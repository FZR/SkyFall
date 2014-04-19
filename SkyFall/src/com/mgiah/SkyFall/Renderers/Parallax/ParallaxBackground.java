package com.mgiah.SkyFall.Renderers.Parallax;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class ParallaxBackground {

    private ParallaxLayer[] layers;
    private Camera camera;
    private SpriteBatch batch;
    private float posY = 0;
    private boolean stop = false;

    public ParallaxBackground(ParallaxLayer[] pLayers, Camera pCamera,
                              SpriteBatch pBatch) {
        layers = pLayers;
        camera = pCamera;
        batch = pBatch;
    }

    public void render() {
        for (ParallaxLayer layer : layers) {
            for(int i = 0; i < layer.region.length; i++) {
                if(i == 1){
                    posY = -camera.viewportHeight / 2 - layer.positionY + layer.secondRegionPosition();
                    batch.draw(layer.region[i],
                            -camera.viewportWidth / 2 - layer.positionX,
                            posY);
                    if(posY == 0){
                        stop = true;
                    } else {
                        stop = false;
                    }
                } else {
                    batch.draw(layer.region[i],
                            -camera.viewportWidth / 2 - layer.positionX,
                            -camera.viewportHeight / 2 - layer.positionY);
                }
            }
        }
    }

    public void moveX(float pDelta) {
        for (ParallaxLayer layer : layers) {
            layer.moveX(pDelta);
        }
    }

    public void moveY(float pDelta) {
        for (ParallaxLayer layer : layers) {
            layer.moveY(pDelta);
        }
    }

    public boolean getPositionToStop(){
        return stop;
    }
}