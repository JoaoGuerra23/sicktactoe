package org.academiadecodigo.bootcamp67;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {

    private Clip menuMusic;
    private Clip gameMusic;
    private Clip winMusic;
    private Clip tieMusic;

    private String prefix = "resources/";

    public void startGameMusic() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(prefix + "GameMusic.wav"));
        gameMusic = AudioSystem.getClip();
        gameMusic.open(audioIn);
        gameMusic.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stopGameMusic() {
       gameMusic.stop();
    }

    public void startStopGameMusic() {
        if (gameMusic.isRunning()) {
            gameMusic.stop();
        } else {
            gameMusic.start();
        }
    }

    public void startMenuMusic() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(prefix + "MenuMusic.wav"));
        menuMusic = AudioSystem.getClip();
        menuMusic.open(audioIn);
        menuMusic.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void startStopMenuMusic() {
        if(menuMusic.isRunning()){
            menuMusic.stop();
        } else {
            menuMusic.start();
        }
    }

    public void stopMenuMusic() {
        menuMusic.stop();
    }

    public void winGameMusic() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(prefix + "victorytheme.wav"));
        winMusic = AudioSystem.getClip();
        winMusic.open(audioIn);
        winMusic.start();
    }

    public void stopWinMusic() {
        winMusic.stop();
    }

    public void tieGameMusic() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(prefix + "endtheme.wav"));
        tieMusic = AudioSystem.getClip();
        tieMusic.open(audioIn);
        tieMusic.start();
    }

    public void stopTieMusic() {
        tieMusic.stop();
    }
}
