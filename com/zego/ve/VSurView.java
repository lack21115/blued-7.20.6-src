package com.zego.ve;

import android.view.SurfaceHolder;
import android.view.SurfaceView;

/* loaded from: source-8829756-dex2jar.jar:com/zego/ve/VSurView.class */
public class VSurView implements SurfaceHolder.Callback {
    private long pthis = 0;
    private SurfaceView mSurView = null;
    private final Object lock = new Object();

    private static native int on_surface_changed(long j, SurfaceHolder surfaceHolder, int i, int i2, int i3);

    private static native int on_surface_created(long j, SurfaceHolder surfaceHolder);

    private static native int on_surface_destroyed(long j, SurfaceHolder surfaceHolder);

    public int removeView() {
        synchronized (this.lock) {
            if (this.mSurView != null) {
                SurfaceHolder holder = this.mSurView.getHolder();
                if (holder != null) {
                    holder.removeCallback(this);
                }
                this.mSurView = null;
            }
        }
        return 0;
    }

    public int setThis(long j) {
        synchronized (this.lock) {
            this.pthis = j;
        }
        return 0;
    }

    public int setView(SurfaceView surfaceView) {
        SurfaceHolder holder;
        synchronized (this.lock) {
            removeView();
            this.mSurView = surfaceView;
            if (surfaceView != null && (holder = surfaceView.getHolder()) != null) {
                holder.addCallback(this);
            }
        }
        return 0;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        synchronized (this.lock) {
            if (this.pthis != 0) {
                on_surface_changed(this.pthis, surfaceHolder, i, i2, i3);
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        synchronized (this.lock) {
            if (this.pthis != 0) {
                on_surface_created(this.pthis, surfaceHolder);
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        synchronized (this.lock) {
            if (this.pthis != 0) {
                on_surface_destroyed(this.pthis, surfaceHolder);
            }
        }
    }
}
