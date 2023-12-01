package android.opengl;

/* loaded from: source-9557208-dex2jar.jar:android/opengl/GLException.class */
public class GLException extends RuntimeException {
    private final int mError;

    public GLException(int i) {
        super(getErrorString(i));
        this.mError = i;
    }

    public GLException(int i, String str) {
        super(str);
        this.mError = i;
    }

    private static String getErrorString(int i) {
        String gluErrorString = GLU.gluErrorString(i);
        String str = gluErrorString;
        if (gluErrorString == null) {
            str = "Unknown error 0x" + Integer.toHexString(i);
        }
        return str;
    }

    int getError() {
        return this.mError;
    }
}
