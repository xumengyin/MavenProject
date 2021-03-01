package com.xu.mybatis.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {

    public static Logger logger =Logger.getLogger("xuxu");
    public static void d(String msg)
    {
        logger.log(Level.INFO,msg);
    }
}
