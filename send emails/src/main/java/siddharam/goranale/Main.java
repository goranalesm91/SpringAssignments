package siddharam.goranale;

import java.sql.SQLOutput;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        MailHandler mailer=new MailHandler();
        mailer.sendmail();
        System.out.println("Email Sent...");
    }
}