package com.jpmc.enrich.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SSI_Reference")
@Setter
@Getter
@NoArgsConstructor
public class SSIReference {
    @Id
    @Column(name = "SSI_Code")
    private String ssiCode;

    @Column(name="payer_Account_Number")
    private String payerAccountNumber;

    @Column(name="payer_Bank")
    private String payerBank;

    @Column(name="receiver_Account_Number")
    private String receiverAccountNumber;

    @Column(name="receiver_Bank")
    private String receiverBank;

    @Column(name="supporting_Information")
    private String supportingInformation;
}
