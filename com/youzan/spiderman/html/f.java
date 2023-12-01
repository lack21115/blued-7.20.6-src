package com.youzan.spiderman.html;

import android.content.Context;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/html/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private Context f28143a;
    private HtmlCacheStrategy b;

    /* renamed from: c  reason: collision with root package name */
    private com.youzan.spiderman.c.b.d f28144c;

    public f(Context context, HtmlCacheStrategy htmlCacheStrategy, com.youzan.spiderman.c.b.d dVar) {
        this.f28143a = context.getApplicationContext();
        this.b = htmlCacheStrategy;
        this.f28144c = dVar;
    }

    public final boolean a() {
        Boolean a2;
        HtmlCacheStrategy htmlCacheStrategy = this.b;
        return (htmlCacheStrategy == null || (a2 = htmlCacheStrategy.a()) == null) ? this.f28144c.a() : a2.booleanValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
        if (r0.equals(com.youzan.spiderman.utils.NetWorkUtil.STATE_WIFI) != false) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(long r6) {
        /*
            r5 = this;
            r0 = r5
            boolean r0 = r0.a()
            if (r0 == 0) goto L75
            r0 = r5
            com.youzan.spiderman.c.b.d r0 = r0.f28144c
            java.lang.String r0 = r0.c()
            r9 = r0
            r0 = r9
            boolean r0 = com.youzan.spiderman.utils.StringUtils.isEmpty(r0)
            if (r0 != 0) goto L52
            r0 = r9
            java.lang.String r1 = "all"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L27
        L22:
            r0 = 1
            r8 = r0
            goto L54
        L27:
            r0 = r9
            java.lang.String r1 = "no"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L52
            r0 = r5
            android.content.Context r0 = r0.f28143a
            java.lang.String r0 = com.youzan.spiderman.utils.NetWorkUtil.getConnectionStatus(r0)
            r10 = r0
            r0 = r9
            java.lang.String r1 = "wifi"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L52
            r0 = r10
            java.lang.String r1 = com.youzan.spiderman.utils.NetWorkUtil.STATE_WIFI
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L52
            goto L22
        L52:
            r0 = 0
            r8 = r0
        L54:
            r0 = r8
            if (r0 == 0) goto L75
            long r0 = java.lang.System.currentTimeMillis()
            r1 = r6
            long r0 = r0 - r1
            r1 = r5
            com.youzan.spiderman.c.b.d r1 = r1.f28144c
            long r1 = r1.b()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L6d
            r0 = 0
            r8 = r0
            goto L6f
        L6d:
            r0 = 1
            r8 = r0
        L6f:
            r0 = r8
            if (r0 == 0) goto L75
            r0 = 1
            return r0
        L75:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youzan.spiderman.html.f.a(long):boolean");
    }

    public final boolean a(g gVar) {
        Long b;
        long a2 = gVar.a();
        long currentTimeMillis = System.currentTimeMillis();
        HtmlCacheStrategy htmlCacheStrategy = this.b;
        return currentTimeMillis - a2 <= ((htmlCacheStrategy == null || (b = htmlCacheStrategy.b()) == null) ? this.f28144c.d() : b.longValue());
    }

    public final List<String> b() {
        return this.f28144c.e();
    }
}
