package net.local.demo.hexagonal.application.ports.incoming;

public interface WithdrawUseCase {
    void withdraw(Long accountId, float value);
}