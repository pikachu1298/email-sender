package me.pikachu.emailsender;

import me.pikachu.emailsender.sendviagmail.GmailLogin;
import me.pikachu.emailsender.sendviaoutlook.OutlookSender;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class StartPage extends JFrame  {
    private JPanel intro;
    private JButton sendViaOutlook;
    private JButton sendViaGmail;
    private JFrame frame;
    public StartPage() {
        frame=new JFrame("Start");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setPreferredSize(new Dimension(250, 200));
        //now add the frame
        frame.add(intro);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Pikachu1298 email sender v3.2.0.5");


        sendViaGmail.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new GmailLogin();


            }
        });
        sendViaOutlook.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new OutlookSender();
            }
        });
    }

}
