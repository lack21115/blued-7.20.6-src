package android.graphics;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/ComposePathEffect.class */
public class ComposePathEffect extends PathEffect {
    public ComposePathEffect(PathEffect pathEffect, PathEffect pathEffect2) {
        this.native_instance = nativeCreate(pathEffect.native_instance, pathEffect2.native_instance);
    }

    private static native long nativeCreate(long j, long j2);
}
