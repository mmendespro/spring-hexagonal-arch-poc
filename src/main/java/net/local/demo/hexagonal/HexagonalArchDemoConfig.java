package net.local.demo.hexagonal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.local.demo.hexagonal.application.services.BankAccountService;
import net.local.demo.hexagonal.infra.repository.BankAccountH2Repository;
import net.local.demo.hexagonal.infra.repository.BankAccountRepository;

@Configuration
public class HexagonalArchDemoConfig {
    
    @Bean
    public BankAccountRepository bankAccountRepository(BankAccountH2Repository repo) {
        return new BankAccountRepository(repo);
    }

    @Bean
    public BankAccountService bankAccountService(BankAccountRepository repository) {
        return new BankAccountService(repository, repository);
    }
}
