package com.bytedance.sdk.openadsdk;

import android.webkit.WebResourceResponse;
import java.util.List;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/IKGUtils.class */
public interface IKGUtils {
    WebResourceResponse findRes(String str, String str2, FindResProxy findResProxy);

    Map<String, Long> getChannelVersion();

    void preload(List<String> list);

    void releaseLoader();
}
