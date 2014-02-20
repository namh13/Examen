package com.me.mygdxgame; 

import com.badlogic.gdx.ApplicationListener; 
import com.badlogic.gdx.Gdx; 
import com.badlogic.gdx.graphics.GL10; 
import com.badlogic.gdx.graphics.OrthographicCamera; 
import com.badlogic.gdx.graphics.Texture; 
import com.badlogic.gdx.graphics.Texture.TextureFilter; 
import com.badlogic.gdx.graphics.g2d.Sprite; 
import com.badlogic.gdx.graphics.g2d.SpriteBatch; 
import com.badlogic.gdx.graphics.g2d.TextureRegion; 

public class MyGdxGame implements ApplicationListener { 
	private OrthographicCamera camera; 
	private SpriteBatch batch; 
	private Texture texture; 
	private Sprite sprite; 
	private Texture texture_nave; 
	private Sprite sprite_nave; 
	private Sprite sprite_kill;
	private Texture texture_kill;
	private Sprite sprite_fondo;
	private Texture texture_fondo;
	int Rotacion=0;
	float Translate;
	 
	@Override 
	public void create() {		 
		float w = Gdx.graphics.getWidth(); 
		float h = Gdx.graphics.getHeight(); 
		 
		camera = new OrthographicCamera(1, h/w); 
		batch = new SpriteBatch(); 
	 
		
		texture = new Texture(Gdx.files.internal("data/sol2.png")); 
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear); 
		
		texture_nave = new Texture(Gdx.files.internal("data/nave.png")); 
		texture_kill = new Texture(Gdx.files.internal("data/enemigo.png"));
		texture_fondo = new Texture(Gdx.files.internal("data/fondo.png"));
		
		 
		//TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275); 
		 
		sprite = new Sprite(texture); 
		sprite.setSize(0.3f, 0.3f); 
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2); 
		sprite.setPosition(0.2f,0.09f); 
		//sprite.setPosition(0,0); 
		 
		sprite_nave = new Sprite(texture_nave,128,64); 
		sprite_nave.setPosition(-0.5f,-0.1f); 
		sprite_nave.setSize(0.2f,0.2f); 
		
		sprite_kill = new Sprite(texture_kill,256,256);
		sprite_kill.setPosition(-0.1f,-0.1f);
		sprite_kill.setSize(0.2f,0.2f);
		
		sprite_fondo = new Sprite(texture_fondo,256,256);
		sprite_fondo.setPosition(-0.6f,-0.6f);
		sprite_fondo.setSize(1.2f,1.2f);
	} 
 
	@Override 
	public void dispose() { 
		batch.dispose(); 
		texture.dispose(); 
	} 

	@Override 
	public void render() {		 
		Gdx.gl.glClearColor(0.4f, 0.5f,1 ,1 ); 
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); 
		sprite_kill.setX(Translate);
		
		if(Gdx.input.isTouched())
		{
			Translate-=0.01;
		}

		sprite.setRotation(Rotacion); 
		Rotacion++; 
		 
		batch.setProjectionMatrix(camera.combined); 
		batch.begin(); 
		sprite_fondo.draw(batch); 
		sprite_nave.draw(batch); 
		sprite_kill.draw(batch);
		sprite.draw(batch); 
		batch.end(); 
		 
	} 

	@Override 
	public void resize(int width, int height) { 
	} 

	@Override 
	public void pause() { 
	} 

	@Override 
	public void resume() { 
	} 
}
