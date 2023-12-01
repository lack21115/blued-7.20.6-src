package com.bytedance.sdk.openadsdk;

import android.os.Bundle;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTAdBridge.class */
public interface TTAdBridge {
    String call(int i, Bundle bundle);

    <T> T callMethod(Class<T> cls, int i, Map<String, Object> map);

    <T> T getObj(Class<T> cls);

    <T> T getObj(Class<T> cls, int i, Map<String, Object> map);

    void init(Bundle bundle);

    void removeObj(Object obj);

    void setObj(Object obj);

    void subscribe(TTAdEvent tTAdEvent);

    void unsubscribe(TTAdEvent tTAdEvent);
}
