package com.mgiah.SkyFall;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mgiah.SkyFall.Screens.MainMenu;

public class MainGameClass extends Game {

    private MainMenu mainMenu;

    @Override
    public void create() {
        mainMenu = new MainMenu(this);
        setScreen(mainMenu);
    }
}
