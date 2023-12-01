package com.baidu.aip;

import java.io.Serializable;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/FaceConfig.class */
public class FaceConfig implements Serializable {
    private static final String TAG = FaceConfig.class.getSimpleName();
    public float brightnessValue = 40.0f;
    public float blurnessValue = 0.7f;
    public float occlusionValue = 0.5f;
    public int headPitchValue = 10;
    public int headYawValue = 10;
    public int headRollValue = 10;
    public int cropFaceValue = 400;
    public int minFaceSize = 200;
    public float notFaceValue = 0.6f;
    public int maxCropImageNum = 1;
    public boolean isCheckFaceQuality = true;
    public boolean isSound = true;
    public boolean isVerifyLive = true;
    public int faceDecodeNumberOfThreads = 0;
    public boolean isLivenessRandom = false;
    public int livenessRandomCount = 3;

    public float getBlurnessValue() {
        return this.blurnessValue;
    }

    public float getBrightnessValue() {
        return this.brightnessValue;
    }

    public int getCropFaceValue() {
        return this.cropFaceValue;
    }

    public int getFaceDecodeNumberOfThreads() {
        return this.faceDecodeNumberOfThreads;
    }

    public int getHeadPitchValue() {
        return this.headPitchValue;
    }

    public int getHeadRollValue() {
        return this.headRollValue;
    }

    public int getHeadYawValue() {
        return this.headYawValue;
    }

    public int getMaxCropImageNum() {
        return this.maxCropImageNum;
    }

    public int getMinFaceSize() {
        return this.minFaceSize;
    }

    public float getNotFaceValue() {
        return this.notFaceValue;
    }

    public float getOcclusionValue() {
        return this.occlusionValue;
    }

    public boolean isCheckFaceQuality() {
        return this.isCheckFaceQuality;
    }

    public boolean isLivenessRandom() {
        return this.isLivenessRandom;
    }

    public boolean isSound() {
        return this.isSound;
    }

    public boolean isVerifyLive() {
        return this.isVerifyLive;
    }

    public void setBlurnessValue(float f) {
        this.blurnessValue = f;
    }

    public void setBrightnessValue(float f) {
        this.brightnessValue = f;
    }

    public void setCheckFaceQuality(boolean z) {
        this.isCheckFaceQuality = z;
    }

    public void setCropFaceValue(int i) {
        this.cropFaceValue = i;
    }

    public void setFaceDecodeNumberOfThreads(int i) {
        this.faceDecodeNumberOfThreads = i;
    }

    public void setHeadPitchValue(int i) {
        this.headPitchValue = i;
    }

    public void setHeadRollValue(int i) {
        this.headRollValue = i;
    }

    public void setHeadYawValue(int i) {
        this.headYawValue = i;
    }

    public void setLivenessRandom(boolean z) {
        this.isLivenessRandom = z;
    }

    public void setMaxCropImageNum(int i) {
        this.maxCropImageNum = i;
    }

    public void setMinFaceSize(int i) {
        this.minFaceSize = i;
    }

    public void setNotFaceValue(float f) {
        this.notFaceValue = f;
    }

    public void setOcclusionValue(float f) {
        this.occlusionValue = f;
    }

    public void setSound(boolean z) {
        this.isSound = z;
    }

    public void setVerifyLive(boolean z) {
        this.isVerifyLive = z;
    }
}
