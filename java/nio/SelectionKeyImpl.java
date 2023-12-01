package java.nio;

import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.AbstractSelectionKey;

/* loaded from: source-2895416-dex2jar.jar:java/nio/SelectionKeyImpl.class */
final class SelectionKeyImpl extends AbstractSelectionKey {
    private AbstractSelectableChannel channel;
    private int interestOps;
    private int readyOps;
    private SelectorImpl selector;

    public SelectionKeyImpl(AbstractSelectableChannel abstractSelectableChannel, int i, Object obj, SelectorImpl selectorImpl) {
        this.channel = abstractSelectableChannel;
        this.interestOps = i;
        this.selector = selectorImpl;
        attach(obj);
    }

    private void checkValid() {
        if (!isValid()) {
            throw new CancelledKeyException();
        }
    }

    @Override // java.nio.channels.SelectionKey
    public SelectableChannel channel() {
        return this.channel;
    }

    @Override // java.nio.channels.SelectionKey
    public int interestOps() {
        int i;
        checkValid();
        synchronized (this.selector.keysLock) {
            i = this.interestOps;
        }
        return i;
    }

    @Override // java.nio.channels.SelectionKey
    public SelectionKey interestOps(int i) {
        checkValid();
        if (((channel().validOps() ^ (-1)) & i) != 0) {
            throw new IllegalArgumentException();
        }
        synchronized (this.selector.keysLock) {
            this.interestOps = i;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int interestOpsNoCheck() {
        int i;
        synchronized (this.selector.keysLock) {
            i = this.interestOps;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isConnected() {
        return !(this.channel instanceof SocketChannel) || ((SocketChannel) this.channel).isConnected();
    }

    @Override // java.nio.channels.SelectionKey
    public int readyOps() {
        checkValid();
        return this.readyOps;
    }

    @Override // java.nio.channels.SelectionKey
    public Selector selector() {
        return this.selector;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setReadyOps(int i) {
        this.readyOps = this.interestOps & i;
    }
}
