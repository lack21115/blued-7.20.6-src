package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;

/* renamed from: com.amap.api.col.3sl.hu  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hu.class */
public final class hu {
    private volatile b a = new b((byte) 0);
    private jj b = new jj("HttpsDecisionUtil");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.hu$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hu$a.class */
    public static final class a {
        static hu a = new hu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.hu$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hu$b.class */
    public static final class b {
        protected boolean a;
        private int b;
        private final boolean c;
        private boolean d;

        private b() {
            this.b = 0;
            this.a = true;
            this.c = true;
            this.d = false;
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void a(Context context) {
            if (context != null && this.b <= 0 && Build.VERSION.SDK_INT >= 4) {
                this.b = context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            }
        }

        public final void a(boolean z) {
            this.a = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0059 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x005b A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean a() {
            /*
                r3 = this;
                r0 = r3
                boolean r0 = r0.d
                if (r0 != 0) goto L5d
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 28
                if (r0 < r1) goto L14
                r0 = 1
                r4 = r0
                goto L16
            L14:
                r0 = 0
                r4 = r0
            L16:
                r0 = r3
                boolean r0 = r0.a
                if (r0 == 0) goto L44
                r0 = r3
                int r0 = r0.b
                r6 = r0
                r0 = r6
                r5 = r0
                r0 = r6
                if (r0 > 0) goto L2b
                r0 = 28
                r5 = r0
            L2b:
                r0 = r5
                r1 = 28
                if (r0 < r1) goto L36
                r0 = 1
                r5 = r0
                goto L38
            L36:
                r0 = 0
                r5 = r0
            L38:
                r0 = r5
                if (r0 == 0) goto L3f
                goto L44
            L3f:
                r0 = 0
                r5 = r0
                goto L46
            L44:
                r0 = 1
                r5 = r0
            L46:
                r0 = r4
                if (r0 == 0) goto L53
                r0 = r5
                if (r0 == 0) goto L53
                r0 = 1
                r4 = r0
                goto L55
            L53:
                r0 = 0
                r4 = r0
            L55:
                r0 = r4
                if (r0 == 0) goto L5b
                r0 = 1
                return r0
            L5b:
                r0 = 0
                return r0
            L5d:
                r0 = 1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.hu.b.a():boolean");
        }

        public final void b(boolean z) {
            this.d = z;
        }
    }

    public static hu a() {
        return a.a;
    }

    public static String a(String str) {
        String str2 = str;
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith(com.alipay.sdk.cons.b.a)) {
                return str;
            }
            try {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                buildUpon.scheme(com.alipay.sdk.cons.b.a);
                str2 = buildUpon.build().toString();
            } catch (Throwable th) {
                return str;
            }
        }
        return str2;
    }

    public static void b(Context context) {
        b(context, true);
    }

    private static void b(Context context, boolean z) {
        SharedPreferences.Editor a2 = jj.a(context, "open_common");
        jj.a(a2, "a3", z);
        jj.a(a2);
    }

    private static boolean c() {
        return Build.VERSION.SDK_INT == 19;
    }

    public final void a(Context context) {
        if (this.a == null) {
            this.a = new b((byte) 0);
        }
        this.a.a(jj.a(context, "open_common", "a3", true));
        this.a.a(context);
        ic.a(context).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Context context, boolean z) {
        if (this.a == null) {
            this.a = new b((byte) 0);
        }
        b(context, z);
        this.a.a(z);
    }

    public final void a(boolean z) {
        if (this.a == null) {
            this.a = new b((byte) 0);
        }
        this.a.b(z);
    }

    public final boolean b() {
        if (this.a == null) {
            this.a = new b((byte) 0);
        }
        return this.a.a();
    }

    public final boolean b(boolean z) {
        if (c()) {
            return false;
        }
        return z || b();
    }
}
