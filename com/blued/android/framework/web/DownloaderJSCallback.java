package com.blued.android.framework.web;

import androidx.collection.ArrayMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/web/DownloaderJSCallback.class */
public class DownloaderJSCallback {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f10382a = new ArrayMap();
    private JSExecutor b;

    public DownloaderJSCallback(JSExecutor jSExecutor) {
        this.b = jSExecutor;
    }

    public void a(int i, String str, String str2, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("option", str2);
            jSONObject.put("code", str);
            jSONObject.put("progress", i2);
            for (String str3 : this.f10382a.keySet()) {
                String str4 = this.f10382a.get(str3);
                JSExecutor jSExecutor = this.b;
                jSExecutor.a(str3, "javascript:" + str4 + "('" + i + "'," + jSONObject.toString() + ")");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        this.f10382a.put(str, str2);
    }
}
