package org.academiadecodigo.bootcamp67;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Sound {

    private Clip audioClipBackground;
    private Clip gameOver;

    public void startMenuMusic() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("resources/music.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    }
}
