package com.mgiah.SkyFall.Renderers.Parallax;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class ParallaxBackground {

    private ParallaxLayer[] layers;
    private Camera camera;
    private SpriteBatch batch;

    public ParallaxBackground(ParallaxLayer[] pLayers, Camera pCamera,
                              SpriteBatch pBatch) {
        layers = pLayers;
        camera = pCamera;
        batch = pBatch;
    }

    public void render() {
        batch.begin();
        for (ParallaxLayer layer : layers) {
            batch.draw(layer.region, -camera.viewportWidth / 2
                    - layer.positionX, -camera.viewportHeight / 2
                    - layer.positionY);
        }
        batch.end();
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
}