package com.sensetime.stmobile.model;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STEffectBeautyInfo.class */
public class STEffectBeautyInfo {
    int mode;
    byte[] name = new byte[256];
    float strength;
    int type;

    public int getMode() {
        return this.mode;
    }

    public byte[] getName() {
        return this.name;
    }

    public float getStrength() {
        return this.strength;
    }

    public int getType() {
        return this.type;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public void setName(byte[] bArr) {
        this.name = bArr;
    }

    public void setStrength(float f) {
        this.strength = f;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String toString() {
        return "STEffectBeautyInfo{type=" + this.type + ", mode=" + this.mode + ", strength=" + this.strength + '}';
    }
}
