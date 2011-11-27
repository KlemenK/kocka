package edu.vecpredstavnost.kocka;

import java.util.Random;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;

import android.app.Activity;
import android.app.Application;
import android.inputmethodservice.Keyboard.Key;
import android.widget.Toast;


public class Kocka implements ApplicationListener{

	  private Mesh[] faces;
	  private PerspectiveCamera camera;
	  private int gd1=0;
	  private int gd2=0;
	  Music glasba;
	 
	  @Override
	  public void create() {
		  
		  glasba= Gdx.audio.newMusic(Gdx.files.internal("data/beersong.mp3"));
		  
		  glasba.play();
		  glasba.setVolume(0.05f);
		  glasba.setLooping(true);
	    if (faces == null) {
	      faces = new Mesh[6];
	 
	      for (int i = 0; i < 6; i++) {
	        faces[i] = new Mesh(true, 4, 4,
	            new VertexAttribute(Usage.Position, 3, "a_position"),
	            new VertexAttribute(Usage.ColorPacked, 4, "a_color"));
	 
	        faces[i].setIndices(new short[] { 0, 1, 2, 3 });
	      }
	 
	      faces[0].setVertices(new float[] {
	          0.5f, 0.5f, 0.5f, Color.toFloatBits(96, 0, 0, 255),
	          -0.5f, 0.5f, 0.5f, Color.toFloatBits(96, 0, 0, 255),
	          0.5f, -0.5f, 0.5f, Color.toFloatBits(96, 0, 0, 255),
	          -0.5f, -0.5f, 0.5f, Color.toFloatBits(96, 0, 0, 255) });
	 
	      faces[1].setVertices(new float[] {
	          0.5f, 0.5f, -0.5f, Color.toFloatBits(255, 0, 0, 255),
	          -0.5f, 0.5f, -0.5f, Color.toFloatBits(255, 0, 0, 255),
	          0.5f, -0.5f, -0.5f,  Color.toFloatBits(255, 0, 0, 255),
	          -0.5f, -0.5f, -0.5f, Color.toFloatBits(255, 0, 0, 255) });
	 
	      faces[2].setVertices(new float[] {
	          0.5f, 0.5f, -0.5f, Color.toFloatBits(0, 255, 0, 255),
	          -0.5f, 0.5f, -0.5f, Color.toFloatBits(0, 255, 0, 255),
	          0.5f, 0.5f, 0.5f, Color.toFloatBits(0, 255, 0, 255),
	          -0.5f, 0.5f, 0.5f, Color.toFloatBits(0, 255, 0, 255) });
	 
	      faces[3].setVertices(new float[] {
	          0.5f, -0.5f, -0.5f, Color.toFloatBits(0, 96, 0, 255),
	          -0.5f, -0.5f, -0.5f, Color.toFloatBits(0, 96, 0, 255),
	          0.5f, -0.5f, 0.5f, Color.toFloatBits(0, 96, 0, 255),
	          -0.5f, -0.5f, 0.5f,  Color.toFloatBits(0, 96, 0, 255) });
	 
	      faces[4].setVertices(new float[] {
	          0.5f, 0.5f, 0.5f, Color.toFloatBits(0, 0, 255, 255),
	          0.5f, -0.5f, 0.5f, Color.toFloatBits(0, 0, 255, 255),
	          0.5f, 0.5f, -0.5f, Color.toFloatBits(0, 0, 255, 255),
	          0.5f, -0.5f, -0.5f, Color.toFloatBits(0, 0, 255, 255) });
	 
	      faces[5].setVertices(new float[] {
	          -0.5f, 0.5f, 0.5f, 
	          Color.toFloatBits(0, 0, 96, 255),
	          -0.5f, -0.5f, 0.5f, Color.toFloatBits(0, 0, 96, 255),
	          -0.5f, 0.5f, -0.5f, Color.toFloatBits(0, 0, 96, 255),
	          -0.5f, -0.5f, -0.5f, Color.toFloatBits(0, 0, 96, 255) });
	    }
	 
	    Gdx.gl.glEnable(GL10.GL_DEPTH_TEST);
	    
	  }
	 
	  @Override
	  public void resume() { }
	 
	  protected int lastTouchX;
	  protected int lastTouchY;
	 
	  @Override
	  public void render() {
		
		  if(Gdx.input.isKeyPressed(Keys.VOLUME_DOWN)==true){
			  camera.position.z-=0.03f;
			  
		  }
		  if(Gdx.input.isKeyPressed(Keys.VOLUME_UP)==true){
			  camera.position.z+=0.03f;
		  }
		  if(Gdx.input.isKeyPressed(Keys.MENU)==true){
			  
			  Random rand= new Random(System.currentTimeMillis());
			  int ra= rand.nextInt(4);
			  switch(ra){
			  case 0:
				  glasba.dispose();
//				  glasba.stop();
				  glasba= Gdx.audio.newMusic(Gdx.files.internal("data/beersong.mp3"));
				  glasba.play();
				  glasba.setVolume(0.05f);
				  glasba.setLooping(true);
				  break;
			  case 1:
				  glasba.dispose();
//				  glasba.stop();
				  glasba= Gdx.audio.newMusic(Gdx.files.internal("data/danswer.mp3"));
				  glasba.play();
				  glasba.setVolume(0.05f);
				  glasba.setLooping(true);
				  break;
			  case 2:
				  glasba.dispose();
//				  glasba.stop();
				  glasba= Gdx.audio.newMusic(Gdx.files.internal("data/fphone.mp3"));
				  glasba.play();
				  glasba.setVolume(0.05f);
				  glasba.setLooping(true);
				  break;
			  case 3:
				  glasba.dispose();
//				  glasba.stop();
				  glasba= Gdx.audio.newMusic(Gdx.files.internal("data/nbstu.mp3"));
				  glasba.play();
				  glasba.setVolume(0.05f);
				  glasba.setLooping(true);
				  break;
			  case 4:
				  glasba.dispose();
//				  glasba.stop();
				  glasba= Gdx.audio.newMusic(Gdx.files.internal("data/wua.mp3"));
				  glasba.play();
				  glasba.setVolume(0.05f);
				  glasba.setLooping(true);
				  break;
				  default:
					  break;
			  }
		  }
		  
		  
		  
	    if (Gdx.input.justTouched()) {
	      lastTouchX = Gdx.input.getX();
	      lastTouchY = Gdx.input.getY();
	      
	    } else if (Gdx.input.isTouched()) {
	     //levo desno
	    	if(Gdx.input.getX()>lastTouchX){
	    		if((camera.position.x>=0)&&(camera.position.z>0)){
	    			camera.translate(1, 0, -1);
		    		camera.lookAt(0, 0, 0);
	    		}
	    		if((camera.position.x>0)&&(camera.position.z<=0)){
	    			camera.translate(-1, 0, -1);
		    		camera.lookAt(0, 0, 0);
	    		}
	    		if((camera.position.x<=0)&&(camera.position.z<0)){
	    			camera.translate(-1, 0, 1);
		    		camera.lookAt(0, 0, 0);
	    		}
	    		if((camera.position.x<0)&&(camera.position.z>=0)){
	    			camera.translate(1, 0, 1);
		    		camera.lookAt(0, 0, 0);
	    		}
	    		
	    	}
	    	if(Gdx.input.getX()<lastTouchX){
	    		if((camera.position.x<=0)&&(camera.position.z>0)){
	    			camera.translate(-1, 0, -1);
		    		camera.lookAt(0, 0, 0);
	    		}
	    		if((camera.position.x<0)&&(camera.position.z<=0)){
	    			camera.translate(1, 0, -1);
		    		camera.lookAt(0, 0, 0);
	    		}
	    		if((camera.position.x>=0)&&(camera.position.z<0)){
	    			camera.translate(1, 0, 1);
		    		camera.lookAt(0, 0, 0);
	    		}
	    		if((camera.position.x>0)&&(camera.position.z>=0)){
	    			camera.translate(-1, 0, 1);
		    		camera.lookAt(0, 0, 0);
	    		}
	    		
	    	}
	    	//gor dol
	    	if(Gdx.input.getY()<lastTouchY){
	    		if((camera.position.y<=0)&&(camera.position.z>0)){
	    			camera.translate(0, -1, -1);
		    		camera.lookAt(0, 0, 0);
	    		}
	    		if((camera.position.y<0)&&(camera.position.z<=0)){
	    			camera.translate(0, 1, -1);
		    		camera.lookAt(0, 0, 0);
	    		}
	    		if((camera.position.y>=0)&&(camera.position.z<0)){
	    			camera.translate(0, 1, 1);
		    		camera.lookAt(0, 0, 0);
	    		}
	    		if((camera.position.y>0)&&(camera.position.z>=0)){
	    			camera.translate(0, -1, 1);
		    		camera.lookAt(0, 0, 0);
	    		}
	    		
	    		
	    	}
	    	if(Gdx.input.getY()>lastTouchY){
	    		if((camera.position.y>=0)&&(camera.position.z>0)){
	    			camera.translate(0, 1, -1);
		    		camera.lookAt(0, 0, 0);
	    		}
	    		if((camera.position.y>0)&&(camera.position.z<=0)){
	    			camera.translate(0, -1, -1);
		    		camera.lookAt(0, 0, 0);
	    		}
	    		if((camera.position.y<=0)&&(camera.position.z<0)){
	    			camera.translate(0, -1, 1);
		    		camera.lookAt(0, 0, 0);
	    		}
	    		if((camera.position.y<0)&&(camera.position.z>=0)){
	    			camera.translate(0, 1, 1);
		    		camera.lookAt(0, 0, 0);
	    		}
	    		
	    	}
	 
	      lastTouchX = Gdx.input.getX();
	      lastTouchY = Gdx.input.getY();
	    }
	 
	    camera.update();
	    camera.apply(Gdx.gl10);
	 
	    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
	 
	    for (Mesh face : faces) {
	      face.render(GL10.GL_TRIANGLE_STRIP, 0, 4);
	    }
	 
	    try {
	      Thread.sleep(16); // ~60FPS
	    } catch (InterruptedException e) {
	    }
	  }
	 
	  @Override
	  public void resize(int width, int height) {
	    float aspectRatio = (float) width / (float) height;
	    camera = new PerspectiveCamera(67, 2f * aspectRatio, 2f);
	    camera.near = 0.1f;
	    camera.translate(0, 0, 7);
	  }
	 
	  @Override
	  public void pause() { }
	 
	  @Override
	  public void dispose() { }
	}
