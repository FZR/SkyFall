package com.mgiah.SkyFall.Controllers;

import com.mgiah.SkyFall.Models.MainChar;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class MainCharController {

    enum Keys {
        LEFT, RIGHT
    }

    static Map<Keys, Boolean> keys = new HashMap<Keys, Boolean>();
    static {
        keys.put(Keys.LEFT, false);
        keys.put(Keys.RIGHT, false);
    }
    private MainChar mainChar;

    public MainCharController(MainChar mainChar){
        this.mainChar = mainChar;
    }

    public void update(float delta){
        processInput();
        mainChar.update(delta);
    }

    private boolean processInput(){
        if(keys.get(Keys.LEFT)){
            if(mainChar.getPosition().x > mainChar.getPosToStopLeft()) {
                mainChar.getVelocity().x = -mainChar.getSpeed();
            } else {
                mainChar.getVelocity().x = 0f;
            }
            return true;
        } else if(keys.get(Keys.RIGHT)){
            if(mainChar.getPosition().x < mainChar.getPosToStopRight()){
                mainChar.getVelocity().x = mainChar.getSpeed();
            } else {
                mainChar.getVelocity().x = 0f;
            }
            return true;
        } else {
            mainChar.getVelocity().x = 0;
            return false;
        }
    }

    public void leftPressed(){
        keys.get(keys.put(Keys.LEFT, true));
        mainChar.setFacingLeft(true);
    }

    public void rightPressed(){
        keys.get(keys.put(Keys.RIGHT, true));
        mainChar.setFacingLeft(false);
    }

    public void leftReleased(){
        keys.get((keys.put(Keys.LEFT, false)));
    }

    public void rightReleased(){
        keys.get((keys.put(Keys.LEFT, false)));
    }
}
