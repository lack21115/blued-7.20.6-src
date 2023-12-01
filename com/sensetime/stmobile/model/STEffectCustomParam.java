package com.sensetime.stmobile.model;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STEffectCustomParam.class */
public class STEffectCustomParam {
    STQuaternion cameraQuaternion;
    int event;
    boolean isFrontCamera;

    public STEffectCustomParam(STQuaternion sTQuaternion, boolean z, int i) {
        this.cameraQuaternion = sTQuaternion;
        this.event = i;
        this.isFrontCamera = z;
    }

    public STQuaternion getCameraQuaternion() {
        return this.cameraQuaternion;
    }

    public int getEvent() {
        return this.event;
    }

    public boolean isFrontCamera() {
        return this.isFrontCamera;
    }

    public void setCameraQuaternion(STQuaternion sTQuaternion) {
        this.cameraQuaternion = sTQuaternion;
    }

    public void setEvent(int i) {
        this.event = i;
    }

    public void setFrontCamera(boolean z) {
        this.isFrontCamera = z;
    }
}
