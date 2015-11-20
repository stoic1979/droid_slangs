package com.dolphinapps.slangs;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import my.dolphinapps.greendao.model.DaoMaster;
import my.dolphinapps.greendao.model.DaoSession;

/**
 * Created by WeaveBytes on 11/19/2015.
 */
public class FavoriteApplication extends Application {

    public DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "slangs_db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
