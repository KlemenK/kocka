package edu.vecpredstavnost.kocka;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class KockaRotirajActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	RadioGroup grupa;
	RadioButton r0,r1,r2,r3;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        grupa= (RadioGroup) findViewById(R.id.radioGroup1);
        r0= (RadioButton) findViewById(R.id.radio0);
        r1= (RadioButton) findViewById(R.id.radio1);
        r2= (RadioButton) findViewById(R.id.radio2);
        r3= (RadioButton) findViewById(R.id.radio3);
        
        grupa.setOnClickListener(this);
        r1.setOnClickListener(this);
        r2.setOnClickListener(this);
        r3.setOnClickListener(this);
        r0.setOnClickListener(this);
//        this.closeContextMenu();
//        Intent nova= new Intent(this, ZagonKocke.class);
//        this.startActivity(nova);
        
        
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent nova;
		switch(v.getId()){
		case R.id.radio0:
			Toast t= Toast.makeText(this, "r1", Toast.LENGTH_SHORT);
			//nova= new Intent(this,Kocka.class);
			
			t.show();
		//	this.startActivity(nova);
			break;
		case R.id.radio1:
			Toast t1= Toast.makeText(this, "r2", Toast.LENGTH_SHORT);
			t1.show();
			break;
		case R.id.radio2:
			Toast t2= Toast.makeText(this, "r3", Toast.LENGTH_SHORT);
			t2.show();
			break;
		case R.id.radio3:
			Toast t3= Toast.makeText(this, "r4", Toast.LENGTH_SHORT);
			t3.show();
			break;
			default: System.out.println("hin...."); break;
		}
	}
}