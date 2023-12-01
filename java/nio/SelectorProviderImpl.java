package java.nio;

import java.io.IOException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.Pipe;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;

/* loaded from: source-2895416-dex2jar.jar:java/nio/SelectorProviderImpl.class */
public final class SelectorProviderImpl extends SelectorProvider {
    @Override // java.nio.channels.spi.SelectorProvider
    public DatagramChannel openDatagramChannel() throws IOException {
        return new DatagramChannelImpl(this);
    }

    @Override // java.nio.channels.spi.SelectorProvider
    public Pipe openPipe() throws IOException {
        return new PipeImpl(this);
    }

    @Override // java.nio.channels.spi.SelectorProvider
    public AbstractSelector openSelector() throws IOException {
        return new SelectorImpl(this);
    }

    @Override // java.nio.channels.spi.SelectorProvider
    public ServerSocketChannel openServerSocketChannel() throws IOException {
        return new ServerSocketChannelImpl(this);
    }

    @Override // java.nio.channels.spi.SelectorProvider
    public SocketChannel openSocketChannel() throws IOException {
        return new SocketChannelImpl(this);
    }
}
