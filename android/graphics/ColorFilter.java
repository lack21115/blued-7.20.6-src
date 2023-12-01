package android.graphics;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/ColorFilter.class */
public class ColorFilter {
    public long native_instance;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void destroyFilter(long j);

    protected void finalize() throws Throwable {
        try {
            super.finalize();
        } finally {
            destroyFilter(this.native_instance);
        }
    }
}
