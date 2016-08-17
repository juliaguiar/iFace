package br.com.ufal.ic.iface.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import br.com.ufal.ic.iface.controller.UserController;
import br.com.ufal.ic.iface.exception.EmailValidatorException;
import br.com.ufal.ic.iface.model.User;

public class Login {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		User user = null;
		int op = 0;
		boolean ok2;
		boolean ok = ok2 = true;
		String op2 = "S";

		do {
				
				System.out.println("1 - LOGIN");
				System.out.println("2 - CADASTRO");
					
				try {
					op = reader.nextInt(); 
				} catch (InputMismatchException e) {
					System.out.println("Opção inválida. Digite novamente!");
					ok = false;
				}
				reader.nextLine();
	
				if (op == 1) {
					String email;
					boolean ok3 = false;
					do {
									
						System.out.println("\nSeja bem-vindo ao iFace!");
						do {
							ok2 = true;
							System.out.println("\nE-mail:");
							email = reader.nextLine();
							try {
								EmailValidatorException.validate(email);
							} catch (EmailValidatorException e) {
								System.out.println(e.getMessage());
								ok2 = false;
							}
						} while(ok2 == false);
						System.out.println("\nSenha:");
						String password = reader.nextLine();
	
						user = UserController.search(email);
						ok3 = UserController.validate(user, password);
						
					} while (!ok3);
	
				} else if (op == 2) {
	
					user = UserController.register();
	
				} else if (ok != false){
					System.out.println("Opção inválida. Digite novamente!");
				}

			try {
				HomeScreen.main(user);
			} catch (NullPointerException e) {
				System.out.println("Retornar(S/N)?");
				op2 = reader.nextLine();
			}
			
		} while(op2.toUpperCase().equals("S"));
	}
}