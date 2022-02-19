package org.academiadecodigo.bootcamp67;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {

    public void startGameMusic() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("resources/GameMusic.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    }

    public void startMenuMusic() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("resources/MenuMusic.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    }

    public void winGameMusic() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("resources/"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    }

    public void tieGameMusic() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("resources/"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    }
}
