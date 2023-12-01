package android.graphics;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/RegionIterator.class */
public class RegionIterator {
    private final long mNativeIter;

    public RegionIterator(Region region) {
        this.mNativeIter = nativeConstructor(region.ni());
    }

    private static native long nativeConstructor(long j);

    private static native void nativeDestructor(long j);

    private static native boolean nativeNext(long j, Rect rect);

    protected void finalize() throws Throwable {
        nativeDestructor(this.mNativeIter);
    }

    public final boolean next(Rect rect) {
        if (rect == null) {
            throw new NullPointerException("The Rect must be provided");
        }
        return nativeNext(this.mNativeIter, rect);
    }
}
