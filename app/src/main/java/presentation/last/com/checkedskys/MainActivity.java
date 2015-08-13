package presentation.last.com.checkedskys;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import Fragmentss.MyFragment;
import Interfaces.Deligator;
import Interfaces.FragInteract;
import Interfaces.UpdateLocation;
import RecycleView.MyAdapter;
import RecycleView.MyNaviAdapter;
import RetroFitGets.OnWeatherReady;
import RetroFitGets.RetroUpdates;
import RoboData.RetroObj;
import butterknife.Bind;
import butterknife.ButterKnife;
import helper_methods.Locator;

import helper_methods.simpleDate;

/**
 * Created by rob2cool on 7/30/15.
 */
public class MainActivity extends ActionBarActivity implements Deligator, OnWeatherReady, UpdateLocation, TextToSpeech.OnInitListener {

    String NAME = "Robert Keazor";
    String EMAIL = "rkeazor@gmail.com";
    boolean Sets = true;
    int PROFILE = R.drawable.aka;
    Bundle bundle;
    double mLon=0;
    double mLat=0;
    Locator gps;
     FragInteract frag;
    @Bind(R.id.RecyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.DrawerLayout)
    android.support.v4.widget.DrawerLayout DrawerLayout;

    @Bind(R.id.my_recycler_view)
    RecyclerView myRecyclerView;
    private Toolbar toolbar;
    String TITLES[] = {"Web News", "Radar Images", "Settings"};
    int ICONS[] = {R.drawable.news,R.drawable.location,R.drawable.sun };
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager
    DrawerLayout Drawer;                                  // Declaring DrawerLayout
    RetroObj retroObj;
    RetroUpdates updateWeather;
    ActionBarDrawerToggle mDrawerToggle;
    ArrayList<String> myDataset = new ArrayList<String>();
    ArrayList<String> myDownSet = new ArrayList<String>();
    public Deligator deligator;
    Context context;
    private TextToSpeech tts;
    private String mTextToSpeech = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_ui_activity);


        tts = new TextToSpeech(getApplicationContext(), this);
        tts.setLanguage(Locale.US);


        ImageView speakerImage = (ImageView) findViewById(R.id.imageView1);
        speakerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts.speak(mTextToSpeech, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        ButterKnife.bind(this);
        context= this;
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        bundle= new Bundle();
        bundle.putString("temp", "");
        bundle.putInt("wallpaper",R.drawable.hotcold);
        MyFragment frag = new MyFragment();
        frag.setArguments(bundle);


        FragmentManager fragmentManager =getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.frames, frag, "frag1");
        transaction.commit();

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView); // Assigning the recyclerView Object to the xml View

        recyclerView.setHasFixedSize(true);

        mAdapter = new MyNaviAdapter(TITLES, ICONS, NAME, EMAIL, PROFILE);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)


        recyclerView.setAdapter(mAdapter);

        mLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);


        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);
        mDrawerToggle = new ActionBarDrawerToggle(this, Drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }


        }; // Drawer Toggle Object Made
        Drawer.setDrawerListener(mDrawerToggle); // Drawer Listener set to the Drawer toggle
        mDrawerToggle.syncState();               // Finally we set the drawer toggle sync State


        gps= new Locator();
       gps.FindMe(MainActivity.this);
        mLon=gps.getmLog();
       mLat=gps.getmLat();
        Log.v ("CHECKERS",""+gps.getmLog());
        Log.v ("Checkers2",""+gps.getmLat());
        //updateWeather = new RetroUpdates(mLon,mLat,this);
        //updateWeather.updateWeatherInfo();


        myRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        myRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter(myDataset, myDownSet ,this);
        myRecyclerView.setAdapter(mAdapter);
        myRecyclerView.setItemAnimator(new DefaultItemAnimator());

        final GestureDetector mGestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener() {

        });
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent motionEvent) {

                View child = recyclerView.findChildViewUnder(motionEvent.getX(),motionEvent.getY());
                int position =recyclerView.getChildPosition(child);

                Log.v("Clicked", "ItemClicked " + "" + position);
                  if (position == 1){
                      Intent i = new Intent (context,webcontroller.class);
                      startActivity(i);
                  }
                 if( position == 2){
                   Intent i = new Intent(context,radarImages.class);
                   startActivity(i);
               }
                Drawer.closeDrawers();


                if(child!=null && mGestureDetector.onTouchEvent(motionEvent)){
                    Drawer.closeDrawers();
                    Toast.makeText(MainActivity.this,"The Item Clicked is: "+recyclerView.getChildPosition(child),Toast.LENGTH_SHORT).show();

                    return true;

                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }


        });



    }


    @Override
    public void onWeatherDataReady(RetroObj data) {
        simpleDate Simple = new simpleDate();
         retroObj =data;
        ArrayList<String> weatherString = new ArrayList<>();
        Long dateValue = Long.valueOf(data.currently.time);
        String s = Simple.simplify(dateValue);
        weatherString.add(s);
        /*myDataset.add(s);
        myDownSet.add(data.currently.summary);
        mAdapter.notifyDataSetChanged();*/

        bundle= new Bundle();
        bundle.putString("temp", ""+data.currently.temperature);
        MyFragment frag = new MyFragment();
        frag.setArguments(bundle);


        mTextToSpeech = "It is " + data.currently.temperature + " degrees.";

        FragmentManager fragmentManager =getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.frames, frag, "frag1");
        transaction.commit();
       /* bundle = new Bundle();
        bundle.putString("temp",""+data.currently.temperature);
        */
        for (int x = 0; x < data.daily.data.length; x++) {
            s = Simple.simplify(Long.valueOf(data.daily.data[x].time));
            myDataset.add(s);
            myDownSet.add(data.daily.data[x].summary);
            mAdapter.notifyDataSetChanged();
        }
        Log.v("TimeDate", data.hourly.data[2].summary);
        Log.v("Date", s);


    }

    @Override
    public void Deligate_Update(int position) {
        Log.v("Deligated", "In Deligation " + position + "");
         int resUpdate = R.drawable.grasss;

        switch (position){

            case 1: resUpdate =R.drawable.hotcold;
            break;
            case  2: resUpdate = R.drawable.waterowl;
            break;
            case 3: resUpdate= R.drawable.waterr;
                break;
            case 4: resUpdate = R.drawable.grasss;
                break;
            case 5: resUpdate =R.drawable.cloudys;
                break;
            case 6: resUpdate =R.drawable.hotcold;
                break;
            case 7: resUpdate=R.drawable.waterowl;
                break;
            case 8:resUpdate=R.drawable.waterr;
            break;
            case 9: resUpdate= R.drawable.hotcold;
                break;
            case 10: resUpdate =R.drawable.waterowl;
                break;

        }
        bundle= new Bundle();
        String temperatureMax = retroObj.daily.data[position].temperatureMax;
        mTextToSpeech = "It is " + temperatureMax + " degrees.";
        bundle.putString("temp", ""+ temperatureMax);
        bundle.putInt("wallpaper", resUpdate);
        MyFragment frag = new MyFragment();
        frag.setArguments(bundle);


        FragmentManager fragmentManager =getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.frames, frag, "frag1");
        transaction.commit();

    }


    @Override
    public void LocationUpdate(Location location) {
        Log.v("Inside","inside it");

        if( mLon != location.getLongitude() || mLat != location.getLatitude())
        {
            mLat =location.getLongitude();
            mLon=location.getLatitude();
          if (Sets) {
              updateWeather = new RetroUpdates(mLon,mLat,this);
              updateWeather.updateWeatherInfo();

          }
            Log.v("Yesss","Yessir");
            Sets=false;
        }

    }

    @Override
    public void onInit(int status) {
        tts.setLanguage(Locale.getDefault());
        tts.setPitch(1.3f);
        tts.setSpeechRate(1f);
    }
}


