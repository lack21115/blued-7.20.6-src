package com.sensetime.stmobile.model;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STFaceExtraInfo.class */
public class STFaceExtraInfo {
    float[][] affineMat;
    int modelInputSize;

    public float[][] getAffineMat() {
        return this.affineMat;
    }

    public int getModelInputSize() {
        return this.modelInputSize;
    }

    public void setAffineMat(float[][] fArr) {
        this.affineMat = fArr;
    }

    public void setModelInputSize(int i) {
        this.modelInputSize = i;
    }
}
