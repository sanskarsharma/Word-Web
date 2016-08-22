package com.wordjungle;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.text.method.MovementMethod;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;



public class Aboutus extends Activity implements OnGestureListener {
	
	RelativeLayout rel;
	
	private TextSwitcher txtswitcher;
	String textToShow[];
	int messageCount;
	int currentIndex = 1;
	GestureDetectorCompat ges;
	int flingDirectionFlag;
	 int yo=0;
	
	 Animation above;
	 
	 TextView hinto;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_us);
		
		hinto=(TextView)findViewById(R.id.textView1111);
		
		hinto.setText("Swipe Down");
		rel=(RelativeLayout)findViewById(R.id.relaboutus);
		txtswitcher=(TextSwitcher)findViewById(R.id.textSwitcher1);
		this.ges= new GestureDetectorCompat(this, this);
		
		rel.setBackgroundResource(R.drawable.aboutusyo);
		 
		
		txtswitcher.setFactory(new ViewFactory() {
			
			@Override
			public View makeView() {
				// TODO Auto-generated method stub
				
				
				 TextView myText = new TextView(Aboutus.this);
	                myText.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
	                myText.setTextSize(12);
	                myText.setTextColor(Color.WHITE);
	                myText.setBackgroundColor(Color.TRANSPARENT);
	                return myText;
				
				
			}
		}); 
				/*// create new textView and set the properties like clolr, size etc
                TextView myText = new TextView(Aboutus.this);
                myText.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                myText.setTextSize(36);
                myText.setTextColor(Color.BLUE);
                return myText;*/
		
		
		// Declare the in and out animations and initialize them 
		  above = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoomin);
      Animation in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
        Animation out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeout);
       
       
        // set the animation type of textSwitcher
       
        	 txtswitcher.setInAnimation(in);
             txtswitcher.setOutAnimation(out);   
       
          
		
        textToShow= new String[3];
        textToShow[0]="Designed and Developed By: "+"\n"+"Astha Batra, "+" Univ. Roll no.- 3332214011"+"\n"+" Sanskar Sharma, "+" Univ. Roll no.- 3332214046"+"\n"+"Shri Shankaracharya Institute of Professional Management and Technology, Raipur";
        textToShow[1]="Guided by : "+"\n"+"Innolat Technologies and RCPL";
        textToShow[2]="Disclaimer:"+"\n"+"This Android App has been developed as a part of our training project for our Engineering Course and is only developed to enhance and demonstrate our Android Application Developement skills."+"\n"+"The Content present in this app has been gathered from various internet sources. We do not guarranty the validity and correctness of the same, neither do we claim any copyrights for any content. ";
        
        messageCount= textToShow.length;
        
	}




	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		
		this.ges.onTouchEvent(event);
		
		return super.onTouchEvent(event);
	}




	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(yo==0){
			rel.setBackgroundResource(R.drawable.aboutusyoyo);
			yo=1;
		}
			
		else if(yo==1){
			rel.setBackgroundResource(R.drawable.aboutusyo);
			yo=0;
		}
		
		
		//Toast.makeText(getApplicationContext(), "this works", Toast.LENGTH_LONG).show();
		
		return true;
	}




	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		
		return false;
	}




	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
		
		
	}




	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		
		
		if(velocityY>300){ 
			hinto.setText("Swipe Down For More");
			currentIndex--;
			flingDirectionFlag=1;
			if(currentIndex==-1)
				currentIndex=messageCount-1;
			txtswitcher.setText(textToShow[currentIndex].toString());  
			 
		}
		else if(velocityY<-300){
	/*		currentIndex++;
			if(currentIndex==messageCount)
				currentIndex=0;
			txtswitcher.setText(textToShow[currentIndex].toString());   */
			txtswitcher.startAnimation(above);
		}
		
		return true;
	}

	
}
