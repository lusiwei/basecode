package util;

import javax.servlet.http.Cookie;

public class CookieUtils {
    public static Cookie getCookieByName(Cookie[] cookies, String cookieName){
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals(cookieName)){
                return cookie;
            }
        }
        return null;
    }
}
