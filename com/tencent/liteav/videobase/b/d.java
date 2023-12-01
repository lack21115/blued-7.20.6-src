package com.tencent.liteav.videobase.b;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.utils.OpenGlUtils;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/b/d.class */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final c f22902a;

    private d(c cVar) {
        this.f22902a = cVar;
    }

    public static Runnable a(c cVar) {
        return new d(cVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar = this.f22902a;
        if (cVar.d != null) {
            try {
                cVar.d.a();
                OpenGlUtils.deleteShaderId(cVar.b.getAndSet(-1));
            } catch (g e) {
                LiteavLog.i("EGLContextChecker", "release EGLCore failed.", e);
            }
            e.a(cVar.d);
            cVar.d = null;
        }
    }
}
