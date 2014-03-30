package com.mgiah.SkyFall.Models;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;

public class Cloud implements Pool.Poolable {
    private Sprite sprite;
    private Vector2 position;
    private Vector2 velocity = new Vector2();

    public Cloud(){

    }

    public void init(Vector2 position){
        this.position = position;
    }

    @Override
    public void reset() {
        this.position.set(0, 0);
        this.velocity.set(0, 0);
        this.sprite = null;
    }

    public void update(float delta){
        position.add(velocity.cpy().scl(delta));
        this.sprite.setPosition(position.x, position.y);
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }
}
