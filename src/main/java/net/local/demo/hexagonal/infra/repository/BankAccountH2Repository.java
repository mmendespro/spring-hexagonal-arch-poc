package net.local.demo.hexagonal.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.local.demo.hexagonal.infra.persistence.entity.AccountJPA;

public interface BankAccountH2Repository extends JpaRepository<AccountJPA, Long> {
}
