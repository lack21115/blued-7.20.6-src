package com.tencent.liteav.videoproducer.encoder;

import android.media.MediaCodec;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/ae.class */
final /* synthetic */ class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final x f36974a;
    private final int b;

    private ae(x xVar, int i) {
        this.f36974a = xVar;
        this.b = i;
    }

    public static Runnable a(x xVar, int i) {
        return new ae(xVar, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        x xVar = this.f36974a;
        int i = this.b;
        if (xVar.f.bitrate != i) {
            boolean z = false;
            if (i < xVar.f.bitrate) {
                z = false;
                if (xVar.j) {
                    if (xVar.b.getBoolean("need_restart_when_down_bitrate", false)) {
                        z = true;
                    } else {
                        int i2 = 0;
                        while (i2 < 3) {
                            i2++;
                            xVar.k.addLast(Long.valueOf(SystemClock.elapsedRealtime() + (i2 * TimeUnit.SECONDS.toMillis(2L))));
                        }
                        xVar.l = i;
                        z = false;
                    }
                }
            }
            xVar.f.bitrate = i;
            if (LiteavSystemInfo.getSystemOSVersionInt() < 19 || xVar.d == null) {
                return;
            }
            if (z) {
                xVar.f37044c.removeCallbacks(xVar.m);
                long elapsedRealtime = SystemClock.elapsedRealtime() - xVar.g;
                if (elapsedRealtime >= TimeUnit.SECONDS.toMillis(2L)) {
                    xVar.m.run();
                    return;
                } else {
                    xVar.f37044c.postDelayed(xVar.m, 2000 - elapsedRealtime);
                    return;
                }
            }
            try {
                Bundle bundle = new Bundle();
                bundle.putInt(MediaCodec.PARAMETER_KEY_VIDEO_BITRATE, i * 1024);
                xVar.d.setParameters(bundle);
            } catch (Throwable th) {
                LiteavLog.e(xVar.f37043a, "setBitrateInternal failed.", th);
            }
        }
    }
}
