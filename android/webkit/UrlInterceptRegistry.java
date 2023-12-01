package android.webkit;

import android.webkit.CacheManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@Deprecated
/* loaded from: source-4181928-dex2jar.jar:android/webkit/UrlInterceptRegistry.class */
public final class UrlInterceptRegistry {
    private static final String LOGTAG = "intercept";
    private static boolean mDisabled = false;
    private static LinkedList mHandlerList;

    private static LinkedList getHandlers() {
        LinkedList linkedList;
        synchronized (UrlInterceptRegistry.class) {
            try {
                if (mHandlerList == null) {
                    mHandlerList = new LinkedList();
                }
                linkedList = mHandlerList;
            } catch (Throwable th) {
                throw th;
            }
        }
        return linkedList;
    }

    @Deprecated
    public static PluginData getPluginData(String str, Map<String, String> map) {
        PluginData pluginData;
        synchronized (UrlInterceptRegistry.class) {
            try {
                if (!urlInterceptDisabled()) {
                    Iterator listIterator = getHandlers().listIterator();
                    while (true) {
                        if (!listIterator.hasNext()) {
                            pluginData = null;
                            break;
                        }
                        PluginData pluginData2 = ((UrlInterceptHandler) listIterator.next()).getPluginData(str, map);
                        if (pluginData2 != null) {
                            pluginData = pluginData2;
                            break;
                        }
                    }
                } else {
                    pluginData = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return pluginData;
    }

    @Deprecated
    public static CacheManager.CacheResult getSurrogate(String str, Map<String, String> map) {
        CacheManager.CacheResult cacheResult;
        synchronized (UrlInterceptRegistry.class) {
            try {
                if (!urlInterceptDisabled()) {
                    Iterator listIterator = getHandlers().listIterator();
                    while (true) {
                        if (!listIterator.hasNext()) {
                            cacheResult = null;
                            break;
                        }
                        CacheManager.CacheResult service = ((UrlInterceptHandler) listIterator.next()).service(str, map);
                        if (service != null) {
                            cacheResult = service;
                            break;
                        }
                    }
                } else {
                    cacheResult = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cacheResult;
    }

    @Deprecated
    public static boolean registerHandler(UrlInterceptHandler urlInterceptHandler) {
        boolean z;
        synchronized (UrlInterceptRegistry.class) {
            try {
                if (getHandlers().contains(urlInterceptHandler)) {
                    z = false;
                } else {
                    getHandlers().addFirst(urlInterceptHandler);
                    z = true;
                }
            } finally {
            }
        }
        return z;
    }

    @Deprecated
    public static void setUrlInterceptDisabled(boolean z) {
        synchronized (UrlInterceptRegistry.class) {
            try {
                mDisabled = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Deprecated
    public static boolean unregisterHandler(UrlInterceptHandler urlInterceptHandler) {
        boolean remove;
        synchronized (UrlInterceptRegistry.class) {
            try {
                remove = getHandlers().remove(urlInterceptHandler);
            } catch (Throwable th) {
                throw th;
            }
        }
        return remove;
    }

    @Deprecated
    public static boolean urlInterceptDisabled() {
        boolean z;
        synchronized (UrlInterceptRegistry.class) {
            try {
                z = mDisabled;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }
}
