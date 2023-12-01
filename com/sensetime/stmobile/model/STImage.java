package com.sensetime.stmobile.model;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STImage.class */
public class STImage {
    int height;
    byte[] imageData;
    int pixelFormat;
    int stride;
    double timeStamp;
    int width;

    public STImage(byte[] bArr, int i, int i2, int i3) {
        this.imageData = bArr;
        this.pixelFormat = i;
        this.width = i2;
        this.height = i3;
    }

    public STImage(byte[] bArr, int i, int i2, int i3, int i4, double d) {
        this.imageData = bArr;
        this.width = i;
        this.height = i2;
        this.timeStamp = d;
        this.stride = i3;
        this.pixelFormat = i4;
    }

    public int getHeight() {
        return this.height;
    }

    public byte[] getImageData() {
        return this.imageData;
    }

    public int getPixelFormat() {
        return this.pixelFormat;
    }

    public int getStride() {
        return this.stride;
    }

    public double getTimeStamp() {
        return this.timeStamp;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setImageData(byte[] bArr) {
        this.imageData = bArr;
    }

    public void setPixelFormat(int i) {
        this.pixelFormat = i;
    }

    public void setStride(int i) {
        this.stride = i;
    }

    public void setTimeStamp(double d) {
        this.timeStamp = d;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
