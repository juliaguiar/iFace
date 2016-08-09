package br.com.ufal.ic.iface.view;

import java.util.Scanner;

import br.com.ufal.ic.iface.controller.ChatController;
import br.com.ufal.ic.iface.model.User;

class Chat {
	public static void main(User userLog) {
		// ChatController chatController = new ChatController();

		System.out.println("MENSAGENS");

		ChatController.viewAll(userLog);
			// chat controller vai mostrar opcoes de conversa chamando outra
			// funcao sua para usuario interagir

	}
}