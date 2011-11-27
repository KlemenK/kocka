
package edu.vecpredstavnost.kocka;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;


public class Zagon extends AndroidApplication {
	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Intent zagonMuzike=new Intent(this, KockaRotirajActivity.class);
		//	this.startActivityForResult(zagonPoti, IZBIRA_POTI_ID);
		//this.startActivity(zagonMuzike);
		initialize(new Kocka(), false);
	}
}
