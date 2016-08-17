package br.com.ufal.ic.iface.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidatorException extends Exception {
	EmailValidatorException(String message) {
		super(message);
	}
	
	public static void validate(String email) throws EmailValidatorException {
		boolean v;
		
		if ((email == null) || (email.trim().length() == 0))
            v = false;

        String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
        Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        v =  matcher.matches();
        
        if (!v){
        	throw new EmailValidatorException("E-mail inválido," +
        			"tente novamente");
        }
	}
}
