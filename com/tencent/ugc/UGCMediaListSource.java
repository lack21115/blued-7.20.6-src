package com.tencent.ugc;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.frame.e;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.retriver.FFmpegMediaRetriever;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCMediaListSource.class */
public class UGCMediaListSource {
    private static final int MAX_FRAME_SIZE = 5;
    private static final int READ_FRAME_TIME_OUT_MS = 5;
    public static final int SEEK_TIME_OUT = 1000;
    private com.tencent.liteav.base.util.b mAudioHandler;
    private List<Bitmap> mBitmapList;
    private FutureTask<Long> mCalculateDurationTask;
    private UGCAudioFrameProvider mCurrentAudioFrameProvider;
    private UGCPixelFrameProvider mCurrentPixelFrameProvider;
    private FutureTask<Boolean> mHasAudioDataTask;
    private UGCPixelFrameProvider mNextPixelFrameProvider;
    private List<TXVideoEditConstants.TXRepeat> mRepeatList;
    private List<String> mSources;
    private List<TXVideoEditConstants.TXSpeed> mSpeedList;
    private com.tencent.liteav.base.util.b mVideoHandler;
    private com.tencent.liteav.base.util.b mWorkHandler;
    private int mCurrentVideoClipIndex = 0;
    private int mCurrentAudioClipIndex = 0;
    private int mNextVideoClipIndex = 0;
    private long mVideoSeekTimeInClip = -1;
    private long mAudioSeekTimeInClip = -1;
    private long mLastVideoFrameTimestamp = -1;
    private long mLastAudioFrameTimestamp = -1;
    private boolean mIsMediaSourceOverlapped = false;
    private int mFps = 20;
    private int mTransitionType = 1;
    private long mSourceRangeStart = 0;
    private long mSourceRangeEnd = 2147483647L;
    private long mTotalDuration = 0;
    private long mTailWaterMarkDurationMs = 0;
    private boolean mIsPreciseSeek = true;
    private boolean mIsReverse = false;
    private final List<Clip> mClipList = new ArrayList();
    private final List<a> mMediaInfoList = new ArrayList();
    private final UGCFrameQueue<List<PixelFrame>> mPixelFrameListQueue = new UGCFrameQueue<>();
    private final UGCFrameQueue<List<AudioFrame>> mAudioFrameListQueue = new UGCFrameQueue<>();
    private final List<PixelFrame> mTailPixelFrameList = new ArrayList();
    private final String mTAG = "UGCMediaListSource_" + hashCode();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCMediaListSource$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public long f40203a;
        public long b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f40204c;
        public float d;
        public String e;
        public String f;

        private a() {
            this.f40203a = 0L;
            this.b = 0L;
            this.f40204c = false;
            this.d = 25.0f;
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    private void addClipToList(long j, long j2, a aVar) {
        if (j >= j2) {
            return;
        }
        Clip clip = new Clip();
        clip.startInFileTime = j;
        clip.endInFileTime = j2;
        clip.path = aVar.e;
        clip.fps = aVar.d;
        clip.videoMimeType = aVar.f;
        this.mClipList.add(clip);
    }

    private void addVideoTailFrameListToQueue() {
        PixelFrame pixelFrame;
        if (this.mTailWaterMarkDurationMs <= 0 || this.mTailPixelFrameList.isEmpty()) {
            return;
        }
        List<Clip> list = this.mClipList;
        long j = 40;
        if (list != null) {
            j = 40;
            if (!list.isEmpty()) {
                Clip clip = this.mClipList.get(0);
                j = 40;
                if (clip.fps > 0.0f) {
                    j = 1000.0f / clip.fps;
                }
            }
        }
        int i = (int) (this.mTailWaterMarkDurationMs / j);
        for (int i2 = 0; i2 < i; i2++) {
            LinkedList linkedList = new LinkedList();
            for (PixelFrame pixelFrame2 : this.mTailPixelFrameList) {
                if (pixelFrame2 instanceof e.b) {
                    e.b bVar = (e.b) pixelFrame2;
                    pixelFrame = bVar.f36634a.a(bVar.getGLContext());
                } else {
                    LiteavLog.w(this.mTAG, "addVideoTailFrameListToQueue: pixelFrame is not TextureFrame");
                    pixelFrame = new PixelFrame(pixelFrame2);
                }
                PixelFrame pixelFrame3 = pixelFrame;
                pixelFrame3.setTimestamp((i2 * j) + pixelFrame2.getTimestamp());
                linkedList.add(pixelFrame3);
            }
            this.mPixelFrameListQueue.queue(linkedList);
        }
    }

    private void adjustAudioFrameTimestamp(List<AudioFrame> list) {
        if (com.tencent.liteav.videobase.utils.c.a(list)) {
            return;
        }
        AudioFrame audioFrame = list.get(0);
        long calculateAudioFrameDuration = calculateAudioFrameDuration(audioFrame);
        if (this.mLastAudioFrameTimestamp == -1 || audioFrame.getTimestamp() >= this.mLastAudioFrameTimestamp + calculateAudioFrameDuration) {
            this.mLastAudioFrameTimestamp = audioFrame.getTimestamp();
            return;
        }
        long j = calculateAudioFrameDuration;
        if (calculateAudioFrameDuration <= 0) {
            j = 1;
        }
        long j2 = this.mLastAudioFrameTimestamp + j;
        this.mLastAudioFrameTimestamp = j2;
        audioFrame.setTimestamp(j2);
    }

    private void adjustPixelFrameTimestamp(List<PixelFrame> list) {
        if (com.tencent.liteav.videobase.utils.c.a(list)) {
            return;
        }
        PixelFrame pixelFrame = list.get(0);
        if (this.mLastVideoFrameTimestamp != -1) {
            long timestamp = pixelFrame.getTimestamp();
            long j = this.mLastVideoFrameTimestamp;
            if (timestamp <= j) {
                long j2 = j + 1;
                this.mLastVideoFrameTimestamp = j2;
                pixelFrame.setTimestamp(j2);
                return;
            }
        }
        this.mLastVideoFrameTimestamp = pixelFrame.getTimestamp();
    }

    private long calculateAudioFrameDuration(AudioFrame audioFrame) {
        long j = 0;
        if (audioFrame != null) {
            if (audioFrame.getData() == null) {
                return 0L;
            }
            long sampleRate = audioFrame.getSampleRate() * 2 * audioFrame.getChannelCount();
            if (sampleRate == 0) {
                return 0L;
            }
            j = (audioFrame.getData().limit() * 1000) / sampleRate;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long calculateTotalDurationOfClips() {
        long j;
        if (isImageSource()) {
            return getImageDuration();
        }
        long j2 = 0;
        if (this.mIsMediaSourceOverlapped) {
            Iterator<Clip> it = this.mClipList.iterator();
            while (true) {
                j = j2;
                if (!it.hasNext()) {
                    break;
                }
                Clip next = it.next();
                if (j2 < getClipDuration(next)) {
                    j2 = getClipDuration(next);
                }
            }
        } else {
            for (Clip clip : this.mClipList) {
                j2 += getClipDuration(clip);
            }
            long j3 = this.mSourceRangeEnd - this.mSourceRangeStart;
            j = j2;
            if (j3 < j2) {
                j = j3;
            }
        }
        return j;
    }

    private void clearFrameQueue() {
        for (List<PixelFrame> list : this.mPixelFrameListQueue.dequeueAll()) {
            PixelFrame.releasePixelFrames(list);
        }
        this.mAudioFrameListQueue.clear();
        this.mLastVideoFrameTimestamp = -1L;
        this.mLastAudioFrameTimestamp = -1L;
    }

    private void closeCurrentAudioFrameProvider() {
        UGCAudioFrameProvider uGCAudioFrameProvider = this.mCurrentAudioFrameProvider;
        if (uGCAudioFrameProvider == null) {
            return;
        }
        uGCAudioFrameProvider.stop();
        this.mCurrentAudioFrameProvider.uninitialize();
        this.mCurrentAudioFrameProvider = null;
    }

    private void closeCurrentPixelFrameProvider() {
        UGCPixelFrameProvider uGCPixelFrameProvider = this.mCurrentPixelFrameProvider;
        if (uGCPixelFrameProvider == null) {
            return;
        }
        uGCPixelFrameProvider.stop();
        this.mCurrentPixelFrameProvider.uninitialize();
        this.mCurrentPixelFrameProvider = null;
    }

    private void closeNextPixelFrameProvider() {
        UGCPixelFrameProvider uGCPixelFrameProvider = this.mNextPixelFrameProvider;
        if (uGCPixelFrameProvider == null) {
            return;
        }
        uGCPixelFrameProvider.stop();
        this.mNextPixelFrameProvider.uninitialize();
        this.mNextPixelFrameProvider = null;
    }

    private UGCPixelFrameProvider createImageProvider() {
        UGCImageProvider uGCImageProvider = new UGCImageProvider(this.mBitmapList, this.mFps);
        uGCImageProvider.initialize();
        uGCImageProvider.start();
        uGCImageProvider.setPictureTransition(this.mTransitionType);
        return uGCImageProvider;
    }

    private UGCAudioFrameProvider createMuteAudioProvider() {
        Clip clip = new Clip();
        clip.path = UGCSingleFileAudioFrameProvider.MUTE_VIRTUAL_FILE_PATH;
        clip.startInClipsTimeline = 0L;
        clip.startTimelineNoSpeed = 0L;
        clip.startInFileTime = 0L;
        clip.endInFileTime = getImageDuration();
        UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider = new UGCSingleFileAudioFrameProvider(clip, this.mAudioHandler);
        uGCSingleFileAudioFrameProvider.initialize();
        uGCSingleFileAudioFrameProvider.start();
        return uGCSingleFileAudioFrameProvider;
    }

    private TXVideoEditConstants.TXSpeed createTXSpeed(long j, long j2, int i) {
        TXVideoEditConstants.TXSpeed tXSpeed = new TXVideoEditConstants.TXSpeed();
        tXSpeed.startTime = j;
        tXSpeed.endTime = j2;
        tXSpeed.speedLevel = i;
        return tXSpeed;
    }

    private UGCPixelFrameProvider createVideoFileProvider(int i, boolean z) {
        if (this.mVideoHandler == null) {
            HandlerThread handlerThread = new HandlerThread("Video-File-Provider");
            handlerThread.start();
            this.mVideoHandler = new com.tencent.liteav.base.util.b(handlerThread.getLooper());
        }
        UGCPixelFrameProvider uGCMultiFilePixelFrameProvider = z ? new UGCMultiFilePixelFrameProvider(this.mClipList, this.mVideoHandler) : new UGCSingleFilePixelFrameProvider(this.mClipList.get(i), this.mVideoHandler);
        uGCMultiFilePixelFrameProvider.initialize();
        uGCMultiFilePixelFrameProvider.setReverse(this.mIsReverse);
        uGCMultiFilePixelFrameProvider.start();
        return uGCMultiFilePixelFrameProvider;
    }

    private void cutMultipleFileToClips() {
        for (a aVar : this.mMediaInfoList) {
            addClipToList(0L, aVar.b, aVar);
        }
    }

    private void cutSingleVideoFileToClips() {
        long j;
        long j2 = this.mSourceRangeStart;
        List<TXVideoEditConstants.TXRepeat> list = this.mRepeatList;
        if (list != null && !list.isEmpty()) {
            Collections.sort(this.mRepeatList, dr.a());
            Iterator<TXVideoEditConstants.TXRepeat> it = this.mRepeatList.iterator();
            while (true) {
                j = j2;
                if (!it.hasNext()) {
                    break;
                }
                TXVideoEditConstants.TXRepeat next = it.next();
                if (!isInvalidRepeat(next)) {
                    long j3 = next.endTime;
                    long j4 = this.mSourceRangeEnd;
                    if (j3 > j4) {
                        j3 = j4;
                    }
                    addClipToList(j2, j3, this.mMediaInfoList.get(0));
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= next.repeatTimes - 1) {
                            break;
                        }
                        addClipToList(next.startTime, j3, this.mMediaInfoList.get(0));
                        i = i2 + 1;
                    }
                    j2 = j3;
                }
            }
        } else {
            j = j2;
        }
        long j5 = this.mTotalDuration;
        long j6 = this.mSourceRangeEnd;
        long j7 = j5;
        if (j5 > j6) {
            j7 = j6;
        }
        if (j < j7) {
            addClipToList(j, j7, this.mMediaInfoList.get(0));
        }
    }

    private long estimateSourceOpenTime() {
        List<String> list = this.mSources;
        long j = 1000;
        if (list != null) {
            j = 1000;
            if (list.size() > 1) {
                j = 1000 * list.size();
            }
        }
        return j;
    }

    private long getClipDuration(Clip clip) {
        if (clip.speedList == null) {
            return clip.endInFileTime - clip.startInFileTime;
        }
        long j = 0;
        for (TXVideoEditConstants.TXSpeed tXSpeed : clip.speedList) {
            j = ((float) j) + (((float) (tXSpeed.endTime - tXSpeed.startTime)) / getSpeed(tXSpeed.speedLevel));
        }
        return j;
    }

    private long getImageDuration() {
        if (isImageSource() && updateCurrentPixelFrameProvider()) {
            UGCPixelFrameProvider uGCPixelFrameProvider = this.mCurrentPixelFrameProvider;
            if (uGCPixelFrameProvider instanceof UGCImageProvider) {
                return ((UGCImageProvider) uGCPixelFrameProvider).getDuration();
            }
            return 0L;
        }
        return 0L;
    }

    private static a getMediaInfo(String str) {
        boolean z = false;
        a aVar = new a((byte) 0);
        FFmpegMediaRetriever fFmpegMediaRetriever = new FFmpegMediaRetriever();
        if (fFmpegMediaRetriever.setDataSource(str) == 0) {
            long audioDurationMs = fFmpegMediaRetriever.getAudioDurationMs();
            aVar.b = Math.max(audioDurationMs, fFmpegMediaRetriever.getVideoDurationMs());
            if (audioDurationMs != 0) {
                z = true;
            }
            aVar.f40204c = z;
            aVar.d = fFmpegMediaRetriever.getFPS();
            aVar.f = fFmpegMediaRetriever.getVideoMimeType();
        }
        return aVar;
    }

    public static float getSpeed(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 3) {
                    return i != 4 ? 1.0f : 2.0f;
                }
                return 1.5f;
            }
            return 0.5f;
        }
        return 0.25f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasAudioDataInternal() {
        for (a aVar : this.mMediaInfoList) {
            if (aVar.f40204c) {
                return true;
            }
        }
        return false;
    }

    private boolean isImageSource() {
        List<Bitmap> list;
        return (this.mClipList.size() != 0 || (list = this.mBitmapList) == null || list.size() == 0) ? false : true;
    }

    private boolean isInvalidRepeat(TXVideoEditConstants.TXRepeat tXRepeat) {
        return tXRepeat.repeatTimes <= 0 || tXRepeat.startTime >= tXRepeat.endTime || tXRepeat.startTime > this.mSourceRangeEnd || tXRepeat.endTime < this.mSourceRangeStart;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int lambda$cutSingleVideoFileToClips$1(TXVideoEditConstants.TXRepeat tXRepeat, TXVideoEditConstants.TXRepeat tXRepeat2) {
        return (int) (tXRepeat.startTime - tXRepeat2.startTime);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setIsMediaSourceOverlapped$3(UGCMediaListSource uGCMediaListSource, boolean z) {
        uGCMediaListSource.mIsMediaSourceOverlapped = z;
        uGCMediaListSource.mSourceRangeStart = 0L;
        uGCMediaListSource.mSourceRangeEnd = 2147483647L;
        uGCMediaListSource.updateTimelineToClips();
        uGCMediaListSource.mCalculateDurationTask.run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setPictureList$5(UGCMediaListSource uGCMediaListSource, List list, int i) {
        uGCMediaListSource.resetReadPositionInternal();
        uGCMediaListSource.mClipList.clear();
        uGCMediaListSource.mBitmapList = list;
        uGCMediaListSource.mFps = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setPictureTransition$6(UGCMediaListSource uGCMediaListSource, int i) {
        uGCMediaListSource.resetReadPositionInternal();
        uGCMediaListSource.mTransitionType = i;
        uGCMediaListSource.updateCurrentPixelFrameProvider();
        FutureTask<Long> futureTask = new FutureTask<>(Cdo.a(uGCMediaListSource));
        uGCMediaListSource.mCalculateDurationTask = futureTask;
        futureTask.run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setRepeatPlay$10(UGCMediaListSource uGCMediaListSource, List list) {
        uGCMediaListSource.mRepeatList = list;
        uGCMediaListSource.updateClipsInfo();
        uGCMediaListSource.resetReadPositionInternal();
        uGCMediaListSource.mCalculateDurationTask.run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setReverse$11(UGCMediaListSource uGCMediaListSource, boolean z) {
        uGCMediaListSource.clearFrameQueue();
        PixelFrame.releasePixelFrames(uGCMediaListSource.mTailPixelFrameList);
        uGCMediaListSource.mLastAudioFrameTimestamp = -1L;
        uGCMediaListSource.mLastVideoFrameTimestamp = -1L;
        uGCMediaListSource.mIsReverse = z;
        uGCMediaListSource.closeCurrentPixelFrameProvider();
        if (z) {
            uGCMediaListSource.mCurrentVideoClipIndex = uGCMediaListSource.mClipList.size() - 1;
        } else {
            uGCMediaListSource.mCurrentVideoClipIndex = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setSpeedList$12(UGCMediaListSource uGCMediaListSource, List list) {
        uGCMediaListSource.mSpeedList = list;
        uGCMediaListSource.updateClipsInfo();
        uGCMediaListSource.resetReadPositionInternal();
        uGCMediaListSource.mCalculateDurationTask.run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setVideoSourceRange$4(UGCMediaListSource uGCMediaListSource, long j, long j2) {
        if (uGCMediaListSource.mIsMediaSourceOverlapped) {
            uGCMediaListSource.mCalculateDurationTask.run();
            return;
        }
        uGCMediaListSource.mSourceRangeStart = j;
        uGCMediaListSource.mSourceRangeEnd = j2;
        uGCMediaListSource.updateClipsInfo();
        uGCMediaListSource.resetReadPositionInternal();
        uGCMediaListSource.mCalculateDurationTask.run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setVideoSources$0(UGCMediaListSource uGCMediaListSource, List list) {
        uGCMediaListSource.setVideoSourcesInternal(list);
        uGCMediaListSource.mHasAudioDataTask.run();
        uGCMediaListSource.mCalculateDurationTask.run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int lambda$updateSpeedInfoToClips$2(TXVideoEditConstants.TXSpeed tXSpeed, TXVideoEditConstants.TXSpeed tXSpeed2) {
        return (int) (tXSpeed.startTime - tXSpeed2.startTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadNextAudioFrameInternal(long j) {
        if (this.mAudioFrameListQueue.size() > 5) {
            return;
        }
        if (!updateCurrentAudioFrameProvider()) {
            LiteavLog.i(this.mTAG, "getAudioFrameProvider fail.AudioFrameListQueue put null");
            this.mAudioFrameListQueue.queue(null);
            return;
        }
        long j2 = this.mAudioSeekTimeInClip;
        if (j2 != -1) {
            this.mCurrentAudioFrameProvider.seekTo(j2);
            this.mAudioSeekTimeInClip = -1L;
        }
        readAudioFrameListToQueue(j);
        com.tencent.liteav.base.util.b bVar = this.mWorkHandler;
        if (bVar != null) {
            bVar.post(dj.a(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadNextVideoFrameInternal(long j) {
        if (this.mPixelFrameListQueue.size() >= 5) {
            return;
        }
        if (!updateCurrentPixelFrameProvider()) {
            LiteavLog.i(this.mTAG, "getPixelFrameProvider fail.PixelFrameListQueue put null");
            addVideoTailFrameListToQueue();
            this.mPixelFrameListQueue.queue(null);
            return;
        }
        long j2 = this.mVideoSeekTimeInClip;
        if (j2 != -1) {
            this.mCurrentPixelFrameProvider.seekTo(j2, this.mIsPreciseSeek);
            this.mVideoSeekTimeInClip = -1L;
        }
        readVideoFrameListToQueue(j);
        com.tencent.liteav.base.util.b bVar = this.mWorkHandler;
        if (bVar != null) {
            bVar.post(dk.a(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prePareNextUGCPixelFrameProvider() {
        int i;
        closeNextPixelFrameProvider();
        if (this.mIsReverse) {
            this.mNextVideoClipIndex = this.mCurrentVideoClipIndex - 1;
        } else {
            this.mNextVideoClipIndex = this.mCurrentVideoClipIndex + 1;
        }
        if (this.mNextVideoClipIndex >= this.mClipList.size() || (i = this.mNextVideoClipIndex) < 0) {
            return;
        }
        this.mNextPixelFrameProvider = createVideoFileProvider(i, false);
    }

    private void readAudioFrameListToQueue(long j) {
        List<AudioFrame> dequeue = this.mCurrentAudioFrameProvider.getFrameQueue().dequeue(j);
        if (dequeue == null) {
            return;
        }
        if (dequeue != UGCAudioFrameProvider.END_OF_STREAM) {
            if (!this.mIsMediaSourceOverlapped) {
                adjustAudioFrameTimestamp(dequeue);
            }
            this.mAudioFrameListQueue.queue(dequeue);
            return;
        }
        LiteavLog.i(this.mTAG, "audio frame provider read END_OF_STREAM");
        closeCurrentAudioFrameProvider();
        if (this.mIsReverse) {
            this.mCurrentAudioClipIndex--;
        } else {
            this.mCurrentAudioClipIndex++;
        }
    }

    private void readVideoFrameListToQueue(long j) {
        List<PixelFrame> dequeue = this.mCurrentPixelFrameProvider.getFrameQueue().dequeue(j);
        if (dequeue == null) {
            return;
        }
        if (dequeue != UGCPixelFrameProvider.END_OF_STREAM) {
            if (!this.mIsMediaSourceOverlapped) {
                adjustPixelFrameTimestamp(dequeue);
            }
            this.mPixelFrameListQueue.queue(dequeue);
            saveTailVideoFrameToList(dequeue);
            return;
        }
        LiteavLog.i(this.mTAG, "video frame provider read END_OF_STREAM");
        closeCurrentPixelFrameProvider();
        if (this.mIsReverse) {
            this.mCurrentVideoClipIndex--;
        } else {
            this.mCurrentVideoClipIndex++;
        }
    }

    private void removeRunnable(Runnable runnable) {
        com.tencent.liteav.base.util.b bVar = this.mWorkHandler;
        if (bVar != null) {
            bVar.removeCallbacks(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetReadPositionInternal() {
        clearFrameQueue();
        PixelFrame.releasePixelFrames(this.mTailPixelFrameList);
        closeCurrentPixelFrameProvider();
        closeCurrentAudioFrameProvider();
        this.mCurrentVideoClipIndex = 0;
        this.mCurrentAudioClipIndex = 0;
        this.mVideoSeekTimeInClip = -1L;
        this.mAudioSeekTimeInClip = -1L;
        this.mLastAudioFrameTimestamp = -1L;
        this.mLastVideoFrameTimestamp = -1L;
    }

    private void runOnWorkThread(Runnable runnable) {
        runOnWorkThread(runnable, 0);
    }

    private void runOnWorkThread(Runnable runnable, int i) {
        com.tencent.liteav.base.util.b bVar = this.mWorkHandler;
        if (bVar != null) {
            bVar.a(runnable, i);
        }
    }

    private void saveTailVideoFrameToList(List<PixelFrame> list) {
        if (this.mTailWaterMarkDurationMs == 0) {
            return;
        }
        for (PixelFrame pixelFrame : this.mTailPixelFrameList) {
            pixelFrame.release();
        }
        this.mTailPixelFrameList.clear();
        for (PixelFrame pixelFrame2 : list) {
            pixelFrame2.retain();
            this.mTailPixelFrameList.add(pixelFrame2);
        }
    }

    private void seekTo(long j, boolean z) {
        com.tencent.liteav.base.util.b bVar;
        if (j >= 0 && (bVar = this.mWorkHandler) != null) {
            bVar.a(db.a(this, j, z), 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void seekToInternal(long j, boolean z) {
        int i;
        if (isImageSource()) {
            seekToInternalWithImageSource(j);
        } else if (this.mClipList.isEmpty()) {
        } else {
            this.mLastAudioFrameTimestamp = -1L;
            this.mLastVideoFrameTimestamp = -1L;
            if (this.mIsMediaSourceOverlapped) {
                this.mVideoSeekTimeInClip = j;
                this.mAudioSeekTimeInClip = j;
                clearFrameQueue();
                PixelFrame.releasePixelFrames(this.mTailPixelFrameList);
                return;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                i = -1;
                if (i3 >= this.mClipList.size()) {
                    break;
                }
                Clip clip = this.mClipList.get(i3);
                if (clip.startInClipsTimeline + (clip.endInFileTime - clip.startInFileTime) >= j) {
                    i = i3;
                    break;
                }
                i2 = i3 + 1;
            }
            if (i < 0) {
                return;
            }
            long j2 = j - this.mClipList.get(i).startInClipsTimeline;
            this.mVideoSeekTimeInClip = j2;
            this.mAudioSeekTimeInClip = j2;
            this.mIsPreciseSeek = z;
            if (this.mCurrentVideoClipIndex != i) {
                closeCurrentPixelFrameProvider();
            }
            if (this.mCurrentAudioClipIndex != i) {
                closeCurrentAudioFrameProvider();
            }
            this.mCurrentVideoClipIndex = i;
            this.mCurrentAudioClipIndex = i;
            clearFrameQueue();
            PixelFrame.releasePixelFrames(this.mTailPixelFrameList);
            loadNextVideoFrameInternal(0L);
            loadNextAudioFrameInternal(0L);
        }
    }

    private void seekToInternalWithImageSource(long j) {
        this.mCurrentVideoClipIndex = 0;
        this.mVideoSeekTimeInClip = j;
        clearFrameQueue();
        PixelFrame.releasePixelFrames(this.mTailPixelFrameList);
        loadNextVideoFrameInternal(0L);
    }

    private void setVideoSourcesInternal(List<String> list) {
        resetReadPositionInternal();
        this.mSources = list;
        this.mMediaInfoList.clear();
        this.mTotalDuration = 0L;
        for (String str : list) {
            a mediaInfo = getMediaInfo(str);
            String str2 = this.mTAG;
            LiteavLog.i(str2, str + "getMediaInfo duration = " + mediaInfo.b);
            mediaInfo.f40203a = this.mTotalDuration;
            mediaInfo.e = str;
            this.mTotalDuration = this.mTotalDuration + mediaInfo.b;
            this.mMediaInfoList.add(mediaInfo);
        }
        updateClipsInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uninitializeInternal() {
        closeCurrentPixelFrameProvider();
        closeNextPixelFrameProvider();
        closeCurrentAudioFrameProvider();
        com.tencent.liteav.base.util.b bVar = this.mVideoHandler;
        if (bVar != null) {
            bVar.a();
            this.mVideoHandler = null;
        }
        com.tencent.liteav.base.util.b bVar2 = this.mAudioHandler;
        if (bVar2 != null) {
            bVar2.a();
            this.mAudioHandler = null;
        }
        clearFrameQueue();
        PixelFrame.releasePixelFrames(this.mTailPixelFrameList);
        this.mClipList.clear();
        this.mMediaInfoList.clear();
        this.mSources = null;
        this.mRepeatList = null;
        this.mSpeedList = null;
        this.mSourceRangeStart = 0L;
        this.mSourceRangeEnd = 2147483647L;
        this.mCurrentVideoClipIndex = 0;
        this.mCurrentAudioClipIndex = 0;
        this.mVideoSeekTimeInClip = -1L;
        this.mAudioSeekTimeInClip = -1L;
        this.mLastAudioFrameTimestamp = -1L;
        this.mLastVideoFrameTimestamp = -1L;
        this.mIsReverse = false;
        this.mNextVideoClipIndex = 0;
        com.tencent.liteav.base.util.b bVar3 = this.mWorkHandler;
        if (bVar3 != null) {
            bVar3.a();
            this.mWorkHandler = null;
        }
    }

    private void updateClipsInfo() {
        LiteavLog.i(this.mTAG, "updateClipsInfo");
        List<String> list = this.mSources;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.mClipList.clear();
        if (this.mSources.size() > 1) {
            cutMultipleFileToClips();
        } else {
            cutSingleVideoFileToClips();
        }
        for (Clip clip : this.mClipList) {
            updateSpeedInfoToClips(clip);
        }
        updateTimelineToClips();
    }

    private boolean updateCurrentAudioFrameProvider() {
        int i;
        if (this.mCurrentAudioFrameProvider != null) {
            return true;
        }
        if (this.mAudioHandler == null) {
            HandlerThread handlerThread = new HandlerThread("Audio-File-Provider");
            handlerThread.start();
            this.mAudioHandler = new com.tencent.liteav.base.util.b(handlerThread.getLooper());
        }
        if (isImageSource() && this.mCurrentAudioClipIndex == 0) {
            this.mCurrentAudioFrameProvider = createMuteAudioProvider();
            return true;
        } else if (this.mCurrentAudioClipIndex >= this.mClipList.size() || (i = this.mCurrentAudioClipIndex) < 0) {
            return false;
        } else {
            if (this.mIsMediaSourceOverlapped) {
                this.mCurrentAudioFrameProvider = new UGCMultiFileAudioFrameProvider(this.mClipList, this.mAudioHandler);
                this.mCurrentAudioClipIndex = this.mClipList.size();
            } else {
                this.mCurrentAudioFrameProvider = new UGCSingleFileAudioFrameProvider(this.mClipList.get(i), this.mAudioHandler);
            }
            this.mCurrentAudioFrameProvider.initialize();
            this.mCurrentAudioFrameProvider.start();
            return true;
        }
    }

    private boolean updateCurrentPixelFrameProvider() {
        int i;
        if (this.mCurrentPixelFrameProvider != null) {
            return true;
        }
        if (isImageSource() && this.mCurrentVideoClipIndex == 0) {
            this.mCurrentPixelFrameProvider = createImageProvider();
            return true;
        } else if (this.mCurrentVideoClipIndex >= this.mClipList.size() || (i = this.mCurrentVideoClipIndex) < 0) {
            return false;
        } else {
            if (this.mIsMediaSourceOverlapped) {
                this.mCurrentPixelFrameProvider = createVideoFileProvider(0, true);
                this.mCurrentVideoClipIndex = this.mClipList.size();
                return true;
            }
            if (i == this.mNextVideoClipIndex) {
                this.mCurrentPixelFrameProvider = this.mNextPixelFrameProvider;
                this.mNextPixelFrameProvider = null;
            }
            if (this.mCurrentPixelFrameProvider == null) {
                this.mCurrentPixelFrameProvider = createVideoFileProvider(this.mCurrentVideoClipIndex, false);
            }
            removeRunnable(dl.a(this));
            runOnWorkThread(dm.a(this), 500);
            return true;
        }
    }

    private void updateSpeedInfoToClips(Clip clip) {
        List<TXVideoEditConstants.TXSpeed> list = this.mSpeedList;
        if (list == null || list.isEmpty()) {
            return;
        }
        Collections.sort(this.mSpeedList, ds.a());
        ArrayList arrayList = new ArrayList();
        long j = clip.startInFileTime;
        for (TXVideoEditConstants.TXSpeed tXSpeed : this.mSpeedList) {
            long j2 = tXSpeed.startTime - clip.startInSourceListTimeline;
            long j3 = tXSpeed.endTime - clip.startInSourceListTimeline;
            if (j3 >= clip.startInFileTime) {
                if (j2 > clip.endInFileTime || j >= clip.endInFileTime) {
                    break;
                }
                long j4 = j;
                if (j2 > j) {
                    arrayList.add(createTXSpeed(j, j2, 2));
                    j4 = j2;
                }
                TXVideoEditConstants.TXSpeed createTXSpeed = createTXSpeed(j4, j3, tXSpeed.speedLevel);
                if (createTXSpeed.endTime > clip.endInFileTime) {
                    createTXSpeed.endTime = clip.endInFileTime;
                }
                arrayList.add(createTXSpeed);
                j = createTXSpeed.endTime;
            }
        }
        if (j != clip.endInFileTime) {
            arrayList.add(createTXSpeed(j, clip.endInFileTime, 2));
        }
        clip.speedList = arrayList;
    }

    private void updateTimelineToClips() {
        long j = 0;
        long j2 = 0;
        for (Clip clip : this.mClipList) {
            clip.startInClipsTimeline = j;
            clip.startTimelineNoSpeed = j2;
            if (!this.mIsMediaSourceOverlapped) {
                j += getClipDuration(clip);
                j2 += clip.endInFileTime - clip.startInFileTime;
            }
        }
    }

    public long getDuration() {
        FutureTask<Long> futureTask = this.mCalculateDurationTask;
        if (futureTask == null) {
            return 0L;
        }
        Long l = 0L;
        try {
            l = futureTask.get(estimateSourceOpenTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            LiteavLog.w(this.mTAG, "getDuration future task exception: ".concat(String.valueOf(e)));
        }
        return l.longValue();
    }

    public boolean hasAudioData() {
        FutureTask<Boolean> futureTask = this.mHasAudioDataTask;
        if (futureTask == null) {
            return false;
        }
        Boolean bool = Boolean.FALSE;
        try {
            bool = futureTask.get(estimateSourceOpenTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            LiteavLog.w(this.mTAG, "hasAudioData future exception ".concat(String.valueOf(e)));
        }
        return bool.booleanValue();
    }

    public void impreciseSeekTo(long j) {
        LiteavLog.i(this.mTAG, "impreciseSeekTo lineTime = ".concat(String.valueOf(j)));
        seekTo(j, false);
    }

    public void initialize() {
        LiteavLog.i(this.mTAG, ContentResolver.SYNC_EXTRAS_INITIALIZE);
        synchronized (this) {
            if (this.mWorkHandler != null) {
                LiteavLog.w(this.mTAG, "UGCMediaStreamSpliter is initialized");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("ugc-media-list-source");
            handlerThread.start();
            this.mWorkHandler = new com.tencent.liteav.base.util.b(handlerThread.getLooper());
        }
    }

    public List<AudioFrame> readNextAudioFrame() {
        runOnWorkThread(cz.a(this));
        return this.mAudioFrameListQueue.dequeue();
    }

    public List<PixelFrame> readNextVideoFrame() {
        runOnWorkThread(da.a(this));
        return this.mPixelFrameListQueue.dequeue();
    }

    public void resetReadPosition() {
        LiteavLog.i(this.mTAG, "resetReadPosition");
        runOnWorkThread(dc.a(this));
    }

    public void seekTo(long j) {
        LiteavLog.i(this.mTAG, "seekTo lineTime = ".concat(String.valueOf(j)));
        seekTo(j, true);
    }

    public void setIsMediaSourceOverlapped(boolean z) {
        LiteavLog.i(this.mTAG, "setIsMediaSourceOverlapped isMediaSourceOverlapped = ".concat(String.valueOf(z)));
        this.mCalculateDurationTask = new FutureTask<>(dt.a(this));
        runOnWorkThread(du.a(this, z));
    }

    public void setPictureList(List<Bitmap> list, int i) {
        String str = this.mTAG;
        LiteavLog.i(str, "setPictureList bitmapList size = " + list.size() + " fps = " + i);
        runOnWorkThread(cx.a(this, list, i));
    }

    public void setPictureTransition(int i) {
        LiteavLog.i(this.mTAG, "setPictureTransition type = ".concat(String.valueOf(i)));
        runOnWorkThread(cy.a(this, i));
    }

    public void setRepeatPlay(List<TXVideoEditConstants.TXRepeat> list) {
        LiteavLog.i(this.mTAG, "setRepeatPlay");
        this.mCalculateDurationTask = new FutureTask<>(dd.a(this));
        runOnWorkThread(de.a(this, list));
    }

    public void setReverse(boolean z) {
        LiteavLog.i(this.mTAG, "setReverse isReverse = ".concat(String.valueOf(z)));
        if (z == this.mIsReverse) {
            return;
        }
        runOnWorkThread(df.a(this, z));
    }

    public void setSpeedList(List<TXVideoEditConstants.TXSpeed> list) {
        LiteavLog.i(this.mTAG, "setSpeedList");
        this.mCalculateDurationTask = new FutureTask<>(dh.a(this));
        runOnWorkThread(di.a(this, list));
    }

    public void setTailWaterMarkDurationSecond(int i) {
        runOnWorkThread(dn.a(this, i));
    }

    public void setVideoSourceRange(long j, long j2) {
        String str = this.mTAG;
        LiteavLog.i(str, "setVideoSourceRange startTime = " + j + " endTime = " + j2);
        this.mCalculateDurationTask = new FutureTask<>(dv.a(this));
        runOnWorkThread(cw.a(this, j, j2));
    }

    public void setVideoSources(List<String> list) {
        LiteavLog.i(this.mTAG, "setVideoSources");
        this.mHasAudioDataTask = new FutureTask<>(dg.a(this));
        this.mCalculateDurationTask = new FutureTask<>(dp.a(this));
        runOnWorkThread(dq.a(this, list));
    }

    public long transitionOffsetTimeWithPts(long j) {
        return 0L;
    }

    public void uninitialize() {
        LiteavLog.i(this.mTAG, "unInitialize");
        runOnWorkThread(cv.a(this));
    }
}
