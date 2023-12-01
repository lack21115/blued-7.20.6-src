package java.net;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: source-2895416-dex2jar.jar:java/net/CookieHandler.class */
public abstract class CookieHandler {
    private static CookieHandler systemWideCookieHandler;

    public static CookieHandler getDefault() {
        return systemWideCookieHandler;
    }

    public static void setDefault(CookieHandler cookieHandler) {
        systemWideCookieHandler = cookieHandler;
    }

    public abstract Map<String, List<String>> get(URI uri, Map<String, List<String>> map) throws IOException;

    public abstract void put(URI uri, Map<String, List<String>> map) throws IOException;
}
