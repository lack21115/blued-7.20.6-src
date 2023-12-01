package android.graphics;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/EmbossMaskFilter.class */
public class EmbossMaskFilter extends MaskFilter {
    public EmbossMaskFilter(float[] fArr, float f, float f2, float f3) {
        if (fArr.length < 3) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.native_instance = nativeConstructor(fArr, f, f2, f3);
    }

    private static native long nativeConstructor(float[] fArr, float f, float f2, float f3);
}
