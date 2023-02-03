/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package onlinevotingmachine;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Dell
 */
public class OnlineVotingMachine extends JFrame {

    Timer timer;
    String mypath = "C:\\Users\\Dell\\Documents\\NetBeansProjects\\OnlineVotingMachine\\src\\Images\\last.jpg";

    OnlineVotingMachine() {
        displaywelcome();
    }

    public static void main(String[] args) {
        OnlineVotingMachine wl = new OnlineVotingMachine();
    }

    private void displaywelcome() {
        JWindow w = new JWindow(this);
//        w.setSize(700, 550);
        w.setBounds(0, 0, 700, 700);

//        w.setLocationRelativeTo(null);
        w.setVisible(true);

        JPanel JP = new JPanel();
        w.add(JP);

        JLabel JL = new JLabel(new ImageIcon(mypath));
//        JL.setHorizontalAlignment(SwingConstants.CENTER);
        JP.add(JL);
        JP.setBorder(BorderFactory.createLineBorder(Color.black));
//        Container content = getContentPane();
//        content.setBackground(Color.BLACK);
        JProgressBar progress = new JProgressBar(0, 100);
        progress.setForeground(Color.DARK_GRAY);
        w.add(BorderLayout.PAGE_END, progress);
        w.revalidate();
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = progress.getValue();
                if (x == 100) {
                    w.dispose();
                    Welcome obj = new Welcome();
                    obj.setVisible(true);
                    timer.stop();
                } else {
                    progress.setValue(x + 4);
                }
            }
        });
        timer.start();
    }
}
