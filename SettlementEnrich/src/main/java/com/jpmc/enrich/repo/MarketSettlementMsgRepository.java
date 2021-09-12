package com.jpmc.enrich.repo;

import com.jpmc.enrich.model.MarketSettlementMsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketSettlementMsgRepository extends JpaRepository<MarketSettlementMsg,String> {
}
