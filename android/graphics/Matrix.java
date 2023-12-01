package android.graphics;

import java.io.PrintWriter;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/Matrix.class */
public class Matrix {
    public static Matrix IDENTITY_MATRIX = new Matrix() { // from class: android.graphics.Matrix.1
        void oops() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        @Override // android.graphics.Matrix
        public boolean postConcat(Matrix matrix) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f, float f2, float f3) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f, float f2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f, float f2, float f3, float f4) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f, float f2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f, float f2, float f3, float f4) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postTranslate(float f, float f2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preConcat(Matrix matrix) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f, float f2, float f3) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f, float f2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f, float f2, float f3, float f4) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f, float f2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f, float f2, float f3, float f4) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preTranslate(float f, float f2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void reset() {
            oops();
        }

        @Override // android.graphics.Matrix
        public void set(Matrix matrix) {
            oops();
        }

        @Override // android.graphics.Matrix
        public boolean setConcat(Matrix matrix, Matrix matrix2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setPolyToPoly(float[] fArr, int i, float[] fArr2, int i2, int i3) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setRectToRect(RectF rectF, RectF rectF2, ScaleToFit scaleToFit) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f, float f2, float f3) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f, float f2) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f, float f2, float f3, float f4) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f, float f2) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f, float f2, float f3, float f4) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f, float f2) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f, float f2, float f3, float f4) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setTranslate(float f, float f2) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setValues(float[] fArr) {
            oops();
        }
    };
    public static final int MPERSP_0 = 6;
    public static final int MPERSP_1 = 7;
    public static final int MPERSP_2 = 8;
    public static final int MSCALE_X = 0;
    public static final int MSCALE_Y = 4;
    public static final int MSKEW_X = 1;
    public static final int MSKEW_Y = 3;
    public static final int MTRANS_X = 2;
    public static final int MTRANS_Y = 5;
    public long native_instance;

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Matrix$ScaleToFit.class */
    public enum ScaleToFit {
        FILL(0),
        START(1),
        CENTER(2),
        END(3);
        
        final int nativeInt;

        ScaleToFit(int i) {
            this.nativeInt = i;
        }
    }

    public Matrix() {
        this.native_instance = native_create(0L);
    }

    public Matrix(Matrix matrix) {
        this.native_instance = native_create(matrix != null ? matrix.native_instance : 0L);
    }

    private static void checkPointArrays(float[] fArr, int i, float[] fArr2, int i2, int i3) {
        int i4 = i + (i3 << 1);
        int i5 = i2 + (i3 << 1);
        if ((i3 | i | i2 | i4 | i5) < 0 || i4 > fArr.length || i5 > fArr2.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private static native void finalizer(long j);

    private static native long native_create(long j);

    private static native boolean native_equals(long j, long j2);

    private static native void native_getValues(long j, float[] fArr);

    private static native boolean native_invert(long j, long j2);

    private static native boolean native_isAffine(long j);

    private static native boolean native_isIdentity(long j);

    private static native void native_mapPoints(long j, float[] fArr, int i, float[] fArr2, int i2, int i3, boolean z);

    private static native float native_mapRadius(long j, float f);

    private static native boolean native_mapRect(long j, RectF rectF, RectF rectF2);

    private static native void native_postConcat(long j, long j2);

    private static native void native_postRotate(long j, float f);

    private static native void native_postRotate(long j, float f, float f2, float f3);

    private static native void native_postScale(long j, float f, float f2);

    private static native void native_postScale(long j, float f, float f2, float f3, float f4);

    private static native void native_postSkew(long j, float f, float f2);

    private static native void native_postSkew(long j, float f, float f2, float f3, float f4);

    private static native void native_postTranslate(long j, float f, float f2);

    private static native void native_preConcat(long j, long j2);

    private static native void native_preRotate(long j, float f);

    private static native void native_preRotate(long j, float f, float f2, float f3);

    private static native void native_preScale(long j, float f, float f2);

    private static native void native_preScale(long j, float f, float f2, float f3, float f4);

    private static native void native_preSkew(long j, float f, float f2);

    private static native void native_preSkew(long j, float f, float f2, float f3, float f4);

    private static native void native_preTranslate(long j, float f, float f2);

    private static native boolean native_rectStaysRect(long j);

    private static native void native_reset(long j);

    private static native void native_set(long j, long j2);

    private static native void native_setConcat(long j, long j2, long j3);

    private static native boolean native_setPolyToPoly(long j, float[] fArr, int i, float[] fArr2, int i2, int i3);

    private static native boolean native_setRectToRect(long j, RectF rectF, RectF rectF2, int i);

    private static native void native_setRotate(long j, float f);

    private static native void native_setRotate(long j, float f, float f2, float f3);

    private static native void native_setScale(long j, float f, float f2);

    private static native void native_setScale(long j, float f, float f2, float f3, float f4);

    private static native void native_setSinCos(long j, float f, float f2);

    private static native void native_setSinCos(long j, float f, float f2, float f3, float f4);

    private static native void native_setSkew(long j, float f, float f2);

    private static native void native_setSkew(long j, float f, float f2, float f3, float f4);

    private static native void native_setTranslate(long j, float f, float f2);

    private static native void native_setValues(long j, float[] fArr);

    public boolean equals(Object obj) {
        if (obj instanceof Matrix) {
            return native_equals(this.native_instance, ((Matrix) obj).native_instance);
        }
        return false;
    }

    protected void finalize() throws Throwable {
        try {
            finalizer(this.native_instance);
        } finally {
            super.finalize();
        }
    }

    public void getValues(float[] fArr) {
        if (fArr.length < 9) {
            throw new ArrayIndexOutOfBoundsException();
        }
        native_getValues(this.native_instance, fArr);
    }

    public int hashCode() {
        return 44;
    }

    public boolean invert(Matrix matrix) {
        return native_invert(this.native_instance, matrix.native_instance);
    }

    public boolean isAffine() {
        return native_isAffine(this.native_instance);
    }

    public boolean isIdentity() {
        return native_isIdentity(this.native_instance);
    }

    public void mapPoints(float[] fArr) {
        mapPoints(fArr, 0, fArr, 0, fArr.length >> 1);
    }

    public void mapPoints(float[] fArr, int i, float[] fArr2, int i2, int i3) {
        checkPointArrays(fArr2, i2, fArr, i, i3);
        native_mapPoints(this.native_instance, fArr, i, fArr2, i2, i3, true);
    }

    public void mapPoints(float[] fArr, float[] fArr2) {
        if (fArr.length != fArr2.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        mapPoints(fArr, 0, fArr2, 0, fArr.length >> 1);
    }

    public float mapRadius(float f) {
        return native_mapRadius(this.native_instance, f);
    }

    public boolean mapRect(RectF rectF) {
        return mapRect(rectF, rectF);
    }

    public boolean mapRect(RectF rectF, RectF rectF2) {
        if (rectF == null || rectF2 == null) {
            throw new NullPointerException();
        }
        return native_mapRect(this.native_instance, rectF, rectF2);
    }

    public void mapVectors(float[] fArr) {
        mapVectors(fArr, 0, fArr, 0, fArr.length >> 1);
    }

    public void mapVectors(float[] fArr, int i, float[] fArr2, int i2, int i3) {
        checkPointArrays(fArr2, i2, fArr, i, i3);
        native_mapPoints(this.native_instance, fArr, i, fArr2, i2, i3, false);
    }

    public void mapVectors(float[] fArr, float[] fArr2) {
        if (fArr.length != fArr2.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        mapVectors(fArr, 0, fArr2, 0, fArr.length >> 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long ni() {
        return this.native_instance;
    }

    public boolean postConcat(Matrix matrix) {
        native_postConcat(this.native_instance, matrix.native_instance);
        return true;
    }

    public boolean postRotate(float f) {
        native_postRotate(this.native_instance, f);
        return true;
    }

    public boolean postRotate(float f, float f2, float f3) {
        native_postRotate(this.native_instance, f, f2, f3);
        return true;
    }

    public boolean postScale(float f, float f2) {
        native_postScale(this.native_instance, f, f2);
        return true;
    }

    public boolean postScale(float f, float f2, float f3, float f4) {
        native_postScale(this.native_instance, f, f2, f3, f4);
        return true;
    }

    public boolean postSkew(float f, float f2) {
        native_postSkew(this.native_instance, f, f2);
        return true;
    }

    public boolean postSkew(float f, float f2, float f3, float f4) {
        native_postSkew(this.native_instance, f, f2, f3, f4);
        return true;
    }

    public boolean postTranslate(float f, float f2) {
        native_postTranslate(this.native_instance, f, f2);
        return true;
    }

    public boolean preConcat(Matrix matrix) {
        native_preConcat(this.native_instance, matrix.native_instance);
        return true;
    }

    public boolean preRotate(float f) {
        native_preRotate(this.native_instance, f);
        return true;
    }

    public boolean preRotate(float f, float f2, float f3) {
        native_preRotate(this.native_instance, f, f2, f3);
        return true;
    }

    public boolean preScale(float f, float f2) {
        native_preScale(this.native_instance, f, f2);
        return true;
    }

    public boolean preScale(float f, float f2, float f3, float f4) {
        native_preScale(this.native_instance, f, f2, f3, f4);
        return true;
    }

    public boolean preSkew(float f, float f2) {
        native_preSkew(this.native_instance, f, f2);
        return true;
    }

    public boolean preSkew(float f, float f2, float f3, float f4) {
        native_preSkew(this.native_instance, f, f2, f3, f4);
        return true;
    }

    public boolean preTranslate(float f, float f2) {
        native_preTranslate(this.native_instance, f, f2);
        return true;
    }

    public void printShortString(PrintWriter printWriter) {
        float[] fArr = new float[9];
        getValues(fArr);
        printWriter.print('[');
        printWriter.print(fArr[0]);
        printWriter.print(", ");
        printWriter.print(fArr[1]);
        printWriter.print(", ");
        printWriter.print(fArr[2]);
        printWriter.print("][");
        printWriter.print(fArr[3]);
        printWriter.print(", ");
        printWriter.print(fArr[4]);
        printWriter.print(", ");
        printWriter.print(fArr[5]);
        printWriter.print("][");
        printWriter.print(fArr[6]);
        printWriter.print(", ");
        printWriter.print(fArr[7]);
        printWriter.print(", ");
        printWriter.print(fArr[8]);
        printWriter.print(']');
    }

    public boolean rectStaysRect() {
        return native_rectStaysRect(this.native_instance);
    }

    public void reset() {
        native_reset(this.native_instance);
    }

    public void set(Matrix matrix) {
        if (matrix == null) {
            reset();
        } else {
            native_set(this.native_instance, matrix.native_instance);
        }
    }

    public boolean setConcat(Matrix matrix, Matrix matrix2) {
        native_setConcat(this.native_instance, matrix.native_instance, matrix2.native_instance);
        return true;
    }

    public boolean setPolyToPoly(float[] fArr, int i, float[] fArr2, int i2, int i3) {
        if (i3 > 4) {
            throw new IllegalArgumentException();
        }
        checkPointArrays(fArr, i, fArr2, i2, i3);
        return native_setPolyToPoly(this.native_instance, fArr, i, fArr2, i2, i3);
    }

    public boolean setRectToRect(RectF rectF, RectF rectF2, ScaleToFit scaleToFit) {
        if (rectF2 == null || rectF == null) {
            throw new NullPointerException();
        }
        return native_setRectToRect(this.native_instance, rectF, rectF2, scaleToFit.nativeInt);
    }

    public void setRotate(float f) {
        native_setRotate(this.native_instance, f);
    }

    public void setRotate(float f, float f2, float f3) {
        native_setRotate(this.native_instance, f, f2, f3);
    }

    public void setScale(float f, float f2) {
        native_setScale(this.native_instance, f, f2);
    }

    public void setScale(float f, float f2, float f3, float f4) {
        native_setScale(this.native_instance, f, f2, f3, f4);
    }

    public void setSinCos(float f, float f2) {
        native_setSinCos(this.native_instance, f, f2);
    }

    public void setSinCos(float f, float f2, float f3, float f4) {
        native_setSinCos(this.native_instance, f, f2, f3, f4);
    }

    public void setSkew(float f, float f2) {
        native_setSkew(this.native_instance, f, f2);
    }

    public void setSkew(float f, float f2, float f3, float f4) {
        native_setSkew(this.native_instance, f, f2, f3, f4);
    }

    public void setTranslate(float f, float f2) {
        native_setTranslate(this.native_instance, f, f2);
    }

    public void setValues(float[] fArr) {
        if (fArr.length < 9) {
            throw new ArrayIndexOutOfBoundsException();
        }
        native_setValues(this.native_instance, fArr);
    }

    public String toShortString() {
        StringBuilder sb = new StringBuilder(64);
        toShortString(sb);
        return sb.toString();
    }

    public void toShortString(StringBuilder sb) {
        float[] fArr = new float[9];
        getValues(fArr);
        sb.append('[');
        sb.append(fArr[0]);
        sb.append(", ");
        sb.append(fArr[1]);
        sb.append(", ");
        sb.append(fArr[2]);
        sb.append("][");
        sb.append(fArr[3]);
        sb.append(", ");
        sb.append(fArr[4]);
        sb.append(", ");
        sb.append(fArr[5]);
        sb.append("][");
        sb.append(fArr[6]);
        sb.append(", ");
        sb.append(fArr[7]);
        sb.append(", ");
        sb.append(fArr[8]);
        sb.append(']');
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("Matrix{");
        toShortString(sb);
        sb.append('}');
        return sb.toString();
    }
}
