package com.example.cnb;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {
	 TextView pl2score;
     TextView pl2disp ;
     EditText pl2iptedt;
     Button btnpl2 ;
	
	
	String aps,zpl="WORD	 |	BULL	COW\n";
	int score2=100,pl2bcnt=0,pl2ccnt=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
         btnpl2 = (Button)findViewById(R.id.but);
         pl2score = (TextView)findViewById(R.id.pl2score);
         pl2disp = (TextView)findViewById(R.id.pl2disp);
         pl2iptedt = (EditText)findViewById(R.id.pl2inpt);
         
         
         if (savedInstanceState == null) {
           Bundle  extras = getIntent().getExtras();
             if(extras == null) {
                 aps= null;
             } else {
                 aps= extras.getString("wordplayer1");
             }
         } else {
             aps= (String) savedInstanceState.getSerializable("wordplayer1");
         }
         
         
 btnpl2.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View v) {


	        	String b=pl2iptedt.getText().toString();
	        	if(b.length()==4)
	        	{
	        	String d=b;
	        	pl2iptedt.setText("");
	        	pl2bcnt=0;
				pl2ccnt=0;
				score2-=8;
	        	
	        	
	       	 String c=aps;
	       	 
	       	 for(int i=0;i<4;i++)
	       	 {
	       		 if(c.charAt(i)==b.charAt(i)){
	       			pl2bcnt++;
	       			 score2+=2;
	       			 c=c.replaceFirst(Character.toString(c.charAt(i)), "*");
	       			 b=b.replaceFirst(Character.toString(b.charAt(i)), "#");
	       			  }
	       	 }
	       			 for(int j=0;j<4;j++){
	       				 for(int k=0;k<4;k++){
	       				 if(c.charAt(j)==b.charAt(k)){
	       					 pl2ccnt++;
	    	       			 score2+=1;
	    	       			c=c.replaceFirst(Character.toString(c.charAt(j)), "%");
	        	    			 b=b.replaceFirst(Character.toString(b.charAt(k)), "&");
	        	    			 continue;	 }}}
	       			 if(pl2bcnt!=4)
	       			 {
	       				 zpl=zpl+d+"\t |   \t  "+pl2bcnt+"\t      "+pl2ccnt+"\n";
		       			 pl2score.setText(""+score2);
		       			pl2disp.setText(zpl); 
		       			
	       			 }
	       			
	       			 else
	       			 {
	       				 pl2disp.setText("\n\nCorrect Answer Hurray!!\n Your score:"+score2);
	       				btnpl2.setOnClickListener(null);
	       				
	       				
	       			 }
	       			 
				
				
			}
	        	else
					Toast.makeText(getApplicationContext(), "Enter 4 letter word!!", Toast.LENGTH_SHORT).show();
}
		});
        
        
        
        
        
        
        
        
        
    }
    
    public void crossing(View v)
    { 
    	//bbbb.setBackgroundDrawable(getResources().getDrawable(R.drawable.cross));
    v.setVisibility(View.INVISIBLE);
    v.getId();

    }
    
    @Override
    public void onBackPressed() {
    	Intent i = new Intent(getApplicationContext(), com.example.cnb.Mainpage.class); 
        SecondActivity.this.finish();
        startActivity(i);
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.second, menu);
        return true;
    }
}
