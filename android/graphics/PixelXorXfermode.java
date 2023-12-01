package android.graphics;

@Deprecated
/* loaded from: source-9557208-dex2jar.jar:android/graphics/PixelXorXfermode.class */
public class PixelXorXfermode extends Xfermode {
    public PixelXorXfermode(int i) {
        this.native_instance = nativeCreate(i);
    }

    private static native long nativeCreate(int i);
}
