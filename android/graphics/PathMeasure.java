package android.graphics;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/PathMeasure.class */
public class PathMeasure {
    public static final int POSITION_MATRIX_FLAG = 1;
    public static final int TANGENT_MATRIX_FLAG = 2;
    private Path mPath;
    private final long native_instance;

    public PathMeasure() {
        this.mPath = null;
        this.native_instance = native_create(0L, false);
    }

    public PathMeasure(Path path, boolean z) {
        this.mPath = path;
        this.native_instance = native_create(path != null ? path.ni() : 0L, z);
    }

    private static native long native_create(long j, boolean z);

    private static native void native_destroy(long j);

    private static native float native_getLength(long j);

    private static native boolean native_getMatrix(long j, float f, long j2, int i);

    private static native boolean native_getPosTan(long j, float f, float[] fArr, float[] fArr2);

    private static native boolean native_getSegment(long j, float f, float f2, long j2, boolean z);

    private static native boolean native_isClosed(long j);

    private static native boolean native_nextContour(long j);

    private static native void native_setPath(long j, long j2, boolean z);

    protected void finalize() throws Throwable {
        native_destroy(this.native_instance);
    }

    public float getLength() {
        return native_getLength(this.native_instance);
    }

    public boolean getMatrix(float f, Matrix matrix, int i) {
        return native_getMatrix(this.native_instance, f, matrix.native_instance, i);
    }

    public boolean getPosTan(float f, float[] fArr, float[] fArr2) {
        if ((fArr == null || fArr.length >= 2) && (fArr2 == null || fArr2.length >= 2)) {
            return native_getPosTan(this.native_instance, f, fArr, fArr2);
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean getSegment(float f, float f2, Path path, boolean z) {
        path.isSimplePath = false;
        return native_getSegment(this.native_instance, f, f2, path.ni(), z);
    }

    public boolean isClosed() {
        return native_isClosed(this.native_instance);
    }

    public boolean nextContour() {
        return native_nextContour(this.native_instance);
    }

    public void setPath(Path path, boolean z) {
        this.mPath = path;
        native_setPath(this.native_instance, path != null ? path.ni() : 0L, z);
    }
}
