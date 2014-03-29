package com.mgiah.SkyFall.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mgiah.SkyFall.MainGameClass;

public class StoryLineScreen implements Screen{

    private MainGameClass mainGameClass;
    private Stage stage;
    private Skin skin;
    private MainMenu mainMenu;

    public StoryLineScreen(MainGameClass mainGameClass, Skin skin, MainMenu mainMenu){
        this.mainGameClass = mainGameClass;
        this.mainMenu = mainMenu;
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
        this.stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        constructMenu();
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
        TextButton playButton = new TextButton("Skip", skin);
        table.setFillParent(true);
        table.bottom().right();
        stage.addActor(table);

        table.add(playButton).size(80, 32).bottom().right().padRight(15).padBottom(15);  //120, 64

        playButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("pressed!");
                mainGameClass.setScreen(new GameScreen(mainGameClass, skin, mainMenu));
                return super.touchDown(event, x, y, pointer, button);
            }
        });

    }
}
