package com.bytedance.applog.event;

import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/applog/event/IEventHandler.class */
public interface IEventHandler {
    int acceptType();

    EventPolicy onReceive(int i, String str, JSONObject jSONObject);
}
