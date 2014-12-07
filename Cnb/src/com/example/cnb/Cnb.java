package com.example.cnb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cnb extends Activity {
	TextView t1,t2,t4,t3;
	EditText edt1;
	String a,z="WORD     |	BULL	COW\n";
	Button btn, ans;
	static int score;
	InputStream in;
	BufferedReader reader;
	SharedPreferences shd;
	String[] name={"first","second","third","fourth","five"};
	String[] listnm={"fir","sec","th","fo","fi"};
    Editor editor;
    AlertDialog.Builder builder;
    Animation anfd,shk;
    TextToSpeech tts;
    MediaPlayer mp;
	 
	public
	static String m_Text;
	  int bcnt,ccnt;
		
		
		//////////////////////word-random-pickup//////////////////////
	void startup()
	{
		 try {
				in=this.getAssets().open("4letter.txt");
			    reader = new BufferedReader(new InputStreamReader(in));
			    Random rd =new Random();
				InputStreamReader isr =new InputStreamReader(in);
				isr.skip((6*rd.nextInt(2289)));
				BufferedReader br = new BufferedReader(isr);
				a = br.readLine();	
			
				isr.close();
			 
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		
		  bcnt=0;
		   	 ccnt=0;
		   	 score=100;

	}

////////////////////////////////////////////creating/////////////////////////////////////////////////
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cnb);
       

        t1=(TextView)findViewById(R.id.textView1);
        t2=(TextView)findViewById(R.id.textView2);
       
        t3=(TextView)findViewById(R.id.textView4);
        t4=(TextView)findViewById(R.id.textView3);
        t4.setMovementMethod(new ScrollingMovementMethod());
        edt1=(EditText)findViewById(R.id.editText1);
        ans=(Button)findViewById(R.id.button2);
        btn=(Button)findViewById(R.id.button1);
        startup();
    	mp=MediaPlayer.create(getApplicationContext(), R.raw.bclk);

        ////////////text-to-speech////////////////////////////
        tts =new TextToSpeech(getApplicationContext(), null);
        
        t3.setMovementMethod(ScrollingMovementMethod.getInstance());
        /////////////////////animation/////////////////////////////////
        anfd =AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in );
        
        ///////////////////////alertbox////////////////////////////////////
        
        
        
       
        final EditText inpt =new EditText(this);
        
        builder = new AlertDialog.Builder(this);
        
        builder.setTitle("Hurray!! Enter name you new Highscorer");
        
        

       
        
        
        builder.setView(inpt);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { 
    	    @Override
    	    public void onClick(DialogInterface dialog, int which) {
    	    
    	    	Editable value =inpt.getText();
    	        m_Text = value.toString();
    	        hgscc(m_Text);
    	    }
    	});
    	builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    	    @Override
    	    public void onClick(DialogInterface dialog, int which) {
    	        dialog.cancel();
    	    }
    	});

        //////////////////////////////////////////////////////////////////////////
        
        //////////////////////////////////shared-oreference///////////////////////////
      //   shd = this.getSharedPreferences(      "com.example.cnb", Context.MODE_PRIVATE);
    	shd=this.getPreferences(MODE_MULTI_PROCESS);
          editor = shd.edit();
          
          
        
        	
        	
        	//////////////////////////////////////////
     
     btn.setOnClickListener(new View.OnClickListener() {
		
			
			public void onClick(View v) {

   mp.start();
	        	String b=edt1.getText().toString();
	        	if(b.length()==4)
	        	{
	        	String d=b;
	        	edt1.setText("");
	        	bcnt=0;
				ccnt=0;
				score-=8;
	        	
	        	
	       	 String c=a;
	       	 
	       	 for(int i=0;i<4;i++)
	       	 {
	       		 if(c.charAt(i)==b.charAt(i)){
	       			 bcnt++;
	       			 score+=2;
	       			 c=c.replaceFirst(Character.toString(c.charAt(i)), "*");
	       			 b=b.replaceFirst(Character.toString(b.charAt(i)), "#");
	       			  }
	       	 }
	       			 for(int j=0;j<4;j++){
	       				 for(int k=0;k<4;k++){
	       				 if(c.charAt(j)==b.charAt(k)){
	       					 ccnt++;
	    	       			 score+=1;
	    	       			c=c.replaceFirst(Character.toString(c.charAt(j)), "%s");
	        	    			 b=b.replaceFirst(Character.toString(b.charAt(k)), "&");
	        	    			 continue;	 }}}
	       			 if(bcnt!=4)
	       			 {
	       				
	       				 z=z+String.format("%-13s", d)+"|\t"+bcnt+"\t		"+ccnt+"\n";
	       				tts.speak(bcnt+"Bulls and"+ccnt+"Cows", 0, null);
		       			 t4.setText(""+score);
		       			t3.setText(z); 
		       			
	       			 }
	       			
	       			 else
	       			 {
	       				 t3.setText("\n\nCorrect Answer Hurray!!\n Your score:"+score);
	       				 btn.setOnClickListener(null);
	     				btn.setVisibility(View.INVISIBLE);

	       				
	       				 
	       				 
	       				 if(score>=shd.getInt(name[4], 0))
	       					 {
	       					 
	       					 builder.show();
	       					 }
	       				}}
	        	else {
					Toast.makeText(getApplicationContext(), "Enter 4 letter word!!", Toast.LENGTH_SHORT).show();

				}}
		
		});
     ans.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				
				
	
				mp.start();
				
				String g= "<b><i>Answer is  :"+a+"   Better luck next time</i></b>";
				t3.setText(Html.fromHtml(g));
				
				t3.startAnimation(anfd);
				
				t4.setText("00");
				score=0;
  				 btn.setOnClickListener(null);
                 btn.setVisibility(View.INVISIBLE);
				}
		});


 }
    
    

    
    ///////////////////////////////////////alphabets////////////////////////////////
public void crossing(View v)
{ 
	//bbbb.setBackgroundDrawable(getResources().getDrawable(R.drawable.cross));
v.setVisibility(View.INVISIBLE);
v.getId();

}


////////////////////shared-preference-highscore///////////////////////////////////
public void hgscc(String plname)
{

	       editor.putInt(name[4], score);
	      editor.putString(listnm[4], plname);
	      editor.commit();
		 int j=3,fg=1;
	 
		 do
		 {
			 if(score>shd.getInt(name[j],0))
			 {
				 editor.putInt(name[j+1],shd.getInt(name[j], 0));
				 editor.putString(listnm[j+1],shd.getString(listnm[j], null));
				 editor.putInt(name[j],score);
				 editor.putString(listnm[j],plname);
				 editor.commit();
	         }
			 else{
				 fg=0;
			 }
			 j--;
		 }while(j>=0 || fg==1);
		 
		 
}
////////////////////////////////////////////////////////////////////////////////////////////////////       
@Override
public void onBackPressed() {
	Intent i = new Intent(getApplicationContext(), com.example.cnb.Mainpage.class); 
    Cnb.this.finish();
    startActivity(i);
    super.onBackPressed();
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_cnb, menu);
        return true;
    }
}


