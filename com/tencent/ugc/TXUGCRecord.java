package com.tencent.ugc;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.ugc.TXVideoEditConstants;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/TXUGCRecord.class */
public class TXUGCRecord {
    private static final String TAG = "TXUGCRecord";
    private static TXUGCRecord instance;
    private UGCRecorderJni mUGCRecorder;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/TXUGCRecord$VideoCustomProcessListener.class */
    public interface VideoCustomProcessListener {
        void onDetectFacePoints(float[] fArr);

        int onTextureCustomProcess(int i, int i2, int i3);

        void onTextureDestroyed();
    }

    protected TXUGCRecord(Context context) {
        this.mUGCRecorder = new UGCRecorderJni(context);
    }

    public static TXUGCRecord getInstance(Context context) {
        TXUGCRecord tXUGCRecord;
        synchronized (TXUGCRecord.class) {
            try {
                if (instance == null) {
                    instance = new TXUGCRecord(context);
                }
                tXUGCRecord = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tXUGCRecord;
    }

    public TXBeautyManager getBeautyManager() {
        return this.mUGCRecorder.getBeautyManager();
    }

    public int getMaxZoom() {
        return this.mUGCRecorder.getMaxZoom();
    }

    public int getMusicDuration(String str) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            return this.mUGCRecorder.getMusicDuration(str);
        }
        LiteavLog.e(TAG, "setBGMVolume is not supported in UGC_Smart license");
        return 0;
    }

    public TXUGCPartsManager getPartsManager() {
        return this.mUGCRecorder.getPartsManager();
    }

    public boolean pauseBGM() {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            return this.mUGCRecorder.pauseBGM();
        }
        LiteavLog.e(TAG, "pauseBGM is not supported in UGC_Smart license");
        return false;
    }

    public int pauseRecord() {
        return this.mUGCRecorder.pauseRecord();
    }

    public boolean playBGMFromTime(int i, int i2) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            return this.mUGCRecorder.playBGMFromTime(i, i2);
        }
        LiteavLog.e(TAG, "playBGMFromTime is not supported in UGC_Smart license");
        return false;
    }

    public void release() {
        this.mUGCRecorder.release();
    }

    public boolean resumeBGM() {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            return this.mUGCRecorder.resumeBGM();
        }
        LiteavLog.e(TAG, "resumeBGM is not supported in UGC_Smart license");
        return false;
    }

    public int resumeRecord() {
        return this.mUGCRecorder.resumeRecord();
    }

    public boolean seekBGM(int i, int i2) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            return this.mUGCRecorder.seekBGM(i, i2);
        }
        LiteavLog.e(TAG, "seekBGM is not supported in UGC_Smart license");
        return false;
    }

    public void setAspectRatio(int i) {
        this.mUGCRecorder.setAspectRatio(i);
    }

    public int setBGM(String str) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            return this.mUGCRecorder.setBGM(str);
        }
        LiteavLog.e(TAG, "setBGM is not supported in UGC_Smart license");
        return -1;
    }

    public void setBGMLoop(boolean z) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mUGCRecorder.setBGMLoop(z);
        } else {
            LiteavLog.e(TAG, "setBGMLoop is not supported in UGC_Smart license");
        }
    }

    public void setBGMNofify(TXRecordCommon.ITXBGMNotify iTXBGMNotify) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mUGCRecorder.setBGMNotify(iTXBGMNotify);
        } else {
            LiteavLog.e(TAG, "setBGMNofify is not supported in UGC_Smart license");
        }
    }

    public boolean setBGMVolume(float f) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            return this.mUGCRecorder.setBGMVolume(f);
        }
        LiteavLog.e(TAG, "setBGMVolume is not supported in UGC_Smart license");
        return false;
    }

    @Deprecated
    public void setBeautyDepth(int i, int i2, int i3, int i4) {
        this.mUGCRecorder.setBeautyDepth(i, i2, i3, i4);
    }

    @Deprecated
    public void setBeautyStyle(int i) {
        this.mUGCRecorder.setBeautyStyle(i);
    }

    @Deprecated
    public void setChinLevel(int i) {
        if (UGCLicenseChecker.isEnterpriseProFunctionSupport()) {
            this.mUGCRecorder.setChinLevel(i);
        } else {
            LiteavLog.e(TAG, "setChinLevel is not supported below enterprise pro license");
        }
    }

    @Deprecated
    public void setEyeScaleLevel(float f) {
        if (UGCLicenseChecker.isEnterpriseProFunctionSupport()) {
            this.mUGCRecorder.setEyeScaleLevel(f);
        } else {
            LiteavLog.e(TAG, "setEyeScaleLevel is not supported below enterprise pro license");
        }
    }

    @Deprecated
    public void setFaceScaleLevel(float f) {
        if (UGCLicenseChecker.isEnterpriseProFunctionSupport()) {
            this.mUGCRecorder.setFaceScaleLevel(f);
        } else {
            LiteavLog.e(TAG, "setFaceScaleLevel is not supported below enterprise pro license");
        }
    }

    @Deprecated
    public void setFaceShortLevel(int i) {
        if (UGCLicenseChecker.isEnterpriseProFunctionSupport()) {
            this.mUGCRecorder.setFaceShortLevel(i);
        } else {
            LiteavLog.e(TAG, "setFaceVLevel is not supported below enterprise pro license");
        }
    }

    @Deprecated
    public void setFaceVLevel(int i) {
        if (UGCLicenseChecker.isEnterpriseProFunctionSupport()) {
            this.mUGCRecorder.setFaceVLevel(i);
        } else {
            LiteavLog.e(TAG, "setFaceVLevel is not supported below enterprise pro license");
        }
    }

    @Deprecated
    public void setFilter(Bitmap bitmap) {
        this.mUGCRecorder.setFilter(bitmap);
    }

    public void setFilter(Bitmap bitmap, float f, Bitmap bitmap2, float f2, float f3) {
        this.mUGCRecorder.setFilter(bitmap, f, bitmap2, f2, f3);
    }

    public void setFocusPosition(float f, float f2) {
        this.mUGCRecorder.setFocusPosition(f, f2);
    }

    @Deprecated
    public void setGreenScreenFile(String str, boolean z) {
        if (UGCLicenseChecker.isEnterpriseProFunctionSupport()) {
            this.mUGCRecorder.setGreenScreenFile(str, z);
        } else {
            LiteavLog.e(TAG, "setGreenScreenFile is not supported below enterprise license");
        }
    }

    public void setHomeOrientation(int i) {
        this.mUGCRecorder.setHomeOrientation(i);
    }

    public boolean setMicVolume(float f) {
        return this.mUGCRecorder.setMicVolume(f);
    }

    @Deprecated
    public void setMotionMute(boolean z) {
        if (UGCLicenseChecker.isEnterpriseFunctionSupport()) {
            this.mUGCRecorder.setMotionMute(z);
        } else {
            LiteavLog.e(TAG, "setMotionMute is not supported below enterprise license");
        }
    }

    @Deprecated
    public void setMotionTmpl(String str) {
        if (UGCLicenseChecker.isEnterpriseFunctionSupport()) {
            this.mUGCRecorder.setMotionTmpl(str);
        } else {
            LiteavLog.e(TAG, "setMotionTmpl is not supported below enterprise license");
        }
    }

    public void setMute(boolean z) {
        this.mUGCRecorder.setMute(z);
    }

    @Deprecated
    public void setNoseSlimLevel(int i) {
        if (UGCLicenseChecker.isEnterpriseProFunctionSupport()) {
            this.mUGCRecorder.setNoseSlimLevel(i);
        } else {
            LiteavLog.e(TAG, "setNoseSlimLevel is not supported below enterprise pro license");
        }
    }

    public void setRecordSpeed(int i) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mUGCRecorder.setRecordSpeed(i);
        } else {
            LiteavLog.e(TAG, "setRecordSpeed is not supported in UGC_Smart license");
        }
    }

    public void setRenderRotation(int i) {
        this.mUGCRecorder.setRenderRotation(i);
    }

    public void setReverb(int i) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mUGCRecorder.setReverb(i);
        } else {
            LiteavLog.e(TAG, "setReverb is not supported in UGC_Smart license");
        }
    }

    @Deprecated
    public void setSpecialRatio(float f) {
        this.mUGCRecorder.setSpecialRatio(f);
    }

    public void setVideoBitrate(int i) {
        this.mUGCRecorder.setVideoBitrate(i);
    }

    public void setVideoProcessListener(VideoCustomProcessListener videoCustomProcessListener) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mUGCRecorder.setVideoProcessListener(videoCustomProcessListener);
        } else {
            LiteavLog.e(TAG, "setVideoProcessListener is not supported in UGC_Smart license");
        }
    }

    public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        this.mUGCRecorder.setVideoRecordListener(iTXVideoRecordListener);
    }

    public void setVideoRenderMode(int i) {
        this.mUGCRecorder.setVideoRenderMode(i);
    }

    public void setVideoResolution(int i) {
        this.mUGCRecorder.setVideoResolution(i);
    }

    public void setVoiceChangerType(int i) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mUGCRecorder.setVoiceChangerType(i);
        } else {
            LiteavLog.e(TAG, "setVoiceChangerType is not supported in UGC_Smart license");
        }
    }

    public void setWatermark(Bitmap bitmap, TXVideoEditConstants.TXRect tXRect) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mUGCRecorder.setWatermark(bitmap, tXRect);
        } else {
            LiteavLog.e(TAG, "setWatermark is not supported in UGC_Smart license");
        }
    }

    public boolean setZoom(int i) {
        return this.mUGCRecorder.setZoom(i);
    }

    public void snapshot(TXRecordCommon.ITXSnapshotListener iTXSnapshotListener) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mUGCRecorder.snapshot(iTXSnapshotListener);
        }
    }

    public int startCameraCustomPreview(TXRecordCommon.TXUGCCustomConfig tXUGCCustomConfig, TXCloudVideoView tXCloudVideoView) {
        return this.mUGCRecorder.startCameraCustomPreview(tXUGCCustomConfig, tXCloudVideoView);
    }

    public int startCameraSimplePreview(TXRecordCommon.TXUGCSimpleConfig tXUGCSimpleConfig, TXCloudVideoView tXCloudVideoView) {
        return this.mUGCRecorder.startCameraSimplePreview(tXUGCSimpleConfig, tXCloudVideoView);
    }

    public int startRecord() {
        if (UGCLicenseChecker.isSimpleFunctionSupport()) {
            return this.mUGCRecorder.startRecord();
        }
        return -5;
    }

    public int startRecord(String str, String str2) {
        if (UGCLicenseChecker.isSimpleFunctionSupport()) {
            return this.mUGCRecorder.startRecord(str, str2);
        }
        return -5;
    }

    public int startRecord(String str, String str2, String str3) {
        if (UGCLicenseChecker.isSimpleFunctionSupport()) {
            return this.mUGCRecorder.startRecord(str, str2, str3);
        }
        return -5;
    }

    public boolean stopBGM() {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            return this.mUGCRecorder.stopBGM();
        }
        LiteavLog.e(TAG, "stopBGM is not supported in UGC_Smart license");
        return false;
    }

    public void stopCameraPreview() {
        this.mUGCRecorder.stopCameraPreview();
    }

    public int stopRecord() {
        return this.mUGCRecorder.stopRecord();
    }

    public boolean switchCamera(boolean z) {
        return this.mUGCRecorder.switchCamera(z);
    }

    public boolean toggleTorch(boolean z) {
        return this.mUGCRecorder.toggleTorch(z);
    }
}
