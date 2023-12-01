package com.sensetime.stmobile.model;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STMobileFaceInfo.class */
public class STMobileFaceInfo {
    byte[] avatarHelpInfo;
    int avatarHelpInfoLength;
    public STMobileEarInfo earInfo;
    STPoint[] extraFacePoints;
    int extraFacePointsCount;
    STPoint[] eyeballCenter;
    int eyeballCenterPointsCount;
    STPoint[] eyeballContour;
    int eyeballContourPointsCount;
    STMobile106 face106;
    long faceAction;
    float[] faceActionScore;
    int faceActionScoreCount;
    STFaceExtraInfo faceExtraInfo;
    public STFaceMesh faceMesh;
    public STMobileForeheadInfo foreheadInfo;
    public STPoint3f[] gazeDirection;
    public float[] gazeScore;
    public STColor hairColor;
    float leftEyeballScore;
    float rightEyeballScore;
    public int skin_type;
    STPoint[] tonguePoints;
    int tonguePointsCount;
    float[] tonguePointsScore;

    public byte[] getAvatarHelpInfo() {
        return this.avatarHelpInfo;
    }

    public int getAvatarHelpInfoLength() {
        return this.avatarHelpInfoLength;
    }

    public STMobileEarInfo getEarInfo() {
        return this.earInfo;
    }

    public STPoint[] getExtraFacePoints() {
        return this.extraFacePoints;
    }

    public int getExtraFacePointsCount() {
        return this.extraFacePointsCount;
    }

    public STPoint[] getEyeballCenter() {
        return this.eyeballCenter;
    }

    public int getEyeballCenterPointsCount() {
        return this.eyeballCenterPointsCount;
    }

    public STPoint[] getEyeballContour() {
        return this.eyeballContour;
    }

    public int getEyeballContourPointsCount() {
        return this.eyeballContourPointsCount;
    }

    public STMobile106 getFace() {
        return this.face106;
    }

    public STMobile106 getFace106() {
        return this.face106;
    }

    public long getFaceAction() {
        return this.faceAction;
    }

    public float[] getFaceActionScore() {
        return this.faceActionScore;
    }

    public int getFaceActionScoreCount() {
        return this.faceActionScoreCount;
    }

    public STFaceExtraInfo getFaceExtraInfo() {
        return this.faceExtraInfo;
    }

    public STFaceMesh getFaceMesh() {
        return this.faceMesh;
    }

    public STMobileForeheadInfo getForeheadInfo() {
        return this.foreheadInfo;
    }

    public STPoint3f[] getGazeDirection() {
        return this.gazeDirection;
    }

    public float[] getGazeScore() {
        return this.gazeScore;
    }

    public STColor getHairColor() {
        return this.hairColor;
    }

    public float getLeftEyeballScore() {
        return this.leftEyeballScore;
    }

    public float getRightEyeballScore() {
        return this.rightEyeballScore;
    }

    public int getSkinType() {
        return this.skin_type;
    }

    public STPoint[] getTonguePoints() {
        return this.tonguePoints;
    }

    public int getTonguePointsCount() {
        return this.tonguePointsCount;
    }

    public float[] getTonguePointsScore() {
        return this.tonguePointsScore;
    }

    public void setAvatarHelpInfo(byte[] bArr) {
        this.avatarHelpInfo = bArr;
    }

    public void setAvatarHelpInfoLength(int i) {
        this.avatarHelpInfoLength = i;
    }

    public void setEarInfo(STMobileEarInfo sTMobileEarInfo) {
        this.earInfo = sTMobileEarInfo;
    }

    public void setExtraFacePoints(STPoint[] sTPointArr) {
        this.extraFacePoints = sTPointArr;
    }

    public void setExtraFacePointsCount(int i) {
        this.extraFacePointsCount = i;
    }

    public void setEyeballCenter(STPoint[] sTPointArr) {
        this.eyeballCenter = sTPointArr;
    }

    public void setEyeballCenterPointsCount(int i) {
        this.eyeballCenterPointsCount = i;
    }

    public void setEyeballContour(STPoint[] sTPointArr) {
        this.eyeballContour = sTPointArr;
    }

    public void setEyeballContourPointsCount(int i) {
        this.eyeballContourPointsCount = i;
    }

    public void setFace(STMobile106 sTMobile106) {
        this.face106 = sTMobile106;
    }

    public void setFace106(STMobile106 sTMobile106) {
        this.face106 = sTMobile106;
    }

    public void setFaceAction(long j) {
        this.faceAction = j;
    }

    public void setFaceActionScore(float[] fArr) {
        this.faceActionScore = fArr;
    }

    public void setFaceActionScoreCount(int i) {
        this.faceActionScoreCount = i;
    }

    public void setFaceExtraInfo(STFaceExtraInfo sTFaceExtraInfo) {
        this.faceExtraInfo = sTFaceExtraInfo;
    }

    public void setFaceMesh(STFaceMesh sTFaceMesh) {
        this.faceMesh = sTFaceMesh;
    }

    public void setForeheadInfo(STMobileForeheadInfo sTMobileForeheadInfo) {
        this.foreheadInfo = sTMobileForeheadInfo;
    }

    public void setGazeDirection(STPoint3f[] sTPoint3fArr) {
        this.gazeDirection = sTPoint3fArr;
    }

    public void setGazeScore(float[] fArr) {
        this.gazeScore = fArr;
    }

    public void setHairColor(STColor sTColor) {
        this.hairColor = sTColor;
    }

    public void setLeftEyeballScore(float f) {
        this.leftEyeballScore = f;
    }

    public void setRightEyeballScore(float f) {
        this.rightEyeballScore = f;
    }

    public void setSkinType(int i) {
        this.skin_type = i;
    }

    public void setTonguePoints(STPoint[] sTPointArr) {
        this.tonguePoints = sTPointArr;
    }

    public void setTonguePointsCount(int i) {
        this.tonguePointsCount = i;
    }

    public void setTonguePointsScore(float[] fArr) {
        this.tonguePointsScore = fArr;
    }
}
