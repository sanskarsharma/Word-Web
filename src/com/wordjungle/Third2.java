package com.wordjungle;




import java.util.Locale;











import android.app.Activity;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Third2 extends Activity implements AnimationListener {
	
	TextView title,word,Worddisp,scoredisp;
	GridView gv;
	Button submitButton, levelResetButton, NextLevel,del;
	
	MediaPlayer rightAnswer,buzzer, gridItemPress,beep;
	
	Vibrator vib;
	
	Animation moveup;
	 
	public View viewarray[];
	
	View passerforDelete;
	
	String array[]={"O","G","R","T","U","Y","K","B","A","T","B","P","A","S","A","E"};
	String str;
	StringBuffer sbr=new StringBuffer();
	String storage[];
	String checker[];
	
	int score=0;
	int flagforsame=0;
	int flag=0;
	int k=0;
	int ko=0;
	

	public void levelreset()
	{
		score=0;
		reset();// text string (word) reset
		del.setEnabled(true);
		// grid visibility reset
		for(int i=0;i<ko;i++)
		{
			Third2.this.viewarray[i].setVisibility(View.VISIBLE);
		}
		word.setBackgroundResource(R.drawable.textviewstyle);; //textview reset 
		
		//checker array reset
		checker= new String[20];
		k=0;
		//view array reset
		viewarray= new View[30];
		ko=0;
		
		//textviews of disp reset
		Worddisp.setText("");
		scoredisp.setText("");
	}
		
	public void reset()
	{
		int end=sbr.length();
		sbr.delete(0, end);
		word.setText("");
		
	}
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third2);
		LevelsToPlay.level3.setEnabled(true);
		
		storage= new String[5];
		storage[0]= "KEBAB";
		storage[1]= "PASTA";
		storage[2]= "YOGURT";
		
		viewarray=new View[30];
		checker = new String[20];
		
		vib=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
		
		
		moveup= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
		moveup.setAnimationListener(this);
		
		NextLevel=(Button)findViewById(R.id.button3);
		NextLevel.setEnabled(false);
		
		del=(Button)findViewById(R.id.button4);
		
		submitButton=(Button)findViewById(R.id.button1);
		levelResetButton=(Button)findViewById(R.id.button2);
		 
		title=(TextView)findViewById(R.id.textView1);
		word=(TextView)findViewById(R.id.textView2);
		Worddisp=(TextView)findViewById(R.id.textViewWordDisp);
		
		scoredisp=(TextView)findViewById(R.id.textViewScore);
		
		del.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				try
				{
					sbr.deleteCharAt(sbr.length()-1);
					word.setText(sbr.toString());
					passerforDelete.setVisibility(View.VISIBLE);
					del.setEnabled(false);
				}
				catch(Exception e)
				{
					Toast.makeText(getApplicationContext(), "Enter something genius", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
		
		
		
		NextLevel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent lev2 = new Intent(Third2.this,Fourth2.class);
				startActivity(lev2);
				Third2.this.overridePendingTransition(R.anim.slideopen, R.anim.slideclose);
			}
		});
		 
		 
		submitButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				// TODO Auto-generated method stub
				
			try{
				
				String ans=word.getText().toString();
				
				flagforsame=0;
				
				for(int i=0;i<10;i++){
					
					if(ans.equals(checker[i])){
						flagforsame=1;
						
						break;
					}
					
				}
				
				checker[k]=ans;
				k++;

				if(flagforsame==0){
					
					flag=0;
					
					for( int i=0;i<3;i++)
					{
						
						if(ans.equals(storage[i])){
							
							Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
							word.setBackgroundColor(Color.GREEN);
							word.startAnimation(moveup);
							rightAnswer=MediaPlayer.create(getApplicationContext(),R.raw.right);
							rightAnswer.start();
							rightAnswer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
								
								@Override
								public void onCompletion(MediaPlayer mp) {
									// TODO Auto-generated method stub
									mp.release();
									
								}
							});
							
						
							if(score<=30)
								score=score+10;
							if(score>=30)
								NextLevel.setEnabled(true);
							
							flag=1;
							
							
							break;
						
						}
					}
					
					if(flag!=1){
						Toast.makeText(getApplicationContext(), "Wrong word", Toast.LENGTH_SHORT).show();
						
						
						vib.vibrate(500);
						
						
						
						buzzer= MediaPlayer.create(getApplicationContext(), R.raw.buzzer);
						buzzer.start();
						buzzer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
							
							@Override
							public void onCompletion(MediaPlayer mp) {
								// TODO Auto-generated method stub
								
								buzzer.release();
								
							}
						});
						word.setBackgroundColor(Color.RED);
						reset();
					}
				}	
					
				else{
						
					Toast.makeText(getApplicationContext(), "Already Entered", Toast.LENGTH_SHORT).show();
					reset();
						
				}
				
			}// try block ends here
			
			catch(Exception e){
				 		Toast.makeText(getApplicationContext(), "Enter Something", Toast.LENGTH_SHORT).show();
				 	
			}
				
				
				
			}  // onclick() of submit button ends here
		}); // onclick listener of submit buttton ends here
		
		
		levelResetButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				levelreset();
				
			}
		});
		
		
		
		gv=(GridView)findViewById(R.id.g);
		ArrayAdapter<String> obj=new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, array);
		gv.setAdapter(obj);
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				
				passerforDelete=view;
				del.setEnabled(true);
				Third2.this.viewarray[ko]=view;  // this is to store views in an array on itemclick so that can be used in level reset
				ko++;
				view.setVisibility(View.INVISIBLE);
				
				
				gridItemPress=MediaPlayer.create(getApplicationContext(), R.raw.itemclick);
				gridItemPress.start();
				gridItemPress.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
					
					@Override
					public void onCompletion(MediaPlayer mp) {
						// TODO Auto-generated method stub
						
						gridItemPress.release();
						
					}
				});
				

				
				
				
				
				switch(position)
				{
				case 0:
				{
					str="O";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					break;
				}
				
				case 1:
				{
					str="G";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					break;
				}
				
				case 2:
				{
					str="R";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					break;
				}
				
				case 3:
				{
					str="T";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					break;
				}
				
				case 4:
				{
					str="U";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					break;
				}
				
				case 5:
				{
					str="Y";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					break;
				}
				
				case 6:
				{
					str="K";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					break;
				}
				
				case 7:
				{
					str="B";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					break;
				}
				
				case 8:
				{
					str="A";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					break;
				}
				
				case 9:
				{
					str="T";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					break;
				}
				
				case 10:
				{
					str="B";
					sbr= sbr.append(str);
					word.setText(sbr.toString());
					break;
				}
				
				case 11:
				{
					str="P";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					
					break;
				}
				
				case 12:
				{
					str="A";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					
					break;
				}
				
				case 13:
				{
					str="S";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					
					break;
				}
				
				case 14:
				{
					str="A";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					
					break;
				}
				
				case 15:
				{
					str="E";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					
					break;
				}
				
				
				
				
			}
				
				
			
			}// on itemclick() ends here
			
		
		}); // on itemclick Listener ends here
	
		

	}	// end of OnCreate

	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub
		Worddisp.setText(word.getText().toString());
		scoredisp.setText("Score : "+score);
	}

	@Override
	public void onAnimationEnd(Animation animation) {
		// TODO Auto-generated method stub
		reset();
		
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub
		
	}
	
	
}	// end of class

	

	

