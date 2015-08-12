package RoboData;

/**
 * Created by rob2cool on 7/30/15.
 */
public class DataItem
{
    public String time;

    public String summary;

    public String temperatureMax;

    private String precipProbability;

    private String precipIntensity;

    public String getTime ()
    {
        return time;
    }

    public void setTime (String time)
    {
        this.time = time;
    }

    public String getPrecipProbability ()
    {
        return precipProbability;
    }

    public void setPrecipProbability (String precipProbability)
    {
        this.precipProbability = precipProbability;
    }

    public String getPrecipIntensity ()
    {
        return precipIntensity;
    }

    public void setPrecipIntensity (String precipIntensity)
    {
        this.precipIntensity = precipIntensity;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [time = "+time+", precipProbability = "+precipProbability+", precipIntensity = "+precipIntensity+"]";
    }
}
