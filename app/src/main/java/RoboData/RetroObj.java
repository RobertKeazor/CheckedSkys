package RoboData;

/*
     ClassModel of DarkSki's API JSON DataItem
 */
public class RetroObj {
    private String timezone;

    private Flags flags;

    public Currently currently;

    private String longitude;

    private String latitude;

    public Hourly hourly;

    private String offset;

    public Daily daily;

    private Minutely minutely;

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Flags getFlags() {
        return flags;
    }

    public void setFlags(Flags flags) {
        this.flags = flags;
    }

    public Currently getCurrently() {
        return currently;
    }

    public void setCurrently(Currently currently) {
        this.currently = currently;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Hourly getHourly() {
        return hourly;
    }

    public void setHourly(Hourly hourly) {
        this.hourly = hourly;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public Daily getDaily() {
        return daily;
    }

    public void setDaily(Daily daily) {
        this.daily = daily;
    }

    public Minutely getMinutely() {
        return minutely;
    }

    public void setMinutely(Minutely minutely) {
        this.minutely = minutely;
    }

    @Override
    public String toString() {
        return "ClassPojo [timezone = " + timezone + ", flags = " + flags + ", currently = " + currently + ", longitude = " + longitude + ", latitude = " + latitude + ", hourly = " + hourly + ", offset = " + offset + ", daily = " + daily + ", minutely = " + minutely + "]";
    }
}
