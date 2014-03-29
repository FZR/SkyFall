package com.mgiah.SkyFall.Renderers.Parallax;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ParallaxLayer {
    public TextureRegion[] region;

    float ratioX, ratioY;
    float positionX, positionY;

    public ParallaxLayer(TextureRegion[] pRegion, float pRatioX, float pRatioY) {
        region = pRegion;
        ratioX = pRatioX;
        ratioY = pRatioY;
    }

    protected void moveX(float pDelta) {
        positionX += pDelta * ratioX;
    }

    protected void moveY(float pDelta) {
        positionY += pDelta * ratioY;
    }

    public int secondRegionPosition(){
        return (-region[0].getRegionHeight());
    }
}