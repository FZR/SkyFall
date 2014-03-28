package com.mgiah.SkyFall.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.mgiah.SkyFall.Controllers.WorldController;
import com.mgiah.SkyFall.MainGameClass;
import com.mgiah.SkyFall.Renderers.WorldRenderer;
import com.mgiah.SkyFall.World;

public class GameScreen implements Screen, GestureDetector.GestureListener {

    private MainGameClass mainGameClass;
    private Skin skin;
    private Stage stage;

    public GameScreen(MainGameClass mainGameClass, Skin skin){
        this.mainGameClass = mainGameClass;
        this.skin = skin;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
        stage = new Stage();

        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(stage);
        inputMultiplexer.addProcessor(new GestureDetector(this));
        Gdx.input.setInputProcessor(inputMultiplexer);
        constructMenu();

        World world = new World();
        WorldController worldController = new WorldController(world);
        WorldRenderer worldRenderer = new WorldRenderer(world);
    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    private void constructMenu(){
        Table table = new Table();
        TextButton playButton = new TextButton("||", skin);
        table.setFillParent(true);
        table.top().right();
        stage.addActor(table);

        table.add(playButton).size(80, 32).top().right().padRight(15).padTop(15);  //120, 64

        playButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("pressed!");
                //mainGameClass.setScreen(new GameScreen(mainGameClass, skin));
                return super.touchDown(event, x, y, pointer, button);
            }
        });

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

        System.out.println("X: " + x + " Y: " + y);
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
