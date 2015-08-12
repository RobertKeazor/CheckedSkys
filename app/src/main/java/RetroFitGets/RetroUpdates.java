package RetroFitGets;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Display;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import Interfaces.Weather_Get;
import RenagadeThreads.WeatherExtractor;
import RoboData.RetroObj;

import helper_methods.Locator;
import presentation.last.com.checkedskys.Constants;
import presentation.last.com.checkedskys.MainActivity;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by rob2cool on 8/2/15.
 */
public class RetroUpdates {
    RestAdapter mRestAdapter;
    WeatherExtractor weatherExtractor;
    String user = Constants.DEVELOPER_KEY_WEATHER;
    RetroObj retroReturn;
    OnWeatherReady mListener;
    Locator gps;
    double mLongititude;
    double mLatitude;

    public RetroUpdates(double lon,double lat,OnWeatherReady listener) {

      mLongititude=lon;
        mLatitude=lat;

        mRestAdapter = new
                RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(Constants.WEATHER_API_BASE_URL)
                .build();

        mListener = listener;
    }

    public void updateWeatherInfo () {

            String lon= "37.8267";
            String lat ="-122.423";
if (mLongititude != 0&& mLatitude!=0){
    lon = ""+mLongititude;
    lat = ""+mLatitude;
    Log.v("Past",""+mLatitude);
}

        Weather_Get weather_get= mRestAdapter.create(Weather_Get.class);
        weather_get.getFeed(user,lon,lat, new Callback<RetroObj>() {
            @Override
            public void success(RetroObj retroObj, Response response) {
                Log.v("Check", retroObj.getLongitude());
                mListener.onWeatherDataReady(retroObj);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.v("ERROR", "Error_Code RED");
            }
        });
    }
}
