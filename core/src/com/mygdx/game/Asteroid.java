package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {

    Texture texture;
    Vector2 position;
    float speed;

    public Asteroid () {
        texture = new Texture("asteroid64.png");
        position = new Vector2(MathUtils.random(1280,2560),MathUtils.random(0,720));

        speed = MathUtils.random(3.f,7.f);
    }

    public void render (SpriteBatch batch) {
        batch.draw( texture,position.x,position.y);

    }

    public void rebuid (){
        position.set(MathUtils.random(1280,2560),MathUtils.random(0,720));
        speed = MathUtils.random(3.f,7.f);
    }

    public  void  update(){
        position.x = position.x - speed;
        if(position.x < -100) {
            rebuid();
        }
    }
}
