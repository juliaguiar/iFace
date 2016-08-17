package br.com.ufal.ic.iface.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.ufal.ic.iface.dao.CRUDImpl;
import br.com.ufal.ic.iface.model.Comment;
import br.com.ufal.ic.iface.model.Community;
import br.com.ufal.ic.iface.model.Postage;
import br.com.ufal.ic.iface.model.User;

public class CommunityController {

	public static Community viewAllAdmin(User userLog) {

		Scanner reader = new Scanner(System.in);
		CRUDImpl crud = new CRUDImpl();

		ArrayList<Community> communities = crud.getCommunityByAdmin(userLog);

		int i = 1;
		for (Community c : communities) {
			System.out.println(i + " - " + c.getName());

			i++;
		}
		int op = reader.nextInt();

		return communities.get(op - 1);
	}

	public static Community viewAllUser(User userLog) {
		Scanner reader = new Scanner(System.in);
		CRUDImpl crud = new CRUDImpl();

		List<Community> communities = crud.getCommunity_UserByMembers(userLog);

		int i = 1;
		for (Community c : communities) {
			System.out.println(i + " - " + c.getName());

			i++;
		}
		int op = reader.nextInt();

		return communities.get(op - 1);
	}

	private static void addMembers(Community comu, ArrayList<User> usersRequired, ArrayList<Integer> ops) {

		ArrayList<User> usersAdd = new ArrayList();

		for (Integer i : ops) {
			int j = (int) i;
			usersAdd.add(usersRequired.get(j));
		}

		comu.setMembers(usersAdd);

		CRUDImpl crud = new CRUDImpl();

		crud.updateCommunity(comu);

		System.out.println("Usuários adicionados!");

	}

	public static void seePublication(Community comu, User user) {

		List<Postage> posts = comu.getPosts();

		CRUDImpl crud = new CRUDImpl();
		Scanner reader = new Scanner(System.in);

		String op;

		do {
			int i = 1;
			for (Postage p : posts) {
				System.out.println(i + ":");
				p.show();
				System.out.println("");
			}
			int op2 = reader.nextInt();

			System.out.println("Comentar(S/N)?");
			op = reader.next();

			if (op.toUpperCase().equals("S")) {
				System.out.println("Comentário:");
				String text = reader.next();

				ArrayList<Comment> comments = new ArrayList();
				Comment comment = new Comment(user, text);
				comments.add(comment);
				posts.get(op2 - 1).setComments(comments);

				crud.updatePostage(posts.get(op2 - 1));
			}

		} while (op.toUpperCase().equals("S"));

	}

	public static void publish(Community comu, User user) {
		CRUDImpl crud = new CRUDImpl();
		Scanner reader = new Scanner(System.in);

		ArrayList<Postage> posts = new ArrayList();

		String op;

		do {
			System.out.println("Publicação:");
			String text = reader.nextLine();

			Postage postage = new Postage(user, text, null);
			posts.add(postage);

			System.out.println("Voltar(S/N)?");
			op = reader.next();

		} while (op.toUpperCase().equals("N"));

		comu.setPosts(posts);

		crud.updateCommunity(comu);

	}

	public static void interactionAdmin(Community comu, int op) {

		CRUDImpl crud = new CRUDImpl();
		Scanner reader = new Scanner(System.in);

		if (op == 1) {
			System.out.println("Usuário:");
			String userRequired = reader.nextLine();

			ArrayList<User> usersRequired = crud.getUserByName(userRequired);
			ArrayList<Integer> options = new ArrayList();
			String op3;

			do {
				System.out.println(usersRequired.size() + " pessoa(s) encontrada(s).\n");

				if (usersRequired.size() != 0) {

					int i = 1;
					for (User u : usersRequired) {
						System.out.println(i + " - " + u.getName() + " : " + u.getEmail());

						i++;
					}
					System.out.println(i + " - Não adicionar");

					int op2 = reader.nextInt();

					if (op2 != i) {
						options.add(op2 - 1);
					}
				}

				System.out.println("Voltar(S/N)?");
				op3 = reader.next();

			} while (op3.toUpperCase().equals("N"));

			addMembers(comu, usersRequired, options);

		} else if (op == 2) {

			seePublication(comu, comu.getAdmin());

		} else {
			publish(comu, comu.getAdmin());
		}

	}

	public static void interactionMember(Community comu, User userLog, int op) {

		if (op == 1) {

			seePublication(comu, userLog);

		} else {
			publish(comu, userLog);
		}

	}
	
	public static void create(String name, User userLog) {
		Community community = new Community(name, userLog, null, null);
		
		CRUDImpl crud = new CRUDImpl();
		
		crud.addInstance(community);
		
		System.out.println("Comunidade adicionada com sucesso.");
	}

}
