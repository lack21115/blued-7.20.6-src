package com.igexin.push.e;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/e/f.class */
public final class f implements com.igexin.push.e.b.c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f10012a = "SilentTimeTimerTask";
    private static f d;
    private long b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f10013c = 0;
    private boolean e = false;

    private f() {
    }

    public static f c() {
        if (d == null) {
            d = new f();
        }
        return d;
    }

    @Override // com.igexin.push.e.b.c
    public final void a() {
        d();
    }

    @Override // com.igexin.push.e.b.c
    public final void a(long j) {
        this.b = j;
    }

    @Override // com.igexin.push.e.b.c
    public final boolean b() {
        return System.currentTimeMillis() - this.b > this.f10013c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0077, code lost:
        if (r0.getTimeInMillis() < r0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b3, code lost:
        if (r0.getTimeInMillis() < r0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b6, code lost:
        r0.add(5, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00bd, code lost:
        r7.f10013c = r0.getTimeInMillis() - r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d() {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.e.f.d():void");
    }
}
