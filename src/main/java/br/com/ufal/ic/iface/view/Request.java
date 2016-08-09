package br.com.ufal.ic.iface.view;

import br.com.ufal.ic.iface.controller.RequestController;
import br.com.ufal.ic.iface.model.User;

class Request {

	public static void main(User userLog) {
		
		System.out.println("Solicitações de Amizade:\n");
		
		RequestController.viewAll(userLog);
	}
	
}
