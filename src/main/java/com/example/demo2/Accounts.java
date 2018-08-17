package com.example.demo2;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.Objects;

@Entity
public class Accounts {
    private String name;
    private String surname;
    private BigInteger amount;
    private Long accountNumber;
    private int id;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "amount")
    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "account_number")
    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts accounts = (Accounts) o;
        return id == accounts.id &&
                Objects.equals(name, accounts.name) &&
                Objects.equals(surname, accounts.surname) &&
                Objects.equals(amount, accounts.amount) &&
                Objects.equals(accountNumber, accounts.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, amount, accountNumber, id);
    }
}
