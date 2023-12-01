package android.system;

import java.net.InetAddress;
import libcore.util.Objects;

/* loaded from: source-2895416-dex2jar.jar:android/system/StructGroupSourceReq.class */
public final class StructGroupSourceReq {
    public final InetAddress gsr_group;
    public final int gsr_interface;
    public final InetAddress gsr_source;

    public StructGroupSourceReq(int i, InetAddress inetAddress, InetAddress inetAddress2) {
        this.gsr_interface = i;
        this.gsr_group = inetAddress;
        this.gsr_source = inetAddress2;
    }

    public String toString() {
        return Objects.toString(this);
    }
}
