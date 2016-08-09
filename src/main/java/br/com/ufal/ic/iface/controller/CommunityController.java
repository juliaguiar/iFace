package br.com.ufal.ic.iface.controller;

import java.util.ArrayList;


import br.com.ufal.ic.iface.dao.CRUDImpl;
import br.com.ufal.ic.iface.model.Comment;
import br.com.ufal.ic.iface.model.Community;
import br.com.ufal.ic.iface.model.Postage;
import br.com.ufal.ic.iface.model.User;

public class CommunityController {

	public static void viewAllAdmin(User userLog) {
		CRUDImpl crud = new CRUDImpl();
		
		Community comu = new Community();
		
		crud.addPostage(comu);
	}
	
}
