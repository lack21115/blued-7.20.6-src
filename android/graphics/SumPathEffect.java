package android.graphics;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/SumPathEffect.class */
public class SumPathEffect extends PathEffect {
    public SumPathEffect(PathEffect pathEffect, PathEffect pathEffect2) {
        this.native_instance = nativeCreate(pathEffect.native_instance, pathEffect2.native_instance);
    }

    private static native long nativeCreate(long j, long j2);
}
