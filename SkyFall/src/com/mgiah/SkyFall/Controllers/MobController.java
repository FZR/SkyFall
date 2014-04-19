package com.mgiah.SkyFall.Controllers;

import com.mgiah.SkyFall.Models.Angel;
import com.mgiah.SkyFall.Models.Demon;
import com.mgiah.SkyFall.Models.MainChar;
import com.mgiah.SkyFall.Models.World;

public class MobController {

    private Demon demon;
    private Angel angel;
    private MainChar mainChar;
    private World world;

    private static enum OnScreen {
        DEMON, ANGEL
    }
    private OnScreen mobOnScreen = OnScreen.ANGEL;

    public MobController(Demon demon, Angel angel, MainChar mainChar, World world){
        this.demon = demon;
        this.angel = angel;
        this.mainChar = mainChar;
        this.world = world;
    }

    public void update(float delta){
        if(mobOnScreen.equals(OnScreen.ANGEL)){
            if(isInRightPositionToDie(mobOnScreen)){
                angel.kill();
                angel.update(delta);
            } else {
                angel.getPosition().y = world.getSpeed();
                angel.update(delta);
            }
        } else if (mobOnScreen.equals(OnScreen.DEMON)){
            if (isInRightPositionToDie(mobOnScreen)){
                demon.update(delta);
            } else {
                demon.update(delta);
            }
        }
    }

    private boolean isInRightPositionToDie(OnScreen mobOnScreen){
        if(mobOnScreen.equals(OnScreen.ANGEL)){
            if(angel.getPosition().y < mainChar.getPosition().y - mainChar.getTextureHeight()) {
                if (angel.getPosition().x >= mainChar.getPosition().x && angel.getPosition().x <= (mainChar.getTextureWidth() / 2f)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            if(demon.getPosition().y < mainChar.getPosition().y - mainChar.getTextureHeight()) {
                if (demon.getPosition().x >= mainChar.getPosition().x && demon.getPosition().x <= (mainChar.getTextureWidth() / 2f)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

}
