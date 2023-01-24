package net.local.demo.hexagonal.infra.repository;

import java.util.Optional;

import net.local.demo.hexagonal.application.domain.entities.Account;
import net.local.demo.hexagonal.application.ports.outgoing.LoadAccountPort;
import net.local.demo.hexagonal.application.ports.outgoing.SaveAccountPort;
import net.local.demo.hexagonal.infra.persistence.mappers.EntityMapper;

public class BankAccountRepository implements LoadAccountPort, SaveAccountPort {
    
    private final BankAccountH2Repository repository;

    public BankAccountRepository(BankAccountH2Repository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Account bankAccount) {
        repository.save(EntityMapper.fromAccount(bankAccount));
    }

    @Override
    public Optional<Account> load(Long id) {
        var accountJPA = repository.findById(id);
        if(accountJPA.isPresent()) {
            return Optional.of(EntityMapper.fromAccountJPA(accountJPA.get()));
        }
        return Optional.empty();
    }
}
