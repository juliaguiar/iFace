package br.com.ufal.ic.iface.view;

import java.util.Scanner;

import br.com.ufal.ic.iface.controller.ChatController;
import br.com.ufal.ic.iface.model.User;

class Chat {
	public static void main(User userLog) {

		System.out.println("MENSAGENS");

		ChatController.viewAll(userLog);

	}
}