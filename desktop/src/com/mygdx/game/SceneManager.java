package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

import gameLayer.EndGameScreen;
import gameLayer.EndLevelScreen;
import gameLayer.GameScreen;
import gameLayer.StartScreen;
import gameLayer.ToolTipScreen;

import java.util.HashMap;
import java.util.Map;


public class SceneManager extends Game {
    private Map<String, Screen> scenes;
    private Screen currentScreen;

    public SceneManager() {
        scenes = new HashMap<>();//create hashmaps to store sceneName and Scene. Allow for easy identification
    }

    @Override
    public void create() {
    	addScene("startScene", new StartScreen(this));
    	
    	addScene("toolTip1", new ToolTipScreen(this, "The category for this level is proteins!", "gameScene1"));
    	addScene("toolTip2", new ToolTipScreen(this, "The category for this level is vegetables!", "gameScene2"));
    	addScene("toolTip3", new ToolTipScreen(this, "The category for this level is fruits!", "gameScene3"));
    	addScene("toolTip4", new ToolTipScreen(this, "The category for this level is vegetables and fruits!", "gameScene4"));
    	
    	addScene("gameScene1", new GameScreen(this, "endLevel1"));
    	addScene("gameScene2", new GameScreen(this, "endLevel2"));
    	addScene("gameScene3", new GameScreen(this, "endLevel3"));
    	addScene("gameScene4", new GameScreen(this, "endLevel4"));
    	
    	addScene("endLevel1", new EndLevelScreen(this, "Congrats on completing Level 1!", "toolTip2"));
    	addScene("endLevel2", new EndLevelScreen(this, "Congrats on completing Level 2!", "toolTip3"));
    	addScene("endLevel3", new EndLevelScreen(this, "Congrats on completing Level 3!", "toolTip4"));
    	addScene("endLevel4", new EndLevelScreen(this, "Congrats on completing Level 4!", "endGameScene"));
    	
    	addScene("endGameScene", new EndGameScreen(this));
        /*addScene("mainScene", new MainScene(this));
        addScene("gameScene", new GameScene(this));
        */
        setScene("startScene"); //set the initial scene
    }

    @Override
    public void render() {
        super.render();
    }

    public void addScene(String name, Screen scene) {
        scenes.put(name, scene);
    }

    public void setScene(String name) {
        if (scenes.containsKey(name)) {
            if (currentScreen != null) {
                currentScreen.hide();
            }
            currentScreen = scenes.get(name);
            setScreen(currentScreen);
        }
    }

    @Override
    public void dispose() {
        for (Screen scene : scenes.values()) {
            if (scene != null) {
                scene.dispose();
            }
        }
    }
}
