package com.bytedance.bdtracker;

import android.os.Bundle;
import com.bytedance.applog.AppLog;
import com.volcengine.onekit.service.Analytics;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/e1.class */
public class e1 implements Analytics {
    public void onEventV3(String str, Bundle bundle) {
        AppLog.onEventV3(str, bundle);
    }

    public void onEventV3(String str, JSONObject jSONObject) {
        AppLog.onEventV3(str, jSONObject);
    }
}
