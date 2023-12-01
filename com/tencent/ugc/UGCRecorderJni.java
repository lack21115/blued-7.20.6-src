package com.tencent.ugc;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.blued.das.live.LiveProtos;
import com.sina.weibo.sdk.constant.WBConstants;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.ThreadUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.beauty.TXBeautyManagerImpl;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.ugc.TXUGCRecord;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.datereport.UGCDataReport;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;

@JNINamespace("liteav::ugc")
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCRecorderJni.class */
public class UGCRecorderJni {
    private static final String OUTPUT_DIR_NAME = "TXUGC";
    private static final String OUTPUT_TEMP_DIR_NAME = "TXUGCParts";
    private static final String OUTPUT_VIDEO_COVER_NAME = "TXUGCCover.jpg";
    private static final String OUTPUT_VIDEO_NAME = "TXUGCRecord.mp4";
    private static final String TAG = "UGCRecorderJni";
    private TXRecordCommon.ITXBGMNotify mBGMListener;
    private TXBeautyManager mBeautyManager;
    private Context mContext;
    private String mCoverPath;
    private TXUGCRecord.VideoCustomProcessListener mCustomProcessListener;
    private long mNativeUGCRecorderJni;
    private TXCloudVideoView mPreviewView;
    private RecordParams mRecorderParams = new RecordParams();
    private TXRecordCommon.ITXSnapshotListener mSnapshotListener;
    private TXUGCPartsManager mTXUGCPartsManager;
    private String mVideoFilePath;
    private String mVideoPartFolder;
    private TXRecordCommon.ITXVideoRecordListener mVideoRecordListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCRecorderJni$RecordParams.class */
    public static class RecordParams {

        /* renamed from: a  reason: collision with root package name */
        public int f40205a = LiveProtos.Event.LIVE_BAG_CHAT_MARK_SHOW_VALUE;
        public int b = 960;

        /* renamed from: c  reason: collision with root package name */
        public int f40206c = 20;
        public int d = 1800;
        public int e = 3;
        public boolean f = true;
        public boolean g = false;
        public int h = 5000;
        public int i = 60000;
        public int j = 48000;
        public boolean k = true;
        public int l = 0;

        RecordParams() {
        }

        public int getAudioSampleRate() {
            return this.j;
        }

        public int getMaxDuration() {
            return this.i;
        }

        public int getMinDuration() {
            return this.h;
        }

        public int getVideoBitrate() {
            return this.d;
        }

        public int getVideoFps() {
            return this.f40206c;
        }

        public int getVideoGop() {
            return this.e;
        }

        public int getVideoHeight() {
            return this.b;
        }

        public int getVideoProfile() {
            return this.l;
        }

        public int getVideoWidth() {
            return this.f40205a;
        }

        public boolean isFullIFrame() {
            return this.k;
        }
    }

    static {
        com.tencent.liteav.base.util.o.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public UGCRecorderJni(Context context) {
        this.mNativeUGCRecorderJni = 0L;
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        ContextUtils.initApplicationContext(applicationContext);
        ContextUtils.setDataDirectorySuffix("liteav");
        long nativeCreate = nativeCreate(this);
        this.mNativeUGCRecorderJni = nativeCreate;
        this.mBeautyManager = new TXBeautyManagerImpl(nativeCreateBeautyManager(nativeCreate));
        this.mTXUGCPartsManager = new TXUGCPartsManagerImpl(nativeCreatePartsManager(this.mNativeUGCRecorderJni));
        initFileAndFolder();
    }

    private int checkRecordPath(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            LiteavLog.e(TAG, "startRecord: init videoRecord failed, videoFilePath is empty");
            return -2;
        }
        this.mVideoFilePath = str;
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        if (!TextUtils.isEmpty(str3)) {
            this.mCoverPath = str3;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.mVideoPartFolder = str2;
        }
        File file2 = new File(this.mVideoPartFolder);
        if (file2.exists()) {
            return 0;
        }
        file2.mkdirs();
        return 0;
    }

    private void createThumbFile(String str, String str2) {
        Bitmap sampleImage;
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (sampleImage = TXVideoInfoReader.getInstance(this.mContext).getSampleImage(0L, str)) == null) {
            return;
        }
        try {
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
            try {
                sampleImage.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                com.tencent.liteav.base.util.g.a(fileOutputStream);
            } catch (Exception e) {
                com.tencent.liteav.base.util.g.a(fileOutputStream);
            } catch (Throwable th) {
                th = th;
                com.tencent.liteav.base.util.g.a(fileOutputStream);
                throw th;
            }
        } catch (Exception e2) {
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    private String getDefaultDir() {
        File a2 = com.tencent.liteav.base.util.g.a(this.mContext, OUTPUT_DIR_NAME);
        File file = a2;
        if (a2 == null) {
            file = this.mContext.getFilesDir();
        }
        return file != null ? file.getPath() : "";
    }

    private int getEditBitrateWithSize(int i, int i2) {
        if (i > 640 || i2 > 640) {
            if (i > 960 || i2 > 960) {
                if (i > 1280 || i2 > 1280) {
                    return 12000;
                }
                return com.cdo.oaps.ad.p.j;
            }
            return 5200;
        }
        return 2000;
    }

    private com.tencent.liteav.base.util.n getVideoSize(int i) {
        com.tencent.liteav.base.util.n nVar = new com.tencent.liteav.base.util.n();
        if (i == 0) {
            nVar.f36340a = 360;
            nVar.b = 640;
            return nVar;
        } else if (i == 1) {
            nVar.f36340a = 480;
            nVar.b = 640;
            return nVar;
        } else if (i == 3) {
            nVar.f36340a = UGCTransitionRules.DEFAULT_IMAGE_WIDTH;
            nVar.b = 1280;
            return nVar;
        } else if (i != 4) {
            nVar.f36340a = LiveProtos.Event.LIVE_BAG_CHAT_MARK_SHOW_VALUE;
            nVar.b = 960;
            return nVar;
        } else {
            nVar.f36340a = 1080;
            nVar.b = WBConstants.SDK_NEW_PAY_VERSION;
            return nVar;
        }
    }

    private void initFileAndFolder() {
        String defaultDir = getDefaultDir();
        this.mVideoFilePath = defaultDir + File.separator + OUTPUT_VIDEO_NAME;
        this.mCoverPath = defaultDir + File.separator + OUTPUT_VIDEO_COVER_NAME;
        this.mVideoPartFolder = defaultDir + File.separator + OUTPUT_TEMP_DIR_NAME;
        File file = new File(this.mVideoPartFolder);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(this.mVideoFilePath);
        if (file2.exists()) {
            file2.delete();
        }
    }

    private void initRecorderParams(TXRecordCommon.TXUGCCustomConfig tXUGCCustomConfig) {
        com.tencent.liteav.base.util.n videoSize = getVideoSize(tXUGCCustomConfig.videoResolution);
        if (tXUGCCustomConfig.enableHighResolutionCapture) {
            videoSize.f36340a = 1080;
            videoSize.b = WBConstants.SDK_NEW_PAY_VERSION;
        }
        this.mRecorderParams.f40205a = videoSize.f36340a;
        this.mRecorderParams.b = videoSize.b;
        this.mRecorderParams.d = tXUGCCustomConfig.videoBitrate;
        this.mRecorderParams.f40206c = tXUGCCustomConfig.videoFps;
        this.mRecorderParams.e = tXUGCCustomConfig.videoGop;
        this.mRecorderParams.k = tXUGCCustomConfig.needEdit;
        this.mRecorderParams.f = tXUGCCustomConfig.isFront;
        this.mRecorderParams.g = tXUGCCustomConfig.touchFocus;
        this.mRecorderParams.l = tXUGCCustomConfig.profile;
        this.mRecorderParams.h = tXUGCCustomConfig.minDuration;
        this.mRecorderParams.i = tXUGCCustomConfig.maxDuration;
        this.mRecorderParams.j = tXUGCCustomConfig.audioSampleRate;
        if (tXUGCCustomConfig.needEdit) {
            this.mRecorderParams.e = 1;
            RecordParams recordParams = this.mRecorderParams;
            recordParams.d = getEditBitrateWithSize(recordParams.f40205a, this.mRecorderParams.b);
        }
        int i = tXUGCCustomConfig.videoResolution;
        if (i == 0) {
            UGCDataReport.reportDAU(1044, 360, "360x640");
        } else if (i == 1) {
            UGCDataReport.reportDAU(1045, 480, "480x640");
        } else if (i == 3) {
            UGCDataReport.reportDAU(1046, UGCTransitionRules.DEFAULT_IMAGE_WIDTH, "720x1280");
        } else if (i != 4) {
            UGCDataReport.reportDAU(1045, LiveProtos.Event.LIVE_BAG_CHAT_MARK_SHOW_VALUE, "540x960");
        } else {
            UGCDataReport.reportDAU(1047, 1080, "1080x1920");
        }
        UGCDataReport.reportDAU(1049, tXUGCCustomConfig.videoFps, "");
        UGCDataReport.reportDAU(1050, tXUGCCustomConfig.videoGop, "");
    }

    private void initRecorderParams(TXRecordCommon.TXUGCSimpleConfig tXUGCSimpleConfig) {
        int i = tXUGCSimpleConfig.videoQuality;
        if (i == 0) {
            this.mRecorderParams.f40205a = 360;
            this.mRecorderParams.b = 640;
            this.mRecorderParams.d = 2000;
            UGCDataReport.reportDAU(1044);
        } else if (i == 1) {
            this.mRecorderParams.f40205a = 480;
            this.mRecorderParams.b = 640;
            this.mRecorderParams.d = 3200;
            UGCDataReport.reportDAU(1045);
        } else if (i != 3) {
            this.mRecorderParams.f40205a = LiveProtos.Event.LIVE_BAG_CHAT_MARK_SHOW_VALUE;
            this.mRecorderParams.b = 960;
            this.mRecorderParams.d = 5200;
            UGCDataReport.reportDAU(1045);
        } else {
            this.mRecorderParams.f40205a = UGCTransitionRules.DEFAULT_IMAGE_WIDTH;
            this.mRecorderParams.b = 1280;
            this.mRecorderParams.d = com.cdo.oaps.ad.p.j;
            UGCDataReport.reportDAU(1046);
        }
        UGCDataReport.reportDAU(1048, this.mRecorderParams.d, "");
        this.mRecorderParams.f40206c = 30;
        this.mRecorderParams.k = tXUGCSimpleConfig.needEdit;
        this.mRecorderParams.f = tXUGCSimpleConfig.isFront;
        this.mRecorderParams.g = tXUGCSimpleConfig.touchFocus;
        this.mRecorderParams.l = tXUGCSimpleConfig.profile;
        this.mRecorderParams.h = tXUGCSimpleConfig.minDuration;
        this.mRecorderParams.i = tXUGCSimpleConfig.maxDuration;
        if (tXUGCSimpleConfig.needEdit) {
            this.mRecorderParams.e = 1;
            RecordParams recordParams = this.mRecorderParams;
            recordParams.d = getEditBitrateWithSize(recordParams.f40205a, this.mRecorderParams.b);
        }
        UGCDataReport.reportDAU(1049, this.mRecorderParams.f40206c, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onRecordComplete$1(int i, String str, String str2, String str3, TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        TXRecordCommon.TXRecordResult tXRecordResult = new TXRecordCommon.TXRecordResult();
        tXRecordResult.retCode = i;
        tXRecordResult.descMsg = str;
        tXRecordResult.videoPath = str2;
        tXRecordResult.coverPath = str3;
        iTXVideoRecordListener.onRecordComplete(tXRecordResult);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setFocusPosition$0(UGCRecorderJni uGCRecorderJni, float f, float f2) {
        try {
            Method declaredMethod = TXCloudVideoView.class.getDeclaredMethod("showIndicatorView", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            declaredMethod.setAccessible(true);
            TXCloudVideoView tXCloudVideoView = uGCRecorderJni.mPreviewView;
            if (tXCloudVideoView != null) {
                declaredMethod.invoke(tXCloudVideoView, Integer.valueOf((int) f), Integer.valueOf((int) f2), Integer.valueOf(tXCloudVideoView.getWidth()), Integer.valueOf(tXCloudVideoView.getHeight()));
            }
        } catch (Exception e) {
            LiteavLog.w(TAG, " showIndicatorView ".concat(String.valueOf(e)));
        }
    }

    private static native long nativeCreate(UGCRecorderJni uGCRecorderJni);

    private static native long nativeCreateBeautyManager(long j);

    private static native long nativeCreatePartsManager(long j);

    private static native void nativeDestroy(long j);

    private static native void nativeEnableBGMNotify(long j, boolean z);

    private static native void nativeEnableCameraAutoFocus(long j, boolean z);

    private static native void nativeEnableVideoCustomPreprocess(long j, boolean z);

    private static native int nativeGetMusicDuration(long j, String str);

    private static native int nativeGetZoomLevel(long j);

    private static native boolean nativePauseBGM(long j);

    private static native int nativePauseRecord(long j);

    private static native boolean nativePlayBGM(long j, int i, int i2);

    private static native boolean nativeResumeBGM(long j);

    private static native int nativeResumeRecord(long j);

    private static native void nativeSetAspectRatio(long j, int i);

    private static native void nativeSetBGMLoop(long j, boolean z);

    private static native int nativeSetBGMPath(long j, String str);

    private static native boolean nativeSetBGMVolume(long j, int i);

    private static native void nativeSetFilter(long j, Bitmap bitmap, float f, Bitmap bitmap2, float f2, float f3);

    private static native void nativeSetFocusPosition(long j, float f, float f2);

    private static native void nativeSetHomeOrientation(long j, int i);

    private static native void nativeSetMicVolume(long j, int i);

    public static native void nativeSetMute(long j, boolean z);

    private static native void nativeSetRecordParams(long j, RecordParams recordParams);

    private static native void nativeSetRecordSpeed(long j, int i);

    private static native void nativeSetRenderMode(long j, int i);

    private static native void nativeSetRenderRotation(long j, int i);

    private static native void nativeSetReverbType(long j, int i);

    private static native void nativeSetView(long j, DisplayTarget displayTarget);

    private static native void nativeSetVoiceChangerType(long j, int i);

    private static native void nativeSetWatermark(long j, Bitmap bitmap, float f, float f2, float f3);

    private static native boolean nativeSetZoomLevel(long j, int i);

    private static native void nativeSnapshot(long j);

    private static native void nativeStartCamera(long j, boolean z);

    private static native int nativeStartRecord(long j, String str, String str2, String str3);

    private static native boolean nativeStopBGM(long j);

    private static native void nativeStopCamera(long j);

    private static native int nativeStopRecord(long j);

    private static native boolean nativeSwitchCamera(long j, boolean z);

    private static native boolean nativeTurnOnTorch(long j, boolean z);

    protected void finalize() throws Throwable {
        super.finalize();
        long j = this.mNativeUGCRecorderJni;
        if (j != 0) {
            nativeDestroy(j);
            this.mNativeUGCRecorderJni = 0L;
        }
    }

    public TXBeautyManager getBeautyManager() {
        return this.mBeautyManager;
    }

    public int getMaxZoom() {
        return nativeGetZoomLevel(this.mNativeUGCRecorderJni);
    }

    public int getMusicDuration(String str) {
        long j = this.mNativeUGCRecorderJni;
        if (str == null) {
            str = "";
        }
        return nativeGetMusicDuration(j, str);
    }

    public TXUGCPartsManager getPartsManager() {
        return this.mTXUGCPartsManager;
    }

    public void onBGMComplete(int i) {
        TXRecordCommon.ITXBGMNotify iTXBGMNotify = this.mBGMListener;
        if (iTXBGMNotify != null) {
            iTXBGMNotify.onBGMComplete(i);
        }
    }

    public void onBGMProgress(long j, long j2) {
        TXRecordCommon.ITXBGMNotify iTXBGMNotify = this.mBGMListener;
        if (iTXBGMNotify != null) {
            iTXBGMNotify.onBGMProgress(j, j2);
        }
    }

    public void onBGMStart() {
        TXRecordCommon.ITXBGMNotify iTXBGMNotify = this.mBGMListener;
        if (iTXBGMNotify != null) {
            iTXBGMNotify.onBGMStart();
        }
    }

    public void onDetectFacePoints(float[] fArr) {
        TXUGCRecord.VideoCustomProcessListener videoCustomProcessListener = this.mCustomProcessListener;
        if (videoCustomProcessListener != null) {
            videoCustomProcessListener.onDetectFacePoints(fArr);
        }
    }

    public void onGLContextDestroy() {
        TXUGCRecord.VideoCustomProcessListener videoCustomProcessListener = this.mCustomProcessListener;
        if (videoCustomProcessListener != null) {
            videoCustomProcessListener.onTextureDestroyed();
        }
    }

    public boolean onPreprocessVideoFrame(PixelFrame pixelFrame, PixelFrame pixelFrame2) {
        int onTextureCustomProcess;
        TXUGCRecord.VideoCustomProcessListener videoCustomProcessListener = this.mCustomProcessListener;
        if (videoCustomProcessListener == null || (onTextureCustomProcess = videoCustomProcessListener.onTextureCustomProcess(pixelFrame.getTextureId(), pixelFrame.getWidth(), pixelFrame.getHeight())) < 0) {
            return false;
        }
        pixelFrame2.setTextureId(onTextureCustomProcess);
        return true;
    }

    public void onRecordComplete(int i, String str, String str2, String str3) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            createThumbFile(str2, str3);
            ThreadUtils.getUiThreadHandler().post(ef.a(i, str, str2, str3, iTXVideoRecordListener));
        }
    }

    public void onRecordEvent(int i) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            iTXVideoRecordListener.onRecordEvent(i, new Bundle());
        }
    }

    public void onRecordProgress(long j) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            iTXVideoRecordListener.onRecordProgress(j);
        }
    }

    public void onSnapshot(Bitmap bitmap) {
        TXRecordCommon.ITXSnapshotListener iTXSnapshotListener = this.mSnapshotListener;
        if (iTXSnapshotListener != null) {
            iTXSnapshotListener.onSnapshot(bitmap);
        }
    }

    public boolean pauseBGM() {
        return nativePauseBGM(this.mNativeUGCRecorderJni);
    }

    public int pauseRecord() {
        return nativePauseRecord(this.mNativeUGCRecorderJni);
    }

    public boolean playBGMFromTime(int i, int i2) {
        UGCDataReport.reportDAU(1008);
        return nativePlayBGM(this.mNativeUGCRecorderJni, i, i2);
    }

    public void release() {
        setVoiceChangerType(0);
        setReverb(0);
        setRecordSpeed(2);
        stopBGM();
        stopCameraPreview();
        stopRecord();
    }

    public boolean resumeBGM() {
        return nativeResumeBGM(this.mNativeUGCRecorderJni);
    }

    public int resumeRecord() {
        return nativeResumeRecord(this.mNativeUGCRecorderJni);
    }

    public boolean seekBGM(int i, int i2) {
        return nativePlayBGM(this.mNativeUGCRecorderJni, i, i2);
    }

    public void setAspectRatio(int i) {
        nativeSetAspectRatio(this.mNativeUGCRecorderJni, i);
        if (i == 0) {
            UGCDataReport.reportDAU(1055);
        } else if (i == 1) {
            UGCDataReport.reportDAU(1042);
        } else if (i == 2) {
            UGCDataReport.reportDAU(1041);
        } else if (i == 3) {
            UGCDataReport.reportDAU(1043);
        } else if (i == 4) {
            UGCDataReport.reportDAU(1056);
        }
    }

    public int setBGM(String str) {
        UGCDataReport.reportDAU(1052);
        long j = this.mNativeUGCRecorderJni;
        if (str == null) {
            str = "";
        }
        return nativeSetBGMPath(j, str);
    }

    public void setBGMLoop(boolean z) {
        nativeSetBGMLoop(this.mNativeUGCRecorderJni, z);
    }

    public void setBGMNotify(TXRecordCommon.ITXBGMNotify iTXBGMNotify) {
        this.mBGMListener = iTXBGMNotify;
        nativeEnableBGMNotify(this.mNativeUGCRecorderJni, iTXBGMNotify != null);
    }

    public boolean setBGMVolume(float f) {
        return nativeSetBGMVolume(this.mNativeUGCRecorderJni, (int) (f * 100.0f));
    }

    public void setBeautyDepth(int i, int i2, int i3, int i4) {
        this.mBeautyManager.setBeautyStyle(i);
        this.mBeautyManager.setBeautyLevel(i2);
        this.mBeautyManager.setWhitenessLevel(i3);
        this.mBeautyManager.setRuddyLevel(i4);
    }

    public void setBeautyStyle(int i) {
        this.mBeautyManager.setBeautyStyle(i);
    }

    public void setChinLevel(int i) {
        this.mBeautyManager.setChinLevel(i);
    }

    public void setEyeScaleLevel(float f) {
        this.mBeautyManager.setEyeScaleLevel(f);
    }

    public void setFaceScaleLevel(float f) {
        this.mBeautyManager.setFaceSlimLevel(f);
    }

    public void setFaceShortLevel(int i) {
        this.mBeautyManager.setFaceShortLevel(i);
    }

    public void setFaceVLevel(int i) {
        this.mBeautyManager.setFaceVLevel(i);
    }

    public void setFilter(Bitmap bitmap) {
        this.mBeautyManager.setFilter(bitmap);
    }

    public void setFilter(Bitmap bitmap, float f, Bitmap bitmap2, float f2, float f3) {
        nativeSetFilter(this.mNativeUGCRecorderJni, bitmap, f, bitmap2, f2, f3);
    }

    public void setFocusPosition(float f, float f2) {
        if (this.mRecorderParams.g) {
            nativeSetFocusPosition(this.mNativeUGCRecorderJni, f, f2);
            ThreadUtils.getUiThreadHandler().postDelayed(ee.a(this, f, f2), 100L);
        }
    }

    public void setGreenScreenFile(String str, boolean z) {
        TXBeautyManager tXBeautyManager = this.mBeautyManager;
        if (str == null) {
            str = "";
        }
        tXBeautyManager.setGreenScreenFile(str);
    }

    public void setHomeOrientation(int i) {
        nativeSetHomeOrientation(this.mNativeUGCRecorderJni, i);
    }

    public boolean setMicVolume(float f) {
        nativeSetMicVolume(this.mNativeUGCRecorderJni, (int) (f * 100.0f));
        return true;
    }

    public void setMotionMute(boolean z) {
        this.mBeautyManager.setMotionMute(z);
    }

    public void setMotionTmpl(String str) {
        TXBeautyManager tXBeautyManager = this.mBeautyManager;
        if (str == null) {
            str = "";
        }
        tXBeautyManager.setMotionTmpl(str);
    }

    public void setMute(boolean z) {
        nativeSetMute(this.mNativeUGCRecorderJni, z);
    }

    public void setNoseSlimLevel(int i) {
        this.mBeautyManager.setNoseSlimLevel(i);
    }

    public void setRecordSpeed(int i) {
        nativeSetRecordSpeed(this.mNativeUGCRecorderJni, i);
        if (i == 0) {
            UGCDataReport.reportDAU(1051, i, "SLOWEST");
        } else if (i == 1) {
            UGCDataReport.reportDAU(1051, i, "SLOW");
        } else if (i == 2) {
            UGCDataReport.reportDAU(1051, i, "NORMAL");
        } else if (i == 3) {
            UGCDataReport.reportDAU(1051, i, "FAST");
        } else if (i != 4) {
        } else {
            UGCDataReport.reportDAU(1051, i, "FASTEST");
        }
    }

    public void setRenderRotation(int i) {
        nativeSetRenderRotation(this.mNativeUGCRecorderJni, i);
    }

    public void setReverb(int i) {
        nativeSetReverbType(this.mNativeUGCRecorderJni, i);
        UGCDataReport.reportDAU(1054, i, "");
        UGCDataReport.reportDAU(1007);
    }

    public void setSpecialRatio(float f) {
        this.mBeautyManager.setFilterStrength(f);
    }

    public void setVideoBitrate(int i) {
        this.mRecorderParams.d = i;
        nativeSetRecordParams(this.mNativeUGCRecorderJni, this.mRecorderParams);
    }

    public void setVideoProcessListener(TXUGCRecord.VideoCustomProcessListener videoCustomProcessListener) {
        this.mCustomProcessListener = videoCustomProcessListener;
        nativeEnableVideoCustomPreprocess(this.mNativeUGCRecorderJni, videoCustomProcessListener != null);
    }

    public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        this.mVideoRecordListener = iTXVideoRecordListener;
    }

    public void setVideoRenderMode(int i) {
        nativeSetRenderMode(this.mNativeUGCRecorderJni, i);
    }

    public void setVideoResolution(int i) {
        com.tencent.liteav.base.util.n videoSize = getVideoSize(i);
        this.mRecorderParams.f40205a = videoSize.f36340a;
        this.mRecorderParams.b = videoSize.b;
        nativeSetRecordParams(this.mNativeUGCRecorderJni, this.mRecorderParams);
    }

    public void setVoiceChangerType(int i) {
        nativeSetVoiceChangerType(this.mNativeUGCRecorderJni, i);
        UGCDataReport.reportDAU(1053, i, "");
    }

    public void setWatermark(Bitmap bitmap, TXVideoEditConstants.TXRect tXRect) {
        nativeSetWatermark(this.mNativeUGCRecorderJni, bitmap, tXRect.x, tXRect.y, tXRect.width);
    }

    public boolean setZoom(int i) {
        return nativeSetZoomLevel(this.mNativeUGCRecorderJni, i);
    }

    public void snapshot(TXRecordCommon.ITXSnapshotListener iTXSnapshotListener) {
        this.mSnapshotListener = iTXSnapshotListener;
        nativeSnapshot(this.mNativeUGCRecorderJni);
    }

    public int startCameraCustomPreview(TXRecordCommon.TXUGCCustomConfig tXUGCCustomConfig, TXCloudVideoView tXCloudVideoView) {
        initRecorderParams(tXUGCCustomConfig);
        nativeSetRecordParams(this.mNativeUGCRecorderJni, this.mRecorderParams);
        nativeSetView(this.mNativeUGCRecorderJni, new DisplayTarget(tXCloudVideoView));
        boolean z = true;
        nativeEnableCameraAutoFocus(this.mNativeUGCRecorderJni, !this.mRecorderParams.g);
        nativeStartCamera(this.mNativeUGCRecorderJni, this.mRecorderParams.f);
        long j = this.mNativeUGCRecorderJni;
        if (this.mCustomProcessListener == null) {
            z = false;
        }
        nativeEnableVideoCustomPreprocess(j, z);
        if (tXUGCCustomConfig.watermark != null) {
            nativeSetWatermark(this.mNativeUGCRecorderJni, tXUGCCustomConfig.watermark, tXUGCCustomConfig.watermarkX, tXUGCCustomConfig.watermarkY, tXUGCCustomConfig.watermark.getWidth());
        }
        this.mPreviewView = tXCloudVideoView;
        return 0;
    }

    public int startCameraSimplePreview(TXRecordCommon.TXUGCSimpleConfig tXUGCSimpleConfig, TXCloudVideoView tXCloudVideoView) {
        initRecorderParams(tXUGCSimpleConfig);
        nativeSetRecordParams(this.mNativeUGCRecorderJni, this.mRecorderParams);
        nativeSetView(this.mNativeUGCRecorderJni, new DisplayTarget(tXCloudVideoView));
        boolean z = true;
        nativeEnableCameraAutoFocus(this.mNativeUGCRecorderJni, !this.mRecorderParams.g);
        nativeStartCamera(this.mNativeUGCRecorderJni, this.mRecorderParams.f);
        long j = this.mNativeUGCRecorderJni;
        if (this.mCustomProcessListener == null) {
            z = false;
        }
        nativeEnableVideoCustomPreprocess(j, z);
        if (tXUGCSimpleConfig.watermark != null) {
            nativeSetWatermark(this.mNativeUGCRecorderJni, tXUGCSimpleConfig.watermark, tXUGCSimpleConfig.watermarkX, tXUGCSimpleConfig.watermarkY, tXUGCSimpleConfig.watermark.getWidth());
        }
        this.mPreviewView = tXCloudVideoView;
        return 0;
    }

    public int startRecord() {
        UGCDataReport.reportDAU(1002);
        return nativeStartRecord(this.mNativeUGCRecorderJni, this.mVideoFilePath, this.mVideoPartFolder, this.mCoverPath);
    }

    public int startRecord(String str, String str2) {
        int checkRecordPath = checkRecordPath(str, this.mVideoPartFolder, str2);
        return checkRecordPath != 0 ? checkRecordPath : nativeStartRecord(this.mNativeUGCRecorderJni, this.mVideoFilePath, this.mVideoPartFolder, this.mCoverPath);
    }

    public int startRecord(String str, String str2, String str3) {
        int checkRecordPath = checkRecordPath(str, str2, str3);
        return checkRecordPath != 0 ? checkRecordPath : nativeStartRecord(this.mNativeUGCRecorderJni, this.mVideoFilePath, this.mVideoPartFolder, this.mCoverPath);
    }

    public boolean stopBGM() {
        return nativeStopBGM(this.mNativeUGCRecorderJni);
    }

    public void stopCameraPreview() {
        nativeStopCamera(this.mNativeUGCRecorderJni);
        this.mPreviewView = null;
    }

    public int stopRecord() {
        return nativeStopRecord(this.mNativeUGCRecorderJni);
    }

    public boolean switchCamera(boolean z) {
        return nativeSwitchCamera(this.mNativeUGCRecorderJni, z);
    }

    public boolean toggleTorch(boolean z) {
        return nativeTurnOnTorch(this.mNativeUGCRecorderJni, z);
    }
}
