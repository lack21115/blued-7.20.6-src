package java.net;

import java.io.FileDescriptor;
import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:java/net/PlainServerSocketImpl.class */
public class PlainServerSocketImpl extends PlainSocketImpl {
    public PlainServerSocketImpl() {
    }

    public PlainServerSocketImpl(FileDescriptor fileDescriptor) {
        super(fileDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.PlainSocketImpl, java.net.SocketImpl
    public void create(boolean z) throws IOException {
        super.create(z);
        if (z) {
            setOption(4, Boolean.TRUE);
        }
    }
}
