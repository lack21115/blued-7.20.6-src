package com.sensetime.stmobile.model;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STEffectTryonInfo.class */
public class STEffectTryonInfo {
    STColor color;
    float highlight;
    int lipFinishType;
    float midtone;
    float strength;

    public STColor getColor() {
        return this.color;
    }

    public float getHighlight() {
        return this.highlight;
    }

    public int getLipFinishType() {
        return this.lipFinishType;
    }

    public float getMidtone() {
        return this.midtone;
    }

    public float getStrength() {
        return this.strength;
    }

    public void setColor(STColor sTColor) {
        this.color = sTColor;
    }

    public void setHighlight(float f) {
        this.highlight = f;
    }

    public void setLipFinishType(int i) {
        this.lipFinishType = i;
    }

    public void setMidtone(float f) {
        this.midtone = f;
    }

    public void setStrength(float f) {
        this.strength = f;
    }

    public String toString() {
        return "STEffectTryonInfo{color=" + this.color + ", strength=" + this.strength + ", midtone=" + this.midtone + ", highlight=" + this.highlight + ", lipFinishType=" + this.lipFinishType + '}';
    }
}
