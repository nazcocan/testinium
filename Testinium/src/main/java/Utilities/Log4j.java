package Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Log4j {
    private static Logger Log = LogManager.getLogger(Log4j.class.getName());
    public static void info (String message) {
        Log.debug(message);
    }

}
