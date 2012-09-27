package com.vouov.yapps.util;

/**
 * User: yuml
 * Date: 12-9-22
 * Time: 上午1:53
 */
public class SystemUtils {
    public static final boolean MODE_DEBUG;

    static {
        String opts = System.getenv("JAVA_OPTS");
        MODE_DEBUG = opts.contains(" -Xdebug ");
    }

    public static boolean isDebug() {
        return MODE_DEBUG;
    }
}
