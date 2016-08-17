package br.com.ufal.ic.iface.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import br.com.ufal.ic.iface.model.User;

class HomeScreen {

	public static void main(User userLog) {

		Scanner reader = new Scanner(System.in);

		int op = 0;
		boolean ok = true;

		String[] arrayUserLog = userLog.getName().split(" ");

		do {
			System.out.println("Olá, " + arrayUserLog[0] + "\n");
			System.out.println("1 - PERFIL");
			System.out.println("2 - CHAT");
			System.out.println("3 - COMUNIDADES");
			System.out.println("4 - BUSCA");
			System.out.println("5 - SOLICITAÇÕES DE AMIZADE");
			System.out.println("6 - SAIR");
			
			try {
				op = reader.nextInt(); 
			} catch (InputMismatchException e) {
				System.out.println("Opção inválida. Digite novamente!");
				ok = false;
			}
			reader.nextLine();

			switch (op) {
			case 1:
				Profile.main(userLog);
				break;
			case 2:
				Chat.main(userLog);
				break;
			case 3:
				MenuCommunity.main(userLog);
				break;
			case 4:
				Search.main(userLog);
				break;
			case 5:
				Request.main(userLog);
			case 6:
				System.out.println("\nAté breve!\n\n");
				break;
			default:
				if (ok != false){
					System.out.println("Opção inválida. Digite novamente!");
				}
			}
		} while ((op != 6) || (ok == false));

	}
}