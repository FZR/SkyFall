package com.mgiah.SkyFall.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class World {

    private MainChar mainChar;
    private float speed = 100f;


    public World(){
        createDemo();
    }

    private void createDemo(){
        mainChar = new MainChar(new Vector2(Gdx.graphics.getWidth() / 2f, 500f));
    }

    public void update(float delta){

    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
