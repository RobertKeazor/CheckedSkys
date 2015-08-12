package Interfaces;

import RoboData.RetroObj;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/*
     RetroFit InterFace For Weather DataItem from
     DarkSkies API.37.8267,-122.423
 */
public interface Weather_Get {

    @GET("/{user}/{lon},{lat}")
    public void getFeed(@Path("user") String user,@Path("lon")String lon,
                        @Path("lat")String lat, Callback<RetroObj> response);
}
