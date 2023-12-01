package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import com.kwad.sdk.crash.c;
import com.kwad.sdk.crash.model.message.ExceptionMessage;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/e.class */
public final class e {
    private com.kwad.sdk.crash.a.b arg;
    private c arh;
    private long ari;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/e$a.class */
    public static final class a {
        private static final e arj = new e((byte) 0);
    }

    private e() {
        this.arg = new com.kwad.sdk.crash.a.b();
        this.arh = new c.a().zx();
    }

    /* synthetic */ e(byte b) {
        this();
    }

    public static e zy() {
        return a.arj;
    }

    public final void a(c cVar) {
        this.arh = cVar;
        this.ari = SystemClock.elapsedRealtime();
        this.arg.a(cVar.aqM, cVar.aqN);
    }

    public final void b(int i, ExceptionMessage exceptionMessage) {
        f zv = this.arh.zv();
        if (zv != null) {
            zv.a(i, exceptionMessage);
        }
    }

    public final String getAppId() {
        return this.arh.aqK.arx;
    }

    public final Context getContext() {
        return this.arh.context;
    }

    public final String getSdkVersion() {
        return this.arh.aqJ.mSdkVersion;
    }

    public final boolean isDebug() {
        return this.arh.zw();
    }

    public final String[] zA() {
        return this.arg.zA();
    }

    public final String zB() {
        return this.arh.aqJ.arA;
    }

    public final int zC() {
        return this.arh.aqJ.arE;
    }

    public final c zD() {
        return this.arh;
    }

    public final h zE() {
        return this.arh.aqL;
    }

    public final long zF() {
        return SystemClock.elapsedRealtime() - this.ari;
    }

    public final String[] zz() {
        return this.arg.zM();
    }
}
