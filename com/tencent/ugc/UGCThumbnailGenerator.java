package com.tencent.ugc;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.ugc.TXVideoEditer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCThumbnailGenerator.class */
public class UGCThumbnailGenerator {
    private com.tencent.liteav.videobase.frame.e mGLTexturePool;
    private com.tencent.liteav.base.util.b mHandler;
    private boolean mIsInitialized;
    private com.tencent.liteav.videobase.frame.j mPixelFrameRender;
    private UGCThumbnailGenerateParams mThumbnailGenerateInfo;
    private TXVideoEditer.TXThumbnailListener mThumbnailListener;
    private final com.tencent.liteav.base.b.a mPrintLogThrottler = new com.tencent.liteav.base.b.a(com.anythink.expressad.video.module.a.a.m.ag);
    private String mTag = "ThumbnailGenerator_";
    private int mGenerateIndex = 0;
    private com.tencent.liteav.videobase.b.e mEGLCore = null;
    private final com.tencent.liteav.videobase.frame.c mGLFrameBuffer = new com.tencent.liteav.videobase.frame.c();
    private Object mSharedContext = null;
    private final UGCMediaListSource mMediaListSource = new UGCMediaListSource();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCThumbnailGenerator$UGCThumbnailGenerateParams.class */
    public static class UGCThumbnailGenerateParams {
        boolean fast;
        int height;
        int thumbnailCount;
        List<Long> thumbnailPtsList;
        int width;
    }

    public UGCThumbnailGenerator() {
        this.mTag += hashCode();
    }

    public static List<Long> calculateThumbnailList(int i, long j, long j2, long j3) {
        if (j3 < 0 || i == 0) {
            LiteavLog.w("calculateThumbnailList", "param error: duration= " + j3 + ",count= " + i);
            return null;
        }
        LiteavLog.i("calculateThumbnailList", "calculateThumbnailList startTimeMs : " + j + ", endTimeMs : " + j2);
        ArrayList arrayList = new ArrayList();
        long j4 = j2 - j;
        if (j4 <= 0) {
            j4 = j3;
        }
        long j5 = j4 / i;
        long min = Math.min(j2, j3);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return arrayList;
            }
            long j6 = (i3 * j5) + j;
            long j7 = j6;
            if (min > 0) {
                j7 = Math.min(j6, min);
            }
            arrayList.add(Long.valueOf(j7));
            i2 = i3 + 1;
        }
    }

    private Bitmap getBitmapFromTexture(com.tencent.liteav.videobase.frame.d dVar) {
        this.mGLFrameBuffer.a(dVar.a());
        this.mGLFrameBuffer.b();
        ByteBuffer order = ByteBuffer.allocateDirect(this.mThumbnailGenerateInfo.width * this.mThumbnailGenerateInfo.height * 4).order(ByteOrder.nativeOrder());
        order.position(0);
        OpenGlUtils.readPixels(0, 0, this.mThumbnailGenerateInfo.width, this.mThumbnailGenerateInfo.height, order);
        order.position(0);
        Bitmap createBitmap = Bitmap.createBitmap(this.mThumbnailGenerateInfo.width, this.mThumbnailGenerateInfo.height, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(order);
        OpenGlUtils.bindFramebuffer(36160, 0);
        this.mGLFrameBuffer.c();
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getNextThumbnail() {
        com.tencent.liteav.videobase.frame.e eVar;
        UGCThumbnailGenerateParams uGCThumbnailGenerateParams = this.mThumbnailGenerateInfo;
        if (uGCThumbnailGenerateParams == null || uGCThumbnailGenerateParams.thumbnailPtsList == null || this.mThumbnailGenerateInfo.thumbnailPtsList.size() <= this.mGenerateIndex) {
            String str = this.mTag;
            LiteavLog.i(str, "generate runnable: mThumbnailGenerateInfo= " + this.mThumbnailGenerateInfo + " mGenerateIndex = " + this.mGenerateIndex);
            return;
        }
        List<Long> list = this.mThumbnailGenerateInfo.thumbnailPtsList;
        int i = this.mGenerateIndex;
        this.mGenerateIndex = i + 1;
        long longValue = list.get(i).longValue();
        if (this.mThumbnailGenerateInfo.fast) {
            this.mMediaListSource.impreciseSeekTo(longValue);
        } else {
            this.mMediaListSource.seekTo(longValue);
        }
        List<PixelFrame> readNextVideoFrame = this.mMediaListSource.readNextVideoFrame();
        if (com.tencent.liteav.videobase.utils.c.a(readNextVideoFrame) || readNextVideoFrame.get(0) == null) {
            LiteavLog.i(this.mTag, "readNextVideoFrame return null.");
            return;
        }
        PixelFrame pixelFrame = readNextVideoFrame.get(0);
        if (this.mEGLCore == null || !CommonUtil.equals(this.mSharedContext, pixelFrame.getGLContext())) {
            uninitOpenGLComponents();
            initOpenGLComponents(pixelFrame.getGLContext(), this.mThumbnailGenerateInfo.width, this.mThumbnailGenerateInfo.height);
        }
        if (this.mEGLCore == null || (eVar = this.mGLTexturePool) == null) {
            if (this.mPrintLogThrottler.a()) {
                LiteavLog.e(this.mTag, "EGLCore or GLTexturePool is null");
            }
            pixelFrame.release();
            return;
        }
        com.tencent.liteav.videobase.frame.d a2 = eVar.a(this.mThumbnailGenerateInfo.width, this.mThumbnailGenerateInfo.height);
        this.mPixelFrameRender.a(pixelFrame, GLConstants.GLScaleType.CENTER_CROP, a2);
        Bitmap bitmapFromTexture = getBitmapFromTexture(a2);
        TXVideoEditer.TXThumbnailListener tXThumbnailListener = this.mThumbnailListener;
        if (tXThumbnailListener != null) {
            tXThumbnailListener.onThumbnail(this.mGenerateIndex, longValue, bitmapFromTexture);
        }
        a2.release();
        pixelFrame.release();
        if (list.size() > this.mGenerateIndex) {
            this.mHandler.post(fm.a(this));
        }
    }

    private void initOpenGLComponents(Object obj, int i, int i2) {
        LiteavLog.i(this.mTag, "initOpenGLComponents ".concat(String.valueOf(obj)));
        if (this.mEGLCore != null) {
            return;
        }
        com.tencent.liteav.videobase.b.e eVar = new com.tencent.liteav.videobase.b.e();
        this.mEGLCore = eVar;
        try {
            eVar.a(obj, null, 128, 128);
            this.mGLTexturePool = new com.tencent.liteav.videobase.frame.e();
            this.mPixelFrameRender = new com.tencent.liteav.videobase.frame.j(i, i2);
            this.mGLFrameBuffer.a();
            this.mSharedContext = obj;
        } catch (com.tencent.liteav.videobase.b.g e) {
            this.mEGLCore = null;
            LiteavLog.e(this.mTag, "EGLCore create failed.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setVideoSourceList$1(UGCThumbnailGenerator uGCThumbnailGenerator, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            LiteavLog.i(uGCThumbnailGenerator.mTag, "setVideoSourceList ".concat(String.valueOf((String) it.next())));
        }
        uGCThumbnailGenerator.mMediaListSource.setVideoSources(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$start$3(UGCThumbnailGenerator uGCThumbnailGenerator, UGCThumbnailGenerateParams uGCThumbnailGenerateParams, TXVideoEditer.TXThumbnailListener tXThumbnailListener) {
        if (uGCThumbnailGenerateParams == null || com.tencent.liteav.videobase.utils.c.a(uGCThumbnailGenerateParams.thumbnailPtsList)) {
            LiteavLog.w(uGCThumbnailGenerator.mTag, "start param error!");
            return;
        }
        String str = uGCThumbnailGenerator.mTag;
        LiteavLog.i(str, "start width = " + uGCThumbnailGenerateParams.width + " height = " + uGCThumbnailGenerateParams.height);
        uGCThumbnailGenerator.mGenerateIndex = 0;
        uGCThumbnailGenerator.mThumbnailGenerateInfo = uGCThumbnailGenerateParams;
        uGCThumbnailGenerator.mThumbnailListener = tXThumbnailListener;
        uGCThumbnailGenerator.getNextThumbnail();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$stop$4(UGCThumbnailGenerator uGCThumbnailGenerator) {
        LiteavLog.i(uGCThumbnailGenerator.mTag, "stop");
        uGCThumbnailGenerator.mThumbnailGenerateInfo = null;
        uGCThumbnailGenerator.mThumbnailListener = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$uninitialize$0(UGCThumbnailGenerator uGCThumbnailGenerator) {
        LiteavLog.i(uGCThumbnailGenerator.mTag, "unInitialize");
        uGCThumbnailGenerator.uninitOpenGLComponents();
        synchronized (uGCThumbnailGenerator) {
            if (!uGCThumbnailGenerator.mIsInitialized) {
                LiteavLog.w(uGCThumbnailGenerator.mTag, "already uninitialize.");
                return;
            }
            com.tencent.liteav.base.util.b bVar = uGCThumbnailGenerator.mHandler;
            uGCThumbnailGenerator.mHandler = null;
            uGCThumbnailGenerator.mIsInitialized = false;
            uGCThumbnailGenerator.mMediaListSource.uninitialize();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    private boolean runOnThumbnailThread(Runnable runnable) {
        com.tencent.liteav.base.util.b bVar = this.mHandler;
        if (!this.mIsInitialized || bVar == null) {
            return false;
        }
        return bVar.a(runnable, 0);
    }

    private void uninitOpenGLComponents() {
        if (this.mEGLCore == null) {
            return;
        }
        LiteavLog.i(this.mTag, "uninitOpenGLComponents");
        this.mEGLCore.b();
        com.tencent.liteav.videobase.frame.e eVar = this.mGLTexturePool;
        if (eVar != null) {
            eVar.b();
            this.mGLTexturePool = null;
        }
        com.tencent.liteav.videobase.frame.j jVar = this.mPixelFrameRender;
        if (jVar != null) {
            jVar.a();
            this.mPixelFrameRender = null;
        }
        this.mGLFrameBuffer.d();
        com.tencent.liteav.videobase.b.e.a(this.mEGLCore);
        this.mEGLCore = null;
    }

    public void initialize() {
        LiteavLog.i(this.mTag, ContentResolver.SYNC_EXTRAS_INITIALIZE);
        synchronized (this) {
            if (this.mIsInitialized) {
                LiteavLog.w(this.mTag, "already initialized.");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("thumbnailG_" + hashCode());
            handlerThread.start();
            this.mHandler = new com.tencent.liteav.base.util.b(handlerThread.getLooper());
            this.mIsInitialized = true;
            UGCMediaListSource uGCMediaListSource = this.mMediaListSource;
            uGCMediaListSource.getClass();
            runOnThumbnailThread(fh.a(uGCMediaListSource));
        }
    }

    public void setVideoSourceList(List<String> list) {
        runOnThumbnailThread(fj.a(this, list));
    }

    public void setVideoSourceRange(long j, long j2) {
        runOnThumbnailThread(fk.a(this, j, j2));
    }

    public void start(UGCThumbnailGenerateParams uGCThumbnailGenerateParams, TXVideoEditer.TXThumbnailListener tXThumbnailListener) {
        runOnThumbnailThread(fl.a(this, uGCThumbnailGenerateParams, tXThumbnailListener));
    }

    public void stop() {
        runOnThumbnailThread(fn.a(this));
    }

    public void uninitialize() {
        runOnThumbnailThread(fi.a(this));
    }
}
