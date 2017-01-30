/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ms.defensoria.comum.mail;

/**
 * 
 * @author Rafael Gouveia da Silva
 * @since JDK7
 * @version 1.0
 * 
 **/
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.eclipse.persistence.internal.oxm.ByteArrayDataSource;

public class MailJavaSender {
	/**
	 * Este método deve ser invocado antes da chamada HTTPS, para servidores que
	 * não possuem certificado SSL o método responsável por dar um bypass
	 * nessa validação.
	 */
	public static void acceptSSL() {
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
			}
		} };
		try {
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// cria as propriedades necessárias para o envio de email
	public void senderMail(final MailJava mail) throws UnsupportedEncodingException, MessagingException {
		acceptSSL();
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", mail.getSmtpHostMail());
		props.setProperty("mail.smtp.auth", mail.getSmtpAuth());
		props.setProperty("mail.smtp.starttls.enable", mail.getSmtpStarttls());
		props.setProperty("mail.smtp.port", mail.getSmtpPortMail());
		props.setProperty("mail.mime.charset", mail.getCharsetMail());
		// classe anonima que realiza a autenticação
		// do usuario no servidor de email.
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mail.getUserMail(), mail.getPassMail());
			}
		};
		// Cria a sessao passando as propriedades e a autenticação
		Session session = Session.getInstance(props, auth);
		// Gera um log no console referente ao processo de envio
		session.setDebug(true);
		// cria a mensagem setando o remetente e seus destinatários
		Message msg = new MimeMessage(session);
		// aqui seta o remetente
		msg.setFrom(new InternetAddress(mail.getUserMail(), mail.getFromNameMail()));
		boolean first = true;
		for (Map.Entry<String, String> map : mail.getToMailsUsers().entrySet()) {
			if (first) {
				// seta o 1° destinatario
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(map.getKey(), map.getValue()));
				first = false;
			} else {
				// seta os demais destinatarios com c�pia e c�pia oculta
				msg.addRecipient(Message.RecipientType.CC, new InternetAddress(map.getKey(), map.getValue()));
			}
		}
		// Adiciona um Assunto a Mensagem
		msg.setSubject(mail.getSubjectMail());
		// Cria o objeto que recebe o texto do corpo do email
		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setContent(mail.getBodyMail(), mail.getTypeTextMail());
		// Monta a mensagem SMTP inserindo o conteudo, texto e anexos
		Multipart mps = new MimeMultipart();
		for (int index = 0; index < mail.getFileMails().size(); index++) {
			// Cria um novo objeto para cada arquivo, e anexa o arquivo
			MimeBodyPart attachFilePart = new MimeBodyPart();
			FileDataSource fds = new FileDataSource(mail.getFileMails().get(index));
			attachFilePart.setDataHandler(new DataHandler(fds));
			attachFilePart.setFileName(fds.getName());
			// adiciona os anexos da mensagem
			mps.addBodyPart(attachFilePart, index);
		}
		// inserindo anexo por byte se houver
		if (mail.getBytes() != null) {

			DataSource dataSource = new ByteArrayDataSource(mail.getBytes(), mail.getTypeBytesFile());
			MimeBodyPart pdfBodyPart = new MimeBodyPart();
			pdfBodyPart.setDataHandler(new DataHandler(dataSource));
			pdfBodyPart.setFileName(mail.getNameBytesFile());
			mps.addBodyPart(pdfBodyPart);
		}
		// adiciona o corpo texto da mensagem
		mps.addBodyPart(textPart);
		// adiciona a mensagem o conteúdo texto e anexo
		msg.setContent(mps);
		// Envia a Mensagem
		Transport.send(msg);
	}
}
