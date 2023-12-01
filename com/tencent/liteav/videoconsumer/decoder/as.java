package com.tencent.liteav.videoconsumer.decoder;

import android.os.Looper;
import com.tencent.liteav.base.util.r;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/as.class */
public final /* synthetic */ class as implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDecodeController f36764a;
    private final VideoDecodeController.a b;

    private as(VideoDecodeController videoDecodeController, VideoDecodeController.a aVar) {
        this.f36764a = videoDecodeController;
        this.b = aVar;
    }

    public static Runnable a(VideoDecodeController videoDecodeController, VideoDecodeController.a aVar) {
        return new as(videoDecodeController, aVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        final VideoDecodeController videoDecodeController = this.f36764a;
        VideoDecodeController.a aVar = this.b;
        if (videoDecodeController.j) {
            return;
        }
        videoDecodeController.j = true;
        videoDecodeController.g = aVar;
        videoDecodeController.m.set(0);
        videoDecodeController.f36735c.b();
        videoDecodeController.d.a();
        if (videoDecodeController.f == null) {
            videoDecodeController.f = new com.tencent.liteav.base.util.r(Looper.myLooper(), new r.a(videoDecodeController) { // from class: com.tencent.liteav.videoconsumer.decoder.at

                /* renamed from: a  reason: collision with root package name */
                private final VideoDecodeController f36765a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f36765a = videoDecodeController;
                }

                @Override // com.tencent.liteav.base.util.r.a
                public final void a_() {
                    VideoDecodeController videoDecodeController2 = this.f36765a;
                    if (videoDecodeController2.e() > 0) {
                        videoDecodeController2.d();
                    } else if (!videoDecodeController2.e || videoDecodeController2.m.get() <= 0 || videoDecodeController2.k == null) {
                    } else {
                        videoDecodeController2.k.decode(null);
                    }
                }
            });
        }
        videoDecodeController.f.a(0, 15);
    }
}
