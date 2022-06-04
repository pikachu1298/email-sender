package me.pikachu.emailsender.sendviaoutlook;

import com.microsoft.graph.models.*;
import com.microsoft.graph.requests.GraphServiceClient;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class OutlookSender {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JTextField subjectField;
    private JTextField bodyField;
    private JTextField ccField;
    private JTextField toField;
    private JFrame frame;

        public OutlookSender() {
            //set the frame so then user can see the window to send the email
            frame.add(frame);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setResizable(true);
            frame.setVisible(true);
            frame.pack();
            frame.setPreferredSize(new Dimension(1020, 900));
            frame.setTitle("Pikachu Email sender v3.2.0.5 (Outlook login)");
            //Definitions
            String e = emailField.getText();
            String p = passwordField.getText();
            String subject = subjectField.getText();
            String body=bodyField.getText();
            String to = toField.getText();
            String cc = ccField.getText();
            GraphServiceClient gc = GraphServiceClient.builder().authenticationProvider( authProvider).buildClient();
            //Message structure
            Message m = new Message();
            m.subject = body;
            ItemBody ibody = new ItemBody();
            ibody.contentType= BodyType.TEXT;
            ibody.content= body;
            m.body=ibody;
            Recipient recipient = new Recipient();
            EmailAddress addr = new EmailAddress();
            addr.address = to;
            recipient.emailAddress=addr;
            LinkedList<Recipient> toRecipientsList = new LinkedList<Recipient>();
            toRecipientsList.add(recipient);
            m.toRecipients=toRecipientsList;
            LinkedList<Recipient> ccRecipientsList = new LinkedList<Recipient>();
            Recipient ccRecipients = new Recipient();
            EmailAddress ccEmail = new EmailAddress();
            ccEmail.address = cc;
            ccRecipients.emailAddress=ccEmail;
            ccRecipientsList.add(ccRecipients);
            m.ccRecipients =ccRecipientsList;
            //Save email to the sent items category? No.
            boolean saveToSentItems=false;
            //Get the items
            gc.me()
                    //Prepare it
                    .sendMail(UserSendMailParameterSet
                            //Also the message structure and extra parameters must go so we can send the email properly
                            .newBuilder()
                            .withMessage(m)
                            .withSaveToSentItems(saveToSentItems)
                            .build())
                    /** Now we assemble the structure
                     * and parameters
                     * then build it and blend it into a proper and well-blended request
                     * so we can send the request and post it to the server.
                     */
                    .buildRequest()
                    //Now we send or post the request
                    .post();








        }

}
