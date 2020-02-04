import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Simple extends JFrame {
    Player player;
    URL url;
    JPanel panel;
    Player currentPlayer;




    public Simple() {
        super("Radio");
        setSize(600, 600);
        setLocationByPlatform(true);
        JPanel panel = new JPanel();


        JButton button1 = new JButton("SPB");
        button1.setActionCommand("https://myradio24.org/2666");



        JButton button2 = new JButton("Retro FM");
        button2.setActionCommand("https://myradio24.org/8144");



        JButton button3 = new JButton("Отличное Радио");
        button3.setActionCommand("https://myradio24.org/60403");


        JButton button4 = new JButton("Radio Respect");
        button4.setActionCommand("https://myradio24.org/lucu666");

        JButton button5 = new JButton("Radio-J");
        button5.setActionCommand("https://myradio24.org/evgewa");


        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);

        add(panel);


        ActionListener actionListener = new TestActionListener();

        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
        button3.addActionListener(actionListener);
        button4.addActionListener(actionListener);
        button5.addActionListener(actionListener);


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
