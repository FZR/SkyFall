package com.mgiah.SkyFall.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Angel {
    private Vector2 position;
    private float stateTime;
    private Vector2 velocity = new Vector2();
    private boolean facingLeft = true;
    private float speed = 50f;
    private float posToStopLeft = 0f;
    private float posToStopRight = Gdx.graphics.getWidth();
    private boolean alive = true;
    private State state = State.ALIVE;

    public Angel(Vector2 position){
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

    public void reset(){
        this.position.set(0, 0);
        this.stateTime = 0f;
        this.facingLeft = true;
        this.alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

    public void kill() {
        this.alive = false;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
