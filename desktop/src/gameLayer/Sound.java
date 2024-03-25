package gameLayer;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	
	Clip clip;
	URL soundURL[] = new URL[30];
	
	public Sound() {
		soundURL[0] = getClass().getResource("/Sounds/GameBG.wav");
		soundURL[1] = getClass().getResource("/Sounds/Correct.wav");
		soundURL[2] = getClass().getResource("/Sounds/Wrong.wav");
		soundURL[3] = getClass().getResource("/Sounds/LevelWin.wav");
		soundURL[4] = getClass().getResource("/Sounds/FinalGameWin.wav");
		soundURL[5] = getClass().getResource("/Sounds/StartMenuBG.wav");
		soundURL[6] = getClass().getResource("/Sounds/InstructionsSound.wav");
		soundURL[7] = getClass().getResource("/Sounds/Tips.wav");
	}
	
	public void setFile(int i) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
		}
		catch(Exception e) {
			
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
