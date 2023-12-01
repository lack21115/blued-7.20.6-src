package com.google.android.cameraview;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8110460-dex2jar.jar:com/google/android/cameraview/PreviewImpl.class */
public abstract class PreviewImpl {
    private Callback mCallback;
    private int mHeight;
    private int mWidth;

    /* loaded from: source-8110460-dex2jar.jar:com/google/android/cameraview/PreviewImpl$Callback.class */
    interface Callback {
        void onSurfaceChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dispatchSurfaceChanged() {
        this.mCallback.onSurfaceChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getHeight() {
        return this.mHeight;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Class getOutputClass();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Surface getSurface();

    /* JADX INFO: Access modifiers changed from: package-private */
    public SurfaceHolder getSurfaceHolder() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getSurfaceTexture() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract View getView();

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getWidth() {
        return this.mWidth;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isReady();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBufferSize(int i, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setDisplayOrientation(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSize(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }
}
