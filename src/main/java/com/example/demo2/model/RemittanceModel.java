package com.example.demo2.model;

import java.math.BigInteger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;


public class RemittanceModel {

    @NotNull
    @Size(min=16, max=16)
    @Pattern(regexp = "\\d+")
    private String remitter;

    @NotNull
    @Size(min=16, max=16)
    @Pattern(regexp = "\\d+")
    private String recipient;

    @NotNull
    @Min(1)
    private BigInteger amount;

    public String getRemitter() {
        return remitter;
    }

    public void setRemitter(String remitter) {
        this.remitter = remitter;
    }

    public String getRecipient() {
        return recipient;
    }


    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }
}
