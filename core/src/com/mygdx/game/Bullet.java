package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Bullet {
    Vector2 position; // position.x,position.y
    float speed ;
    boolean active ;

    public Bullet() {
        position = new Vector2(0,0);
        speed = 14.0f;
        active = false ;
    }

    public  void activation (float x, float y) {
        position.set(x,y);
        active = true;
    }

    public void deactivation() {
        active = false;
    }

    public void updaate () {
        position.x += speed;
        if (position.x > 1280) {
            deactivation();
        }
    }
}
