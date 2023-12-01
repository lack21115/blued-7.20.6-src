package com.sensetime.stmobile.model;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STMobileBodyInfo.class */
public class STMobileBodyInfo {
    long bodyAction;
    float bodyActionScore;
    STPoint[] contourPoints;
    int contourPointsCount;
    float[] contourPointsScore;
    int[] handValid;
    int id;
    STPoint[] keyPoints;
    STPoint3f[] keyPoints3d;
    int keyPoints3dCount;
    float[] keyPoints3dScore;
    int keyPointsCount;
    float[] keyPointsScore;
    int label;

    public long getBodyAction() {
        return this.bodyAction;
    }

    public float getBodyActionScore() {
        return this.bodyActionScore;
    }

    public STPoint[] getContourPoints() {
        return this.contourPoints;
    }

    public int getContourPointsCount() {
        return this.contourPointsCount;
    }

    public float[] getContourPointsScore() {
        return this.contourPointsScore;
    }

    public int[] getHandValid() {
        return this.handValid;
    }

    public int getId() {
        return this.id;
    }

    public STPoint[] getKeyPoints() {
        return this.keyPoints;
    }

    public STPoint3f[] getKeyPoints3d() {
        return this.keyPoints3d;
    }

    public int getKeyPoints3dCount() {
        return this.keyPoints3dCount;
    }

    public float[] getKeyPoints3dScore() {
        return this.keyPoints3dScore;
    }

    public int getKeyPointsCount() {
        return this.keyPointsCount;
    }

    public float[] getKeyPointsScore() {
        return this.keyPointsScore;
    }

    public int getLabel() {
        return this.label;
    }

    public void setBodyAction(long j) {
        this.bodyAction = j;
    }

    public void setBodyActionScore(float f) {
        this.bodyActionScore = f;
    }

    public void setContourPoints(STPoint[] sTPointArr) {
        this.contourPoints = sTPointArr;
    }

    public void setContourPointsCount(int i) {
        this.contourPointsCount = i;
    }

    public void setContourPointsScore(float[] fArr) {
        this.contourPointsScore = fArr;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setKeyPoints(STPoint[] sTPointArr) {
        this.keyPoints = sTPointArr;
    }

    public void setKeyPointsCount(int i) {
        this.keyPointsCount = i;
    }

    public void setKeyPointsScore(float[] fArr) {
        this.keyPointsScore = fArr;
    }
}
