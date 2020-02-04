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
        super("Radio Online");
        setSize(400, 300);
        setLocationByPlatform(true);
        JPanel panel = new JPanel();







        JButton button1 = new JButton("SPB");
        button1.setActionCommand("https://myradio24.org/2666");

        JButton button2 = new JButton("Retro");
        button2.setActionCommand("https://myradio24.org/8144");

        panel.add(button1);
        panel.add(button2);
        add(panel);


        ActionListener actionListener = new TestActionListener();

        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);


    }
    public class Paint extends JPanel{

        BufferedImage image;

        public void paintComponent(Graphics g)
        {
            try {
                image = ImageIO.read(new File("C:\\Users\\Султан\\Desktop\\Radio2.0\\src\\main\\resources\\145458292112119207.jpg"));
            } catch (IOException e) {

                e.printStackTrace();
            }
            g.drawImage(image, 0, 0, this);
        }

    }






    class TestActionListener implements ActionListener {


        public void actionPerformed(ActionEvent e) {
            if (currentPlayer != null){
                currentPlayer.close();
            }
            new Thread(()->{
                try{
                    Player player = new Player(new BufferedInputStream(new URL(e.getActionCommand()).openStream()));
                    currentPlayer = player;
                    currentPlayer.play();
                } catch (JavaLayerException | IOException ex){
                    ex.printStackTrace();
                }
            }).start();




        }
    }

    class Fr extends JFrame {
        JLabel lbl;
        JButton b;

        public Fr() {
            setTitle("Window");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setBounds(100, 100, 500, 450);
            setResizable(false);

            setContentPane(new BgPanel());
            Container cont = getContentPane();

            lbl = new JLabel("Label");
            lbl.setFont(new Font("Arial", Font.PLAIN, 24));
            b = new JButton("Button");


            cont.setLayout(new FlowLayout());
            cont.add(lbl);
            cont.add(b);

        }
    }

    class BgPanel extends JPanel {
        public void paintComponent(Graphics g) {
            Image im = null;
            try {
                im = ImageIO.read(new File("C:\\Users\\Султан\\Desktop\\Radio2.0\\src\\main\\resources\\145458292112119207.jpg"));
            } catch (IOException e) {
            }
            g.drawImage(im, 0, 0, null);
        }
    }


}


