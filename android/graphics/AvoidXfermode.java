package android.graphics;

@Deprecated
/* loaded from: source-9557208-dex2jar.jar:android/graphics/AvoidXfermode.class */
public class AvoidXfermode extends Xfermode {

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/AvoidXfermode$Mode.class */
    public enum Mode {
        AVOID(0),
        TARGET(1);
        
        final int nativeInt;

        Mode(int i) {
            this.nativeInt = i;
        }
    }

    public AvoidXfermode(int i, int i2, Mode mode) {
        if (i2 < 0 || i2 > 255) {
            throw new IllegalArgumentException("tolerance must be 0..255");
        }
        this.native_instance = nativeCreate(i, i2, mode.nativeInt);
    }

    private static native long nativeCreate(int i, int i2, int i3);
}
