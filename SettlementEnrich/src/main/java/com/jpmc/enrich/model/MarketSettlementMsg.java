package com.jpmc.enrich.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Market_Settlement_Message")
@Setter
@Getter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MarketSettlementMsg {
    @Id
    private String tradeId;
    private String messageId;
    private Double amount;
    private String valueDate;
    private String currency;
    @JsonIgnore
    private String payerParty;
    @JsonIgnore
    private String receiverParty;
    private String supportingInformation;
}
