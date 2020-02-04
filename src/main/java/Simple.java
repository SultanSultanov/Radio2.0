import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import javax.swing.*;


public class Simple extends JFrame {
    Player player;
    URL url;
    JPanel panel;
    Player currentPlayer;
    Font font = new Font("TimesNewRoman", Font.BOLD, 22);


    public Simple() {
        setLocationByPlatform(true);
        setBounds(700, 300, 300, 600);
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(6, 1));

        JButton button1 = new JButton("Radio SPB");
        button1.setActionCommand("https://myradio24.org/2666");
        button1.setFont(font);

        JButton button2 = new JButton("Retro FM");
        button2.setActionCommand("https://myradio24.org/8144");
        button2.setFont(font);

        JButton button3 = new JButton("Great radio");
        button3.setActionCommand("https://myradio24.org/60403");
        button3.setFont(font);

        JButton button4 = new JButton("Radio Respect");
        button4.setActionCommand("https://myradio24.org/lucu666");
        button4.setFont(font);

        JButton button5 = new JButton("Radio-J");
        button5.setActionCommand("https://myradio24.org/evgewa");
        button5.setFont(font);

        JButton button6 = new JButton("Radio Galactic");
        button6.setActionCommand("https://myradio24.org/11643");
        button6.setFont(font);

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);

        add(panel);

        ActionListener actionListener = new TestActionListener();

        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
        button3.addActionListener(actionListener);
        button4.addActionListener(actionListener);
        button5.addActionListener(actionListener);
        button6.addActionListener(actionListener);
    }

    class TestActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (currentPlayer != null) {
                currentPlayer.close();
            }
            new Thread(() -> {
                try {
                    Player player = new Player(new BufferedInputStream(new URL(e.getActionCommand()).openStream()));
                    currentPlayer = player;
                    currentPlayer.play();
                } catch (JavaLayerException | IOException ex) {
                    ex.printStackTrace();
                }
            }).start();
        }
    }
}
