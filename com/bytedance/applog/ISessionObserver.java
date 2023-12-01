package com.bytedance.applog;

import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/ISessionObserver.class */
public interface ISessionObserver {
    void onSessionBatchEvent(long j, String str, JSONObject jSONObject);

    void onSessionStart(long j, String str);

    void onSessionTerminate(long j, String str, JSONObject jSONObject);
}
