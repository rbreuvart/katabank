package com.kata.account;

import com.kata.account.controllers.ClientBankController;
import com.kata.account.controllers.ClientBankControllerImpl;
import com.kata.account.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AccountApplication {

	public static String TiCKER = "€";

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(AccountApplication.class, args);

		ClientBankController clientBankControllerController = ctx.getBean(ClientBankControllerImpl.class);



		System.out.println("------------------Remi Bank Hello Test-----------------------");
		//Creation Client
		Client remi = clientBankControllerController.createClient();


		//Deposit
		clientBankControllerController.deposit(remi.getId(),600);
		clientBankControllerController.deposit(remi.getId(),600);

		//withdraw
		clientBankControllerController.withdraw(remi.getId(),500);
		clientBankControllerController.withdraw(remi.getId(),500);

		//history 1
		clientBankControllerController.history(remi.getId());

		/// Test withdraw
		clientBankControllerController.withdraw(remi.getId(),500);


		//history 2
		clientBankControllerController.history(remi.getId());

	}

}
