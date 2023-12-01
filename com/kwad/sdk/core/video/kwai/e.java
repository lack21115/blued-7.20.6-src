package com.kwad.sdk.core.video.kwai;

import android.content.Context;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.report.q;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.am;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/video/kwai/e.class */
public final class e {
    private static boolean QB = false;
    private static AtomicBoolean ane;
    private static int anf = -1;
    private static int anh;
    private static final AtomicBoolean Xq = new AtomicBoolean(false);
    private static final AtomicBoolean ang = new AtomicBoolean(false);

    public static c a(Context context, boolean z, boolean z2, boolean z3) {
        d bVar;
        boolean z4;
        try {
            if (tF() && z2 && yo()) {
                com.kwad.sdk.core.d.b.i("MediaPlayerImpl", "constructPlayer KwaiMediaPlayer");
                bVar = new d();
                anh = 2;
                bVar.aX(z);
            } else {
                com.kwad.sdk.core.d.b.i("MediaPlayerImpl", "constructPlayer AndroidMediaPlayer");
                bVar = new b();
                anh = 1;
            }
            z4 = false;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.e("MediaPlayerImpl", "constructPlayer exception, using AndroidMediaPlayer", th);
            if (!QB) {
                QB = true;
                com.kwad.sdk.service.b.gatherException(th);
            }
            bVar = new b();
            anh = 1;
            z4 = true;
        }
        int a2 = am.a(tF(), ServiceProvider.get(com.kwad.sdk.service.kwai.e.class) != null && ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getIsExternal(), z2, yo(), z4, z3, bVar.getMediaPlayerType());
        com.kwad.sdk.core.d.b.cb("player v=" + Integer.toBinaryString(a2));
        if (anf != a2) {
            anf = a2;
            bB(a2);
        }
        return bVar;
    }

    private static void bB(int i) {
        q qVar = new q(10212L);
        qVar.ajn = i;
        h.a2(qVar);
    }

    private static boolean tF() {
        return ang.get() || com.kwad.b.kwai.a.Hm.booleanValue();
    }

    public static int yn() {
        return anh;
    }

    private static boolean yo() {
        AtomicBoolean atomicBoolean = ane;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
        ane = atomicBoolean2;
        return atomicBoolean2.get();
    }
}
