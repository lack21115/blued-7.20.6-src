package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.amap.api.col.3sl.kv  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/kv.class */
public final class kv extends ky {
    private Context b;
    private boolean d;
    private int e;
    private int f;
    private String a = "iKey";
    private int g = 0;

    public kv(Context context, boolean z, int i, int i2, String str) {
        a(context, z, i, i2, str, 0);
    }

    public kv(Context context, boolean z, int i, int i2, String str, int i3) {
        a(context, z, i, i2, str, i3);
    }

    private void a(Context context, boolean z, int i, int i2, String str, int i3) {
        this.b = context;
        this.d = z;
        this.e = i;
        this.f = i2;
        this.a = str;
        this.g = i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0018, code lost:
        if (r0 <= 0) goto L12;
     */
    @Override // com.amap.api.col.p0003sl.ky
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a() {
        /*
            r3 = this;
            r0 = r3
            android.content.Context r0 = r0.b
            int r0 = com.amap.api.col.p0003sl.hs.o(r0)
            r4 = r0
            r0 = 2147483647(0x7fffffff, float:NaN)
            r5 = r0
            r0 = r4
            r1 = 1
            if (r0 == r1) goto L21
            r0 = r3
            int r0 = r0.e
            r6 = r0
            r0 = r6
            r4 = r0
            r0 = r6
            if (r0 > 0) goto L1e
            goto L21
        L1e:
            goto L39
        L21:
            r0 = r3
            int r0 = r0.g
            r6 = r0
            r0 = r5
            r4 = r0
            r0 = r6
            if (r0 <= 0) goto L39
            r0 = r5
            r4 = r0
            r0 = r6
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 >= r1) goto L39
            r0 = r6
            r4 = r0
            goto L1e
        L39:
            r0 = r3
            com.amap.api.col.3sl.ky r0 = r0.c
            if (r0 == 0) goto L4c
            r0 = r4
            r1 = r3
            com.amap.api.col.3sl.ky r1 = r1.c
            int r1 = r1.a()
            int r0 = java.lang.Math.max(r0, r1)
            return r0
        L4c:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.kv.a():int");
    }

    @Override // com.amap.api.col.p0003sl.ky
    public final void b_(int i) {
        if (hs.o(this.b) == 1) {
            return;
        }
        String a = ib.a(System.currentTimeMillis(), "yyyyMMdd");
        String a2 = iu.a(this.b, this.a);
        int i2 = i;
        if (!TextUtils.isEmpty(a2)) {
            String[] split = a2.split("\\|");
            if (split == null || split.length < 2) {
                iu.b(this.b, this.a);
                i2 = i;
            } else {
                i2 = i;
                if (a.equals(split[0])) {
                    i2 = i + Integer.parseInt(split[1]);
                }
            }
        }
        Context context = this.b;
        String str = this.a;
        iu.a(context, str, a + "|" + i2);
    }

    @Override // com.amap.api.col.p0003sl.ky
    protected final boolean c() {
        if (hs.o(this.b) == 1) {
            return true;
        }
        if (this.d) {
            String a = iu.a(this.b, this.a);
            if (TextUtils.isEmpty(a)) {
                return true;
            }
            String[] split = a.split("\\|");
            if (split != null && split.length >= 2) {
                return !ib.a(System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || Integer.parseInt(split[1]) < this.f;
            }
            iu.b(this.b, this.a);
            return true;
        }
        return false;
    }
}
