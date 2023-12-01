package libcore.io;

import java.io.FileDescriptor;

/* loaded from: source-2895416-dex2jar.jar:libcore/io/AsynchronousCloseMonitor.class */
public final class AsynchronousCloseMonitor {
    private AsynchronousCloseMonitor() {
    }

    public static native void signalBlockedThreads(FileDescriptor fileDescriptor);
}
