package com.wordjungle;





import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	
	TextView title;
	Button play,instructions,aboutus,rate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		play=(Button)findViewById(R.id.button2);
		instructions=(Button)findViewById(R.id.button1);
		aboutus=(Button)findViewById(R.id.button3);
		rate=(Button)findViewById(R.id.buttonrate);
		
		play.setOnClickListener(this);
		instructions.setOnClickListener(this);
		aboutus.setOnClickListener(this);
		rate.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
		
		switch(v.getId())
		{
		case R.id.button1 :
			Intent intobj=new Intent(MainActivity.this,Instructions.class);
			startActivity(intobj);
			MainActivity.this.overridePendingTransition(R.anim.slideopen, R.anim.slideclose);
			break;
			
		case R.id.button2 :
			Intent intobj2=new Intent(MainActivity.this,LevelsToPlay.class);
			startActivity(intobj2);
			MainActivity.this.overridePendingTransition(R.anim.slideopen, R.anim.slideclose);
			break;
			
		case R.id.button3 :
			Intent intobj3=new Intent(MainActivity.this,Aboutus.class);
			startActivity(intobj3);
			MainActivity.this.overridePendingTransition(R.anim.slideopen, R.anim.slideclose);
			break;
			
		case R.id.buttonrate :
			launchPlaystore();
		
			
		}
		
	}

	private void launchPlaystore() {
		Uri uri = Uri.parse("market://details?id=" + getApplicationContext().getPackageName());
	    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
	    // To count with Play market backstack, After pressing back button, 
	    // to taken back to our application, we need to add following flags to intent. 
	    goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
	                    Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET |
	                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
	    try {
	        startActivity(goToMarket);
	    } catch (ActivityNotFoundException e) {
	    	Toast.makeText(this, " Unable to find app on Play store", Toast.LENGTH_LONG).show();
	    }
	}
	
}
