package com.zego.ve;

import android.graphics.SurfaceTexture;

/* loaded from: source-8829756-dex2jar.jar:com/zego/ve/VSurTex.class */
public class VSurTex implements SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "VSurTex";
    private long pthis = 0;
    private SurfaceTexture mSt = null;
    private Object mLock = new Object();

    private static native int on_frame(long j, int i);

    public int create(long j, int i) {
        this.pthis = j;
        SurfaceTexture surfaceTexture = new SurfaceTexture(i);
        this.mSt = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        return this.mSt.hashCode();
    }

    public void destroy() {
        synchronized (this.mLock) {
            this.pthis = 0L;
        }
        this.mSt.setOnFrameAvailableListener(null);
        this.mSt.release();
        this.mSt = null;
    }

    public SurfaceTexture get() {
        return this.mSt;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        try {
            synchronized (this.mLock) {
                if (this.pthis != 0) {
                    on_frame(this.pthis, surfaceTexture.hashCode());
                } else {
                    android.util.Log.d(TAG, "ignore callback:");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
