package android.webkit;

import android.webkit.CacheManager;
import java.util.Map;

@Deprecated
/* loaded from: source-4181928-dex2jar.jar:android/webkit/UrlInterceptHandler.class */
public interface UrlInterceptHandler {
    @Deprecated
    PluginData getPluginData(String str, Map<String, String> map);

    @Deprecated
    CacheManager.CacheResult service(String str, Map<String, String> map);
}
