package com.opos.acs.st.utils;

import android.content.Context;
import com.opos.cmn.biz.requeststatistic.InitParams;
import com.opos.cmn.biz.requeststatistic.RequestStatisticManager;
import com.opos.cmn.biz.requeststatistic.StatisticEvent;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/acs/st/utils/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static String f10778a = "ReportErrorEngine";

    /* renamed from: c  reason: collision with root package name */
    private static volatile e f10779c;
    private static byte[] d = new byte[1];
    private Context b;

    private e(Context context) {
        if (context != null) {
            this.b = context;
            RequestStatisticManager.getInstance().init(this.b, new InitParams.Builder().build());
        }
    }

    public static e a(Context context) {
        if (f10779c == null) {
            synchronized (d) {
                if (f10779c == null) {
                    f10779c = new e(context);
                }
            }
        }
        return f10779c;
    }

    public static void a(Map map) {
        try {
            String str = f10778a;
            StringBuilder sb = new StringBuilder("errorMap=");
            sb.append(map != null ? map : com.igexin.push.core.b.l);
            d.a(str, sb.toString());
            StatisticEvent a2 = com.opos.acs.st.b.a.a(map);
            if (a2 != null) {
                try {
                    RequestStatisticManager.getInstance().report(a2);
                } catch (Exception e) {
                    d.c(f10778a, "report error Exception", e);
                }
            }
        } catch (Exception e2) {
            d.c(f10778a, "reportOneRecord error Exception", e2);
        }
    }

    public final void a() {
        boolean z;
        try {
            if ("WIFI".equalsIgnoreCase(h.a(this.b))) {
                d.a(f10778a, "is wifi");
                z = true;
            } else {
                d.a(f10778a, "is not wifi");
                z = false;
            }
            if (z) {
                RequestStatisticManager.getInstance().reportCacheIfNeed();
            } else {
                d.a(f10778a, "is not wifi");
            }
        } catch (Exception e) {
            d.c(f10778a, "report all error Exception", e);
        }
    }
}
