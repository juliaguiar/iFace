package br.com.ufal.ic.iface.view;

import java.util.Scanner;

import br.com.ufal.ic.iface.controller.CommunityController;
import br.com.ufal.ic.iface.model.User;

class MenuCommunity {

  public static void main(User userLog) {
  
    Scanner leitor = new Scanner(System.in);
    CommunityController comuController = new CommunityController();
    
    String op;
    
    do {
    
      System.out.println("Comunidades"); 
      
      System.out.println("Administrador");
      comuController.viewAllAdmin(userLog);
      //separar entre comunidades de admin e usuario comum
    
      System.out.println("Voltar(S/N)?"); 
      op = leitor.next();
    
    } while(op == "N");
  
  }
}