package com.tencent.ugc;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Looper;
import android.text.TextUtils;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.liteav.videoproducer.encoder.VideoEncodeParams;
import com.tencent.ugc.MP4Writer;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.UGCAVSyncer;
import com.tencent.ugc.UGCAudioProcessor;
import com.tencent.ugc.UGCThumbnailGenerator;
import com.tencent.ugc.UGCVideoProcessor;
import com.tencent.ugc.common.MediaExtractorBuilder;
import com.tencent.ugc.common.UGCConstants;
import com.tencent.ugc.common.UGCTranscodeAudioEncodeParamsDecider;
import com.tencent.ugc.common.UGCTranscodeVideoEncodeParamsDecider;
import com.tencent.ugc.datereport.UGCDataReport;
import com.tencent.ugc.retriver.FFmpegMediaRetriever;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/TXVideoEditer.class */
public class TXVideoEditer {
    private static final String TAG = "TXVideoEditer";
    private final UGCAVSyncer mAVSyncer;
    private int mAudioEncodeBitrate;
    private final UGCAudioProcessor.AudioEncodedFrameListener mAudioEncodedFrameListener;
    private List<MediaFormat> mAudioFormatList;
    private final UGCAudioProcessor mAudioProcessor;
    private MediaFormat mBGMFormat;
    private CombineFilterInfo mCombineFilterInfo;
    private final Context mContext;
    private long mCutEndTimeMs;
    private long mCutStartTimeMs;
    private int mEncodeProfile;
    private com.tencent.liteav.base.util.n mEncodeResolution;
    private FrameLayout mFrameLayout;
    private boolean mHasBGM;
    private final TXThumbnailListener mInnerThumbnailListener;
    private boolean mIsAudioEncoderStarted;
    private boolean mIsAudioEnd;
    private boolean mIsFullIFrame;
    private boolean mIsGenerating;
    private boolean mIsPlaying;
    private boolean mIsProcessToFullKeyFrame;
    private boolean mIsReverse;
    private boolean mIsVideoEncoderStarted;
    private boolean mIsVideoEnd;
    private final com.tencent.liteav.base.util.b mMainHandler;
    private final UGCMediaListSource mMediaListSource;
    private MP4Writer mMp4Writer;
    private final MP4Writer.MP4WriterListener mMp4WriterListener;
    private final AtomicReference<Long> mPendingPreviewAtTime;
    private UGCAVSyncer.SyncMode mPreviewSyncMode;
    private String mProcessOutputPath;
    private UGCThumbnailGenerator.UGCThumbnailGenerateParams mProcessThumbnailInfo;
    private TXThumbnailListener mProcessThumbnailListener;
    private Rotation mRotation;
    protected final com.tencent.liteav.base.util.j mSequenceTaskRunner;
    private String mSourcePath;
    private long mSourceRangeEndTimeMs;
    private long mSourceRangeStartTimeMs;
    private final UGCThumbnailGenerator mThumbnailGenerator;
    private int mVideoEncodeBitrate;
    private final UGCVideoProcessor.VideoEncodedFrameListener mVideoEncodedFrameListener;
    private List<MediaFormat> mVideoFormatList;
    private TXVideoGenerateListener mVideoGenerateListener;
    private TXVideoPreviewListener mVideoPreviewListener;
    private TXVideoProcessListener mVideoProcessListener;
    private final UGCVideoProcessor.VideoProcessListener mVideoProcessProgressListener;
    private final UGCVideoProcessor mVideoProcessor;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.ugc.TXVideoEditer$4  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/TXVideoEditer$4.class */
    public final class AnonymousClass4 implements UGCVideoProcessor.VideoProcessListener {
        AnonymousClass4() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void a(AnonymousClass4 anonymousClass4) {
            if (TXVideoEditer.this.mIsVideoEnd) {
                return;
            }
            TXVideoEditer.this.mIsVideoEnd = true;
            TXVideoEditer.this.mIsAudioEnd = true;
            TXVideoEditer.this.mAVSyncer.setVideoEos();
            TXVideoEditer.this.mAVSyncer.setAudioEos();
            TXVideoEditer.this.onPlayProgressEnd();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void a(AnonymousClass4 anonymousClass4, float f) {
            float duration = (float) (TXVideoEditer.this.mMediaListSource.getDuration() * 1000);
            float f2 = f;
            if (TXVideoEditer.this.mIsReverse) {
                f2 = 1.0f - f;
            }
            TXVideoEditer.this.notifyPreviewProgress((int) (duration * f2));
        }

        @Override // com.tencent.ugc.UGCVideoProcessor.VideoProcessListener
        public final void onComplete(TXVideoEditConstants.TXGenerateResult tXGenerateResult) {
            if (tXGenerateResult != null) {
                LiteavLog.i(TXVideoEditer.TAG, "on video progress complete: retCode= " + tXGenerateResult.retCode + ", descMsg= " + tXGenerateResult.descMsg);
            }
            TXVideoEditer.this.mSequenceTaskRunner.a(bo.a(this));
        }

        @Override // com.tencent.ugc.UGCVideoProcessor.VideoProcessListener
        public final void onProgress(float f) {
            TXVideoEditer.this.mSequenceTaskRunner.a(bn.a(this, f));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/TXVideoEditer$TXPCMCallbackListener.class */
    public interface TXPCMCallbackListener {
        TXAudioFrame onPCMCallback(TXAudioFrame tXAudioFrame);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/TXVideoEditer$TXThumbnailListener.class */
    public interface TXThumbnailListener {
        void onThumbnail(int i, long j, Bitmap bitmap);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/TXVideoEditer$TXVideoCustomProcessListener.class */
    public interface TXVideoCustomProcessListener {
        int onTextureCustomProcess(int i, int i2, int i3, long j);

        void onTextureDestroyed();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/TXVideoEditer$TXVideoGenerateListener.class */
    public interface TXVideoGenerateListener {
        void onGenerateComplete(TXVideoEditConstants.TXGenerateResult tXGenerateResult);

        void onGenerateProgress(float f);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/TXVideoEditer$TXVideoPreviewListener.class */
    public interface TXVideoPreviewListener {
        void onPreviewFinished();

        void onPreviewProgress(int i);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/TXVideoEditer$TXVideoPreviewListenerEx.class */
    public interface TXVideoPreviewListenerEx extends TXVideoPreviewListener {
        void onPreviewError(TXVideoEditConstants.TXPreviewError tXPreviewError);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/TXVideoEditer$TXVideoProcessListener.class */
    public interface TXVideoProcessListener {
        void onProcessComplete(TXVideoEditConstants.TXGenerateResult tXGenerateResult);

        void onProcessProgress(float f);
    }

    public TXVideoEditer(Context context) {
        this(context, new com.tencent.liteav.base.util.j());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TXVideoEditer(Context context, com.tencent.liteav.base.util.j jVar) {
        this.mPendingPreviewAtTime = new AtomicReference<>();
        this.mPreviewSyncMode = UGCAVSyncer.SyncMode.VIDEO_MASTER;
        this.mIsGenerating = false;
        this.mIsPlaying = false;
        this.mIsProcessToFullKeyFrame = false;
        this.mHasBGM = false;
        this.mMp4WriterListener = new MP4Writer.MP4WriterListener() { // from class: com.tencent.ugc.TXVideoEditer.1
            @Override // com.tencent.ugc.MP4Writer.MP4WriterListener
            public final void onComplete(long j) {
                LiteavLog.i(TXVideoEditer.TAG, "onComplete ".concat(String.valueOf(j)));
                TXVideoEditer.this.handleWriteMP4Completed(0, j);
            }

            @Override // com.tencent.ugc.MP4Writer.MP4WriterListener
            public final void onError(String str) {
                LiteavLog.i(TXVideoEditer.TAG, "onError ".concat(String.valueOf(str)));
                TXVideoEditer.this.handleWriteMP4Completed(-1, 0L);
            }
        };
        this.mMainHandler = new com.tencent.liteav.base.util.b(Looper.getMainLooper());
        this.mIsVideoEnd = false;
        this.mIsAudioEnd = false;
        this.mVideoEncodeBitrate = -1;
        this.mAudioEncodeBitrate = -1;
        this.mEncodeProfile = -1;
        this.mSourceRangeStartTimeMs = 0L;
        this.mSourceRangeEndTimeMs = 2147483647L;
        this.mCutStartTimeMs = 0L;
        this.mCutEndTimeMs = 2147483647L;
        this.mIsReverse = false;
        this.mIsFullIFrame = false;
        this.mRotation = Rotation.NORMAL;
        this.mIsVideoEncoderStarted = false;
        this.mIsAudioEncoderStarted = false;
        this.mVideoEncodedFrameListener = new UGCVideoProcessor.VideoEncodedFrameListener() { // from class: com.tencent.ugc.TXVideoEditer.2
            @Override // com.tencent.ugc.UGCVideoProcessor.VideoEncodedFrameListener
            public final void onVideoEncodeStarted() {
                TXVideoEditer.this.mIsVideoEncoderStarted = true;
            }

            @Override // com.tencent.ugc.UGCVideoProcessor.VideoEncodedFrameListener
            public final void onVideoEncodingCompleted() {
                TXVideoEditer.this.onVideoEncodedFrameComplete();
            }

            @Override // com.tencent.ugc.UGCVideoProcessor.VideoEncodedFrameListener
            public final void onVideoFrameEncoded(EncodedVideoFrame encodedVideoFrame) {
                TXVideoEditer.this.onVideoEncodedFrame(encodedVideoFrame);
            }
        };
        this.mAudioEncodedFrameListener = new UGCAudioProcessor.AudioEncodedFrameListener() { // from class: com.tencent.ugc.TXVideoEditer.3
            @Override // com.tencent.ugc.UGCAudioProcessor.AudioEncodedFrameListener
            public final void onAudioEncodingCompleted() {
                TXVideoEditer.this.onAudioEncodedFrameComplete();
            }

            @Override // com.tencent.ugc.UGCAudioProcessor.AudioEncodedFrameListener
            public final void onAudioEncodingStarted() {
                TXVideoEditer.this.mIsAudioEncoderStarted = true;
            }

            @Override // com.tencent.ugc.UGCAudioProcessor.AudioEncodedFrameListener
            public final void onAudioFrameEncoded(AudioFrame audioFrame) {
                TXVideoEditer.this.onAudioEncodedFrame(audioFrame);
            }
        };
        this.mVideoProcessProgressListener = new AnonymousClass4();
        this.mInnerThumbnailListener = b.a(this);
        UGCInitializer.initialize();
        this.mContext = context.getApplicationContext();
        this.mAVSyncer = new UGCAVSyncer();
        UGCMediaListSource uGCMediaListSource = new UGCMediaListSource();
        this.mMediaListSource = uGCMediaListSource;
        this.mVideoProcessor = new UGCVideoProcessor(this.mContext, uGCMediaListSource, this.mAVSyncer, new com.tencent.liteav.videobase.videobase.f(), true);
        this.mAudioProcessor = new UGCAudioProcessor(this.mAVSyncer, this.mMediaListSource);
        UGCThumbnailGenerator uGCThumbnailGenerator = new UGCThumbnailGenerator();
        this.mThumbnailGenerator = uGCThumbnailGenerator;
        uGCThumbnailGenerator.initialize();
        this.mVideoProcessor.initialize();
        this.mAudioProcessor.initialize();
        this.mMediaListSource.initialize();
        this.mSequenceTaskRunner = jVar;
        UGCDataReport.reportDAU(1004);
    }

    private float calculateProgress(long j) {
        long duration = this.mMediaListSource.getDuration();
        long j2 = duration;
        if (duration == 0) {
            j2 = 1;
        }
        return (((float) j) * 1.0f) / ((float) j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doGetThumbnail(List<Long> list, int i, int i2, boolean z, TXThumbnailListener tXThumbnailListener) {
        LiteavLog.i(TAG, "getThumbnail: width= " + i + " height= " + i2 + ",fast= " + z + ",list.size= " + list.size());
        UGCThumbnailGenerator.UGCThumbnailGenerateParams uGCThumbnailGenerateParams = new UGCThumbnailGenerator.UGCThumbnailGenerateParams();
        uGCThumbnailGenerateParams.thumbnailPtsList = list;
        uGCThumbnailGenerateParams.width = i;
        uGCThumbnailGenerateParams.height = i2;
        uGCThumbnailGenerateParams.fast = z;
        UGCThumbnailGenerator uGCThumbnailGenerator = new UGCThumbnailGenerator();
        uGCThumbnailGenerator.initialize();
        uGCThumbnailGenerator.setVideoSourceList(Collections.singletonList(this.mSourcePath));
        uGCThumbnailGenerator.start(uGCThumbnailGenerateParams, ax.a(tXThumbnailListener, list, uGCThumbnailGenerator));
    }

    private void doStopPlayInner() {
        LiteavLog.i(TAG, "doStopPlayInner");
        this.mVideoProcessor.setProgressListener(null);
        this.mAudioProcessor.setProgressListener(null);
        this.mAVSyncer.stop();
        this.mVideoProcessor.stop();
        this.mAudioProcessor.stop();
        this.mIsPlaying = false;
    }

    private String generateVideoPath() {
        File externalFilesDir = this.mContext.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            LiteavLog.e(TAG, "generateVideoPath getExternalFilesDir return null.");
            return null;
        }
        File file = new File(externalFilesDir + File.separator + "liteav");
        if (!file.exists()) {
            file.mkdirs();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US);
        String format = simpleDateFormat.format(new Date(Long.parseLong(String.valueOf(currentTimeMillis) + "000")));
        return file + "/" + String.format("TXVideo_%s_process.mp4", format);
    }

    private void getAllMediaFormatFromSource(List<String> list) {
        for (String str : list) {
            MediaExtractor build = new MediaExtractorBuilder().setPath(str).build();
            if (build != null) {
                int trackCount = build.getTrackCount();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < trackCount) {
                        MediaFormat trackFormat = build.getTrackFormat(i2);
                        String string = trackFormat.getString(MediaFormat.KEY_MIME);
                        if (string != null) {
                            if (string.startsWith("video/")) {
                                this.mVideoFormatList.add(trackFormat);
                            }
                            if (string.startsWith("audio/")) {
                                this.mAudioFormatList.add(trackFormat);
                            }
                        }
                        i = i2 + 1;
                    }
                }
            } else {
                LiteavLog.e(TAG, "build extractor fail.");
            }
        }
    }

    private void handleEncodedCompletedInner() {
        if (this.mIsAudioEnd && this.mIsVideoEnd) {
            LiteavLog.i(TAG, "handleEncodedCompleted");
            this.mAVSyncer.stop();
            stopMp4Writer();
        }
    }

    private void handleProcessThumbnail(int i, int i2, TXThumbnailListener tXThumbnailListener) {
        UGCThumbnailGenerator.UGCThumbnailGenerateParams uGCThumbnailGenerateParams = this.mProcessThumbnailInfo;
        if (uGCThumbnailGenerateParams == null) {
            return;
        }
        if (uGCThumbnailGenerateParams.width == 0 || this.mProcessThumbnailInfo.height == 0) {
            this.mProcessThumbnailInfo.width = i;
            this.mProcessThumbnailInfo.height = i2;
        }
        this.mThumbnailGenerator.setVideoSourceRange(this.mCutStartTimeMs, this.mCutEndTimeMs);
        UGCThumbnailGenerator.UGCThumbnailGenerateParams uGCThumbnailGenerateParams2 = this.mProcessThumbnailInfo;
        uGCThumbnailGenerateParams2.thumbnailPtsList = UGCThumbnailGenerator.calculateThumbnailList(uGCThumbnailGenerateParams2.thumbnailCount, 0L, this.mCutEndTimeMs - this.mCutStartTimeMs, this.mMediaListSource.getDuration());
        this.mThumbnailGenerator.start(this.mProcessThumbnailInfo, tXThumbnailListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWriteMP4Completed(int i, long j) {
        this.mSequenceTaskRunner.a(ay.a(this, i, j));
    }

    private static boolean isAudioChannelSatisfied(MediaFormat mediaFormat) {
        int integer;
        if (!mediaFormat.containsKey(MediaFormat.KEY_CHANNEL_COUNT) || (integer = mediaFormat.getInteger(MediaFormat.KEY_CHANNEL_COUNT)) <= 2) {
            return true;
        }
        LiteavLog.e(ContentValues.TAG, "isAudioChannelSatisfied: unSupport audio format. channel = ".concat(String.valueOf(integer)));
        return false;
    }

    private static int isAudioFormatValid(MediaExtractor mediaExtractor, boolean z) {
        int trackCount = mediaExtractor.getTrackCount();
        if (trackCount <= 0) {
            LiteavLog.e(ContentValues.TAG, "isSourceValid: trackCount < 1!");
            return TXVideoEditConstants.ERR_SOURCE_NO_TRACK;
        }
        int i = 0;
        boolean z2 = false;
        while (true) {
            boolean z3 = z2;
            if (i >= trackCount) {
                if (!z || z3) {
                    return 0;
                }
                return UGCConstants.ERR_BGM_NO_AUDIO_TRACK;
            }
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
            String string = trackFormat.getString(MediaFormat.KEY_MIME);
            boolean z4 = z3;
            if (string != null) {
                z4 = z3;
                if (!string.startsWith("audio")) {
                    continue;
                } else if (!isAudioChannelSatisfied(trackFormat)) {
                    return -1004;
                } else {
                    z4 = true;
                }
            }
            i++;
            z2 = z4;
        }
    }

    private int isBGMValid(String str) {
        MediaExtractor build = new MediaExtractorBuilder().setPath(str).build();
        if (build == null) {
            LiteavLog.e(ContentValues.TAG, " checkBGMLegality: setDataSource error. path =  ".concat(String.valueOf(str)));
            return TXVideoEditConstants.ERR_SOURCE_DAMAGED;
        }
        int isAudioFormatValid = isAudioFormatValid(build, true);
        build.release();
        return isAudioFormatValid;
    }

    private boolean isFullIFrame(String str) {
        int i;
        MediaExtractor build = new MediaExtractorBuilder().setPath(str).setMimeType("video/").build();
        if (build == null) {
            LiteavLog.w(ContentValues.TAG, "judgeFullIFrame: extractor is null.");
            return false;
        }
        build.seekTo(0L, 0);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i2 >= 7) {
                break;
            }
            int i4 = i;
            if ((build.getSampleFlags() & 1) == 1) {
                i4 = i + 1;
            }
            build.advance();
            i2++;
            i3 = i4;
        }
        return i > 5;
    }

    private boolean isGopEqualOne(String str) {
        MediaExtractor build = new MediaExtractorBuilder().setPath(str).setMimeType("video/").build();
        if (build == null) {
            LiteavLog.w(TAG, "extractor is null.");
            return false;
        }
        build.seekTo(1L, 1);
        long sampleTime = build.getSampleTime();
        build.release();
        return sampleTime > 100000 && sampleTime < 1100000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int isMediaSourceValid(String str) {
        if (TextUtils.isEmpty(str)) {
            LiteavLog.e(TAG, "checkLegality: path is null.");
            return TXVideoEditConstants.ERR_SOURCE_NO_FOUND;
        }
        try {
            MediaExtractor build = new MediaExtractorBuilder().setPath(str).build();
            if (build == null) {
                LiteavLog.e(TAG, "checkLegality:source no found!");
                return TXVideoEditConstants.ERR_SOURCE_NO_FOUND;
            }
            int isAudioFormatValid = isAudioFormatValid(build, false);
            build.release();
            return isAudioFormatValid;
        } catch (Exception e) {
            LiteavLog.e(TAG, "checkLegality: some error happen.");
            return TXVideoEditConstants.ERR_SOURCE_DAMAGED;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$cancel$50(TXVideoEditer tXVideoEditer) {
        LiteavLog.i(TAG, com.anythink.expressad.d.a.b.dO);
        tXVideoEditer.mIsGenerating = false;
        tXVideoEditer.mIsVideoEncoderStarted = false;
        tXVideoEditer.mIsAudioEncoderStarted = false;
        tXVideoEditer.mIsProcessToFullKeyFrame = false;
        tXVideoEditer.mThumbnailGenerator.stop();
        tXVideoEditer.mVideoProcessor.setVideoEncodedFrameListener(null);
        tXVideoEditer.mAudioProcessor.setAudioEncodedFrameListener(null);
        tXVideoEditer.mMediaListSource.resetReadPosition();
        tXVideoEditer.mMediaListSource.setTailWaterMarkDurationSecond(0);
        if (!tXVideoEditer.mIsPlaying) {
            tXVideoEditer.mAudioProcessor.stop();
            tXVideoEditer.mVideoProcessor.stop();
        }
        MP4Writer mP4Writer = tXVideoEditer.mMp4Writer;
        if (mP4Writer != null) {
            mP4Writer.setListener(null);
        }
        tXVideoEditer.stopMp4Writer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$deleteAllEffect$31(TXVideoEditer tXVideoEditer) {
        LiteavLog.i(TAG, "deleteAllEffect");
        tXVideoEditer.mVideoProcessor.getEffectProcessor().deleteAllEffect();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$deleteLastEffect$30(TXVideoEditer tXVideoEditer) {
        LiteavLog.i(TAG, "deleteLastEffect");
        tXVideoEditer.mVideoProcessor.getEffectProcessor().deleteLastEffect();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$deleteLastTransitionEffect$27(TXVideoEditer tXVideoEditer) {
        LiteavLog.i(TAG, "deleteLastTransitionEffect");
        tXVideoEditer.mVideoProcessor.getTransitionProcessor().deleteLastTransitionEffect();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$doGetThumbnail$52(TXThumbnailListener tXThumbnailListener, List list, UGCThumbnailGenerator uGCThumbnailGenerator, int i, long j, Bitmap bitmap) {
        if (tXThumbnailListener != null) {
            tXThumbnailListener.onThumbnail(i, j, bitmap);
        }
        if (i == list.size()) {
            LiteavLog.i(TAG, "getThumbnail finished!");
            uGCThumbnailGenerator.stop();
            uGCThumbnailGenerator.uninitialize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$generateVideo$49(TXVideoEditer tXVideoEditer, int i, String str) {
        LiteavLog.i(TAG, "generateVideo: videoCompressed= " + i + ", videoOutputPath= " + str);
        UGCTranscodeVideoEncodeParamsDecider uGCTranscodeVideoEncodeParamsDecider = new UGCTranscodeVideoEncodeParamsDecider();
        uGCTranscodeVideoEncodeParamsDecider.setSourceType(UGCConstants.SourceType.VIDEO);
        uGCTranscodeVideoEncodeParamsDecider.setFullIFrame(tXVideoEditer.mIsFullIFrame);
        uGCTranscodeVideoEncodeParamsDecider.setOutputResolution(i);
        uGCTranscodeVideoEncodeParamsDecider.setEncodeProfile(tXVideoEditer.mEncodeProfile);
        uGCTranscodeVideoEncodeParamsDecider.setInputVideoMediaFormat(tXVideoEditer.mVideoFormatList);
        UGCTranscodeAudioEncodeParamsDecider uGCTranscodeAudioEncodeParamsDecider = new UGCTranscodeAudioEncodeParamsDecider();
        uGCTranscodeAudioEncodeParamsDecider.setInputAudioMediaFormat(tXVideoEditer.mAudioFormatList);
        uGCTranscodeAudioEncodeParamsDecider.setBGMMediaFormat(tXVideoEditer.mBGMFormat);
        if (TextUtils.isEmpty(tXVideoEditer.mSourcePath)) {
            uGCTranscodeVideoEncodeParamsDecider.setSourceType(UGCConstants.SourceType.PICTURE);
        }
        int i2 = tXVideoEditer.mVideoEncodeBitrate;
        if (i2 != -1) {
            uGCTranscodeVideoEncodeParamsDecider.setEncodeBitrate(i2);
        }
        int i3 = tXVideoEditer.mAudioEncodeBitrate;
        if (i3 != -1) {
            uGCTranscodeAudioEncodeParamsDecider.setEncodeBitrate(i3);
        }
        com.tencent.liteav.base.util.n nVar = tXVideoEditer.mEncodeResolution;
        if (nVar != null) {
            uGCTranscodeVideoEncodeParamsDecider.setEncodeOutputSize(nVar);
        }
        VideoEncodeParams decidedEncodeParams = uGCTranscodeVideoEncodeParamsDecider.getDecidedEncodeParams();
        AudioEncodeParams decidedEncodeParams2 = uGCTranscodeAudioEncodeParamsDecider.getDecidedEncodeParams();
        tXVideoEditer.mIsProcessToFullKeyFrame = false;
        tXVideoEditer.mIsGenerating = true;
        tXVideoEditer.startRecord(str, decidedEncodeParams, decidedEncodeParams2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$getThumbnail$34(TXVideoEditer tXVideoEditer, int i, int i2, boolean z, int i3, TXThumbnailListener tXThumbnailListener) {
        LiteavLog.i(TAG, "getThumbnail: width= " + i + " height= " + i2 + ",fast= " + z + ",count= " + i3);
        FFmpegMediaRetriever fFmpegMediaRetriever = new FFmpegMediaRetriever();
        fFmpegMediaRetriever.setDataSource(tXVideoEditer.mSourcePath);
        List<Long> calculateThumbnailList = UGCThumbnailGenerator.calculateThumbnailList(i3, 0L, fFmpegMediaRetriever.getVideoDurationMs(), fFmpegMediaRetriever.getVideoDurationMs());
        if (calculateThumbnailList != null) {
            tXVideoEditer.doGetThumbnail(calculateThumbnailList, i, i2, z, tXThumbnailListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleWriteMP4Completed$53(TXVideoEditer tXVideoEditer, int i, long j) {
        LiteavLog.i(TAG, "handleWriteMP4Completed: mIsProcessToFullKeyFrame=" + tXVideoEditer.mIsProcessToFullKeyFrame + ",resultCode=" + i + ",mIsGenerating= " + tXVideoEditer.mIsGenerating);
        if (tXVideoEditer.mIsGenerating) {
            tXVideoEditer.mAVSyncer.stop();
            tXVideoEditer.mVideoProcessor.stop();
            tXVideoEditer.mAudioProcessor.stop();
            tXVideoEditer.stopMp4Writer();
            tXVideoEditer.mIsGenerating = false;
            if (!tXVideoEditer.mIsProcessToFullKeyFrame) {
                tXVideoEditer.notifyGenerateComplete(i, j);
                return;
            }
            if (com.tencent.liteav.base.util.g.a(tXVideoEditer.mProcessOutputPath) && i == 0) {
                if (tXVideoEditer.mRotation != Rotation.NORMAL) {
                    Rotation rotation = Rotation.NORMAL;
                    tXVideoEditer.mRotation = rotation;
                    tXVideoEditer.mVideoProcessor.setRenderRotation(rotation);
                }
                tXVideoEditer.setMediaSourcePaths(Collections.singletonList(tXVideoEditer.mProcessOutputPath));
            }
            tXVideoEditer.notifyProcessComplete(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$initWithPreview$39(TXVideoEditer tXVideoEditer, TXVideoEditConstants.TXPreviewParam tXPreviewParam) {
        FrameLayout frameLayout = tXVideoEditer.mFrameLayout;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        TextureView textureView = null;
        FrameLayout frameLayout2 = tXVideoEditer.mFrameLayout;
        if (frameLayout2 == null || !frameLayout2.equals(tXPreviewParam.videoView)) {
            textureView = new TextureView(tXVideoEditer.mContext);
        }
        FrameLayout frameLayout3 = tXPreviewParam.videoView;
        tXVideoEditer.mFrameLayout = frameLayout3;
        if (frameLayout3 != null && textureView != null) {
            frameLayout3.addView(textureView);
        }
        DisplayTarget displayTarget = new DisplayTarget(textureView);
        GLConstants.GLScaleType gLScaleType = GLConstants.GLScaleType.CENTER_CROP;
        if (tXPreviewParam.renderMode == 2) {
            gLScaleType = GLConstants.GLScaleType.FIT_CENTER;
        }
        tXVideoEditer.mVideoProcessor.setDisplayView(displayTarget, gLScaleType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$new$1(TXVideoEditer tXVideoEditer, int i, long j, Bitmap bitmap) {
        TXThumbnailListener tXThumbnailListener = tXVideoEditer.mProcessThumbnailListener;
        if (tXThumbnailListener != null) {
            tXThumbnailListener.onThumbnail(i, j, bitmap);
        }
        int thumbnailCount = tXVideoEditer.getThumbnailCount();
        tXVideoEditer.mMainHandler.post(bj.a(tXVideoEditer, thumbnailCount, j, i));
        if (thumbnailCount == i) {
            LiteavLog.i(TAG, "mInnerThumbnailListener: notifyProcessComplete");
            tXVideoEditer.mProcessOutputPath = tXVideoEditer.mSourcePath;
            tXVideoEditer.notifyProcessComplete(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$notifyGenerateComplete$61(int i, TXVideoGenerateListener tXVideoGenerateListener) {
        TXVideoEditConstants.TXGenerateResult tXGenerateResult = new TXVideoEditConstants.TXGenerateResult();
        tXGenerateResult.retCode = i;
        tXGenerateResult.descMsg = "";
        tXVideoGenerateListener.onGenerateComplete(tXGenerateResult);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$notifyProcessComplete$59(int i, TXVideoProcessListener tXVideoProcessListener) {
        TXVideoEditConstants.TXGenerateResult tXGenerateResult = new TXVideoEditConstants.TXGenerateResult();
        tXGenerateResult.retCode = i;
        tXGenerateResult.descMsg = "";
        tXVideoProcessListener.onProcessComplete(tXGenerateResult);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$null$0(TXVideoEditer tXVideoEditer, int i, long j, int i2) {
        if (tXVideoEditer.mVideoProcessListener != null) {
            tXVideoEditer.mVideoProcessListener.onProcessProgress(i == 0 ? tXVideoEditer.calculateProgress(j) : (i2 * 1.0f) / i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onAudioEncodedFrame$56(TXVideoEditer tXVideoEditer, AudioFrame audioFrame) {
        if (tXVideoEditer.mMp4Writer != null || tXVideoEditer.mIsAudioEncoderStarted) {
            tXVideoEditer.mMp4Writer.writeAudioFrame(audioFrame);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onAudioEncodedFrameComplete$57(TXVideoEditer tXVideoEditer) {
        LiteavLog.i(TAG, "onAudioEncodedFrameComplete end flag = " + tXVideoEditer.mIsAudioEnd);
        if (tXVideoEditer.mIsAudioEnd) {
            return;
        }
        tXVideoEditer.mIsAudioEnd = true;
        tXVideoEditer.mAVSyncer.setAudioEos();
        tXVideoEditer.handleEncodedCompletedInner();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onVideoEncodedFrame$54(TXVideoEditer tXVideoEditer, EncodedVideoFrame encodedVideoFrame) {
        if (tXVideoEditer.mIsGenerating && tXVideoEditer.mIsVideoEncoderStarted) {
            MP4Writer mP4Writer = tXVideoEditer.mMp4Writer;
            if (mP4Writer != null) {
                mP4Writer.writeVideoFrame(encodedVideoFrame);
            }
            if (!tXVideoEditer.mIsProcessToFullKeyFrame) {
                tXVideoEditer.notifyGenerateProgress(tXVideoEditer.calculateProgress(encodedVideoFrame.pts));
                return;
            }
            TXVideoProcessListener tXVideoProcessListener = tXVideoEditer.mVideoProcessListener;
            if (tXVideoProcessListener != null) {
                tXVideoProcessListener.onProcessProgress(tXVideoEditer.calculateProgress(encodedVideoFrame.pts));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onVideoEncodedFrameComplete$55(TXVideoEditer tXVideoEditer) {
        LiteavLog.i(TAG, "onVideoEncodedFrameComplete end flag = " + tXVideoEditer.mIsVideoEnd);
        if (tXVideoEditer.mIsVideoEnd) {
            return;
        }
        tXVideoEditer.mAVSyncer.setVideoEos();
        tXVideoEditer.mIsVideoEnd = true;
        tXVideoEditer.handleEncodedCompletedInner();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$pausePlay$41(TXVideoEditer tXVideoEditer) {
        LiteavLog.i(TAG, "pausePlay " + tXVideoEditer.mIsGenerating);
        if (tXVideoEditer.mIsGenerating) {
            return;
        }
        tXVideoEditer.mAVSyncer.stop();
        tXVideoEditer.mVideoProcessor.stop();
        tXVideoEditer.mAudioProcessor.stop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$previewAtTime$44(TXVideoEditer tXVideoEditer) {
        Long andSet = tXVideoEditer.mPendingPreviewAtTime.getAndSet(null);
        if (andSet == null) {
            return;
        }
        LiteavLog.i(TAG, "previewAtTime time = ".concat(String.valueOf(andSet)));
        tXVideoEditer.mMediaListSource.seekTo(andSet.longValue());
        tXVideoEditer.mVideoProcessor.seekTo(andSet.longValue());
        tXVideoEditer.mAVSyncer.resetClock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$release$37(TXVideoEditer tXVideoEditer) {
        LiteavLog.i(TAG, "release");
        tXVideoEditer.mVideoProcessor.unInitialize();
        tXVideoEditer.mAudioProcessor.unInitialize();
        tXVideoEditer.mMediaListSource.uninitialize();
        tXVideoEditer.mThumbnailGenerator.uninitialize();
        tXVideoEditer.stopMp4Writer();
        UGCInitializer.uninitialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$resumePlay$42(TXVideoEditer tXVideoEditer) {
        LiteavLog.i(TAG, "resumePlay " + tXVideoEditer.mIsGenerating);
        if (tXVideoEditer.mIsGenerating) {
            return;
        }
        tXVideoEditer.mAVSyncer.start();
        tXVideoEditer.mVideoProcessor.start(false);
        tXVideoEditer.mAudioProcessor.start(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setAnimatedPasterList$20(TXVideoEditer tXVideoEditer, List list) {
        LiteavLog.i(TAG, "setAnimatedPasterList");
        tXVideoEditer.mVideoProcessor.getWatermarkProcessor().setAnimatedPasterList(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setAudioBitrate$48(TXVideoEditer tXVideoEditer, int i) {
        LiteavLog.i(TAG, "setAudioBitrate: bitrate= ".concat(String.valueOf(i)));
        tXVideoEditer.mAudioEncodeBitrate = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setBGM$11(TXVideoEditer tXVideoEditer, String str, boolean z) {
        tXVideoEditer.mAudioProcessor.setBGM(str);
        tXVideoEditer.doStopPlayInner();
        if (z) {
            tXVideoEditer.mBGMFormat = null;
            tXVideoEditer.mHasBGM = false;
            if (com.tencent.liteav.videobase.utils.c.a(tXVideoEditer.mAudioFormatList)) {
                tXVideoEditer.mAVSyncer.setAudioExist(false);
                tXVideoEditer.mPreviewSyncMode = UGCAVSyncer.SyncMode.VIDEO_MASTER;
                tXVideoEditer.mAVSyncer.setSyncMode(UGCAVSyncer.SyncMode.VIDEO_MASTER);
                return;
            }
            return;
        }
        tXVideoEditer.mHasBGM = true;
        MediaExtractor build = new MediaExtractorBuilder().setPath(str).setMimeType("audio/").build();
        if (build == null) {
            LiteavLog.w(TAG, "setBGM: build extractor fail.");
            return;
        }
        tXVideoEditer.mBGMFormat = build.getTrackFormat(build.getSampleTrackIndex());
        tXVideoEditer.mAVSyncer.setAudioExist(true);
        tXVideoEditer.mPreviewSyncMode = UGCAVSyncer.SyncMode.AUDIO_MASTER;
        tXVideoEditer.mAVSyncer.setSyncMode(UGCAVSyncer.SyncMode.AUDIO_MASTER);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setBGMAtVideoTime$13(TXVideoEditer tXVideoEditer, long j) {
        LiteavLog.i(TAG, "setBGMAtVideoTime: videoStartTime= ".concat(String.valueOf(j)));
        tXVideoEditer.mAudioProcessor.setBGMAtVideoTime(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setBGMFadeInOutDuration$16(TXVideoEditer tXVideoEditer, long j, long j2) {
        LiteavLog.i(TAG, "setBGMFadeInOutDuration: fadeInDuration= " + j + ",fadeOutDuration= " + j2);
        tXVideoEditer.mAudioProcessor.setFadeInOutDuration(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setBGMLoop$12(TXVideoEditer tXVideoEditer, boolean z) {
        LiteavLog.i(TAG, "setBGMLoop: looping= ".concat(String.valueOf(z)));
        tXVideoEditer.mAudioProcessor.setBGMLoop(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setBGMStartTime$14(TXVideoEditer tXVideoEditer, long j, long j2) {
        LiteavLog.i(TAG, "setBGMStartTime: startTime= " + j + ", endTime= " + j2);
        tXVideoEditer.mAudioProcessor.setBGMStartTime(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setBGMVolume$15(TXVideoEditer tXVideoEditer, float f) {
        LiteavLog.i(TAG, "setBGMVolume: ".concat(String.valueOf(f)));
        tXVideoEditer.mAudioProcessor.setBGMVolume(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setBeautyFilter$8(TXVideoEditer tXVideoEditer, int i, int i2) {
        LiteavLog.i(TAG, "setBeautyFilter: beautyLevel= " + i + ",whiteningLevel= " + i2);
        tXVideoEditer.mVideoProcessor.setBeautyFilter(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setCustomVideoProcessListener$3(TXVideoEditer tXVideoEditer, TXVideoCustomProcessListener tXVideoCustomProcessListener) {
        LiteavLog.i(TAG, "setCustomVideoProcessListener: ".concat(String.valueOf(tXVideoCustomProcessListener)));
        tXVideoEditer.mVideoProcessor.setCustomVideoProcessListener(tXVideoCustomProcessListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setCutFromTime$46(TXVideoEditer tXVideoEditer, long j, long j2) {
        LiteavLog.i(TAG, "setCutFromTime: startTime= " + j + ",endTime= " + j2);
        tXVideoEditer.mCutStartTimeMs = j;
        tXVideoEditer.mCutEndTimeMs = j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setFilter$6(TXVideoEditer tXVideoEditer, Bitmap bitmap) {
        float f;
        float f2;
        LiteavLog.i(TAG, "setFilter: ".concat(String.valueOf(bitmap)));
        CombineFilterInfo combineFilterInfo = tXVideoEditer.mCombineFilterInfo;
        if (combineFilterInfo != null) {
            f = combineFilterInfo.getLeftSpecialRatio();
            f2 = tXVideoEditer.mCombineFilterInfo.getRightSpecialRatio();
        } else {
            f = 0.5f;
            f2 = 0.0f;
        }
        tXVideoEditer.setFilter(bitmap, f, null, f2, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setFilter$7(TXVideoEditer tXVideoEditer, float f, float f2, float f3, Bitmap bitmap, Bitmap bitmap2) {
        LiteavLog.i(TAG, "setFilter: leftIntensity= " + f + ",rightIntensity= " + f2 + ",leftRatio= " + f3);
        tXVideoEditer.mVideoProcessor.setFilter(bitmap, f, bitmap2, f2, f3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setPasterList$21(TXVideoEditer tXVideoEditer, List list) {
        LiteavLog.i(TAG, "setPasterList");
        tXVideoEditer.mVideoProcessor.getWatermarkProcessor().setPasterList(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setPictureList$9(TXVideoEditer tXVideoEditer, int i, List list) {
        LiteavLog.i(TAG, "setPictureList: fps= " + i + ",bitmapList.size= " + list.size());
        tXVideoEditer.mMediaListSource.setPictureList(list, i);
        tXVideoEditer.setOutputSize(new com.tencent.liteav.base.util.n(UGCTransitionRules.DEFAULT_IMAGE_WIDTH, 1280));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setPictureTransition$10(TXVideoEditer tXVideoEditer, int i) {
        LiteavLog.i(TAG, "setPictureTransition: ".concat(String.valueOf(i)));
        tXVideoEditer.mMediaListSource.setPictureTransition(i);
        tXVideoEditer.mVideoProcessor.setPictureTransition(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setProfile$4(TXVideoEditer tXVideoEditer, int i) {
        LiteavLog.i(TAG, "setProfile: ".concat(String.valueOf(i)));
        tXVideoEditer.mEncodeProfile = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setRenderRotation$22(TXVideoEditer tXVideoEditer, int i) {
        LiteavLog.i(TAG, "setRenderRotation: rotation= ".concat(String.valueOf(i)));
        Rotation a2 = Rotation.a(i);
        tXVideoEditer.mRotation = a2;
        tXVideoEditer.mVideoProcessor.setRenderRotation(a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setRepeatPlay$24(TXVideoEditer tXVideoEditer, List list) {
        LiteavLog.i(TAG, "setRepeatPlay");
        tXVideoEditer.mMediaListSource.setRepeatPlay(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setReverse$25(TXVideoEditer tXVideoEditer, boolean z) {
        LiteavLog.i(TAG, "setReverse: isReverse= ".concat(String.valueOf(z)));
        tXVideoEditer.mIsReverse = z;
        tXVideoEditer.mMediaListSource.setReverse(z);
        tXVideoEditer.doStopPlayInner();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setSpecialRatio$5(TXVideoEditer tXVideoEditer, float f) {
        LiteavLog.i(TAG, "setSpecialRatio: ".concat(String.valueOf(f)));
        if (tXVideoEditer.mCombineFilterInfo == null) {
            tXVideoEditer.mCombineFilterInfo = new CombineFilterInfo();
        }
        tXVideoEditer.mCombineFilterInfo.setLeftSpecialRatio(f);
        tXVideoEditer.mCombineFilterInfo.setRightSpecialRatio(0.0f);
        tXVideoEditer.mVideoProcessor.setSpecialRatio(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setSpeedList$23(TXVideoEditer tXVideoEditer, List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                TXVideoEditConstants.TXSpeed tXSpeed = (TXVideoEditConstants.TXSpeed) it.next();
                LiteavLog.i(TAG, "setSpeedList " + tXSpeed.startTime + " " + tXSpeed.endTime + " speed: " + tXSpeed.speedLevel);
            }
        }
        tXVideoEditer.mVideoProcessor.setSpeedList(list);
        tXVideoEditer.mAudioProcessor.setSpeedList(list);
        tXVideoEditer.mMediaListSource.setSpeedList(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setSubtitleList$19(TXVideoEditer tXVideoEditer, List list) {
        LiteavLog.i(TAG, "setSubtitleList");
        tXVideoEditer.mVideoProcessor.getWatermarkProcessor().setSubtitleList(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setTXVideoPreviewListener$38(TXVideoEditer tXVideoEditer, TXVideoPreviewListener tXVideoPreviewListener) {
        LiteavLog.i(TAG, "setTXVideoPreviewListener: listener= ".concat(String.valueOf(tXVideoPreviewListener)));
        tXVideoEditer.mVideoPreviewListener = tXVideoPreviewListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setTailWaterMark$18(TXVideoEditer tXVideoEditer, int i, Bitmap bitmap, TXVideoEditConstants.TXRect tXRect) {
        LiteavLog.i(TAG, "setTailWaterMark: duration= ".concat(String.valueOf(i)));
        tXVideoEditer.mVideoProcessor.getWatermarkProcessor().setTailWaterMark(bitmap, tXRect, tXVideoEditer.mMediaListSource.getDuration(), i);
        tXVideoEditer.mMediaListSource.setTailWaterMarkDurationSecond(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setThumbnail$35(TXVideoEditer tXVideoEditer, TXVideoEditConstants.TXThumbnail tXThumbnail) {
        LiteavLog.i(TAG, "setThumbnail: thumbnail.count= " + tXThumbnail.count + " ,thumbnail.width= " + tXThumbnail.width + " ,thumbnail.height= " + tXThumbnail.height);
        UGCThumbnailGenerator.UGCThumbnailGenerateParams uGCThumbnailGenerateParams = new UGCThumbnailGenerator.UGCThumbnailGenerateParams();
        tXVideoEditer.mProcessThumbnailInfo = uGCThumbnailGenerateParams;
        uGCThumbnailGenerateParams.thumbnailCount = tXThumbnail.count;
        tXVideoEditer.mProcessThumbnailInfo.width = tXThumbnail.width;
        tXVideoEditer.mProcessThumbnailInfo.height = tXThumbnail.height;
        tXVideoEditer.mProcessThumbnailInfo.fast = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setThumbnailListener$36(TXVideoEditer tXVideoEditer, TXThumbnailListener tXThumbnailListener) {
        LiteavLog.i(TAG, "setThumbnailListener: listener= ".concat(String.valueOf(tXThumbnailListener)));
        tXVideoEditer.mProcessThumbnailListener = tXThumbnailListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setTransitionEffect$26(TXVideoEditer tXVideoEditer, int i, long j, long j2, AtomicBoolean atomicBoolean) {
        LiteavLog.i(TAG, "setTransitionEffect: type=" + i + " ,startTimeMs= " + j + " ,transitionDurationMs= " + j2);
        atomicBoolean.set(tXVideoEditer.mVideoProcessor.getTransitionProcessor().setTransitionEffect(i, tXVideoEditer.mMediaListSource.getDuration(), j, j2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setVideoBitrate$47(TXVideoEditer tXVideoEditer, int i) {
        LiteavLog.i(TAG, "setVideoBitrate: bitrate= ".concat(String.valueOf(i)));
        tXVideoEditer.mVideoEncodeBitrate = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setVideoGenerateListener$45(TXVideoEditer tXVideoEditer, TXVideoGenerateListener tXVideoGenerateListener) {
        LiteavLog.i(TAG, "setVideoGenerateListener: listener= ".concat(String.valueOf(tXVideoGenerateListener)));
        tXVideoEditer.mVideoGenerateListener = tXVideoGenerateListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setVideoProcessListener$32(TXVideoEditer tXVideoEditer, TXVideoProcessListener tXVideoProcessListener) {
        LiteavLog.i(TAG, "setVideoProcessListener: listener= ".concat(String.valueOf(tXVideoProcessListener)));
        tXVideoEditer.mVideoProcessListener = tXVideoProcessListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setVideoVolume$51(TXVideoEditer tXVideoEditer, float f) {
        LiteavLog.i(TAG, "setVideoVolume: volume= ".concat(String.valueOf(f)));
        tXVideoEditer.mAudioProcessor.setVideoVolume(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setWaterMark$17(TXVideoEditer tXVideoEditer, TXVideoEditConstants.TXRect tXRect, Bitmap bitmap) {
        LiteavLog.i(TAG, "setWaterMark: " + tXRect.toString());
        tXVideoEditer.mVideoProcessor.getWatermarkProcessor().setWaterMark(bitmap, tXRect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$startEffect$28(TXVideoEditer tXVideoEditer, int i, long j) {
        LiteavLog.i(TAG, "startEffect: type=" + i + ",startTime= " + j);
        tXVideoEditer.mVideoProcessor.getEffectProcessor().startEffect(i, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$startPlayFromTime$40(TXVideoEditer tXVideoEditer, long j, long j2) {
        LiteavLog.i(TAG, "startPlayFromTime: startTime= " + j + ", endTime= " + j2);
        tXVideoEditer.doStopPlayInner();
        com.tencent.liteav.base.util.n nVar = tXVideoEditer.mEncodeResolution;
        if (nVar == null) {
            tXVideoEditer.mVideoProcessor.setOutputSize(-1, -1, GLConstants.GLScaleType.FIT_CENTER);
        } else {
            tXVideoEditer.mVideoProcessor.setOutputSize(nVar.f22649a, tXVideoEditer.mEncodeResolution.b, GLConstants.GLScaleType.FIT_CENTER);
        }
        tXVideoEditer.mIsAudioEnd = false;
        tXVideoEditer.mIsVideoEnd = false;
        tXVideoEditer.mAVSyncer.setSyncMode(tXVideoEditer.mPreviewSyncMode);
        tXVideoEditer.mAVSyncer.start();
        if (tXVideoEditer.mSourceRangeStartTimeMs != 0 || ((j2 != tXVideoEditer.mSourceRangeEndTimeMs && j2 >= 0) || tXVideoEditer.mIsReverse)) {
            tXVideoEditer.mSourceRangeStartTimeMs = 0L;
            tXVideoEditer.mSourceRangeEndTimeMs = j2;
            if (tXVideoEditer.mIsReverse) {
                tXVideoEditer.mSourceRangeStartTimeMs = j;
            }
            tXVideoEditer.mMediaListSource.setVideoSourceRange(tXVideoEditer.mSourceRangeStartTimeMs, j2);
        }
        if (!tXVideoEditer.mIsReverse) {
            tXVideoEditer.mMediaListSource.seekTo(j);
        }
        tXVideoEditer.mVideoProcessor.setProgressListener(tXVideoEditer.mVideoProcessProgressListener);
        tXVideoEditer.mVideoProcessor.start(false);
        tXVideoEditer.mAudioProcessor.start(false);
        tXVideoEditer.mIsProcessToFullKeyFrame = false;
        tXVideoEditer.mIsGenerating = false;
        tXVideoEditer.mIsPlaying = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$stopEffect$29(TXVideoEditer tXVideoEditer, int i, long j) {
        LiteavLog.i(TAG, "stopEffect");
        tXVideoEditer.mVideoProcessor.getEffectProcessor().stopEffect(i, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$stopPlay$43(TXVideoEditer tXVideoEditer) {
        LiteavLog.i(TAG, "stopPlay");
        tXVideoEditer.doStopPlayInner();
    }

    private void notifyGenerateComplete(int i, long j) {
        TXVideoGenerateListener tXVideoGenerateListener = this.mVideoGenerateListener;
        if (!TextUtils.isEmpty(this.mProcessOutputPath) && new File(this.mProcessOutputPath).exists()) {
            UGCDataReport.reportDAU(1032, (int) new File(this.mProcessOutputPath).length(), "");
            UGCDataReport.reportDAU(1033, (int) j, "");
        }
        if (tXVideoGenerateListener != null) {
            this.mMainHandler.post(bi.a(i, tXVideoGenerateListener));
        }
    }

    private void notifyGenerateProgress(float f) {
        TXVideoGenerateListener tXVideoGenerateListener = this.mVideoGenerateListener;
        if (tXVideoGenerateListener != null) {
            this.mMainHandler.post(bh.a(tXVideoGenerateListener, f));
        }
    }

    private void notifyPreviewFinished() {
        TXVideoPreviewListener tXVideoPreviewListener = this.mVideoPreviewListener;
        if (tXVideoPreviewListener != null) {
            com.tencent.liteav.base.util.b bVar = this.mMainHandler;
            tXVideoPreviewListener.getClass();
            bVar.post(bf.a(tXVideoPreviewListener));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPreviewProgress(int i) {
        TXVideoPreviewListener tXVideoPreviewListener = this.mVideoPreviewListener;
        if (tXVideoPreviewListener != null) {
            this.mMainHandler.post(bd.a(tXVideoPreviewListener, i));
        }
    }

    private void notifyProcessComplete(int i) {
        TXVideoProcessListener tXVideoProcessListener = this.mVideoProcessListener;
        if (tXVideoProcessListener != null) {
            this.mMainHandler.post(bg.a(i, tXVideoProcessListener));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAudioEncodedFrame(AudioFrame audioFrame) {
        if (audioFrame == null) {
            LiteavLog.w(TAG, "onAudioEncodedFrame frame is null.");
        } else {
            this.mSequenceTaskRunner.a(bb.a(this, audioFrame));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAudioEncodedFrameComplete() {
        this.mSequenceTaskRunner.a(bc.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlayProgressEnd() {
        LiteavLog.i(TAG, "onProgressEnd mIsPreviewAudioEnd=" + this.mIsAudioEnd + " mIsPreviewVideoEnd=" + this.mIsVideoEnd);
        if (this.mIsAudioEnd && this.mIsVideoEnd) {
            this.mAVSyncer.stop();
            notifyPreviewFinished();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVideoEncodedFrame(EncodedVideoFrame encodedVideoFrame) {
        if (encodedVideoFrame == null) {
            LiteavLog.w(TAG, "onVideoEncodedFrame frame is null.");
        } else {
            this.mSequenceTaskRunner.a(az.a(this, encodedVideoFrame));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVideoEncodedFrameComplete() {
        this.mSequenceTaskRunner.a(ba.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processVideoInternal() {
        LiteavLog.i(TAG, "processVideoInternal");
        this.mProcessOutputPath = generateVideoPath();
        boolean isFullIFrame = isFullIFrame(this.mSourcePath);
        UGCTranscodeVideoEncodeParamsDecider uGCTranscodeVideoEncodeParamsDecider = new UGCTranscodeVideoEncodeParamsDecider();
        uGCTranscodeVideoEncodeParamsDecider.setSourceType(UGCConstants.SourceType.VIDEO);
        uGCTranscodeVideoEncodeParamsDecider.setFullIFrame(true);
        uGCTranscodeVideoEncodeParamsDecider.setEncodeRotation(this.mRotation);
        uGCTranscodeVideoEncodeParamsDecider.setOutputResolution(4);
        uGCTranscodeVideoEncodeParamsDecider.setInputVideoMediaFormat(this.mVideoFormatList);
        VideoEncodeParams decidedEncodeParams = uGCTranscodeVideoEncodeParamsDecider.getDecidedEncodeParams();
        UGCTranscodeAudioEncodeParamsDecider uGCTranscodeAudioEncodeParamsDecider = new UGCTranscodeAudioEncodeParamsDecider();
        uGCTranscodeAudioEncodeParamsDecider.setInputAudioMediaFormat(this.mAudioFormatList);
        AudioEncodeParams decidedEncodeParams2 = uGCTranscodeAudioEncodeParamsDecider.getDecidedEncodeParams();
        boolean isGopEqualOne = isGopEqualOne(this.mSourcePath);
        LiteavLog.i(TAG, "processVideoInternal: hasIFramePerMinute= " + isGopEqualOne + ", inputFullIFrame= " + isFullIFrame + ",mProcessOutputPath= " + this.mProcessOutputPath);
        TXThumbnailListener tXThumbnailListener = this.mProcessThumbnailListener;
        this.mIsProcessToFullKeyFrame = true;
        this.mIsGenerating = true;
        if (isFullIFrame) {
            tXThumbnailListener = this.mInnerThumbnailListener;
        } else {
            startRecord(this.mProcessOutputPath, decidedEncodeParams, decidedEncodeParams2);
        }
        handleProcessThumbnail(decidedEncodeParams.width, decidedEncodeParams.height, tXThumbnailListener);
    }

    private void startMP4Writer(String str) {
        LiteavLog.i(TAG, "startMP4Writer ".concat(String.valueOf(str)));
        MP4Writer mP4Writer = new MP4Writer();
        this.mMp4Writer = mP4Writer;
        mP4Writer.setListener(this.mMp4WriterListener);
        if (!com.tencent.liteav.videobase.utils.c.a(this.mAudioFormatList) || this.mHasBGM) {
            this.mMp4Writer.setHasAudio(true);
        }
        this.mMp4Writer.setHasVideo(true);
        this.mMp4Writer.setPath(str);
        this.mMp4Writer.start();
    }

    private void startRecord(String str, VideoEncodeParams videoEncodeParams, AudioEncodeParams audioEncodeParams) {
        doStopPlayInner();
        stopMp4Writer();
        startMP4Writer(str);
        this.mIsVideoEncoderStarted = false;
        this.mIsAudioEncoderStarted = false;
        this.mVideoProcessor.setVideoEncodedFrameListener(this.mVideoEncodedFrameListener);
        this.mAudioProcessor.setAudioEncodedFrameListener(this.mAudioEncodedFrameListener);
        this.mAVSyncer.setSyncMode(UGCAVSyncer.SyncMode.INTERLEAVE_OUTPUT_WITHOUT_SKIP);
        this.mAVSyncer.start();
        this.mIsAudioEnd = false;
        this.mIsVideoEnd = false;
        this.mMediaListSource.setVideoSourceRange(this.mCutStartTimeMs, this.mCutEndTimeMs);
        this.mVideoProcessor.setOutputSize(videoEncodeParams.width, videoEncodeParams.height, GLConstants.GLScaleType.FIT_CENTER);
        this.mVideoProcessor.setEncodeParams(videoEncodeParams);
        this.mVideoProcessor.start(true);
        this.mAudioProcessor.setEncodeParams(audioEncodeParams);
        this.mAudioProcessor.start(true);
    }

    private void stopMp4Writer() {
        LiteavLog.i(TAG, "stopMp4Writer");
        MP4Writer mP4Writer = this.mMp4Writer;
        if (mP4Writer != null) {
            mP4Writer.stop();
            this.mMp4Writer = null;
        }
    }

    public void cancel() {
        this.mSequenceTaskRunner.a(av.a(this));
    }

    public void deleteAllEffect() {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mSequenceTaskRunner.a(z.a(this));
        } else {
            LiteavLog.e(TAG, "deleteAllEffect is not supported in UGC_Smart license");
        }
    }

    public void deleteLastEffect() {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mSequenceTaskRunner.a(y.a(this));
        } else {
            LiteavLog.e(TAG, "deleteLastEffect is not supported in UGC_Smart license");
        }
    }

    public void deleteLastTransitionEffect() {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mSequenceTaskRunner.a(u.a(this));
        } else {
            LiteavLog.e(TAG, "deleteLastTransitionEffect is not supported in UGC_Smart license");
        }
    }

    public void generateVideo(int i, String str) {
        if (UGCLicenseChecker.isSimpleFunctionSupport()) {
            this.mSequenceTaskRunner.a(au.a(this, i, str));
            return;
        }
        TXVideoEditConstants.TXGenerateResult tXGenerateResult = new TXVideoEditConstants.TXGenerateResult();
        tXGenerateResult.retCode = -5;
        tXGenerateResult.descMsg = "licence verify failed";
        TXVideoGenerateListener tXVideoGenerateListener = this.mVideoGenerateListener;
        if (tXVideoGenerateListener != null) {
            tXVideoGenerateListener.onGenerateComplete(tXGenerateResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getDuration() {
        return this.mMediaListSource.getDuration();
    }

    public void getThumbnail(int i, int i2, int i3, boolean z, TXThumbnailListener tXThumbnailListener) {
        this.mSequenceTaskRunner.a(ac.a(this, i2, i3, z, i, tXThumbnailListener));
    }

    public void getThumbnail(List<Long> list, int i, int i2, boolean z, TXThumbnailListener tXThumbnailListener) {
        this.mSequenceTaskRunner.a(ab.a(this, list, i, i2, z, tXThumbnailListener));
    }

    public int getThumbnailCount() {
        LiteavLog.i(TAG, "getThumbnailCount");
        if (this.mProcessThumbnailInfo.thumbnailPtsList != null) {
            return this.mProcessThumbnailInfo.thumbnailPtsList.size();
        }
        return 0;
    }

    public String getVideoProcessPath() {
        LiteavLog.i(TAG, "getVideoProcessPath: process output path= " + this.mProcessOutputPath);
        return this.mProcessOutputPath;
    }

    public String getVideoSourcePath() {
        LiteavLog.i(TAG, "getVideoSourcePath: sourcePath= " + this.mSourcePath);
        return this.mSourcePath;
    }

    public void initWithPreview(TXVideoEditConstants.TXPreviewParam tXPreviewParam) {
        if (tXPreviewParam == null) {
            LiteavLog.i(TAG, "initWithPreview param is null.");
            return;
        }
        LiteavLog.i(TAG, "initWithPreview: view= " + tXPreviewParam.videoView + " renderMode= " + tXPreviewParam.renderMode);
        this.mMainHandler.a(aj.a(this, tXPreviewParam), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isHasAudio() {
        return this.mMediaListSource.hasAudioData();
    }

    public void pausePlay() {
        this.mSequenceTaskRunner.a(al.a(this));
    }

    public void previewAtTime(long j) {
        this.mPendingPreviewAtTime.set(Long.valueOf(j));
        this.mSequenceTaskRunner.a(ao.a(this));
    }

    public void processVideo() {
        if (UGCLicenseChecker.isSimpleFunctionSupport()) {
            UGCDataReport.reportDAU(1034);
            this.mSequenceTaskRunner.a(af.a(this));
            return;
        }
        TXVideoEditConstants.TXGenerateResult tXGenerateResult = new TXVideoEditConstants.TXGenerateResult();
        tXGenerateResult.retCode = -5;
        tXGenerateResult.descMsg = "licence verify failed";
        TXVideoProcessListener tXVideoProcessListener = this.mVideoProcessListener;
        if (tXVideoProcessListener != null) {
            tXVideoProcessListener.onProcessComplete(tXGenerateResult);
        }
    }

    public void refreshOneFrame() {
        LiteavLog.i(TAG, "refreshOneFrame");
    }

    public void release() {
        this.mSequenceTaskRunner.a(ag.a(this));
    }

    public void resumePlay() {
        this.mSequenceTaskRunner.a(am.a(this));
    }

    public void setAnimatedPasterList(List<TXVideoEditConstants.TXAnimatedPaster> list) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setAnimatedPasterList is not supported in UGC_Smart license");
            return;
        }
        UGCDataReport.reportDAU(1026);
        this.mSequenceTaskRunner.a(n.a(this, list));
    }

    @Deprecated
    public void setAudioBitrate(int i) {
        this.mSequenceTaskRunner.a(as.a(this, i));
    }

    public int setBGM(String str) {
        int i;
        boolean z;
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setBGM is not supported in UGC_Smart license");
            return 0;
        }
        LiteavLog.i(TAG, "setBGM: path= ".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            LiteavLog.e(TAG, " setBGM: bgm path is empty.");
            i = 0;
            z = true;
        } else {
            i = isBGMValid(str);
            z = false;
        }
        if (i != 0) {
            LiteavLog.i(TAG, " setBGM: check return: ".concat(String.valueOf(i)));
            return i;
        }
        this.mSequenceTaskRunner.a(d.a(this, str, z));
        UGCDataReport.reportDAU(1024);
        return 0;
    }

    public void setBGMAtVideoTime(long j) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mSequenceTaskRunner.a(f.a(this, j));
        } else {
            LiteavLog.e(TAG, "setBGMAtVideoTime is not supported in UGC_Smart license");
        }
    }

    public void setBGMFadeInOutDuration(long j, long j2) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mSequenceTaskRunner.a(i.a(this, j, j2));
        } else {
            LiteavLog.e(TAG, "setBGMFadeInOutDuration is not supported in UGC_Smart license");
        }
    }

    public void setBGMLoop(boolean z) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mSequenceTaskRunner.a(e.a(this, z));
        } else {
            LiteavLog.e(TAG, "setBGMLoop is not supported in UGC_Smart license");
        }
    }

    public void setBGMStartTime(long j, long j2) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mSequenceTaskRunner.a(g.a(this, j, j2));
        } else {
            LiteavLog.e(TAG, "setBGMStartTime is not supported in UGC_Smart license");
        }
    }

    public void setBGMVolume(float f) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mSequenceTaskRunner.a(h.a(this, f));
        } else {
            LiteavLog.e(TAG, "setBGMVolume is not supported in UGC_Smart license");
        }
    }

    public void setBeautyFilter(int i, int i2) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mSequenceTaskRunner.a(bl.a(this, i, i2));
        } else {
            LiteavLog.e(TAG, "setBeautyFilter is not supported in UGC_Smart license");
        }
    }

    public void setCustomVideoProcessListener(TXVideoCustomProcessListener tXVideoCustomProcessListener) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mSequenceTaskRunner.a(x.a(this, tXVideoCustomProcessListener));
        } else {
            LiteavLog.e(TAG, "setCustomVideoProcessListener is not supported in UGC_Smart license");
        }
    }

    public void setCutFromTime(long j, long j2) {
        this.mSequenceTaskRunner.a(aq.a(this, j, j2));
        UGCDataReport.reportDAU(1018);
    }

    public void setFilter(Bitmap bitmap) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setFilter is not supported in UGC_Smart license");
            return;
        }
        UGCDataReport.reportDAU(1023);
        this.mSequenceTaskRunner.a(be.a(this, bitmap));
    }

    public void setFilter(Bitmap bitmap, float f, Bitmap bitmap2, float f2, float f3) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mSequenceTaskRunner.a(bk.a(this, f, f2, f3, bitmap, bitmap2));
        } else {
            LiteavLog.e(TAG, "setFilter is not supported in UGC_Smart license");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setIsFullIFrame(boolean z) {
        this.mIsFullIFrame = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setIsSplitScreen(boolean z) {
        this.mMediaListSource.setIsMediaSourceOverlapped(z);
        if (z) {
            return;
        }
        this.mVideoProcessor.setSplitScreenList(null, -1, -1);
        setOutputSize(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int setMediaSourcePaths(List<String> list) {
        com.tencent.liteav.base.util.n nVar = this.mEncodeResolution;
        if (nVar == null) {
            this.mVideoProcessor.setOutputSize(-1, -1, GLConstants.GLScaleType.FIT_CENTER);
        } else {
            this.mVideoProcessor.setOutputSize(nVar.f22649a, this.mEncodeResolution.b, GLConstants.GLScaleType.FIT_CENTER);
        }
        if (list.size() == 1) {
            this.mThumbnailGenerator.setVideoSourceList(list);
        }
        this.mMediaListSource.setVideoSources(list);
        this.mSourcePath = list.get(0);
        this.mVideoFormatList = new LinkedList();
        this.mAudioFormatList = new LinkedList();
        getAllMediaFormatFromSource(list);
        if (!com.tencent.liteav.videobase.utils.c.a(this.mVideoFormatList)) {
            this.mAVSyncer.setVideoExist(true);
        }
        if (!com.tencent.liteav.videobase.utils.c.a(this.mAudioFormatList)) {
            this.mAVSyncer.setAudioExist(true);
        }
        if (com.tencent.liteav.videobase.utils.c.a(this.mAudioFormatList)) {
            this.mPreviewSyncMode = UGCAVSyncer.SyncMode.VIDEO_MASTER;
            return 0;
        } else if (list.size() > 1) {
            this.mPreviewSyncMode = UGCAVSyncer.SyncMode.CLOCK_MASTER;
            return 0;
        } else {
            this.mPreviewSyncMode = UGCAVSyncer.SyncMode.AUDIO_MASTER;
            return 0;
        }
    }

    protected void setOutputSize(com.tencent.liteav.base.util.n nVar) {
        this.mEncodeResolution = nVar;
    }

    public void setPasterList(List<TXVideoEditConstants.TXPaster> list) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setPasterList is not supported in UGC_Smart license");
            return;
        }
        UGCDataReport.reportDAU(1025);
        this.mSequenceTaskRunner.a(o.a(this, list));
    }

    public int setPictureList(List<Bitmap> list, int i) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setPictureList is not supported in UGC_Smart license");
            return -1;
        }
        UGCDataReport.reportDAU(1030);
        this.mSequenceTaskRunner.a(bm.a(this, i, list));
        return 0;
    }

    public long setPictureTransition(int i) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mSequenceTaskRunner.b(c.a(this, i));
            return this.mMediaListSource.getDuration();
        }
        LiteavLog.e(TAG, "setPictureTransition is not supported in UGC_Smart license");
        return 0L;
    }

    public void setProfile(int i) {
        this.mSequenceTaskRunner.a(ai.a(this, i));
    }

    public void setRenderRotation(int i) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mSequenceTaskRunner.a(p.a(this, i));
        } else {
            LiteavLog.e(TAG, "setRenderRotation is not supported in UGC_Smart license");
        }
    }

    public void setRepeatPlay(List<TXVideoEditConstants.TXRepeat> list) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setRepeatPlay is not supported in UGC_Smart license");
            return;
        }
        UGCDataReport.reportDAU(1020);
        this.mSequenceTaskRunner.a(r.a(this, list));
    }

    public void setReverse(boolean z) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setReverse is not supported in UGC_Smart license");
            return;
        }
        UGCDataReport.reportDAU(1021);
        this.mSequenceTaskRunner.a(s.a(this, z));
    }

    public void setSpecialRatio(float f) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mSequenceTaskRunner.a(at.a(this, f));
        } else {
            LiteavLog.e(TAG, "setSpecialRatio is not supported in UGC_Smart license");
        }
    }

    public void setSpeedList(List<TXVideoEditConstants.TXSpeed> list) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setSpeedList is not supported in UGC_Smart license");
            return;
        }
        UGCDataReport.reportDAU(1019);
        this.mSequenceTaskRunner.a(q.a(this, list));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSplitScreenList(List<TXVideoEditConstants.TXAbsoluteRect> list, int i, int i2) {
        this.mVideoProcessor.setSplitScreenList(list, i, i2);
        setOutputSize(new com.tencent.liteav.base.util.n(i, i2));
    }

    public void setSubtitleList(List<TXVideoEditConstants.TXSubtitle> list) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setSubtitleList is not supported in UGC_Smart license");
            return;
        }
        UGCDataReport.reportDAU(1027);
        this.mSequenceTaskRunner.a(l.a(this, list));
    }

    public void setTXVideoPreviewListener(TXVideoPreviewListener tXVideoPreviewListener) {
        this.mSequenceTaskRunner.a(ah.a(this, tXVideoPreviewListener));
    }

    public void setTailWaterMark(Bitmap bitmap, TXVideoEditConstants.TXRect tXRect, int i) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setTailWaterMark is not supported in UGC_Smart license");
            return;
        }
        UGCDataReport.reportDAU(1029);
        this.mSequenceTaskRunner.a(k.a(this, i, bitmap, tXRect));
    }

    public void setThumbnail(TXVideoEditConstants.TXThumbnail tXThumbnail) {
        this.mSequenceTaskRunner.a(ad.a(this, tXThumbnail));
    }

    public void setThumbnailListener(TXThumbnailListener tXThumbnailListener) {
        this.mSequenceTaskRunner.a(ae.a(this, tXThumbnailListener));
    }

    public boolean setTransitionEffect(int i, long j, long j2) {
        return setTransitionEffect(i, j2, j, 1000L);
    }

    public boolean setTransitionEffect(int i, long j, long j2, long j3) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setTransitionEffect is not supported in UGC_Smart license");
            return false;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.mSequenceTaskRunner.b(t.a(this, i, j2, j3, atomicBoolean));
        return atomicBoolean.get();
    }

    public void setVideoBitrate(int i) {
        this.mSequenceTaskRunner.a(ar.a(this, i));
    }

    public void setVideoGenerateListener(TXVideoGenerateListener tXVideoGenerateListener) {
        this.mSequenceTaskRunner.a(ap.a(this, tXVideoGenerateListener));
    }

    public int setVideoPath(String str) {
        LiteavLog.i(TAG, "setVideoPath ".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        int isMediaSourceValid = isMediaSourceValid(str);
        if (isMediaSourceValid == 0) {
            this.mSequenceTaskRunner.a(m.a(this, str));
            return 0;
        }
        LiteavLog.i(TAG, "setVideoPath " + str + " is illegal." + isMediaSourceValid);
        return isMediaSourceValid;
    }

    public void setVideoProcessListener(TXVideoProcessListener tXVideoProcessListener) {
        this.mSequenceTaskRunner.a(aa.a(this, tXVideoProcessListener));
    }

    public void setVideoVolume(float f) {
        this.mSequenceTaskRunner.a(aw.a(this, f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setVideoVolumes(float[] fArr) {
        this.mAudioProcessor.setVideoVolumes(fArr);
    }

    public void setWaterMark(Bitmap bitmap, TXVideoEditConstants.TXRect tXRect) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setWaterMark is not supported in UGC_Smart license");
            return;
        }
        UGCDataReport.reportDAU(1028);
        this.mSequenceTaskRunner.a(j.a(this, tXRect, bitmap));
    }

    public void startEffect(int i, long j) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "startEffect is not supported in UGC_Smart license");
            return;
        }
        UGCDataReport.reportDAU(1022, i, "");
        this.mSequenceTaskRunner.a(v.a(this, i, j));
    }

    public void startPlayFromTime(long j, long j2) {
        this.mSequenceTaskRunner.a(ak.a(this, j, j2));
    }

    public void stopEffect(int i, long j) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mSequenceTaskRunner.a(w.a(this, i, j));
        } else {
            LiteavLog.e(TAG, "stopEffect is not supported in UGC_Smart license");
        }
    }

    public void stopPlay() {
        this.mSequenceTaskRunner.a(an.a(this));
    }
}
