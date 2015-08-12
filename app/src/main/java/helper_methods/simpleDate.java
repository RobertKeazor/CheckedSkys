package helper_methods;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by rob2cool on 8/3/15.
 */
public class   simpleDate {

long mTime;



public String simplify (long UxTime)
{
    Calendar mydate = Calendar.getInstance();
   // mydate.setTimeInMillis(UxTime*1000);
    UxTime = UxTime * 1000;
    Date now = new Date(UxTime);
   // String date =mydate.get(Calendar.DAY_OF_MONTH)+"."+mydate.get(Calendar.MONTH)+"."+mydate.get(Calendar.YEAR);
String date = ""+now;



    return date;
}

}
