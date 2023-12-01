package com.tencent.ugc;

import android.content.ContentResolver;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.AudioFrame;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.UGCFrameQueue;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@JNINamespace("liteav::ugc")
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCSingleFileAudioFrameProvider.class */
public class UGCSingleFileAudioFrameProvider implements UGCAudioFrameProvider, UGCFrameQueue.UGCFrameQueueListener {
    private static final int DEFAULT_CHANNEL_COUNT = 2;
    private static final int DEFAULT_SAMPLE_RATE = 48000;
    private static final int MAX_FRAME_SIZE = 5;
    private static final int MUTE_AUDIO_FRAME_DURATION = 20;
    public static final String MUTE_VIRTUAL_FILE_PATH = "mute_virtual_file_path";
    private static final String TAG = "UGCAudioFileProvider";
    private final Clip mClip;
    private long mNativeHandle;
    private final com.tencent.liteav.base.util.b mWorkHandler;
    private long mCurrentTimestamp = 0;
    private final UGCFrameQueue<List<AudioFrame>> mAudioFrameQueue = new UGCFrameQueue<>();

    public UGCSingleFileAudioFrameProvider(Clip clip, com.tencent.liteav.base.util.b bVar) {
        this.mClip = new Clip(clip);
        this.mWorkHandler = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DecodeOrAppendMuteFrame() {
        if (this.mAudioFrameQueue.size() >= 5) {
            return;
        }
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeDecode(j);
        } else {
            appendMuteFrame();
        }
        this.mWorkHandler.removeCallbacks(er.a(this));
        this.mWorkHandler.post(es.a(this));
    }

    private void appendMuteFrame() {
        if (this.mCurrentTimestamp >= this.mClip.startInClipsTimeline + (this.mClip.endInFileTime - this.mClip.startInFileTime)) {
            this.mAudioFrameQueue.queue(UGCAudioFrameProvider.END_OF_STREAM);
            return;
        }
        AudioFrame audioFrame = new AudioFrame();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(3840);
        Arrays.fill(allocateDirect.array(), (byte) 0);
        audioFrame.setData(allocateDirect);
        audioFrame.setChannelCount(2);
        audioFrame.setSampleRate(48000);
        audioFrame.setCodecFormat(AudioFrame.AudioCodecFormat.PCM);
        long j = this.mCurrentTimestamp + 20;
        this.mCurrentTimestamp = j;
        audioFrame.setTimestamp(j);
        this.mAudioFrameQueue.queue(Collections.singletonList(audioFrame));
    }

    private long fileTimeToTimelineNoSpeed(long j) {
        return this.mClip.startTimelineNoSpeed + (j - this.mClip.startInFileTime);
    }

    private ByteBuffer getByteBufferFromAudioFrame(AudioFrame audioFrame) {
        return audioFrame.getData();
    }

    private float getTimeMultipleInSpeed(int i) {
        return UGCMediaListSource.getSpeed(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$initialize$0(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider) {
        if (uGCSingleFileAudioFrameProvider.mClip.path.equals(MUTE_VIRTUAL_FILE_PATH)) {
            uGCSingleFileAudioFrameProvider.mNativeHandle = 0L;
            return;
        }
        long nativeCreate = nativeCreate(uGCSingleFileAudioFrameProvider);
        uGCSingleFileAudioFrameProvider.mNativeHandle = nativeCreate;
        if (nativeCreate == 0) {
            LiteavLog.e(TAG, "create native instance failed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$seekTo$2(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider, long j) {
        uGCSingleFileAudioFrameProvider.mCurrentTimestamp = j;
        uGCSingleFileAudioFrameProvider.seekToInFileTime(uGCSingleFileAudioFrameProvider.timelineToFileTime(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$uninitialize$1(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider) {
        long j = uGCSingleFileAudioFrameProvider.mNativeHandle;
        if (j != 0) {
            nativeClose(j);
            nativeDestroy(uGCSingleFileAudioFrameProvider.mNativeHandle);
            uGCSingleFileAudioFrameProvider.mNativeHandle = 0L;
        }
        uGCSingleFileAudioFrameProvider.mAudioFrameQueue.clear();
    }

    private static native void nativeClose(long j);

    private static native long nativeCreate(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider);

    private static native void nativeDecode(long j);

    private static native void nativeDestroy(long j);

    private static native long nativeGetDuration(long j);

    private static native int nativeOpen(long j, String str);

    private static native int nativeSeekTo(long j, long j2);

    private AudioFrame obtainAudioFrame(int i, int i2, long j, int i3) {
        AudioFrame audioFrame = new AudioFrame();
        audioFrame.setSampleRate(i);
        audioFrame.setChannelCount(i2);
        audioFrame.setTimestamp(j);
        audioFrame.setData(ByteBuffer.allocateDirect(i3));
        return audioFrame;
    }

    private void onDecodeEndOfFile() {
        LiteavLog.i(TAG, "onDecodeEndOfFile");
        this.mAudioFrameQueue.queue(END_OF_STREAM);
    }

    private void onDecodeError(String str) {
        LiteavLog.i(TAG, "onDecodeError reason = ".concat(String.valueOf(str)));
        this.mAudioFrameQueue.queue(END_OF_STREAM);
    }

    private void onDecodeFrame(AudioFrame audioFrame) {
        if (audioFrame.getTimestamp() < this.mClip.startInFileTime) {
            return;
        }
        if (audioFrame.getTimestamp() > this.mClip.endInFileTime) {
            LiteavLog.i(TAG, "decode frame pts is bigger than end time");
            this.mAudioFrameQueue.queue(END_OF_STREAM);
            return;
        }
        audioFrame.setTimestamp(fileTimeToTimelineNoSpeed(audioFrame.getTimestamp()));
        this.mAudioFrameQueue.queue(Collections.singletonList(audioFrame));
    }

    private void seekToInFileTime(long j) {
        long a2 = com.tencent.liteav.base.util.h.a(j, this.mClip.startInFileTime, this.mClip.endInFileTime);
        LiteavLog.i(TAG, "seekTo fileTime ".concat(String.valueOf(a2)));
        long j2 = this.mNativeHandle;
        if (j2 != 0 && nativeSeekTo(j2, a2) != 0) {
            LiteavLog.w(TAG, "nativeSeekTo fail");
        }
        this.mAudioFrameQueue.clear();
        this.mWorkHandler.a(eq.a(this), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInternal() {
        long j = this.mNativeHandle;
        if (j != 0 && nativeOpen(j, this.mClip.path) != 0) {
            LiteavLog.e(TAG, "native AudioFileReaderFFmpeg open failed.");
            nativeClose(this.mNativeHandle);
            nativeDestroy(this.mNativeHandle);
            this.mNativeHandle = 0L;
        }
        this.mCurrentTimestamp = this.mClip.startInClipsTimeline;
        this.mAudioFrameQueue.setUGCFrameQueueListener(this);
        this.mAudioFrameQueue.clear();
        if (this.mClip.startInFileTime != 0) {
            seekToInFileTime(this.mClip.startInFileTime);
        }
        DecodeOrAppendMuteFrame();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopInternal() {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeClose(j);
        }
        this.mAudioFrameQueue.setUGCFrameQueueListener(null);
        this.mWorkHandler.removeCallbacks(eo.a(this));
        this.mAudioFrameQueue.clear();
        this.mAudioFrameQueue.queue(END_OF_STREAM);
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

    @Override // com.tencent.ugc.UGCAudioFrameProvider
    public UGCFrameQueue<List<AudioFrame>> getFrameQueue() {
        return this.mAudioFrameQueue;
    }

    @Override // com.tencent.ugc.UGCAudioFrameProvider
    public void initialize() {
        LiteavLog.i(TAG, ContentResolver.SYNC_EXTRAS_INITIALIZE);
        this.mWorkHandler.a(ej.a(this), 0);
    }

    @Override // com.tencent.ugc.UGCFrameQueue.UGCFrameQueueListener
    public void onFrameDequeued() {
        this.mWorkHandler.a(ek.a(this), 0);
    }

    @Override // com.tencent.ugc.UGCAudioFrameProvider
    public void seekTo(long j) {
        this.mWorkHandler.a(ep.a(this, j), 1000L);
    }

    @Override // com.tencent.ugc.UGCAudioFrameProvider
    public void start() {
        this.mWorkHandler.a(em.a(this), 0);
    }

    @Override // com.tencent.ugc.UGCAudioFrameProvider
    public void stop() {
        this.mWorkHandler.a(en.a(this), 0);
    }

    @Override // com.tencent.ugc.UGCAudioFrameProvider
    public void uninitialize() {
        this.mWorkHandler.a(el.a(this), 0);
    }
}
