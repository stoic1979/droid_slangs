package com.dolphinapps.slangs;

import android.app.Dialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;


import com.revmob.RevMob;
import com.revmob.RevMobTestingMode;

import my.dolphinapps.greendao.model.Favorite;


import java.util.ArrayList;
import java.util.List;

public class MainActivityListAdapter extends RecyclerView.Adapter<MainActivityListAdapter.ViewHolder>{
    private List<Favorite> mData;
    private Favorites mainActivity;
    ArrayList<String> arrlist= new ArrayList<String>();
    String mylist;
    public MainActivityListAdapter(List<Favorite> data, Favorites mainActivity) {
        this.mData           =  data;
        this.mainActivity    =  mainActivity;
        Log.d("MainActivityListAdapter","List"+mData);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main_item, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView, mainActivity);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Log.d("slang", "slangs" + mData.get(position).getSlang());
        Log.d("slang", "meaning" + mData.get(position).getMeaning());
        viewHolder.textViewItem.setText(mData.get(position).getSlang());
        viewHolder.textViewPersonName.setText(mData
                .get(position)
                .getMeaning());
        viewHolder.favId = mData.get(position).getId();
        String mylist = mData.get(position).getSlang() +" :  " +mData.get(position).getMeaning();
        arrlist.add(mylist);



    }

    @Override
    public int getItemCount() {
        return mData.size();

    }

     public  void getFavList(){
         Log.d("Favorite List ", "Favorite List" + mData.size());
         Log.d(" slang is"," slang is"+mylist);
     }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public long favId;
        Dialog dialog;
        public Favorites mainActivity;
        public TextView textViewItem;
        public TextView textViewPersonName;
        public View viewParent;
        String shareMyFavSlang;
        RevMob revmob;

        @Override
        public void onClick(View v) {
            dialog = new Dialog(mainActivity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.slangs_popup);
            dialog.show();

            // Starting RevMob session
            revmob = RevMob.start(mainActivity);
            AddConfig.counter(mainActivity, revmob);

            if(AddConfig.DEBUG)
            {
                revmob.setTestingMode(RevMobTestingMode.WITH_ADS);
            }

            final TextView shareSlang = (TextView) dialog
                    .findViewById(R.id.share);
            TextView shareAll = (TextView) dialog
                    .findViewById(R.id.shareAll);

            TextView remove = (TextView) dialog
                    .findViewById(R.id.remove);

            shareSlang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                    shareMyFavSlang  = textViewItem.getText().toString()+" :  "+textViewPersonName.getText().toString();
                    Log.d(" slang is"," slang is"+shareMyFavSlang);
                    mainActivity.shareMySlang(shareMyFavSlang);




                }
            });

            shareAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                    Log.d(" list ", " list " + mylist);
                    Log.d(" list is", " list is" + arrlist);
                    StringBuffer buffer = new StringBuffer();
                    buffer.append(arrlist);
                    buffer.toString();
                    Log.d(" StringBuffer", " lStringBuffer" + buffer.toString());
                    mainActivity.shareMySlang(buffer.toString());



                }
            });

            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                    mainActivity.removeSlang(favId);
                    mainActivity.onResume();
                }
            });



        }

        public ViewHolder(View itemLayoutView, Favorites mainActivity) {
            super(itemLayoutView);
            this.mainActivity = mainActivity;
            textViewItem = (TextView) itemLayoutView.findViewById(R.id.activity_main_item_item);
            textViewPersonName = (TextView) itemLayoutView.findViewById(R.id.activity_main_item_person_name);
            viewParent = (View) itemLayoutView.findViewById(R.id.activity_main_item_parent);
            viewParent.setOnClickListener(this);
        }

        public void setLeaseId(long id) {

            this.favId = id;
        }


    }

}


