package com.umeng.analytics.pro;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/an.class */
public class an implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public static final String f26933a = "https://aspect-upush.umeng.com/occa/v1/event/report";
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f26934c;

    public an(String str, JSONObject jSONObject) {
        this.b = str;
        this.f26934c = jSONObject.toString();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (TextUtils.isEmpty(this.f26934c)) {
                return;
            }
            am.b(this.b, this.f26934c.getBytes());
        } catch (Throwable th) {
        }
    }
}
