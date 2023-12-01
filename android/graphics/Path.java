package android.graphics;

import android.graphics.Region;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/Path.class */
public class Path {
    static final FillType[] sFillTypeArray = {FillType.WINDING, FillType.EVEN_ODD, FillType.INVERSE_WINDING, FillType.INVERSE_EVEN_ODD};
    public boolean isSimplePath;
    private Direction mLastDirection;
    public final long mNativePath;
    public Region rects;

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Path$Direction.class */
    public enum Direction {
        CW(1),
        CCW(2);
        
        final int nativeInt;

        Direction(int i) {
            this.nativeInt = i;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Path$FillType.class */
    public enum FillType {
        WINDING(0),
        EVEN_ODD(1),
        INVERSE_WINDING(2),
        INVERSE_EVEN_ODD(3);
        
        final int nativeInt;

        FillType(int i) {
            this.nativeInt = i;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Path$Op.class */
    public enum Op {
        DIFFERENCE,
        INTERSECT,
        UNION,
        XOR,
        REVERSE_DIFFERENCE
    }

    public Path() {
        this.isSimplePath = true;
        this.mLastDirection = null;
        this.mNativePath = init1();
    }

    public Path(Path path) {
        this.isSimplePath = true;
        this.mLastDirection = null;
        long j = 0;
        if (path != null) {
            long j2 = path.mNativePath;
            this.isSimplePath = path.isSimplePath;
            j = j2;
            if (path.rects != null) {
                this.rects = new Region(path.rects);
                j = j2;
            }
        }
        this.mNativePath = init2(j);
    }

    private void detectSimplePath(float f, float f2, float f3, float f4, Direction direction) {
        if (this.mLastDirection == null) {
            this.mLastDirection = direction;
        }
        if (this.mLastDirection != direction) {
            this.isSimplePath = false;
            return;
        }
        if (this.rects == null) {
            this.rects = new Region();
        }
        this.rects.op((int) f, (int) f2, (int) f3, (int) f4, Region.Op.UNION);
    }

    private static native void finalizer(long j);

    private static native long init1();

    private static native long init2(long j);

    private static native void native_addArc(long j, float f, float f2, float f3, float f4, float f5, float f6);

    private static native void native_addCircle(long j, float f, float f2, float f3, int i);

    private static native void native_addOval(long j, float f, float f2, float f3, float f4, int i);

    private static native void native_addPath(long j, long j2);

    private static native void native_addPath(long j, long j2, float f, float f2);

    private static native void native_addPath(long j, long j2, long j3);

    private static native void native_addRect(long j, float f, float f2, float f3, float f4, int i);

    private static native void native_addRoundRect(long j, float f, float f2, float f3, float f4, float f5, float f6, int i);

    private static native void native_addRoundRect(long j, float f, float f2, float f3, float f4, float[] fArr, int i);

    private static native float[] native_approximate(long j, float f);

    private static native void native_arcTo(long j, float f, float f2, float f3, float f4, float f5, float f6, boolean z);

    private static native void native_close(long j);

    private static native void native_computeBounds(long j, RectF rectF);

    private static native void native_cubicTo(long j, float f, float f2, float f3, float f4, float f5, float f6);

    private static native int native_getFillType(long j);

    private static native void native_incReserve(long j, int i);

    private static native boolean native_isConvex(long j);

    private static native boolean native_isEmpty(long j);

    private static native boolean native_isRect(long j, RectF rectF);

    private static native void native_lineTo(long j, float f, float f2);

    private static native void native_moveTo(long j, float f, float f2);

    private static native void native_offset(long j, float f, float f2);

    private static native void native_offset(long j, float f, float f2, long j2);

    private static native boolean native_op(long j, long j2, int i, long j3);

    private static native void native_quadTo(long j, float f, float f2, float f3, float f4);

    private static native void native_rCubicTo(long j, float f, float f2, float f3, float f4, float f5, float f6);

    private static native void native_rLineTo(long j, float f, float f2);

    private static native void native_rMoveTo(long j, float f, float f2);

    private static native void native_rQuadTo(long j, float f, float f2, float f3, float f4);

    private static native void native_reset(long j);

    private static native void native_rewind(long j);

    private static native void native_set(long j, long j2);

    private static native void native_setFillType(long j, int i);

    private static native void native_setLastPoint(long j, float f, float f2);

    private static native void native_transform(long j, long j2);

    private static native void native_transform(long j, long j2, long j3);

    public void addArc(float f, float f2, float f3, float f4, float f5, float f6) {
        this.isSimplePath = false;
        native_addArc(this.mNativePath, f, f2, f3, f4, f5, f6);
    }

    public void addArc(RectF rectF, float f, float f2) {
        addArc(rectF.left, rectF.top, rectF.right, rectF.bottom, f, f2);
    }

    public void addCircle(float f, float f2, float f3, Direction direction) {
        this.isSimplePath = false;
        native_addCircle(this.mNativePath, f, f2, f3, direction.nativeInt);
    }

    public void addOval(float f, float f2, float f3, float f4, Direction direction) {
        this.isSimplePath = false;
        native_addOval(this.mNativePath, f, f2, f3, f4, direction.nativeInt);
    }

    public void addOval(RectF rectF, Direction direction) {
        addOval(rectF.left, rectF.top, rectF.right, rectF.bottom, direction);
    }

    public void addPath(Path path) {
        this.isSimplePath = false;
        native_addPath(this.mNativePath, path.mNativePath);
    }

    public void addPath(Path path, float f, float f2) {
        this.isSimplePath = false;
        native_addPath(this.mNativePath, path.mNativePath, f, f2);
    }

    public void addPath(Path path, Matrix matrix) {
        if (!path.isSimplePath) {
            this.isSimplePath = false;
        }
        native_addPath(this.mNativePath, path.mNativePath, matrix.native_instance);
    }

    public void addRect(float f, float f2, float f3, float f4, Direction direction) {
        detectSimplePath(f, f2, f3, f4, direction);
        native_addRect(this.mNativePath, f, f2, f3, f4, direction.nativeInt);
    }

    public void addRect(RectF rectF, Direction direction) {
        addRect(rectF.left, rectF.top, rectF.right, rectF.bottom, direction);
    }

    public void addRoundRect(float f, float f2, float f3, float f4, float f5, float f6, Direction direction) {
        this.isSimplePath = false;
        native_addRoundRect(this.mNativePath, f, f2, f3, f4, f5, f6, direction.nativeInt);
    }

    public void addRoundRect(float f, float f2, float f3, float f4, float[] fArr, Direction direction) {
        if (fArr.length < 8) {
            throw new ArrayIndexOutOfBoundsException("radii[] needs 8 values");
        }
        this.isSimplePath = false;
        native_addRoundRect(this.mNativePath, f, f2, f3, f4, fArr, direction.nativeInt);
    }

    public void addRoundRect(RectF rectF, float f, float f2, Direction direction) {
        addRoundRect(rectF.left, rectF.top, rectF.right, rectF.bottom, f, f2, direction);
    }

    public void addRoundRect(RectF rectF, float[] fArr, Direction direction) {
        if (rectF == null) {
            throw new NullPointerException("need rect parameter");
        }
        addRoundRect(rectF.left, rectF.top, rectF.right, rectF.bottom, fArr, direction);
    }

    public float[] approximate(float f) {
        return native_approximate(this.mNativePath, f);
    }

    public void arcTo(float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
        this.isSimplePath = false;
        native_arcTo(this.mNativePath, f, f2, f3, f4, f5, f6, z);
    }

    public void arcTo(RectF rectF, float f, float f2) {
        arcTo(rectF.left, rectF.top, rectF.right, rectF.bottom, f, f2, false);
    }

    public void arcTo(RectF rectF, float f, float f2, boolean z) {
        arcTo(rectF.left, rectF.top, rectF.right, rectF.bottom, f, f2, z);
    }

    public void close() {
        this.isSimplePath = false;
        native_close(this.mNativePath);
    }

    public void computeBounds(RectF rectF, boolean z) {
        native_computeBounds(this.mNativePath, rectF);
    }

    public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
        this.isSimplePath = false;
        native_cubicTo(this.mNativePath, f, f2, f3, f4, f5, f6);
    }

    protected void finalize() throws Throwable {
        try {
            finalizer(this.mNativePath);
        } finally {
            super.finalize();
        }
    }

    public FillType getFillType() {
        return sFillTypeArray[native_getFillType(this.mNativePath)];
    }

    public void incReserve(int i) {
        native_incReserve(this.mNativePath, i);
    }

    public boolean isConvex() {
        return native_isConvex(this.mNativePath);
    }

    public boolean isEmpty() {
        return native_isEmpty(this.mNativePath);
    }

    public boolean isInverseFillType() {
        return (FillType.INVERSE_WINDING.nativeInt & native_getFillType(this.mNativePath)) != 0;
    }

    public boolean isRect(RectF rectF) {
        return native_isRect(this.mNativePath, rectF);
    }

    public void lineTo(float f, float f2) {
        this.isSimplePath = false;
        native_lineTo(this.mNativePath, f, f2);
    }

    public void moveTo(float f, float f2) {
        native_moveTo(this.mNativePath, f, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long ni() {
        return this.mNativePath;
    }

    public void offset(float f, float f2) {
        this.isSimplePath = false;
        native_offset(this.mNativePath, f, f2);
    }

    public void offset(float f, float f2, Path path) {
        long j = 0;
        if (path != null) {
            j = path.mNativePath;
            path.isSimplePath = false;
        }
        native_offset(this.mNativePath, f, f2, j);
    }

    public boolean op(Path path, Op op) {
        return op(this, path, op);
    }

    public boolean op(Path path, Path path2, Op op) {
        if (native_op(path.mNativePath, path2.mNativePath, op.ordinal(), this.mNativePath)) {
            this.isSimplePath = false;
            this.rects = null;
            return true;
        }
        return false;
    }

    public void quadTo(float f, float f2, float f3, float f4) {
        this.isSimplePath = false;
        native_quadTo(this.mNativePath, f, f2, f3, f4);
    }

    public void rCubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
        this.isSimplePath = false;
        native_rCubicTo(this.mNativePath, f, f2, f3, f4, f5, f6);
    }

    public void rLineTo(float f, float f2) {
        this.isSimplePath = false;
        native_rLineTo(this.mNativePath, f, f2);
    }

    public void rMoveTo(float f, float f2) {
        native_rMoveTo(this.mNativePath, f, f2);
    }

    public void rQuadTo(float f, float f2, float f3, float f4) {
        this.isSimplePath = false;
        native_rQuadTo(this.mNativePath, f, f2, f3, f4);
    }

    public void reset() {
        this.isSimplePath = true;
        this.mLastDirection = null;
        if (this.rects != null) {
            this.rects.setEmpty();
        }
        FillType fillType = getFillType();
        native_reset(this.mNativePath);
        setFillType(fillType);
    }

    public void rewind() {
        this.isSimplePath = true;
        this.mLastDirection = null;
        if (this.rects != null) {
            this.rects.setEmpty();
        }
        native_rewind(this.mNativePath);
    }

    public void set(Path path) {
        if (this != path) {
            this.isSimplePath = path.isSimplePath;
            native_set(this.mNativePath, path.mNativePath);
        }
    }

    public void setFillType(FillType fillType) {
        native_setFillType(this.mNativePath, fillType.nativeInt);
    }

    public void setLastPoint(float f, float f2) {
        this.isSimplePath = false;
        native_setLastPoint(this.mNativePath, f, f2);
    }

    public void toggleInverseFillType() {
        native_setFillType(this.mNativePath, native_getFillType(this.mNativePath) ^ FillType.INVERSE_WINDING.nativeInt);
    }

    public void transform(Matrix matrix) {
        this.isSimplePath = false;
        native_transform(this.mNativePath, matrix.native_instance);
    }

    public void transform(Matrix matrix, Path path) {
        long j = 0;
        if (path != null) {
            path.isSimplePath = false;
            j = path.mNativePath;
        }
        native_transform(this.mNativePath, matrix.native_instance, j);
    }
}
