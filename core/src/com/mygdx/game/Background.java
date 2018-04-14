package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Background {
    Texture texureSpace;

    public Background() {
        texureSpace = new Texture("bg.png");
    }

    public void render(SpriteBatch batch){
        batch.draw(texureSpace,0,0);

    }

}
