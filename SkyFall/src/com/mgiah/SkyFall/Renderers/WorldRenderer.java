package com.mgiah.SkyFall.Renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.mgiah.SkyFall.Models.Cloud;
import com.mgiah.SkyFall.Models.World;
import com.mgiah.SkyFall.Renderers.Parallax.ParallaxBackground;
import com.mgiah.SkyFall.Renderers.Parallax.ParallaxLayer;

import java.util.ArrayList;
import java.util.Random;

public class WorldRenderer implements Renderer {

    private World world;
    private ParallaxBackground parallaxBackground;
    private Camera camera;
    private SpriteBatch spriteBatch;
    private ArrayList<Sprite> cloudSprites = new ArrayList<Sprite>();
    private Array<Cloud> activeClouds = new Array<Cloud>();
    private float startTime;

    public WorldRenderer(World world){
        this.world = world;
        this.camera = new OrthographicCamera();
        this.spriteBatch = new SpriteBatch();
    }

    private final Pool<Cloud> cloudPool = new Pool<Cloud>() {
        @Override
        protected Cloud newObject() {
            return new Cloud();
        }
    };

    @Override
    public void load(AssetManager assetManager) {
        loadParallax(assetManager);
        TextureAtlas cloudsAtlas = assetManager.get("Textures/clouds/clouds.atlas", TextureAtlas.class);
        for(TextureAtlas.AtlasRegion region : cloudsAtlas.getRegions()){
            cloudSprites.add(new Sprite(region));
        }
        startTime = System.currentTimeMillis();

    }

    @Override
    public void render(float delta) {
        if(activeClouds.size <= 35){
            Cloud cloud = cloudPool.obtain();//new Cloud(new Vector2(new Random().nextInt(Gdx.graphics.getWidth()) - 100, -(new Random().nextInt(20) * 10)));
            cloud.init(new Vector2(new Random().nextInt(Gdx.graphics.getWidth()) - 100, -(new Random().nextInt(20) * 10)));
            cloud.setSprite(cloudSprites.get(new Random().nextInt(cloudSprites.size())));
            activeClouds.add(cloud);
        }
        spriteBatch.begin();
        parallaxBackground.render();
        for(int i = 0; i < activeClouds.size; i++){
            activeClouds.get(i).getVelocity().y = i+25;
            if(activeClouds.get(i).getPosition().y > Gdx.graphics.getHeight()){
                cloudPool.free(activeClouds.get(i));
                activeClouds.removeIndex(i);
            }
        }
        for(Cloud cloud : activeClouds){
            cloud.update(delta);
            cloud.getSprite().draw(spriteBatch);
        }
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
