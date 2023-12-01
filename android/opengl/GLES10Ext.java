package android.opengl;

import java.nio.IntBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/opengl/GLES10Ext.class */
public class GLES10Ext {
    static {
        _nativeClassInit();
    }

    private static native void _nativeClassInit();

    public static native int glQueryMatrixxOES(IntBuffer intBuffer, IntBuffer intBuffer2);

    public static native int glQueryMatrixxOES(int[] iArr, int i, int[] iArr2, int i2);
}
