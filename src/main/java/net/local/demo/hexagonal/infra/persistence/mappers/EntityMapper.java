package net.local.demo.hexagonal.infra.persistence.mappers;

import net.local.demo.hexagonal.application.domain.entities.Account;
import net.local.demo.hexagonal.infra.persistence.entity.AccountJPA;

public class EntityMapper {
    
    public static Account fromAccountJPA(AccountJPA accountJPA) {
        return new Account(accountJPA.getAccountId(), accountJPA.getBalance());
    }

    public static AccountJPA fromAccount(Account account) {
        return new AccountJPA(account.getAccountId(), account.getBalance());
    }
}
