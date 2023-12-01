package com.tencent.tendinsv.utils;

import android.Manifest;
import android.content.Context;
import android.os.Build;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/utils/h.class */
public class h extends com.tencent.tendinsv.tool.a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile com.tencent.tendinsv.tool.a f25406a;

    public static com.tencent.tendinsv.tool.a a() {
        if (f25406a == null) {
            synchronized (h.class) {
                try {
                    if (f25406a == null) {
                        f25406a = new h();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f25406a;
    }

    @Override // com.tencent.tendinsv.tool.a
    public void a(Context context, boolean z, int i, long j, long j2, long j3) {
        try {
            String b = t.b(context, "ns", "0");
            int b2 = t.b(context, t.T, 0);
            int parseInt = Integer.parseInt(Build.VERSION.RELEASE.substring(0, 1));
            String b3 = e.b();
            if ("1".equals(b) || ("0".equals(b) && r.d.equals(b3) && parseInt <= 9 && parseInt >= 6)) {
                boolean b4 = t.b(context, t.R, false);
                if (e.a(context, Manifest.permission.CHANGE_WIFI_STATE) && z && !b4 && i == 1 && b2 < 5) {
                    t.a(context, t.T, b2 + 1);
                    com.tencent.tendinsv.tool.n.a().a(context, j, j2, j3);
                }
                l.a(com.tencent.tendinsv.b.J, "__initR==", Boolean.valueOf(z), "__preinit==", Boolean.valueOf(b4), "__intCount==", Integer.valueOf(b2));
            }
            l.a(com.tencent.tendinsv.b.J, "___switch==", b, "__osType==", Integer.valueOf(parseInt), "__manufacturer==", b3);
        } catch (Exception e) {
            e.printStackTrace();
            l.a(com.tencent.tendinsv.b.J, "checkMobileNetwork__Exception_e==", e);
        }
    }
}
