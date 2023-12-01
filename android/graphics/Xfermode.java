package android.graphics;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/Xfermode.class */
public class Xfermode {
    long native_instance;

    private static native void finalizer(long j);

    protected void finalize() throws Throwable {
        try {
            finalizer(this.native_instance);
        } finally {
            super.finalize();
        }
    }
}
