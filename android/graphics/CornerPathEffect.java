package android.graphics;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/CornerPathEffect.class */
public class CornerPathEffect extends PathEffect {
    public CornerPathEffect(float f) {
        this.native_instance = nativeCreate(f);
    }

    private static native long nativeCreate(float f);
}
