package com.tencent.liteav.videoproducer.preprocessor;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videobase.utils.a;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.preprocessor.BeautyProcessor;
import com.tencent.liteav.videoproducer.preprocessor.h;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

@JNINamespace("liteav::video")
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/preprocessor/VideoPreprocessor.class */
public class VideoPreprocessor implements BeautyProcessor.a {
    private static final String TAG = "VideoPreprocessor";
    private final com.tencent.liteav.videobase.utils.a mAverageCostCalculator;
    private final h mPreprocessor;
    private final IVideoReporter mVideoReporter;
    private com.tencent.liteav.base.util.b mWorkHandler;
    private final CyclicBarrier mLoadFrameCyclicBarrier = new CyclicBarrier(2);
    private final SparseArray<com.tencent.liteav.videobase.videobase.a> mConvertParamsList = new SparseArray<>();
    private float mLookupMixLevel = 0.5f;
    private long mTotalFrameCount = 0;
    private long mLastProcessTimestamp = 0;

    public VideoPreprocessor(Context context, BeautyProcessor beautyProcessor, IVideoReporter iVideoReporter) {
        this.mPreprocessor = new h(context, beautyProcessor, iVideoReporter);
        this.mVideoReporter = iVideoReporter;
        beautyProcessor.setBeautyManagerStatusListener(this);
        com.tencent.liteav.beauty.a.a(this.mVideoReporter);
        this.mAverageCostCalculator = new com.tencent.liteav.videobase.utils.a("preprocess", new a.InterfaceC0767a(this) { // from class: com.tencent.liteav.videoproducer.preprocessor.q

            /* renamed from: a  reason: collision with root package name */
            private final VideoPreprocessor f23393a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f23393a = this;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$processFrame$2(VideoPreprocessor videoPreprocessor, PixelFrame pixelFrame, long j) {
        PixelFrame a2;
        h hVar = videoPreprocessor.mPreprocessor;
        pixelFrame.getGLContext();
        Object gLContext = pixelFrame.getGLContext();
        if (!CommonUtil.equals(hVar.l, gLContext)) {
            hVar.l = gLContext;
            hVar.a();
            LiteavLog.i("GPUPreprocessor", "set unique eglcore: %s", gLContext);
        }
        try {
            if (hVar.k == null) {
                Object gLContext2 = pixelFrame.getGLContext();
                LiteavLog.i("GPUPreprocessor", "initialize internal, eglContextFromPixelFrame: %s", gLContext2);
                hVar.k = new com.tencent.liteav.videobase.b.e();
                hVar.k.a(gLContext2, null, 128, 128);
                hVar.k.a();
                hVar.n = new com.tencent.liteav.videobase.frame.e();
                hVar.p.a(hVar.n);
                hVar.e.initialize(hVar.n);
                hVar.b();
            }
            hVar.k.a();
            hVar.d.a();
            if (hVar.m == null) {
                hVar.m = new com.tencent.liteav.videobase.frame.j(hVar.i, hVar.j);
            }
            OpenGlUtils.glViewport(0, 0, hVar.i, hVar.j);
            if (pixelFrame.getHeight() == hVar.j && pixelFrame.getWidth() == hVar.i && pixelFrame.getRotation() == Rotation.NORMAL && !pixelFrame.isMirrorVertical() && !pixelFrame.isMirrorHorizontal() && pixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_2D) {
                pixelFrame.retain();
                a2 = pixelFrame;
            } else {
                com.tencent.liteav.videobase.frame.d a3 = hVar.n.a(hVar.i, hVar.j);
                hVar.m.a(pixelFrame, hVar.h == CaptureSourceInterface.SourceType.SCREEN ? GLConstants.GLScaleType.FIT_CENTER : GLConstants.GLScaleType.CENTER_CROP, a3);
                a2 = a3.a(hVar.k.d());
                a3.release();
            }
            hVar.f.setTimestamp(pixelFrame.getTimestamp());
            com.tencent.liteav.videobase.frame.d a4 = hVar.n.a(hVar.i, hVar.j);
            hVar.f.onDraw(a2.getTextureId(), a4, hVar.b, hVar.f23375c);
            a2.release();
            a4.release();
        } catch (com.tencent.liteav.videobase.b.g e) {
            if (hVar.g.a()) {
                LiteavLog.e("GPUPreprocessor", "initializeEGL failed. " + e.getMessage());
            }
            hVar.a();
        }
        videoPreprocessor.mVideoReporter.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_PREPROCESS_TIME, Long.valueOf(SystemClock.elapsedRealtime() - j));
        videoPreprocessor.reportProcessFrameRate();
        pixelFrame.release();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$registerVideoProcessedListener$3(VideoPreprocessor videoPreprocessor, int i, com.tencent.liteav.videobase.videobase.a aVar, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType, boolean z, ag agVar) {
        h hVar = videoPreprocessor.mPreprocessor;
        h.c cVar = new h.c(i, aVar, pixelBufferType, pixelFormatType, agVar);
        if (z) {
            h.a(cVar, hVar.s);
        } else {
            h.a(cVar, hVar.r);
        }
        hVar.c();
        LiteavLog.i("GPUPreprocessor", "register listener, identity:%d, bufferType:%s, formatType:%s, withWatermark:%b, listener:%s", Integer.valueOf(i), pixelBufferType, pixelFormatType, Boolean.valueOf(z), agVar);
        videoPreprocessor.mConvertParamsList.put(i, aVar);
        videoPreprocessor.recalculateProcessSizeInternal();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setFilterMixLevel$7(VideoPreprocessor videoPreprocessor, float f) {
        h hVar = videoPreprocessor.mPreprocessor;
        hVar.d.a(m.a(hVar, f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setGaussianBlurLevel$12(VideoPreprocessor videoPreprocessor, float f) {
        h hVar = videoPreprocessor.mPreprocessor;
        hVar.d.a(l.a(hVar, f / 4.0f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setGreenScreenFile$5(VideoPreprocessor videoPreprocessor, String str, boolean z) {
        h hVar = videoPreprocessor.mPreprocessor;
        hVar.d.a(o.a(hVar, str, z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setGreenScreenParam$6(VideoPreprocessor videoPreprocessor, GLConstants.GLScaleType gLScaleType, boolean z) {
        h hVar = videoPreprocessor.mPreprocessor;
        hVar.d.a(p.a(hVar, gLScaleType, z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setInterceptorBeforeWatermark$14(VideoPreprocessor videoPreprocessor, com.tencent.liteav.videobase.a.a aVar) {
        h hVar = videoPreprocessor.mPreprocessor;
        hVar.d.a(i.a(hVar, aVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setWatermark$10(VideoPreprocessor videoPreprocessor, Bitmap bitmap, float f, float f2, float f3) {
        h hVar = videoPreprocessor.mPreprocessor;
        LiteavLog.d("GPUPreprocessor", "setWatermark xOffsetRatio: %.2f, yOffsetRatio: %.2f, widthRatio: %.2f", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3));
        hVar.d.a(j.a(hVar, bitmap, f, f2, f3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setWatermarkList$11(VideoPreprocessor videoPreprocessor, List list) {
        h hVar = videoPreprocessor.mPreprocessor;
        hVar.d.a(k.a(hVar, list));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0026, code lost:
        if (r10 != null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void lambda$unregisterVideoProcessedListener$4(com.tencent.liteav.videoproducer.preprocessor.VideoPreprocessor r7, int r8, com.tencent.liteav.videoproducer.preprocessor.ag r9) {
        /*
            r0 = r7
            com.tencent.liteav.videoproducer.preprocessor.h r0 = r0.mPreprocessor
            r12 = r0
            r0 = r8
            r1 = r9
            r2 = r12
            java.util.List<com.tencent.liteav.videoproducer.preprocessor.h$c> r2 = r2.r
            com.tencent.liteav.videoproducer.preprocessor.h$c r0 = com.tencent.liteav.videoproducer.preprocessor.h.a(r0, r1, r2)
            r11 = r0
            r0 = r11
            r10 = r0
            r0 = r11
            if (r0 != 0) goto L29
            r0 = r8
            r1 = r9
            r2 = r12
            java.util.List<com.tencent.liteav.videoproducer.preprocessor.h$c> r2 = r2.s
            com.tencent.liteav.videoproducer.preprocessor.h$c r0 = com.tencent.liteav.videoproducer.preprocessor.h.a(r0, r1, r2)
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L5c
        L29:
            r0 = r12
            com.tencent.liteav.videobase.videobase.e r0 = r0.p
            r1 = r8
            r2 = r10
            r0.a(r1, r2)
            r0 = r12
            com.tencent.liteav.videobase.videobase.e r0 = r0.q
            if (r0 == 0) goto L45
            r0 = r12
            com.tencent.liteav.videobase.videobase.e r0 = r0.q
            r1 = r8
            r2 = r10
            r0.a(r1, r2)
        L45:
            java.lang.String r0 = "GPUPreprocessor"
            java.lang.String r1 = "unregister listener: identity: %d, listener: %s"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r8
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3[r4] = r5
            r3 = r2
            r4 = 1
            r5 = r9
            r3[r4] = r5
            com.tencent.liteav.base.util.LiteavLog.i(r0, r1, r2)
        L5c:
            r0 = r7
            android.util.SparseArray<com.tencent.liteav.videobase.videobase.a> r0 = r0.mConvertParamsList
            r1 = r8
            r0.remove(r1)
            r0 = r7
            r0.recalculateProcessSizeInternal()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.preprocessor.VideoPreprocessor.lambda$unregisterVideoProcessedListener$4(com.tencent.liteav.videoproducer.preprocessor.VideoPreprocessor, int, com.tencent.liteav.videoproducer.preprocessor.ag):void");
    }

    private void recalculateProcessSizeInternal() {
        int i;
        if (this.mConvertParamsList.size() == 0) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = i4;
            if (i2 >= this.mConvertParamsList.size()) {
                break;
            }
            com.tencent.liteav.videobase.videobase.a valueAt = this.mConvertParamsList.valueAt(i2);
            boolean z = valueAt.f22978c == Rotation.ROTATION_90 || valueAt.f22978c == Rotation.ROTATION_270;
            int i5 = z ? valueAt.b : valueAt.f22977a;
            int i6 = z ? valueAt.f22977a : valueAt.b;
            if (i3 * i6 != i * i5) {
                LiteavLog.w(TAG, "video preprocessor has different w/h ratio: %dx%d vs %dx%d", Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i5), Integer.valueOf(i6));
            }
            int i7 = i3;
            int i8 = i;
            if (i5 * i6 > i3 * i) {
                i8 = i6;
                i7 = i5;
            }
            i2++;
            i3 = i7;
            i4 = i8;
        }
        h hVar = this.mPreprocessor;
        if (hVar.i == i3 && hVar.j == i) {
            LiteavLog.d("GPUPreprocessor", "process size is same as before");
            return;
        }
        hVar.i = i3;
        hVar.j = i;
        LiteavLog.i("GPUPreprocessor", "process size update to %dx%d", Integer.valueOf(i3), Integer.valueOf(i));
        if (hVar.m != null) {
            hVar.m.a();
            hVar.m = null;
        }
        if (hVar.n != null) {
            hVar.n.a();
        }
        hVar.f.onOutputSizeChanged(i3, i);
    }

    private void reportProcessFrameRate() {
        long j;
        this.mTotalFrameCount++;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime > 2000 + this.mLastProcessTimestamp) {
            this.mVideoReporter.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_PREPROCESS_FPS_IN, Double.valueOf((this.mTotalFrameCount * 1000.0d) / (elapsedRealtime - j)));
            this.mTotalFrameCount = 0L;
            this.mLastProcessTimestamp = elapsedRealtime;
        }
    }

    public BeautyProcessor getBeautyProcessor() {
        return this.mPreprocessor.e;
    }

    public void initialize() {
        LiteavLog.i(TAG, ContentResolver.SYNC_EXTRAS_INITIALIZE);
        HandlerThread handlerThread = new HandlerThread("video-preprocessor");
        handlerThread.start();
        this.mWorkHandler = new com.tencent.liteav.base.util.b(handlerThread.getLooper());
    }

    @Override // com.tencent.liteav.videoproducer.preprocessor.BeautyProcessor.a
    public void onBeautyStatsChanged(String str) {
        this.mVideoReporter.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_PREPROCESS_BEAUTY_SETTINGS, str);
    }

    public void postTaskToGlThread(Runnable runnable) {
        this.mWorkHandler.post(runnable);
    }

    public boolean processFrame(PixelFrame pixelFrame) {
        boolean post;
        synchronized (this) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            pixelFrame.retain();
            post = this.mWorkHandler.post(z.a(this, pixelFrame, elapsedRealtime));
            if (!post) {
                pixelFrame.release();
            }
        }
        return post;
    }

    public void registerVideoProcessedListener(int i, com.tencent.liteav.videobase.videobase.a aVar, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType, boolean z, ag agVar) {
        GLConstants.PixelBufferType pixelBufferType2 = GLConstants.PixelBufferType.TEXTURE_OES;
        if (pixelBufferType == GLConstants.PixelBufferType.TEXTURE_2D) {
            GLConstants.PixelFormatType pixelFormatType2 = GLConstants.PixelFormatType.RGBA;
        }
        this.mWorkHandler.post(aa.a(this, i, aVar, pixelBufferType, pixelFormatType, z, agVar));
    }

    public void runTaskInGlThreadAndWaitDone(Runnable runnable) {
        this.mWorkHandler.a(runnable);
    }

    public void setFilterGroupImages(float f, Bitmap bitmap, float f2, Bitmap bitmap2, float f3) {
        postTaskToGlThread(r.a(this, f, bitmap, f2, bitmap2, f3));
    }

    public void setFilterMixLevel(float f) {
        LiteavLog.i(TAG, "setFilterMixLevel: ".concat(String.valueOf(f)));
        this.mLookupMixLevel = f;
        this.mWorkHandler.post(ae.a(this, f));
    }

    public void setGaussianBlurLevel(float f) {
        this.mWorkHandler.post(u.a(this, f));
    }

    public boolean setGreenScreenFile(String str, boolean z) {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 18) {
            return false;
        }
        LiteavLog.i(TAG, "setGreenScreenFile: path=" + str + ", isLoop=" + z);
        this.mWorkHandler.post(ac.a(this, str, z));
        return true;
    }

    public void setGreenScreenParam(GLConstants.GLScaleType gLScaleType, boolean z) {
        this.mWorkHandler.post(ad.a(this, gLScaleType, z));
    }

    public void setInterceptorBeforeWatermark(com.tencent.liteav.videobase.a.a aVar) {
        this.mWorkHandler.post(x.a(this, aVar));
    }

    public void setLookupImage(Bitmap bitmap) {
        LiteavLog.i(TAG, "setLookupImage: ".concat(String.valueOf(bitmap)));
        this.mWorkHandler.post(af.a(this, bitmap));
    }

    public void setSourceType(CaptureSourceInterface.SourceType sourceType) {
        this.mWorkHandler.post(y.a(this, sourceType));
    }

    public void setWatermark(Bitmap bitmap, float f, float f2, float f3) {
        this.mWorkHandler.post(s.a(this, bitmap, f, f2, f3));
    }

    public void setWatermarkList(List<com.tencent.liteav.beauty.b.o> list) {
        this.mWorkHandler.post(t.a(this, list));
    }

    public void uninitialize() {
        LiteavLog.i(TAG, "uninitialize");
        this.mAverageCostCalculator.a();
        com.tencent.liteav.base.util.b bVar = this.mWorkHandler;
        if (bVar != null) {
            h hVar = this.mPreprocessor;
            hVar.getClass();
            bVar.post(w.a(hVar));
            bVar.a();
        }
    }

    public void unregisterVideoProcessedListener(int i, ag agVar) {
        this.mWorkHandler.post(ab.a(this, i, agVar));
    }

    public void updateHomeOrientation(int i) {
        this.mWorkHandler.post(v.a(this, i));
    }
}
