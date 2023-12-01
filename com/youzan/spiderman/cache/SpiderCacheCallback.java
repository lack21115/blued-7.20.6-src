package com.youzan.spiderman.cache;

import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/cache/SpiderCacheCallback.class */
public interface SpiderCacheCallback {
    void onCustomRequestHeader(String str, Map<String, String> map);

    void onStatistic(String str, String str2, Map<String, String> map);

    String onTokenInactive(String str);

    String onTokenNeeded();
}
