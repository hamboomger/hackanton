package com.hackanton.user.email;

import com.hackanton.event.Event;
import com.hackanton.model.event.EventMocks;
import com.hackanton.user.User;
import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmailServiceTest {

	@Autowired
	private EmailService emailService;

	private GreenMail smtpServer;

	@Before
	public void setUp() {
		this.smtpServer = new GreenMail(new ServerSetup(2525, null, "smtp"));
		smtpServer.start();
	}

	@Test
	public void sendEmail() throws IOException, MessagingException, InterruptedException {
		emailService.sendEmail("some_address@gmail.com", "subject", "content");

		MimeMessage[] messages = smtpServer.getReceivedMessages();

		assertEquals(messages.length, 1);
		MimeMessage message = messages[0];
		String content = message.getContent().toString();
		assertEquals(content, "content\r\n");
		String subject = message.getSubject();
		assertEquals(subject, "subject");

		Address[] from = message.getFrom();
		assertEquals(from.length, 1);
		assertEquals(from[0].toString(), "hg.hackathon@gmail.com");

		Address[] recipients = message.getAllRecipients();
		assertEquals(recipients.length, 1);
		assertEquals(recipients[0].toString(), "some_address@gmail.com");
	}

	@Test
	public void sendNewEvents() throws IOException, MessagingException {
		Event event1 = EventMocks.getMock1();
		Event event2 = EventMocks.getMock2();

		List<Event> events = new ArrayList<>(Arrays.asList(event1, event2));
		User user = new User("user@gmail.com", "password", "username", true, new ArrayList<>(), null);
		emailService.sendNewEvents(user, events);

		MimeMessage[] messages = smtpServer.getReceivedMessages();

		assertEquals(messages.length, 1);
		MimeMessage message = messages[0];
		String content = message.getContent().toString();

		System.out.println(content);
	}

	@After
	public void tearDown() {
		smtpServer.stop();
	}
}