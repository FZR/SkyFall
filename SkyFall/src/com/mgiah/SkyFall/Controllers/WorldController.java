package com.mgiah.SkyFall.Controllers;

import com.mgiah.SkyFall.Models.World;

public class WorldController {

    private World world;

    public WorldController(World world){
        this.world = world;
    }

    public void setWorldSpeed(float speed){
        world.setSpeed(speed);
    }

    public float getWorldSpeed(){
        return world.getSpeed();
    }
}
