package LogaTestNG;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class utilityClass {

    public static String createEmailAddress(){

        long date = new Date().getTime();
        return "testEmail"+date+"@gmail.com";
    }

}

