package com.qiniu.pili.droid.beauty;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/beauty/b.class */
public final class b {
    private int b;

    /* renamed from: a  reason: collision with root package name */
    private int f13777a = -1;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13778c = false;

    public void a() {
        if (this.f13778c) {
            JNIControl.reInit();
        }
        this.f13778c = false;
        this.f13777a = -1;
    }

    public void a(float f) {
        JNIControl.setBeautify(f);
    }

    public void a(int i, int i2, int i3, int i4) {
        JNIControl.setSurfaceTextureID(i);
        JNIControl.processThrough(0L, i3, i2, i3, i2, i4);
    }

    public void a(Context context, int i, int i2) {
        this.f13778c = true;
        if (this.f13777a == -1) {
            if (i == 3) {
                JNIControl.setGLES(3);
            } else {
                JNIControl.setGLES(2);
            }
            JNIControl.onSurfaceCreated(context, i2);
        }
    }

    public void a(boolean z) {
        JNIControl.setIsPortraitDisplay(z);
    }

    public void b(float f) {
        JNIControl.setWhiten(f);
    }

    public void b(Context context, int i, int i2) {
        JNIControl.onSurfaceChanged(i, i2);
        this.b = JNIControl.getOutputTexture();
        JNIControl.setCurrentDirection(1);
    }

    public void c(float f) {
        JNIControl.setRedden(f);
    }
}
