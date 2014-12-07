package com.example.cnb;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Twoplayerj extends Activity {
     
	EditText pl1ipt;
	
	Button okpl1,cntbtn;
	String apl=null;
	MediaPlayer mp;
	 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twoplayer);
       pl1ipt=(EditText)findViewById(R.id.pl1input);
       okpl1=(Button)findViewById(R.id.okpl1);
   	mp=MediaPlayer.create(getApplicationContext(), R.raw.bclk);
    okpl1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				mp.start();
			apl  = pl1ipt.getText().toString();
			if(apl.length()==4)
			{
				pl1ipt.setText("");
				Intent i = new Intent(getApplicationContext(), com.example.cnb.SecondActivity.class); 
				i.putExtra("wordplayer1", apl);
				
				Twoplayerj.this.finish();
		    	startActivity(i);
		    	overridePendingTransition(R.anim.right_slide_in,R.anim.right_slide_out);
				
				}
			else
				Toast.makeText(getApplicationContext(), "Enter 4 letter word!!", Toast.LENGTH_SHORT).show();
}		
		});
        
        
      
        
        
       
	
    }
   
   

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.twoplayer, menu);
        return true;
    }
}
