package com.dolphinapps.slangs;

import android.util.Log;

import my.dolphinapps.greendao.model.Favorite;

/**
 * Created by WeaveBytes on 11/19/2015.
 */
public class CustomListAdapter {

    Favorite slang;
    public CustomListAdapter(Favorite s) {
        this.slang = s;
    }

    public Long getid(){
        Log.d(" CustomListAdapter ", " CustomListAdapter"+slang.getMeaning());
        Log.d(" CustomListAdapter ", " CustomListAdapter" + slang.getId());

        return slang.getId();
    }

}
