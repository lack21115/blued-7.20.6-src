package com.qiniu.pili.droid.streaming;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/SurfaceTextureCallback.class */
public interface SurfaceTextureCallback {
    int onDrawFrame(int i, int i2, int i3, float[] fArr);

    void onSurfaceChanged(int i, int i2);

    void onSurfaceCreated();

    void onSurfaceDestroyed();
}
