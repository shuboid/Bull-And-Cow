package com.example.cnb;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class Mainpage extends Activity {
	Button sngl,twpl,hghscore,rul;
	
	Animation shk,skh2;
    MediaPlayer mp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainp);
        shk=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btnanim);
        skh2=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btnanim22);

        sngl=(Button)findViewById(R.id.singl);
        twpl=(Button)findViewById(R.id.twpl);
        hghscore=(Button)findViewById(R.id.high);
        rul=(Button)findViewById(R.id.rules);
        
        
        sngl.startAnimation(shk);
        hghscore.startAnimation(shk);
        twpl.startAnimation(skh2);
        rul.startAnimation(skh2);

        
    	mp=MediaPlayer.create(getApplicationContext(), R.raw.bclk);
///////////////////single player///////////////////////////////////        
       sngl.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			mp.start();
			Intent intent = new Intent(getApplicationContext(), com.example.cnb.Info.class); 
			Mainpage.this.finish();
	    	startActivity(intent);
	    	
			
		}
	});
       
//////////////////////////////two player/////////////////////////////////       
       
       rul.setOnClickListener(new View.OnClickListener() {
   		
   		@Override
   		public void onClick(View v) {
   			mp.start();
   			Intent intent = new Intent(getApplicationContext(), com.example.cnb.RuleoActivity.class); 
			Mainpage.this.finish();
   	    	startActivity(intent);
   			
   		}
   	});
//////////////////////////////////////////////////////////////////////////////       
       
       twpl.setOnClickListener(new View.OnClickListener() {
      		
      		@Override
      		public void onClick(View v) {
      			mp.start();
      			Intent intent = new Intent(getApplicationContext(), com.example.cnb.Twoplayerj.class); 
    			Mainpage.this.finish();
      	    	startActivity(intent);
      			
      		}
      	});
       
       
       
       
       hghscore.setOnClickListener(new View.OnClickListener() {
      		
      		@Override
      		public void onClick(View v) {
      			mp.start();
      			Intent intent = new Intent(getApplicationContext(), com.example.cnb.HighscoreActivity.class); 
    			Mainpage.this.finish();
      	    	startActivity(intent);
      			
      		}
      	});    
       
       
       
       
       
       
       
       
       
       
       
       
       
       
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.mainp, menu);
        return true;
    }
}
