package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Background {
    class Star {
        Vector2 position; // position.x,position.y
        float speed ;

        public Star() {
            position = new Vector2(MathUtils.random(0,1280),MathUtils.random(0,720));
            speed = MathUtils.random(0.5f,2f);
        }

        public void update() {
            position.x = position.x -  speed;
            if (position.x < -20) {
                position.x =1280;
                position.y = MathUtils.random(0,720);
                speed = MathUtils.random(0.5f,2f);

            }
        }
    }

    Texture textureSpace;
    Texture textureStar;
    Star[] stars;

    public Background() {
        textureSpace = new Texture("bg.png");
        textureStar  = new Texture("star12.tga");
        stars = new Star[240];
        for (int i =0; i<stars.length;i++) {
            stars[i] = new Star();
        }
    }

    public void render(SpriteBatch batch){
        batch.draw(textureSpace,0,0);
        for (int i=0;i<stars.length;i++){
            float scale = stars[i].speed /2.0f ;
            if (MathUtils.random(0,300) < 2) {
                scale *= 1.8f;
            }
            batch.draw(textureStar,stars[i].position.x,stars[i].position.y,6,6,12,12,scale,scale,0,0,0,12,12,false,false);
        }
    }

    public void update() {
        for (int i =0;i<stars.length;i++) {
            stars[i].update();
        }
    }

}
