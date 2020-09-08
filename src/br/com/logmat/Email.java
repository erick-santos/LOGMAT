package br.com.logmat;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

public class Email {
//commons-email-1.5.jar
//mail-1.4.7.jar

	String meuEmail = "materiaislogsr@gmail.com";
	String minhaSenha = "MSERLLC19";

	public void mandarEmail(String titulo, String msg, String emailTo) {
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
		email.setSSLOnConnect(true);

		try {
			email.setFrom(meuEmail);
			email.setSubject(titulo);
			email.setMsg(msg);
			email.addTo(emailTo);
			email.send();
			System.out.println("o email foi enviado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
