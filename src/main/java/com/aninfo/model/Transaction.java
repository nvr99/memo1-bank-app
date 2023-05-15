package com.aninfo.model;

import javax.persistence.*;
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private Long cbu;
    private Double amount;
    private String transactionType;

    public Transaction(){
    }
    public Transaction(Double amount) {this.amount = amount; }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getCbu() { return cbu; }

    public void setCbu(Long cbu) { this.cbu = cbu; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) {this.amount = amount; }

    public String getTransactionType() { return transactionType; }

    public void setTransactionType(String transactionType) { this.transactionType = transactionType; }

}
