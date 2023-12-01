package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/k0.class */
public class k0 implements o0 {

    /* renamed from: a  reason: collision with root package name */
    public Context f9152a = b.i();
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f9153c;
    public String d;
    public String e;
    public String f;
    public String g;
    public Boolean h;

    public k0(String str, JSONObject jSONObject, String str2, String str3, long j) {
        this.b = str;
        this.f9153c = jSONObject;
        this.d = str2;
        this.e = str3;
        this.f = String.valueOf(j);
        if (a.i(str2, "oper")) {
            g0 a2 = f0.a().a(str2, j);
            this.g = a2.a();
            this.h = Boolean.valueOf(a2.b());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray;
        z.c("hmsSdk", "Begin to run EventRecordTask...");
        int h = b.h();
        int k = c.k(this.d, this.e);
        if (r0.a(this.f9152a, "stat_v2_1", h * 1048576)) {
            z.c("hmsSdk", "stat sp file reach max limited size, discard new event");
            i0.a().a("", "alltype");
            return;
        }
        q qVar = new q();
        qVar.b(this.b);
        qVar.a(this.f9153c.toString());
        qVar.d(this.e);
        qVar.c(this.f);
        qVar.f(this.g);
        Boolean bool = this.h;
        qVar.e(bool == null ? null : String.valueOf(bool));
        try {
            JSONObject d = qVar.d();
            String a2 = v0.a(this.d, this.e);
            String a3 = h0.a(this.f9152a, "stat_v2_1", a2, "");
            try {
                jSONArray = !TextUtils.isEmpty(a3) ? new JSONArray(a3) : new JSONArray();
            } catch (JSONException e) {
                z.d("hmsSdk", "Cached data corrupted: stat_v2_1");
                jSONArray = new JSONArray();
            }
            jSONArray.put(d);
            h0.b(this.f9152a, "stat_v2_1", a2, jSONArray.toString());
            if (jSONArray.toString().length() > k * 1024) {
                i0.a().a(this.d, this.e);
            }
        } catch (JSONException e2) {
            z.e("hmsSdk", "eventRecord toJson error! The record failed.");
        }
    }
}
