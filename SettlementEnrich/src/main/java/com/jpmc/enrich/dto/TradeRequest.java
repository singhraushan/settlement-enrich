package com.jpmc.enrich.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TradeRequest {

    private String tradeId;
    private String ssiCode;
    private Double amount;
    private String currency;
    private String valueDate;

}
