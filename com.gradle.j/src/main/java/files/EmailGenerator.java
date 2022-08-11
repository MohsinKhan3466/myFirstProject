package files;

import java.util.Date;

public class EmailGenerator {
    public static String createEmailAddress(){

        long date = new Date().getTime();
        return "testEmail"+date+"@gmail.com";
    }
}
