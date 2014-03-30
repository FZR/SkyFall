package com.mgiah.SkyFall.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mgiah.SkyFall.Controllers.WorldController;
import com.mgiah.SkyFall.MainGameClass;
import com.mgiah.SkyFall.Renderers.WorldRenderer;
import com.mgiah.SkyFall.Models.World;

public class GameScreen implements Screen, GestureDetector.GestureListener {

    private MainGameClass mainGameClass;
    private Skin skin;
    private Stage stage;
    private InputMultiplexer inputMultiplexer;
    private World world;
    private WorldController worldController;
    private WorldRenderer worldRenderer;
    private MainMenu mainMenu;
    private Preferences preferences = Gdx.app.getPreferences(MainGameClass.preferencesName);
    private AssetManager assetManager = new AssetManager();
    private SpriteBatch spriteBatch = new SpriteBatch();
    private BitmapFont font = new BitmapFont();



    private static final int GAME_READY = 0;
    private static final int GAME_RUNNING = 1;
    private static final int GAME_PAUSED = 2;
    private static final int GAME_OVER = 3;
    //private static final int GAME_ = ;
    private int state;

    public GameScreen(MainGameClass mainGameClass, Skin skin, MainMenu mainMenu){
        this.mainGameClass = mainGameClass;
        this.mainMenu = mainMenu;
        this.skin = skin;
        stage = new Stage();

        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(stage);
        inputMultiplexer.addProcessor(new GestureDetector(this));
        Gdx.input.setInputProcessor(inputMultiplexer);
        constructMenu();

        world = new World();
        worldController = new WorldController(world);
        worldRenderer = new WorldRenderer(world);
        assetManager.load("Textures/first.png", Texture.class);
        assetManager.load("Textures/second.png", Texture.class);
        assetManager.load("Textures/clouds/clouds.atlas", TextureAtlas.class);
        font.setColor(Color.BLACK);
        font.setScale(2);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
        if(state == GAME_PAUSED){
            state = GAME_RUNNING;
            Gdx.input.setInputProcessor(inputMultiplexer);
        } else {
            state = GAME_READY;
        }
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void pause() {
        if(state == GAME_RUNNING) state = GAME_PAUSED;
    }

    @Override
    public void resume() {
        if(state == GAME_PAUSED) state = GAME_RUNNING;
    }

    @Override
    public void dispose() {
        Gdx.input.setInputProcessor(null);
        skin.dispose();
        stage.dispose();
        worldRenderer.dispose();
    }

    private void constructMenu(){
        Table table = new Table();
        TextButton playButton = new TextButton("||", skin);
        table.setFillParent(true);
        table.top().right();
        stage.addActor(table);

        table.add(playButton).size(25, 25).top().right().padRight(15).padTop(15);  //120, 64

        playButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("pressed!");
                state = GAME_PAUSED;
                //mainGameClass.setScreen(new GameScreen(mainGameClass, skin));
                return super.touchDown(event, x, y, pointer, button);
            }
        });

    }

    private void update(float delta){
        if(delta > 0.1f) delta = 0.1f;

        switch (state){
            case GAME_READY:
                updateReady();
                break;
            case GAME_RUNNING:
                updateRunning(delta);
                break;
            case GAME_PAUSED:
                updatePaused();
                break;
            case GAME_OVER:
                updateGameOver();
                break;
        }
    }

    private void updatePaused(){
        preferences.putBoolean("PAUSED", true);
        preferences.flush();
        mainGameClass.setPreviousScreen(this);
        mainGameClass.setScreen(mainMenu);
    }

    private void updateRunning(float delta){

        worldRenderer.render(delta);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    private void updateReady(){
        if(assetManager.update()){
            worldRenderer.load(assetManager);
            state = GAME_RUNNING;
        } else {
            spriteBatch.begin();
            font.draw(spriteBatch, String.valueOf(assetManager.getProgress()), Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
            spriteBatch.end();
        }
    }

    private void updateGameOver(){

    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {

        if(deltaX < 0){
            System.out.println("Left");
        } else if(deltaX > 0){
            System.out.println("RIGHT");
        }
        //System.out.println("X: " + deltaX + " Y: " + deltaY);
        return true;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }
}
