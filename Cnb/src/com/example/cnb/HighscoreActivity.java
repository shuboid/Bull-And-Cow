package com.example.cnb;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.widget.TextView;

public class HighscoreActivity extends Activity {
    TextView th;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore);
        
     th=(TextView)findViewById(R.id.hght);
     SharedPreferences prefs = this.getSharedPreferences(
    	      "com.example.cnb", Context.MODE_PRIVATE);
    
     String s="\n\n\n\n\t\t\t\t\t\t1."+prefs.getString("fir", "----")+"      "+prefs.getInt("first",0)+
    		 "\n\t\t\t\t\t\t2."+prefs.getString("sec","----")+"      "+prefs.getInt("second",0)+
    		 "\n\t\t\t\t\t\t3."+prefs.getString("th","----")+"       "+prefs.getInt("third",0)+
    		 "\n\t\t\t\t\t\t4."+prefs.getString("fo","----")+"       "+prefs.getInt("fourth",0)+
    		 "\n\t\t\t\t\t\t5."+prefs.getString("fi","----")+"       "+prefs.getInt("five",0);
       th.setText(s);
       
       
       
    }
    @Override
    public void onBackPressed() {
    	// TODO Auto-generated method stub
    	Intent i = new Intent(getApplicationContext(), com.example.cnb.Mainpage.class); 
        HighscoreActivity.this.finish();
        startActivity(i);
    	super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.highscore, menu);
        return true;
    }
}
