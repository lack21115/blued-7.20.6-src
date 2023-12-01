package com.meizu.cloud.pushsdk.a;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.d.f.e;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23953a = b.class.getSimpleName();
    private final HashMap<String, String> b;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, Object> f23954c;
    private final HashMap<String, Object> d;

    /* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/a/b$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f23955a = null;

        public a a(Context context) {
            this.f23955a = context;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    private b(a aVar) {
        this.b = new HashMap<>();
        this.f23954c = new HashMap<>();
        this.d = new HashMap<>();
        d();
        if (aVar.f23955a != null) {
            b(aVar.f23955a);
            a(aVar.f23955a);
            c(aVar.f23955a);
            d(aVar.f23955a);
        }
        DebugLogger.i(f23953a, "Subject created successfully.");
    }

    private void a(String str, int i, int i2) {
        this.b.put(str, i + "." + i2);
    }

    private void a(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        if ((obj instanceof String) && ((String) obj).isEmpty()) {
            return;
        }
        this.f23954c.put(str, obj);
    }

    private void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.b.put(str, str2);
    }

    private void b(Context context) {
        a("op", e.c(context));
    }

    private void b(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        if ((obj instanceof String) && ((String) obj).isEmpty()) {
            return;
        }
        this.d.put(str, obj);
    }

    private void c(Context context) {
        b("nt", MzSystemUtils.getNetWorkType(context));
    }

    private void d() {
        a("br", Build.BRAND);
        a(OapsKey.KEY_DOWNLOAD_COUNT, Build.MODEL);
        a(com.anythink.expressad.foundation.g.a.J, Build.VERSION.RELEASE);
        a(com.anythink.expressad.foundation.g.a.F, Build.DISPLAY);
        a("ll", MzSystemUtils.getCurrentLanguage());
    }

    private void d(Context context) {
        a("pn", (Object) context.getPackageName());
        a("pv", (Object) MzSystemUtils.getAppVersionName(context));
        a("pvc", Integer.valueOf(MzSystemUtils.getAppVersionCode(context)));
        a("st", Integer.valueOf(!TextUtils.isEmpty(MzSystemUtils.findReceiver(context, "com.meizu.ups.push.intent.MESSAGE", context.getPackageName())) ? 1 : 0));
    }

    public Map<String, String> a() {
        return this.b;
    }

    public void a(Context context) {
        Point d = e.d(context);
        if (d == null) {
            DebugLogger.e(f23953a, "screen information not available.");
        } else {
            a("ss", d.x, d.y);
        }
    }

    public Map<String, Object> b() {
        return this.f23954c;
    }

    public Map<String, Object> c() {
        return this.d;
    }
}
