package android.system;

import libcore.util.Objects;

/* loaded from: source-2895416-dex2jar.jar:android/system/StructFlock.class */
public final class StructFlock {
    public long l_len;
    public int l_pid;
    public long l_start;
    public short l_type;
    public short l_whence;

    public String toString() {
        return Objects.toString(this);
    }
}
