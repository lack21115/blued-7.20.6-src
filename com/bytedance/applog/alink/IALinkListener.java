package com.bytedance.applog.alink;

import java.util.Map;
import kotlin.Metadata;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/alink/IALinkListener.class */
public interface IALinkListener {
    void onALinkData(Map<String, String> map, Exception exc);

    void onAttributionData(Map<String, String> map, Exception exc);
}
