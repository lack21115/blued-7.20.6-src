package com.tencent.liteav.audio.earmonitor;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.audio.earmonitor.a.b.a.c;
import com.tencent.liteav.audio.earmonitor.a.b.a.d;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.r;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/earmonitor/a.class */
public final class a extends SystemAudioKit implements com.tencent.liteav.audio.earmonitor.a.b.a.e, r.a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f36222a = (int) TimeUnit.SECONDS.toMillis(1);
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f36223c;
    private com.tencent.liteav.audio.earmonitor.a.b.a.d d;
    private com.tencent.liteav.audio.earmonitor.a.b.a.c e;
    private r f;
    private boolean g;
    private boolean h;
    private boolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(long j, Context context) {
        super(j);
        this.f36223c = new Handler(Looper.getMainLooper());
        this.g = false;
        this.h = false;
        this.i = false;
        this.b = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar) {
        r rVar = aVar.f;
        if (rVar != null) {
            rVar.a();
            aVar.f = null;
        }
        aVar.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, int i) {
        LiteavLog.i("HwSystemAudioKit", "on audio kit callback: %d", Integer.valueOf(i));
        if (i == 0) {
            aVar.g = false;
            com.tencent.liteav.audio.earmonitor.a.b.a.d dVar = aVar.d;
            if (dVar == null || !dVar.a(d.a.HWAUDIO_FEATURE_KARAOKE)) {
                aVar.notifyEarMonitoringInitialized(aVar, false);
                return;
            } else {
                aVar.e = (com.tencent.liteav.audio.earmonitor.a.b.a.c) aVar.d.b(d.a.HWAUDIO_FEATURE_KARAOKE);
                return;
            }
        }
        if (i != 2 && i != 4 && i != 5 && i != 6 && i != 7) {
            switch (i) {
                case 1000:
                    aVar.notifyEarMonitoringInitialized(aVar, true);
                    return;
                case 1001:
                case 1002:
                case 1003:
                    break;
                default:
                    return;
            }
        }
        if (!aVar.g) {
            aVar.notifySystemError(aVar);
            return;
        }
        aVar.g = false;
        aVar.notifyEarMonitoringInitialized(aVar, false);
    }

    private void a(Runnable runnable) {
        if (Looper.myLooper() == this.f36223c.getLooper()) {
            runnable.run();
        } else {
            this.f36223c.post(runnable);
        }
    }

    private void b() {
        com.tencent.liteav.audio.earmonitor.a.b.a.c cVar = this.e;
        if (cVar == null) {
            return;
        }
        int a2 = cVar.a(true);
        if (a2 == 0 || a2 == 1805) {
            this.i = true;
        } else {
            notifySystemError(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(a aVar) {
        if (aVar.f == null) {
            r rVar = new r(Looper.getMainLooper(), aVar);
            aVar.f = rVar;
            rVar.a(0, f36222a);
        }
        aVar.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(a aVar, int i) {
        if (aVar.e == null) {
            return;
        }
        if (aVar.e.a(c.a.CMD_SET_VOCAL_VOLUME_BASE, com.tencent.liteav.base.util.h.a(i, 0, 100)) != 0) {
            aVar.notifySystemError(aVar);
        }
    }

    private void c() {
        com.tencent.liteav.audio.earmonitor.a.b.a.c cVar = this.e;
        if (cVar == null) {
            return;
        }
        cVar.a(false);
        this.i = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(a aVar) {
        com.tencent.liteav.audio.earmonitor.a.b.a.c cVar = aVar.e;
        if (cVar != null) {
            cVar.a();
            aVar.e = null;
        }
        com.tencent.liteav.audio.earmonitor.a.b.a.d dVar = aVar.d;
        if (dVar != null) {
            dVar.b();
            aVar.d = null;
        }
        aVar.g = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(a aVar) {
        if (aVar.d != null) {
            return;
        }
        aVar.g = true;
        com.tencent.liteav.audio.earmonitor.a.b.a.d dVar = new com.tencent.liteav.audio.earmonitor.a.b.a.d(aVar.b, aVar);
        aVar.d = dVar;
        dVar.a();
    }

    @Override // com.tencent.liteav.audio.earmonitor.a.b.a.e
    public final void a(int i) {
        a(g.a(this, i));
    }

    @Override // com.tencent.liteav.base.util.r.a
    public final void a_() {
        boolean z = true;
        if (LiteavSystemInfo.getAppBackgroundState() != 1) {
            z = false;
        }
        if (this.i && this.h && !z) {
            LiteavLog.i("HwSystemAudioKit", "app return to foreground.");
            c();
            b();
        } else if (z && !this.h) {
            LiteavLog.i("HwSystemAudioKit", "app has gone to background.");
        }
        this.h = z;
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void initialize() {
        a(b.a(this));
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void setEarMonitoringVolume(int i) {
        a(f.a(this, i));
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void startEarMonitoring() {
        a(d.a(this));
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void stopEarMonitoring() {
        a(e.a(this));
    }

    @Override // com.tencent.liteav.audio.earmonitor.SystemAudioKit
    public final void terminate() {
        a(c.a(this));
    }
}
