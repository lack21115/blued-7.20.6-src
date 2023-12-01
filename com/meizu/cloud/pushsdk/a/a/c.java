package com.meizu.cloud.pushsdk.a.a;

import android.media.TtmlUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/a/a/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final int f10341a;
    private final String b;

    public c(int i, String str) {
        this.f10341a = i;
        this.b = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f10341a);
            jSONObject.put(TtmlUtils.TAG_BODY, this.b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }
}
