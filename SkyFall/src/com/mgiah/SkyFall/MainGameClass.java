package com.mgiah.SkyFall;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mgiah.SkyFall.Screens.MainMenu;

public class MainGameClass extends Game {

    private MainMenu mainMenu;
    private Screen screen;
    private Preferences preferences;
    public static final String preferencesName = "game-prefs";

    @Override
    public void create() {
        mainMenu = new MainMenu(this);
        preferences = Gdx.app.getPreferences(preferencesName);
        preferences.putBoolean("PAUSED", false);
        preferences.flush();
        setScreen(mainMenu);
    }

    public void setPreviousScreen(Screen screen){
        this.screen = screen;
    }

    public Screen getPreviousScreen(){
        return this.screen;
    }

    /*public void returnToPreviousScreen(){

    }*/
}
