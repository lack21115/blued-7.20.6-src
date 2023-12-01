package java.nio.channels.spi;

import java.io.IOException;
import java.nio.SelectorProviderImpl;
import java.nio.channels.Channel;
import java.nio.channels.DatagramChannel;
import java.nio.channels.Pipe;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.ServiceLoader;

/* loaded from: source-2895416-dex2jar.jar:java/nio/channels/spi/SelectorProvider.class */
public abstract class SelectorProvider {
    private static SelectorProvider provider = null;

    private static SelectorProvider loadProviderByJar() {
        Iterator it = ServiceLoader.load(SelectorProvider.class).iterator();
        if (it.hasNext()) {
            return (SelectorProvider) it.next();
        }
        return null;
    }

    public static SelectorProvider provider() {
        SelectorProvider selectorProvider;
        synchronized (SelectorProvider.class) {
            try {
                if (provider == null) {
                    provider = (SelectorProvider) ServiceLoader.loadFromSystemProperty(SelectorProvider.class);
                    if (provider == null) {
                        provider = loadProviderByJar();
                    }
                    if (provider == null) {
                        provider = new SelectorProviderImpl();
                    }
                }
                selectorProvider = provider;
            } catch (Throwable th) {
                throw th;
            }
        }
        return selectorProvider;
    }

    public Channel inheritedChannel() throws IOException {
        return null;
    }

    public abstract DatagramChannel openDatagramChannel() throws IOException;

    public abstract Pipe openPipe() throws IOException;

    public abstract AbstractSelector openSelector() throws IOException;

    public abstract ServerSocketChannel openServerSocketChannel() throws IOException;

    public abstract SocketChannel openSocketChannel() throws IOException;
}
