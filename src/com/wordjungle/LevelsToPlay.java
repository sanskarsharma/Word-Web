package com.wordjungle;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Switch;

public class LevelsToPlay extends Activity implements OnClickListener
{
    MediaPlayer mp;
	public static Button level1,level2,level3,level4,level5,level6,level7,level8,level9;;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_levels_to_play);
		
		mp=MediaPlayer.create(this, R.raw.itemclick);
		level1=(Button)findViewById(R.id.button1);
		level2=(Button)findViewById(R.id.button2);
		level3=(Button)findViewById(R.id.button3);
		level4=(Button)findViewById(R.id.button4);
		level5=(Button)findViewById(R.id.button5);
		level6=(Button)findViewById(R.id.button6);
		level7=(Button)findViewById(R.id.button7);
		level8=(Button)findViewById(R.id.button8);
		level9=(Button)findViewById(R.id.button9);
		
		level1.setOnClickListener(this);
		level2.setOnClickListener(this);
		level3.setOnClickListener(this);
		level4.setOnClickListener(this);
		level5.setOnClickListener(this);
		level6.setOnClickListener(this);
		level7.setOnClickListener(this);
		level8.setOnClickListener(this);
		level9.setOnClickListener(this);
		
		level2.setEnabled(false);
		level3.setEnabled(false);
		level4.setEnabled(false);
		level5.setEnabled(false);
		level6.setEnabled(false);
		level7.setEnabled(false);
		level8.setEnabled(false);
		level9.setEnabled(false);   
		
		
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.button1 :
			mp.start();
			Intent int1= new Intent(LevelsToPlay.this,First_level.class);
			startActivity(int1);
		 break;
		 
		case R.id.button2 :
			mp.start();
			Intent int2= new Intent(LevelsToPlay.this,Second2.class);
			startActivity(int2);
			 break;
			 
		case R.id.button3 :
			mp.start();
			Intent int3= new Intent(LevelsToPlay.this,Third2.class);
			startActivity(int3);
			 break;
			 
		case R.id.button4 :
			mp.start();
			Intent int4= new Intent(LevelsToPlay.this,Fourth2.class);
			startActivity(int4);
			 break;
			 
		case R.id.button5 :
			mp.start();
			Intent int5= new Intent(LevelsToPlay.this,Fifth2.class);
			startActivity(int5);
			 break;
			 
		case R.id.button6 :
			mp.start();
			Intent int6= new Intent(LevelsToPlay.this,Sixth2.class);
			startActivity(int6);
			 break;
			 
		case R.id.button7 :
			mp.start();
			Intent int7= new Intent(LevelsToPlay.this,Seventh2.class);
			startActivity(int7);
			 break;
			 
		case R.id.button8 :
			mp.start();
			Intent int8= new Intent(LevelsToPlay.this,Eighth2.class);
			startActivity(int8);
			 break;
			 
		case R.id.button9 :
			mp.start();
			Intent int9= new Intent(LevelsToPlay.this,Ninth2.class);
			startActivity(int9);
			 break;
		}
		
	}

	
}
