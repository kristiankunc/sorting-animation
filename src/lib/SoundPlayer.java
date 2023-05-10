package lib;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.SourceDataLine;
public class SoundPlayer {
    private SourceDataLine sdl;
    private final AudioFormat af;
    private boolean isMuted;
    public SoundPlayer(boolean playSound) {
        this.isMuted = !playSound;

        af = new AudioFormat((float) 44100, 8, 1, true, false);
        try {
            sdl = javax.sound.sampled.AudioSystem.getSourceDataLine(af);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void playFromArray(int value, int max) { // plays a sound from a value and max value
        if (isMuted) return; // if the sound player is muted, return

        // https://stackoverflow.com/a/929107/14762088
        double freq = 120 + (value / (double) max) * (1212 - 120); // converts to range 120hz-1212hz

        byte[] buf = new byte[1];
        try {
            sdl.open(af); // try to open the audio line
        } catch (Exception e) {
            e.printStackTrace();
        }

        sdl.start();
        for (int i = 0; i < 1000; i++) {
            double angle = i / (44100.0 / freq) * 2.0 * Math.PI; // 44100 is the sample rate, 2.0 is to make it louder, Math.PI is to make it a sine wave
            buf[0] = (byte) (Math.sin(angle) * 100); // Get the sine of the angle, multiply by 100 to make it louder
            sdl.write(buf, 0, 1); // write to audio line
        }
    }

    public void reset() { // closes the sdl, should be called after playing a set of sounds to reset the audio line
        sdl.stop();
        sdl.close();
    }

    public void setMuted(boolean muted) { // sets the muted state
        isMuted = muted;
    }

    public static void main(String[] args) { // test
        SoundPlayer sp = new SoundPlayer(true);
        for (int i = 0; i < 10; i++) {
            sp.playFromArray(i, 10);
        }
    }
}
