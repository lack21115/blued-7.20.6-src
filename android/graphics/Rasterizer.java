package android.graphics;

@Deprecated
/* loaded from: source-9557208-dex2jar.jar:android/graphics/Rasterizer.class */
public class Rasterizer {
    long native_instance;

    private static native void finalizer(long j);

    protected void finalize() throws Throwable {
        finalizer(this.native_instance);
    }
}
