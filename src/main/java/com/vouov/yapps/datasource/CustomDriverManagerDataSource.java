package com.vouov.yapps.datasource;

import com.vouov.yapps.util.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


/**
 * User: yuml
 * Date: 12-9-22
 * Time: 上午12:47
 */
public class CustomDriverManagerDataSource extends DriverManagerDataSource {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private String debugUrl;

    public void setDebugUrl(String debugUrl) {
        this.debugUrl = debugUrl;
        if (SystemUtils.isDebug()) {
            logger.info("***** System is debug mode. debug_url = {} ******", debugUrl);
            setUrl(debugUrl);
        }
    }
}
