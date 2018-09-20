package utils;

import javax.servlet.http.Cookie;

public class CookieUtil {
    public static Cookie getCookieByName(Cookie[] cookies, String cookieName) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
