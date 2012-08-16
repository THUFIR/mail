package net.bounceme.dur.mail;

import static java.lang.System.out;
import javax.mail.MessagingException;

public class Mail {

    private MailClient mailClient = new MailClient("hawat", "localhost");

    public static void main(String[] args) throws MessagingException {
        Mail mail = new Mail();
        mail.dummyMessage();
    }

    public Mail() {
    }

    private void dummyMessage() throws MessagingException {
        mailClient.sendMessage("thufir", "hello world", "hello world content yet again");
        out.println("sent message");
    }
}
