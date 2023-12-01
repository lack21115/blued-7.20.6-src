package com.tencent.tmsbeacon.a.b;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.tmsbeacon.base.net.BResponse;
import com.tencent.tmsbeacon.base.net.HttpMethod;
import com.tencent.tmsbeacon.base.net.call.Callback;
import com.tencent.tmsbeacon.base.net.call.e;
import com.tencent.tmsbeacon.base.util.c;
import com.umeng.analytics.pro.bh;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/a/b/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f25772a;
    private static final Map<String, String> b = new LinkedHashMap();

    /* renamed from: c  reason: collision with root package name */
    private boolean f25773c = false;
    private boolean d = false;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/a/b/d$a.class */
    public class a implements Callback<BResponse> {
        public a() {
        }

        @Override // com.tencent.tmsbeacon.base.net.call.Callback
        /* renamed from: a */
        public void onResponse(BResponse bResponse) {
            c.a("AttaReport", "net ret: " + bResponse.toString(), new Object[0]);
        }

        @Override // com.tencent.tmsbeacon.base.net.call.Callback
        public void onFailure(com.tencent.tmsbeacon.base.net.d dVar) {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/a/b/d$b.class */
    public class b implements Runnable {
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f25774c;
        public final /* synthetic */ Throwable d;
        public final /* synthetic */ Callback e;

        public b(String str, String str2, Throwable th, Callback callback) {
            this.b = str;
            this.f25774c = str2;
            this.d = th;
            this.e = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (d.this) {
                LinkedHashMap linkedHashMap = new LinkedHashMap(d.b);
                linkedHashMap.put("error_code", this.b);
                linkedHashMap.put("error_msg", this.f25774c);
                linkedHashMap.put("error_stack_full", com.tencent.tmsbeacon.base.util.b.a(this.d));
                linkedHashMap.put("_dc", String.valueOf(Math.random()));
                com.tencent.tmsbeacon.base.net.c.c().a(e.b().b("https://h.trace.qq.com/kv").a("atta").a(linkedHashMap).a(HttpMethod.POST).a()).a(this.e);
                c.d("[atta] upload a new error, errorCode: %s, message: %s, stack: %s", this.b, this.f25774c, com.tencent.tmsbeacon.base.util.b.a(this.d));
            }
        }
    }

    private d() {
    }

    public static d b() {
        if (f25772a == null) {
            synchronized (d.class) {
                try {
                    if (f25772a == null) {
                        f25772a = new d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f25772a;
    }

    private void d() {
        synchronized (this) {
            if (this.f25773c) {
                return;
            }
            Map<String, String> map = b;
            map.put("attaid", "00400014144");
            map.put("token", "6478159937");
            map.put("error_code", "");
            map.put("platform", "Android");
            map.put("uin", com.tencent.tmsbeacon.a.c.e.l().d());
            map.put("model", Build.BOARD + " " + com.tencent.tmsbeacon.a.c.f.e().h());
            map.put(bh.x, com.tencent.tmsbeacon.a.c.e.l().s());
            map.put("error_msg", "");
            map.put("error_stack_full", "");
            map.put("app_version", com.tencent.tmsbeacon.a.c.b.a());
            map.put("sdk_version", com.tencent.tmsbeacon.a.c.c.d().i());
            map.put("product_id", com.tencent.tmsbeacon.a.c.c.d().f());
            map.put("_dc", "");
            this.f25773c = true;
        }
    }

    public void a(String str, String str2) {
        synchronized (this) {
            a(str, str2, null);
        }
    }

    public void a(String str, String str2, Throwable th) {
        synchronized (this) {
            a(str, str2, th, new a());
        }
    }

    public void a(String str, String str2, Throwable th, Callback<BResponse> callback) {
        synchronized (this) {
            if (c()) {
                if (!this.f25773c) {
                    d();
                }
                if (TextUtils.isEmpty(str)) {
                    c.b("[atta] errorCode isn't valid value!", new Object[0]);
                } else {
                    com.tencent.tmsbeacon.a.b.a.a().a(new b(str, str2, th, callback));
                }
            }
        }
    }

    public void a(boolean z) {
        this.d = z;
    }

    public boolean c() {
        if (this.d) {
            return true;
        }
        if (c.a()) {
            return false;
        }
        String d = com.tencent.tmsbeacon.a.c.e.l().d();
        return !TextUtils.isEmpty(d) && ((double) Math.abs(d.hashCode() % 10000)) < 100.0d;
    }
}
