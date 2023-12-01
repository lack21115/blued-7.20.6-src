package java.nio;

import android.system.ErrnoException;
import android.system.OsConstants;
import android.system.StructPollfd;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.IllegalSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.AbstractSelectionKey;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UnsafeArrayList;
import libcore.io.IoUtils;
import libcore.io.Libcore;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/nio/SelectorImpl.class */
public final class SelectorImpl extends AbstractSelector {
    final Object keysLock;
    private final Set<SelectionKeyImpl> mutableKeys;
    private final Set<SelectionKey> mutableSelectedKeys;
    private final UnsafeArrayList<StructPollfd> pollFds;
    private final Set<SelectionKey> selectedKeys;
    private final Set<SelectionKey> unmodifiableKeys;
    private final FileDescriptor wakeupIn;
    private final FileDescriptor wakeupOut;

    /* loaded from: source-2895416-dex2jar.jar:java/nio/SelectorImpl$UnaddableSet.class */
    private static class UnaddableSet<E> implements Set<E> {
        private final Set<E> set;

        UnaddableSet(Set<E> set) {
            this.set = set;
        }

        @Override // java.util.Set
        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set
        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set
        public void clear() {
            this.set.clear();
        }

        @Override // java.util.Set
        public boolean contains(Object obj) {
            return this.set.contains(obj);
        }

        @Override // java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.set.containsAll(collection);
        }

        @Override // java.util.Set
        public boolean equals(Object obj) {
            return this.set.equals(obj);
        }

        @Override // java.util.Set
        public int hashCode() {
            return this.set.hashCode();
        }

        @Override // java.util.Set
        public boolean isEmpty() {
            return this.set.isEmpty();
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return this.set.iterator();
        }

        @Override // java.util.Set
        public boolean remove(Object obj) {
            return this.set.remove(obj);
        }

        @Override // java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return this.set.removeAll(collection);
        }

        @Override // java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return this.set.retainAll(collection);
        }

        @Override // java.util.Set, java.util.Collection, java.util.List
        public int size() {
            return this.set.size();
        }

        @Override // java.util.Set
        public Object[] toArray() {
            return this.set.toArray();
        }

        @Override // java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) this.set.toArray(tArr);
        }
    }

    public SelectorImpl(SelectorProvider selectorProvider) throws IOException {
        super(selectorProvider);
        this.keysLock = new Object();
        this.mutableKeys = new HashSet();
        this.unmodifiableKeys = Collections.unmodifiableSet(this.mutableKeys);
        this.mutableSelectedKeys = new HashSet();
        this.selectedKeys = new UnaddableSet(this.mutableSelectedKeys);
        this.pollFds = new UnsafeArrayList<>(StructPollfd.class, 8);
        try {
            FileDescriptor[] pipe = Libcore.os.pipe();
            this.wakeupIn = pipe[0];
            this.wakeupOut = pipe[1];
            IoUtils.setBlocking(this.wakeupIn, false);
            this.pollFds.add(new StructPollfd());
            setPollFd(0, this.wakeupIn, OsConstants.POLLIN, null);
        } catch (ErrnoException e) {
            throw e.rethrowAsIOException();
        }
    }

    private void checkClosed() {
        if (!isOpen()) {
            throw new ClosedSelectorException();
        }
    }

    private int doCancel() {
        int i = 0;
        Set<SelectionKey> cancelledKeys = cancelledKeys();
        synchronized (cancelledKeys) {
            if (cancelledKeys.size() > 0) {
                i = 0;
                for (SelectionKey selectionKey : cancelledKeys) {
                    this.mutableKeys.remove(selectionKey);
                    deregister((AbstractSelectionKey) selectionKey);
                    if (this.mutableSelectedKeys.remove(selectionKey)) {
                        i++;
                    }
                }
                cancelledKeys.clear();
            }
        }
        return i;
    }

    private void ensurePollFdsCapacity() {
        while (this.pollFds.size() < this.mutableKeys.size() + 1) {
            this.pollFds.add(new StructPollfd());
        }
    }

    private void preparePollFds() {
        int i = 1;
        for (SelectionKeyImpl selectionKeyImpl : this.mutableKeys) {
            int interestOpsNoCheck = selectionKeyImpl.interestOpsNoCheck();
            int i2 = (interestOpsNoCheck & 17) != 0 ? (short) (OsConstants.POLLIN | 0) : 0;
            int i3 = i2;
            if ((interestOpsNoCheck & 12) != 0) {
                i3 = (short) (OsConstants.POLLOUT | i2);
            }
            if (i3 != 0) {
                setPollFd(i, ((FileDescriptorChannel) selectionKeyImpl.channel()).getFD(), i3, selectionKeyImpl);
                i++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int processPollFds() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.SelectorImpl.processPollFds():int");
    }

    private int selectInternal(long j) throws IOException {
        int i;
        int doCancel;
        checkClosed();
        synchronized (this) {
            synchronized (this.unmodifiableKeys) {
                synchronized (this.selectedKeys) {
                    doCancel();
                    boolean z = j != 0;
                    synchronized (this.keysLock) {
                        preparePollFds();
                    }
                    int i2 = -1;
                    if (z) {
                        begin();
                    }
                    try {
                        i2 = Libcore.os.poll(this.pollFds.array(), (int) j);
                    } catch (ErrnoException e) {
                        if (e.errno != OsConstants.EINTR) {
                            throw e.rethrowAsIOException();
                        }
                    }
                    if (z) {
                        end();
                    }
                    i = 0;
                    if (i2 > 0) {
                        i = processPollFds();
                    }
                    doCancel = doCancel();
                }
            }
        }
        return i - doCancel;
    }

    private void setPollFd(int i, FileDescriptor fileDescriptor, int i2, Object obj) {
        StructPollfd structPollfd = this.pollFds.get(i);
        structPollfd.fd = fileDescriptor;
        structPollfd.events = (short) i2;
        structPollfd.userData = obj;
    }

    @Override // java.nio.channels.spi.AbstractSelector
    protected void implCloseSelector() throws IOException {
        wakeup();
        synchronized (this) {
            synchronized (this.unmodifiableKeys) {
                synchronized (this.selectedKeys) {
                    IoUtils.close(this.wakeupIn);
                    IoUtils.close(this.wakeupOut);
                    doCancel();
                    for (SelectionKeyImpl selectionKeyImpl : this.mutableKeys) {
                        deregister(selectionKeyImpl);
                    }
                }
            }
        }
    }

    @Override // java.nio.channels.Selector
    public Set<SelectionKey> keys() {
        Set<SelectionKey> set;
        synchronized (this) {
            checkClosed();
            set = this.unmodifiableKeys;
        }
        return set;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.nio.channels.spi.AbstractSelector
    public SelectionKey register(AbstractSelectableChannel abstractSelectableChannel, int i, Object obj) {
        SelectionKeyImpl selectionKeyImpl;
        if (provider().equals(abstractSelectableChannel.provider())) {
            synchronized (this) {
                synchronized (this.unmodifiableKeys) {
                    selectionKeyImpl = new SelectionKeyImpl(abstractSelectableChannel, i, obj, this);
                    this.mutableKeys.add(selectionKeyImpl);
                    ensurePollFdsCapacity();
                }
            }
            return selectionKeyImpl;
        }
        throw new IllegalSelectorException();
    }

    @Override // java.nio.channels.Selector
    public int select() throws IOException {
        return selectInternal(-1L);
    }

    @Override // java.nio.channels.Selector
    public int select(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        }
        long j2 = j;
        if (j == 0) {
            j2 = -1;
        }
        return selectInternal(j2);
    }

    @Override // java.nio.channels.Selector
    public int selectNow() throws IOException {
        return selectInternal(0L);
    }

    @Override // java.nio.channels.Selector
    public Set<SelectionKey> selectedKeys() {
        Set<SelectionKey> set;
        synchronized (this) {
            checkClosed();
            set = this.selectedKeys;
        }
        return set;
    }

    @Override // java.nio.channels.Selector
    public Selector wakeup() {
        try {
            Libcore.os.write(this.wakeupOut, new byte[]{1}, 0, 1);
            return this;
        } catch (ErrnoException e) {
            return this;
        } catch (InterruptedIOException e2) {
            return this;
        }
    }
}
