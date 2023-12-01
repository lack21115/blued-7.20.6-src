package android.hardware.display;

import android.view.Display;
import android.view.Surface;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/display/VirtualDisplay.class */
public final class VirtualDisplay {
    private final Display mDisplay;
    private final DisplayManagerGlobal mGlobal;
    private Surface mSurface;
    private IVirtualDisplayCallback mToken;

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/display/VirtualDisplay$Callback.class */
    public static abstract class Callback {
        public void onPaused() {
        }

        public void onResumed() {
        }

        public void onStopped() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VirtualDisplay(DisplayManagerGlobal displayManagerGlobal, Display display, IVirtualDisplayCallback iVirtualDisplayCallback, Surface surface) {
        this.mGlobal = displayManagerGlobal;
        this.mDisplay = display;
        this.mToken = iVirtualDisplayCallback;
        this.mSurface = surface;
    }

    public Display getDisplay() {
        return this.mDisplay;
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public void release() {
        if (this.mToken != null) {
            this.mGlobal.releaseVirtualDisplay(this.mToken);
            this.mToken = null;
        }
    }

    public void resize(int i, int i2, int i3) {
        this.mGlobal.resizeVirtualDisplay(this.mToken, i, i2, i3);
    }

    public void setSurface(Surface surface) {
        if (this.mSurface != surface) {
            this.mGlobal.setVirtualDisplaySurface(this.mToken, surface);
            this.mSurface = surface;
        }
    }

    public String toString() {
        return "VirtualDisplay{display=" + this.mDisplay + ", token=" + this.mToken + ", surface=" + this.mSurface + "}";
    }
}
