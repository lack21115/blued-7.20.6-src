package android.graphics;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/PaintFlagsDrawFilter.class */
public class PaintFlagsDrawFilter extends DrawFilter {
    public final int clearBits;
    public final int setBits;

    public PaintFlagsDrawFilter(int i, int i2) {
        this.clearBits = i;
        this.setBits = i2;
        this.mNativeInt = nativeConstructor(i, i2);
    }

    private static native long nativeConstructor(int i, int i2);
}
