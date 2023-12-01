package java.nio.channels;

import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:java/nio/channels/FileLock.class */
public abstract class FileLock implements AutoCloseable {
    private final FileChannel channel;
    private final long position;
    private final boolean shared;
    private final long size;

    /* JADX INFO: Access modifiers changed from: protected */
    public FileLock(FileChannel fileChannel, long j, long j2, boolean z) {
        if (j < 0 || j2 < 0 || j + j2 < 0) {
            throw new IllegalArgumentException("position=" + j + " size=" + j2);
        }
        this.channel = fileChannel;
        this.position = j;
        this.size = j2;
        this.shared = z;
    }

    public final FileChannel channel() {
        return this.channel;
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws IOException {
        release();
    }

    public final boolean isShared() {
        return this.shared;
    }

    public abstract boolean isValid();

    public final boolean overlaps(long j, long j2) {
        return (this.position + this.size) - 1 >= j && this.position <= (j + j2) - 1;
    }

    public final long position() {
        return this.position;
    }

    public abstract void release() throws IOException;

    public final long size() {
        return this.size;
    }

    public final String toString() {
        return "FileLock[position=" + this.position + ", size=" + this.size + ", shared=" + this.shared + "]";
    }
}
