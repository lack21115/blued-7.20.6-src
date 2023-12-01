package com.zk_oaction.adengine.lk_animation;

import android.os.SystemClock;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_animation/b.class */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private long f28193a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f28194c;
    private boolean d;
    private long e;

    public abstract long a();

    public abstract void a(long j);

    public abstract boolean a(XmlPullParser xmlPullParser);

    public void b() {
        if (this.b) {
            return;
        }
        this.b = true;
        if (this.f28194c) {
            this.f28194c = false;
            return;
        }
        this.f28193a = SystemClock.uptimeMillis();
        a(0L);
    }

    public void c() {
        this.b = false;
        this.f28194c = true;
    }

    public void d() {
        if (this.b) {
            this.b = false;
            a(0L);
        }
    }

    public void e() {
        this.e = SystemClock.uptimeMillis();
        this.d = true;
    }

    public void f() {
        if (this.d) {
            this.d = false;
            this.f28193a += SystemClock.uptimeMillis() - this.e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
        if (r0 < 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g() {
        /*
            r5 = this;
            r0 = r5
            boolean r0 = r0.b
            if (r0 != 0) goto L8
            return
        L8:
            long r0 = android.os.SystemClock.uptimeMillis()
            r1 = r5
            long r1 = r1.f28193a
            long r0 = r0 - r1
            r8 = r0
            r0 = r8
            r1 = r5
            long r1 = r1.a()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L22
            r0 = r8
            r6 = r0
            r0 = r8
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L2b
        L22:
            r0 = r5
            long r1 = android.os.SystemClock.uptimeMillis()
            r0.f28193a = r1
            r0 = 0
            r6 = r0
        L2b:
            r0 = r5
            r1 = r6
            r0.a(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_animation.b.g():void");
    }
}
