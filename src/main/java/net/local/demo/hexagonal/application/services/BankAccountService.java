package net.local.demo.hexagonal.application.services;

import java.util.NoSuchElementException;

import net.local.demo.hexagonal.application.domain.entities.Account;
import net.local.demo.hexagonal.application.ports.incoming.CreateAccountUseCase;
import net.local.demo.hexagonal.application.ports.incoming.DepositUseCase;
import net.local.demo.hexagonal.application.ports.incoming.VerifyBalanceUseCase;
import net.local.demo.hexagonal.application.ports.incoming.WithdrawUseCase;
import net.local.demo.hexagonal.application.ports.outgoing.LoadAccountPort;
import net.local.demo.hexagonal.application.ports.outgoing.SaveAccountPort;

public class BankAccountService implements CreateAccountUseCase, DepositUseCase, WithdrawUseCase, VerifyBalanceUseCase {
    
    private final LoadAccountPort loadAccountPort;
    private final SaveAccountPort saveAccountPort;

    public BankAccountService(LoadAccountPort loadAccountPort, SaveAccountPort saveAccountPort) {
        this.loadAccountPort = loadAccountPort;
        this.saveAccountPort = saveAccountPort;
    }

    @Override
    public void create(Long accountId, float amount) {
        saveAccountPort.save(new Account(accountId, amount));
    }

    @Override
    public void withdraw(Long accountId, float amount) {
        Account account = loadAccountPort.load(accountId).orElseThrow(NoSuchElementException::new);
        account.withdraw(amount);
        saveAccountPort.save(account);
    }

    @Override
    public void deposit(Long accountId, float amount) {
        Account account = loadAccountPort.load(accountId).orElseThrow(NoSuchElementException::new);
        account.deposit(amount);
        saveAccountPort.save(account);      
    }

    @Override
    public float showBalance(Long id) {
        Account account = loadAccountPort.load(id).orElseThrow(NoSuchElementException::new);
        return account.getBalance();
    }
}
