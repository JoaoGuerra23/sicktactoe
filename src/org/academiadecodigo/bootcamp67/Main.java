package org.academiadecodigo.bootcamp67;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();

        game.init();
        //PrankGame game = new PrankGame();
        //game.initializer();
    }
}
