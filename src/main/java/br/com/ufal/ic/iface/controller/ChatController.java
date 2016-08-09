package br.com.ufal.ic.iface.controller;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.ufal.ic.iface.dao.CRUDImpl;
import br.com.ufal.ic.iface.model.Friendship;
import br.com.ufal.ic.iface.model.User;

public class ChatController {

	public static void sendMessage(Friendship conversation, User userSender) {

		Scanner reader = new Scanner(System.in);

		String op;
		String[] arrayUserSender = userSender.getName().split(" ");

		do {
			System.out.println(conversation.getMessage());

			String op2;

			do {
				System.out.println("Messagem:");
				String message = reader.nextLine();

				System.out.println("Enviar(S/N)?");
				op2 = reader.nextLine();
				
				if(op2.toUpperCase().equals("S")) {
					conversation.setMessage(message, arrayUserSender[0]);
					
					if(conversation.getStatus().equals("Amigos")){
						conversation.setStatus("Melhores Amigos");	
					}
				}
				
			} while (op2.toUpperCase().equals("N"));

			System.out.println("Voltar(S/N)?");
			op = reader.nextLine();

		} while (op.toUpperCase().equals("N"));
		
		CRUDImpl crud = new CRUDImpl();
		
		crud.updateFriendship(conversation);

	}

	public static ArrayList<Friendship> searchForUser1(User userLog, String status) {
		CRUDImpl crud = new CRUDImpl();
		
		ArrayList<Friendship> f = crud.getFriendshipByUser1AndStatus(userLog, status);
		
		return f;
	}
	
	public static ArrayList<Friendship> searchForUser2(User userLog, String status) {
		CRUDImpl crud = new CRUDImpl();
		
		ArrayList<Friendship> f = crud.getFriendshipByUser2AndStatus(userLog, status);
		
		return f;
	}

	public static void viewAll(User userLog) {

		Scanner reader = new Scanner(System.in);
		ArrayList<Friendship> conversations1 = new ArrayList();
		ArrayList<Friendship> conversations2 = new ArrayList();
		
		int op;
		
		do {
			System.out.println("1 - Conversas Antigas");
			System.out.println("2 - Novas Conversas");
			System.out.println("3 - Voltar");
			op = reader.nextInt();
			
			if(op != 3) {
				
				if(op == 1) {
					conversations1 = searchForUser1(userLog, "Melhores Amigos");
					conversations2 = searchForUser2(userLog, "Melhores Amigos");
				} else 
					if(op == 2) {
					conversations1 = searchForUser1(userLog, "Amigos");
					conversations2 = searchForUser2(userLog, "Amigos");
				} 
				
				int i = 1;
				for (Friendship c : conversations1) {
					System.out.println(i + " - " + c.getUser2().getName() + " : " + c.getUser2().getEmail());
					//System.out.println(c);

					i++;
				}
				for (Friendship c : conversations2) {

					System.out.println(i + " - " + c.getUser1().getName() + " : " + c.getUser1().getEmail());
					//System.out.println(c);

					i++;
				}
				int op2 = reader.nextInt();

				if(op2 <= conversations1.size())
					sendMessage(conversations1.get(op2 - 1), userLog);
				else
					sendMessage(conversations2.get(op2 - 1), userLog);
				
			}
			
		} while(op != 3);
		

	}
}