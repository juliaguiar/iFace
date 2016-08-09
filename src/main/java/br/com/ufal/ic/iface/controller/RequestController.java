package br.com.ufal.ic.iface.controller;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.ufal.ic.iface.dao.CRUDImpl;
import br.com.ufal.ic.iface.model.Friendship;
import br.com.ufal.ic.iface.model.User;

public class RequestController {
	
	public static void acceptFriends(Friendship f) {
		
		CRUDImpl crud = new CRUDImpl();
		
		f.setStatus("Amigos");
		
		crud.updateFriendship(f);
		
	}
	
	public static ArrayList<Friendship> research(User userLog) {
		
		CRUDImpl crud = new CRUDImpl();
		ArrayList<Friendship> noFriends = crud.getFriendshipByUser2AndStatus(userLog, "Solicitação de amizade enviada");
		
		return noFriends;
	}
	
	public static void viewAll(User userLog) {
		
		Scanner reader = new Scanner(System.in);
		
		String op2;
		
		do {
			ArrayList<Friendship> noFriends = research(userLog);
			
			System.out.println(noFriends.size() + " solicitação(ões).\n");
			
			if(noFriends.size() != 0) {
				
				int i = 1;
				for (Friendship f : noFriends) {
					System.out.println(i + " - " + f.getUser1().getName() + " : " + f.getUser1().getEmail());
					
					i++;
				}
				System.out.println(i + " - Não aceitar ninguém.");
				
				int op = reader.nextInt();
				
				if(op != i) {
					acceptFriends(noFriends.get(op - 1));
				}
			}
			
			System.out.println("Voltar(S/N)?");
			op2 = reader.next();
			
		} while(op2.toUpperCase().equals("N"));
		
	}
}
