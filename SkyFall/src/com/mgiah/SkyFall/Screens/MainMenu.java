package com.mgiah.SkyFall.Screens;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mgiah.SkyFall.MainGameClass;

public class MainMenu implements Screen{
	private OrthographicCamera camera;
	private SpriteBatch batch;
    private Stage stage;
    private Skin skin;
    private MainGameClass mainGameClass;
    private MainMenu mainMenu = this;
    private TextButton resumeButton;
    private Preferences preferences = Gdx.app.getPreferences(MainGameClass.preferencesName);

    public MainMenu(MainGameClass mainGameClass){
        this.mainGameClass = mainGameClass;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        stage = new Stage();
        camera = new OrthographicCamera();
        skin = new Skin(Gdx.files.internal("data/uiskin.json"),
                new TextureAtlas(Gdx.files.internal("data/uiskin.atlas")));
        Gdx.input.setInputProcessor(stage);

        constructMenu();
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.end();

        if(preferences.getBoolean("PAUSED")){
            resumeButton.setVisible(true);
        } else {
            resumeButton.setVisible(false);
        }
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
	public void resize(int width, int height) {
	}


    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
	public void pause() {
        Gdx.input.setInputProcessor(null);
	}

	@Override
	public void resume() {
        Gdx.input.setInputProcessor(stage);
	}

    private void constructMenu(){
        Table table = new Table();
        resumeButton =  new TextButton("Resume", skin);
        TextButton playButton = new TextButton("Play", skin);
        TextButton optionsButton = new TextButton("Options", skin);
        TextButton statsButton = new TextButton("Stats", skin);
        TextButton exitButton = new TextButton("Exit", skin);
        table.setFillParent(true);
        stage.addActor(table);

        table.add(resumeButton).size(80, 32).center().padTop(-15);
        table.row();
        table.add(playButton).size(80, 32).center().padTop(15);  //120, 64
        table.row();
        table.add(optionsButton).size(80, 32).center().padTop(15);
        table.row();
        table.add(statsButton).size(80, 32).center().padTop(15);
        table.row();
        table.add(exitButton).size(80, 32).center().padTop(15);

        playButton.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //System.out.println("pressed!");
                mainGameClass.setScreen(new StoryLineScreen(mainGameClass, skin, mainMenu));
                return super.touchDown(event, x, y, pointer, button);
            }
        });

        exitButton.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
                return super.touchDown(event, x, y, pointer, button);
            }
        });

        resumeButton.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                mainGameClass.setScreen(mainGameClass.getPreviousScreen());
                return super.touchDown(event, x, y, pointer, button);
            }
        });

    }

    @Override
    public void dispose() {
        batch.dispose();
        skin.dispose();
        stage.dispose();
        Gdx.input.setInputProcessor(null);
    }

}
