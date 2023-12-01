package com.tencent.ugc;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import androidx.core.math.MathUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.ugc.UGCFrameQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCImageProvider.class */
public class UGCImageProvider implements UGCFrameQueue.UGCFrameQueueListener, UGCPixelFrameProvider {
    private static final int MAX_FRAME_SIZE = 5;
    private static final String TAG = "UGCImageProvider";
    private final List<Bitmap> mBitmapList;
    private FutureTask<Long> mDurationFuture;
    private long mDurationMs;
    private com.tencent.liteav.videobase.b.e mEGLCore;
    private final int mFps;
    private final int mFrameIntervalMs;
    private final UGCFrameQueue<List<PixelFrame>> mFrameQueue;
    private final Map<Bitmap, com.tencent.liteav.videobase.frame.d> mGLTextureMap;
    private com.tencent.liteav.videobase.frame.e mGLTexturePool;
    private int mTotalFrameCount;
    private com.tencent.liteav.base.util.b mWorkHandler;
    private int mCurrentFrameCount = 0;
    private long mStayDurationMs = 1000;
    private long mMotionDurationMs = 500;
    private int mTransitionType = 1;

    public UGCImageProvider(List<Bitmap> list, int i) {
        LiteavLog.i(TAG, TAG);
        i = i <= 0 ? 20 : i;
        this.mFps = i;
        this.mFrameIntervalMs = 1000 / i;
        this.mFrameQueue = new UGCFrameQueue<>();
        this.mGLTextureMap = new HashMap();
        this.mBitmapList = list;
    }

    private void clearGLTextureCache() {
        for (com.tencent.liteav.videobase.frame.d dVar : this.mGLTextureMap.values()) {
            if (dVar != null) {
                dVar.release();
            }
        }
        this.mGLTextureMap.clear();
    }

    private void clearPixelFrameQueue() {
        for (List<PixelFrame> list : this.mFrameQueue.dequeueAll()) {
            if (list != null) {
                for (PixelFrame pixelFrame : list) {
                    pixelFrame.release();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void decodeBitmapFrame() {
        if (this.mEGLCore == null || this.mFrameQueue.size() > 5) {
            return;
        }
        if (this.mCurrentFrameCount >= this.mTotalFrameCount) {
            this.mFrameQueue.queue(END_OF_STREAM);
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i = this.mCurrentFrameCount;
        long j = i * this.mFrameIntervalMs;
        this.mCurrentFrameCount = i + 1;
        int clamp = MathUtils.clamp((int) (j / (this.mStayDurationMs + this.mMotionDurationMs)), 0, this.mBitmapList.size() - 1);
        arrayList.add(loadBitmapToPixelFrame(this.mBitmapList.get(clamp), j));
        arrayList.add(loadBitmapToPixelFrame(this.mBitmapList.get(MathUtils.clamp(clamp + 1, 0, this.mBitmapList.size() - 1)), j));
        this.mFrameQueue.queue(arrayList);
        com.tencent.liteav.base.util.b bVar = this.mWorkHandler;
        if (bVar != null) {
            bVar.removeCallbacks(cr.a(this));
            bVar.post(cs.a(this));
        }
    }

    private void initializeGLComponents() {
        com.tencent.liteav.videobase.b.e eVar = new com.tencent.liteav.videobase.b.e();
        this.mEGLCore = eVar;
        try {
            eVar.a(com.tencent.liteav.videoproducer.capture.au.a().b(), null, 128, 128);
            this.mEGLCore.a();
            this.mGLTexturePool = new com.tencent.liteav.videobase.frame.e();
        } catch (com.tencent.liteav.videobase.b.g e) {
            LiteavLog.e(TAG, "create EGLCore failed.", e);
            this.mEGLCore = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$initialize$0(UGCImageProvider uGCImageProvider) {
        uGCImageProvider.mFrameQueue.setUGCFrameQueueListener(uGCImageProvider);
        uGCImageProvider.initializeGLComponents();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$seekTo$4(UGCImageProvider uGCImageProvider, long j) {
        uGCImageProvider.mCurrentFrameCount = (((int) (j - 1)) / uGCImageProvider.mFrameIntervalMs) + 1;
        uGCImageProvider.clearPixelFrameQueue();
        uGCImageProvider.runOnWorkThread(cj.a(uGCImageProvider));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Long lambda$setPictureTransition$5(UGCImageProvider uGCImageProvider, int i) throws Exception {
        uGCImageProvider.setPictureTransitionInternal(i);
        return Long.valueOf(uGCImageProvider.mDurationMs);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$start$2(UGCImageProvider uGCImageProvider) {
        uGCImageProvider.setPictureTransitionInternal(uGCImageProvider.mTransitionType);
        uGCImageProvider.decodeBitmapFrame();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$stop$3(UGCImageProvider uGCImageProvider) {
        com.tencent.liteav.base.util.b bVar = uGCImageProvider.mWorkHandler;
        if (bVar != null) {
            bVar.removeCallbacks(ck.a(uGCImageProvider));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$uninitialize$1(UGCImageProvider uGCImageProvider) {
        uGCImageProvider.clearPixelFrameQueue();
        uGCImageProvider.clearGLTextureCache();
        uGCImageProvider.uninitGLComponents();
        uGCImageProvider.mFrameQueue.setUGCFrameQueueListener(null);
        com.tencent.liteav.base.util.b bVar = uGCImageProvider.mWorkHandler;
        if (bVar != null) {
            bVar.a();
            uGCImageProvider.mWorkHandler = null;
        }
    }

    private PixelFrame loadBitmapToPixelFrame(Bitmap bitmap, long j) {
        com.tencent.liteav.videobase.frame.d dVar;
        if (this.mGLTextureMap.containsKey(bitmap)) {
            dVar = this.mGLTextureMap.get(bitmap);
        } else {
            com.tencent.liteav.videobase.frame.d a2 = this.mGLTexturePool.a(bitmap.getWidth(), bitmap.getHeight());
            OpenGlUtils.loadTexture(bitmap, a2.a(), false);
            this.mGLTextureMap.put(bitmap, a2);
            dVar = a2;
        }
        PixelFrame a3 = dVar.a(com.tencent.liteav.videoproducer.capture.au.a().b());
        a3.setTimestamp(j);
        return a3;
    }

    private boolean runOnWorkThread(Runnable runnable) {
        com.tencent.liteav.base.util.b bVar = this.mWorkHandler;
        if (bVar != null) {
            return bVar.a(runnable, 0);
        }
        return false;
    }

    private void setPictureTransitionInternal(int i) {
        this.mTransitionType = i;
        this.mStayDurationMs = UGCTransitionRules.getStayDurationMs(i);
        this.mMotionDurationMs = UGCTransitionRules.getMotionDurationMs(i);
        List<Bitmap> list = this.mBitmapList;
        if (list == null) {
            return;
        }
        if (i == 5 || i == 4) {
            this.mDurationMs = this.mBitmapList.size() * (this.mStayDurationMs + this.mMotionDurationMs);
        } else {
            long size = list.size();
            long j = this.mStayDurationMs;
            long j2 = this.mMotionDurationMs;
            this.mDurationMs = (size * (j + j2)) - j2;
        }
        this.mTotalFrameCount = (int) ((this.mDurationMs / 1000) * this.mFps);
    }

    private void uninitGLComponents() {
        if (this.mEGLCore == null) {
            return;
        }
        try {
            if (this.mGLTexturePool != null) {
                this.mGLTexturePool.a();
                this.mGLTexturePool.b();
                this.mGLTexturePool = null;
            }
            this.mEGLCore.a();
        } catch (com.tencent.liteav.videobase.b.g e) {
            LiteavLog.e(TAG, "EGLCore destroy failed.", e);
        }
        com.tencent.liteav.videobase.b.e.a(this.mEGLCore);
        this.mEGLCore = null;
    }

    public long getDuration() {
        if (this.mDurationFuture == null) {
            return 0L;
        }
        Long l = 0L;
        try {
            l = this.mDurationFuture.get(500L, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            LiteavLog.w(TAG, "getDuration future task exception: ".concat(String.valueOf(e)));
        }
        return l.longValue();
    }

    @Override // com.tencent.ugc.UGCPixelFrameProvider
    public UGCFrameQueue<List<PixelFrame>> getFrameQueue() {
        return this.mFrameQueue;
    }

    @Override // com.tencent.ugc.UGCPixelFrameProvider
    public void initialize() {
        LiteavLog.i(TAG, ContentResolver.SYNC_EXTRAS_INITIALIZE);
        synchronized (this) {
            if (this.mWorkHandler != null) {
                LiteavLog.w(TAG, "UGCPixelFrameProvider is initialized");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("ugc-image-frame-provider");
            handlerThread.start();
            this.mWorkHandler = new com.tencent.liteav.base.util.b(handlerThread.getLooper());
            runOnWorkThread(ci.a(this));
        }
    }

    @Override // com.tencent.ugc.UGCFrameQueue.UGCFrameQueueListener
    public void onFrameDequeued() {
        runOnWorkThread(cq.a(this));
    }

    @Override // com.tencent.ugc.UGCPixelFrameProvider
    public void seekTo(long j, boolean z) {
        runOnWorkThread(co.a(this, j));
    }

    public void setPictureTransition(int i) {
        LiteavLog.i(TAG, "setPictureTransition type = ".concat(String.valueOf(i)));
        FutureTask<Long> futureTask = new FutureTask<>(cp.a(this, i));
        this.mDurationFuture = futureTask;
        runOnWorkThread(futureTask);
    }

    @Override // com.tencent.ugc.UGCPixelFrameProvider
    public void setReverse(boolean z) {
    }

    @Override // com.tencent.ugc.UGCPixelFrameProvider
    public void start() {
        Log.i(TAG, "Start", new Object[0]);
        runOnWorkThread(cm.a(this));
    }

    @Override // com.tencent.ugc.UGCPixelFrameProvider
    public void stop() {
        LiteavLog.i(TAG, "stop");
        runOnWorkThread(cn.a(this));
    }

    @Override // com.tencent.ugc.UGCPixelFrameProvider
    public void uninitialize() {
        LiteavLog.i(TAG, "unInitialize");
        runOnWorkThread(cl.a(this));
    }
}
