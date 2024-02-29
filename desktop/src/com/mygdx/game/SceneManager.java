package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

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
        addScene("mainScene", new MainScene(this));
        addScene("gameScene", new GameScene(this));
        setScene("mainScene"); //set the initial scene
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
