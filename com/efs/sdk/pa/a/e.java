package com.efs.sdk.pa.a;

import android.os.SystemClock;
import android.util.Printer;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Iterator;
import java.util.Vector;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/pa/a/e.class */
final class e implements Printer {
    private long f;
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private String f8253c = null;
    private long d = -1;
    private long e = -1;

    /* renamed from: a  reason: collision with root package name */
    Vector<d> f8252a = new Vector<>();

    @Override // android.util.Printer
    public final void println(String str) {
        if (str.startsWith(SimpleComparison.GREATER_THAN_OPERATION)) {
            this.d = SystemClock.elapsedRealtime();
            this.e = SystemClock.currentThreadTimeMillis();
            this.f8253c = str;
            this.b = true;
            Iterator<d> it = this.f8252a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        } else if (this.b && str.startsWith(SimpleComparison.LESS_THAN_OPERATION)) {
            this.b = false;
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.d;
            if (elapsedRealtime > this.f) {
                long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
                long j = this.e;
                Iterator<d> it2 = this.f8252a.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this.f8253c, elapsedRealtime, currentThreadTimeMillis - j);
                }
            }
        }
    }
}
