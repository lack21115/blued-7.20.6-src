package com.tencent.liteav.videoproducer.producer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.os.Looper;
import com.blued.das.live.LiveProtos;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.TimeUtil;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.common.SnapshotSourceType;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderInterface;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderListener;
import com.tencent.liteav.videoproducer.capture.CameraCaptureParams;
import com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.capture.ScreenCapturer;
import com.tencent.liteav.videoproducer.capture.VirtualCamera;
import com.tencent.liteav.videoproducer.encoder.VideoEncodeParams;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.encoder.a;
import com.tencent.liteav.videoproducer.preprocessor.BeautyProcessor;
import com.tencent.liteav.videoproducer.preprocessor.VideoPreprocessor;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;
import com.tencent.liteav.videoproducer.producer.d;
import com.tencent.liteav.videoproducer.producer.e;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/f.class */
public final class f implements CaptureSourceInterface.a, com.tencent.liteav.videoproducer.preprocessor.ag, d.a, com.tencent.rtmp.ui.a, com.tencent.rtmp.ui.b {
    private DisplayTarget A;
    private volatile VideoRenderListener E;
    private a J;
    final IVideoReporter b;

    /* renamed from: c  reason: collision with root package name */
    final VideoPreprocessor f23465c;
    final BeautyProcessor d;
    com.tencent.liteav.base.util.b e;
    private final Context g;
    private com.tencent.liteav.videobase.b.e h;
    private ServerVideoProducerConfig j;
    private d n;
    private CaptureSourceInterface q;
    private CaptureSourceInterface.CaptureParams r;
    private final ax s;
    private PixelFrame t;
    private final ConcurrentHashMap<VideoProducerDef.StreamType, GLConstants.Orientation> u;
    private final ConcurrentHashMap<VideoProducerDef.StreamType, com.tencent.liteav.videoproducer.encoder.ai> z;

    /* renamed from: a  reason: collision with root package name */
    String f23464a = "VideoProducer";
    volatile boolean f = false;
    private Object i = null;
    private VideoProducerDef.GSensorMode k = VideoProducerDef.GSensorMode.UI_FIX_LAYOUT;
    private Rotation l = Rotation.NORMAL;
    private int m = 0;
    private boolean o = false;
    private volatile CaptureSourceInterface.SourceType p = CaptureSourceInterface.SourceType.NONE;
    private Rotation v = Rotation.NORMAL;
    private boolean w = false;
    private JSONArray x = null;
    private final Map<VideoProducerDef.StreamType, VideoEncoderDef.EncodeStrategy> y = new HashMap<VideoProducerDef.StreamType, VideoEncoderDef.EncodeStrategy>() { // from class: com.tencent.liteav.videoproducer.producer.f.1
        {
            put(VideoProducerDef.StreamType.STREAM_TYPE_BIG_VIDEO, VideoEncoderDef.EncodeStrategy.PREFER_HARDWARE);
            put(VideoProducerDef.StreamType.STREAM_TYPE_SMALL_VIDEO, VideoEncoderDef.EncodeStrategy.USE_SOFTWARE_ONLY);
            put(VideoProducerDef.StreamType.STREAM_TYPE_SUB_VIDEO, VideoEncoderDef.EncodeStrategy.PREFER_HARDWARE);
        }
    };
    private Rotation B = Rotation.NORMAL;
    private GLConstants.MirrorMode C = GLConstants.MirrorMode.AUTO;
    private GLConstants.GLScaleType D = GLConstants.GLScaleType.CENTER_CROP;
    private VideoRenderInterface F = null;
    private VideoRenderListener G = new VideoRenderListener() { // from class: com.tencent.liteav.videoproducer.producer.f.2
        @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderListener
        public final void onRenderFrame(PixelFrame pixelFrame) {
            f.this.a(pixelFrame);
        }

        @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderListener
        public final void onRenderTargetSizeChanged(int i, int i2) {
        }
    };
    private VideoRenderInterface H = null;
    private VideoRenderListener I = new VideoRenderListener() { // from class: com.tencent.liteav.videoproducer.producer.f.3
        @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderListener
        public final void onRenderFrame(PixelFrame pixelFrame) {
            f.b(f.this, pixelFrame);
        }

        @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderListener
        public final void onRenderTargetSizeChanged(int i, int i2) {
        }
    };
    private final com.tencent.liteav.base.util.n K = new com.tencent.liteav.base.util.n();
    private final com.tencent.liteav.base.util.n L = new com.tencent.liteav.base.util.n();
    private final e M = new e();
    private boolean N = false;
    private boolean O = false;
    private boolean P = false;
    private final com.tencent.liteav.base.util.n Q = new com.tencent.liteav.base.util.n(0, 0);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.videoproducer.producer.f$4  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/f$4.class */
    public static final /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23468a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[VideoProducerDef.HomeOrientation.values().length];
            f23468a = iArr;
            try {
                iArr[VideoProducerDef.HomeOrientation.RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23468a[VideoProducerDef.HomeOrientation.UP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23468a[VideoProducerDef.HomeOrientation.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f23468a[VideoProducerDef.HomeOrientation.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f23468a[VideoProducerDef.HomeOrientation.UNSET.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public f(Context context, boolean z, IVideoReporter iVideoReporter) {
        this.g = context;
        this.b = iVideoReporter;
        BeautyProcessor beautyProcessor = new BeautyProcessor(this.g, z, this.b);
        this.d = beautyProcessor;
        this.f23465c = new VideoPreprocessor(this.g, beautyProcessor, iVideoReporter);
        this.z = new ConcurrentHashMap<>();
        this.u = new ConcurrentHashMap<>();
        this.s = new ax(this.g);
        this.f23464a += "_" + hashCode();
    }

    private Rotation a(VideoProducerDef.StreamType streamType) {
        Rotation rotation = Rotation.NORMAL;
        if (this.p != CaptureSourceInterface.SourceType.CAMERA) {
            return rotation;
        }
        if (this.k != VideoProducerDef.GSensorMode.DISABLE) {
            if (this.l == null) {
                return rotation;
            }
            return Rotation.a(CameraCaptureSingleton.getInstance().isFrontCamera() ? (360 - this.l.mValue) % 360 : this.l.mValue);
        }
        Rotation rotation2 = rotation;
        if (this.u.get(streamType) == GLConstants.Orientation.LANDSCAPE) {
            rotation2 = rotation;
            if (this.s.a() == VideoProducerDef.HomeOrientation.UNSET) {
                rotation2 = CameraCaptureSingleton.getInstance().isFrontCamera() ? Rotation.ROTATION_90 : Rotation.ROTATION_270;
            }
        }
        return rotation2;
    }

    private static com.tencent.liteav.videoproducer.capture.s a(CaptureSourceInterface captureSourceInterface) {
        if (captureSourceInterface instanceof com.tencent.liteav.videoproducer.capture.ah) {
            CaptureSourceInterface captureSourceInterface2 = ((com.tencent.liteav.videoproducer.capture.ah) captureSourceInterface).f23174c;
            if (captureSourceInterface2 instanceof com.tencent.liteav.videoproducer.capture.s) {
                return (com.tencent.liteav.videoproducer.capture.s) captureSourceInterface2;
            }
            return null;
        }
        return null;
    }

    private VideoEncodeParams a(VideoEncodeParams videoEncodeParams) {
        com.tencent.liteav.base.util.n d = this.s.d();
        this.s.b(new com.tencent.liteav.base.util.n(videoEncodeParams.width, videoEncodeParams.height));
        com.tencent.liteav.base.util.n d2 = this.s.d();
        if (videoEncodeParams.width != d2.f22649a || videoEncodeParams.height != d2.b) {
            String str = this.f23464a;
            LiteavLog.i(str, "update encode size from " + videoEncodeParams.width + "x" + videoEncodeParams.height + " to " + d2.f22649a + "x" + d2.b);
            videoEncodeParams.width = d2.f22649a;
            videoEncodeParams.height = d2.b;
        }
        if (!d.equals(d2)) {
            LiteavLog.i(this.f23464a, "producer with encoder ".concat(String.valueOf(d2)));
        }
        return videoEncodeParams;
    }

    private void a(int i) {
        boolean z;
        CaptureSourceInterface captureSourceInterface;
        com.tencent.liteav.base.util.n b = this.s.b();
        boolean z2 = false;
        if (this.r != null) {
            if (b.f22649a != this.r.f23155c || b.b != this.r.d) {
                this.r.f23155c = b.f22649a;
                this.r.d = b.b;
                z2 = true;
            }
            if (i > this.r.b) {
                this.r.b = i;
                z = true;
            } else {
                z = z2;
            }
        } else {
            LiteavLog.w(this.f23464a, "updateCapturePreviewSizeFromSupervisor mCaptureParams==null!");
            z = false;
        }
        if (z && (captureSourceInterface = this.q) != null) {
            captureSourceInterface.updateParams(this.r);
        }
        if (this.s.c().equals(this.L)) {
            return;
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PixelFrame pixelFrame) {
        if (pixelFrame != null && (pixelFrame.getWidth() != this.Q.f22649a || pixelFrame.getHeight() != this.Q.b)) {
            this.Q.a(pixelFrame.getWidth(), pixelFrame.getHeight());
            this.b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_RENDER_FRAME_WIDTH, Integer.valueOf(this.Q.f22649a));
            this.b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_RENDER_FRAME_HEIGHT, Integer.valueOf(this.Q.b));
        }
        if (!this.N) {
            LiteavLog.d(this.f23464a, "rendered first frame!");
            this.b.notifyEvent(h.b.EVT_VIDEO_RENDER_FIRST_FRAME, "rendered first frame", new Object[0]);
            this.N = true;
        }
        this.b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_RENDER_FRAME, 0);
    }

    private void a(PixelFrame pixelFrame, VideoRenderInterface videoRenderInterface) {
        if (videoRenderInterface == null) {
            return;
        }
        e eVar = this.M;
        long timestamp = pixelFrame.getTimestamp();
        e.b bVar = new e.b();
        if (eVar.f23459c == CaptureSourceInterface.SourceType.CUSTOM || (eVar.f23459c == CaptureSourceInterface.SourceType.CAMERA && eVar.e != VideoProducerDef.HomeOrientation.UNSET)) {
            bVar.f23463a = eVar.c(timestamp);
            e.b a2 = eVar.a(timestamp);
            if (a2.f23463a || a2.b) {
                bVar.f23463a = !bVar.f23463a;
            }
        } else if (eVar.f23459c == CaptureSourceInterface.SourceType.CAMERA) {
            boolean z = false;
            if (eVar.d == Rotation.NORMAL || eVar.d == Rotation.ROTATION_180) {
                bVar.f23463a = eVar.c(timestamp);
            } else {
                boolean c2 = eVar.c(timestamp);
                e.a b = eVar.b(timestamp);
                bVar.f23463a = b.f23461a;
                if (!b.f23461a) {
                    z = c2;
                } else if (!c2) {
                    z = true;
                }
            }
            bVar.b = z;
            e.b a3 = eVar.a(timestamp);
            if (a3.f23463a) {
                bVar.f23463a = !bVar.f23463a;
            }
            if (a3.b) {
                bVar.b = !bVar.b;
            }
        }
        videoRenderInterface.setHorizontalMirror(bVar.f23463a);
        videoRenderInterface.setVerticalMirror(bVar.b);
        videoRenderInterface.renderFrame(pixelFrame);
    }

    private void a(DisplayTarget displayTarget, boolean z) {
        String str = this.f23464a;
        LiteavLog.i(str, "setDisplayView " + displayTarget + ",clearLastImage=" + z);
        this.A = displayTarget;
        if ((displayTarget != null ? displayTarget.getTXCloudVideoView() : null) != null) {
            e(true);
            f(true);
        }
        for (VideoRenderInterface videoRenderInterface : h()) {
            if (videoRenderInterface != null) {
                videoRenderInterface.setDisplayView(this.A, z);
            }
        }
    }

    private void a(VideoRenderInterface videoRenderInterface, VideoRenderListener videoRenderListener) {
        if (videoRenderInterface != null) {
            videoRenderInterface.setDisplayView(this.A, true);
            videoRenderInterface.start(videoRenderListener);
            videoRenderInterface.setScaleType(this.D);
        }
        g();
    }

    private static void a(CaptureSourceInterface.CaptureParams captureParams) {
        if (captureParams instanceof CameraCaptureParams) {
            ((CameraCaptureParams) captureParams).f23151a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar) {
        LiteavLog.i(fVar.f23464a, "Stop custom capture");
        fVar.c();
        fVar.p = CaptureSourceInterface.SourceType.NONE;
        fVar.f23465c.setSourceType(fVar.p);
        fVar.M.a(fVar.p);
        fVar.s.f23450a = fVar.p;
        fVar.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, float f) {
        com.tencent.liteav.videoproducer.capture.s a2;
        if (fVar.p == CaptureSourceInterface.SourceType.CAMERA && (a2 = a(fVar.q)) != null) {
            a2.a(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, int i, int i2) {
        DisplayTarget displayTarget = fVar.A;
        if (displayTarget != null) {
            com.tencent.liteav.base.util.n size = displayTarget.getSize();
            fVar.a(i, i2, size.f22649a, size.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, int i, PixelFrame pixelFrame) {
        if (fVar.h != null) {
            if (pixelFrame.getGLContext() != null) {
                pixelFrame.setGLContext(fVar.h.d());
            }
            if (i == 1) {
                for (com.tencent.liteav.videoproducer.encoder.ai aiVar : fVar.z.values()) {
                    if (aiVar != null) {
                        aiVar.a(pixelFrame);
                    }
                }
            } else if (i == 2) {
                fVar.a(pixelFrame, fVar.F);
                fVar.a(pixelFrame, fVar.H);
                e eVar = fVar.M;
                long timestamp = pixelFrame.getTimestamp();
                if (eVar.b != -1) {
                    eVar.f23458a.remove(eVar.b);
                }
                eVar.b = timestamp;
            }
        }
        pixelFrame.release();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, int i, VideoProducerDef.StreamType streamType) {
        LiteavLog.i(fVar.f23464a, "setRPSNearestREFSize: %d", Integer.valueOf(i));
        com.tencent.liteav.videoproducer.encoder.ai aiVar = fVar.z.get(streamType);
        if (aiVar == null) {
            LiteavLog.w(fVar.f23464a, "setRPSNearestREFSize with stream type: %s, but can't find matched videoEncodeController.", streamType);
        } else {
            aiVar.a(com.tencent.liteav.videoproducer.encoder.an.a(aiVar, i), "setRPSNearestREFSize");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, Bitmap bitmap, int i) {
        if (fVar.q == null) {
            return;
        }
        int i2 = 64;
        int width = bitmap != null ? bitmap.getWidth() : 64;
        if (bitmap != null) {
            i2 = bitmap.getHeight();
        }
        CaptureSourceInterface captureSourceInterface = fVar.q;
        if (captureSourceInterface instanceof com.tencent.liteav.videoproducer.capture.ah) {
            ((com.tencent.liteav.videoproducer.capture.ah) captureSourceInterface).a(bitmap, i, width, i2);
        } else if (captureSourceInterface instanceof VirtualCamera) {
            LiteavLog.w(fVar.f23464a, "setPausedImage in Start param.");
        } else {
            LiteavLog.w(fVar.f23464a, "setPausedImage failed!");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, Point point, int i, int i2, int i3, int i4) {
        com.tencent.liteav.videoproducer.capture.s a2;
        if (fVar.p == CaptureSourceInterface.SourceType.CAMERA && (a2 = a(fVar.q)) != null && (!CameraCaptureSingleton.getInstance().isAutoFocusEnabled())) {
            a2.a(point.x, point.y);
            DisplayTarget displayTarget = fVar.A;
            TXCloudVideoView tXCloudVideoView = displayTarget == null ? null : displayTarget.getTXCloudVideoView();
            if (tXCloudVideoView != null) {
                try {
                    Method declaredMethod = TXCloudVideoView.class.getDeclaredMethod("showFocusView", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(tXCloudVideoView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                } catch (Exception e) {
                    LiteavLog.e(fVar.f23464a, "showFocusViewInternal Exception:".concat(String.valueOf(e)));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, GLConstants.GLScaleType gLScaleType) {
        LiteavLog.i(fVar.f23464a, "setRenderScaleType: %s", gLScaleType.name());
        fVar.D = gLScaleType;
        for (VideoRenderInterface videoRenderInterface : fVar.h()) {
            if (videoRenderInterface != null) {
                videoRenderInterface.setScaleType(gLScaleType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, GLConstants.MirrorMode mirrorMode) {
        LiteavLog.i(fVar.f23464a, "setRenderMirrorMode: %s", mirrorMode.name());
        fVar.C = mirrorMode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, VideoRenderListener videoRenderListener) {
        String str = fVar.f23464a;
        LiteavLog.i(str, "setCustomRenderListener PixelFormatType = " + pixelFormatType + ",  PixelBufferType = " + pixelBufferType + " listener= " + videoRenderListener);
        fVar.E = videoRenderListener;
        if (fVar.E != null) {
            if (fVar.H == null) {
                com.tencent.liteav.videoconsumer.consumer.a aVar = new com.tencent.liteav.videoconsumer.consumer.a(fVar.e.getLooper());
                fVar.H = aVar;
                fVar.a(aVar, fVar.I);
            }
            ((com.tencent.liteav.videoconsumer.consumer.a) fVar.H).a(pixelFormatType, pixelBufferType);
            return;
        }
        VideoRenderInterface videoRenderInterface = fVar.H;
        if (videoRenderInterface != null) {
            videoRenderInterface.stop(true);
            fVar.H = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, CustomVideoProcessListener customVideoProcessListener) {
        String str = fVar.f23464a;
        LiteavLog.i(str, "setCustomVideoProcessListener PixelFormatType = " + pixelFormatType + ",  PixelBufferType = " + pixelBufferType + " listener= " + customVideoProcessListener);
        if (fVar.J == null) {
            fVar.J = new a(fVar.b);
        }
        a aVar = fVar.J;
        LiteavLog.i("CustomVideoProcessListenerAdapter", "setCustomVideoProcessListener PixelFormatType = " + pixelFormatType + ",  PixelBufferType = " + pixelBufferType + " listener= " + customVideoProcessListener);
        aVar.b.a(b.a(aVar, pixelFormatType, pixelBufferType, customVideoProcessListener));
        fVar.f23465c.setInterceptorBeforeWatermark(fVar.J);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, TakeSnapshotListener takeSnapshotListener, SnapshotSourceType snapshotSourceType) {
        VideoRenderInterface videoRenderInterface;
        LiteavLog.i(fVar.f23464a, "takeSnapshot: ".concat(String.valueOf(takeSnapshotListener)));
        if (snapshotSourceType == SnapshotSourceType.STREAM) {
            for (com.tencent.liteav.videoproducer.encoder.ai aiVar : fVar.z.values()) {
                if (aiVar != null) {
                    aiVar.a(com.tencent.liteav.videoproducer.encoder.at.a(aiVar, takeSnapshotListener), "snapshot");
                    return;
                }
            }
        } else if (snapshotSourceType == SnapshotSourceType.VIEW) {
            if (fVar.A != null && (videoRenderInterface = fVar.F) != null) {
                videoRenderInterface.takeSnapshot(takeSnapshotListener);
                return;
            }
            VideoRenderInterface videoRenderInterface2 = fVar.H;
            if (videoRenderInterface2 != null) {
                videoRenderInterface2.takeSnapshot(takeSnapshotListener);
                return;
            }
            LiteavLog.w(fVar.f23464a, "takeSnapshot return null, no match render.");
            if (takeSnapshotListener != null) {
                takeSnapshotListener.onComplete(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, PixelFrame pixelFrame, int i, int i2) {
        if (fVar.p != CaptureSourceInterface.SourceType.CUSTOM) {
            pixelFrame.release();
            return;
        }
        if (pixelFrame.getTimestamp() == 0) {
            pixelFrame.setTimestamp(TimeUtil.c());
        }
        fVar.b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_INCOME_FRAME, 0);
        fVar.b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_CAPTURE_FRAME, 0);
        fVar.M.a(pixelFrame.getTimestamp(), fVar.C);
        fVar.M.a(pixelFrame.getTimestamp(), fVar.w);
        boolean z = false;
        if (fVar.K.f22649a == i) {
            z = false;
            if (fVar.K.b == i2) {
                z = true;
            }
        }
        if (!z || !fVar.o) {
            fVar.s.a(VideoProducerDef.ProducerMode.MANUAL);
            fVar.s.a(new com.tencent.liteav.base.util.n(i, i2));
            fVar.e();
            fVar.K.a(i, i2);
        }
        if (pixelFrame.getGLContext() != null && !CommonUtil.equals(fVar.i, pixelFrame.getGLContext())) {
            fVar.f();
            fVar.a(pixelFrame.getGLContext());
        }
        e.b a2 = fVar.M.a(pixelFrame.getTimestamp());
        if ((pixelFrame.getRotation() == Rotation.ROTATION_90 || pixelFrame.getRotation() == Rotation.ROTATION_270) && a2.f23463a != a2.b) {
            boolean z2 = a2.f23463a;
            a2.f23463a = a2.b;
            a2.b = z2;
        }
        if (a2.f23463a) {
            pixelFrame.setMirrorHorizontal(!pixelFrame.isMirrorHorizontal());
        }
        if (a2.b) {
            pixelFrame.setMirrorVertical(!pixelFrame.isMirrorVertical());
        }
        if (pixelFrame.getGLContext() == null) {
            pixelFrame.setGLContext(fVar.h.d());
        }
        fVar.f23465c.processFrame(pixelFrame);
        pixelFrame.release();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, PixelFrame pixelFrame, CaptureSourceInterface captureSourceInterface) {
        fVar.b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_CAPTURE_FRAME, 0);
        if (!fVar.O) {
            fVar.O = true;
            fVar.b.notifyEvent(h.b.EVT_VIDEO_CAPTURE_FIRST_FRAME, "capture first frame", new Object[0]);
            LiteavLog.d(fVar.f23464a, "receive first capture frame! ");
        }
        com.tencent.liteav.base.util.n nVar = fVar.s.f;
        if (!fVar.o || nVar.f22649a != pixelFrame.getWidth() || nVar.b != pixelFrame.getHeight()) {
            ax axVar = fVar.s;
            axVar.f.a(new com.tencent.liteav.base.util.n(pixelFrame.getWidth(), pixelFrame.getHeight()));
            axVar.g.a(0, 0);
            fVar.e();
            if (fVar.p == CaptureSourceInterface.SourceType.SCREEN) {
                for (com.tencent.liteav.videoproducer.encoder.ai aiVar : fVar.z.values()) {
                    if (aiVar != null) {
                        VideoEncodeParams a2 = fVar.a(aiVar.f());
                        fVar.a(a2.fps);
                        aiVar.a(a2);
                    }
                }
            }
        }
        if (a(captureSourceInterface) != null) {
            PixelFrame pixelFrame2 = new PixelFrame(pixelFrame);
            fVar.t = pixelFrame2;
            pixelFrame2.setRotation(CameraCaptureSingleton.getInstance().getCameraRotation());
            fVar.M.b(pixelFrame.getTimestamp()).f23461a = CameraCaptureSingleton.getInstance().isFrontCamera();
            fVar.M.a(pixelFrame.getTimestamp(), fVar.C);
            fVar.M.a(pixelFrame.getTimestamp(), fVar.w);
            Rotation cameraRotation = CameraCaptureSingleton.getInstance().getCameraRotation();
            int i = cameraRotation != null ? cameraRotation.mValue : 0;
            int i2 = AnonymousClass4.f23468a[fVar.s.a().ordinal()];
            if (i2 == 1) {
                pixelFrame.setRotation(Rotation.a(360 - i));
                pixelFrame.swapWidthHeight();
            } else if (i2 == 2) {
                pixelFrame.setRotation(Rotation.ROTATION_180);
            } else if (i2 == 3) {
                pixelFrame.setRotation(Rotation.a((LiveProtos.Event.LIVE_BAG_CHAT_MARK_SHOW_VALUE - i) % 360));
                pixelFrame.swapWidthHeight();
            }
            e.b a3 = fVar.M.a(pixelFrame.getTimestamp());
            if (a3.f23463a) {
                pixelFrame.setMirrorHorizontal(!pixelFrame.isMirrorHorizontal());
            }
            if (a3.b) {
                pixelFrame.setMirrorVertical(!pixelFrame.isMirrorVertical());
            }
        }
        if (pixelFrame.getGLContext() == null) {
            pixelFrame.setGLContext(fVar.h.d());
        }
        fVar.f23465c.processFrame(pixelFrame);
        pixelFrame.release();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, Rotation rotation) {
        LiteavLog.i(fVar.f23464a, "setRenderRotation: %s, GSensorMode is %s", rotation.name(), fVar.k.name());
        fVar.B = rotation;
        fVar.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, Rotation rotation, int i) {
        LiteavLog.i(fVar.f23464a, "onOrientationChanged: %s, displayRotation:%d", rotation, Integer.valueOf(i));
        fVar.l = rotation;
        fVar.m = i;
        e eVar = fVar.M;
        Rotation rotation2 = rotation;
        if (rotation == null) {
            rotation2 = Rotation.NORMAL;
        }
        eVar.d = rotation2;
        fVar.g();
        fVar.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, DisplayTarget displayTarget, boolean z) {
        if (CommonUtil.equals(fVar.A, displayTarget)) {
            return;
        }
        fVar.a(displayTarget, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, CaptureSourceInterface.SourceType sourceType, VideoProducerDef.ProducerMode producerMode, CaptureSourceInterface.CaptureParams captureParams) {
        String str = fVar.f23464a;
        LiteavLog.i(str, "setCaptureParams " + sourceType + " ,mode = " + producerMode + " , " + captureParams.toString());
        LiteavLog.d(fVar.f23464a, "setCaptureParamInternal ".concat(String.valueOf(sourceType)));
        if (fVar.p != sourceType) {
            String str2 = fVar.f23464a;
            LiteavLog.i(str2, "setCaptureParamInternal sourcetype not match: " + sourceType + " , current is " + fVar.p);
        } else if (fVar.q == null || fVar.r == null) {
            String str3 = fVar.f23464a;
            LiteavLog.i(str3, "setCaptureParamInternal capturesource is " + fVar.q + ", " + fVar.r);
        } else if (producerMode == fVar.s.b && fVar.r.equals(captureParams)) {
        } else {
            fVar.d.setPerformanceMode(producerMode == VideoProducerDef.ProducerMode.PERFORMANCE);
            fVar.s.a(producerMode);
            fVar.s.a(new com.tencent.liteav.base.util.n(captureParams.f23155c, captureParams.d));
            fVar.s.a(captureParams.e);
            com.tencent.liteav.base.util.n b = fVar.s.b();
            captureParams.f23155c = b.f22649a;
            captureParams.d = b.b;
            if (!fVar.s.c().equals(fVar.L)) {
                fVar.e();
            }
            if (captureParams instanceof CameraCaptureParams) {
                fVar.r = new CameraCaptureParams((CameraCaptureParams) captureParams);
            } else if (captureParams instanceof VirtualCamera.VirtualCameraParams) {
                fVar.r = new VirtualCamera.VirtualCameraParams((VirtualCamera.VirtualCameraParams) captureParams);
            } else if (captureParams instanceof ScreenCapturer.ScreenCaptureParams) {
                fVar.r = new ScreenCapturer.ScreenCaptureParams((ScreenCapturer.ScreenCaptureParams) captureParams);
            } else if (captureParams instanceof CaptureSourceInterface.CaptureParams) {
                fVar.r = new CaptureSourceInterface.CaptureParams(captureParams);
            }
            fVar.q.updateParams(fVar.r);
            a(fVar.r);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, ServerVideoProducerConfig serverVideoProducerConfig) {
        LiteavLog.i(fVar.f23464a, "setServerConfig=".concat(String.valueOf(serverVideoProducerConfig)));
        fVar.j = serverVideoProducerConfig;
        for (com.tencent.liteav.videoproducer.encoder.ai aiVar : fVar.z.values()) {
            if (aiVar != null) {
                aiVar.a(serverVideoProducerConfig);
            }
        }
        CameraCaptureSingleton.getInstance().setServerConfig(serverVideoProducerConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, VideoProducerDef.GSensorMode gSensorMode) {
        if (fVar.p == CaptureSourceInterface.SourceType.SCREEN) {
            LiteavLog.i(fVar.f23464a, "setGSensorMode has been ignored for screen capturing");
            return;
        }
        fVar.k = gSensorMode;
        fVar.M.f = gSensorMode;
        LiteavLog.i(fVar.f23464a, "set GSensor mode to %s", gSensorMode);
        fVar.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, VideoProducerDef.HomeOrientation homeOrientation) {
        if (fVar.p == CaptureSourceInterface.SourceType.SCREEN) {
            LiteavLog.i(fVar.f23464a, "setHomeOrientation has been ignored for screen capturing");
            return;
        }
        d dVar = fVar.n;
        if (dVar != null) {
            dVar.disable();
        }
        fVar.s.f23451c = homeOrientation;
        fVar.M.e = homeOrientation == null ? VideoProducerDef.HomeOrientation.UNSET : homeOrientation;
        LiteavLog.i(fVar.f23464a, "set HomeOrientation to %s", homeOrientation);
        if (!fVar.s.c().equals(fVar.L)) {
            fVar.e();
        }
        fVar.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, VideoProducerDef.StreamType streamType) {
        LiteavLog.i(fVar.f23464a, "requestKeyFrame");
        com.tencent.liteav.videoproducer.encoder.ai aiVar = fVar.z.get(streamType);
        if (aiVar == null) {
            LiteavLog.w(fVar.f23464a, "requestKeyFrame with stream type: %s, but can't find matched videoEncodeController.", streamType);
        } else {
            aiVar.a(com.tencent.liteav.videoproducer.encoder.al.a(aiVar), "restartIDRFrame");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, VideoProducerDef.StreamType streamType, int i, int i2) {
        com.tencent.liteav.videoproducer.encoder.ai aiVar = fVar.z.get(streamType);
        if (aiVar == null) {
            LiteavLog.w(fVar.f23464a, "ackRPSRecvFrameIndex with stream type: %s, but can't find matched videoEncodeController.", streamType);
        } else {
            aiVar.a(com.tencent.liteav.videoproducer.encoder.ao.a(aiVar, i, i2), "ackRPSRecvFrameIndex");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, VideoProducerDef.StreamType streamType, GLConstants.Orientation orientation, VideoEncodeParams videoEncodeParams) {
        String str = fVar.f23464a;
        LiteavLog.i(str, "setEncodeParams:  streamType:" + streamType + " orientation:" + orientation + " params:" + videoEncodeParams);
        if (orientation != null) {
            GLConstants.Orientation orientation2 = fVar.u.get(streamType);
            fVar.u.put(streamType, orientation);
            fVar.s.e = orientation;
            if (orientation2 != orientation) {
                fVar.b(streamType);
            }
        }
        VideoEncodeParams a2 = fVar.a(videoEncodeParams);
        if (streamType != VideoProducerDef.StreamType.STREAM_TYPE_SMALL_VIDEO) {
            fVar.a(a2.fps);
        }
        com.tencent.liteav.videoproducer.encoder.ai aiVar = fVar.z.get(streamType);
        if (aiVar != null) {
            aiVar.a(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, VideoProducerDef.StreamType streamType, VideoEncodeParams videoEncodeParams, VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener) {
        if (fVar.z.get(streamType) != null) {
            LiteavLog.w(fVar.f23464a, "%s video encoder is started", streamType.toString());
            return;
        }
        String str = fVar.f23464a;
        LiteavLog.i(str, "startEncodeStreamInternal: " + streamType + "; " + videoEncodeParams);
        videoEncodeParams.fps = Math.min(20, videoEncodeParams.fps);
        VideoEncodeParams a2 = fVar.a(videoEncodeParams);
        if (streamType != VideoProducerDef.StreamType.STREAM_TYPE_SMALL_VIDEO) {
            fVar.a(a2.fps);
        }
        a2.mediaCodecDeviceRelatedParams = fVar.x;
        com.tencent.liteav.videoproducer.encoder.ai aiVar = new com.tencent.liteav.videoproducer.encoder.ai(fVar.b, streamType, a2.isTranscodingMode());
        aiVar.b();
        aiVar.a(fVar.j);
        aiVar.a(fVar.y.get(streamType));
        fVar.z.put(streamType, aiVar);
        fVar.b(streamType);
        aiVar.a(a2, videoEncoderDataListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, VideoProducerDef.StreamType streamType, VideoEncoderDef.EncodeStrategy encodeStrategy) {
        VideoEncoderDef.EncodeStrategy encodeStrategy2;
        if (streamType == VideoProducerDef.StreamType.STREAM_TYPE_SMALL_VIDEO || (encodeStrategy2 = fVar.y.get(streamType)) == null || encodeStrategy2 == encodeStrategy) {
            return;
        }
        String str = fVar.f23464a;
        LiteavLog.i(str, "setEncodeStrategy: " + streamType + " " + encodeStrategy);
        fVar.y.put(streamType, encodeStrategy);
        com.tencent.liteav.videoproducer.encoder.ai aiVar = fVar.z.get(streamType);
        if (aiVar != null) {
            aiVar.a(encodeStrategy);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, String str) {
        try {
            LiteavLog.i(fVar.f23464a, "setHWEncoderDeviceRelatedParams: ".concat(String.valueOf(str)));
            fVar.x = new JSONArray(str);
        } catch (JSONException e) {
            LiteavLog.e(fVar.f23464a, "setHWEncoderDeviceRelatedParams error ".concat(String.valueOf(e)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, boolean z) {
        DisplayTarget displayTarget = fVar.A;
        if ((displayTarget != null ? displayTarget.getTXCloudVideoView() : null) != null) {
            fVar.f(z);
        }
    }

    private void a(Object obj) {
        LiteavLog.i(this.f23464a, "initOpenGLComponents");
        if (!CommonUtil.equals(this.i, obj)) {
            f();
        }
        if (this.h != null) {
            return;
        }
        this.i = obj;
        com.tencent.liteav.videobase.b.e eVar = new com.tencent.liteav.videobase.b.e();
        this.h = eVar;
        try {
            eVar.a(obj, null, 128, 128);
        } catch (com.tencent.liteav.videobase.b.g e) {
            this.h = null;
            LiteavLog.e(this.f23464a, "EGLCore create failed.", e);
        }
    }

    public static VideoEncoderDef.EncodeAbility b() {
        com.tencent.liteav.videoproducer.encoder.a aVar;
        aVar = a.C0771a.f23277a;
        return aVar.f23276a;
    }

    private void b(VideoProducerDef.StreamType streamType) {
        com.tencent.liteav.videoproducer.encoder.ai aiVar = this.z.get(streamType);
        if (aiVar == null) {
            return;
        }
        aiVar.b(this.k == VideoProducerDef.GSensorMode.DISABLE ? this.v : Rotation.NORMAL);
        aiVar.a(a(streamType));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(f fVar) {
        LiteavLog.i(fVar.f23464a, "uninitialize");
        fVar.c();
        for (com.tencent.liteav.videoproducer.encoder.ai aiVar : fVar.z.values()) {
            if (aiVar != null) {
                aiVar.d();
                aiVar.e();
                aiVar.c();
            }
        }
        fVar.z.clear();
        fVar.s.b(new com.tencent.liteav.base.util.n());
        synchronized (fVar) {
            if (!fVar.f) {
                LiteavLog.w(fVar.f23464a, "videoproducer already uninitialize.");
                return;
            }
            com.tencent.liteav.base.util.b bVar = fVar.e;
            fVar.e = null;
            fVar.f = false;
            fVar.f23465c.uninitialize();
            fVar.F = null;
            fVar.H = null;
            fVar.f();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(f fVar, int i, VideoProducerDef.StreamType streamType) {
        LiteavLog.i(fVar.f23464a, "setRPSIFrameFPS: %d", Integer.valueOf(i));
        com.tencent.liteav.videoproducer.encoder.ai aiVar = fVar.z.get(streamType);
        if (aiVar == null) {
            LiteavLog.w(fVar.f23464a, "setRPSIFrameFPS with stream type: %s, but can't find matched videoEncodeController.", streamType);
        } else {
            aiVar.a(com.tencent.liteav.videoproducer.encoder.am.a(aiVar, i), "setRPSIFrameFPS");
        }
    }

    static /* synthetic */ void b(f fVar, PixelFrame pixelFrame) {
        fVar.a(pixelFrame);
        if (fVar.E != null) {
            fVar.E.onRenderFrame(pixelFrame);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(f fVar, Rotation rotation) {
        LiteavLog.i(fVar.f23464a, "setEncodeRotation rotation: %s, GSensor mode: %s", rotation, fVar.k);
        if (fVar.v == rotation) {
            return;
        }
        fVar.v = rotation;
        fVar.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(f fVar, CaptureSourceInterface.SourceType sourceType, VideoProducerDef.ProducerMode producerMode, CaptureSourceInterface.CaptureParams captureParams) {
        String str = fVar.f23464a;
        LiteavLog.i(str, "startCaptureInternal sourceType:" + sourceType + ",mode:" + producerMode + ",captureParams:" + captureParams);
        if (fVar.p != CaptureSourceInterface.SourceType.NONE || fVar.p == CaptureSourceInterface.SourceType.CUSTOM) {
            String str2 = fVar.f23464a;
            LiteavLog.w(str2, "can't Start when sourceType isn't NONE. current is " + fVar.p.name());
            return;
        }
        fVar.a(com.tencent.liteav.videoproducer.capture.au.a().b());
        fVar.p = sourceType;
        fVar.r = captureParams;
        fVar.d.setPerformanceMode(producerMode == VideoProducerDef.ProducerMode.PERFORMANCE);
        fVar.f23465c.setSourceType(fVar.p);
        fVar.M.a(fVar.p);
        fVar.s.f23450a = fVar.p;
        fVar.s.a(producerMode);
        fVar.s.a(fVar.r.e);
        fVar.s.a(new com.tencent.liteav.base.util.n(fVar.r.f23155c, fVar.r.d));
        com.tencent.liteav.base.util.n b = fVar.s.b();
        fVar.r.f23155c = b.f22649a;
        fVar.r.d = b.b;
        fVar.e();
        if (sourceType == CaptureSourceInterface.SourceType.CAMERA) {
            fVar.q = new com.tencent.liteav.videoproducer.capture.ah(fVar.g, Looper.myLooper(), fVar.b);
            if (fVar.n == null) {
                fVar.n = new d(fVar.g, fVar);
                if (fVar.s.a() == VideoProducerDef.HomeOrientation.UNSET) {
                    fVar.n.enable();
                }
            }
        } else if (sourceType == CaptureSourceInterface.SourceType.SCREEN) {
            fVar.q = new com.tencent.liteav.videoproducer.capture.ah(fVar.g, Looper.myLooper(), fVar.b);
            VideoProducerDef.GSensorMode gSensorMode = VideoProducerDef.GSensorMode.DISABLE;
            fVar.k = gSensorMode;
            fVar.M.f = gSensorMode;
        } else if (sourceType == CaptureSourceInterface.SourceType.VIRTUAL_CAMERA) {
            fVar.q = new VirtualCamera(Looper.myLooper(), fVar.b);
        }
        CaptureSourceInterface captureSourceInterface = fVar.q;
        com.tencent.liteav.videobase.b.e eVar = fVar.h;
        captureSourceInterface.start(eVar != null ? eVar.d() : null, captureParams, fVar);
        fVar.a(fVar.A, true);
        fVar.a(fVar.F, fVar.G);
        a(fVar.r);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(f fVar, VideoProducerDef.StreamType streamType) {
        com.tencent.liteav.videoproducer.encoder.ai aiVar = fVar.z.get(streamType);
        if (aiVar != null) {
            aiVar.d();
            aiVar.e();
            aiVar.c();
            fVar.z.remove(streamType);
            if (streamType == VideoProducerDef.StreamType.STREAM_TYPE_BIG_VIDEO) {
                fVar.s.b(new com.tencent.liteav.base.util.n());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(f fVar, boolean z) {
        DisplayTarget displayTarget = fVar.A;
        if ((displayTarget != null ? displayTarget.getTXCloudVideoView() : null) != null) {
            fVar.e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        LiteavLog.i(this.f23464a, "stopCaptureInternal");
        this.o = false;
        this.f23465c.unregisterVideoProcessedListener(1, this);
        this.f23465c.unregisterVideoProcessedListener(2, this);
        for (VideoRenderInterface videoRenderInterface : h()) {
            if (videoRenderInterface != null) {
                videoRenderInterface.stop(true);
            }
        }
        d();
        d dVar = this.n;
        if (dVar != null) {
            dVar.disable();
            this.n = null;
        }
        this.p = CaptureSourceInterface.SourceType.NONE;
        this.f23465c.setSourceType(this.p);
        this.M.a(this.p);
        this.s.f23450a = this.p;
        this.s.a(new com.tencent.liteav.base.util.n());
        this.s.a((Rect) null);
        this.O = false;
        this.P = false;
        this.N = false;
        f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(f fVar) {
        fVar.f23465c.initialize();
        fVar.F = new com.tencent.liteav.videoconsumer.renderer.g(fVar.e.getLooper(), fVar.b);
    }

    private void d() {
        CaptureSourceInterface captureSourceInterface = this.q;
        if (captureSourceInterface != null) {
            captureSourceInterface.stop();
            this.q = null;
        }
        this.r = null;
        this.t = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(f fVar, boolean z) {
        String str = fVar.f23464a;
        LiteavLog.i(str, "setEncodeMirrorEnabled : " + z + ", old is " + fVar.w);
        if (fVar.w == z) {
            return;
        }
        fVar.w = z;
        fVar.i();
    }

    private void e() {
        com.tencent.liteav.base.util.n c2 = this.s.c();
        if (!c2.equals(this.L)) {
            com.tencent.liteav.base.util.n b = this.s.b();
            String str = this.f23464a;
            LiteavLog.i(str, "producer with capture " + b + " preview " + c2 + " mode:" + this.s.b);
        }
        this.L.a(c2.f22649a, c2.b);
        if (this.o) {
            this.f23465c.unregisterVideoProcessedListener(1, this);
            this.f23465c.unregisterVideoProcessedListener(2, this);
        }
        com.tencent.liteav.videobase.videobase.a aVar = new com.tencent.liteav.videobase.videobase.a(c2.f22649a, c2.b);
        this.f23465c.registerVideoProcessedListener(1, aVar, GLConstants.PixelBufferType.TEXTURE_2D, GLConstants.PixelFormatType.RGBA, true, this);
        this.f23465c.registerVideoProcessedListener(2, aVar, GLConstants.PixelBufferType.TEXTURE_2D, GLConstants.PixelFormatType.RGBA, false, this);
        this.o = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(f fVar) {
        LiteavLog.i(fVar.f23464a, "pauseCaptureInternal");
        if (fVar.p == CaptureSourceInterface.SourceType.CUSTOM) {
            LiteavLog.w(fVar.f23464a, "ignore invoking pauseCapture() when using custom input");
            return;
        }
        CaptureSourceInterface captureSourceInterface = fVar.q;
        if (captureSourceInterface != null) {
            captureSourceInterface.pause();
        }
    }

    private void e(boolean z) {
        DisplayTarget displayTarget = this.A;
        f fVar = null;
        TXCloudVideoView tXCloudVideoView = displayTarget == null ? null : displayTarget.getTXCloudVideoView();
        if (tXCloudVideoView == null) {
            LiteavLog.e(this.f23464a, "setTouchToFocusEnableInternal mDisplayTarget is null.");
            return;
        }
        try {
            Method declaredMethod = TXCloudVideoView.class.getDeclaredMethod("setTouchToFocusEnabled", Boolean.TYPE, com.tencent.rtmp.ui.a.class);
            declaredMethod.setAccessible(true);
            if (z) {
                fVar = this;
            }
            declaredMethod.invoke(tXCloudVideoView, Boolean.valueOf(z), fVar);
        } catch (Exception e) {
            LiteavLog.e(this.f23464a, "setTouchToFocusEnableInternal Exception:".concat(String.valueOf(e)));
        }
    }

    private void f() {
        LiteavLog.i(this.f23464a, "uninitOpenGLComponents");
        com.tencent.liteav.videobase.b.e.a(this.h);
        this.h = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(f fVar) {
        LiteavLog.i(fVar.f23464a, "resumeCaptureInternal");
        if (fVar.p == CaptureSourceInterface.SourceType.CUSTOM) {
            LiteavLog.w(fVar.f23464a, "ignore invoking resumeCapture() when using custom input");
            return;
        }
        CaptureSourceInterface captureSourceInterface = fVar.q;
        if (captureSourceInterface != null) {
            captureSourceInterface.resume();
        }
    }

    private void f(boolean z) {
        DisplayTarget displayTarget = this.A;
        f fVar = null;
        TXCloudVideoView tXCloudVideoView = displayTarget == null ? null : displayTarget.getTXCloudVideoView();
        if (tXCloudVideoView == null) {
            LiteavLog.e(this.f23464a, "setZoomEnabledInternal mDisplayTarget is null.");
            return;
        }
        try {
            Method declaredMethod = TXCloudVideoView.class.getDeclaredMethod("setZoomEnabled", Boolean.TYPE, com.tencent.rtmp.ui.b.class);
            declaredMethod.setAccessible(true);
            if (z) {
                fVar = this;
            }
            declaredMethod.invoke(tXCloudVideoView, Boolean.valueOf(z), fVar);
        } catch (Exception e) {
            LiteavLog.e(this.f23464a, "setZoomEnabledInternal Exception:".concat(String.valueOf(e)));
        }
    }

    private void g() {
        int i = this.m;
        int i2 = this.B.mValue;
        for (VideoRenderInterface videoRenderInterface : h()) {
            if (videoRenderInterface != null) {
                videoRenderInterface.setRenderRotation(Rotation.a(((360 - i) + i2) % 360));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g(f fVar) {
        if (fVar.p != CaptureSourceInterface.SourceType.NONE) {
            LiteavLog.w(fVar.f23464a, "can't Start when sourceType isn't NONE");
            return;
        }
        LiteavLog.i(fVar.f23464a, "Start custom capture");
        fVar.a(com.tencent.liteav.videoproducer.capture.au.a().b());
        fVar.d();
        fVar.s.a(VideoProducerDef.ProducerMode.AUTO);
        fVar.K.a(0, 0);
        fVar.p = CaptureSourceInterface.SourceType.CUSTOM;
        fVar.f23465c.setSourceType(fVar.p);
        fVar.M.a(fVar.p);
        fVar.s.f23450a = fVar.p;
        fVar.a(fVar.F, fVar.G);
    }

    private List<VideoRenderInterface> h() {
        ArrayList arrayList = new ArrayList();
        VideoRenderInterface videoRenderInterface = this.F;
        if (videoRenderInterface != null) {
            arrayList.add(videoRenderInterface);
        }
        VideoRenderInterface videoRenderInterface2 = this.H;
        if (videoRenderInterface2 != null) {
            arrayList.add(videoRenderInterface2);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        for (VideoProducerDef.StreamType streamType : this.z.keySet()) {
            b(streamType);
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.a
    public final void a() {
        LiteavLog.i(this.f23464a, "onCaptureError");
    }

    @Override // com.tencent.rtmp.ui.b
    public final void a(float f) {
        a(ar.a(this, f));
    }

    @Override // com.tencent.rtmp.ui.a
    public final void a(int i, int i2, int i3, int i4) {
        PixelFrame pixelFrame = this.t;
        if (pixelFrame == null) {
            return;
        }
        a(aq.a(this, OpenGlUtils.reverseMappingPoint(GLConstants.GLScaleType.CENTER_CROP, this.t.getRotation(), new Point(i, i2), new com.tencent.liteav.base.util.n(i3, i4), new com.tencent.liteav.base.util.n(pixelFrame.getWidth(), this.t.getHeight())), i, i2, i3, i4));
    }

    @Override // com.tencent.liteav.videoproducer.preprocessor.ag
    public final void a(int i, PixelFrame pixelFrame) {
        if (pixelFrame == null) {
            return;
        }
        if (!this.P) {
            this.P = true;
            LiteavLog.d(this.f23464a, "preprocess first frame out!");
        }
        GLES20.glFinish();
        pixelFrame.retain();
        if (a(ao.a(this, i, pixelFrame))) {
            return;
        }
        pixelFrame.release();
    }

    @Override // com.tencent.liteav.videoproducer.producer.d.a
    public final void a(Rotation rotation, int i) {
        a(ap.a(this, rotation, i));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.a
    public final void a(CaptureSourceInterface captureSourceInterface, PixelFrame pixelFrame) {
        if (pixelFrame != null) {
            pixelFrame.retain();
            if (pixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_2D || pixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_OES) {
                GLES20.glFinish();
            }
            if (a(am.a(this, pixelFrame, captureSourceInterface))) {
                return;
            }
            pixelFrame.release();
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.a
    public final void a(boolean z) {
        LiteavLog.i(this.f23464a, "onStartFinish success:".concat(String.valueOf(z)));
        a(ai.a(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(Runnable runnable) {
        com.tencent.liteav.base.util.b bVar = this.e;
        if (!this.f || bVar == null) {
            return false;
        }
        if (Looper.myLooper() == bVar.getLooper()) {
            runnable.run();
            return true;
        }
        return bVar.post(runnable);
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.a
    public final void b(boolean z) {
        LiteavLog.i(this.f23464a, "onScreenDisplayOrientationChanged isPortrait:".concat(String.valueOf(z)));
        a(aj.a(this, z));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.a
    public final void c(boolean z) {
        LiteavLog.i(this.f23464a, "onCameraTouchEnable enableTouch:".concat(String.valueOf(z)));
        a(ak.a(this, z));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.a
    public final void d(boolean z) {
        LiteavLog.i(this.f23464a, "onCameraZoomEnable enableZoom:".concat(String.valueOf(z)));
        a(al.a(this, z));
    }
}
