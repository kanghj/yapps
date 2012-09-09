package com.vouov.yapps.util;

/**
 * User: yuminglong
 * Date: 12-2-21
 * Time: 上午11:00
 */
public class TokenUtils {
    private static final String TOOKEN_NAME = "user-token";
    private static final int LIVE_CYCLE = 1800000;

    /**
     * 读取解析UserToken
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     *//*
    public static ProductSetBean readToken(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ProductSetBean productSetBean = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (TOOKEN_NAME.equalsIgnoreCase(cookie.getName())) {
                    //decrypt the cookie value
                    String cookieValue = SecUtils.decryptText(cookie.getValue());
                    ObjectMapper objectMapper = new ObjectMapper();
                    //convert the json to object
                    productSetBean = objectMapper.readValue(cookieValue, ProductSetBean.class);
                    //validate the token expire and crc
                    if (Calendar.getInstance().getTimeInMillis() > (productSetBean.getTimestamp() + LIVE_CYCLE)) {
                        //productSetBean = null;
                    } else {
                        if (!productSetBean.getCrc().endsWith(TextUtils.sha1Text(objectMapper.writeValueAsString(productSetBean.getProductBeans())))) {
                            productSetBean = null;
                        }
                    }
                    //update the cookie
                    writeToken(response, productSetBean);
                    break;
                }
            }
        }
        return productSetBean;
    }

    *//**
     * @param response
     * @param productSetBean
     * @throws Exception
     *//*
    public static void writeToken(HttpServletResponse response, ProductSetBean productSetBean) throws Exception {
        if (productSetBean != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            String crc = TextUtils.sha1Text(objectMapper.writeValueAsString(productSetBean.getProductBeans()));
            productSetBean.setCrc(crc);
            productSetBean.setTimestamp(Calendar.getInstance().getTimeInMillis());
            String cookieValue = SecUtils.encryptText(objectMapper.writeValueAsString(productSetBean));
            response.addCookie(newCookie(TOOKEN_NAME, cookieValue));
        } else {
            //delete the cookie
            response.addCookie(newCookie(TOOKEN_NAME, null, 0));
        }
    }

    public static Cookie newCookie(String name, String value) {
        return newCookie(name, value, -1);
    }

    public static Cookie newCookie(String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        //cookie.setDomain(ConfigUtils.getValue(ConfigUtils.getValue("cookie.domain")));
        cookie.setPath("/");
        return cookie;
    }
*/
}
