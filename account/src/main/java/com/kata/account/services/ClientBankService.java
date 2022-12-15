package com.kata.account.services;

import com.kata.account.models.Client;
import com.kata.account.models.History;

import java.util.Set;

public interface ClientBankService {

    /**
     *
     * @param idClient
     * @param amount en centimes
     */
    public void deposit(Long idClient,int amount);

    /**
     *
     * @param idClient
     * @param amount en centimes
     */
    public void withdraw(Long idClient,int amount);

    /**
     * @param idClient
     */
    public Set<History> history(Long idClient);

    /**
     */
    Client createClient();



}
