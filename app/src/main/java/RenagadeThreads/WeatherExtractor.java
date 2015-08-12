package RenagadeThreads;

import android.os.AsyncTask;

import Interfaces.Deligator;

// BackGround Task to get DataItem from the web


public class WeatherExtractor extends AsyncTask <String,Void,String >{

    Deligator deligator;

    @Override
    protected String doInBackground(String... params) {
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
