package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.map.tools.Callback;
import com.tencent.mapsdk.internal.ca;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/qf.class */
public class qf {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/qf$a.class */
    public static final class a extends ca.c<Boolean> {
        public final /* synthetic */ Callback b;

        public a(Callback callback) {
            this.b = callback;
        }

        @Override // com.tencent.mapsdk.internal.ca.c, com.tencent.map.tools.Callback
        /* renamed from: a */
        public void callback(Boolean bool) {
            this.b.callback(bool);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/qf$b.class */
    public static final class b extends ca.i<Boolean> {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f37721c;
        public final /* synthetic */ String d;

        public b(Context context, String str) {
            this.f37721c = context;
            this.d = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            qf.a(this.f37721c, this.d);
            return Boolean.TRUE;
        }
    }

    public static void a(Context context, String str) {
        if (context == null) {
            return;
        }
        String c2 = mc.b(context).c(str);
        lc a2 = lc.a(context);
        a(a2);
        int b2 = c7.b(c7.E(), a2.d("sdkVersion"));
        ic a3 = kc.a(context, str);
        jc.c(a3, c2);
        jc.a(context, a3, c2, k4.f37583a);
        jc.a(context, a3, c2, k4.d);
        jc.a(context, a3, c2, k4.b);
        jc.a(context, a3, c2, k4.f37584c);
        jc.a(context, a3, c2, k4.e);
        jc.a(context, a3, c2, k4.f);
        jc.a(context, a3, c2, k4.g);
        jc.a(context, a3, c2, k4.h);
        if (b2 > 0) {
            a2.b("sdkVersion", c7.E());
        }
    }

    public static void a(Context context, String str, Callback<Boolean> callback) {
        ca.a((ca.i) new b(context, str)).a((ca.d.b) Boolean.FALSE, (ca.c<ca.d.b>) (callback != null ? new a(callback) : null));
    }

    private static void a(ic icVar) {
        if (c7.b(icVar.d("sdkVersion"), "4.0.9.1") < 0) {
            icVar.a(new String[]{m4.q, m4.s});
        }
    }
}
