package com.tencent.ugc;

import android.os.HandlerThread;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.ugc.UGCFrameQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

@JNINamespace("liteav::ugc")
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/VideoDemuxerFFmpeg.class */
public class VideoDemuxerFFmpeg implements UGCFrameQueue.UGCFrameQueueListener, VideoDemuxer {
    private static final int MAX_FRAME_SIZE = 20;
    private static final String TAG = "VideoDemuxerFFmpeg";
    private final UGCFrameQueue<EncodedVideoFrame> mFrameQueue = new UGCFrameQueue<>();
    private long mNativeHandler;
    private com.tencent.liteav.base.util.b mWorkHandler;

    private void clearFrameQueue() {
        for (EncodedVideoFrame encodedVideoFrame : this.mFrameQueue.dequeueAll()) {
            if (encodedVideoFrame != null) {
                encodedVideoFrame.release();
            }
        }
    }

    private void destroyNativeHandler() {
        long j = this.mNativeHandler;
        if (j != 0) {
            nativeClose(j);
            nativeDestroy(this.mNativeHandler);
            this.mNativeHandler = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getNextEncodeVideoFrameInternal() {
        if (this.mNativeHandler == 0) {
            this.mFrameQueue.queue(END_OF_STREAM);
        } else if (this.mFrameQueue.size() > 20) {
        } else {
            EncodedVideoFrame nativeGetNextEncodeVideoFrame = nativeGetNextEncodeVideoFrame(this.mNativeHandler);
            if (nativeGetNextEncodeVideoFrame != null) {
                this.mFrameQueue.queue(nativeGetNextEncodeVideoFrame);
            } else {
                this.mFrameQueue.queue(END_OF_STREAM);
            }
            com.tencent.liteav.base.util.b bVar = this.mWorkHandler;
            if (bVar != null) {
                bVar.removeCallbacks(go.a(this));
                this.mWorkHandler.post(gp.a(this));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$close$1(VideoDemuxerFFmpeg videoDemuxerFFmpeg) {
        videoDemuxerFFmpeg.clearFrameQueue();
        videoDemuxerFFmpeg.mFrameQueue.queue(END_OF_STREAM);
        videoDemuxerFFmpeg.mFrameQueue.setUGCFrameQueueListener(null);
        videoDemuxerFFmpeg.destroyNativeHandler();
        com.tencent.liteav.base.util.b bVar = videoDemuxerFFmpeg.mWorkHandler;
        if (bVar != null) {
            bVar.a();
            videoDemuxerFFmpeg.mWorkHandler = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$open$0(VideoDemuxerFFmpeg videoDemuxerFFmpeg, String str) {
        long nativeCreate = nativeCreate(videoDemuxerFFmpeg);
        videoDemuxerFFmpeg.mNativeHandler = nativeCreate;
        if (nativeCreate == 0) {
            LiteavLog.e(TAG, "create native instance failed.");
            videoDemuxerFFmpeg.mFrameQueue.queue(END_OF_STREAM);
        } else if (nativeOpen(nativeCreate, str) != 0) {
            LiteavLog.e(TAG, "native FFmpegDemuxerWrapper open failed.");
            videoDemuxerFFmpeg.destroyNativeHandler();
            videoDemuxerFFmpeg.mFrameQueue.queue(END_OF_STREAM);
        } else {
            videoDemuxerFFmpeg.mFrameQueue.setUGCFrameQueueListener(videoDemuxerFFmpeg);
            videoDemuxerFFmpeg.mFrameQueue.clear();
            videoDemuxerFFmpeg.runOnWorkThread(gr.a(videoDemuxerFFmpeg));
            LiteavLog.i(TAG, "demuxer open success.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Boolean lambda$seek$2(VideoDemuxerFFmpeg videoDemuxerFFmpeg, long j) throws Exception {
        if (videoDemuxerFFmpeg.mNativeHandler == 0) {
            return Boolean.FALSE;
        }
        videoDemuxerFFmpeg.clearFrameQueue();
        boolean nativeSeek = nativeSeek(videoDemuxerFFmpeg.mNativeHandler, j);
        videoDemuxerFFmpeg.getNextEncodeVideoFrameInternal();
        return Boolean.valueOf(nativeSeek);
    }

    private static native void nativeClose(long j);

    private static native long nativeCreate(VideoDemuxerFFmpeg videoDemuxerFFmpeg);

    private static native void nativeDestroy(long j);

    private static native EncodedVideoFrame nativeGetNextEncodeVideoFrame(long j);

    private static native int nativeOpen(long j, String str);

    private static native boolean nativeSeek(long j, long j2);

    private void runOnWorkThread(Runnable runnable) {
        com.tencent.liteav.base.util.b bVar = this.mWorkHandler;
        if (bVar != null) {
            bVar.a(runnable, 0);
        }
    }

    @Override // com.tencent.ugc.VideoDemuxer
    public void close() {
        runOnWorkThread(gm.a(this));
    }

    @Override // com.tencent.ugc.VideoDemuxer
    public EncodedVideoFrame getNextEncodeVideoFrame() {
        return this.mFrameQueue.dequeue();
    }

    @Override // com.tencent.ugc.UGCFrameQueue.UGCFrameQueueListener
    public void onFrameDequeued() {
        runOnWorkThread(gq.a(this));
    }

    @Override // com.tencent.ugc.VideoDemuxer
    public boolean open(String str) {
        synchronized (this) {
            if (this.mWorkHandler != null) {
                LiteavLog.w(TAG, "demuxer is already open!");
                return false;
            }
            HandlerThread handlerThread = new HandlerThread("ugc-media-list-source");
            handlerThread.start();
            this.mWorkHandler = new com.tencent.liteav.base.util.b(handlerThread.getLooper());
            runOnWorkThread(gl.a(this, str));
            return true;
        }
    }

    @Override // com.tencent.ugc.VideoDemuxer
    public boolean seek(long j) {
        FutureTask futureTask = new FutureTask(gn.a(this, j));
        runOnWorkThread(futureTask);
        try {
            return ((Boolean) futureTask.get(500L, TimeUnit.MILLISECONDS)).booleanValue();
        } catch (Exception e) {
            LiteavLog.w(TAG, "seek future task exception: ".concat(String.valueOf(e)));
            return false;
        }
    }
}
