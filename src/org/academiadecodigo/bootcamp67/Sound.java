package org.academiadecodigo.bootcamp67;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Sound {

    private Clip menuMusic;
    private Clip gameMusic;
    private Clip winMusic;
    private Clip tieMusic;

    public void startGameMusic() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        URL wavFile = getClass().getClassLoader().getResource("GameMusic.wav");
        try {
            gameMusic = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        try {
            gameMusic.open(AudioSystem.getAudioInputStream(wavFile));
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        gameMusic.start();
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
        URL wavFile = getClass().getClassLoader().getResource("MenuMusic.wav");
        try {
            menuMusic = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        try {
            menuMusic.open(AudioSystem.getAudioInputStream(wavFile));
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        menuMusic.start();
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
        URL wavFile = getClass().getClassLoader().getResource("victorytheme.wav");
        try {
            winMusic = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        try {
            winMusic.open(AudioSystem.getAudioInputStream(wavFile));
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        winMusic.start();
        winMusic.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stopWinMusic() {
        winMusic.stop();
    }

    public void tieGameMusic() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        URL wavFile = getClass().getClassLoader().getResource("endtheme.wav");
        try {
            tieMusic = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        try {
            tieMusic.open(AudioSystem.getAudioInputStream(wavFile));
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        tieMusic.start();
        tieMusic.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stopTieMusic() {
        tieMusic.stop();
    }
}
