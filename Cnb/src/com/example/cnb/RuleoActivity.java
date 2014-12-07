package com.example.cnb;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class RuleoActivity extends Activity {
  
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ruleo);
        
    }
    
    @Override
    public void onBackPressed() {
    	// TODO Auto-generated method stub
		Intent i = new Intent(getApplicationContext(), com.example.cnb.Mainpage.class); 
       RuleoActivity.this.finish();
       startActivity(i);
    	super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.ruleo, menu);
        return true;
    }
}
