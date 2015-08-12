package RoboData;

/**
 * Created by rob2cool on 7/30/15.
 */
public class Currently
{
    public String summary;

    public String icon;

    public String pressure;

    public String nearestStormBearing;

    public String cloudCover;

    public String visibility;

    public String apparentTemperature;

    public String precipIntensity;

    public String temperature;

    public String dewPoint;

    public String ozone;

    public String time;

    private String windSpeed;

    private String humidity;

    private String windBearing;

    private String nearestStormDistance;

    private String precipProbability;

    public String getSummary ()
    {
        return summary;
    }

    public void setSummary (String summary)
    {
        this.summary = summary;
    }

    public String getIcon ()
    {
        return icon;
    }

    public void setIcon (String icon)
    {
        this.icon = icon;
    }

    public String getPressure ()
    {
        return pressure;
    }

    public void setPressure (String pressure)
    {
        this.pressure = pressure;
    }

    public String getNearestStormBearing ()
    {
        return nearestStormBearing;
    }

    public void setNearestStormBearing (String nearestStormBearing)
    {
        this.nearestStormBearing = nearestStormBearing;
    }

    public String getCloudCover ()
    {
        return cloudCover;
    }

    public void setCloudCover (String cloudCover)
    {
        this.cloudCover = cloudCover;
    }

    public String getVisibility ()
    {
        return visibility;
    }

    public void setVisibility (String visibility)
    {
        this.visibility = visibility;
    }

    public String getApparentTemperature ()
    {
        return apparentTemperature;
    }

    public void setApparentTemperature (String apparentTemperature)
    {
        this.apparentTemperature = apparentTemperature;
    }

    public String getPrecipIntensity ()
    {
        return precipIntensity;
    }

    public void setPrecipIntensity (String precipIntensity)
    {
        this.precipIntensity = precipIntensity;
    }

    public String getTemperature ()
    {
        return temperature;
    }

    public void setTemperature (String temperature)
    {
        this.temperature = temperature;
    }

    public String getDewPoint ()
    {
        return dewPoint;
    }

    public void setDewPoint (String dewPoint)
    {
        this.dewPoint = dewPoint;
    }

    public String getOzone ()
    {
        return ozone;
    }

    public void setOzone (String ozone)
    {
        this.ozone = ozone;
    }

    public String getTime ()
    {
        return time;
    }

    public void setTime (String time)
    {
        this.time = time;
    }

    public String getWindSpeed ()
    {
        return windSpeed;
    }

    public void setWindSpeed (String windSpeed)
    {
        this.windSpeed = windSpeed;
    }

    public String getHumidity ()
    {
        return humidity;
    }

    public void setHumidity (String humidity)
    {
        this.humidity = humidity;
    }

    public String getWindBearing ()
    {
        return windBearing;
    }

    public void setWindBearing (String windBearing)
    {
        this.windBearing = windBearing;
    }

    public String getNearestStormDistance ()
    {
        return nearestStormDistance;
    }

    public void setNearestStormDistance (String nearestStormDistance)
    {
        this.nearestStormDistance = nearestStormDistance;
    }

    public String getPrecipProbability ()
    {
        return precipProbability;
    }

    public void setPrecipProbability (String precipProbability)
    {
        this.precipProbability = precipProbability;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [summary = "+summary+", icon = "+icon+", pressure = "+pressure+", nearestStormBearing = "+nearestStormBearing+", cloudCover = "+cloudCover+", visibility = "+visibility+", apparentTemperature = "+apparentTemperature+", precipIntensity = "+precipIntensity+", temperature = "+temperature+", dewPoint = "+dewPoint+", ozone = "+ozone+", time = "+time+", windSpeed = "+windSpeed+", humidity = "+humidity+", windBearing = "+windBearing+", nearestStormDistance = "+nearestStormDistance+", precipProbability = "+precipProbability+"]";
    }
}
