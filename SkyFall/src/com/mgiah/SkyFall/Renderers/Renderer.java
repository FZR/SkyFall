package com.mgiah.SkyFall.Renderers;

import com.badlogic.gdx.assets.AssetManager;

public interface Renderer {

    public void load(AssetManager assetManager);

    public void render(float delta);

    public void dispose();
}
