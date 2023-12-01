package android.opengl;

/* loaded from: source-9557208-dex2jar.jar:android/opengl/EGLConfig.class */
public class EGLConfig extends EGLObjectHandle {
    private EGLConfig(long j) {
        super(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EGLConfig) && getNativeHandle() == ((EGLConfig) obj).getNativeHandle();
    }
}
