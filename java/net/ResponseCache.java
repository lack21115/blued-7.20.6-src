package java.net;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: source-2895416-dex2jar.jar:java/net/ResponseCache.class */
public abstract class ResponseCache {
    private static ResponseCache defaultResponseCache = null;

    public static ResponseCache getDefault() {
        return defaultResponseCache;
    }

    public static void setDefault(ResponseCache responseCache) {
        defaultResponseCache = responseCache;
    }

    public abstract CacheResponse get(URI uri, String str, Map<String, List<String>> map) throws IOException;

    public abstract CacheRequest put(URI uri, URLConnection uRLConnection) throws IOException;
}
