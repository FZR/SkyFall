package com.mgiah.SkyFall;

import com.badlogic.gdx.Game;
import com.mgiah.SkyFall.Screens.MainMenu;

public class MainGameClass extends Game {

    private MainMenu mainMenu;

    @Override
    public void create() {
        mainMenu = new MainMenu();

        setScreen(mainMenu);
    }
}
