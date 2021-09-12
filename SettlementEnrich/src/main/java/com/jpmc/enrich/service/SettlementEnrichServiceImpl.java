package com.jpmc.enrich.service;

import com.jpmc.enrich.dto.EnrichMessage;
import com.jpmc.enrich.exception.CustomException;
import com.jpmc.enrich.model.MarketSettlementMsg;
import com.jpmc.enrich.model.SSIReference;
import com.jpmc.enrich.repo.MarketSettlementMsgRepository;
import com.jpmc.enrich.repo.SSIReferenceRepository;
import com.jpmc.enrich.dto.TradeRequest;
import com.jpmc.enrich.util.EnrichUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class SettlementEnrichServiceImpl implements SettlementEnrichService {

    @Autowired
    SSIReferenceRepository ssiReferenceRepository;

    @Autowired
    MarketSettlementMsgRepository marketSettlementMsgRepository;

    @Override
    public MarketSettlementMsg getSettlementMsg(String tradeId) throws CustomException {
        MarketSettlementMsg res = marketSettlementMsgRepository.getOne(tradeId);
        if(Objects.isNull(res)){
            throw new CustomException("Existing Market Settlement Message not available for tradeId:"+tradeId, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return res;
    }

    @Override
    public MarketSettlementMsg createSettlementMsg(TradeRequest tradeRequest) throws CustomException {
        Optional<SSIReference> ssiReference = ssiReferenceRepository.findById(tradeRequest.getSsiCode());
        if(!ssiReference.isPresent()){
           throw new CustomException("SSIReference not available for SsiCode:"+tradeRequest.getSsiCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        MarketSettlementMsg enriched = getMarketSettlementMsg(enrich( tradeRequest, ssiReference.get()));
        marketSettlementMsgRepository.save(enriched);
        return enriched;
    }

    public EnrichMessage enrich(TradeRequest tradeRequest, SSIReference ssiReference) throws CustomException {

        return new EnrichMessage.EnrichMessageBuilder(tradeRequest.getTradeId(), UUID.randomUUID().toString())
                .amount(tradeRequest.getAmount())
                .valueDate(tradeRequest.getValueDate())
                .currency(tradeRequest.getCurrency())
                .payerParty(EnrichUtility.BANK_PARTY.apply(ssiReference.getPayerAccountNumber(),ssiReference.getPayerBank()))
                .receiverParty(EnrichUtility.BANK_PARTY.apply(ssiReference.getReceiverAccountNumber(),ssiReference.getReceiverBank()))
                .supportingInformation(EnrichUtility.SUPP_INFO.apply(ssiReference.getSupportingInformation()) )
                .build();
    }


    public MarketSettlementMsg getMarketSettlementMsg(EnrichMessage enrichedMessage) {
        MarketSettlementMsg obj = new MarketSettlementMsg();
        obj.setTradeId(enrichedMessage.getTradeId());
        obj.setMessageId(enrichedMessage.getMessageId());
        obj.setAmount(enrichedMessage.getAmount());
        obj.setValueDate(enrichedMessage.getValueDate());
        obj.setCurrency(enrichedMessage.getCurrency());
        obj.setPayerParty(enrichedMessage.getPayerParty());
        obj.setReceiverParty(enrichedMessage.getReceiverParty());
        obj.setSupportingInformation(enrichedMessage.getSupportingInformation());
        return obj;
    }

}
