package br.com.ufal.ic.iface.view;

import java.util.Scanner;

import br.com.ufal.ic.iface.controller.CommunityController;
import br.com.ufal.ic.iface.model.Community;
import br.com.ufal.ic.iface.model.User;

class MenuCommunity {

	public static void main(User userLog) {

		Scanner reader = new Scanner(System.in);

		String op2;
		int op3;

		do {

			System.out.println("Comunidades");

			System.out.println("1 - Usuário Administrador");
			System.out.println("2 - Usuário Comum");
			System.out.println("3 - Criar comunidade");
			int op = reader.nextInt();

			Community comu;

			if(op == 1) {
				comu = CommunityController.viewAllAdmin(userLog);
				System.out.println("1 - Adicionar membros");
				System.out.println("2 - Ver publicações");
				System.out.println("3 - Publicar");
				op3 = reader.nextInt();
				CommunityController.interactionAdmin(comu, op3);
			} else if(op == 2) {
				comu = CommunityController.viewAllUser(userLog);
				System.out.println("1 - Ver publicações");
				System.out.println("2 - Publicar");
				op3 = reader.nextInt();
				CommunityController.interactionMember(comu, userLog, op3);
			} else {
				System.out.println("Nome da Comunidade:");
				String name = reader.nextLine();
				CommunityController.create(name, userLog);
			}
			System.out.println("Voltar(S/N)?");
			op2 = reader.next();

		} while (op2 == "N");

	}
}