package java.nio.channels.spi;

import java.io.IOException;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.IllegalBlockingModeException;
import java.nio.channels.IllegalSelectorException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-2895416-dex2jar.jar:java/nio/channels/spi/AbstractSelectableChannel.class */
public abstract class AbstractSelectableChannel extends SelectableChannel {
    private final SelectorProvider provider;
    private List<SelectionKey> keyList = new ArrayList();
    private final Object blockingLock = new Object();
    boolean isBlocking = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractSelectableChannel(SelectorProvider selectorProvider) {
        this.provider = selectorProvider;
    }

    private boolean containsValidKeys() {
        boolean z;
        synchronized (this) {
            Iterator<SelectionKey> it = this.keyList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                SelectionKey next = it.next();
                if (next != null && next.isValid()) {
                    z = true;
                    break;
                }
            }
        }
        return z;
    }

    @Override // java.nio.channels.SelectableChannel
    public final Object blockingLock() {
        return this.blockingLock;
    }

    @Override // java.nio.channels.SelectableChannel
    public final SelectableChannel configureBlocking(boolean z) throws IOException {
        if (isOpen()) {
            synchronized (this.blockingLock) {
                if (this.isBlocking == z) {
                    return this;
                }
                if (z && containsValidKeys()) {
                    throw new IllegalBlockingModeException();
                }
                implConfigureBlocking(z);
                this.isBlocking = z;
                return this;
            }
        }
        throw new ClosedChannelException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void deregister(SelectionKey selectionKey) {
        synchronized (this) {
            if (this.keyList != null) {
                this.keyList.remove(selectionKey);
            }
        }
    }

    @Override // java.nio.channels.spi.AbstractInterruptibleChannel
    protected final void implCloseChannel() throws IOException {
        synchronized (this) {
            implCloseSelectableChannel();
            for (SelectionKey selectionKey : this.keyList) {
                if (selectionKey != null) {
                    selectionKey.cancel();
                }
            }
        }
    }

    protected abstract void implCloseSelectableChannel() throws IOException;

    protected abstract void implConfigureBlocking(boolean z) throws IOException;

    @Override // java.nio.channels.SelectableChannel
    public final boolean isBlocking() {
        boolean z;
        synchronized (this.blockingLock) {
            z = this.isBlocking;
        }
        return z;
    }

    @Override // java.nio.channels.SelectableChannel
    public final boolean isRegistered() {
        boolean z;
        synchronized (this) {
            z = !this.keyList.isEmpty();
        }
        return z;
    }

    @Override // java.nio.channels.SelectableChannel
    public final SelectionKey keyFor(Selector selector) {
        SelectionKey selectionKey;
        synchronized (this) {
            Iterator<SelectionKey> it = this.keyList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    selectionKey = null;
                    break;
                }
                SelectionKey next = it.next();
                if (next != null && next.selector() == selector) {
                    selectionKey = next;
                    break;
                }
            }
        }
        return selectionKey;
    }

    @Override // java.nio.channels.SelectableChannel
    public final SelectorProvider provider() {
        return this.provider;
    }

    @Override // java.nio.channels.SelectableChannel
    public final SelectionKey register(Selector selector, int i, Object obj) throws ClosedChannelException {
        SelectionKey selectionKey;
        if (isOpen()) {
            if (((validOps() ^ (-1)) & i) != 0) {
                throw new IllegalArgumentException("no valid ops in interest set: " + i);
            }
            synchronized (this.blockingLock) {
                if (this.isBlocking) {
                    throw new IllegalBlockingModeException();
                }
                if (!selector.isOpen()) {
                    if (i == 0) {
                        throw new IllegalSelectorException();
                    }
                    throw new NullPointerException("selector not open");
                }
                SelectionKey keyFor = keyFor(selector);
                if (keyFor == null) {
                    selectionKey = ((AbstractSelector) selector).register(this, i, obj);
                    this.keyList.add(selectionKey);
                } else if (!keyFor.isValid()) {
                    throw new CancelledKeyException();
                } else {
                    keyFor.interestOps(i);
                    keyFor.attach(obj);
                    selectionKey = keyFor;
                }
            }
            return selectionKey;
        }
        throw new ClosedChannelException();
    }
}
