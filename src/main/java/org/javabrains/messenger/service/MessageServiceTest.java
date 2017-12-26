package org.javabrains.messenger.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.javabrains.messenger.model.Message;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MessageServiceTest {

	private MessageService messageService;
	
	@Before
	public void setUp() throws Exception {
		messageService = new MessageService();
	}

	@After
	public void tearDown() throws Exception {
		messageService = null;
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetAllMessages() {
		List<Message> messages = messageService.getAllMessages();
		assertEquals(messages.get(0).getAuthor(), "Karthik Chejerla");
		assertEquals(messages.get(1).getAuthor(), "Koushik Kothagal");
		assertEquals(messages.get(10).getAuthor(), "Invalid Entry");
	}

	@Test
	public void testGetMessage() {
		Message message = messageService.getMessage(2L);
		assertEquals("Hello India!", message.getMessageContent());
		assertEquals("Koushik Kothagal", message.getAuthor());
	}

	@Test
	public void testRemoveMessage() {
		Message message = messageService.removeMessage(2L);
		assertEquals("Hello India!", message.getMessageContent());
		assertEquals("Koushik Kothagal", message.getAuthor());
	}

	@Test
	public void testAddMessage() {
		assertEquals(messageService.getAllMessages().size(), 2);
		Message message = messageService.addMessage(new Message(3L, "Python!", "Vocollect"));
		assertEquals("Python!", message.getMessageContent());
		assertEquals("Vocollect", message.getAuthor());
		assertEquals(messageService.getAllMessages().size(), 3);
	}

	@Test
	public void testUpdateMessage() {
		Message message = messageService.updateMessage(new Message(1L, "Hello World Updated!", "Karthik Chejerla"));
		assertEquals("Hello World Updated!", message.getMessageContent());
		assertEquals("Karthik Chejerla", message.getAuthor());
	}

}
