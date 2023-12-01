package android.graphics;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import java.lang.ref.WeakReference;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/SurfaceTexture.class */
public class SurfaceTexture {
    private final Looper mCreatorLooper;
    private long mFrameAvailableListener;
    private Handler mOnFrameAvailableHandler;
    private long mProducer;
    private long mSurfaceTexture;

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/SurfaceTexture$OnFrameAvailableListener.class */
    public interface OnFrameAvailableListener {
        void onFrameAvailable(SurfaceTexture surfaceTexture);
    }

    @Deprecated
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/SurfaceTexture$OutOfResourcesException.class */
    public static class OutOfResourcesException extends Exception {
        public OutOfResourcesException() {
        }

        public OutOfResourcesException(String str) {
            super(str);
        }
    }

    static {
        nativeClassInit();
    }

    public SurfaceTexture(int i) {
        this(i, false);
    }

    public SurfaceTexture(int i, boolean z) {
        this.mCreatorLooper = Looper.myLooper();
        nativeInit(false, i, z, new WeakReference<>(this));
    }

    public SurfaceTexture(boolean z) {
        this.mCreatorLooper = Looper.myLooper();
        nativeInit(true, 0, z, new WeakReference<>(this));
    }

    private native int nativeAttachToGLContext(int i);

    private static native void nativeClassInit();

    private native int nativeDetachFromGLContext();

    private native void nativeFinalize();

    private native int nativeGetQueuedCount();

    private native long nativeGetTimestamp();

    private native void nativeGetTransformMatrix(float[] fArr);

    private native void nativeInit(boolean z, int i, boolean z2, WeakReference<SurfaceTexture> weakReference) throws Surface.OutOfResourcesException;

    private native void nativeRelease();

    private native void nativeReleaseTexImage();

    private native void nativeSetDefaultBufferSize(int i, int i2);

    private native void nativeUpdateTexImage();

    private static void postEventFromNative(WeakReference<SurfaceTexture> weakReference) {
        Handler handler;
        SurfaceTexture surfaceTexture = weakReference.get();
        if (surfaceTexture == null || (handler = surfaceTexture.mOnFrameAvailableHandler) == null) {
            return;
        }
        handler.sendEmptyMessage(0);
    }

    public void attachToGLContext(int i) {
        if (nativeAttachToGLContext(i) != 0) {
            throw new RuntimeException("Error during attachToGLContext (see logcat for details)");
        }
    }

    public void detachFromGLContext() {
        if (nativeDetachFromGLContext() != 0) {
            throw new RuntimeException("Error during detachFromGLContext (see logcat for details)");
        }
    }

    protected void finalize() throws Throwable {
        try {
            nativeFinalize();
        } finally {
            super.finalize();
        }
    }

    public long getTimestamp() {
        return nativeGetTimestamp();
    }

    public void getTransformMatrix(float[] fArr) {
        if (fArr.length != 16) {
            throw new IllegalArgumentException();
        }
        nativeGetTransformMatrix(fArr);
    }

    public void release() {
        nativeRelease();
    }

    public void releaseTexImage() {
        nativeReleaseTexImage();
    }

    public void setDefaultBufferSize(int i, int i2) {
        nativeSetDefaultBufferSize(i, i2);
    }

    public void setOnFrameAvailableListener(OnFrameAvailableListener onFrameAvailableListener) {
        setOnFrameAvailableListener(onFrameAvailableListener, null);
    }

    public void setOnFrameAvailableListener(final OnFrameAvailableListener onFrameAvailableListener, Handler handler) {
        if (onFrameAvailableListener != null) {
            this.mOnFrameAvailableHandler = new Handler(handler != null ? handler.getLooper() : this.mCreatorLooper != null ? this.mCreatorLooper : Looper.getMainLooper(), null, true) { // from class: android.graphics.SurfaceTexture.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    onFrameAvailableListener.onFrameAvailable(SurfaceTexture.this);
                }
            };
        } else {
            this.mOnFrameAvailableHandler = null;
        }
    }

    public void updateTexImage() {
        nativeUpdateTexImage();
    }
}
