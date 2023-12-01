package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.e;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/a.class */
public final class a extends com.tencent.liteav.videobase.a.a implements e.a {

    /* renamed from: c  reason: collision with root package name */
    CustomVideoProcessListener f23414c;
    GLConstants.PixelBufferType d;
    GLConstants.PixelFormatType e;
    private final IVideoReporter g;
    private com.tencent.liteav.videobase.frame.l i;
    private com.tencent.liteav.videobase.videobase.e j;
    private com.tencent.liteav.videobase.frame.j k;
    private PixelFrame l;
    private PixelFrame m;
    private PixelFrame n;
    private PixelFrame o;
    private final com.tencent.liteav.base.util.n h = new com.tencent.liteav.base.util.n(0, 0);
    final com.tencent.liteav.videobase.utils.d b = new com.tencent.liteav.videobase.utils.d();
    boolean f = false;
    private boolean p = false;
    private int q = -1;

    public a(IVideoReporter iVideoReporter) {
        this.g = iVideoReporter;
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x03c3, code lost:
        if (r12 != false) goto L48;
     */
    @Override // com.tencent.liteav.videobase.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.tencent.liteav.videobase.frame.d a(long r9, com.tencent.liteav.videobase.frame.d r11) {
        /*
            Method dump skipped, instructions count: 969
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.producer.a.a(long, com.tencent.liteav.videobase.frame.d):com.tencent.liteav.videobase.frame.d");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(CustomVideoProcessListener customVideoProcessListener) {
        if (customVideoProcessListener == null || this.p) {
            return;
        }
        customVideoProcessListener.onGLContextCreated();
        this.p = true;
    }

    @Override // com.tencent.liteav.videobase.a.a
    public final void b() {
        boolean d = this.h.d();
        this.h.a(0, 0);
        this.i = null;
        this.n = null;
        this.o = null;
        this.l = null;
        this.m = null;
        this.j.a();
        this.j = null;
        if (d) {
            this.b.a();
            b(this.f23414c);
        }
    }

    @Override // com.tencent.liteav.videobase.a.a
    public final void b(com.tencent.liteav.videobase.frame.e eVar) {
        this.h.a(0, 0);
        this.i = new com.tencent.liteav.videobase.frame.l();
        this.n = new PixelFrame();
        this.o = new PixelFrame();
        this.m = new PixelFrame();
        com.tencent.liteav.videobase.videobase.e eVar2 = new com.tencent.liteav.videobase.videobase.e();
        this.j = eVar2;
        eVar2.a(eVar);
        this.b.a(c.a(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(CustomVideoProcessListener customVideoProcessListener) {
        if (customVideoProcessListener == null || !this.p) {
            return;
        }
        customVideoProcessListener.onGLContextDestroy();
        this.p = false;
    }

    @Override // com.tencent.liteav.videobase.videobase.e.a
    public final void onFrameConverted(int i, PixelFrame pixelFrame) {
        if (i != 101) {
            LiteavLog.w("CustomVideoProcessListenerAdapter", "Receive frame converted, but identity is invalid(%d)", Integer.valueOf(i));
            return;
        }
        this.l = pixelFrame;
        pixelFrame.retain();
    }
}
