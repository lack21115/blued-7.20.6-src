package com.tencent.qimei.n;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/n/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f38358a = new d();
    public int b = -1;

    /* renamed from: c  reason: collision with root package name */
    public String f38359c = "";
    public String d = "";

    public String a(String str, String str2) {
        if (str.isEmpty()) {
            return com.tencent.qimei.e.a.a() + str2;
        }
        return str + str2;
    }

    public final void a(JSONObject jSONObject, String str) throws JSONException {
        if (this.b == -1) {
            com.tencent.qimei.c.c.j().r();
            this.b = 1;
        }
        com.tencent.qimei.u.a aVar = new com.tencent.qimei.u.a(str);
        if (TextUtils.isEmpty(this.f38359c)) {
            this.f38359c = aVar.N();
        }
        if (TextUtils.isEmpty(this.d)) {
            this.d = aVar.H();
        }
        String sdkVersion = com.tencent.qimei.u.d.b().getSdkVersion();
        jSONObject.put(e.REPORT_PLATFORM_ID.K, this.b);
        jSONObject.put(e.REPORT_DATA_Q16.K, this.f38359c);
        jSONObject.put(e.REPORT_DATA_Q36.K, this.d);
        jSONObject.put(e.REPORT_APPKEY.K, str);
        jSONObject.put(e.REPORT_SDKVERSION.K, sdkVersion);
    }
}
