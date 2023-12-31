package com.tencent.beacon.a.b;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.beacon.base.net.BResponse;
import com.tencent.beacon.base.net.call.Callback;
import com.umeng.analytics.pro.bh;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/b/e.class */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, String> f21237a = new LinkedHashMap();
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21238c = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, Throwable th) {
        synchronized (this) {
            a(str, str2, th, true, new d(this));
        }
    }

    private void e() {
        synchronized (this) {
            if (this.b) {
                return;
            }
            f21237a.put("attaid", b());
            f21237a.put("token", c());
            f21237a.put("error_code", "");
            f21237a.put("platform", "Android");
            f21237a.put("uin", com.tencent.beacon.a.c.e.l().d());
            Map<String, String> map = f21237a;
            map.put("model", Build.BOARD + " " + com.tencent.beacon.a.c.f.e().h());
            f21237a.put(bh.x, com.tencent.beacon.a.c.e.l().s());
            f21237a.put("error_msg", "");
            f21237a.put("error_stack_full", "");
            f21237a.put("app_version", com.tencent.beacon.a.c.b.a());
            f21237a.put("sdk_version", com.tencent.beacon.a.c.c.d().j());
            f21237a.put("product_id", com.tencent.beacon.a.c.c.d().f());
            f21237a.put("_dc", "");
            this.b = true;
        }
    }

    public void a(String str, String str2) {
        synchronized (this) {
            a(str, str2, null);
        }
    }

    public void a(String str, String str2, Throwable th) {
        synchronized (this) {
            a(str, str2, th, false, new b(this, str, str2, th));
        }
    }

    public void a(String str, String str2, Throwable th, boolean z, Callback<BResponse> callback) {
        synchronized (this) {
            if (d()) {
                if (!this.b) {
                    e();
                }
                if (TextUtils.isEmpty(str)) {
                    com.tencent.beacon.base.util.c.b("[atta] errorCode isn't valid value!", new Object[0]);
                } else {
                    a.a().a(new c(this, str, str2, th, z, callback));
                }
            }
        }
    }

    public void a(boolean z) {
        this.f21238c = z;
    }

    abstract String b();

    abstract String c();

    public boolean d() {
        if (this.f21238c) {
            return true;
        }
        if (com.tencent.beacon.base.util.c.b()) {
            return false;
        }
        String d = com.tencent.beacon.a.c.e.l().d();
        return !TextUtils.isEmpty(d) && ((double) Math.abs(d.hashCode() % 10000)) < 100.0d;
    }
}
