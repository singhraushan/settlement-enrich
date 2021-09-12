package com.jpmc.enrich.service;

import com.jpmc.enrich.exception.CustomException;
import com.jpmc.enrich.model.MarketSettlementMsg;
import com.jpmc.enrich.dto.TradeRequest;

public interface SettlementEnrichService {
    MarketSettlementMsg getSettlementMsg(String tradeId) throws CustomException;
    MarketSettlementMsg createSettlementMsg(TradeRequest tradeRequest) throws CustomException;
}
