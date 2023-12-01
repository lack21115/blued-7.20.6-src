package android.system;

import libcore.util.Objects;

/* loaded from: source-2895416-dex2jar.jar:android/system/StructStat.class */
public final class StructStat {
    public final long st_atime;
    public final long st_blksize;
    public final long st_blocks;
    public final long st_ctime;
    public final long st_dev;
    public final int st_gid;
    public final long st_ino;
    public final int st_mode;
    public final long st_mtime;
    public final long st_nlink;
    public final long st_rdev;
    public final long st_size;
    public final int st_uid;

    public StructStat(long j, long j2, int i, long j3, int i2, int i3, long j4, long j5, long j6, long j7, long j8, long j9, long j10) {
        this.st_dev = j;
        this.st_ino = j2;
        this.st_mode = i;
        this.st_nlink = j3;
        this.st_uid = i2;
        this.st_gid = i3;
        this.st_rdev = j4;
        this.st_size = j5;
        this.st_atime = j6;
        this.st_mtime = j7;
        this.st_ctime = j8;
        this.st_blksize = j9;
        this.st_blocks = j10;
    }

    public String toString() {
        return Objects.toString(this);
    }
}
