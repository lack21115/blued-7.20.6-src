package com.tencent.liteav.videoproducer.encoder;

import android.os.Looper;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.r;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/af.class */
final /* synthetic */ class af implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final x f23284a;

    private af(x xVar) {
        this.f23284a = xVar;
    }

    public static Runnable a(x xVar) {
        return new af(xVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        final x xVar = this.f23284a;
        LiteavLog.i(xVar.f23352a, "signalEndOfStream");
        if (xVar.d != null) {
            try {
                xVar.d.signalEndOfInputStream();
            } catch (Throwable th) {
                LiteavLog.e(xVar.f23352a, "signalEndOfStream failed.", th);
            }
        }
        if (xVar.h == null) {
            xVar.h = new com.tencent.liteav.base.util.r(Looper.myLooper(), new r.a(xVar) { // from class: com.tencent.liteav.videoproducer.encoder.z

                /* renamed from: a  reason: collision with root package name */
                private final x f23355a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f23355a = xVar;
                }

                @Override // com.tencent.liteav.base.util.r.a
                public final void a_() {
                    this.f23355a.c();
                }
            });
            xVar.h.a(0, 30);
        }
    }
}
