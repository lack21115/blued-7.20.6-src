package android.graphics;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pools;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/Region.class */
public class Region implements Parcelable {
    private static final int MAX_POOL_SIZE = 10;
    public final long mNativeRegion;
    private static final Pools.SynchronizedPool<Region> sPool = new Pools.SynchronizedPool<>(10);
    public static final Parcelable.Creator<Region> CREATOR = new Parcelable.Creator<Region>() { // from class: android.graphics.Region.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Region createFromParcel(Parcel parcel) {
            long nativeCreateFromParcel = Region.nativeCreateFromParcel(parcel);
            if (nativeCreateFromParcel == 0) {
                throw new RuntimeException();
            }
            return new Region(nativeCreateFromParcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Region[] newArray(int i) {
            return new Region[i];
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Region$Op.class */
    public enum Op {
        DIFFERENCE(0),
        INTERSECT(1),
        UNION(2),
        XOR(3),
        REVERSE_DIFFERENCE(4),
        REPLACE(5);
        
        public final int nativeInt;

        Op(int i) {
            this.nativeInt = i;
        }
    }

    public Region() {
        this(nativeConstructor());
    }

    public Region(int i, int i2, int i3, int i4) {
        this.mNativeRegion = nativeConstructor();
        nativeSetRect(this.mNativeRegion, i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Region(long j) {
        if (j == 0) {
            throw new RuntimeException();
        }
        this.mNativeRegion = j;
    }

    private Region(long j, int i) {
        this(j);
    }

    public Region(Rect rect) {
        this.mNativeRegion = nativeConstructor();
        nativeSetRect(this.mNativeRegion, rect.left, rect.top, rect.right, rect.bottom);
    }

    public Region(Region region) {
        this(nativeConstructor());
        nativeSetRegion(this.mNativeRegion, region.mNativeRegion);
    }

    private static native long nativeConstructor();

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeCreateFromParcel(Parcel parcel);

    private static native void nativeDestructor(long j);

    private static native boolean nativeEquals(long j, long j2);

    private static native boolean nativeGetBoundaryPath(long j, long j2);

    private static native boolean nativeGetBounds(long j, Rect rect);

    private static native boolean nativeOp(long j, int i, int i2, int i3, int i4, int i5);

    private static native boolean nativeOp(long j, long j2, long j3, int i);

    private static native boolean nativeOp(long j, Rect rect, long j2, int i);

    private static native boolean nativeSetPath(long j, long j2, long j3);

    private static native boolean nativeSetRect(long j, int i, int i2, int i3, int i4);

    private static native void nativeSetRegion(long j, long j2);

    private static native String nativeToString(long j);

    private static native boolean nativeWriteToParcel(long j, Parcel parcel);

    public static Region obtain() {
        Region acquire = sPool.acquire();
        return acquire != null ? acquire : new Region();
    }

    public static Region obtain(Region region) {
        Region obtain = obtain();
        obtain.set(region);
        return obtain;
    }

    public native boolean contains(int i, int i2);

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Region)) {
            return false;
        }
        return nativeEquals(this.mNativeRegion, ((Region) obj).mNativeRegion);
    }

    protected void finalize() throws Throwable {
        try {
            nativeDestructor(this.mNativeRegion);
        } finally {
            super.finalize();
        }
    }

    public Path getBoundaryPath() {
        Path path = new Path();
        nativeGetBoundaryPath(this.mNativeRegion, path.ni());
        return path;
    }

    public boolean getBoundaryPath(Path path) {
        return nativeGetBoundaryPath(this.mNativeRegion, path.ni());
    }

    public Rect getBounds() {
        Rect rect = new Rect();
        nativeGetBounds(this.mNativeRegion, rect);
        return rect;
    }

    public boolean getBounds(Rect rect) {
        if (rect == null) {
            throw new NullPointerException();
        }
        return nativeGetBounds(this.mNativeRegion, rect);
    }

    public native boolean isComplex();

    public native boolean isEmpty();

    public native boolean isRect();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long ni() {
        return this.mNativeRegion;
    }

    public boolean op(int i, int i2, int i3, int i4, Op op) {
        return nativeOp(this.mNativeRegion, i, i2, i3, i4, op.nativeInt);
    }

    public boolean op(Rect rect, Op op) {
        return nativeOp(this.mNativeRegion, rect.left, rect.top, rect.right, rect.bottom, op.nativeInt);
    }

    public boolean op(Rect rect, Region region, Op op) {
        return nativeOp(this.mNativeRegion, rect, region.mNativeRegion, op.nativeInt);
    }

    public boolean op(Region region, Op op) {
        return op(this, region, op);
    }

    public boolean op(Region region, Region region2, Op op) {
        return nativeOp(this.mNativeRegion, region.mNativeRegion, region2.mNativeRegion, op.nativeInt);
    }

    public native boolean quickContains(int i, int i2, int i3, int i4);

    public boolean quickContains(Rect rect) {
        return quickContains(rect.left, rect.top, rect.right, rect.bottom);
    }

    public native boolean quickReject(int i, int i2, int i3, int i4);

    public boolean quickReject(Rect rect) {
        return quickReject(rect.left, rect.top, rect.right, rect.bottom);
    }

    public native boolean quickReject(Region region);

    public void recycle() {
        setEmpty();
        sPool.release(this);
    }

    public void scale(float f) {
        scale(f, null);
    }

    public native void scale(float f, Region region);

    public boolean set(int i, int i2, int i3, int i4) {
        return nativeSetRect(this.mNativeRegion, i, i2, i3, i4);
    }

    public boolean set(Rect rect) {
        return nativeSetRect(this.mNativeRegion, rect.left, rect.top, rect.right, rect.bottom);
    }

    public boolean set(Region region) {
        nativeSetRegion(this.mNativeRegion, region.mNativeRegion);
        return true;
    }

    public void setEmpty() {
        nativeSetRect(this.mNativeRegion, 0, 0, 0, 0);
    }

    public boolean setPath(Path path, Region region) {
        return nativeSetPath(this.mNativeRegion, path.ni(), region.mNativeRegion);
    }

    public String toString() {
        return nativeToString(this.mNativeRegion);
    }

    public void translate(int i, int i2) {
        translate(i, i2, null);
    }

    public native void translate(int i, int i2, Region region);

    public final boolean union(Rect rect) {
        return op(rect, Op.UNION);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (!nativeWriteToParcel(this.mNativeRegion, parcel)) {
            throw new RuntimeException();
        }
    }
}
