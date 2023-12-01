package javax.microedition.khronos.egl;

import com.google.android.gles_jni.EGLImpl;
import javax.microedition.khronos.opengles.GL;

/* loaded from: source-4181928-dex2jar.jar:javax/microedition/khronos/egl/EGLContext.class */
public abstract class EGLContext {
    private static final EGL EGL_INSTANCE = new EGLImpl();

    public static EGL getEGL() {
        return EGL_INSTANCE;
    }

    public abstract GL getGL();
}
