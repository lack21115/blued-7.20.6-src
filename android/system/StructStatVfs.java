package android.system;

import libcore.util.Objects;

/* loaded from: source-2895416-dex2jar.jar:android/system/StructStatVfs.class */
public final class StructStatVfs {
    public final long f_bavail;
    public final long f_bfree;
    public final long f_blocks;
    public final long f_bsize;
    public final long f_favail;
    public final long f_ffree;
    public final long f_files;
    public final long f_flag;
    public final long f_frsize;
    public final long f_fsid;
    public final long f_namemax;

    public StructStatVfs(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11) {
        this.f_bsize = j;
        this.f_frsize = j2;
        this.f_blocks = j3;
        this.f_bfree = j4;
        this.f_bavail = j5;
        this.f_files = j6;
        this.f_ffree = j7;
        this.f_favail = j8;
        this.f_fsid = j9;
        this.f_flag = j10;
        this.f_namemax = j11;
    }

    public String toString() {
        return Objects.toString(this);
    }
}
