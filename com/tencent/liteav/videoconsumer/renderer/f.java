package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.videobase.utils.f;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videoconsumer.renderer.e;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/f.class */
public final class f implements f.a {

    /* renamed from: a  reason: collision with root package name */
    public final IVideoReporter f36822a;

    /* renamed from: c  reason: collision with root package name */
    public int f36823c = 0;
    public int d = 0;
    public e e = new e(new e.a() { // from class: com.tencent.liteav.videoconsumer.renderer.f.1
        @Override // com.tencent.liteav.videoconsumer.renderer.e.a
        public final void a(long j) {
            f.this.f36822a.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_RENDER_REEZE, Long.valueOf(j));
        }
    });
    public boolean f = false;
    public final com.tencent.liteav.videobase.utils.f b = new com.tencent.liteav.videobase.utils.f("VideoRenderer", 1000, this);

    public f(IVideoReporter iVideoReporter) {
        this.f36822a = iVideoReporter;
    }

    public final void a() {
        this.f36822a.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_RENDER_FRAME, 0);
        this.f36822a.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_RENDER_RESET_FREEZE_TIME, 0);
    }

    @Override // com.tencent.liteav.videobase.utils.f.a
    public final void a(double d) {
        this.f36822a.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_RENDER_AVARAGE_FPS, Double.valueOf(d));
    }
}
