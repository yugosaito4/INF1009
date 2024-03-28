package com.mygdx.game;
import java.util.List;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class IOManagement 
{
    protected Clip clip;
	protected URL soundURL[] = new URL[30];

	
    public IOManagement(){
    	//adding sounds to an array
        soundURL[0] = getClass().getResource("/Sounds/StartMenuBG.wav");
		soundURL[1] = getClass().getResource("/Sounds/InstructionsSound.wav");
		soundURL[2] = getClass().getResource("/Sounds/Tips.wav");
		soundURL[3] = getClass().getResource("/Sounds/GameBG.wav");
		soundURL[4] = getClass().getResource("/Sounds/Correct.wav");
		soundURL[5] = getClass().getResource("/Sounds/Wrong.wav");
		soundURL[6] = getClass().getResource("/Sounds/LevelWin.wav");
		soundURL[7] = getClass().getResource("/Sounds/FinalGameWin.wav");
		soundURL[8] = getClass().getResource("/Sounds/LoseLevel.wav");
    }
    
    //handling input
	public void handleInput(List<Player> playerList) {
        for (Player p : playerList) {
			((iMovable) p).UserEntityMovement();	
        }
    }
	
	
	
	public void setFile(int i) {
            
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }
        catch(Exception e) {
            System.out.println("Clip file does not exist.");
        }
    }
    
	//handling output
    public void play() {
        if (clip != null){
            clip.start();
        }
        else{
            System.out.println("Clip file does not exist");
        }
    }
    
    public void loop() {
        if (clip != null){
           clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        else{
            System.out.println("Clip file does not exist");
        }
    }

    public Clip getClip(){
        return clip;
    }
    
    public void stop() {
        clip.stop();
    }
	
	
	
}
