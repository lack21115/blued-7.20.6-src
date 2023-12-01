package android.system;

import libcore.util.Objects;

/* loaded from: source-2895416-dex2jar.jar:android/system/StructTimeval.class */
public final class StructTimeval {
    public final long tv_sec;
    public final long tv_usec;

    private StructTimeval(long j, long j2) {
        this.tv_sec = j;
        this.tv_usec = j2;
    }

    public static StructTimeval fromMillis(long j) {
        long j2 = j / 1000;
        return new StructTimeval(j2, (j - (j2 * 1000)) * 1000);
    }

    public long toMillis() {
        return (this.tv_sec * 1000) + (this.tv_usec / 1000);
    }

    public String toString() {
        return Objects.toString(this);
    }
}
