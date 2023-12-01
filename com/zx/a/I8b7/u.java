package com.zx.a.I8b7;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/u.class */
public class u implements c0 {

    /* renamed from: a  reason: collision with root package name */
    public String f28512a = "sdk.debug";
    public e0 b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28513c;
    public boolean d;
    public Context e;

    public u(Context context, e0 e0Var) {
        this.e = context.getApplicationContext();
        this.b = (e0) o1.a(e0Var);
        a(this.f28512a);
    }

    @Override // com.zx.a.I8b7.c0
    public void a(int i, String str, String str2, Throwable th) {
        int i2 = i;
        if ((i & 240) != 0) {
            i2 = i & 15;
        }
        this.b.a(i2, str, str2, th);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(6:2|3|4|5|6|7)|(3:9|10|11)|(10:13|14|15|16|17|18|19|20|21|22)|23|24|(5:25|26|27|28|29)|(13:(18:34|35|36|37|38|39|40|41|42|43|44|45|(8:47|48|49|(1:51)|52|53|54|55)|58|52|53|54|55)|40|41|42|43|44|45|(0)|58|52|53|54|55)|76|35|36|37|38|39|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(21:102|103|(3:105|10|11)|13|14|15|(13:(7:16|17|18|19|20|21|22)|40|41|42|43|44|45|(0)|58|52|53|54|55)|23|24|25|26|27|28|29|(0)|76|35|36|37|38|39) */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0164, code lost:
        r8 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x016b, code lost:
        if (r8 != null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x016e, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0220, code lost:
        r8 = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0141 A[Catch: all -> 0x021b, TryCatch #12 {all -> 0x021b, blocks: (B:29:0x012c, B:30:0x012f, B:32:0x0141, B:35:0x0154), top: B:115:0x012c }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01cb  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x01fc -> B:93:0x0078). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0226 -> B:97:0x0172). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 587
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.u.a(java.lang.String):void");
    }

    @Override // com.zx.a.I8b7.c0
    public boolean a(int i, String str) {
        int i2 = i & 240;
        boolean z = false;
        if (i2 == 0 || i2 == 32) {
            if (this.f28513c || this.d) {
                z = true;
            }
            return z;
        }
        return false;
    }
}
