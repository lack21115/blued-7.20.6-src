package android.graphics;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/DrawFilter.class */
public class DrawFilter {
    long mNativeInt;

    private static native void nativeDestructor(long j);

    protected void finalize() throws Throwable {
        try {
            nativeDestructor(this.mNativeInt);
        } finally {
            super.finalize();
        }
    }
}
