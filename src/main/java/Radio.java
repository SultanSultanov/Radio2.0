import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;

public class Radio  {


    public void radioPleer(String s) {


        URL url;
        AdvancedPlayer play = null;
        try {
            play = new AdvancedPlayer(new BufferedInputStream(new URL(s).openStream()));
        } catch (JavaLayerException | IOException e) {
            e.printStackTrace();
        }
        try {
            play.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }

    }


}

