package com.anythink.expressad.atsignalcommon.c;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.o;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/c/a.class */
public final class a {
    private static int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static int f7078c = 1;

    /* renamed from: a  reason: collision with root package name */
    private String f7079a;
    private String d;
    private String e;
    private WindVaneWebView f;

    /* renamed from: com.anythink.expressad.atsignalcommon.c.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/c/a$a.class */
    static final class C0116a {

        /* renamed from: a  reason: collision with root package name */
        static a f7080a = new a((byte) 0);

        private C0116a() {
        }
    }

    private a() {
        this.f7079a = "ShakeCacheManager";
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        return C0116a.f7080a;
    }

    private void a(Object obj, WebView webView, String str, String str2) {
        if (webView != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("currentCache", str);
                a(obj, str2, jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static void a(Object obj, WindVaneWebView windVaneWebView) {
        if (windVaneWebView != null) {
            j.a().a(obj, "releaseShake", "");
        }
    }

    private void a(Object obj, WindVaneWebView windVaneWebView, String str, String str2, String str3) {
        if ((str + str2 + str3).equals(this.d)) {
            a(obj, windVaneWebView);
        }
    }

    private void a(Object obj, String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", f7078c);
            jSONObject2.put("message", str);
            jSONObject2.put("data", jSONObject);
            j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Exception e) {
            o.a(this.f7079a, e.getMessage());
        }
    }

    private void a(Object obj, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", b);
            jSONObject2.put("message", "");
            jSONObject2.put("data", jSONObject);
            j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Exception e) {
            a(obj, e.getMessage(), new JSONObject());
            o.a(this.f7079a, e.getMessage());
        }
    }

    private void b(Object obj) {
        a(obj, new JSONObject());
    }

    public final void a(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cache", this.e);
            a(obj, jSONObject);
        } catch (JSONException e) {
            a(obj, e.getMessage(), new JSONObject());
        }
    }

    public final void a(Object obj, WindVaneWebView windVaneWebView, String str) {
        if (!TextUtils.isEmpty(this.e) && this.e.equals(str)) {
            this.e = "";
            this.f = null;
            a(obj, windVaneWebView);
            a(obj, new JSONObject());
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("currentCache", this.e);
            a(obj, "cache is exception", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final void a(Object obj, WindVaneWebView windVaneWebView, String str, String str2) {
        if ((!TextUtils.isEmpty(this.e) && this.e.equals(str)) || (TextUtils.isEmpty(this.e) && TextUtils.isEmpty(str))) {
            this.e = str2;
            if (!TextUtils.isEmpty(str2)) {
                try {
                    this.d = new JSONObject(str2).optString("sid");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.f = windVaneWebView;
            a(obj, new JSONObject());
            return;
        }
        String str3 = this.e;
        if (windVaneWebView != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("currentCache", str3);
                a(obj, "cache had changed", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
