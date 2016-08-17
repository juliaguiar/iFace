package br.com.ufal.ic.iface.controller;

import java.awt.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.ufal.ic.iface.dao.CRUDImpl;
import br.com.ufal.ic.iface.model.Friendship;
import br.com.ufal.ic.iface.model.User;

public class SearchController {
	
	private static void addFriends(User userLog, User userAdd) {
		Friendship friendship = new Friendship(userLog, userAdd, "Solicitação de amizade enviada", null);
		
		CRUDImpl crud = new CRUDImpl();

		crud.addFriendship(friendship);

		System.out.println("Solicitação de amizade enviada!");

	}
	
	public static void viewAll(User userLog, String userRequired) {
		
		Scanner reader = new Scanner(System.in);
		
		int op = 0;
		String op2;
		boolean ok = true;
		
		ArrayList<User> noFriends = research(userLog, userRequired);
		
		do {
			System.out.println("\nAdicionar amigos:\n");
			System.out.println(noFriends.size() + " pessoa(s) a adicionar.\n");
			
			if(noFriends.size() != 0) {
				
				int i = 1;
				for (User u : noFriends) {
					System.out.println(i + " - " + u.getName() + " : " + u.getEmail());
					
					i++;
				}
				System.out.println(i + " - Não adicionar");
				
				try {
					op = reader.nextInt(); 
				} catch (InputMismatchException e) {
					System.out.println("Opção inválida. Digite novamente!");
					ok = false;
				}
				reader.nextLine();
				
				if(op != i) {
					if(op >= 1 || op <= i) {
						addFriends(userLog, noFriends.get(op - 1));
					} else {
						if (ok != false){
							System.out.println("Opção inválida. Digite novamente!");
						}
					}
				}
			}
			
			System.out.println("Voltar(S/N)?");
			op2 = reader.next();
			
		} while(op2.toUpperCase().equals("N"));
			
	}

	public static ArrayList<User> research(User userLog, String userRequired) {

		CRUDImpl crud = new CRUDImpl();

		ArrayList<User> usersRequired = crud.getUserByName(userRequired);
		ArrayList<User> noFriends = new ArrayList();

		for (User u : usersRequired) {
		
			Friendship f = crud.getFriendshipByUserForUser(userLog, u);
			
			try {
				System.out.println(u.getName() + ", " + u.getEmail() + " : " + f.getStatus());
			} catch (NullPointerException e) {
				noFriends.add(u);	
			}
			
		}

		return noFriends;

	}

}
