package android.system;

import libcore.util.Objects;

/* loaded from: source-2895416-dex2jar.jar:android/system/StructUcred.class */
public final class StructUcred {
    public final int gid;
    public final int pid;
    public final int uid;

    public StructUcred(int i, int i2, int i3) {
        this.pid = i;
        this.uid = i2;
        this.gid = i3;
    }

    public String toString() {
        return Objects.toString(this);
    }
}
