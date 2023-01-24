package net.local.demo.hexagonal.application.ports.incoming;

public interface CreateAccountUseCase {
    void create(Long accountId, float balance);
}
