package net.bounceme.dur.mail;

import java.io.IOException;
import static java.lang.System.out;
import javax.mail.MessagingException;

public class JamesConfigTest {

    public void redGreenBlue() throws MessagingException, IOException, InterruptedException   {
        // CREATE CLIENT INSTANCES
        MailClient redClient = new MailClient("red", "localhost");
        MailClient greenClient = new MailClient("green", "localhost");
        MailClient blueClient = new MailClient("blue", "localhost");

        // CLEAR EVERYBODY'S INBOX
        redClient.checkInbox(MailClient.CLEAR_MESSAGES);
        greenClient.checkInbox(MailClient.CLEAR_MESSAGES);
        blueClient.checkInbox(MailClient.CLEAR_MESSAGES);
        Thread.sleep(500); // Let the server catch up

        // SEND A COUPLE OF MESSAGES TO BLUE (FROM RED AND GREEN)
        redClient.sendMessage(
                "blue@localhost",
                "Testing blue from red",
                "This is a test message");
        greenClient.sendMessage(
                "blue@localhost",
                "Testing blue from green",
                "This is a test message");
        Thread.sleep(500); // Let the server catch up

        // LIST MESSAGES FOR BLUE (EXPECT MESSAGES FROM RED AND GREEN)
        blueClient.checkInbox(MailClient.SHOW_AND_CLEAR);
        
        out.println("did test");
    }
}