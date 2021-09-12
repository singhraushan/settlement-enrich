package com.jpmc.enrich.ctrl;

import com.jpmc.enrich.exception.CustomException;
import com.jpmc.enrich.model.MarketSettlementMsg;
import com.jpmc.enrich.dto.TradeRequest;
import com.jpmc.enrich.service.SettlementEnrichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SettlementEnrichController {

    @Autowired
    private SettlementEnrichService settlementEnrichService;

    @PostMapping("/create")
    public ResponseEntity<MarketSettlementMsg> createSettlementMsg(@RequestBody TradeRequest tradeRequest) throws CustomException {
        return ResponseEntity.ok(settlementEnrichService.createSettlementMsg(tradeRequest));
    }

    @GetMapping("/fetch")
    public ResponseEntity<MarketSettlementMsg> fetchSettlementMsg(@RequestParam("tradeId") String tradeId) throws CustomException {
         return ResponseEntity.ok(settlementEnrichService.getSettlementMsg(tradeId));
    }

}
