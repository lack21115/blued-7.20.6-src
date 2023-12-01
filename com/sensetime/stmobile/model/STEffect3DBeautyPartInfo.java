package com.sensetime.stmobile.model;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STEffect3DBeautyPartInfo.class */
public class STEffect3DBeautyPartInfo {
    private byte[] name = new byte[256];
    private int part_id;
    private float strength;
    private float strength_max;
    private float strength_min;

    public byte[] getName() {
        return this.name;
    }

    public int getPart_id() {
        return this.part_id;
    }

    public float getStrength() {
        return this.strength;
    }

    public float getStrength_max() {
        return this.strength_max;
    }

    public float getStrength_min() {
        return this.strength_min;
    }

    public void setName(byte[] bArr) {
        this.name = bArr;
    }

    public void setPart_id(int i) {
        this.part_id = i;
    }

    public void setStrength(float f) {
        this.strength = f;
    }

    public void setStrength_max(float f) {
        this.strength_max = f;
    }

    public void setStrength_min(float f) {
        this.strength_min = f;
    }

    public String toString() {
        return "STEffect3DBeautyPartInfo{name=" + new String(this.name) + ", part_id=" + this.part_id + ", strength=" + this.strength + ", strength_min=" + this.strength_min + ", strength_max=" + this.strength_max + '}';
    }
}
