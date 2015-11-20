package com.dolphinapps.slangs;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.revmob.RevMob;
import com.revmob.RevMobTestingMode;
import com.revmob.ads.banner.RevMobBanner;

public class MainActivity extends Activity implements OnItemClickListener {

	private ListView lv;
	private String[] slang;
	RevMob revmob;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_main);


		// Starting RevMob session
		revmob = RevMob.start(this);

		if(AddConfig.DEBUG)
		{
			Toast.makeText(getApplicationContext(), "Warning::debugging", Toast.LENGTH_LONG).show();
		}

		//###### uncomment this while testing in emulator
		if(AddConfig.DEBUG)
		{
			revmob.setTestingMode(RevMobTestingMode.WITH_ADS);
		}

		RevMobBanner banner = revmob.createBanner(this);
		ViewGroup view = (ViewGroup) findViewById(R.id.banner);
		view.addView(banner);

		slang = Config.values;
		lv = (ListView) findViewById(R.id.listView1);


		ArrayAdapter<String> ad = new ArrayAdapter<String>(
				getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,slang);
		lv.setAdapter(ad);
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				lv.getId();
				AddConfig.counter(MainActivity.this, revmob);
				Log.d(" Main Activity "," Main Activity "+AddConfig.click_counter);

				Intent it = new Intent(MainActivity.this, Description.class);
				it.putExtra("pos", arg2);
				startActivity(it);

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub

	}

}// MainActivity
