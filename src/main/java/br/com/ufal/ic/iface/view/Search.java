package br.com.ufal.ic.iface.view;

import java.util.Scanner;
import br.com.ufal.ic.iface.controller.SearchController;
import br.com.ufal.ic.iface.dao.CRUDImpl;
import br.com.ufal.ic.iface.model.Friendship;
import br.com.ufal.ic.iface.model.User;

class Search {

	public static void main(User userLog) {

		Scanner leitor = new Scanner(System.in);
		SearchController searchController = new SearchController();

		String op;

		do {
			
			System.out.println("Busca por Usuários:");
			String userRequired = leitor.nextLine();
			
			searchController.viewAll(userLog, userRequired);
			//searchController.research(userLog, userRequired);

			System.out.println("Voltar(S/N)?");
			op = leitor.next();

		} while (op == "N");

	}

}