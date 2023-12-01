package java.nio.channels.spi;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-2895416-dex2jar.jar:java/nio/channels/spi/AbstractSelector.class */
public abstract class AbstractSelector extends Selector {
    private SelectorProvider provider;
    private final AtomicBoolean isOpen = new AtomicBoolean(true);
    private final Set<SelectionKey> cancelledKeysSet = new HashSet();
    private final Runnable wakeupRunnable = new Runnable() { // from class: java.nio.channels.spi.AbstractSelector.1
        @Override // java.lang.Runnable
        public void run() {
            AbstractSelector.this.wakeup();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractSelector(SelectorProvider selectorProvider) {
        this.provider = null;
        this.provider = selectorProvider;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void begin() {
        Thread.currentThread().pushInterruptAction$(this.wakeupRunnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cancel(SelectionKey selectionKey) {
        synchronized (this.cancelledKeysSet) {
            this.cancelledKeysSet.add(selectionKey);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Set<SelectionKey> cancelledKeys() {
        return this.cancelledKeysSet;
    }

    @Override // java.nio.channels.Selector, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.isOpen.getAndSet(false)) {
            implCloseSelector();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void deregister(AbstractSelectionKey abstractSelectionKey) {
        ((AbstractSelectableChannel) abstractSelectionKey.channel()).deregister(abstractSelectionKey);
        abstractSelectionKey.isValid = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void end() {
        Thread.currentThread().popInterruptAction$(this.wakeupRunnable);
    }

    protected abstract void implCloseSelector() throws IOException;

    @Override // java.nio.channels.Selector
    public final boolean isOpen() {
        return this.isOpen.get();
    }

    @Override // java.nio.channels.Selector
    public final SelectorProvider provider() {
        return this.provider;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract SelectionKey register(AbstractSelectableChannel abstractSelectableChannel, int i, Object obj);
}
