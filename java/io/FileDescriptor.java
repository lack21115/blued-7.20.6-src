package java.io;

import android.system.ErrnoException;
import android.system.OsConstants;
import libcore.io.Libcore;

/* loaded from: source-2895416-dex2jar.jar:java/io/FileDescriptor.class */
public final class FileDescriptor {
    private int descriptor = -1;

    /* renamed from: in  reason: collision with root package name */
    public static final FileDescriptor f42253in = new FileDescriptor();
    public static final FileDescriptor out = new FileDescriptor();
    public static final FileDescriptor err = new FileDescriptor();

    static {
        f42253in.descriptor = OsConstants.STDIN_FILENO;
        out.descriptor = OsConstants.STDOUT_FILENO;
        err.descriptor = OsConstants.STDERR_FILENO;
    }

    private static native boolean isSocket(int i);

    public final int getInt$() {
        return this.descriptor;
    }

    public boolean isSocket() {
        return isSocket(this.descriptor);
    }

    public final void setInt$(int i) {
        this.descriptor = i;
    }

    public void sync() throws SyncFailedException {
        try {
            if (Libcore.os.isatty(this)) {
                Libcore.os.tcdrain(this);
            } else {
                Libcore.os.fsync(this);
            }
        } catch (ErrnoException e) {
            SyncFailedException syncFailedException = new SyncFailedException(e.getMessage());
            syncFailedException.initCause(e);
            throw syncFailedException;
        }
    }

    public String toString() {
        return "FileDescriptor[" + this.descriptor + "]";
    }

    public boolean valid() {
        return this.descriptor != -1;
    }
}
