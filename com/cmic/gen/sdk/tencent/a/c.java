package com.cmic.gen.sdk.tencent.a;

import android.content.Context;
import android.text.TextUtils;
import com.cmic.gen.sdk.tencent.a.b;
import com.cmic.gen.sdk.tencent.e.k;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/a/c.class */
public class c implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private static c f7978a;
    private a b;

    /* renamed from: c  reason: collision with root package name */
    private a f7979c;
    private b d;
    private Context e;

    private c(Context context) {
        this.e = context;
        b();
    }

    public static c a(Context context) {
        if (f7978a == null) {
            synchronized (c.class) {
                try {
                    if (f7978a == null) {
                        f7978a = new c(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f7978a;
    }

    private void b() {
        String b = k.b("sdk_config_version", "");
        if (TextUtils.isEmpty(b) || !com.cmic.gen.sdk.tencent.auth.c.SDK_VERSION.equals(b)) {
            b a2 = b.a(true);
            this.d = a2;
            this.b = a2.a();
            if (!TextUtils.isEmpty(b)) {
                c();
            }
        } else {
            b a3 = b.a(false);
            this.d = a3;
            this.b = a3.b();
        }
        this.d.a(this);
        this.f7979c = this.d.a();
    }

    private void c() {
        com.cmic.gen.sdk.tencent.e.c.b("UmcConfigManager", "delete localConfig");
        this.d.c();
    }

    public a a() {
        try {
            return this.b.clone();
        } catch (CloneNotSupportedException e) {
            return this.f7979c;
        }
    }

    @Override // com.cmic.gen.sdk.tencent.a.b.a
    public void a(a aVar) {
        this.b = aVar;
    }

    public void a(com.cmic.gen.sdk.tencent.a aVar) {
        this.d.a(aVar);
    }
}
