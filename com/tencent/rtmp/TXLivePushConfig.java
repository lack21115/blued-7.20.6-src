package com.tencent.rtmp;

import android.graphics.Bitmap;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXLivePushConfig.class */
public class TXLivePushConfig implements Serializable {
    public static final int DEFAULT_MAX_VIDEO_BITRATE = 1200;
    public static final int DEFAULT_MIN_VIDEO_BITRATE = 800;
    public int mAudioBitrate;
    public String mAudioPreProcessFuncName;
    public String mAudioPreProcessLibrary;
    public HashMap<String, String> mMetaData;
    public String mVideoPreProcessFuncName;
    public String mVideoPreProcessLibrary;
    public Bitmap mWatermark;
    public int mCustomModeType = 0;
    public int mAudioSample = 48000;
    public int mAudioChannels = 1;
    public int mVideoFPS = 20;
    public TXVideoResolution mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_540_960;
    public int mVideoBitrate = 1200;
    public int mMaxVideoBitrate = 1500;
    public int mMinVideoBitrate = 800;
    public int mBeautyLevel = 0;
    public int mWhiteningLevel = 0;
    public int mRuddyLevel = 0;
    public int mEyeScaleLevel = 0;
    public int mFaceSlimLevel = 0;
    public int mConnectRetryCount = 3;
    public int mConnectRetryInterval = 3;
    public int mWatermarkX = 0;
    public int mWatermarkY = 0;
    public float mWatermarkXF = 0.0f;
    public float mWatermarkYF = 0.0f;
    public float mWatermarkWidth = -1.0f;
    public int mVideoEncodeGop = 3;
    public boolean mVideoEncoderXMirror = false;
    public boolean mEnableHighResolutionCapture = false;
    public boolean mEnableVideoHardEncoderMainProfile = true;
    public boolean mFrontCamera = true;
    public boolean mAutoAdjustBitrate = false;
    public int mAutoAdjustStrategy = 0;
    public int mHardwareAccel = 2;
    public boolean mTouchFocus = true;
    public boolean mEnableZoom = false;
    public int mHomeOrientation = 1;
    public Bitmap mPauseImg = null;
    public int mPauseTime = 300;
    public int mPauseFps = 5;
    public int mPauseFlag = 1;
    public boolean mEnableAec = false;
    public boolean mEnableAgc = false;
    public boolean mEnableAns = false;
    public boolean mEnableAudioPreview = false;
    public boolean mEnableScreenCaptureAutoRotate = false;
    public boolean mEnablePureAudioPush = false;
    public boolean mEnableNearestIP = true;
    public int mVolumeType = 0;
    public int mLocalVideoMirrorType = 0;
    public int mRtmpChannelType = 0;

    public void enableAEC(boolean z) {
        this.mEnableAec = z;
    }

    public void enableAGC(boolean z) {
        this.mEnableAgc = z;
    }

    public void enableANS(boolean z) {
        this.mEnableAns = z;
    }

    public void enableAudioEarMonitoring(boolean z) {
        this.mEnableAudioPreview = z;
    }

    public void enableHighResolutionCaptureMode(boolean z) {
        this.mEnableHighResolutionCapture = z;
    }

    @Deprecated
    public void enableNearestIP(boolean z) {
        this.mEnableNearestIP = z;
    }

    public void enablePureAudioPush(boolean z) {
        this.mEnablePureAudioPush = z;
    }

    public void enableScreenCaptureAutoRotate(boolean z) {
        this.mEnableScreenCaptureAutoRotate = z;
    }

    public void enableVideoHardEncoderMainProfile(boolean z) {
        this.mEnableVideoHardEncoderMainProfile = z;
    }

    public void setAudioChannels(int i) {
        this.mAudioChannels = i;
    }

    public void setAudioSampleRate(int i) {
        this.mAudioSample = i;
    }

    public void setAutoAdjustBitrate(boolean z) {
        this.mAutoAdjustBitrate = z;
    }

    public void setAutoAdjustStrategy(int i) {
        this.mAutoAdjustStrategy = i;
    }

    @Deprecated
    public void setBeautyFilter(int i, int i2, int i3) {
        this.mBeautyLevel = i;
        this.mWhiteningLevel = i2;
        this.mRuddyLevel = i3;
    }

    public void setConnectRetryCount(int i) {
        this.mConnectRetryCount = i;
    }

    public void setConnectRetryInterval(int i) {
        this.mConnectRetryInterval = i;
    }

    public void setCustomAudioPreProcessLibrary(String str, String str2) {
        this.mAudioPreProcessLibrary = str;
        this.mAudioPreProcessFuncName = str2;
    }

    public void setCustomModeType(int i) {
        this.mCustomModeType = i;
    }

    public void setCustomVideoPreProcessLibrary(String str, String str2) {
        this.mVideoPreProcessLibrary = str;
        this.mVideoPreProcessFuncName = str2;
    }

    public void setEnableZoom(boolean z) {
        this.mEnableZoom = z;
    }

    @Deprecated
    public void setEyeScaleLevel(int i) {
        this.mEyeScaleLevel = i;
    }

    @Deprecated
    public void setFaceSlimLevel(int i) {
        this.mFaceSlimLevel = i;
    }

    @Deprecated
    public void setFrontCamera(boolean z) {
        this.mFrontCamera = z;
    }

    public void setHardwareAcceleration(int i) {
        int i2 = i;
        if (i < 0) {
            i2 = 2;
        }
        if (i2 > 2) {
            i2 = 2;
        }
        this.mHardwareAccel = i2;
    }

    public void setHomeOrientation(int i) {
        this.mHomeOrientation = i;
    }

    public void setLocalVideoMirrorType(int i) {
        this.mLocalVideoMirrorType = i;
    }

    public void setMaxVideoBitrate(int i) {
        this.mMaxVideoBitrate = i;
    }

    public void setMetaData(HashMap<String, String> hashMap) {
        this.mMetaData = hashMap;
    }

    public void setMinVideoBitrate(int i) {
        this.mMinVideoBitrate = i;
    }

    public void setPauseFlag(int i) {
        this.mPauseFlag = i;
    }

    public void setPauseImg(int i, int i2) {
        this.mPauseTime = i;
        this.mPauseFps = i2;
    }

    public void setPauseImg(Bitmap bitmap) {
        this.mPauseImg = bitmap;
    }

    @Deprecated
    public void setRtmpChannelType(int i) {
        this.mRtmpChannelType = i;
    }

    public void setTouchFocus(boolean z) {
        this.mTouchFocus = z;
    }

    public void setVideoBitrate(int i) {
        this.mVideoBitrate = i;
    }

    public void setVideoEncodeGop(int i) {
        this.mVideoEncodeGop = i;
    }

    public void setVideoEncoderXMirror(boolean z) {
        this.mVideoEncoderXMirror = z;
    }

    public void setVideoFPS(int i) {
        this.mVideoFPS = i;
    }

    public void setVideoResolution(int i) {
        if (i == 30) {
            this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_1080_1920;
        } else if (i == 31) {
            this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_1920_1080;
        } else {
            switch (i) {
                case 0:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_360_640;
                    return;
                case 1:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_540_960;
                    return;
                case 2:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_720_1280;
                    return;
                case 3:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_640_360;
                    return;
                case 4:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_960_540;
                    return;
                case 5:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_1280_720;
                    return;
                case 6:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_320_480;
                    return;
                case 7:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_180_320;
                    return;
                case 8:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_270_480;
                    return;
                case 9:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_320_180;
                    return;
                case 10:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_480_270;
                    return;
                case 11:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_240_320;
                    return;
                case 12:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_360_480;
                    return;
                case 13:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_480_640;
                    return;
                case 14:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_320_240;
                    return;
                case 15:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_480_360;
                    return;
                case 16:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_640_480;
                    return;
                case 17:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_480_480;
                    return;
                case 18:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_270_270;
                    return;
                case 19:
                    this.mVideoResolution = TXVideoResolution.RESOLUTION_TYPE_160_160;
                    return;
                default:
                    return;
            }
        }
    }

    public void setVolumeType(int i) {
        this.mVolumeType = i;
    }

    public void setWatermark(Bitmap bitmap, float f, float f2, float f3) {
        this.mWatermark = bitmap;
        this.mWatermarkXF = f;
        this.mWatermarkYF = f2;
        this.mWatermarkWidth = f3;
    }

    public void setWatermark(Bitmap bitmap, int i, int i2) {
        this.mWatermark = bitmap;
        this.mWatermarkX = i;
        this.mWatermarkY = i2;
    }

    public String toString() {
        return "[resolution:" + this.mVideoResolution + "][fps:" + this.mVideoFPS + "][gop:" + this.mVideoEncodeGop + "][bitrate:" + this.mVideoBitrate + "][maxBitrate:" + this.mMaxVideoBitrate + "][minBitrate:" + this.mMinVideoBitrate + "][highCapture:" + this.mEnableHighResolutionCapture + "][hwAcc:" + this.mHardwareAccel + "][homeOrientation:" + this.mHomeOrientation + "][volumeType:" + this.mVolumeType + "][earMonitor:" + this.mEnableAudioPreview + "][agc:" + this.mEnableAgc + "][ans:" + this.mEnableAns + "][aec:" + this.mEnableAec + "][sample:" + this.mAudioSample + "][pureAudioPush:" + this.mEnablePureAudioPush + "]";
    }
}
