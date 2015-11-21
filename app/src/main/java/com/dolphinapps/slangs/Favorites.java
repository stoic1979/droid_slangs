package com.dolphinapps.slangs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.revmob.RevMob;
import com.revmob.RevMobTestingMode;
import com.revmob.ads.banner.RevMobBanner;

import my.dolphinapps.greendao.model.DaoSession;
import my.dolphinapps.greendao.model.Favorite;
import my.dolphinapps.greendao.model.FavoriteDao;

import java.util.List;

public class Favorites extends Activity {
    String TAG = " Favorites  ";
    List favoritesList;
    List myfavoriteList;
    RevMob revmob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_favorites);

        revmob = RevMob.start(this);

        if(AddConfig.DEBUG)
        {
            revmob.setTestingMode(RevMobTestingMode.WITH_ADS);
        }

        DaoSession daoSession = ((FavoriteApplication) getApplicationContext()).getDaoSession();
        FavoriteDao favoriteDao = daoSession.getFavoriteDao();
        myfavoriteList = favoriteDao.loadAll();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_activity_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MainActivityListAdapter mainActivityListAdapter = new MainActivityListAdapter(myfavoriteList, this);
        recyclerView.setAdapter(mainActivityListAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        DaoSession daoSession = ((FavoriteApplication) getApplicationContext()).getDaoSession();
        FavoriteDao favoriteDao = daoSession.getFavoriteDao();
        myfavoriteList = favoriteDao.loadAll();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_activity_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MainActivityListAdapter mainActivityListAdapter = new MainActivityListAdapter(myfavoriteList, this);
        recyclerView.setAdapter(mainActivityListAdapter);
    }

    public void shareMySlang(String message) {
        Log.d(" slang ", " slang " + message);
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(shareIntent,
                "Share This Message Via"));
    }

    public void removeSlang(Long id) {

        DaoSession daoSession = ((FavoriteApplication) getApplicationContext()).getDaoSession();
        delSlangFromFavList(daoSession, id);

    }

    public void delSlangFromFavList(DaoSession daoSession, Long id) {
        Log.d("id "," Id is"+id);
        Favorite favorite = new Favorite();
        FavoriteDao favoriteDao = daoSession.getFavoriteDao();
        favoriteDao.deleteByKey(id);
        Toast.makeText(getApplicationContext(), "Removed From Favorites", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_favorites, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
