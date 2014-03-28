package com.mgiah.SkyFall;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.mgiah.SkyFall.Characters.MainChar;

public class World {

    private MainChar mainChar;

    public World(){
        createDemo();
    }

    private void createDemo(){
        mainChar = new MainChar(new Vector2(Gdx.graphics.getWidth() / 2f, 500f));
    }

}
