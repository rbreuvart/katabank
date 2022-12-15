package com.kata.account.controllers;

import com.kata.account.models.Client;
import com.kata.account.models.ClientBankRepository;
import com.kata.account.services.ClientBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller()
public class ClientBankControllerImpl implements ClientBankController {

    @Autowired
    private ClientBankService clientBankService;


    public ClientBankControllerImpl() {

    }

    @Override
    public void deposit(Long idClient,int amount){
        if(idClient==null){
            System.out.println("idClient not defined");
            return ;
        }
        if(amount>=0){
            clientBankService.deposit(idClient,amount);
        }else{
            System.out.println("use withdraw to instead");
        }
    }
    @Override
    public void withdraw(Long idClient,int amount){
        if(idClient==null){
            System.out.println("idClient not defined");
            return ;
        }
        if(amount>=0){
            clientBankService.withdraw(idClient,amount);
        }else{
            System.out.println("use deposit to instead");
        }
    }
    @Override
    public void history(Long idClient){
        if(idClient==null){
            System.out.println("idClient not defined");
            return ;
        }
        System.out.println("------ History ------");
        clientBankService.history(idClient).stream().sorted((h1,h2)-> h1.getTimestamp().compareTo(h2.getTimestamp())  ).forEach((history)->{
            System.out.println("Client: "+idClient+" Date: "+history.getTimestamp()+" "+history.getAmountChange()+" Balance: "+history.getCurrentBalance());
        });
        System.out.println("---------------------");
    }

    @Override
    public Client createClient() {
        return  this.clientBankService.createClient();

    }
}
