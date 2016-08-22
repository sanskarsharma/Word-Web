package com.wordjungle;


import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Instructions extends Activity {
	
	TextView ins;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_instructions);
		
		ins=(TextView)findViewById(R.id.textView1);
		 String inst=" Word Web is a word maker game in which the player has to form words based on different theme."+"\n"+"The Objective is to form Words (related to theme) from given set of letters but STRATEGICALLY so, since : "+"\n"+"(1) You can use every given letter ONCE."+"\n"+"(2) You can go back deleting 'not more than one letter at a time' while forming any word. Think Wisely."+"\n"+"(3) On Some levels only a COMBINATION of words can be formed from the letters provided. You can only make the Three words if you choose your words wisely utilizing given letters, otherwise You'll end up making two perfect words and lack of letters for the third. Use your Brain and Reset button repeatedly"+"\n"+"Every  correct word submitted earns 10 points. 30 points are required to unlock every next theme of the game."+"\n"+"Example: Theme-Street , Possible words- Road, Park,...etc"+"\n"+"All the Best!!!";
		ins.setText(inst.toString());
	
	}
	
}
