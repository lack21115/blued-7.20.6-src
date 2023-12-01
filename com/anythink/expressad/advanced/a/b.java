package com.anythink.expressad.advanced.a;

import android.content.Context;
import android.hardware.Camera;
import android.os.BatteryManager;
import android.text.TextUtils;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.ak;
import com.anythink.core.common.k.d;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.t;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/a/b.class */
public final class b {
    public String d;
    public String e;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;

    /* renamed from: c  reason: collision with root package name */
    public String f6991c = "android";

    /* renamed from: a  reason: collision with root package name */
    public String f6990a = k.b();
    public String b = k.c();
    public String f = d.f();

    public b(Context context) {
        String str;
        this.e = d.d(context);
        int a2 = k.a();
        this.h = String.valueOf(a2);
        this.i = k.a(context, a2);
        this.j = d.i();
        this.k = com.anythink.expressad.foundation.b.a.b().f();
        this.l = com.anythink.expressad.foundation.b.a.b().e();
        this.m = String.valueOf(t.f(context));
        this.n = String.valueOf(t.e(context));
        this.p = String.valueOf(t.c(context));
        if (context.getResources().getConfiguration().orientation == 2) {
            this.o = Camera.Parameters.SCENE_MODE_LANDSCAPE;
        } else {
            this.o = Camera.Parameters.SCENE_MODE_PORTRAIT;
        }
        IExHandler b = n.a().b();
        if (b != null) {
            str = b.fillCDataParam("at_device1|||at_device2|||at_device3");
            str.replace("at_device1", "").replace("at_device2", "").replace("at_device3", "");
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            this.d = "";
            this.g = "";
            return;
        }
        String[] split = str.split("\\|\\|\\|");
        try {
            this.d = split[0];
        } catch (Throwable th) {
        }
        try {
            this.g = split[2];
        } catch (Throwable th2) {
        }
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device", this.f6990a);
            jSONObject.put("system_version", this.b);
            jSONObject.put("network_type", this.h);
            jSONObject.put("network_type_str", this.i);
            jSONObject.put("device_ua", this.j);
            ak L = n.a().L();
            if (L != null) {
                jSONObject.put("has_wx", L.a());
                jSONObject.put("integrated_wx", L.b());
                StringBuilder sb = new StringBuilder();
                sb.append(L.c());
                jSONObject.put("opensdk_ver", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(L.d());
                jSONObject.put("wx_api_ver", sb2.toString());
            }
            jSONObject.put("plantform", this.f6991c);
            jSONObject.put(com.anythink.core.common.k.c.b("ZGV2aWNlX2ltZWk="), this.d);
            jSONObject.put("android_id", this.e);
            jSONObject.put("google_ad_id", this.f);
            jSONObject.put("oaid", this.g);
            jSONObject.put("appkey", this.k);
            jSONObject.put("appId", this.l);
            jSONObject.put("screen_width", this.m);
            jSONObject.put("screen_height", this.n);
            jSONObject.put("orientation", this.o);
            jSONObject.put(BatteryManager.EXTRA_SCALE, this.p);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }
}
