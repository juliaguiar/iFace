package br.com.ufal.ic.iface.view;

import java.util.Scanner;
import br.com.ufal.ic.iface.controller.UserController;
import br.com.ufal.ic.iface.model.User;

public class Login {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		User user = null;

		while (true) {
			System.out.println("1 - LOGIN");
			System.out.println("2 - CADASTRO");
			int op = reader.nextInt();

			if (op == 1) {

				boolean ok;
				do {
					System.out.println("\nSeja bem-vindo ao iFace!");
					System.out.println("\nE-mail:");
					String email = reader.next();
					System.out.println("\nSenha:");
					String password = reader.next();

					user = UserController.search(email);
					ok = UserController.validate(user, password);
					
				} while (!ok);

			} else if (op == 2) {

				user = UserController.register();

			} else {
				System.out.println("Opção errada. Digite novamente!");
			}

			HomeScreen.main(user);
		}
	}
}