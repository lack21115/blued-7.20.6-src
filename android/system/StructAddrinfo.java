package android.system;

import java.net.InetAddress;
import libcore.util.Objects;

/* loaded from: source-2895416-dex2jar.jar:android/system/StructAddrinfo.class */
public final class StructAddrinfo {
    public InetAddress ai_addr;
    public int ai_family;
    public int ai_flags;
    public StructAddrinfo ai_next;
    public int ai_protocol;
    public int ai_socktype;

    public String toString() {
        return Objects.toString(this);
    }
}
