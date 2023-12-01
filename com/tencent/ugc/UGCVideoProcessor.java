package com.tencent.ugc;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderListener;
import com.tencent.liteav.videoproducer.encoder.VideoEncodeParams;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.TXVideoEditer;
import com.tencent.ugc.UGCAVSyncer;
import com.tencent.ugc.datereport.UGCDataReport;
import com.tencent.ugc.videoprocessor.SpeedProcessor;
import com.tencent.ugc.videoprocessor.VideoEffectProcessor;
import com.tencent.ugc.videoprocessor.VideoProcessManager;
import com.tencent.ugc.videoprocessor.VideoTransitionProcessor;
import com.tencent.ugc.videoprocessor.WatermarkProcessor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCVideoProcessor.class */
public class UGCVideoProcessor {
    private static final int MSG_FORCE_PROCESS = 105;
    private static final int MSG_PAUSE = 102;
    private static final int MSG_PROCESS_FROM_SOURCE = 101;
    private static final int MSG_REFRESH = 104;
    private static final int MSG_START = 100;
    private static final int MSG_STOP = 103;
    private static final String TAG = "UGCVideoProcessor";
    private DisplayTarget mDisplayTarget;
    private com.tencent.liteav.videobase.b.e mEGLCore;
    private com.tencent.liteav.videobase.frame.e mGLTexturePool;
    private boolean mInvalidate;
    private PixelFrame mLastRenderFrame;
    private com.tencent.liteav.videobase.frame.j mPreScaleRenderer;
    private List<TXVideoEditConstants.TXAbsoluteRect> mRectList;
    private HandlerThread mRenderThread;
    private com.tencent.liteav.videoconsumer.renderer.g mRenderer;
    private IVideoReporter mReporter;
    private SpeedProcessor mSpeedProcessor;
    private a mStatus;
    private TXVideoEditer.TXVideoCustomProcessListener mTXVideoCustomProcessListener;
    private final UGCAVSyncer mUGCAVSyncer;
    private UGCCombineProcessor mUGCCombineProcessor;
    private UGCMediaListSource mUGCMediaListSource;
    private UGCTransitionProcessor mUGCTransitionProcessor;
    private com.tencent.liteav.videoproducer.encoder.ai mVideoEncodeController;
    private VideoEncodeParams mVideoEncodeParams;
    private VideoEncodedFrameListener mVideoEncodedFrameListener;
    private com.tencent.liteav.base.util.b mVideoProcessHandler;
    private VideoProcessListener mVideoProcessListener;
    private VideoProcessManager mVideoProcessManager;
    private boolean mIsInit = false;
    private int mTransitionType = -1;
    private long mFinalPts = -1;
    private GLConstants.GLScaleType mScaleType = GLConstants.GLScaleType.FIT_CENTER;
    private Rotation mRotation = Rotation.NORMAL;
    private boolean mIsRecord = false;
    private float mLastProgress = 0.0f;
    private Object mCurEGLContext = null;
    private int mCurEGLWidth = -1;
    private int mCurEGLHeight = -1;
    private int mOutputWidth = -1;
    private int mOutputHeight = -1;
    private VideoRenderListener mVideoRenderListener = new AnonymousClass1();
    private com.tencent.liteav.videoproducer.preprocessor.ag mVideoPreprocessorListener = new AnonymousClass2();
    private VideoEncoderDef.VideoEncoderDataListener mVideoEncoderDataListener = new AnonymousClass3();
    private VideoProcessManager.IVideoProcessorListener mEffectProcessorListener = new AnonymousClass4();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.ugc.UGCVideoProcessor$1  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCVideoProcessor$1.class */
    public final class AnonymousClass1 implements VideoRenderListener {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void a(AnonymousClass1 anonymousClass1, int i, int i2) {
            if (UGCVideoProcessor.this.mVideoProcessManager != null) {
                UGCVideoProcessor.this.mVideoProcessManager.setOutputSize(i, i2);
            }
        }

        @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderListener
        public final void onRenderFrame(PixelFrame pixelFrame) {
        }

        @Override // com.tencent.liteav.videoconsumer.renderer.VideoRenderListener
        public final void onRenderTargetSizeChanged(int i, int i2) {
            LiteavLog.i(UGCVideoProcessor.TAG, "onRenderSizeChange " + i + "," + i2);
            UGCVideoProcessor.this.runOnVideoProcessHandler(gf.a(this, i, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.ugc.UGCVideoProcessor$2  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCVideoProcessor$2.class */
    public final class AnonymousClass2 implements com.tencent.liteav.videoproducer.preprocessor.ag {
        AnonymousClass2() {
        }

        @Override // com.tencent.liteav.videoproducer.preprocessor.ag
        public final void a(int i, PixelFrame pixelFrame) {
            pixelFrame.retain();
            if (pixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_2D || pixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_OES) {
                GLES20.glFinish();
            }
            if (UGCVideoProcessor.this.runOnVideoProcessHandler(gg.a(this, pixelFrame))) {
                return;
            }
            pixelFrame.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.ugc.UGCVideoProcessor$3  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCVideoProcessor$3.class */
    public final class AnonymousClass3 implements VideoEncoderDef.VideoEncoderDataListener {
        AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void a(AnonymousClass3 anonymousClass3, EncodedVideoFrame encodedVideoFrame) {
            if (UGCVideoProcessor.this.mVideoEncodedFrameListener == null) {
                return;
            }
            if (encodedVideoFrame != null) {
                UGCVideoProcessor.this.mVideoEncodedFrameListener.onVideoFrameEncoded(encodedVideoFrame);
                if (encodedVideoFrame.pts != UGCVideoProcessor.this.mFinalPts) {
                    return;
                }
            }
            UGCVideoProcessor.this.mVideoEncodedFrameListener.onVideoEncodingCompleted();
            UGCVideoProcessor.this.stopEncoder();
        }

        @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.VideoEncoderDataListener
        public final void onEncodedFail(h.a aVar) {
            LiteavLog.e(UGCVideoProcessor.TAG, "onEncodedFail: ");
            TXVideoEditConstants.TXGenerateResult tXGenerateResult = new TXVideoEditConstants.TXGenerateResult();
            tXGenerateResult.retCode = aVar.ordinal();
            tXGenerateResult.descMsg = aVar.name();
            UGCVideoProcessor.this.mVideoProcessListener.onComplete(tXGenerateResult);
        }

        @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.VideoEncoderDataListener
        public final void onEncodedNAL(EncodedVideoFrame encodedVideoFrame, boolean z) {
            UGCVideoProcessor.this.runOnVideoProcessHandler(gh.a(this, encodedVideoFrame));
        }

        @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.VideoEncoderDataListener
        public final void onOutputFormatChanged(MediaFormat mediaFormat) {
            LiteavLog.i(UGCVideoProcessor.TAG, "onOutputFormatChanged: ".concat(String.valueOf(mediaFormat)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.ugc.UGCVideoProcessor$4  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCVideoProcessor$4.class */
    public final class AnonymousClass4 implements VideoProcessManager.IVideoProcessorListener {
        AnonymousClass4() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void a(AnonymousClass4 anonymousClass4, PixelFrame pixelFrame) {
            UGCVideoProcessor.this.handleProcessFrame(pixelFrame);
            pixelFrame.release();
        }

        @Override // com.tencent.ugc.videoprocessor.VideoProcessManager.IVideoProcessorListener
        public final int customProcessFrame(PixelFrame pixelFrame) {
            if (UGCVideoProcessor.this.mTXVideoCustomProcessListener == null || pixelFrame == null) {
                return -1;
            }
            if (pixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_2D || pixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_OES) {
                GLES20.glFinish();
            }
            return UGCVideoProcessor.this.mTXVideoCustomProcessListener.onTextureCustomProcess(pixelFrame.getTextureId(), pixelFrame.getWidth(), pixelFrame.getHeight(), pixelFrame.getTimestamp());
        }

        @Override // com.tencent.ugc.videoprocessor.VideoProcessManager.IVideoProcessorListener
        public final void didProcessFrame(PixelFrame pixelFrame) {
            pixelFrame.retain();
            if (pixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_2D || pixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_OES) {
                GLES20.glFinish();
            }
            if (UGCVideoProcessor.this.runOnVideoProcessHandler(gi.a(this, pixelFrame))) {
                return;
            }
            pixelFrame.release();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCVideoProcessor$VideoEncodedFrameListener.class */
    public interface VideoEncodedFrameListener {
        void onVideoEncodeStarted();

        void onVideoEncodingCompleted();

        void onVideoFrameEncoded(EncodedVideoFrame encodedVideoFrame);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCVideoProcessor$VideoProcessListener.class */
    public interface VideoProcessListener {
        void onComplete(TXVideoEditConstants.TXGenerateResult tXGenerateResult);

        void onProgress(float f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCVideoProcessor$a.class */
    public enum a {
        STOPPED,
        STARTED,
        PAUSED
    }

    public UGCVideoProcessor(Context context, UGCMediaListSource uGCMediaListSource, UGCAVSyncer uGCAVSyncer, IVideoReporter iVideoReporter, boolean z) {
        this.mUGCMediaListSource = uGCMediaListSource;
        this.mUGCAVSyncer = uGCAVSyncer;
        this.mReporter = iVideoReporter;
        this.mVideoProcessManager = new VideoProcessManager(context, z, iVideoReporter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean handleMessage(Message message) {
        PixelFrame pixelFrame;
        VideoProcessManager videoProcessManager;
        LiteavLog.d(TAG, "handleMessage: " + message.what);
        switch (message.what) {
            case 100:
                this.mStatus = a.STARTED;
                if (this.mIsRecord) {
                    initEncoder();
                    return true;
                }
                initRenderer();
                return true;
            case 101:
                break;
            case 102:
                this.mStatus = a.PAUSED;
                return true;
            case 103:
                this.mStatus = a.STOPPED;
                return true;
            case 104:
                if (this.mStatus == a.STARTED || (pixelFrame = this.mLastRenderFrame) == null || (videoProcessManager = this.mVideoProcessManager) == null) {
                    return true;
                }
                videoProcessManager.processFrame(pixelFrame);
                return true;
            case 105:
                LiteavLog.i(TAG, "handleMessage: MSG_FORCE_PROCESS");
                removeMsgFromVideoProcessHandler(105);
                this.mInvalidate = true;
                break;
            default:
                return true;
        }
        if (this.mStatus == a.STARTED || this.mInvalidate) {
            processFrame();
            this.mInvalidate = false;
            return true;
        }
        LiteavLog.e(TAG, "MSG_PROCESS_FROM_SOURCE FAILD AS mStatus == " + this.mStatus);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleProcessFrame(PixelFrame pixelFrame) {
        com.tencent.liteav.videoproducer.encoder.ai aiVar;
        com.tencent.liteav.videoconsumer.renderer.g gVar;
        if (this.mVideoProcessListener != null) {
            float timestamp = (float) (pixelFrame.getTimestamp() / (this.mUGCMediaListSource.getDuration() * 1.0d));
            if (timestamp - this.mLastProgress > 0.01f) {
                LiteavLog.d(TAG, "handleProcessFrame: progress：" + timestamp + "  frame.getTimestamp()：" + pixelFrame.getTimestamp() + "  mUGCMediaListSource.getDuration()：" + this.mUGCMediaListSource.getDuration());
                this.mVideoProcessListener.onProgress(timestamp);
            }
        }
        if (!this.mIsRecord && (gVar = this.mRenderer) != null) {
            gVar.renderFrame(pixelFrame);
        }
        if (this.mIsRecord && (aiVar = this.mVideoEncodeController) != null) {
            aiVar.a(pixelFrame);
            if (this.mFinalPts > 0 && pixelFrame.getTimestamp() == this.mFinalPts) {
                LiteavLog.i(TAG, "processFrameFromSource: signalEndOfStream");
                this.mVideoEncodeController.d();
                return;
            }
        }
        if (this.mStatus == a.STARTED) {
            sendMsgToVideoProcessHandler(101);
        }
    }

    private void initEncoder() {
        if (this.mVideoEncodeController != null || this.mVideoEncodeParams == null) {
            return;
        }
        com.tencent.liteav.videoproducer.encoder.ai aiVar = new com.tencent.liteav.videoproducer.encoder.ai(this.mReporter, VideoProducerDef.StreamType.STREAM_TYPE_BIG_VIDEO, true);
        this.mVideoEncodeController = aiVar;
        aiVar.b();
        this.mVideoEncodeController.a(VideoEncoderDef.EncodeStrategy.PREFER_HARDWARE);
        this.mVideoEncodeController.b(this.mRotation);
        this.mVideoEncodeController.a(this.mVideoEncodeParams, this.mVideoEncoderDataListener);
        VideoEncodedFrameListener videoEncodedFrameListener = this.mVideoEncodedFrameListener;
        if (videoEncodedFrameListener != null) {
            videoEncodedFrameListener.onVideoEncodeStarted();
        }
    }

    private void initProcessChain(int i, int i2) {
        LiteavLog.i(TAG, "initProcessChain:  width:" + i + " height:" + i2);
        if (this.mEGLCore == null) {
            return;
        }
        VideoProcessManager videoProcessManager = this.mVideoProcessManager;
        if (videoProcessManager != null) {
            videoProcessManager.initialize(this.mGLTexturePool, i, i2, this.mVideoPreprocessorListener);
            this.mVideoProcessManager.setListener(this.mEffectProcessorListener);
        }
        this.mUGCTransitionProcessor = new UGCTransitionProcessor(i, i2, this.mGLTexturePool);
        this.mUGCCombineProcessor = new UGCCombineProcessor(i, i2, this.mGLTexturePool);
    }

    private void initRenderer() {
        if (this.mRenderer != null) {
            return;
        }
        if (this.mRenderThread == null) {
            HandlerThread handlerThread = new HandlerThread("VideoProcessRender" + hashCode());
            this.mRenderThread = handlerThread;
            handlerThread.start();
        }
        com.tencent.liteav.videoconsumer.renderer.g gVar = new com.tencent.liteav.videoconsumer.renderer.g(this.mRenderThread.getLooper(), this.mReporter);
        this.mRenderer = gVar;
        DisplayTarget displayTarget = this.mDisplayTarget;
        if (displayTarget != null) {
            gVar.setDisplayView(displayTarget, true);
            this.mRenderer.setScaleType(this.mScaleType);
        }
        this.mRenderer.start(this.mVideoRenderListener);
    }

    private void initializeEGL(Object obj, int i, int i2) {
        try {
            com.tencent.liteav.videobase.b.e eVar = new com.tencent.liteav.videobase.b.e();
            this.mEGLCore = eVar;
            eVar.a(obj, null, i, i2);
            this.mEGLCore.a();
            this.mCurEGLContext = obj;
            this.mCurEGLWidth = i;
            this.mCurEGLHeight = i2;
            this.mGLTexturePool = new com.tencent.liteav.videobase.frame.e();
        } catch (com.tencent.liteav.videobase.b.g e) {
            this.mEGLCore = null;
            LiteavLog.e(TAG, e.getMessage());
        }
    }

    private boolean isNeedReCreateEGL(Object obj, int i, int i2) {
        Object obj2 = this.mCurEGLContext;
        if (obj2 == null || i < 0 || i2 < 0) {
            return false;
        }
        if (obj.equals(obj2) && this.mCurEGLWidth == i && this.mCurEGLHeight == i2) {
            return false;
        }
        LiteavLog.i(TAG, "isNeedReCreateEGL: true");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setBeautyFilter$10(UGCVideoProcessor uGCVideoProcessor, int i, int i2) {
        VideoProcessManager videoProcessManager = uGCVideoProcessor.mVideoProcessManager;
        if (videoProcessManager != null) {
            videoProcessManager.setBeautyFilter(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setDisplayView$4(UGCVideoProcessor uGCVideoProcessor, DisplayTarget displayTarget, GLConstants.GLScaleType gLScaleType) {
        uGCVideoProcessor.mDisplayTarget = displayTarget;
        if (gLScaleType != null) {
            uGCVideoProcessor.mScaleType = gLScaleType;
        }
        com.tencent.liteav.videoconsumer.renderer.g gVar = uGCVideoProcessor.mRenderer;
        if (gVar != null) {
            gVar.setDisplayView(uGCVideoProcessor.mDisplayTarget, true);
            uGCVideoProcessor.mRenderer.setScaleType(uGCVideoProcessor.mScaleType);
        }
        VideoProcessManager videoProcessManager = uGCVideoProcessor.mVideoProcessManager;
        if (videoProcessManager != null) {
            videoProcessManager.setScaleType(uGCVideoProcessor.mScaleType);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setFilter$12(UGCVideoProcessor uGCVideoProcessor, Bitmap bitmap, float f, Bitmap bitmap2, float f2, float f3) {
        VideoProcessManager videoProcessManager = uGCVideoProcessor.mVideoProcessManager;
        if (videoProcessManager != null) {
            videoProcessManager.setFilter(bitmap, f, bitmap2, f2, f3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setOutputSize$3(UGCVideoProcessor uGCVideoProcessor, int i, int i2, GLConstants.GLScaleType gLScaleType) {
        uGCVideoProcessor.mOutputWidth = i;
        uGCVideoProcessor.mOutputHeight = i2;
        if (i > 0) {
            uGCVideoProcessor.mScaleType = gLScaleType;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setRenderRotation$5(UGCVideoProcessor uGCVideoProcessor, Rotation rotation) {
        uGCVideoProcessor.mRotation = rotation;
        com.tencent.liteav.videoconsumer.renderer.g gVar = uGCVideoProcessor.mRenderer;
        if (gVar != null) {
            gVar.setRenderRotation(rotation);
        }
        com.tencent.liteav.videoproducer.encoder.ai aiVar = uGCVideoProcessor.mVideoEncodeController;
        if (aiVar != null) {
            aiVar.b(uGCVideoProcessor.mRotation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setSpecialRatio$11(UGCVideoProcessor uGCVideoProcessor, float f) {
        VideoProcessManager videoProcessManager = uGCVideoProcessor.mVideoProcessManager;
        if (videoProcessManager != null) {
            videoProcessManager.setSpecialRatio(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setSpeedList$9(UGCVideoProcessor uGCVideoProcessor, List list) {
        if (uGCVideoProcessor.mSpeedProcessor == null) {
            uGCVideoProcessor.mSpeedProcessor = new SpeedProcessor();
        }
        LiteavLog.i(TAG, "==== setSpeedList ==== ");
        if (list == null) {
            uGCVideoProcessor.mSpeedProcessor.setSpeedList(null);
            return;
        }
        UGCDataReport.reportDAU(1019);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                uGCVideoProcessor.mSpeedProcessor.setSpeedList(arrayList);
                return;
            }
            TXVideoEditConstants.TXSpeed tXSpeed = (TXVideoEditConstants.TXSpeed) list.get(i2);
            TXVideoEditConstants.TXSpeed tXSpeed2 = new TXVideoEditConstants.TXSpeed();
            tXSpeed2.speedLevel = tXSpeed.speedLevel;
            tXSpeed2.startTime = tXSpeed.startTime;
            tXSpeed2.endTime = tXSpeed.endTime;
            arrayList.add(tXSpeed2);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setSplitScreenList$2(UGCVideoProcessor uGCVideoProcessor, List list, int i, int i2) {
        uGCVideoProcessor.mRectList = list;
        uGCVideoProcessor.setOutputSize(i, i2, GLConstants.GLScaleType.FIT_CENTER);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$unInitialize$0(UGCVideoProcessor uGCVideoProcessor) {
        uGCVideoProcessor.mFinalPts = -1L;
        PixelFrame pixelFrame = uGCVideoProcessor.mLastRenderFrame;
        if (pixelFrame != null) {
            pixelFrame.release();
            uGCVideoProcessor.mLastRenderFrame = null;
        }
        com.tencent.liteav.videoconsumer.renderer.g gVar = uGCVideoProcessor.mRenderer;
        if (gVar != null) {
            gVar.stop(false);
            uGCVideoProcessor.mRenderer = null;
        }
        uGCVideoProcessor.stopEncoder();
        com.tencent.liteav.videobase.frame.j jVar = uGCVideoProcessor.mPreScaleRenderer;
        if (jVar != null) {
            jVar.a();
            uGCVideoProcessor.mPreScaleRenderer = null;
        }
        uGCVideoProcessor.uninitVideoProcessor();
        HandlerThread handlerThread = uGCVideoProcessor.mRenderThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            uGCVideoProcessor.mRenderThread = null;
        }
        uGCVideoProcessor.uninitializedEGL();
        synchronized (uGCVideoProcessor) {
            if (uGCVideoProcessor.mVideoProcessHandler != null) {
                uGCVideoProcessor.mVideoProcessHandler.a();
                uGCVideoProcessor.mVideoProcessHandler = null;
            }
        }
    }

    private PixelFrame preScale(PixelFrame pixelFrame) {
        if (this.mEGLCore == null || this.mOutputHeight <= 0 || this.mOutputWidth <= 0 || (pixelFrame.getWidth() == this.mOutputWidth && pixelFrame.getHeight() == this.mOutputHeight)) {
            pixelFrame.retain();
            return pixelFrame;
        }
        if (this.mPreScaleRenderer == null) {
            this.mPreScaleRenderer = new com.tencent.liteav.videobase.frame.j(this.mOutputWidth, this.mOutputHeight);
        }
        com.tencent.liteav.videobase.frame.d a2 = this.mGLTexturePool.a(this.mOutputWidth, this.mOutputHeight);
        this.mPreScaleRenderer.a(pixelFrame, this.mScaleType, a2);
        PixelFrame a3 = a2.a(this.mEGLCore.d());
        a3.setTimestamp(pixelFrame.getTimestamp());
        a2.release();
        return a3;
    }

    private void processFrame() {
        if (this.mIsInit) {
            List<PixelFrame> readNextVideoFrame = this.mUGCMediaListSource.readNextVideoFrame();
            boolean z = false;
            if (readNextVideoFrame == null || readNextVideoFrame.size() <= 0) {
                if (this.mVideoProcessListener != null) {
                    TXVideoEditConstants.TXGenerateResult tXGenerateResult = new TXVideoEditConstants.TXGenerateResult();
                    tXGenerateResult.retCode = 0;
                    tXGenerateResult.descMsg = "";
                    this.mVideoProcessListener.onComplete(tXGenerateResult);
                }
                PixelFrame pixelFrame = this.mLastRenderFrame;
                if (pixelFrame != null) {
                    this.mFinalPts = pixelFrame.getTimestamp();
                    LiteavLog.i(TAG, "processFrameFromSource: mFinalPts:" + this.mFinalPts);
                    return;
                }
                return;
            }
            PixelFrame pixelFrame2 = readNextVideoFrame.get(0);
            int width = pixelFrame2.getWidth();
            int height = pixelFrame2.getHeight();
            int i = this.mOutputWidth;
            int i2 = width;
            int i3 = height;
            if (i > 0) {
                int i4 = this.mOutputHeight;
                i2 = width;
                i3 = height;
                if (i4 > 0) {
                    i2 = i;
                    i3 = i4;
                }
            }
            if (isNeedReCreateEGL(pixelFrame2.getGLContext(), i2, i3)) {
                VideoProcessManager videoProcessManager = this.mVideoProcessManager;
                if (videoProcessManager != null) {
                    videoProcessManager.unInitialize(this.mVideoPreprocessorListener);
                }
                UGCTransitionProcessor uGCTransitionProcessor = this.mUGCTransitionProcessor;
                if (uGCTransitionProcessor != null) {
                    uGCTransitionProcessor.release();
                    this.mUGCTransitionProcessor = null;
                }
                UGCCombineProcessor uGCCombineProcessor = this.mUGCCombineProcessor;
                if (uGCCombineProcessor != null) {
                    uGCCombineProcessor.release();
                    this.mUGCCombineProcessor = null;
                }
                com.tencent.liteav.videobase.frame.j jVar = this.mPreScaleRenderer;
                if (jVar != null) {
                    jVar.a();
                    this.mPreScaleRenderer = null;
                }
                uninitializedEGL();
                z = true;
            }
            if (this.mEGLCore == null) {
                initializeEGL(pixelFrame2.getGLContext(), i2, i3);
                if (z) {
                    reInitProcessorChain(i2, i3);
                } else {
                    initProcessChain(i2, i3);
                }
            }
            if (this.mUGCAVSyncer.syncVideo(pixelFrame2.getTimestamp()) == UGCAVSyncer.SkipMode.SKIP_CURRENT_FRAME) {
                for (PixelFrame pixelFrame3 : readNextVideoFrame) {
                    pixelFrame3.release();
                }
                if (this.mStatus == a.STARTED) {
                    sendMsgToVideoProcessHandler(101);
                    return;
                }
                return;
            }
            if (readNextVideoFrame.size() > 1) {
                List<TXVideoEditConstants.TXAbsoluteRect> list = this.mRectList;
                pixelFrame2 = list != null ? this.mUGCCombineProcessor.processFrame(readNextVideoFrame, list) : this.mUGCTransitionProcessor.processFrame(readNextVideoFrame, this.mTransitionType);
            }
            PixelFrame pixelFrame4 = this.mLastRenderFrame;
            if (pixelFrame4 != null) {
                pixelFrame4.release();
            }
            PixelFrame preScale = preScale(pixelFrame2);
            this.mLastRenderFrame = preScale;
            VideoProcessManager videoProcessManager2 = this.mVideoProcessManager;
            if (videoProcessManager2 != null) {
                videoProcessManager2.processFrame(preScale);
            }
            if (readNextVideoFrame.size() > 1) {
                pixelFrame2.release();
            }
            for (PixelFrame pixelFrame5 : readNextVideoFrame) {
                pixelFrame5.release();
            }
        }
    }

    private void reInitProcessorChain(int i, int i2) {
        if (this.mEGLCore == null) {
            return;
        }
        VideoProcessManager videoProcessManager = this.mVideoProcessManager;
        if (videoProcessManager != null) {
            videoProcessManager.reInitFilter(this.mGLTexturePool, i, i2, this.mVideoPreprocessorListener);
        }
        if (this.mUGCTransitionProcessor == null) {
            this.mUGCTransitionProcessor = new UGCTransitionProcessor(i, i2, this.mGLTexturePool);
        }
        if (this.mUGCCombineProcessor == null) {
            this.mUGCCombineProcessor = new UGCCombineProcessor(i, i2, this.mGLTexturePool);
        }
    }

    private void removeMsgFromVideoProcessHandler(int i) {
        synchronized (this) {
            if (this.mVideoProcessHandler != null) {
                this.mVideoProcessHandler.removeMessages(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean runOnVideoProcessHandler(Runnable runnable) {
        synchronized (this) {
            if (this.mVideoProcessHandler != null && this.mVideoProcessHandler.getLooper() != null && this.mVideoProcessHandler.getLooper().getThread() != null && this.mVideoProcessHandler.getLooper().getThread().isAlive()) {
                com.tencent.liteav.base.util.b bVar = this.mVideoProcessHandler;
                if (bVar != null) {
                    if (Looper.myLooper() == bVar.getLooper()) {
                        runnable.run();
                        return true;
                    }
                    boolean post = bVar.post(runnable);
                    if (!post) {
                        LiteavLog.e(TAG, "handler post fail ret = ".concat(String.valueOf(post)));
                    }
                    return post;
                }
                return false;
            }
            LiteavLog.e(TAG, "handler post fail thread is not alive ");
            return false;
        }
    }

    private void sendMsgToVideoProcessHandler(int i) {
        synchronized (this) {
            if (this.mVideoProcessHandler != null) {
                this.mVideoProcessHandler.sendEmptyMessage(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopEncoder() {
        com.tencent.liteav.videoproducer.encoder.ai aiVar = this.mVideoEncodeController;
        if (aiVar == null) {
            return;
        }
        this.mFinalPts = -1L;
        aiVar.d();
        this.mVideoEncodeController.e();
        this.mVideoEncodeController.c();
        this.mVideoEncodeController = null;
    }

    private void uninitVideoProcessor() {
        LiteavLog.i(TAG, "uninitVideoProcessor: ");
        VideoProcessManager videoProcessManager = this.mVideoProcessManager;
        if (videoProcessManager != null) {
            videoProcessManager.destroyFilter(this.mVideoPreprocessorListener);
            this.mVideoProcessManager = null;
        }
        UGCTransitionProcessor uGCTransitionProcessor = this.mUGCTransitionProcessor;
        if (uGCTransitionProcessor != null) {
            uGCTransitionProcessor.release();
            this.mUGCTransitionProcessor = null;
        }
        UGCCombineProcessor uGCCombineProcessor = this.mUGCCombineProcessor;
        if (uGCCombineProcessor != null) {
            uGCCombineProcessor.release();
            this.mUGCCombineProcessor = null;
        }
    }

    private void uninitializedEGL() {
        LiteavLog.i(TAG, "uninitializedEGL");
        com.tencent.liteav.videobase.frame.e eVar = this.mGLTexturePool;
        if (eVar != null) {
            eVar.b();
        }
        TXVideoEditer.TXVideoCustomProcessListener tXVideoCustomProcessListener = this.mTXVideoCustomProcessListener;
        if (tXVideoCustomProcessListener != null) {
            tXVideoCustomProcessListener.onTextureDestroyed();
        }
        com.tencent.liteav.videobase.b.e.a(this.mEGLCore);
        this.mEGLCore = null;
    }

    public VideoEffectProcessor getEffectProcessor() {
        VideoProcessManager videoProcessManager = this.mVideoProcessManager;
        if (videoProcessManager != null) {
            return videoProcessManager.getEffectProcessor();
        }
        return null;
    }

    public VideoTransitionProcessor getTransitionProcessor() {
        VideoProcessManager videoProcessManager = this.mVideoProcessManager;
        if (videoProcessManager != null) {
            return videoProcessManager.getTransitionProcessor();
        }
        return null;
    }

    public WatermarkProcessor getWatermarkProcessor() {
        VideoProcessManager videoProcessManager = this.mVideoProcessManager;
        if (videoProcessManager != null) {
            return videoProcessManager.getWatermarkProcessor();
        }
        return null;
    }

    public void initialize() {
        if (this.mIsInit) {
            return;
        }
        this.mIsInit = true;
        LiteavLog.i(TAG, "initialize: ");
        HandlerThread handlerThread = new HandlerThread("VideoProcess_" + hashCode());
        handlerThread.start();
        synchronized (this) {
            this.mVideoProcessHandler = new com.tencent.liteav.base.util.b(handlerThread.getLooper(), fo.a(this));
        }
    }

    public void seekTo(long j) {
        LiteavLog.i(TAG, "seekTo: ".concat(String.valueOf(j)));
        removeMsgFromVideoProcessHandler(105);
        sendMsgToVideoProcessHandler(105);
    }

    public void setBeautyFilter(int i, int i2) {
        runOnVideoProcessHandler(fs.a(this, i, i2));
    }

    public void setCustomVideoProcessListener(TXVideoEditer.TXVideoCustomProcessListener tXVideoCustomProcessListener) {
        runOnVideoProcessHandler(fv.a(this, tXVideoCustomProcessListener));
    }

    public void setDisplayView(DisplayTarget displayTarget, GLConstants.GLScaleType gLScaleType) {
        LiteavLog.i(TAG, "setDisplayView: displayTarget:" + displayTarget + "scaleType:" + gLScaleType);
        runOnVideoProcessHandler(gc.a(this, displayTarget, gLScaleType));
    }

    public void setEncodeParams(VideoEncodeParams videoEncodeParams) {
        LiteavLog.i(TAG, "setEncodeParams: ".concat(String.valueOf(videoEncodeParams)));
        runOnVideoProcessHandler(ge.a(this, videoEncodeParams));
    }

    public void setFilter(Bitmap bitmap, float f, Bitmap bitmap2, float f2, float f3) {
        runOnVideoProcessHandler(fu.a(this, bitmap, f, bitmap2, f2, f3));
    }

    public void setOutputSize(int i, int i2, GLConstants.GLScaleType gLScaleType) {
        runOnVideoProcessHandler(gb.a(this, i, i2, gLScaleType));
    }

    public void setPictureTransition(int i) {
        runOnVideoProcessHandler(fq.a(this, i));
    }

    public void setProgressListener(VideoProcessListener videoProcessListener) {
        runOnVideoProcessHandler(fw.a(this, videoProcessListener));
    }

    public void setRenderRotation(Rotation rotation) {
        LiteavLog.i(TAG, "setRenderRotation: ".concat(String.valueOf(rotation)));
        if (rotation == null) {
            return;
        }
        runOnVideoProcessHandler(gd.a(this, rotation));
        sendMsgToVideoProcessHandler(104);
    }

    public void setSpecialRatio(float f) {
        runOnVideoProcessHandler(ft.a(this, f));
        sendMsgToVideoProcessHandler(104);
    }

    public void setSpeedList(List<TXVideoEditConstants.TXSpeed> list) {
        runOnVideoProcessHandler(fr.a(this, list));
    }

    public void setSplitScreenList(List<TXVideoEditConstants.TXAbsoluteRect> list, int i, int i2) {
        runOnVideoProcessHandler(ga.a(this, list, i, i2));
    }

    public void setVideoEncodedFrameListener(VideoEncodedFrameListener videoEncodedFrameListener) {
        runOnVideoProcessHandler(fp.a(this, videoEncodedFrameListener));
    }

    public void start(boolean z) {
        LiteavLog.i(TAG, "start: ".concat(String.valueOf(z)));
        runOnVideoProcessHandler(fy.a(this, z));
        sendMsgToVideoProcessHandler(100);
        sendMsgToVideoProcessHandler(101);
    }

    public void stop() {
        LiteavLog.i(TAG, "stop: ");
        removeMsgFromVideoProcessHandler(101);
        sendMsgToVideoProcessHandler(103);
        runOnVideoProcessHandler(fz.a(this));
    }

    public void unInitialize() {
        if (this.mIsInit) {
            this.mIsInit = false;
            LiteavLog.i(TAG, "uninitialize");
            runOnVideoProcessHandler(fx.a(this));
        }
    }
}
