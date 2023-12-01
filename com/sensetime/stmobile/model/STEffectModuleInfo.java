package com.sensetime.stmobile.model;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STEffectModuleInfo.class */
public class STEffectModuleInfo {
    int instanceId;
    int moduleId;
    int moduleType;
    public byte[] name;
    int packageId;
    int state;
    float strength;

    public int getInstanceId() {
        return this.instanceId;
    }

    public int getModuleId() {
        return this.moduleId;
    }

    public int getModuleType() {
        return this.moduleType;
    }

    public byte[] getName() {
        return this.name;
    }

    public int getPackageId() {
        return this.packageId;
    }

    public int getState() {
        return this.state;
    }

    public float getStrength() {
        return this.strength;
    }

    public void setInstanceId(int i) {
        this.instanceId = i;
    }

    public void setModuleId(int i) {
        this.moduleId = i;
    }

    public void setModuleType(int i) {
        this.moduleType = i;
    }

    public void setName(byte[] bArr) {
        this.name = bArr;
    }

    public void setPackageId(int i) {
        this.packageId = i;
    }

    public void setState(int i) {
        this.state = i;
    }

    public void setStrength(float f) {
        this.strength = f;
    }
}
