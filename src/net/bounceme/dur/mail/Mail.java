package net.bounceme.dur.mail;

import java.io.IOException;
import static java.lang.System.out;
import javax.mail.MessagingException;

public class Mail {

    private MailClient mailClient = new MailClient("hawat", "localhost");

    public static void main(String[] args) throws MessagingException, IOException, InterruptedException {
        Mail mail = new Mail();
    }

    public Mail() throws MessagingException, IOException, InterruptedException {
        dummyMessage();
    }

    private void dummyMessage() throws MessagingException {
        mailClient.sendMessage("thufir@localhost", "hello world", "hello world content yet again");
        out.println("sent message");
    }
}
