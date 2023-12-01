package android.view;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import com.android.internal.util.VirtualRefBasePtr;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/view/HardwareLayer.class */
public final class HardwareLayer {
    private VirtualRefBasePtr mFinalizer;
    private HardwareRenderer mRenderer;

    private HardwareLayer(HardwareRenderer hardwareRenderer, long j) {
        if (hardwareRenderer == null || j == 0) {
            throw new IllegalArgumentException("Either hardware renderer: " + hardwareRenderer + " or deferredUpdater: " + j + " is invalid");
        }
        this.mRenderer = hardwareRenderer;
        this.mFinalizer = new VirtualRefBasePtr(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HardwareLayer adoptTextureLayer(HardwareRenderer hardwareRenderer, long j) {
        return new HardwareLayer(hardwareRenderer, j);
    }

    private static native int nGetTexName(long j);

    private static native boolean nPrepare(long j, int i, int i2, boolean z);

    private static native void nSetLayerPaint(long j, long j2);

    private static native void nSetSurfaceTexture(long j, SurfaceTexture surfaceTexture, boolean z);

    private static native void nSetTransform(long j, long j2);

    private static native void nUpdateRenderLayer(long j, long j2, int i, int i2, int i3, int i4);

    private static native void nUpdateSurfaceTexture(long j);

    public boolean copyInto(Bitmap bitmap) {
        return this.mRenderer.copyLayerInto(this, bitmap);
    }

    public void destroy() {
        if (isValid()) {
            this.mRenderer.onLayerDestroyed(this);
            this.mRenderer = null;
            this.mFinalizer.release();
            this.mFinalizer = null;
        }
    }

    public void detachSurfaceTexture() {
        this.mRenderer.detachSurfaceTexture(this.mFinalizer.get());
    }

    public long getDeferredLayerUpdater() {
        return this.mFinalizer.get();
    }

    public long getLayerHandle() {
        return this.mFinalizer.get();
    }

    public boolean isValid() {
        return (this.mFinalizer == null || this.mFinalizer.get() == 0) ? false : true;
    }

    public boolean prepare(int i, int i2, boolean z) {
        return nPrepare(this.mFinalizer.get(), i, i2, z);
    }

    public void setLayerPaint(Paint paint) {
        nSetLayerPaint(this.mFinalizer.get(), paint.mNativePaint);
        this.mRenderer.pushLayerUpdate(this);
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        nSetSurfaceTexture(this.mFinalizer.get(), surfaceTexture, false);
        this.mRenderer.pushLayerUpdate(this);
    }

    public void setTransform(Matrix matrix) {
        nSetTransform(this.mFinalizer.get(), matrix.native_instance);
        this.mRenderer.pushLayerUpdate(this);
    }

    public void updateSurfaceTexture() {
        nUpdateSurfaceTexture(this.mFinalizer.get());
        this.mRenderer.pushLayerUpdate(this);
    }
}
