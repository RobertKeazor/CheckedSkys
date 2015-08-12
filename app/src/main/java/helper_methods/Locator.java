package helper_methods;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import Interfaces.UpdateLocation;

/**
 * Created by rob2cool on 8/6/15.
 */
public class Locator {

    private Location mLocated;
    private double mLog;
    private double mLat;
    private UpdateLocation locates;

    public void FindMe(final Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {

            public void onLocationChanged(Location location) {

                locates= (UpdateLocation)context;
                Log.v("Onlocatin", "" + location.getLatitude());

                locates.LocationUpdate(location);
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            public void onProviderEnabled(String provider) {
            }

            public void onProviderDisabled(String provider) {
            }
        };

// Register the listener with the Location Manager to receive location updates
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
    }

    private void makeUseOfNewLocation(Location location) {

        Log.v("MakeUs", "" + location.getLatitude());
        setmLat(location.getLatitude());
        setmLog(location.getLongitude());

    }


    public Location getmLocated() {
        return mLocated;
    }

    public void setmLocated(Location mLocated) {
        this.mLocated = mLocated;
    }

    public double getmLog() {
        return mLog;
    }

    public void setmLog(double mLog) {
        this.mLog = mLog;
    }

    public double getmLat() {
        return mLat;
    }

    public void setmLat(double mLat) {
        this.mLat = mLat;
    }
}