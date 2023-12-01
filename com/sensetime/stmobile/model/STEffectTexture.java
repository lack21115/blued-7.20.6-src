package com.sensetime.stmobile.model;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STEffectTexture.class */
public class STEffectTexture {
    int format;
    int height;
    int id;
    int width;

    public STEffectTexture(int i, int i2, int i3, int i4) {
        this.id = i;
        this.width = i2;
        this.height = i3;
        this.format = i4;
    }

    public int getFormat() {
        return this.format;
    }

    public int getHeight() {
        return this.height;
    }

    public int getId() {
        return this.id;
    }

    public int getWidth() {
        return this.width;
    }

    public void setFormat(int i) {
        this.format = i;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
