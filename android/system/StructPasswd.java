package android.system;

import libcore.util.Objects;

/* loaded from: source-2895416-dex2jar.jar:android/system/StructPasswd.class */
public final class StructPasswd {
    public final String pw_dir;
    public final int pw_gid;
    public final String pw_name;
    public final String pw_shell;
    public final int pw_uid;

    public StructPasswd(String str, int i, int i2, String str2, String str3) {
        this.pw_name = str;
        this.pw_uid = i;
        this.pw_gid = i2;
        this.pw_dir = str2;
        this.pw_shell = str3;
    }

    public String toString() {
        return Objects.toString(this);
    }
}
