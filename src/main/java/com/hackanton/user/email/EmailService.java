package com.hackanton.user.email;

import com.hackanton.event.Event;
import com.hackanton.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;

@Service
public class EmailService {

	private static final String SENDER_ADDRESS = "hg.hackathon@gmail.com";

	private final JavaMailSender mailSender;
	private final TemplateEngine templateEngine;

	@Autowired
	public EmailService(JavaMailSender mailSender, TemplateEngine templateEngine) {
		this.mailSender = mailSender;
		this.templateEngine = templateEngine;
	}

	public void sendEmail(String emailAddress, String subject, String htmlBody) {
		MimeMessagePreparator preparator = mimeMessage -> {
			MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
			message.setFrom(SENDER_ADDRESS);
			message.setTo(emailAddress);
			message.setSubject(subject);
			message.setText(htmlBody, true);
		};
		mailSender.send(preparator);
	}

	public void sendNewEvents(User user, List<Event> events) {
		Context context = new Context();
		context.setVariable("username", user.getUsername());
		context.setVariable("events", events);
		String htmlContent = templateEngine.process("new_events", context);

		sendEmail(user.getEmail(), "New events for last 24 hours", htmlContent);
	}

}
