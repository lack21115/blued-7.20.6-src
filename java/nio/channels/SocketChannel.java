package java.nio.channels;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;

/* loaded from: source-2895416-dex2jar.jar:java/nio/channels/SocketChannel.class */
public abstract class SocketChannel extends AbstractSelectableChannel implements ByteChannel, ScatteringByteChannel, GatheringByteChannel {
    /* JADX INFO: Access modifiers changed from: protected */
    public SocketChannel(SelectorProvider selectorProvider) {
        super(selectorProvider);
    }

    public static SocketChannel open() throws IOException {
        return SelectorProvider.provider().openSocketChannel();
    }

    public static SocketChannel open(SocketAddress socketAddress) throws IOException {
        SocketChannel open = open();
        if (open != null) {
            open.connect(socketAddress);
        }
        return open;
    }

    public abstract boolean connect(SocketAddress socketAddress) throws IOException;

    public abstract boolean finishConnect() throws IOException;

    public abstract boolean isConnected();

    public abstract boolean isConnectionPending();

    public abstract int read(ByteBuffer byteBuffer) throws IOException;

    @Override // java.nio.channels.ScatteringByteChannel
    public final long read(ByteBuffer[] byteBufferArr) throws IOException {
        long read;
        synchronized (this) {
            read = read(byteBufferArr, 0, byteBufferArr.length);
        }
        return read;
    }

    public abstract long read(ByteBuffer[] byteBufferArr, int i, int i2) throws IOException;

    public abstract Socket socket();

    @Override // java.nio.channels.SelectableChannel
    public final int validOps() {
        return 13;
    }

    public abstract int write(ByteBuffer byteBuffer) throws IOException;

    @Override // java.nio.channels.GatheringByteChannel
    public final long write(ByteBuffer[] byteBufferArr) throws IOException {
        long write;
        synchronized (this) {
            write = write(byteBufferArr, 0, byteBufferArr.length);
        }
        return write;
    }

    public abstract long write(ByteBuffer[] byteBufferArr, int i, int i2) throws IOException;
}
