package android.graphics;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/DiscretePathEffect.class */
public class DiscretePathEffect extends PathEffect {
    public DiscretePathEffect(float f, float f2) {
        this.native_instance = nativeCreate(f, f2);
    }

    private static native long nativeCreate(float f, float f2);
}
