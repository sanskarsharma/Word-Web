package com.wordjungle;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class Splash extends Activity {
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		Thread soja =new Thread(){
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				
				try{
					sleep(2500);
				}
				catch(Exception e){
					e.printStackTrace();
					
				}
				finally{
					Intent intentObject = new Intent(Splash.this,MainActivity.class);
					startActivity(intentObject);
				}
				
			}
			
		};soja.start();
			
		
	
		
	/*	slash=(Button)findViewById(R.id.button);
		
		slash.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Toast.makeText(getApplicationContext(), "Waiting(hello i am a splash)", Toast.LENGTH_LONG).show();
				
				Thread soja =new Thread(){
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						super.run();
						
						try{
							sleep(3000);
						}
						catch(Exception e){
							e.printStackTrace();
							
						}
						finally{
							Intent intentObject = new Intent(MainActivity.this,Splashagain.class);
							startActivity(intentObject);
						}
						
					}
					
				};soja.start();
				
			}
		});    */
		
	}

	
}
