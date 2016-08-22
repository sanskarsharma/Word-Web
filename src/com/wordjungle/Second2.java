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

public class Second2 extends Activity implements AnimationListener {
	
	TextView title,word,Worddisp,scoredisp;
	GridView gv;
	Button submitButton, levelResetButton, NextLevel,del;
	
	MediaPlayer rightAnswer,buzzer, gridItemPress,beep;
	
	Vibrator vib;
	
	View passerforDelete;
	
	Animation moveup;
	 
	public View viewarray[];
	
	 String array[]={"E","P","N","N","N","E","L","E","O","C","A","O","T","G","A","G","R","I","N","T","C","T","O","C","A"};
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
			Second2.this.viewarray[i].setVisibility(View.VISIBLE);
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
		setContentView(R.layout.activity_second2);
		LevelsToPlay.level2.setEnabled(true);
		storage= new String[5];
		storage[0]= "PENTAGON";
		storage[1]= "CIRCLE";
		storage[2]= "TRIANGLE";
		storage[3]= "OCTAGON";
		storage[4]= "CONE";
		
		vib=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
		
		viewarray=new View[30];
		checker = new String[20];
		
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
				
	            Intent lev2= new Intent(Second2.this,Third2.class);
	            startActivity(lev2);
	            Second2.this.overridePendingTransition(R.anim.slideopen, R.anim.slideclose);
			}
		});
		 
		 
		submitButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				// TODO Auto-generated method stub
				
			try{
				
				String ans=word.getText().toString();
				
				flagforsame=0;
				
				for(int i=0;i<15;i++){
					
					if(ans.equals(checker[i])){
						flagforsame=1;
						
						break;
					}
					
				
				}
				
				checker[k]=ans;
				k++;

				if(flagforsame==0){
					
					flag=0;
					
					for( int i=0;i<5;i++)
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
							
						
							if(score<=50)
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
				Second2.this.viewarray[ko]=view;  // this is to store views in an array on itemclick so that can be used in level reset
				ko++;
				
				
				
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
					str="E";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
					break;
				}
				
				case 1:
				{
					str="P";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
					break;
				}
				
				case 2:
				{
					str="N";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
					break;
				}
				
				case 3:
				{
					str="N";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
					break;
				}
				
				case 4:
				{
					str="N";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
					break;
				}
				
				case 5:
				{
					str="E";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
					break;
				}
				
				case 6:
				{
					str="L";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
					break;
				}
				
				case 7:
				{
					str="E";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
					break;
				}
				
				case 8:
				{
					str="O";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
					break;
				}
				
				case 9:
				{
					str="C";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
					break;
				}
				
				case 10:
				{
					str="A";
					sbr= sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
					break;
				}
				
				case 11:
				{
					str="O";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
					break;
				}
				case 12:
				{
					str="T";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
					break;
				}
				
				case 13:
				{
					str="G";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
					break;
				}
				case 14:
				{
					str="A";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
					break;
				}
				
				case 15:
				{
					str="G";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
					break;
				}
				
				case 16:
				{
					str="R";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
					break;
				}
				
				case 17:
				{
					str="I";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
					break;
				}
				
				case 18:
				{
					str="N";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
					break;
				}
				
				case 19:
				{
					str="T";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
					break;
				}
				case 20:
				{
					str="C";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
					break;
				}
				
				
				
				case 21:
				{
					str="T";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
					break;
				}
				case 22:
				{
					str="O";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
					break;
				}
				case 23:
				{
					str="C";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
					break;
				}
				case 24:
				{
					str="A";
					sbr=sbr.append(str);
					word.setText(sbr.toString());
					view.setVisibility(View.INVISIBLE);
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

	

	

