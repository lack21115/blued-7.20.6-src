package dalvik.system;

import java.io.FileDescriptor;
import java.net.Socket;
import java.net.SocketException;

/* loaded from: source-2895416-dex2jar.jar:dalvik/system/SocketTagger.class */
public abstract class SocketTagger {
    private static SocketTagger tagger = new SocketTagger() { // from class: dalvik.system.SocketTagger.1
        @Override // dalvik.system.SocketTagger
        public void tag(FileDescriptor fileDescriptor) throws SocketException {
        }

        @Override // dalvik.system.SocketTagger
        public void untag(FileDescriptor fileDescriptor) throws SocketException {
        }
    };

    public static SocketTagger get() {
        SocketTagger socketTagger;
        synchronized (SocketTagger.class) {
            try {
                socketTagger = tagger;
            } catch (Throwable th) {
                throw th;
            }
        }
        return socketTagger;
    }

    public static void set(SocketTagger socketTagger) {
        synchronized (SocketTagger.class) {
            try {
                if (socketTagger == null) {
                    throw new NullPointerException("tagger == null");
                }
                tagger = socketTagger;
            } finally {
            }
        }
    }

    public abstract void tag(FileDescriptor fileDescriptor) throws SocketException;

    public final void tag(Socket socket) throws SocketException {
        if (socket.isClosed()) {
            return;
        }
        tag(socket.getFileDescriptor$());
    }

    public abstract void untag(FileDescriptor fileDescriptor) throws SocketException;

    public final void untag(Socket socket) throws SocketException {
        if (socket.isClosed()) {
            return;
        }
        untag(socket.getFileDescriptor$());
    }
}
