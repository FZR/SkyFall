package com.mgiah.SkyFall.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class MainChar {
    private Vector2 position;
    private float stateTime;
    private Vector2 velocity = new Vector2();
    private boolean facingLeft = true;
    private float wingVariable = 100f;
    private float speed = 50f;
    private float posToStopLeft = 0f;
    private float posToStopRight = Gdx.graphics.getWidth();
    public MainChar(Vector2 position){
        this.position = position;
    }
    private float textureWidth = 0, textureHeight = 0;

    public void update(float delta){
        this.stateTime += delta;
        position.add(velocity.cpy().scl(delta));
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public float getStateTime() {
        return stateTime;
    }

    public void setStateTime(float stateTime) {
        this.stateTime = stateTime;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public boolean isFacingLeft() {
        return facingLeft;
    }

    public void setFacingLeft(boolean facingLeft) {
        this.facingLeft = facingLeft;
    }

    public float getWingVariable() {
        return wingVariable;
    }

    public void setWingVariable(float wingVariable) {
        this.wingVariable = wingVariable;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getPosToStopLeft() {
        return posToStopLeft;
    }

    public float getPosToStopRight() {
        return posToStopRight;
    }

    public float getTextureWidth() {
        return textureWidth;
    }

    public void setTextureWidth(float textureWidth) {
        this.textureWidth = textureWidth;
    }

    public float getTextureHeight() {
        return textureHeight;
    }

    public void setTextureHeight(float textureHeight) {
        this.textureHeight = textureHeight;
    }
}
