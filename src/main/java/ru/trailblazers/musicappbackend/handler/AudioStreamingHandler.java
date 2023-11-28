package ru.trailblazers.musicappbackend.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@Component
public class AudioStreamingHandler {

    private SourceDataLine audioOutputLine;
    private boolean isPlaying;

    public AudioStreamingHandler() {
        isPlaying = false;
    }

    public void handleWebSocketMessage(byte[] audioData, String command) {
        if (command.equals("play")) {
            if (!isPlaying) {
                playAudio(audioData);
            }
        } else if (command.equals("pause")) {
            if (isPlaying) {
                pauseAudio();
            }
        } else if (command.equals("stop")) {
            if (isPlaying) {
                stopAudio();
            }
        }
    }

    private void pauseAudio() {
        isPlaying = false;
    }

    private void playAudio(byte[] audioData) {
        try {
            var audioFormat = new AudioFormat(44100, 16, 2, true, false);
            var info = new DataLine.Info(SourceDataLine.class, audioFormat);
            audioOutputLine = (SourceDataLine) AudioSystem.getLine(info);
            audioOutputLine.open(audioFormat);
            audioOutputLine.start();

            ByteArrayInputStream audioInputStream = new ByteArrayInputStream(audioData);
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = audioInputStream.read(buffer)) != -1) {
                audioOutputLine.write(buffer, 0, bytesRead);
            }

            audioOutputLine.drain();
            audioOutputLine.close();
        } catch (LineUnavailableException | IOException ex) {
            ex.printStackTrace();
        }
    }

    private void stopAudio() {
        isPlaying = false;
        audioOutputLine.stop();
        audioOutputLine.flush();
        audioOutputLine.close();
    }
}
