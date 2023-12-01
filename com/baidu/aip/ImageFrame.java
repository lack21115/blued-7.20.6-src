package com.baidu.aip;

import com.baidu.aip.face.ArgbPool;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/ImageFrame.class */
public class ImageFrame {
    private int[] argb;
    private int height;
    private ArgbPool pool;
    private boolean retained = false;
    private int width;

    public ImageFrame() {
    }

    public ImageFrame(int[] iArr, int i, int i2) {
        this.argb = iArr;
        this.width = i;
        this.height = i2;
    }

    public int[] getArgb() {
        return this.argb;
    }

    public int getHeight() {
        return this.height;
    }

    public ArgbPool getPool() {
        return this.pool;
    }

    public int getWidth() {
        return this.width;
    }

    public void release() {
        this.retained = false;
    }

    public void retain() {
        this.retained = true;
    }

    public void setArgb(int[] iArr) {
        this.argb = iArr;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setPool(ArgbPool argbPool) {
        this.pool = argbPool;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
