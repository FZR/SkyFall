package com.mgiah.SkyFall.Controllers;

import com.mgiah.SkyFall.Models.MainChar;

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
        //mainChar.
    }

    private boolean processInput(){
        return false;
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

    }

    public void rightReleased(){

    }
}
