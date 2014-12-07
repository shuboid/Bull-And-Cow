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

public class Info extends Activity {
 Button proceed;
 MediaPlayer mp;
 Animation shk;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    	mp=MediaPlayer.create(getApplicationContext(), R.raw.bclk);
    	   shk=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btnanim);
        //   skh2=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btnanim22);
           
           

    proceed=(Button)findViewById(R.id.proceed);
    proceed.startAnimation(shk);
    proceed.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			mp.start();
			Intent intent = new Intent(getApplicationContext(), com.example.cnb.Cnb.class); 
			Info.this.finish();
	    	startActivity(intent);
	    		// TODO Auto-generated method stub
			
		}
	});
    
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_info, menu);
        return true;
    }
}
