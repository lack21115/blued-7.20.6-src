package android.system;

import java.io.FileDescriptor;
import libcore.util.Objects;

/* loaded from: source-2895416-dex2jar.jar:android/system/StructPollfd.class */
public final class StructPollfd {
    public short events;
    public FileDescriptor fd;
    public short revents;
    public Object userData;

    public String toString() {
        return Objects.toString(this);
    }
}
