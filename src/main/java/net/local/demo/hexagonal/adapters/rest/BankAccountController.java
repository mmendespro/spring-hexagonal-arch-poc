package net.local.demo.hexagonal.adapters.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.local.demo.hexagonal.application.ports.incoming.CreateAccountUseCase;
import net.local.demo.hexagonal.application.ports.incoming.DepositUseCase;
import net.local.demo.hexagonal.application.ports.incoming.VerifyBalanceUseCase;
import net.local.demo.hexagonal.application.ports.incoming.WithdrawUseCase;

@RestController
@RequestMapping("/v1/accounts")
public class BankAccountController {

    private final DepositUseCase depositUseCase;
    private final WithdrawUseCase withdrawUseCase;
    private final CreateAccountUseCase createAccountUseCase;
    private final VerifyBalanceUseCase verifyBalanceUseCase;

    public BankAccountController(CreateAccountUseCase createAccountUseCase, DepositUseCase depositUseCase, WithdrawUseCase withdrawUseCase, VerifyBalanceUseCase verifyBalanceUseCase) {
        this.createAccountUseCase = createAccountUseCase;
        this.verifyBalanceUseCase = verifyBalanceUseCase;
        this.depositUseCase = depositUseCase;
        this.withdrawUseCase = withdrawUseCase;
    }

    @PostMapping
    public void create(@RequestBody Long accountId, @RequestBody float amount ) {
        createAccountUseCase.create(accountId, amount);
    }

    @PostMapping(value = "/{id}/deposit")
    public void deposit(@PathVariable Long id, @RequestBody float amount) {
        depositUseCase.deposit(id, amount);
    }

    @PostMapping(value = "/{id}/withdraw")
    public void withdraw(@PathVariable Long id, @RequestBody float amount) {
        withdrawUseCase.withdraw(id, amount);
    }

    @GetMapping(value = "/{id}/balance")
    public ResponseEntity<Float> showBalance(@PathVariable Long id) {
        return ResponseEntity.ok(verifyBalanceUseCase.showBalance(id));
    }
}
