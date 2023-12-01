package android.graphics;

import android.graphics.PorterDuff;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/PorterDuffXfermode.class */
public class PorterDuffXfermode extends Xfermode {
    public final PorterDuff.Mode mode;

    public PorterDuffXfermode(PorterDuff.Mode mode) {
        this.mode = mode;
        this.native_instance = nativeCreateXfermode(mode.nativeInt);
    }

    private static native long nativeCreateXfermode(int i);
}
