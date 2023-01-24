package net.local.demo.hexagonal.application.ports.incoming;

public interface DepositUseCase {
    void deposit(Long accountId, float value);
}