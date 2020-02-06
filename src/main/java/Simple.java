import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import javax.swing.*;


public class Simple extends JFrame {
    Player player;
    URL url;
    JPanel panel;
    Player currentPlayer;
    Font font = new Font("TimesNewRoman", Font.BOLD, 22);
    Properties property = new Properties();
    FileInputStream fis;



    public Simple() {
        setLocationByPlatform(true);
        setBounds(700, 300, 300, 600);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        try {
            fis = new FileInputStream("src/main/resources/radio.properties");
            property.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JButton button1 = new JButton(property.getProperty("button1.name"));
        button1.setActionCommand(property.getProperty("button1.URL"));
        button1.setFont(font);


        JButton button2 = new JButton(property.getProperty("button2.name"));
        button2.setActionCommand(property.getProperty("button2.URL"));
        button2.setFont(font);

        JButton button3 = new JButton(property.getProperty("button3.name"));
        button3.setActionCommand(property.getProperty("button3.URL"));
        button3.setFont(font);

        JButton button4 = new JButton(property.getProperty("button4.name"));
        button4.setActionCommand(property.getProperty("button4.URL"));
        button4.setFont(font);

        JButton button5 = new JButton(property.getProperty("button5.name"));
        button5.setActionCommand(property.getProperty("button5.URL"));
        button5.setFont(font);

        JButton button6 = new JButton(property.getProperty("button6.name"));
        button6.setActionCommand(property.getProperty("button6.URL"));
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
                    currentPlayer = new Player(new BufferedInputStream(new URL(e.getActionCommand()).openStream()));
                    currentPlayer.play();
                } catch (JavaLayerException | IOException ex) {
                    ex.printStackTrace();
                }
            }).start();
        }
    }
}
