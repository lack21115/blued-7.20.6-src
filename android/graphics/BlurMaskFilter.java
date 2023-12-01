package android.graphics;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/BlurMaskFilter.class */
public class BlurMaskFilter extends MaskFilter {

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/BlurMaskFilter$Blur.class */
    public enum Blur {
        NORMAL(0),
        SOLID(1),
        OUTER(2),
        INNER(3);
        
        final int native_int;

        Blur(int i) {
            this.native_int = i;
        }
    }

    public BlurMaskFilter(float f, Blur blur) {
        this.native_instance = nativeConstructor(f, blur.native_int);
    }

    private static native long nativeConstructor(float f, int i);
}
