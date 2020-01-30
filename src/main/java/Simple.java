import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.*;


public class Simple extends JFrame {
    JPanel panel;
    boolean bool;

    ExecutorService service = Executors.newFixedThreadPool(1);


    public Simple() {
        super("Radio Online");
        setSize(400, 300);
        setLocationByPlatform(true);
        JPanel panel = new JPanel();

        JButton button1 = new JButton("SPB");


        JButton button2 = new JButton("Retro");


        panel.add(button1);
        panel.add(button2);
        add(panel);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("SPB");

                        Radio radio = new Radio();
                        radio.radioPleer("https://myradio24.org/2666");

                    }
                };
                service.shutdownNow();
               service.execute(runnable);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Retro");

                        Radio radio = new Radio();
                        radio.radioPleer("https://myradio24.org/8144");
                    }
                };
                service.execute(runnable);

            }
        });

    }
}
