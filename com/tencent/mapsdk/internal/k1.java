package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.internal.ca;
import com.tencent.mapsdk.shell.events.ReportEvent;
import java.net.URLEncoder;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/k1.class */
public class k1 {
    private static volatile k1 b;

    /* renamed from: a  reason: collision with root package name */
    private boolean f23890a = false;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/k1$a.class */
    public class a extends ca.i<Boolean> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            try {
                s3 s3Var = (s3) n2.a(s3.class);
                if (TextUtils.isEmpty(c7.z())) {
                    c7.z();
                }
                NetResponse launchStat = ((e3) s3Var.d()).launchStat(g7.b(), URLEncoder.encode(g7.a(), "utf-8"), c7.A(), c7.z(), c7.I(), c7.M(), c7.E(), c7.O(), c7.G());
                if (launchStat != null) {
                    na.c("LaunchStat data with response:" + new String(launchStat.data, launchStat.charset));
                }
            } catch (Exception e) {
                na.b("err:" + e.getMessage());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("cm_model", g7.a());
            u.d().onReport(new ReportEvent("cm_stat", hashMap));
            return Boolean.TRUE;
        }
    }

    private k1() {
    }

    public static k1 a() {
        if (b == null) {
            synchronized (k1.class) {
                try {
                    if (b == null) {
                        b = new k1();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public void a(q1 q1Var) {
        synchronized (this) {
            if (this.f23890a) {
                return;
            }
            if (q1Var != null && !q1Var.v().b()) {
                ca.a((ca.i) new a()).b((ca.d.b) Boolean.FALSE);
                this.f23890a = true;
            }
        }
    }
}
