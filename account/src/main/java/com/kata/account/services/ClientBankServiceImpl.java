package com.kata.account.services;

import com.kata.account.AccountApplication;
import com.kata.account.models.Client;
import com.kata.account.models.ClientBankHistoryRepository;
import com.kata.account.models.ClientBankRepository;
import com.kata.account.models.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Service
public class ClientBankServiceImpl implements ClientBankService{
    @Autowired
    private ClientBankRepository clientBankRepository;
    @Autowired
    private ClientBankHistoryRepository clientBankHistoryRepository;

    public ClientBankServiceImpl(){

    }


    @Override
    public void deposit(Long idClient, int amount) {

        Optional<Client> c = clientBankRepository.findById(idClient);
        if( c.isPresent()){
            c.get().setTotalAmount( c.get().getTotalAmount() + amount);
            History h =  new History("+"+amount+" "+ AccountApplication.TiCKER, new Date().getTime(),  c.get().getTotalAmount() );
            clientBankHistoryRepository.save(h);
            c.get().getHistory().add(h);
            clientBankRepository.save(c.get());
            System.out.println("Client: "+idClient+" success deposit: "+amount+" "+AccountApplication.TiCKER );
        }else{
            System.out.println("Client "+idClient+" Not found");
        }


    }

    @Override
    public void withdraw(Long idClient, int amount) {

        Optional<Client> c = clientBankRepository.findById(idClient);
        if( c.isPresent() ){
            if(isClientHasEnoughInTotalAmountInTheirAccount(c.get(),amount)){

                c.get().setTotalAmount( c.get().getTotalAmount() - amount);
                History h =  new History( "-"+amount+" "+ AccountApplication.TiCKER, new Date().getTime(), c.get().getTotalAmount() );
                clientBankHistoryRepository.save(h);
                c.get().getHistory().add(h);
                clientBankRepository.save(c.get());
                System.out.println("Client: "+idClient+" success withdraw: "+amount+" "+AccountApplication.TiCKER );
            }else{
                System.out.println("please credit the account of the client iD : "+c.get().getId()+ "  you can not withdraw : "+amount+" "+AccountApplication.TiCKER+" because you have only "+c.get().getTotalAmount()+" "+AccountApplication.TiCKER+" left");
            }
        }else{
            System.out.println("Client "+idClient+" Not found");
        }


    }

    private boolean isClientHasEnoughInTotalAmountInTheirAccount(Client c,int amountToWithDraw){
        return c.getTotalAmount()>amountToWithDraw;
    }


    @Override
    public Set<History> history(Long idClient) {

        Optional<Client> c = clientBankRepository.findById(idClient);
        if( c.isPresent() ){
            return c.get().getHistory();
        }else{
            System.out.println("Client "+idClient+" Not found");
        }
        return null;
    }


    @Override
    public Client createClient( ) {
        Client c =  new Client();
        this.clientBankRepository.save(c);
        return c;
    }
}
