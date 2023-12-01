package com.zk_oaction.adengine.log;

import android.content.Context;
import android.os.BatteryManager;
import android.os.Build;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.zk_oaction.adengine.lk_sdk.d;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/log/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f42086a;
    public String h;
    public String i;
    public String j;
    public int k;
    public String l;
    public String m;
    public int n;
    public String o;
    public String p;
    public String q;
    public boolean s;
    public long r = System.currentTimeMillis();
    public String b = "sdk";

    /* renamed from: c  reason: collision with root package name */
    public String f42087c = "HD_SDK";
    public String d = "409";
    public String e = "4.09.20220518.release";
    public String f = "409";
    public String g = "HD_A1010";

    public a(Context context, int i, String str, String str2, String str3) {
        this.f42086a = i;
        this.p = str;
        this.q = str2;
        this.h = context.getPackageName();
        try {
            this.i = String.valueOf(context.getPackageManager().getPackageInfo(this.h, 0).versionCode);
        } catch (Throwable th) {
            this.i = "0";
        }
        this.j = this.g;
        this.k = Build.VERSION.SDK_INT;
        this.l = Build.BRAND;
        this.m = Build.MODEL;
        this.s = d.a(context);
        this.o = str3;
    }

    public void a(JSONObject jSONObject) {
        jSONObject.put(BatteryManager.EXTRA_LEVEL, this.f42086a);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", this.b);
        jSONObject2.put("id", this.f42087c);
        jSONObject2.put("version", this.d);
        jSONObject2.put("channel", this.g);
        jSONObject2.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, this.e);
        jSONObject2.put("ui_version", this.f);
        jSONObject.put("runner", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("pkg", this.h);
        jSONObject3.put("version", this.i);
        jSONObject3.put("channel", this.j);
        jSONObject.put("mainapp", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("andver", this.k);
        jSONObject4.put("oaid", this.o);
        jSONObject4.put("brand", this.l);
        jSONObject4.put("model", this.m);
        jSONObject4.put("net", this.n);
        jSONObject4.put("iswifi", this.s);
        jSONObject.put("device", jSONObject4);
        jSONObject.put("eid", this.p);
        jSONObject.put("ecnt", this.q);
        jSONObject.put("etime", this.r);
        jSONObject.put("retry", 0);
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject);
        } catch (Throwable th) {
        }
        return jSONObject.toString();
    }
}
