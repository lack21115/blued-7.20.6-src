package com.sensetime.stmobile.model;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STStickerInputParams.class */
public class STStickerInputParams {
    float[] cameraQuaternion;
    int customEvent;
    boolean isFrontCamera;
    int quaternionLength;

    public STStickerInputParams(float[] fArr, boolean z, int i) {
        if (fArr != null) {
            this.cameraQuaternion = fArr;
            this.quaternionLength = fArr.length;
        } else {
            this.cameraQuaternion = null;
            this.quaternionLength = 0;
        }
        this.isFrontCamera = z;
        this.customEvent = i;
    }

    public float[] getCameraQuaternion() {
        return this.cameraQuaternion;
    }

    public int getCustomEvent() {
        return this.customEvent;
    }

    public int getQuaternionLength() {
        return this.quaternionLength;
    }

    public boolean isFrontCamera() {
        return this.isFrontCamera;
    }

    public void setCameraQuaternion(float[] fArr) {
        this.cameraQuaternion = fArr;
    }

    public void setCustomEvent(int i) {
        this.customEvent = i;
    }

    public void setFrontCamera(boolean z) {
        this.isFrontCamera = z;
    }

    public void setQuaternionLength(int i) {
        this.quaternionLength = i;
    }
}
