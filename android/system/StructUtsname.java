package android.system;

import libcore.util.Objects;

/* loaded from: source-2895416-dex2jar.jar:android/system/StructUtsname.class */
public final class StructUtsname {
    public final String machine;
    public final String nodename;
    public final String release;
    public final String sysname;
    public final String version;

    public StructUtsname(String str, String str2, String str3, String str4, String str5) {
        this.sysname = str;
        this.nodename = str2;
        this.release = str3;
        this.version = str4;
        this.machine = str5;
    }

    public String toString() {
        return Objects.toString(this);
    }
}
