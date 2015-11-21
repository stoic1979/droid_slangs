package com.dolphinapps.slangs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.revmob.RevMob;
import com.revmob.RevMobTestingMode;
import com.revmob.ads.banner.RevMobBanner;

public class Description extends Activity implements OnItemClickListener {

	private ListView lv1;
	private String[] aslang;
	RevMob revmob;
	int position;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.description);

		// Starting RevMob session
		revmob = RevMob.start(this);

		if(AddConfig.DEBUG)
		{
		}

		//###### uncomment this while testing in emulator
		if(AddConfig.DEBUG)
		{
			revmob.setTestingMode(RevMobTestingMode.WITH_ADS);
		}

		RevMobBanner banner = revmob.createBanner(this);
		ViewGroup view = (ViewGroup) findViewById(R.id.banner);
		view.addView(banner);



		lv1 = (ListView) findViewById(R.id.listView);

		Intent it = getIntent();

		position = it.getIntExtra("pos", 0);
		switch (position) {
		case 0:

			ArrayAdapter<String> ad = new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Avalues);
			
			lv1.setAdapter(ad);

			break;
		case 1:

			ArrayAdapter<String> ad1 = new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Bvalues);
			
			lv1.setAdapter(ad1);

			break;
		case 2:

			ArrayAdapter<String> ad2 = new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Cvalues);
			
			lv1.setAdapter(ad2);

			break;
		case 3:

			ArrayAdapter<String> ad3 = new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Dvalues);
			
			lv1.setAdapter(ad3);

			break;
		case 4:

			ArrayAdapter<String> ad4 = new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Evalues);
			
			lv1.setAdapter(ad4);

			break;
		case 5:

			ArrayAdapter<String> ad5 = new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Fvalues);
			
			lv1.setAdapter(ad5);

			break;
		case 6:

			ArrayAdapter<String> ad6 = new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Gvalues);
			
			lv1.setAdapter(ad6);

			break;
		case 7:
			ArrayAdapter<String> ad7 = new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Hvalues);
			
			lv1.setAdapter(ad7);

			break;
		case 8:

			ArrayAdapter<String> ad8 = new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Ivalues);
			
			lv1.setAdapter(ad8);

			break;
		case 9:

			ArrayAdapter<String> ad9 = new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Jvalues);
			
			lv1.setAdapter(ad9);
			break;
		case 10:

			ArrayAdapter<String> ad10 = new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Kvalues);
			
			lv1.setAdapter(ad10);
			break;
		case 11:

			ArrayAdapter<String> ad11 = new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Lvalues);
			
			lv1.setAdapter(ad11);

			break;
		case 12:

			ArrayAdapter<String> ad12= new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Mvalues);
			
			lv1.setAdapter(ad12);

			break;
		case 13:

			ArrayAdapter<String> ad13 = new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Nvalues);
			
			lv1.setAdapter(ad13);

			break;
		case 14:

			ArrayAdapter<String> ad14 = new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Ovalues);
			
			lv1.setAdapter(ad14);

			break;
		case 15:

			ArrayAdapter<String> ad15 = new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Pvalues);
			
			lv1.setAdapter(ad15);

			break;
		case 16:
			ArrayAdapter<String> ad16 = new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Qvalues);
			
			lv1.setAdapter(ad16);

			break;
		case 17:

			ArrayAdapter<String> ad17 = new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Rvalues);
			
			lv1.setAdapter(ad17);

			break;
		case 18:

			ArrayAdapter<String> ad18 = new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Svalues);
			
			lv1.setAdapter(ad18);
			break;
		case 19:

			ArrayAdapter<String> ad19 = new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Tvalues);
			
			lv1.setAdapter(ad19);
			break;
		case 20:

			ArrayAdapter<String> ad20 = new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Uvalues);
			
			lv1.setAdapter(ad20);
			break;
		case 21:

			ArrayAdapter<String> ad21 = new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Vvalues);
			
			lv1.setAdapter(ad21);

			break;
		case 22:

			ArrayAdapter<String> ad22 = new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Wvalues);
			
			lv1.setAdapter(ad22);

			break;
		case 23:

			ArrayAdapter<String> ad23 = new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Xvalues);
			
			lv1.setAdapter(ad23);

			break;
		case 24:

			ArrayAdapter<String> ad24= new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Yvalues);
			
			lv1.setAdapter(ad24);

			break;
		case 25:

			ArrayAdapter<String> ad25 = new ArrayAdapter<String>(
					getApplicationContext(), R.layout.simple_list_item_single_choice,R.id.tv1,Config.Zvalues);
			
			lv1.setAdapter(ad25);

			break;

		}


		lv1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub

				AddConfig.counter(Description.this, revmob);
				Log.d(" Main Activity ", " Main Activity " + AddConfig.click_counter);

				Intent it = new Intent(Description.this, Meaning.class);
				it.putExtra("pos", arg2);
				it.putExtra("posi", position);
				startActivity(it);
			}
		});

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub

	}

}// Description
