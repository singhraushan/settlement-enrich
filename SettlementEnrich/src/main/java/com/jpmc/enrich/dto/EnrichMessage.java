package com.jpmc.enrich.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EnrichMessage {

    private String tradeId;
    private String messageId;
    private Double amount;
    private String valueDate;
    private String currency;
    private String payerParty;
    private String receiverParty;
    private String supportingInformation;

    private EnrichMessage(EnrichMessageBuilder builder){
        this.tradeId=builder.tradeId;
        this.messageId=builder.messageId;
        this.amount=builder.amount;
        this.valueDate=builder.valueDate;
        this.currency=builder.currency;
        this.payerParty=builder.payerParty;
        this.receiverParty=builder.receiverParty;
        this.supportingInformation=builder.supportingInformation;
    }

    public static class EnrichMessageBuilder{
        private String tradeId;
        private String messageId;
        private Double amount;
        private String valueDate;
        private String currency;
        private String payerParty;
        private String receiverParty;
        private String supportingInformation;

        public EnrichMessageBuilder(String tradeId,String messageId) {
            this.tradeId = tradeId;
            this.messageId = messageId;
        }

        public EnrichMessageBuilder amount(Double amount) {
            this.amount = amount;
            return this;
        }

        public EnrichMessageBuilder valueDate(String valueDate) {
            this.valueDate = valueDate;
            return this;
        }

        public EnrichMessageBuilder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public EnrichMessageBuilder payerParty(String payerParty) {
            this.payerParty = payerParty;
            return this;
        }

        public EnrichMessageBuilder receiverParty(String receiverParty) {
            this.receiverParty = receiverParty;
            return this;
        }

        public EnrichMessageBuilder supportingInformation(String supportingInformation) {
            this.supportingInformation = supportingInformation;
            return this;
        }

        public EnrichMessage build()
        {
            return new EnrichMessage(this);
        }
    }

}
