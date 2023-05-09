package lib;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import java.util.Arrays;

public class SoundPlayer {
    private SourceDataLine sdl;
    private final AudioFormat af;
    public SoundPlayer() {
        af = new AudioFormat((float) 44100, 8, 1, true, false);
        try {
            sdl = javax.sound.sampled.AudioSystem.getSourceDataLine(af);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void playFromArray(int value, int max) {
        double freq = 120 + (value / (double) max) * (1212 - 120);

        byte[] buf = new byte[1];
        try {
            sdl.open(af);
        } catch (Exception e) {
            System.out.println("Error opening audio line, cannot play sound");
        }

        sdl.start();
        for (int i = 0; i < 1000; i++) {
            double angle = i / (44100.0 / freq) * 2.0 * Math.PI;
            buf[0] = (byte) (Math.sin(angle) * 100);
            sdl.write(buf, 0, 1);
        }

        // reset()
    }

    public void reset() { // should be called after playing a set of sounds to reset the audio line
        sdl.stop();
        sdl.close();
    }

    public static void main(String[] args) { // test
        SoundPlayer sp = new SoundPlayer();
        for (int i = 0; i < 10; i++) {
            sp.playFromArray(i, 10);
        }
    }
}
