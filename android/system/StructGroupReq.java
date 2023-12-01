package android.system;

import java.net.InetAddress;
import libcore.util.Objects;

/* loaded from: source-2895416-dex2jar.jar:android/system/StructGroupReq.class */
public final class StructGroupReq {
    public final InetAddress gr_group;
    public final int gr_interface;

    public StructGroupReq(int i, InetAddress inetAddress) {
        this.gr_interface = i;
        this.gr_group = inetAddress;
    }

    public String toString() {
        return Objects.toString(this);
    }
}
