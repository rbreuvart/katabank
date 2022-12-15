package com.kata.account.controllers;

import com.kata.account.models.Client;

public interface ClientBankController {
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
     *
     * @param idClient
     */
    public void history(Long idClient);

    /**
     *
     */
    Client createClient();
}
