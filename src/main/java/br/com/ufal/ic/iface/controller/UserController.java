package br.com.ufal.ic.iface.controller;

import java.util.Scanner;


import javax.persistence.NonUniqueResultException;

import br.com.ufal.ic.iface.dao.CRUDImpl;
import br.com.ufal.ic.iface.model.User;

public class UserController {

	// static CRUDImpl crud = new CRUDImpl();

	public static User register() {

		Scanner reader = new Scanner(System.in);

		System.out.println("Nome:");
		String name = reader.nextLine();
		System.out.println("E-mail:");
		String email = reader.next(); // validar e-mail
		System.out.println("Senha:");
		String password = reader.next();

		User user = new User(email, password, name, null);

		CRUDImpl crud = new CRUDImpl();

		crud.addUser(user);

		System.out.println("Usu·rio cadastrado com sucesso");
		// tratar a excessao caso n√£o consiga cadastrar

		return user;
	}

	public static boolean validate(User user, String password) {
		String pass;

		try {
			pass = user.getPassword();
		} catch (NullPointerException e) {
			System.out.println("E-mail n„o cadastrado.");
			return false;
		}

		if (!pass.equals(password)) {
			System.out.println("Senha incorreta!");
			return false;
		}

		return true;

	}

	public static User search(String email) {

		// User userLog = User.authenticate(email, password);
		// exception caso tenha problema com banco

		CRUDImpl crud = new CRUDImpl();

		User user = crud.getUserByEmail(email);

		// caso n„o exista no banco
		/*
		 * if(userLog.getName().isEmpty()) { System.out.println("Erro"); } else
		 * { System.out.println("OK"); }
		 */

		return user;

	}

	public static void edit(User userLog) {

		Scanner reader = new Scanner(System.in);

		System.out.println("Nome:");
		String name = reader.nextLine();
		System.out.println("E-mail:");
		String email = reader.next();
		System.out.println("Senha:");
		String password = reader.next();

		userLog.edit(name, email, password);

		CRUDImpl crud = new CRUDImpl();

		crud.updateUser(userLog);

	}
}