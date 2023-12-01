package android.opengl;

import com.blued.das.live.LiveProtos;

/* loaded from: source-9557208-dex2jar.jar:android/opengl/EGLObjectHandle.class */
public abstract class EGLObjectHandle {
    private final long mHandle;

    @Deprecated
    protected EGLObjectHandle(int i) {
        this.mHandle = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public EGLObjectHandle(long j) {
        this.mHandle = j;
    }

    @Deprecated
    public int getHandle() {
        if ((this.mHandle & 4294967295L) != this.mHandle) {
            throw new UnsupportedOperationException();
        }
        return (int) this.mHandle;
    }

    public long getNativeHandle() {
        return this.mHandle;
    }

    public int hashCode() {
        return ((int) (this.mHandle ^ (this.mHandle >>> 32))) + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE;
    }
}
