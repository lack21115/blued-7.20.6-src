package com.ss.android.socialbase.downloader.monitor;

import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/monitor/InnerEventListener.class */
public interface InnerEventListener {
    void onEvent(int i, String str, JSONObject jSONObject);

    void onUnityEvent(int i, String str, JSONObject jSONObject);
}
