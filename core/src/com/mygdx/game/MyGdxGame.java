package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Background background;
	Hero       hero;
	Asteroid  [] asteroids;
	Texture   textureBullet;
	static Bullet[] bullets;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Background();
		hero = new Hero() ;
		asteroids = new Asteroid[20];
		for (int i =0;i<asteroids.length;i++) {
			asteroids[i] = new Asteroid() ;
		}
		textureBullet = new Texture("bullet64x32.png");
		bullets = new Bullet[200];
		for (int i =0;i<bullets.length;i++) {
			bullets[i] = new Bullet();
		}

	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		background.render(batch);
		hero.render(batch);
		for (int i = 0; i< asteroids.length;i++) {
			asteroids[i].render(batch);
		}
		for (int i = 0; i< bullets.length;i++) {
			if (bullets[i].active) {
				batch.draw(textureBullet,bullets[i].position.x-32,bullets[i].position.y-16);
			}
		}

		batch.end();
	}

	public void update(){
		background.update();
		hero.update();
		for (int i = 0; i< asteroids.length;i++) {
			asteroids[i].update();
		}
		for (int i = 0; i< bullets.length;i++) {
			if (bullets[i].active) {
				bullets[i].updaate();
			}
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
