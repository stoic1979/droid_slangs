package com.dolphinapps.slangs;

import android.app.Activity;
import android.util.Log;

import com.revmob.RevMob;

/**
 * Created by WeaveBytes on 11/20/2015.
 */
public class AddConfig {
    public static boolean DEBUG = false;

    public static int click_counter = 0;
    public static int MAX_CLICK_LIMIT = 20;

    public static  void counter(Activity activity,RevMob revMob){
        AddConfig.click_counter++;
        if(AddConfig.click_counter%MAX_CLICK_LIMIT==0){

            if(revMob==null) {
                Log.e("revMob", "****************************revmob NULL**********************************");
                return;
            }

            revMob.showFullscreen(activity);
            AddConfig.click_counter=0;
        }
    }

    public static final  String[]  PRODUCTS    = {"DSORB","FERILIV","GASTROMATE","MEGAKAL","POMEGO",
            "RELYTE","SAPTOS","SUPPORT"};


    public static final  String[]  IMAGE       = {"product1","product2","product3","product4","product5","product6",
            "product7","product8"};

}/*Config*/
