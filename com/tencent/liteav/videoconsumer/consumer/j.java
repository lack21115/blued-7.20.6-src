package com.tencent.liteav.videoconsumer.consumer;

import android.os.Message;
import android.os.SystemClock;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videobase.utils.f;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;
import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/j.class */
public final class j {
    com.tencent.liteav.base.util.b b;

    /* renamed from: c  reason: collision with root package name */
    final IVideoReporter f36706c;
    VideoRenderInterface d;
    VideoRenderInterface e;
    VideoDecodeController f;
    b g;
    VideoRenderListener h;
    DisplayTarget i;
    final com.tencent.liteav.videoconsumer.renderer.f w;

    /* renamed from: a  reason: collision with root package name */
    String f36705a = "VideoConsumer";
    private VideoRenderListener A = new VideoRenderListener() { // from class: com.tencent.liteav.videoconsumer.consumer.j.1
        @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderListener
        public final void onRenderFrame(PixelFrame pixelFrame) {
            j jVar = j.this;
            jVar.a(pixelFrame);
            if (jVar.h != null) {
                jVar.h.onRenderFrame(pixelFrame);
            }
        }

        @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderListener
        public final void onRenderTargetSizeChanged(int i, int i2) {
        }
    };
    private VideoRenderListener B = new VideoRenderListener() { // from class: com.tencent.liteav.videoconsumer.consumer.j.2
        @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderListener
        public final void onRenderFrame(PixelFrame pixelFrame) {
            j.this.a(pixelFrame);
        }

        @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderListener
        public final void onRenderTargetSizeChanged(int i, int i2) {
        }
    };
    GLConstants.GLScaleType j = GLConstants.GLScaleType.CENTER_CROP;
    Rotation k = Rotation.NORMAL;
    boolean l = false;
    final com.tencent.liteav.videobase.utils.d m = new com.tencent.liteav.videobase.utils.d();
    boolean n = false;
    a p = a.STOPPED;
    boolean q = false;
    int r = 0;
    int s = 0;
    VideoDecoderDef.ConsumerScene t = VideoDecoderDef.ConsumerScene.UNKNOWN;
    Object u = null;
    final AtomicLong v = new AtomicLong(0);
    final com.tencent.liteav.videobase.utils.j x = new com.tencent.liteav.videobase.utils.j(1);
    final Runnable y = new Runnable() { // from class: com.tencent.liteav.videoconsumer.consumer.j.3
        @Override // java.lang.Runnable
        public final void run() {
            PixelFrame a2 = j.this.x.a();
            if (a2 != null) {
                j jVar = j.this;
                int width = a2.getWidth();
                int height = a2.getHeight();
                if (jVar.r != width || jVar.s != height) {
                    if (jVar.f36706c != null) {
                        jVar.f36706c.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_DECODER_WIDTH, Integer.valueOf(width));
                        jVar.f36706c.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_DECODER_HEIGHT, Integer.valueOf(height));
                    }
                    jVar.r = width;
                    jVar.s = height;
                    IVideoReporter iVideoReporter = jVar.f36706c;
                    h.b bVar = h.b.EVT_VIDEO_RENDER_RESOLUTION_CHANGE;
                    iVideoReporter.notifyEvent(bVar, "resolution change to " + width + "x" + height, new Object[0]);
                }
                for (VideoRenderInterface videoRenderInterface : jVar.a()) {
                    if (videoRenderInterface != null) {
                        videoRenderInterface.renderFrame(a2);
                    }
                }
                if (jVar.g != null) {
                    a2.getTimestamp();
                }
                a2.release();
            }
        }
    };
    final VideoDecodeController.a z = new VideoDecodeController.a() { // from class: com.tencent.liteav.videoconsumer.consumer.j.4
        @Override // com.tencent.liteav.videoconsumer.decoder.az
        public final void onAbandonDecodingFramesCompleted() {
        }

        @Override // com.tencent.liteav.videoconsumer.decoder.az
        public final void onDecodeCompleted() {
        }

        @Override // com.tencent.liteav.videoconsumer.decoder.az
        public final void onDecodeFailed() {
            j.this.a(ad.a(this), "onDecodeFailed", false);
        }

        @Override // com.tencent.liteav.videoconsumer.decoder.az
        public final void onDecodeFrame(PixelFrame pixelFrame, long j) {
            if (pixelFrame == null || j.this.p != a.STARTED) {
                return;
            }
            j.this.x.a(pixelFrame);
            j jVar = j.this;
            jVar.a(jVar.y, "onDecodeFrame", false);
        }

        @Override // com.tencent.liteav.videoconsumer.decoder.az
        public final void onDecodeLatencyChanged(boolean z) {
        }

        @Override // com.tencent.liteav.videoconsumer.decoder.az
        public final void onFrameEnqueuedToDecoder() {
        }

        @Override // com.tencent.liteav.videoconsumer.decoder.az
        public final void onRequestKeyFrame() {
            j.this.a(ae.a(this), "onRequestKeyFrame", false);
        }
    };
    final com.tencent.liteav.videobase.utils.f o = new com.tencent.liteav.videobase.utils.f("VideoConsumer", 1000, new f.a(this) { // from class: com.tencent.liteav.videoconsumer.consumer.k

        /* renamed from: a  reason: collision with root package name */
        private final j f36714a;

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            this.f36714a = this;
        }

        @Override // com.tencent.liteav.videobase.utils.f.a
        public final void a(double d) {
            this.f36714a.f36706c.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_CONSUMER_RECEIVE_FPS, Double.valueOf(d));
        }
    });

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/j$a.class */
    enum a {
        STOPPED,
        STARTED,
        PAUSED
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/j$b.class */
    public interface b {
    }

    public j(IVideoReporter iVideoReporter) {
        this.f36706c = iVideoReporter;
        this.f36705a += hashCode();
        this.w = new com.tencent.liteav.videoconsumer.renderer.f(this.f36706c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<VideoRenderInterface> a() {
        ArrayList arrayList = new ArrayList();
        VideoRenderInterface videoRenderInterface = this.d;
        if (videoRenderInterface != null) {
            arrayList.add(videoRenderInterface);
        }
        VideoRenderInterface videoRenderInterface2 = this.e;
        if (videoRenderInterface2 != null) {
            arrayList.add(videoRenderInterface2);
        }
        return arrayList;
    }

    final void a(PixelFrame pixelFrame) {
        if (pixelFrame != null) {
            this.v.getAndSet(pixelFrame.getTimestamp());
            com.tencent.liteav.videoconsumer.renderer.f fVar = this.w;
            long timestamp = pixelFrame.getTimestamp();
            int width = pixelFrame.getWidth();
            int height = pixelFrame.getHeight();
            fVar.b.a();
            if (width != fVar.f36823c || height != fVar.d) {
                fVar.f36823c = width;
                fVar.d = height;
                fVar.f36822a.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_RENDER_FRAME_WIDTH, Integer.valueOf(width));
                fVar.f36822a.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_RENDER_FRAME_HEIGHT, Integer.valueOf(height));
            }
            if (!fVar.f) {
                LiteavLog.i("VideoRenderStatistic", "rendered first frame!");
                fVar.f36822a.notifyEvent(h.b.EVT_VIDEO_RENDER_FIRST_FRAME, "rendered first frame", new Object[0]);
                fVar.f = true;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            fVar.f36822a.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_RENDER_FRAME, 0);
            fVar.f36822a.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_FRAME_RENDER_PTS, Long.valueOf(timestamp));
            fVar.e.a(elapsedRealtime);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(VideoRenderInterface videoRenderInterface) {
        if (videoRenderInterface != null) {
            videoRenderInterface.start(videoRenderInterface instanceof com.tencent.liteav.videoconsumer.consumer.a ? this.A : this.B);
            videoRenderInterface.setDisplayView(this.i, true);
            videoRenderInterface.setRenderRotation(this.k);
            videoRenderInterface.setScaleType(this.j);
            videoRenderInterface.setHorizontalMirror(this.l);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Runnable runnable, String str, boolean z) {
        com.tencent.liteav.base.util.b bVar = this.b;
        if (bVar == null) {
            LiteavLog.w(this.f36705a, "ignore runnable: ".concat(String.valueOf(str)));
        } else if (z) {
            bVar.sendMessage(bVar.obtainMessage(1, 0, 0, runnable));
        } else {
            bVar.post(runnable);
        }
    }

    public final void a(boolean z) {
        a(x.a(this, z), "Stop", false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(Message message) {
        if (message.obj instanceof Runnable) {
            Runnable runnable = (Runnable) message.obj;
            if (this.p != a.STOPPED) {
                runnable.run();
                return true;
            }
            this.m.a(runnable);
            return true;
        }
        return true;
    }
}
