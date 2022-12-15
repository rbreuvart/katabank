package com.kata.account.models;

import org.springframework.data.repository.CrudRepository;

public interface ClientBankRepository extends CrudRepository<Client, Long> {
}
