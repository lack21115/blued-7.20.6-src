package com.kwad.components.core.kwai;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.report.q;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/kwai/a.class */
public final class a {
    private String Hq;
    private String Hr;
    private long Hs;
    private long Ht;
    private Timer Hu;
    private boolean Hv = false;
    private final long period;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.core.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/kwai/a$a.class */
    public static final class C0355a {
        private static final a Hx = new a();
    }

    public a() {
        this.Hs = -1L;
        try {
            this.Hs = SystemClock.elapsedRealtime();
        } catch (Throwable th) {
            this.Hs = System.currentTimeMillis();
            b.printStackTraceOnly(th);
        }
        this.period = TimeUnit.MINUTES.toMillis(d.ub());
        com.kwad.sdk.core.b.d dVar = new com.kwad.sdk.core.b.d() { // from class: com.kwad.components.core.kwai.a.1
            @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                a.this.lU();
            }

            @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                a.this.fc();
            }
        };
        com.kwad.sdk.core.b.b.vS();
        com.kwad.sdk.core.b.b.a(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(int i) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.Hs;
        this.Hs = elapsedRealtime;
        if (i == 1) {
            this.Ht = 0L;
            this.Hr = UUID.randomUUID().toString();
            if (TextUtils.isEmpty(this.Hq)) {
                this.Hq = this.Hr;
            }
        }
        this.Ht++;
        q qVar = new q(10220L);
        qVar.aeM = this.Ht;
        if (j > 0) {
            qVar.ajL = j;
        }
        qVar.ajM = i;
        qVar.Hq = this.Hq;
        qVar.Hr = this.Hr;
        h.a2(qVar);
    }

    public static a lT() {
        return C0355a.Hx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lU() {
        this.Hv = false;
        if (this.period <= 0) {
            return;
        }
        Timer timer = this.Hu;
        if (timer != null) {
            timer.cancel();
        }
        am(3);
    }

    public final void fc() {
        if (this.Hv) {
            return;
        }
        this.Hv = true;
        if (this.period <= 0) {
            return;
        }
        this.Hu = new Timer();
        am(1);
        try {
            this.Hu.schedule(new TimerTask() { // from class: com.kwad.components.core.kwai.a.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public final void run() {
                    a.this.am(2);
                }
            }, this.period, this.period);
        } catch (Throwable th) {
        }
    }
}
