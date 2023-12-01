package com.umeng.commonsdk.statistics.noise;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.internal.d;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/noise/ImLatent.class */
public class ImLatent implements d {
    private static ImLatent instanse;
    private Context context;
    private StatTracer statTracer;
    private com.umeng.commonsdk.statistics.common.d storeHelper;
    private final int _DEFAULT_HOURS = 360;
    private final int _DEFAULT_MIN_HOURS = 36;
    private final int _DEFAULT_MIN_LATENT = 1;
    private final int _DEFAULT_MAX_LATENT = 1800;
    private final long _ONE_HOURS_IN_MS = 3600000;
    private final long _360HOURS_IN_MS = 1296000000;
    private final long _36HOURS_IN_MS = 129600000;
    private final int LATENT_MAX = 1800000;
    private final int LATENT_WINDOW = 10;
    private long latentHour = 1296000000;
    private int latentWindow = 10;
    private long mDelay = 0;
    private long mElapsed = 0;
    private boolean mLatentActivite = false;
    private Object mLatentLock = new Object();

    private ImLatent(Context context, StatTracer statTracer) {
        this.context = context;
        this.storeHelper = com.umeng.commonsdk.statistics.common.d.a(context);
        this.statTracer = statTracer;
    }

    public static ImLatent getService(Context context, StatTracer statTracer) {
        ImLatent imLatent;
        synchronized (ImLatent.class) {
            try {
                if (instanse == null) {
                    ImLatent imLatent2 = new ImLatent(context, statTracer);
                    instanse = imLatent2;
                    imLatent2.onImprintChanged(ImprintHandler.getImprintService(context).c());
                }
                imLatent = instanse;
            } catch (Throwable th) {
                throw th;
            }
        }
        return imLatent;
    }

    public long getDelayTime() {
        long j;
        synchronized (this.mLatentLock) {
            j = this.mDelay;
        }
        return j;
    }

    public long getElapsedTime() {
        return this.mElapsed;
    }

    public boolean isLatentActivite() {
        boolean z;
        synchronized (this.mLatentLock) {
            z = this.mLatentActivite;
        }
        return z;
    }

    public void latentDeactivite() {
        synchronized (this.mLatentLock) {
            this.mLatentActivite = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0046, code lost:
        if (r0 > 1800) goto L21;
     */
    @Override // com.umeng.commonsdk.statistics.internal.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onImprintChanged(com.umeng.commonsdk.statistics.idtracking.ImprintHandler.a r7) {
        /*
            r6 = this;
            r0 = 360(0x168, float:5.04E-43)
            r8 = r0
            r0 = r7
            java.lang.String r1 = "latent_hours"
            r2 = 360(0x168, float:5.04E-43)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r0 = r0.a(r1, r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            int r0 = r0.intValue()
            r9 = r0
            r0 = r9
            r1 = 36
            if (r0 > r1) goto L20
            goto L22
        L20:
            r0 = r9
            r8 = r0
        L22:
            r0 = r6
            r1 = r8
            long r1 = (long) r1
            r2 = 3600000(0x36ee80, double:1.7786363E-317)
            long r1 = r1 * r2
            r0.latentHour = r1
            r0 = r7
            java.lang.String r1 = "latent"
            java.lang.String r2 = "0"
            java.lang.String r0 = r0.a(r1, r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            int r0 = r0.intValue()
            r9 = r0
            r0 = r9
            r1 = 1
            if (r0 < r1) goto L49
            r0 = r9
            r8 = r0
            r0 = r9
            r1 = 1800(0x708, float:2.522E-42)
            if (r0 <= r1) goto L4b
        L49:
            r0 = 0
            r8 = r0
        L4b:
            r0 = r8
            if (r0 != 0) goto L6f
            int r0 = com.umeng.commonsdk.statistics.a.f40899c
            if (r0 <= 0) goto L68
            int r0 = com.umeng.commonsdk.statistics.a.f40899c
            r1 = 1800000(0x1b7740, float:2.522337E-39)
            if (r0 <= r1) goto L60
            goto L68
        L60:
            r0 = r6
            int r1 = com.umeng.commonsdk.statistics.a.f40899c
            r0.latentWindow = r1
            return
        L68:
            r0 = r6
            r1 = 10
            r0.latentWindow = r1
            return
        L6f:
            r0 = r6
            r1 = r8
            r0.latentWindow = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.noise.ImLatent.onImprintChanged(com.umeng.commonsdk.statistics.idtracking.ImprintHandler$a):void");
    }

    public boolean shouldStartLatency() {
        if (this.storeHelper.c() || this.statTracer.isFirstRequest()) {
            return false;
        }
        synchronized (this.mLatentLock) {
            if (this.mLatentActivite) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.statTracer.getLastReqTime();
            if (currentTimeMillis > this.latentHour) {
                String signature = Envelope.getSignature(this.context);
                synchronized (this.mLatentLock) {
                    this.mDelay = DataHelper.random(this.latentWindow, signature);
                    this.mElapsed = currentTimeMillis;
                    this.mLatentActivite = true;
                }
                return true;
            } else if (currentTimeMillis > 129600000) {
                synchronized (this.mLatentLock) {
                    this.mDelay = 0L;
                    this.mElapsed = currentTimeMillis;
                    this.mLatentActivite = true;
                }
                return true;
            } else {
                return false;
            }
        }
    }
}
