package util;

import java.util.logging.*;

public class LoggerUtil {
    public static Logger getLogger(String name) {
        Logger logger = Logger.getLogger(name);
        logger.setUseParentHandlers(true);
        return logger;
    }
}
