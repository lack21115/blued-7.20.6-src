package com.tencent.ugc;

import android.content.ContentResolver;
import android.opengl.GLES20;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;
import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.UGCFrameQueue;
import java.nio.ByteBuffer;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCSingleFilePixelFrameProvider.class */
public class UGCSingleFilePixelFrameProvider implements VideoDecodeController.a, UGCFrameQueue.UGCFrameQueueListener, UGCPixelFrameProvider {
    private static final int MAX_FRAME_SIZE = 3;
    private static final int REVERSE_STEP_TIME = 500;
    private static final String TAG = "UGCVideoFileProvider";
    private final Clip mClip;
    private VideoDemuxer mDemuxer;
    private com.tencent.liteav.videobase.b.e mEGLCore;
    private com.tencent.liteav.videobase.frame.e mGLTexturePool;
    private com.tencent.liteav.videobase.frame.j mPixelFrameRenderer;
    private long mReversePlayCurrentPts;
    private VideoDecodeController mVideoDecodeController;
    private final com.tencent.liteav.base.util.b mWorkHandler;
    private boolean mIsAbandoningDecodingFrame = false;
    private long mSeekingTimeMs = -1;
    private boolean mIsInPreciseSeeking = true;
    private boolean mHasReadEOF = false;
    private boolean mIsDecodeCompleted = false;
    private boolean mIsFrameSendingDecoder = false;
    private boolean mIsReverse = false;
    private int mFrameCacheCapacityForReverse = 0;
    private int mVideoWidth = 0;
    private int mVideoHeight = 0;
    private Rotation mVideoRotation = Rotation.NORMAL;
    private final UGCFrameQueue<List<PixelFrame>> mPixFrameQueue = new UGCFrameQueue<>();
    private final Deque<PixelFrame> mPixFrameCacheForReverse = new LinkedList();

    public UGCSingleFilePixelFrameProvider(Clip clip, com.tencent.liteav.base.util.b bVar) {
        this.mClip = new Clip(clip);
        this.mWorkHandler = bVar;
    }

    private void addFrameToQueue(PixelFrame pixelFrame) {
        if (pixelFrame == null) {
            this.mPixFrameQueue.queue(END_OF_STREAM);
        } else if (pixelFrame.getTimestamp() < this.mClip.startInFileTime) {
            pixelFrame.release();
        } else if (pixelFrame.getTimestamp() <= this.mClip.endInFileTime) {
            pixelFrame.setTimestamp(fileTimeToTimeline(pixelFrame.getTimestamp()));
            LinkedList linkedList = new LinkedList();
            linkedList.add(pixelFrame);
            this.mPixFrameQueue.queue(linkedList);
        } else {
            LiteavLog.i(TAG, "addFrameToQueue Timestamp = " + pixelFrame.getTimestamp() + " endInnerFileTime = " + this.mClip.endInFileTime);
            this.mPixFrameQueue.queue(END_OF_STREAM);
            pixelFrame.release();
        }
    }

    private void addFrameToQueueForReverse(PixelFrame pixelFrame) {
        if (pixelFrame != null && pixelFrame.getTimestamp() <= this.mReversePlayCurrentPts) {
            this.mPixFrameCacheForReverse.addLast(pixelFrame);
            return;
        }
        if (pixelFrame != null) {
            pixelFrame.release();
        }
        if (this.mPixFrameCacheForReverse.isEmpty()) {
            LiteavLog.i(TAG, "mGopVideoFrameList isEmpty so put END_OF_STREAM");
            this.mPixFrameQueue.queue(END_OF_STREAM);
            return;
        }
        this.mFrameCacheCapacityForReverse = this.mPixFrameCacheForReverse.size();
        while (!this.mPixFrameCacheForReverse.isEmpty()) {
            PixelFrame pollLast = this.mPixFrameCacheForReverse.pollLast();
            long timestamp = pollLast.getTimestamp();
            this.mReversePlayCurrentPts = timestamp;
            if (timestamp > this.mClip.endInFileTime || this.mReversePlayCurrentPts < this.mClip.startInFileTime) {
                pollLast.release();
            } else {
                pollLast.setTimestamp(fileTimeToTimelineForReverse(this.mReversePlayCurrentPts));
                LinkedList linkedList = new LinkedList();
                linkedList.add(pollLast);
                this.mPixFrameQueue.queue(linkedList);
            }
        }
        if (this.mReversePlayCurrentPts <= this.mClip.startInFileTime) {
            LiteavLog.i(TAG, "mLastGopFinishPts is smaller start time so put END_OF_STREAM");
            this.mPixFrameQueue.queue(END_OF_STREAM);
            return;
        }
        long j = this.mReversePlayCurrentPts - 1;
        this.mReversePlayCurrentPts = j;
        seekToInFileTime(j - 500, false);
    }

    private void clearPixelFrameQueue() {
        for (List<PixelFrame> list : this.mPixFrameQueue.dequeueAll()) {
            PixelFrame.releasePixelFrames(list);
        }
    }

    private boolean createDemuxerAndOpenFile() {
        if (this.mClip.videoMimeType == null || "video/hevc".equals(this.mClip.videoMimeType) || "video/avc".equals(this.mClip.videoMimeType)) {
            this.mDemuxer = new VideoDemuxerFFmpeg();
        } else {
            this.mDemuxer = new VideoDemuxerSystem();
        }
        if (this.mDemuxer.open(this.mClip.path)) {
            return true;
        }
        this.mDemuxer.close();
        this.mDemuxer = null;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void decodeInternal() {
        if (this.mVideoDecodeController == null || !isNeedDecode()) {
            this.mIsFrameSendingDecoder = false;
            return;
        }
        EncodedVideoFrame nextEncodeVideoFrame = this.mDemuxer.getNextEncodeVideoFrame();
        if (nextEncodeVideoFrame != VideoDemuxerFFmpeg.END_OF_STREAM) {
            this.mIsFrameSendingDecoder = true;
            this.mIsDecodeCompleted = false;
            this.mVideoRotation = Rotation.a(nextEncodeVideoFrame.rotation);
            this.mVideoDecodeController.a(nextEncodeVideoFrame);
            return;
        }
        LiteavLog.i(TAG, "demuxer read completed");
        this.mHasReadEOF = true;
        VideoDecodeController videoDecodeController = this.mVideoDecodeController;
        videoDecodeController.a(com.tencent.liteav.videoconsumer.decoder.av.a(videoDecodeController));
        this.mWorkHandler.removeCallbacks(ew.a(this));
        this.mWorkHandler.a(ex.a(this), 1000);
    }

    private long fileTimeToTimeline(long j) {
        long j2 = this.mClip.startInClipsTimeline;
        if (this.mClip.speedList == null) {
            return j2 + (j - this.mClip.startInFileTime);
        }
        for (TXVideoEditConstants.TXSpeed tXSpeed : this.mClip.speedList) {
            float timeMultipleInSpeed = 1.0f / getTimeMultipleInSpeed(tXSpeed.speedLevel);
            if (j < tXSpeed.endTime) {
                return j2 + (((float) (j - tXSpeed.startTime)) * timeMultipleInSpeed);
            }
            j2 += ((float) (tXSpeed.endTime - tXSpeed.startTime)) * timeMultipleInSpeed;
        }
        return j2;
    }

    private long fileTimeToTimelineForReverse(long j) {
        if (this.mClip.speedList == null) {
            return this.mClip.endInFileTime - j;
        }
        long j2 = this.mClip.startInClipsTimeline;
        int size = this.mClip.speedList.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return j2;
            }
            TXVideoEditConstants.TXSpeed tXSpeed = this.mClip.speedList.get(i);
            float timeMultipleInSpeed = 1.0f / getTimeMultipleInSpeed(tXSpeed.speedLevel);
            if (j > tXSpeed.startTime) {
                return j2 + (((float) (tXSpeed.endTime - j)) * timeMultipleInSpeed);
            }
            j2 += ((float) (tXSpeed.endTime - tXSpeed.startTime)) * timeMultipleInSpeed;
            size = i;
        }
    }

    private float getTimeMultipleInSpeed(int i) {
        return UGCMediaListSource.getSpeed(i);
    }

    private void initializeGLComponents() {
        com.tencent.liteav.videobase.b.e eVar = new com.tencent.liteav.videobase.b.e();
        this.mEGLCore = eVar;
        try {
            eVar.a(com.tencent.liteav.videoproducer.capture.au.a().b(), null, 128, 128);
            this.mEGLCore.a();
            this.mGLTexturePool = new com.tencent.liteav.videobase.frame.e();
        } catch (com.tencent.liteav.videobase.b.g e) {
            LiteavLog.e(TAG, "initializeGLComponents failed.", e);
            this.mEGLCore = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initializeInternal() {
        if (this.mVideoDecodeController != null) {
            LiteavLog.w(TAG, "UGCVideoFileProvider is initialized");
            return;
        }
        VideoDecodeController videoDecodeController = new VideoDecodeController(new com.tencent.liteav.videobase.videobase.f(), true);
        this.mVideoDecodeController = videoDecodeController;
        videoDecodeController.a();
        this.mVideoDecodeController.a(com.tencent.liteav.videoproducer.capture.au.a().b());
        this.mVideoDecodeController.a(VideoDecoderDef.ConsumerScene.UNKNOWN);
        initializeGLComponents();
    }

    private boolean isNeedDecode() {
        return (this.mVideoDecodeController != null && this.mDemuxer != null && !this.mIsAbandoningDecodingFrame && !this.mHasReadEOF) && !(!this.mIsReverse ? this.mPixFrameQueue.size() >= 3 : !(this.mPixFrameQueue.size() < 3 || this.mPixFrameQueue.size() + this.mPixFrameCacheForReverse.size() < this.mFrameCacheCapacityForReverse + 3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onAbandonDecodingFramesCompleted$4(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider) {
        if (uGCSingleFilePixelFrameProvider.mVideoDecodeController == null) {
            return;
        }
        uGCSingleFilePixelFrameProvider.mIsAbandoningDecodingFrame = false;
        uGCSingleFilePixelFrameProvider.decodeInternal();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onDecodeFailed$5(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider) {
        if (uGCSingleFilePixelFrameProvider.mVideoDecodeController == null) {
            return;
        }
        uGCSingleFilePixelFrameProvider.mPixFrameQueue.queue(END_OF_STREAM);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onFrameDequeued$3(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider) {
        if (uGCSingleFilePixelFrameProvider.mIsFrameSendingDecoder) {
            return;
        }
        uGCSingleFilePixelFrameProvider.decodeInternal();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$seekTo$0(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider, long j, boolean z) {
        if (uGCSingleFilePixelFrameProvider.mVideoDecodeController == null) {
            return;
        }
        uGCSingleFilePixelFrameProvider.clearPixelFrameQueue();
        long timelineToFileTime = uGCSingleFilePixelFrameProvider.timelineToFileTime(j);
        uGCSingleFilePixelFrameProvider.mReversePlayCurrentPts = timelineToFileTime;
        uGCSingleFilePixelFrameProvider.seekToInFileTime(timelineToFileTime, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDecodeCompletedInternal() {
        LiteavLog.i(TAG, "onDecodeCompletedInteral");
        if (this.mVideoDecodeController == null || this.mIsAbandoningDecodingFrame || this.mIsDecodeCompleted || !this.mHasReadEOF) {
            return;
        }
        if (this.mIsReverse) {
            addFrameToQueueForReverse(null);
        } else {
            addFrameToQueue(null);
        }
        this.mIsDecodeCompleted = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r0 != (-1)) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onDecodeFrameInternal(com.tencent.liteav.videobase.frame.PixelFrame r6) {
        /*
            r5 = this;
            r0 = r5
            com.tencent.liteav.videoconsumer.decoder.VideoDecodeController r0 = r0.mVideoDecodeController
            if (r0 != 0) goto Lc
            r0 = r6
            r0.release()
            return
        Lc:
            r0 = r6
            long r0 = r0.getTimestamp()
            r7 = r0
            r0 = r5
            boolean r0 = r0.mIsAbandoningDecodingFrame
            if (r0 != 0) goto L5f
            r0 = r5
            boolean r0 = r0.mIsReverse
            if (r0 != 0) goto L3f
            r0 = r5
            boolean r0 = r0.mIsInPreciseSeeking
            if (r0 == 0) goto L3f
            r0 = r5
            long r0 = r0.mSeekingTimeMs
            r9 = r0
            r0 = r7
            r1 = r9
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L3f
            r0 = r9
            r1 = -1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L3f
            goto L5f
        L3f:
            r0 = r5
            r1 = -1
            r0.mSeekingTimeMs = r1
            r0 = r5
            r1 = r6
            com.tencent.liteav.videobase.frame.PixelFrame r0 = r0.processFrame(r1)
            r6 = r0
            r0 = r5
            boolean r0 = r0.mIsReverse
            if (r0 == 0) goto L59
            r0 = r5
            r1 = r6
            r0.addFrameToQueueForReverse(r1)
            return
        L59:
            r0 = r5
            r1 = r6
            r0.addFrameToQueue(r1)
            return
        L5f:
            r0 = r6
            r0.release()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.UGCSingleFilePixelFrameProvider.onDecodeFrameInternal(com.tencent.liteav.videobase.frame.PixelFrame):void");
    }

    private PixelFrame processFrame(PixelFrame pixelFrame) {
        com.tencent.liteav.videobase.frame.j jVar;
        try {
            this.mEGLCore.a();
            pixelFrame.setRotation(this.mVideoRotation);
            if (pixelFrame.getRotation() != Rotation.NORMAL && pixelFrame.getRotation() != Rotation.ROTATION_180) {
                pixelFrame.swapWidthHeight();
            }
            int width = pixelFrame.getWidth();
            int height = pixelFrame.getHeight();
            if ((width != this.mVideoWidth || height != this.mVideoHeight) && (jVar = this.mPixelFrameRenderer) != null) {
                jVar.a();
                this.mPixelFrameRenderer = null;
            }
            if (this.mPixelFrameRenderer == null) {
                this.mPixelFrameRenderer = new com.tencent.liteav.videobase.frame.j(width, height);
                this.mVideoWidth = width;
                this.mVideoHeight = height;
            }
            OpenGlUtils.glViewport(0, 0, width, height);
            com.tencent.liteav.videobase.frame.d a2 = this.mGLTexturePool.a(width, height);
            this.mPixelFrameRenderer.a(pixelFrame, GLConstants.GLScaleType.CENTER_CROP, a2);
            PixelFrame a3 = a2.a(this.mEGLCore.d());
            a3.setTimestamp(pixelFrame.getTimestamp());
            a3.setGLContext(com.tencent.liteav.videoproducer.capture.au.a().b());
            GLES20.glFinish();
            a2.release();
            pixelFrame.release();
            return a3;
        } catch (com.tencent.liteav.videobase.b.g e) {
            pixelFrame.release();
            return null;
        }
    }

    private void seekToInFileTime(long j, boolean z) {
        if (this.mDemuxer == null) {
            return;
        }
        long a2 = com.tencent.liteav.base.util.h.a(j, this.mClip.startInFileTime, this.mClip.endInFileTime);
        if (this.mSeekingTimeMs == a2 && this.mIsInPreciseSeeking == z) {
            return;
        }
        LiteavLog.i(TAG, "seekToInFileTime file time = ".concat(String.valueOf(a2)));
        this.mSeekingTimeMs = a2;
        this.mIsInPreciseSeeking = z;
        this.mDemuxer.seek(a2);
        this.mIsAbandoningDecodingFrame = true;
        this.mHasReadEOF = false;
        VideoDecodeController videoDecodeController = this.mVideoDecodeController;
        LiteavLog.i(videoDecodeController.f36734a, "decoder abandonDecodingFrames");
        videoDecodeController.a(com.tencent.liteav.videoconsumer.decoder.ad.a(videoDecodeController));
        PixelFrame.releasePixelFrames(this.mPixFrameCacheForReverse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReverseInternal(boolean z) {
        if (this.mVideoDecodeController == null || this.mIsReverse == z) {
            return;
        }
        this.mIsReverse = z;
        if (z) {
            this.mReversePlayCurrentPts = this.mClip.endInFileTime;
            seekToInFileTime(this.mClip.endInFileTime - 500, false);
        } else {
            seekToInFileTime(this.mClip.startInFileTime, true);
        }
        clearPixelFrameQueue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInternal() {
        if (this.mVideoDecodeController == null) {
            LiteavLog.e(TAG, "mVideoDecodeController is null and is not initialize");
        } else if (!createDemuxerAndOpenFile()) {
            LiteavLog.e(TAG, this.mClip.path + " open fail or there is not video stream");
            this.mPixFrameQueue.queue(END_OF_STREAM);
        } else {
            LiteavLog.i(TAG, this.mClip.path + " open success");
            this.mPixFrameQueue.setUGCFrameQueueListener(this);
            this.mPixFrameQueue.clear();
            if (this.mIsReverse) {
                long j = this.mClip.endInFileTime;
                this.mReversePlayCurrentPts = j;
                this.mDemuxer.seek(j - 500);
            } else if (this.mClip.startInFileTime != 0) {
                this.mDemuxer.seek(this.mClip.startInFileTime);
            }
            this.mVideoDecodeController.a((VideoDecodeController.a) this);
            decodeInternal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopInternal() {
        this.mPixFrameQueue.setUGCFrameQueueListener(null);
        VideoDemuxer videoDemuxer = this.mDemuxer;
        if (videoDemuxer != null) {
            videoDemuxer.close();
            this.mDemuxer = null;
        }
        VideoDecodeController videoDecodeController = this.mVideoDecodeController;
        if (videoDecodeController != null) {
            videoDecodeController.g();
        }
        clearPixelFrameQueue();
        PixelFrame.releasePixelFrames(this.mPixFrameCacheForReverse);
        this.mPixFrameQueue.queue(END_OF_STREAM);
        this.mIsAbandoningDecodingFrame = false;
        this.mIsInPreciseSeeking = true;
        this.mIsReverse = false;
        this.mIsFrameSendingDecoder = false;
        this.mSeekingTimeMs = -1L;
        this.mReversePlayCurrentPts = this.mClip.startInFileTime;
    }

    private long timelineToFileTime(long j) {
        long j2;
        float timeMultipleInSpeed;
        if (this.mClip.speedList == null) {
            return j + this.mClip.startInFileTime;
        }
        Iterator<TXVideoEditConstants.TXSpeed> it = this.mClip.speedList.iterator();
        long j3 = j;
        long j4 = 0;
        while (true) {
            j2 = j4;
            if (!it.hasNext()) {
                break;
            }
            TXVideoEditConstants.TXSpeed next = it.next();
            long timeMultipleInSpeed2 = ((float) (next.endTime - next.startTime)) * (1.0f / getTimeMultipleInSpeed(next.speedLevel));
            j4 = next.startTime + (((float) j3) / timeMultipleInSpeed);
            j2 = j4;
            if (j3 < timeMultipleInSpeed2) {
                break;
            }
            j3 -= timeMultipleInSpeed2;
        }
        return j2;
    }

    private void unInitializeGLComponents() {
        com.tencent.liteav.videobase.frame.e eVar = this.mGLTexturePool;
        if (eVar != null) {
            eVar.a();
            this.mGLTexturePool.b();
            this.mGLTexturePool = null;
        }
        com.tencent.liteav.videobase.frame.j jVar = this.mPixelFrameRenderer;
        if (jVar != null) {
            jVar.a();
            this.mPixelFrameRenderer = null;
        }
        com.tencent.liteav.videobase.b.e.a(this.mEGLCore);
        this.mEGLCore = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uninitializeInternal() {
        unInitializeGLComponents();
        VideoDecodeController videoDecodeController = this.mVideoDecodeController;
        if (videoDecodeController != null) {
            videoDecodeController.g();
            this.mVideoDecodeController.i();
            this.mVideoDecodeController = null;
        }
        clearPixelFrameQueue();
        PixelFrame.releasePixelFrames(this.mPixFrameCacheForReverse);
    }

    @Override // com.tencent.ugc.UGCPixelFrameProvider
    public UGCFrameQueue<List<PixelFrame>> getFrameQueue() {
        return this.mPixFrameQueue;
    }

    @Override // com.tencent.ugc.UGCPixelFrameProvider
    public void initialize() {
        LiteavLog.i(TAG, ContentResolver.SYNC_EXTRAS_INITIALIZE);
        this.mWorkHandler.a(et.a(this), 0);
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.az
    public void onAbandonDecodingFramesCompleted() {
        LiteavLog.i(TAG, "onAbandonDecodingFramesCompleted");
        this.mWorkHandler.a(eu.a(this), 0);
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.az
    public void onDecodeCompleted() {
        this.mWorkHandler.a(ev.a(this), 0);
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.az
    public void onDecodeFailed() {
        LiteavLog.i(TAG, "on decode fail");
        this.mWorkHandler.a(ey.a(this), 0);
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.az
    public void onDecodeFrame(PixelFrame pixelFrame, long j) {
        if (pixelFrame == null) {
            return;
        }
        pixelFrame.retain();
        this.mWorkHandler.a(fe.a(this, pixelFrame), 0);
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.az
    public void onDecodeLatencyChanged(boolean z) {
    }

    public void onDecodeSEI(ByteBuffer byteBuffer) {
    }

    @Override // com.tencent.ugc.UGCFrameQueue.UGCFrameQueueListener
    public void onFrameDequeued() {
        this.mWorkHandler.a(fg.a(this), 0);
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.az
    public void onFrameEnqueuedToDecoder() {
        this.mWorkHandler.a(ff.a(this), 0);
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.az
    public void onRequestKeyFrame() {
    }

    @Override // com.tencent.ugc.UGCPixelFrameProvider
    public void seekTo(long j, boolean z) {
        LiteavLog.i(TAG, "seekTo lineTime = " + j + " isPreciseSeek = " + z);
        this.mWorkHandler.a(fc.a(this, j, z), 1000L);
    }

    @Override // com.tencent.ugc.UGCPixelFrameProvider
    public void setReverse(boolean z) {
        LiteavLog.i(TAG, "isReverse = ".concat(String.valueOf(z)));
        this.mWorkHandler.a(fd.a(this, z), 0);
    }

    @Override // com.tencent.ugc.UGCPixelFrameProvider
    public void start() {
        this.mWorkHandler.a(fa.a(this), 0);
    }

    @Override // com.tencent.ugc.UGCPixelFrameProvider
    public void stop() {
        this.mWorkHandler.a(fb.a(this), 0);
    }

    @Override // com.tencent.ugc.UGCPixelFrameProvider
    public void uninitialize() {
        LiteavLog.i(TAG, "unInitialize");
        this.mWorkHandler.a(ez.a(this), 0);
    }
}
