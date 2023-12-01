package com.zx.a.I8b7;

import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import com.zx.a.I8b7.c3;
import com.zx.a.I8b7.u2;
import com.zx.module.base.Callback;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q1.class */
public class q1 {
    public static final Set<String> b;

    /* renamed from: a  reason: collision with root package name */
    public v2 f28486a;

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q1$a.class */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f28487a;
        public final /* synthetic */ Callback b;

        public a(String str, Callback callback) {
            this.f28487a = str;
            this.b = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                u2.b.f28523a.b(new JSONObject(this.f28487a), this.b, 0);
            } catch (Throwable th) {
                z1.b("getUAID error:" + th);
                Callback callback = this.b;
                if (callback != null) {
                    try {
                        callback.callback(q1.this.a(th.getMessage(), 1));
                    } catch (JSONException e) {
                        z1.a(e);
                    }
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q1$b.class */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f28489a;
        public final /* synthetic */ Callback b;

        public b(String str, Callback callback) {
            this.f28489a = str;
            this.b = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                u2.b.f28523a.b(new JSONObject(this.f28489a), this.b, 1);
            } catch (Throwable th) {
                z1.b("getAuthToken error:" + th);
                Callback callback = this.b;
                if (callback != null) {
                    try {
                        callback.callback(q1.this.a(th.getMessage(), 1));
                    } catch (JSONException e) {
                        z1.a(e);
                    }
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q1$c.class */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Callback f28491a;

        public c(Callback callback) {
            this.f28491a = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f28491a.callback(q1.this.a(k1.c(), 0));
            } catch (Throwable th) {
                z1.b("getTag error:" + th);
                Callback callback = this.f28491a;
                if (callback != null) {
                    try {
                        callback.callback(q1.this.a(th.getMessage(), 1));
                    } catch (JSONException e) {
                        z1.a(e);
                    }
                }
            }
        }
    }

    static {
        HashSet hashSet = new HashSet();
        b = hashSet;
        t2.f28511c = "core-n";
        t2.d = "3.2.0.16894";
        hashSet.add("fd39c63f1732f201");
        hashSet.add("182215c3273d3c96");
        hashSet.add("30c3b906fa3a6c10");
        hashSet.add("83e1f70a049353e0");
        hashSet.add("a14a9b473d09b4a4");
        hashSet.add("c5d0f5289411bfb1");
        hashSet.add("888db8aca12678cf");
        hashSet.add("4d34408b292920ff");
        Set<String> set = t2.E;
        set.add("fd39c63f1732f201");
        set.add("182215c3273d3c96");
        set.add("30c3b906fa3a6c10");
        set.add("83e1f70a049353e0");
        set.add("888db8aca12678cf");
    }

    public final String a(String str, int i) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", str);
        jSONObject.put("code", i);
        return jSONObject.toString();
    }

    public String f182215c3273d3c96(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", false);
        jSONObject.put("code", 0);
        return jSONObject.toString();
    }

    public String f30c3b906fa3a6c10(String str) throws JSONException {
        try {
            boolean z = new JSONObject(str).getBoolean("isDebug");
            Log.d("setDebug", "isDebug: " + z);
            m.f28456a = z;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 0);
            return jSONObject.toString();
        } catch (Throwable th) {
            Log.e("ZXCoreModule setDebug", th.getMessage());
            return a(th.getMessage(), 1);
        }
    }

    public void f4d34408b292920ff(String str, Callback callback) {
        z1.a("getAuthToken:" + str + "with cb");
        AtomicInteger atomicInteger = c3.f28421c;
        c3.c.f28423a.f28422a.execute(new b(str, callback));
    }

    public String f83e1f70a049353e0(String str) throws JSONException {
        t2.b = new JSONObject(str).getString("version");
        return a("", 0);
    }

    public String f888db8aca12678cf(String str) throws JSONException {
        return a("lib not work", 1);
    }

    public void fa14a9b473d09b4a4(String str, Callback callback) {
        z1.a("getUAID:" + str + "with cb");
        AtomicInteger atomicInteger = c3.f28421c;
        c3.c.f28423a.f28422a.execute(new a(str, callback));
    }

    public void fc5d0f5289411bfb1(String str, Callback callback) {
        z1.a("getTag:" + str + "with cb");
        AtomicInteger atomicInteger = c3.f28421c;
        c3.c.f28423a.f28422a.execute(new c(callback));
    }

    public String ffd39c63f1732f201(String str) throws JSONException {
        String a2;
        boolean z = new JSONObject(str).getBoolean("allowExpired");
        ((a3) this.f28486a).getClass();
        if (z) {
            a2 = t2.a();
        } else {
            String str2 = t2.i;
            boolean z2 = true;
            if (!TextUtils.isEmpty(str2)) {
                try {
                    if (System.currentTimeMillis() < Long.parseLong(str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[1]) * 1000) {
                        z2 = false;
                    }
                } catch (Exception e) {
                    z1.b("zid判断过期异常:" + str2 + ", err :" + e.getMessage());
                }
            }
            a2 = !z2 ? t2.a() : null;
        }
        return a(a2, 0);
    }
}
