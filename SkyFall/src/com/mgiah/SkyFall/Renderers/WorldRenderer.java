package com.mgiah.SkyFall.Renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mgiah.SkyFall.Models.World;
import com.mgiah.SkyFall.Renderers.Parallax.ParallaxBackground;
import com.mgiah.SkyFall.Renderers.Parallax.ParallaxLayer;

public class WorldRenderer implements Renderer {

    private World world;
    private ParallaxBackground parallaxBackground;
    private Camera camera;
    private SpriteBatch spriteBatch;

    public WorldRenderer(World world){
        this.world = world;
        this.camera = new OrthographicCamera();
        this.spriteBatch = new SpriteBatch();
    }

    @Override
    public void load(AssetManager assetManager) {
        loadParallax(assetManager);
    }

    @Override
    public void render(float delta) {
        //spriteBatch.setProjectionMatrix(camera.combined);

        spriteBatch.begin();
        parallaxBackground.render();
        if(!parallaxBackground.getPositionToStop())
            parallaxBackground.moveY(-0.1f);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();

    }

    private void loadParallax(AssetManager assetManager){
        parallaxBackground = new ParallaxBackground(new ParallaxLayer[]{
                new ParallaxLayer(new TextureRegion[]{
                        new TextureRegion(assetManager.get("Textures/first.png", Texture.class)),
                        new TextureRegion(assetManager.get("Textures/second.png", Texture.class))
                }, 0, 0.1f),
        }, camera, spriteBatch);
    }
}
