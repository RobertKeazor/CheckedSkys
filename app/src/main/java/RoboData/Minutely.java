package RoboData;

/**
 * Created by rob2cool on 7/30/15.
 */

public class Minutely
{
    private String summary;

    private String icon;

    private DataItem[] data;

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

    public DataItem[] getData ()
    {
        return data;
    }

    public void setData (DataItem[] data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [summary = "+summary+", icon = "+icon+", data = "+data+"]";
    }
}