package com.sensetime.stmobile.model;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STMobileHandInfo.class */
public class STMobileHandInfo {
    STHandDynamicGesture dynamicGesture;
    STPoint[] extra2dKeyPoints;
    int extra2dKeyPointsCount;
    STPoint3f[] extra3dKeyPoints;
    int extra3dKeyPointsCount;
    STPoint[] gestureKeyPoints;
    int gestureKeyPointsCount;
    long handAction;
    float handActionScore;
    int handId;
    STRect handRect;
    STPoint[] keyPoints;
    int keyPointsCount;
    int left_right;

    public STHandDynamicGesture getDynamicGesture() {
        return this.dynamicGesture;
    }

    public STPoint[] getExtra2dKeyPoints() {
        return this.extra2dKeyPoints;
    }

    public int getExtra2dKeyPointsCount() {
        return this.extra2dKeyPointsCount;
    }

    public STPoint3f[] getExtra3dKeyPoints() {
        return this.extra3dKeyPoints;
    }

    public int getExtra3dKeyPointsCount() {
        return this.extra3dKeyPointsCount;
    }

    public STPoint[] getGestureKeyPoints() {
        return this.gestureKeyPoints;
    }

    public int getGestureKeyPointsCount() {
        return this.gestureKeyPointsCount;
    }

    public long getHandAction() {
        return this.handAction;
    }

    public float getHandActionScore() {
        return this.handActionScore;
    }

    public int getHandId() {
        return this.handId;
    }

    public STRect getHandRect() {
        return this.handRect;
    }

    public STPoint[] getKeyPoints() {
        return this.keyPoints;
    }

    public int getKeyPointsCount() {
        return this.keyPointsCount;
    }

    public int getLeft_right() {
        return this.left_right;
    }

    public void setDynamicGesture(STHandDynamicGesture sTHandDynamicGesture) {
        this.dynamicGesture = sTHandDynamicGesture;
    }

    public void setExtra2dKeyPoints(STPoint[] sTPointArr) {
        this.extra2dKeyPoints = sTPointArr;
    }

    public void setExtra2dKeyPointsCount(int i) {
        this.extra2dKeyPointsCount = i;
    }

    public void setExtra3dKeyPoints(STPoint3f[] sTPoint3fArr) {
        this.extra3dKeyPoints = sTPoint3fArr;
    }

    public void setExtra3dKeyPointsCount(int i) {
        this.extra3dKeyPointsCount = i;
    }

    public void setGestureKeyPoints(STPoint[] sTPointArr) {
        this.gestureKeyPoints = sTPointArr;
    }

    public void setGestureKeyPointsCount(int i) {
        this.gestureKeyPointsCount = i;
    }

    public void setHandAction(long j) {
        this.handAction = j;
    }

    public void setHandActionScore(float f) {
        this.handActionScore = f;
    }

    public void setHandId(int i) {
        this.handId = i;
    }

    public void setHandRect(STRect sTRect) {
        this.handRect = sTRect;
    }

    public void setKeyPoints(STPoint[] sTPointArr) {
        this.keyPoints = sTPointArr;
    }

    public void setKeyPointsCount(int i) {
        this.keyPointsCount = i;
    }

    public void setLeft_right(int i) {
        this.left_right = i;
    }
}
