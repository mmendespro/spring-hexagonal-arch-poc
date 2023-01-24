package net.local.demo.hexagonal.application.domain.exceptions;

public class AccountHasNoFundsException extends RuntimeException {
    
    public AccountHasNoFundsException() {
        super("This account has no funds for this operation.");
    }
}
