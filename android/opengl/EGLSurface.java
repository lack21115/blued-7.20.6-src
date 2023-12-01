package android.opengl;

/* loaded from: source-9557208-dex2jar.jar:android/opengl/EGLSurface.class */
public class EGLSurface extends EGLObjectHandle {
    private EGLSurface(long j) {
        super(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EGLSurface) && getNativeHandle() == ((EGLSurface) obj).getNativeHandle();
    }
}
