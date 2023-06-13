package com.jumpingrocket.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class JumpingRocket extends ApplicationAdapter {
	SpriteBatch batch;
	Texture backgroundImg;
	Texture rocketImg;
	Sound jumpSound;
	Music mainMusic;
	OrthographicCamera camera;
	Rectangle rocket;
	

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		backgroundImg = new Texture(Gdx.files.internal("background.jpg"));
		rocketImg = new Texture(Gdx.files.internal("rocket.jpg"));
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		
	    // load the drop sound effect and the rain background "music"
	    jumpSound = Gdx.audio.newSound(Gdx.files.internal("jump.wav"));
//	    mainMusic = Gdx.audio.newMusic(Gdx.files.internal("space.wav"));
	      
	    // start the playback of the background music immediately
//	    mainMusic.setLooping(true);
//	    mainMusic.play();
	    
	    rocket = new Rectangle();
	    rocket.x = 800 / 2 - 64 / 2;
	    rocket.y = 20;
	    rocket.width = 40;
	    rocket.height = 60;

	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(backgroundImg, 0, 0);
		batch.end();
		camera.update();
		
	    // Hapus layar dengan warna latar belakang yang Anda inginkan (jika perlu)
	    Gdx.gl.glClearColor(0, 0, 0, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	    // Gambar latar belakang di (0, 0) (posisi kiri bawah)
	    batch.begin();
	    batch.draw(backgroundImg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	    batch.end();
	    
	    batch.setProjectionMatrix(camera.combined);
	    batch.begin();
//	    batch.draw(rocketImg, rocket.x, rocket.y);
//	    batch.draw(rocketImg, rocket.x, rocket.y, rocket.width, rocket.height);
	    batch.draw(rocketImg, rocket.x, rocket.y, rocket.width / 2, rocket.height / 2, rocket.width, rocket.height, 1, 1, -90, 0, 0, rocketImg.getWidth(), rocketImg.getHeight(), false, false);

	    batch.end();


	    // Tambahkan logika dan kode penggambaran lainnya di sini
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		backgroundImg.dispose();
	}
}
