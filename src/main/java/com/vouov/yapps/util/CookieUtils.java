package com.vouov.yapps.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
    private static final int DEFAULT_AGE = -1;

    /**
     * 
    * @Function: setCookie
    * @Description: 写cookie公共方法
    *
    * @param response
    * @param cookieName
    * @param value
    *
    * @version: v1.0.0
    * @author: panjh
    * @date: 2012-3-2 下午01:35:00 
    *
    * Modification History:
    * Date         Author          Version            Description
    *---------------------------------------------------------*
    * 2012-3-2     panjh           v1.0.0
     */
    public static void setCookie(HttpServletResponse response, String cookieName, String cookieValue) {
        Cookie cookie = new Cookie(cookieName, cookieValue);//设定cookie值
        cookie.setMaxAge(DEFAULT_AGE);//负值关闭浏览器被删除，正值为N秒过期
        //cookie.setDomain(ConfigUtils.getValue("cookie.domain"));// 域名
        cookie.setPath("/");//默认存储路径
        response.addCookie(cookie);
    }

    /**
     * 
    * @Function: getCookie
    * @Description: 获取cookie
    *
    * @param request
    * @param cookieName cookie名称
    * @return cookie不存在返回null，否则返回cookie
    *
    * @version: v1.0.0
    * @author: panjh
    * @date: 2012-3-2 下午01:36:16 
    *
    * Modification History:
    * Date         Author          Version            Description
    *---------------------------------------------------------*
    * 2012-3-2     panjh           v1.0.0
     */
    public static Cookie getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookieName.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }

    /**
     * 删除cookies
    * @Function: delCookie
    * @Description: 删除cookies，可以删除多个
    *
    * @param response
    * @param request
    * @param cookieNames String数组，传入cookie名称
    *
    * @version: v1.0.0
    * @author: panjh
    * @date: 2012-3-2 下午01:48:54 
    *
    * Modification History:
    * Date         Author          Version            Description
    *---------------------------------------------------------*
    * 2012-3-2     panjh           v1.0.0
     */
    public static void delCookie(HttpServletResponse response, HttpServletRequest request, String[] cookieNames) {
        Cookie[] cookie = request.getCookies();
        if (cookieNames != null && cookieNames.length > 0) {
            for (String cookieName : cookieNames) {
                for (Cookie element : cookie) {
                    if (element.getName().equals(cookieName)) {
                        element.setMaxAge(0);
                        element.setPath("/");
                        // element.setDomain(ConfigUtils.getValue("cookie.domain"));
                        response.addCookie(element);
                    }
                }
            }
        }
    }
}
