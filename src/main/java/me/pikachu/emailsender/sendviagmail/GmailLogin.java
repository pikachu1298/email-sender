package me.pikachu.emailsender.sendviagmail;

import com.microsoft.graph.requests.GraphServiceClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class GmailLogin extends JFrame {
        private JTextField email;
        private JPasswordField password;
        private JPanel panel;
        private JFrame frame;
        public GmailLogin() {
            frame.setPreferredSize(new Dimension(1000, 600));
            frame.add(panel);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setResizable(true);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //take the login details and give it to the new class.
            String e=email.getText();
            String p= String.valueOf(password.getPassword());




        }
    }

