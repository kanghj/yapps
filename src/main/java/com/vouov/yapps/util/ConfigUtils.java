package com.vouov.yapps.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * User: yuminglong
 * Date: 12-2-20
 * Time: 下午5:09
 */
public class ConfigUtils {
    private static Properties properties = new Properties();
    private static String configFile = "/com/ailk/icrm/selfcare/config.properties";

    private ConfigUtils() {
    }

    private static void load() {
        try {
            InputStream is = ConfigUtils.class.getResourceAsStream(configFile);
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        if (properties.size() < 1) {
            load();
        }
        return properties.getProperty(key);
    }

}
