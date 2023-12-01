package com.tencent.liteav.videobase.utils;

import android.os.SystemClock;
import com.anythink.expressad.video.module.a.a.m;
import com.tencent.liteav.base.util.LiteavLog;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/utils/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final String f22965a;
    private final int b;
    private long d;
    private long e;
    private long f;
    private final a g;

    /* renamed from: c  reason: collision with root package name */
    private final com.tencent.liteav.base.b.a f22966c = new com.tencent.liteav.base.b.a(m.ag);
    private double h = 0.0d;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/utils/f$a.class */
    public interface a {
        void a(double d);
    }

    public f(String str, int i, a aVar) {
        this.f22965a = str + "(" + hashCode() + ")";
        this.b = (int) Math.max((long) i, TimeUnit.SECONDS.toMillis(1L));
        b();
        this.g = aVar;
    }

    public final void a() {
        this.d++;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.f;
        if (j == 0) {
            this.f = SystemClock.elapsedRealtime();
        } else if (elapsedRealtime - j >= this.b) {
            this.h = (((float) (this.d - this.e)) * 1000.0f) / ((float) (elapsedRealtime - j));
            if (this.f22966c.a()) {
                LiteavLog.i("FpsCalculate", "meter name:" + this.f22965a + " fps:" + this.h);
            }
            this.f = elapsedRealtime;
            this.e = this.d;
            a aVar = this.g;
            if (aVar != null) {
                aVar.a(this.h);
            }
        }
    }

    public final void b() {
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
    }
}
