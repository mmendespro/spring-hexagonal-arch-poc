package net.local.demo.hexagonal.application.domain.entities;

import net.local.demo.hexagonal.application.domain.exceptions.AccountHasNoFundsException;
import net.local.demo.hexagonal.application.domain.valueObjects.Money;

public class Account {

    private Long accountId;
    private Money balance;
    
    public Account(Long accountId, float balance) {
        this.accountId = accountId;
        this.balance = new Money(balance);
    }

    public Long getAccountId() {
        return accountId;
    }

    public float getBalance() {
        return balance.getValue();
    }

    public void withdraw(float value) {
        if(!hasFund(value)) {
            throw new AccountHasNoFundsException();
        }
        balance.decrease(value);
    }

    public void deposit(float value) {
        balance.increase(value);
    }

    private boolean hasFund(float value) {
        return getBalance() >= value;
    }
}
