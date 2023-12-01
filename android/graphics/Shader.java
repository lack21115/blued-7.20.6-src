package android.graphics;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/Shader.class */
public class Shader {
    private Matrix mLocalMatrix;
    private long native_instance;

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Shader$TileMode.class */
    public enum TileMode {
        CLAMP(0),
        REPEAT(1),
        MIRROR(2);
        
        final int nativeInt;

        TileMode(int i) {
            this.nativeInt = i;
        }
    }

    private static native void nativeDestructor(long j);

    private static native void nativeSetLocalMatrix(long j, long j2);

    /* JADX INFO: Access modifiers changed from: protected */
    public Shader copy() {
        Shader shader = new Shader();
        copyLocalMatrix(shader);
        return shader;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void copyLocalMatrix(Shader shader) {
        if (this.mLocalMatrix == null) {
            shader.setLocalMatrix(null);
            return;
        }
        Matrix matrix = new Matrix();
        getLocalMatrix(matrix);
        shader.setLocalMatrix(matrix);
    }

    protected void finalize() throws Throwable {
        try {
            super.finalize();
        } finally {
            nativeDestructor(this.native_instance);
        }
    }

    public boolean getLocalMatrix(Matrix matrix) {
        boolean z = false;
        if (this.mLocalMatrix != null) {
            matrix.set(this.mLocalMatrix);
            z = false;
            if (!this.mLocalMatrix.isIdentity()) {
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNativeInstance() {
        return this.native_instance;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init(long j) {
        this.native_instance = j;
    }

    public void setLocalMatrix(Matrix matrix) {
        this.mLocalMatrix = matrix;
        nativeSetLocalMatrix(this.native_instance, matrix == null ? 0L : matrix.native_instance);
    }
}
