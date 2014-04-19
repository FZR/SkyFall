package com.mgiah.SkyFall.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class World {

    private MainChar mainChar;
    private Angel angel;
    private Demon demon;
    private float speed = 25f;


    public World(){
        createWorld();
    }

    private void createWorld(){
        mainChar = new MainChar(new Vector2(Gdx.graphics.getWidth() / 2f, 500f));
        angel = new Angel(new Vector2(0, 0));
        demon = new Demon(new Vector2(0, 0));
    }

    public void update(float delta){

    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public MainChar getMainChar() {
        return mainChar;
    }

    public Angel getAngel() {
        return angel;
    }

    public Demon getDemon() {
        return demon;
    }
}
