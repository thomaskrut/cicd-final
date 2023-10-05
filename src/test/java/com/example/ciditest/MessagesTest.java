package com.example.ciditest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MessagesTest {

    @BeforeEach
    void setUp() {
        Messages.clearMessages();
    }

    @Test
    void shouldReturnMessagesListSizeOneWhenAddingNewMessage() {
        Messages.addMessage(new Message("Username", "Message"));
        assertEquals(Messages.getAllMessages().size(), 1);
    }

    @Test
    void shouldReturnMessagesListSizeTwoWhenAddingTwoMessages() {
        Messages.addMessage(new Message("Username", "Message"));
        Messages.addMessage(new Message("Username", "Message 2"));
        assertEquals(Messages.getAllMessages().size(), 3);
    }

    @Test
    void shouldReturnMessagesAfterTimestampOfFirstMessage() {
        Messages.addMessage(new Message("Username", "Message"));
        Messages.addMessage(new Message("Username", "Message 2"));
        assertEquals(Messages.getAllMessagesAfterTimestamp(Messages.getAllMessages()
                .get(0).getTimestamp()).size(), 1);
    }

    @Test
    void removeMessage() {
        Messages.addMessage(new Message("Username", "Message"));
        Messages.addMessage(new Message("Username", "Message 2"));
        Messages.removeMessage(Messages.getAllMessages().get(0));
        assertEquals(Messages.getAllMessages().size(), 1);
    }
}