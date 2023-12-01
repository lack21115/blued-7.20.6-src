package com.anythink.core.common.k;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.SparseBooleanArray;
import com.anythink.core.common.k.o;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/q.class */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private static final int f6822a = 1;
    private static final int b = 2;

    /* renamed from: c  reason: collision with root package name */
    private static final int f6823c = 3;
    private static volatile q e;
    private final SparseBooleanArray d = new SparseBooleanArray(3);

    public static q a() {
        if (e == null) {
            synchronized (q.class) {
                try {
                    if (e == null) {
                        e = new q();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return e;
    }

    public final boolean a(Context context) {
        boolean z;
        synchronized (this) {
            if (this.d.indexOfKey(1) >= 0) {
                return this.d.get(1);
            } else if (Build.VERSION.SDK_INT < 16) {
                this.d.put(1, false);
                return false;
            } else {
                try {
                    o oVar = new o(context);
                    o.a a2 = oVar.a("com.huawei.hwid");
                    String b2 = oVar.b("com.huawei.hwid");
                    z = false;
                    if (a2 == o.a.ENABLED) {
                        z = false;
                        if ("B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05".equalsIgnoreCase(b2)) {
                            z = true;
                        }
                    }
                } catch (Exception e2) {
                    z = false;
                }
                this.d.put(1, z);
                return z;
            }
        }
    }

    public final boolean b() {
        synchronized (this) {
            if (this.d.indexOfKey(3) >= 0) {
                return this.d.get(3);
            }
            boolean z = false;
            try {
                Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory");
                z = true;
            } catch (Exception e2) {
            }
            this.d.put(3, z);
            return z;
        }
    }

    public final boolean b(Context context) {
        boolean z;
        synchronized (this) {
            if (this.d.indexOfKey(2) >= 0) {
                return this.d.get(2);
            }
            try {
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
                z = false;
                if (queryIntentServices != null) {
                    z = false;
                    if (queryIntentServices.size() > 0) {
                        z = true;
                    }
                }
            } catch (Exception e2) {
                z = false;
            }
            this.d.put(2, z);
            return z;
        }
    }
}
