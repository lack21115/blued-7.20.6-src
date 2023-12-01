package android.opengl;

/* loaded from: source-9557208-dex2jar.jar:android/opengl/EGLDisplay.class */
public class EGLDisplay extends EGLObjectHandle {
    private EGLDisplay(long j) {
        super(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EGLDisplay) && getNativeHandle() == ((EGLDisplay) obj).getNativeHandle();
    }
}
