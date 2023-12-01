package com.android.internal.view;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/view/BaseSurfaceHolder.class */
public abstract class BaseSurfaceHolder implements SurfaceHolder {
    static final boolean DEBUG = false;
    private static final String TAG = "BaseSurfaceHolder";
    SurfaceHolder.Callback[] mGottenCallbacks;
    boolean mHaveGottenCallbacks;
    Rect mTmpDirty;
    public final ArrayList<SurfaceHolder.Callback> mCallbacks = new ArrayList<>();
    public final ReentrantLock mSurfaceLock = new ReentrantLock();
    public Surface mSurface = new Surface();
    int mRequestedWidth = -1;
    int mRequestedHeight = -1;
    protected int mRequestedFormat = -1;
    int mRequestedType = -1;
    long mLastLockTime = 0;
    int mType = -1;
    final Rect mSurfaceFrame = new Rect();

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00b0 -> B:24:0x009e). Please submit an issue!!! */
    private final Canvas internalLockCanvas(Rect rect) {
        if (this.mType == 3) {
            throw new SurfaceHolder.BadSurfaceTypeException("Surface type is SURFACE_TYPE_PUSH_BUFFERS");
        }
        this.mSurfaceLock.lock();
        Canvas canvas = null;
        if (onAllowLockCanvas()) {
            Rect rect2 = rect;
            if (rect == null) {
                if (this.mTmpDirty == null) {
                    this.mTmpDirty = new Rect();
                }
                this.mTmpDirty.set(this.mSurfaceFrame);
                rect2 = this.mTmpDirty;
            }
            try {
                canvas = this.mSurface.lockCanvas(rect2);
            } catch (Exception e) {
                Log.e(TAG, "Exception locking surface", e);
                canvas = null;
            }
        }
        if (canvas != null) {
            this.mLastLockTime = SystemClock.uptimeMillis();
            return canvas;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = this.mLastLockTime + 100;
        long j2 = uptimeMillis;
        if (j > uptimeMillis) {
            try {
                Thread.sleep(j - uptimeMillis);
            } catch (InterruptedException e2) {
            }
            j2 = SystemClock.uptimeMillis();
        }
        this.mLastLockTime = j2;
        this.mSurfaceLock.unlock();
        return null;
    }

    @Override // android.view.SurfaceHolder
    public void addCallback(SurfaceHolder.Callback callback) {
        synchronized (this.mCallbacks) {
            if (!this.mCallbacks.contains(callback)) {
                this.mCallbacks.add(callback);
            }
        }
    }

    public SurfaceHolder.Callback[] getCallbacks() {
        if (this.mHaveGottenCallbacks) {
            return this.mGottenCallbacks;
        }
        synchronized (this.mCallbacks) {
            int size = this.mCallbacks.size();
            if (size > 0) {
                if (this.mGottenCallbacks == null || this.mGottenCallbacks.length != size) {
                    this.mGottenCallbacks = new SurfaceHolder.Callback[size];
                }
                this.mCallbacks.toArray(this.mGottenCallbacks);
            } else {
                this.mGottenCallbacks = null;
            }
            this.mHaveGottenCallbacks = true;
        }
        return this.mGottenCallbacks;
    }

    public int getRequestedFormat() {
        return this.mRequestedFormat;
    }

    public int getRequestedHeight() {
        return this.mRequestedHeight;
    }

    public int getRequestedType() {
        return this.mRequestedType;
    }

    public int getRequestedWidth() {
        return this.mRequestedWidth;
    }

    @Override // android.view.SurfaceHolder
    public Surface getSurface() {
        return this.mSurface;
    }

    @Override // android.view.SurfaceHolder
    public Rect getSurfaceFrame() {
        return this.mSurfaceFrame;
    }

    @Override // android.view.SurfaceHolder
    public Canvas lockCanvas() {
        return internalLockCanvas(null);
    }

    @Override // android.view.SurfaceHolder
    public Canvas lockCanvas(Rect rect) {
        return internalLockCanvas(rect);
    }

    public abstract boolean onAllowLockCanvas();

    public abstract void onRelayoutContainer();

    public abstract void onUpdateSurface();

    @Override // android.view.SurfaceHolder
    public void removeCallback(SurfaceHolder.Callback callback) {
        synchronized (this.mCallbacks) {
            this.mCallbacks.remove(callback);
        }
    }

    @Override // android.view.SurfaceHolder
    public void setFixedSize(int i, int i2) {
        if (this.mRequestedWidth == i && this.mRequestedHeight == i2) {
            return;
        }
        this.mRequestedWidth = i;
        this.mRequestedHeight = i2;
        onRelayoutContainer();
    }

    @Override // android.view.SurfaceHolder
    public void setFormat(int i) {
        if (this.mRequestedFormat != i) {
            this.mRequestedFormat = i;
            onUpdateSurface();
        }
    }

    @Override // android.view.SurfaceHolder
    public void setSizeFromLayout() {
        if (this.mRequestedWidth == -1 && this.mRequestedHeight == -1) {
            return;
        }
        this.mRequestedHeight = -1;
        this.mRequestedWidth = -1;
        onRelayoutContainer();
    }

    public void setSurfaceFrameSize(int i, int i2) {
        this.mSurfaceFrame.top = 0;
        this.mSurfaceFrame.left = 0;
        this.mSurfaceFrame.right = i;
        this.mSurfaceFrame.bottom = i2;
    }

    @Override // android.view.SurfaceHolder
    public void setType(int i) {
        switch (i) {
            case 1:
            case 2:
                i = 0;
                break;
        }
        switch (i) {
            case 0:
            case 3:
                if (this.mRequestedType != i) {
                    this.mRequestedType = i;
                    onUpdateSurface();
                    return;
                }
                return;
            case 1:
            case 2:
            default:
                return;
        }
    }

    public void ungetCallbacks() {
        this.mHaveGottenCallbacks = false;
    }

    @Override // android.view.SurfaceHolder
    public void unlockCanvasAndPost(Canvas canvas) {
        this.mSurface.unlockCanvasAndPost(canvas);
        this.mSurfaceLock.unlock();
    }
}
