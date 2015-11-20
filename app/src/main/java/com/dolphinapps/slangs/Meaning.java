package com.dolphinapps.slangs;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import my.dolphinapps.greendao.model.DaoSession;
import my.dolphinapps.greendao.model.Favorite;
import my.dolphinapps.greendao.model.FavoriteDao;

import java.util.List;

public class Meaning extends Activity implements SimpleGestureFilter.SimpleGestureListener {

	TextView meaning, slang;
	Button btnshare, btnprev, btnnext;
	ImageView fav , menu;
	int position1;
	int position;
	Dialog dialog;
	String TAG = " Meaning ";
    List myfavoriteList;
	private SimpleGestureFilter detector;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.meaning);


		detector  = new SimpleGestureFilter(this, this);
		meaning  = (TextView)  findViewById(R.id.textview1);
		slang = (TextView)  findViewById(R.id.textview2);
		btnshare  = (Button)    findViewById(R.id.btnshare);
		btnprev   = (Button)    findViewById(R.id.btnprev);
		btnnext   = (Button)    findViewById(R.id.btnnext);
		fav       = (ImageView) findViewById(R.id.btnfav);
		menu       = (ImageView) findViewById(R.id.menu);

		Intent it = getIntent();



		// share button
		btnshare.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				switch (position1) {
				case 0:

					share(Config.a1[position]);
					break;
				case 1:
					share(Config.b1[position]);
					break;
				case 2:
					share(Config.c1[position]);
					break;
				case 3:
					share(Config.d1[position]);
					break;
				case 4:
					share(Config.e1[position]);
					break;
				case 5:
					share(Config.f1[position]);
					break;
				case 6:
					share(Config.g1[position]);
					break;
				case 7:
					share(Config.h1[position]);
					break;
				case 8:
					share(Config.i1[position]);
					break;
				case 9:
					share(Config.j1[position]);
					break;
				case 10:
					share(Config.k1[position]);
					break;
				case 11:
					share(Config.l1[position]);
					break;
				case 12:
					share(Config.m1[position]);
					break;
				case 13:
					share(Config.n1[position]);
					break;
				case 14:
					share(Config.o1[position]);
					break;
				case 15:
					share(Config.p1[position]);
					break;
				case 16:
					share(Config.q1[position]);
					break;
				case 17:
					share(Config.r1[position]);
					break;
				case 18:
					share(Config.s1[position]);
					break;
				case 19:
					share(Config.t1[position]);
					break;
				case 20:
					share(Config.u1[position]);
					break;
				case 21:
					share(Config.v1[position]);
					break;
				case 22:
					share(Config.w1[position]);
					break;
				case 23:
					share(Config.x1[position]);
					break;
				case 24:
					share(Config.y1[position]);
					break;
				case 25:
					share(Config.z1[position]);
					break;

				default:
					break;
				}

			}
		});
		// previous button
		btnprev.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				// TODO Auto-generated method stub
				prev();
                changeStar();

			}
		});
		btnnext.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub


                next();
                changeStar();

			}
		});


		fav.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {

            // if(fav.isSelected()){}
                toggleFav();
                /*fav.setBackgroundResource(R.drawable.fav);
				DaoSession daoSession = ((FavoriteApplication)getApplicationContext()).getDaoSession();
				addFavorite(daoSession);*/

			}
		});

		menu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {

            openDialog();

			}
		});


		position = it.getIntExtra("pos", 0);

		position1 = it.getIntExtra("posi", 0);
		Log.e("array" + position1, "array");
		// int position2=it.getIntExtra("position",0);
		switch (position1) {
		case 0:
			meaning.setText(Config.a1[position]);
			slang.setText(Config.Avalues[position]);

			break;
		case 1:
			meaning.setText(Config.b1[position]);
			slang.setText(Config.Bvalues[position]);
			Log.e("arrayB" + position1, "array");
			break;
		case 2:
			meaning.setText(Config.c1[position]);
			slang.setText(Config.Cvalues[position]);
			break;
		case 3:
			meaning.setText(Config.d1[position]);
			slang.setText(Config.Dvalues[position]);
			break;
		case 4:
			meaning.setText(Config.e1[position]);
			slang.setText(Config.Evalues[position]);
			break;
		case 5:
			meaning.setText(Config.f1[position]);
			slang.setText(Config.Fvalues[position]);
			break;
		case 6:
			meaning.setText(Config.g1[position]);
			slang.setText(Config.Gvalues[position]);
			break;
		case 7:
			meaning.setText(Config.h1[position]);
			slang.setText(Config.Hvalues[position]);
			break;
		case 8:
			meaning.setText(Config.i1[position]);
			slang.setText(Config.Ivalues[position]);
			break;
		case 9:
			meaning.setText(Config.j1[position]);
			slang.setText(Config.Jvalues[position]);
			break;
		case 10:
			meaning.setText(Config.k1[position]);
			slang.setText(Config.Kvalues[position]);
			break;
		case 11:
			meaning.setText(Config.l1[position]);
			slang.setText(Config.Lvalues[position]);
			break;
		case 12:
			meaning.setText(Config.m1[position]);
			slang.setText(Config.Mvalues[position]);
			break;
		case 13:
			meaning.setText(Config.n1[position]);
			slang.setText(Config.Nvalues[position]);
			break;
		case 14:
			meaning.setText(Config.o1[position]);
			slang.setText(Config.Ovalues[position]);
			break;
		case 15:
			meaning.setText(Config.p1[position]);
			slang.setText(Config.Pvalues[position]);
			break;
		case 16:
			meaning.setText(Config.q1[position]);
			slang.setText(Config.Qvalues[position]);
			break;
		case 17:
			meaning.setText(Config.r1[position]);
			slang.setText(Config.Rvalues[position]);
			break;
		case 18:
			meaning.setText(Config.s1[position]);
			slang.setText(Config.Svalues[position]);
			break;
		case 19:
			meaning.setText(Config.t1[position]);
			slang.setText(Config.Tvalues[position]);
			break;
		case 20:
			meaning.setText(Config.u1[position]);
			slang.setText(Config.Uvalues[position]);
			break;
		case 21:
			meaning.setText(Config.v1[position]);
			slang.setText(Config.Vvalues[position]);
			break;
		case 22:
			meaning.setText(Config.w1[position]);
			slang.setText(Config.Wvalues[position]);
			break;
		case 23:
			meaning.setText(Config.x1[position]);
			slang.setText(Config.Xvalues[position]);
			break;
		case 24:
			meaning.setText(Config.y1[position]);
			slang.setText(Config.Yvalues[position]);
			break;
		case 25:
			meaning.setText(Config.z1[position]);
			slang.setText(Config.Zvalues[position]);
			break;

		default:
			break;
		}

	}

    @Override
    protected void onResume() {
        super.onResume();

        changeStar();
    }

    public void share(String message) {

		Intent shareIntent = new Intent(Intent.ACTION_SEND);
		shareIntent.setType("text/plain");
		shareIntent.putExtra(Intent.EXTRA_TEXT, message);
		startActivity(Intent.createChooser(shareIntent,
                "Share This Message Via"));
	}

	private void prev() {

		switch (position1) {
		case 0:
			if (position == 0) {
				//textView2.setText(Config.Avalues[position]);
				meaning.setText(Config.a1[position]);
			} else {
				position--;
				slang.setText(Config.Avalues[position]);
				meaning.setText(Config.a1[position]);
			}
			break;
		case 1:
			if (position == 0) {
				meaning.setText(Config.b1[position]);
			} else {
				position--;
				slang.setText(Config.Bvalues[position]);

				meaning.setText(Config.b1[position]);
			}
			break;
		case 2:
			if (position == 0) {
				meaning.setText(Config.c1[position]);
			} else {
				position--;
				slang.setText(Config.Cvalues[position]);

				meaning.setText(Config.c1[position]);
			}
			break;
		case 3:
			if (position == 0) {
				meaning.setText(Config.d1[position]);
			} else {
				position--;
				meaning.setText(Config.d1[position]);
				slang.setText(Config.Dvalues[position]);

			}
			break;
		case 4:
			if (position == 0) {
				meaning.setText(Config.e1[position]);
			} else {
				position--;
				meaning.setText(Config.e1[position]);
				slang.setText(Config.Evalues[position]);

			}
			break;
		case 5:
			if (position == 0) {
				meaning.setText(Config.f1[position]);
			} else {
				position--;
				meaning.setText(Config.f1[position]);
				slang.setText(Config.Fvalues[position]);

			}
			break;
		case 6:
			if (position == 0) {
				meaning.setText(Config.g1[position]);
			} else {
				position--;
				meaning.setText(Config.g1[position]);
				slang.setText(Config.Gvalues[position]);

			}
			break;
		case 7:
			if (position == 0) {
				meaning.setText(Config.h1[position]);
			} else {
				position--;
				meaning.setText(Config.h1[position]);
				slang.setText(Config.Hvalues[position]);

			}
			break;
		case 8:
			if (position == 0) {
				meaning.setText(Config.i1[position]);
			} else {
				position--;
				meaning.setText(Config.i1[position]);
				slang.setText(Config.Ivalues[position]);

			}
			break;
		case 9:
			if (position == 0) {
				meaning.setText(Config.j1[position]);
			} else {
				position--;
				meaning.setText(Config.j1[position]);
				slang.setText(Config.Jvalues[position]);

			}
			break;
		case 10:
			if (position == 0) {
				meaning.setText(Config.k1[position]);
			} else {
				position--;
				meaning.setText(Config.k1[position]);
				slang.setText(Config.Kvalues[position]);

			}
			break;
		case 11:
			if (position == 0) {
				meaning.setText(Config.l1[position]);
			} else {
				position--;
				meaning.setText(Config.l1[position]);
				slang.setText(Config.Lvalues[position]);

			}
			break;
		case 12:
			if (position == 0) {
				meaning.setText(Config.m1[position]);
			} else {
				position--;
				meaning.setText(Config.m1[position]);
				slang.setText(Config.Mvalues[position]);

			}
			break;
		case 13:
			if (position == 0) {
				meaning.setText(Config.n1[position]);
			} else {
				position--;
				meaning.setText(Config.n1[position]);
				slang.setText(Config.Nvalues[position]);

			}
			break;
		case 14:
			if (position == 0) {
				meaning.setText(Config.o1[position]);
			} else {
				position--;
				meaning.setText(Config.o1[position]);
				slang.setText(Config.Ovalues[position]);

			}
			break;
		case 15:
			if (position == 0) {
				meaning.setText(Config.p1[position]);
			} else {
				position--;
				meaning.setText(Config.p1[position]);
				slang.setText(Config.Pvalues[position]);

			}
			break;
		case 16:
			if (position == 0) {
				meaning.setText(Config.q1[position]);
			} else {
				position--;
				meaning.setText(Config.q1[position]);
				slang.setText(Config.Qvalues[position]);

			}
			break;
		case 17:
			if (position == 0) {
				meaning.setText(Config.r1[position]);
			} else {
				position--;
				meaning.setText(Config.r1[position]);
				slang.setText(Config.Rvalues[position]);

			}
			break;
		case 18:
			if (position == 0) {
				meaning.setText(Config.s1[position]);
			} else {
				position--;
				meaning.setText(Config.s1[position]);
				slang.setText(Config.Svalues[position]);

			}
			break;
		case 19:
			if (position == 0) {
				meaning.setText(Config.t1[position]);
			} else {
				position--;
				meaning.setText(Config.t1[position]);
				slang.setText(Config.Tvalues[position]);

			}
			break;
		case 20:
			if (position == 0) {
				meaning.setText(Config.u1[position]);
			} else {
				position--;
				meaning.setText(Config.u1[position]);
				slang.setText(Config.Uvalues[position]);

			}
			break;
		case 21:
			if (position == 0) {
				meaning.setText(Config.v1[position]);
			} else {
				position--;
				meaning.setText(Config.v1[position]);
				slang.setText(Config.Vvalues[position]);

			}
			break;
		case 22:
			if (position == 0) {
				meaning.setText(Config.w1[position]);
			} else {
				position--;
				meaning.setText(Config.w1[position]);
				slang.setText(Config.Wvalues[position]);

			}
			break;
		case 23:
			if (position == 0) {
				meaning.setText(Config.x1[position]);
			} else {
				position--;
				meaning.setText(Config.x1[position]);
				slang.setText(Config.Xvalues[position]);

			}
			break;
		case 24:
			if (position == 0) {
				meaning.setText(Config.y1[position]);
			} else {
				position--;
				meaning.setText(Config.y1[position]);
				slang.setText(Config.Yvalues[position]);

			}
			break;
		case 25:
			if (position == 0) {
				meaning.setText(Config.z1[position]);
			} else {

				position--;
				meaning.setText(Config.z1[position]);
				slang.setText(Config.Zvalues[position]);

			}
			break;

		default:
			break;
		}

	}

	private void next() {
		switch (position1) {
		case 0:
			if (position == Config.a1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.a1[position]);
                slang.setText(Config.Avalues[position]);

			}
			break;
		case 1:
			if (position == Config.b1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.b1[position]);
                slang.setText(Config.Bvalues[position]);


			}
			break;
		case 2:
			if (position == Config.c1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;

				meaning.setText(Config.c1[position]);
                slang.setText(Config.Cvalues[position]);

			}
			break;
		case 3:
			if (position == Config.d1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.d1[position]);
				slang.setText(Config.Dvalues[position]);


			}
			break;
		case 4:
			if (position == Config.e1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.e1[position]);
				slang.setText(Config.Evalues[position]);


			}
			break;
		case 5:
			if (position == Config.f1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.f1[position]);
                slang.setText(Config.Fvalues[position]);


			}
			break;
		case 6:
			if (position == Config.g1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.g1[position]);
                slang.setText(Config.Gvalues[position]);

			}
			break;
		case 7:
			if (position == Config.h1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.h1[position]);
                slang.setText(Config.Hvalues[position]);

			;
			}
			break;
		case 8:
			if (position == Config.i1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.i1[position]);
                slang.setText(Config.Ivalues[position]);

			}
			break;
		case 9:
			if (position == Config.j1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.j1[position]);
				slang.setText(Config.Jvalues[position]);


			}
			break;
		case 10:
			if (position == Config.k1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.k1[position]);
                slang.setText(Config.Kvalues[position]);

			}
			break;
		case 11:
			if (position == Config.l1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.l1[position]);
				slang.setText(Config.Lvalues[position]);


			}
			break;
		case 12:
			if (position == Config.m1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.m1[position]);
				slang.setText(Config.Mvalues[position]);

			}
			break;
		case 13:
			if (position == Config.n1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.n1[position]);
				slang.setText(Config.Nvalues[position]);


			}
			break;
		case 14:
			if (position == Config.o1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.o1[position]);
				slang.setText(Config.Ovalues[position]);


			}
			break;
		case 15:
			if (position == Config.p1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.p1[position]);
				slang.setText(Config.Pvalues[position]);

			}
			break;
		case 16:
			if (position == Config.q1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.q1[position]);
				slang.setText(Config.Qvalues[position]);


			}
			break;
		case 17:
			if (position == Config.r1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.r1[position]);
				slang.setText(Config.Rvalues[position]);


			}
			break;

		case 18:
			if (position == Config.s1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.s1[position]);
				slang.setText(Config.Svalues[position]);


			}
			break;
		case 19:
			if (position == Config.t1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.t1[position]);
				slang.setText(Config.Tvalues[position]);


			}
			break;
		case 20:
			if (position == Config.u1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.u1[position]);
				slang.setText(Config.Uvalues[position]);


			}
			break;
		case 21:
			if (position == Config.v1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.v1[position]);
				slang.setText(Config.Vvalues[position]);


			}
			break;
		case 22:
			if (position == Config.w1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.w1[position]);
				slang.setText(Config.Wvalues[position]);


			}
			break;
		case 23:
			if (position == Config.x1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.x1[position]);
				slang.setText(Config.Xvalues[position]);


			}
			break;
		case 24:
			if (position == Config.y1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.y1[position]);
				slang.setText(Config.Yvalues[position]);


			}
			break;
		case 25:
			if (position == Config.z1.length - 1) {
				btnnext.setEnabled(false);
			} else {
				position++;
				meaning.setText(Config.z1[position]);
				slang.setText(Config.Zvalues[position]);


			}
			break;

		default:
			break;
		}

	}

	@Override
	public void onSwipe(int direction) {
		// TODO Auto-generated method stub
		String str = "";

		switch (direction) {
		case SimpleGestureFilter.SWIPE_RIGHT:
			str = "Swipe Right";
			prev();
			break;
		case SimpleGestureFilter.SWIPE_LEFT:
			str = "Swipe Left";

			next();
			break;

		}
	}
     public  void  changeStar(){
         DaoSession daoSession = ((FavoriteApplication) getApplicationContext()).getDaoSession();
         Favorite favorite = new Favorite();
         favorite.setSlang(slang.getText().toString());
         favorite.setMeaning(meaning.getText().toString());
         FavoriteDao favoriteDao = daoSession.getFavoriteDao();
         List favFromDb = favoriteDao.queryBuilder()
                 .where(FavoriteDao.Properties.Slang.eq(slang.getText().toString()))
                 .list();
         if(favFromDb.size() == 0){
             fav.setBackgroundResource(R.drawable.nofav);

         }
         else
         {
             fav.setBackgroundResource(R.drawable.fav);

         }
     }
	@Override
	public void onDoubleTap() {

	}
   public void toggleFav(){

       DaoSession daoSession = ((FavoriteApplication) getApplicationContext()).getDaoSession();
       Favorite favorite = new Favorite();
       favorite.setSlang(slang.getText().toString());
       favorite.setMeaning(meaning.getText().toString());
       FavoriteDao favoriteDao = daoSession.getFavoriteDao();
       List favFromDb = favoriteDao.queryBuilder()
               .where(FavoriteDao.Properties.Slang.eq(slang.getText().toString()))
               .list();
       if(favFromDb.size() == 0){
           addFavorite(daoSession);
           fav.setBackgroundResource(R.drawable.fav);

       }
       else
       {
           removeFavorite(daoSession,favorite);
           fav.setBackgroundResource(R.drawable.nofav);


       }
       }


	@Override
	public boolean dispatchTouchEvent(MotionEvent me) {
		this.detector.onTouchEvent(me);
		return super.dispatchTouchEvent(me);
	}
	// TODO Auto-generated method stub
   public  void openDialog(){

	   dialog = new Dialog(Meaning.this);
	   dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
	   dialog.setContentView(R.layout.menu);
	   dialog.show();
	   TextView fav = (TextView) dialog
			   .findViewById(R.id.fav);
	   TextView rateus = (TextView) dialog
			   .findViewById(R.id.rateus);

	   TextView about = (TextView) dialog
			   .findViewById(R.id.about);

	   fav.setOnClickListener(new OnClickListener() {
		   @Override
		   public void onClick(View view) {
			   dialog.dismiss();

			   Intent intent = new Intent(Meaning.this,Favorites.class);
			   startActivity(intent);

		   }
	   });

	   rateus.setOnClickListener(new OnClickListener() {
		   @Override
		   public void onClick(View view) {
			   dialog.dismiss();

		   }
	   });

	   about.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View view) {
               dialog.dismiss();

           }
       });


   }

	public  void  addFavorite(DaoSession daoSession){
		Favorite favorite = new Favorite();
		favorite.setSlang(slang.getText().toString());
		favorite.setMeaning(meaning.getText().toString());
		FavoriteDao favoriteDao = daoSession.getFavoriteDao();
        /*check from database if fav already exits*/
        List favFromDb = favoriteDao.queryBuilder()
                .where(FavoriteDao.Properties.Slang.eq(slang.getText().toString()))
                .list();
        Log.d(TAG, " values from db" + favFromDb);
        if(favFromDb.size() == 0){
            favoriteDao.insert(favorite);
            Toast.makeText(getApplicationContext(),"Favorite Added",Toast.LENGTH_LONG).show();
        }
        else
        {
        }

	}

    public  void removeFavorite(DaoSession daoSession, Favorite favorite) {

        Log.d(TAG, " favorite " + favorite.getSlang());
        FavoriteDao favoriteDao = daoSession.getFavoriteDao();
        favoriteDao.queryBuilder()
                .where(FavoriteDao.Properties.Slang.eq(slang.getText().toString())).buildDelete().executeDeleteWithoutDetachingEntities();

    }
}
