package id.its.pbo;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	Clip clip;
	URL soundURL[] = new URL[30];
	
	public Sound() {
		try {
		soundURL[0] = getClass().getResource("/sound/MainSoundGame.wav").toURI().toURL();
		soundURL[1] = getClass().getResource("/sound/Item.WAV").toURI().toURL();
		soundURL[2] = getClass().getResource("/sound/boots.WAV").toURI().toURL();
		soundURL[3] = getClass().getResource("/sound/wrong.WAV").toURI().toURL();
		} catch(Exception e) {
			 e.printStackTrace();
		}
	}
	
	public void setFile(int i) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
		} catch(Exception e) {
			
		}
	}
	
	public void play() {
		clip.start();
	}
	
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		clip.stop();
	}
}
