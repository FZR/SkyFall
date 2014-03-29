package com.mgiah.SkyFall.Models;

import com.badlogic.gdx.math.Vector2;

public class MainChar {

    private Vector2 position;
    private float stateTime;
    private Vector2 velocity = new Vector2();
    private boolean facingLeft = true;
    private float wingVariable = 100f;

    public MainChar(Vector2 position){
        this.position = position;
    }

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
}
