package br.com.ufal.ic.iface.view;

import java.util.Scanner;

import br.com.ufal.ic.iface.controller.UserController;
import br.com.ufal.ic.iface.model.User;

class Profile {

	public static void main(User userLog) {

		Scanner reader = new Scanner(System.in);

		String op;

		do {

			System.out.println("Nome: " + userLog.getName());
			System.out.println("E-mail: " + userLog.getEmail());

			System.out.println("Editar(S/N)?");
			String op2 = reader.next();

			if (op2.toUpperCase().equals("S")) {
				UserController.edit(userLog);
			}

			System.out.println("Voltar(S/N)?");
			op = reader.next();

		} while (op.toUpperCase().equals("N"));

	}
}