package android.view;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.IBinder;
import android.util.Log;
import android.view.Surface;
import dalvik.system.CloseGuard;

/* loaded from: source-9557208-dex2jar.jar:android/view/SurfaceControl.class */
public class SurfaceControl {
    public static final int BUILT_IN_DISPLAY_ID_HDMI = 1;
    public static final int BUILT_IN_DISPLAY_ID_MAIN = 0;
    public static final int CURSOR_WINDOW = 8192;
    public static final int FX_SURFACE_BLUR = 65536;
    public static final int FX_SURFACE_DIM = 131072;
    public static final int FX_SURFACE_MASK = 983040;
    public static final int FX_SURFACE_NORMAL = 0;
    public static final int HIDDEN = 4;
    public static final int NON_PREMULTIPLIED = 256;
    public static final int OPAQUE = 1024;
    public static final int POWER_MODE_DOZE = 1;
    public static final int POWER_MODE_DOZE_SUSPEND = 3;
    public static final int POWER_MODE_NORMAL = 2;
    public static final int POWER_MODE_OFF = 0;
    public static final int PROTECTED_APP = 2048;
    public static final int SECURE = 128;
    private static final int SURFACE_HIDDEN = 1;
    private static final int SURFACE_OPAQUE = 2;
    private static final int SURFACE_TRANSPARENT = 128;
    private static final String TAG = "SurfaceControl";
    private final CloseGuard mCloseGuard = CloseGuard.get();
    private final String mName;
    long mNativeObject;

    /* loaded from: source-9557208-dex2jar.jar:android/view/SurfaceControl$PhysicalDisplayInfo.class */
    public static final class PhysicalDisplayInfo {
        public long appVsyncOffsetNanos;
        public float density;
        public int height;
        public long presentationDeadlineNanos;
        public float refreshRate;
        public boolean secure;
        public int width;
        public float xDpi;
        public float yDpi;

        public PhysicalDisplayInfo() {
        }

        public PhysicalDisplayInfo(PhysicalDisplayInfo physicalDisplayInfo) {
            copyFrom(physicalDisplayInfo);
        }

        public void copyFrom(PhysicalDisplayInfo physicalDisplayInfo) {
            this.width = physicalDisplayInfo.width;
            this.height = physicalDisplayInfo.height;
            this.refreshRate = physicalDisplayInfo.refreshRate;
            this.density = physicalDisplayInfo.density;
            this.xDpi = physicalDisplayInfo.xDpi;
            this.yDpi = physicalDisplayInfo.yDpi;
            this.secure = physicalDisplayInfo.secure;
            this.appVsyncOffsetNanos = physicalDisplayInfo.appVsyncOffsetNanos;
            this.presentationDeadlineNanos = physicalDisplayInfo.presentationDeadlineNanos;
        }

        public boolean equals(PhysicalDisplayInfo physicalDisplayInfo) {
            return physicalDisplayInfo != null && this.width == physicalDisplayInfo.width && this.height == physicalDisplayInfo.height && this.refreshRate == physicalDisplayInfo.refreshRate && this.density == physicalDisplayInfo.density && this.xDpi == physicalDisplayInfo.xDpi && this.yDpi == physicalDisplayInfo.yDpi && this.secure == physicalDisplayInfo.secure && this.appVsyncOffsetNanos == physicalDisplayInfo.appVsyncOffsetNanos && this.presentationDeadlineNanos == physicalDisplayInfo.presentationDeadlineNanos;
        }

        public boolean equals(Object obj) {
            return (obj instanceof PhysicalDisplayInfo) && equals((PhysicalDisplayInfo) obj);
        }

        public int hashCode() {
            return 0;
        }

        public String toString() {
            return "PhysicalDisplayInfo{" + this.width + " x " + this.height + ", " + this.refreshRate + " fps, density " + this.density + ", " + this.xDpi + " x " + this.yDpi + " dpi, secure " + this.secure + ", appVsyncOffset " + this.appVsyncOffsetNanos + ", bufferDeadline " + this.presentationDeadlineNanos + "}";
        }
    }

    public SurfaceControl(SurfaceSession surfaceSession, String str, int i, int i2, int i3, int i4) throws Surface.OutOfResourcesException {
        if (surfaceSession == null) {
            throw new IllegalArgumentException("session must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        if ((i4 & 4) == 0) {
            Log.w(TAG, "Surfaces should always be created with the HIDDEN flag set to ensure that they are not made visible prematurely before all of the surface's properties have been configured.  Set the other properties and make the surface visible within a transaction.  New surface name: " + str, new Throwable());
        }
        this.mName = str;
        this.mNativeObject = nativeCreate(surfaceSession, str, i, i2, i3, i4);
        if (this.mNativeObject == 0) {
            throw new Surface.OutOfResourcesException("Couldn't allocate SurfaceControl native object");
        }
        this.mCloseGuard.open("release");
    }

    private void checkNotReleased() {
        if (this.mNativeObject == 0) {
            throw new NullPointerException("mNativeObject is null. Have you called release() already?");
        }
    }

    public static boolean clearAnimationFrameStats() {
        return nativeClearAnimationFrameStats();
    }

    public static void closeTransaction() {
        nativeCloseTransaction();
    }

    public static IBinder createDisplay(String str, boolean z) {
        if (str == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        return nativeCreateDisplay(str, z);
    }

    public static void destroyDisplay(IBinder iBinder) {
        if (iBinder == null) {
            throw new IllegalArgumentException("displayToken must not be null");
        }
        nativeDestroyDisplay(iBinder);
    }

    public static int getActiveConfig(IBinder iBinder) {
        if (iBinder == null) {
            throw new IllegalArgumentException("displayToken must not be null");
        }
        return nativeGetActiveConfig(iBinder);
    }

    public static boolean getAnimationFrameStats(WindowAnimationFrameStats windowAnimationFrameStats) {
        return nativeGetAnimationFrameStats(windowAnimationFrameStats);
    }

    public static IBinder getBuiltInDisplay(int i) {
        return nativeGetBuiltInDisplay(i);
    }

    public static PhysicalDisplayInfo[] getDisplayConfigs(IBinder iBinder) {
        if (iBinder == null) {
            throw new IllegalArgumentException("displayToken must not be null");
        }
        return nativeGetDisplayConfigs(iBinder);
    }

    private static native boolean nativeClearAnimationFrameStats();

    private static native boolean nativeClearContentFrameStats(long j);

    private static native void nativeCloseTransaction();

    private static native long nativeCreate(SurfaceSession surfaceSession, String str, int i, int i2, int i3, int i4) throws Surface.OutOfResourcesException;

    private static native IBinder nativeCreateDisplay(String str, boolean z);

    private static native void nativeDestroy(long j);

    private static native void nativeDestroyDisplay(IBinder iBinder);

    private static native int nativeGetActiveConfig(IBinder iBinder);

    private static native boolean nativeGetAnimationFrameStats(WindowAnimationFrameStats windowAnimationFrameStats);

    private static native IBinder nativeGetBuiltInDisplay(int i);

    private static native boolean nativeGetContentFrameStats(long j, WindowContentFrameStats windowContentFrameStats);

    private static native PhysicalDisplayInfo[] nativeGetDisplayConfigs(IBinder iBinder);

    private static native void nativeOpenTransaction();

    private static native void nativeRelease(long j);

    private static native Bitmap nativeScreenshot(IBinder iBinder, Rect rect, int i, int i2, int i3, int i4, boolean z, boolean z2, int i5);

    private static native void nativeScreenshot(IBinder iBinder, Surface surface, Rect rect, int i, int i2, int i3, int i4, boolean z, boolean z2);

    private static native boolean nativeSetActiveConfig(IBinder iBinder, int i);

    private static native void nativeSetAlpha(long j, float f);

    private static native void nativeSetAnimationTransaction();

    private static native void nativeSetBlur(long j, float f);

    private static native void nativeSetBlurMaskAlphaThreshold(long j, float f);

    private static native void nativeSetBlurMaskSampling(long j, int i);

    private static native void nativeSetBlurMaskSurface(long j, long j2);

    private static native void nativeSetDisplayLayerStack(IBinder iBinder, int i);

    private static native void nativeSetDisplayPowerMode(IBinder iBinder, int i);

    private static native void nativeSetDisplayProjection(IBinder iBinder, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    private static native void nativeSetDisplaySize(IBinder iBinder, int i, int i2);

    private static native void nativeSetDisplaySurface(IBinder iBinder, long j);

    private static native void nativeSetFlags(long j, int i, int i2);

    private static native void nativeSetLayer(long j, int i);

    private static native void nativeSetLayerStack(long j, int i);

    private static native void nativeSetMatrix(long j, float f, float f2, float f3, float f4);

    private static native void nativeSetPosition(long j, float f, float f2);

    private static native void nativeSetSize(long j, int i, int i2);

    private static native void nativeSetTransparentRegionHint(long j, Region region);

    private static native void nativeSetWindowCrop(long j, int i, int i2, int i3, int i4);

    public static void openTransaction() {
        nativeOpenTransaction();
    }

    public static Bitmap screenshot(int i, int i2) {
        return nativeScreenshot(getBuiltInDisplay(0), new Rect(), i, i2, 0, 0, true, false, 0);
    }

    public static Bitmap screenshot(Rect rect, int i, int i2, int i3, int i4, boolean z, int i5) {
        return nativeScreenshot(getBuiltInDisplay(0), rect, i, i2, i3, i4, false, z, i5);
    }

    public static void screenshot(IBinder iBinder, Surface surface) {
        screenshot(iBinder, surface, new Rect(), 0, 0, 0, 0, true, false);
    }

    public static void screenshot(IBinder iBinder, Surface surface, int i, int i2) {
        screenshot(iBinder, surface, new Rect(), i, i2, 0, 0, true, false);
    }

    public static void screenshot(IBinder iBinder, Surface surface, int i, int i2, int i3, int i4, boolean z) {
        screenshot(iBinder, surface, new Rect(), i, i2, i3, i4, false, z);
    }

    private static void screenshot(IBinder iBinder, Surface surface, Rect rect, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        if (iBinder == null) {
            throw new IllegalArgumentException("displayToken must not be null");
        }
        if (surface == null) {
            throw new IllegalArgumentException("consumer must not be null");
        }
        nativeScreenshot(iBinder, surface, rect, i, i2, i3, i4, z, z2);
    }

    public static boolean setActiveConfig(IBinder iBinder, int i) {
        if (iBinder == null) {
            throw new IllegalArgumentException("displayToken must not be null");
        }
        return nativeSetActiveConfig(iBinder, i);
    }

    public static void setAnimationTransaction() {
        nativeSetAnimationTransaction();
    }

    public static void setDisplayLayerStack(IBinder iBinder, int i) {
        if (iBinder == null) {
            throw new IllegalArgumentException("displayToken must not be null");
        }
        nativeSetDisplayLayerStack(iBinder, i);
    }

    public static void setDisplayPowerMode(IBinder iBinder, int i) {
        if (iBinder == null) {
            throw new IllegalArgumentException("displayToken must not be null");
        }
        nativeSetDisplayPowerMode(iBinder, i);
    }

    public static void setDisplayProjection(IBinder iBinder, int i, Rect rect, Rect rect2) {
        if (iBinder == null) {
            throw new IllegalArgumentException("displayToken must not be null");
        }
        if (rect == null) {
            throw new IllegalArgumentException("layerStackRect must not be null");
        }
        if (rect2 == null) {
            throw new IllegalArgumentException("displayRect must not be null");
        }
        nativeSetDisplayProjection(iBinder, i, rect.left, rect.top, rect.right, rect.bottom, rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    public static void setDisplaySize(IBinder iBinder, int i, int i2) {
        if (iBinder == null) {
            throw new IllegalArgumentException("displayToken must not be null");
        }
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("width and height must be positive");
        }
        nativeSetDisplaySize(iBinder, i, i2);
    }

    public static void setDisplaySurface(IBinder iBinder, Surface surface) {
        if (iBinder == null) {
            throw new IllegalArgumentException("displayToken must not be null");
        }
        if (surface == null) {
            nativeSetDisplaySurface(iBinder, 0L);
            return;
        }
        synchronized (surface.mLock) {
            nativeSetDisplaySurface(iBinder, surface.mNativeObject);
        }
    }

    public boolean clearContentFrameStats() {
        checkNotReleased();
        return nativeClearContentFrameStats(this.mNativeObject);
    }

    public void destroy() {
        if (this.mNativeObject != 0) {
            nativeDestroy(this.mNativeObject);
            this.mNativeObject = 0L;
        }
        this.mCloseGuard.close();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.mCloseGuard != null) {
                this.mCloseGuard.warnIfOpen();
            }
            if (this.mNativeObject != 0) {
                nativeRelease(this.mNativeObject);
            }
        } finally {
            super.finalize();
        }
    }

    public boolean getContentFrameStats(WindowContentFrameStats windowContentFrameStats) {
        checkNotReleased();
        return nativeGetContentFrameStats(this.mNativeObject, windowContentFrameStats);
    }

    public void hide() {
        checkNotReleased();
        nativeSetFlags(this.mNativeObject, 1, 1);
    }

    public void release() {
        if (this.mNativeObject != 0) {
            nativeRelease(this.mNativeObject);
            this.mNativeObject = 0L;
        }
        this.mCloseGuard.close();
    }

    public void setAlpha(float f) {
        checkNotReleased();
        nativeSetAlpha(this.mNativeObject, f);
    }

    public void setBlur(float f) {
        checkNotReleased();
        nativeSetBlur(this.mNativeObject, f);
    }

    public void setBlurMaskAlphaThreshold(float f) {
        checkNotReleased();
        nativeSetBlurMaskAlphaThreshold(this.mNativeObject, f);
    }

    public void setBlurMaskSampling(int i) {
        checkNotReleased();
        nativeSetBlurMaskSampling(this.mNativeObject, i);
    }

    public void setBlurMaskSurface(SurfaceControl surfaceControl) {
        checkNotReleased();
        if (surfaceControl != null) {
            surfaceControl.checkNotReleased();
        }
        nativeSetBlurMaskSurface(this.mNativeObject, surfaceControl == null ? 0L : surfaceControl.mNativeObject);
    }

    public void setLayer(int i) {
        checkNotReleased();
        nativeSetLayer(this.mNativeObject, i);
    }

    public void setLayerStack(int i) {
        checkNotReleased();
        nativeSetLayerStack(this.mNativeObject, i);
    }

    public void setMatrix(float f, float f2, float f3, float f4) {
        checkNotReleased();
        nativeSetMatrix(this.mNativeObject, f, f2, f3, f4);
    }

    public void setOpaque(boolean z) {
        checkNotReleased();
        if (z) {
            nativeSetFlags(this.mNativeObject, 2, 2);
        } else {
            nativeSetFlags(this.mNativeObject, 0, 2);
        }
    }

    public void setPosition(float f, float f2) {
        checkNotReleased();
        nativeSetPosition(this.mNativeObject, f, f2);
    }

    public void setSize(int i, int i2) {
        checkNotReleased();
        nativeSetSize(this.mNativeObject, i, i2);
    }

    public void setTransparent(boolean z) {
        checkNotReleased();
        if (z) {
            nativeSetFlags(this.mNativeObject, 128, 128);
        } else {
            nativeSetFlags(this.mNativeObject, 0, 128);
        }
    }

    public void setTransparentRegionHint(Region region) {
        checkNotReleased();
        nativeSetTransparentRegionHint(this.mNativeObject, region);
    }

    public void setWindowCrop(Rect rect) {
        checkNotReleased();
        if (rect != null) {
            nativeSetWindowCrop(this.mNativeObject, rect.left, rect.top, rect.right, rect.bottom);
        } else {
            nativeSetWindowCrop(this.mNativeObject, 0, 0, 0, 0);
        }
    }

    public void show() {
        checkNotReleased();
        nativeSetFlags(this.mNativeObject, 0, 1);
    }

    public String toString() {
        return "Surface(name=" + this.mName + ")";
    }
}
