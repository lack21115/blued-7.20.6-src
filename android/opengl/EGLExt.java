package android.opengl;

/* loaded from: source-9557208-dex2jar.jar:android/opengl/EGLExt.class */
public class EGLExt {
    public static final int EGL_CONTEXT_FLAGS_KHR = 12540;
    public static final int EGL_CONTEXT_MAJOR_VERSION_KHR = 12440;
    public static final int EGL_CONTEXT_MINOR_VERSION_KHR = 12539;
    public static final int EGL_OPENGL_ES3_BIT_KHR = 64;

    static {
        _nativeClassInit();
    }

    private static native void _nativeClassInit();

    public static native boolean eglPresentationTimeANDROID(EGLDisplay eGLDisplay, EGLSurface eGLSurface, long j);
}
