package android.filterfw.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/FilterSurfaceView.class */
public class FilterSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static int STATE_ALLOCATED = 0;
    private static int STATE_CREATED = 1;
    private static int STATE_INITIALIZED = 2;
    private int mFormat;
    private GLEnvironment mGLEnv;
    private int mHeight;
    private SurfaceHolder.Callback mListener;
    private int mState;
    private int mSurfaceId;
    private int mWidth;

    public FilterSurfaceView(Context context) {
        super(context);
        this.mState = STATE_ALLOCATED;
        this.mSurfaceId = -1;
        getHolder().addCallback(this);
    }

    public FilterSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = STATE_ALLOCATED;
        this.mSurfaceId = -1;
        getHolder().addCallback(this);
    }

    private void registerSurface() {
        this.mSurfaceId = this.mGLEnv.registerSurface(getHolder().getSurface());
        if (this.mSurfaceId < 0) {
            throw new RuntimeException("Could not register Surface: " + getHolder().getSurface() + " in FilterSurfaceView!");
        }
    }

    private void unregisterSurface() {
        if (this.mGLEnv == null || this.mSurfaceId <= 0) {
            return;
        }
        this.mGLEnv.unregisterSurfaceId(this.mSurfaceId);
    }

    public void bindToListener(SurfaceHolder.Callback callback, GLEnvironment gLEnvironment) {
        synchronized (this) {
            if (callback == null) {
                throw new NullPointerException("Attempting to bind null filter to SurfaceView!");
            }
            if (this.mListener != null && this.mListener != callback) {
                throw new RuntimeException("Attempting to bind filter " + callback + " to SurfaceView with another open filter " + this.mListener + " attached already!");
            }
            this.mListener = callback;
            if (this.mGLEnv != null && this.mGLEnv != gLEnvironment) {
                this.mGLEnv.unregisterSurfaceId(this.mSurfaceId);
            }
            this.mGLEnv = gLEnvironment;
            if (this.mState >= STATE_CREATED) {
                registerSurface();
                this.mListener.surfaceCreated(getHolder());
                if (this.mState == STATE_INITIALIZED) {
                    this.mListener.surfaceChanged(getHolder(), this.mFormat, this.mWidth, this.mHeight);
                }
            }
        }
    }

    public GLEnvironment getGLEnv() {
        GLEnvironment gLEnvironment;
        synchronized (this) {
            gLEnvironment = this.mGLEnv;
        }
        return gLEnvironment;
    }

    public int getSurfaceId() {
        int i;
        synchronized (this) {
            i = this.mSurfaceId;
        }
        return i;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        synchronized (this) {
            this.mFormat = i;
            this.mWidth = i2;
            this.mHeight = i3;
            this.mState = STATE_INITIALIZED;
            if (this.mListener != null) {
                this.mListener.surfaceChanged(surfaceHolder, i, i2, i3);
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        synchronized (this) {
            this.mState = STATE_CREATED;
            if (this.mGLEnv != null) {
                registerSurface();
            }
            if (this.mListener != null) {
                this.mListener.surfaceCreated(surfaceHolder);
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        synchronized (this) {
            this.mState = STATE_ALLOCATED;
            if (this.mListener != null) {
                this.mListener.surfaceDestroyed(surfaceHolder);
            }
            unregisterSurface();
        }
    }

    public void unbind() {
        synchronized (this) {
            this.mListener = null;
        }
    }
}
