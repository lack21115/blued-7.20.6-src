package android.graphics;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/PathEffect.class */
public class PathEffect {
    long native_instance;

    private static native void nativeDestructor(long j);

    protected void finalize() throws Throwable {
        nativeDestructor(this.native_instance);
    }
}
