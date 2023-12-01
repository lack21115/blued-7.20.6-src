package java.util.concurrent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentLinkedDeque.class */
public class ConcurrentLinkedDeque<E> extends AbstractCollection<E> implements Deque<E>, Serializable {
    private static final int HOPS = 2;
    private static final Node<Object> NEXT_TERMINATOR;
    private static final Node<Object> PREV_TERMINATOR = new Node<>();
    private static final Unsafe UNSAFE;
    private static final long headOffset;
    private static final long serialVersionUID = 876323262645176354L;
    private static final long tailOffset;
    private volatile transient Node<E> head;
    private volatile transient Node<E> tail;

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentLinkedDeque$AbstractItr.class */
    private abstract class AbstractItr implements Iterator<E> {
        private Node<E> lastRet;
        private E nextItem;
        private Node<E> nextNode;

        AbstractItr() {
            advance();
        }

        private void advance() {
            this.lastRet = this.nextNode;
            Node<E> startNode = this.nextNode == null ? startNode() : nextNode(this.nextNode);
            while (true) {
                Node<E> node = startNode;
                if (node == null) {
                    this.nextNode = null;
                    this.nextItem = null;
                    return;
                }
                E e = node.item;
                if (e != null) {
                    this.nextNode = node;
                    this.nextItem = e;
                    return;
                }
                startNode = nextNode(node);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextItem != null;
        }

        @Override // java.util.Iterator
        public E next() {
            E e = this.nextItem;
            if (e == null) {
                throw new NoSuchElementException();
            }
            advance();
            return e;
        }

        abstract Node<E> nextNode(Node<E> node);

        @Override // java.util.Iterator
        public void remove() {
            Node<E> node = this.lastRet;
            if (node == null) {
                throw new IllegalStateException();
            }
            node.item = null;
            ConcurrentLinkedDeque.this.unlink(node);
            this.lastRet = null;
        }

        abstract Node<E> startNode();
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentLinkedDeque$DescendingItr.class */
    private class DescendingItr extends ConcurrentLinkedDeque<E>.AbstractItr {
        private DescendingItr() {
            super();
        }

        @Override // java.util.concurrent.ConcurrentLinkedDeque.AbstractItr
        Node<E> nextNode(Node<E> node) {
            return ConcurrentLinkedDeque.this.pred(node);
        }

        @Override // java.util.concurrent.ConcurrentLinkedDeque.AbstractItr
        Node<E> startNode() {
            return ConcurrentLinkedDeque.this.last();
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentLinkedDeque$Itr.class */
    private class Itr extends ConcurrentLinkedDeque<E>.AbstractItr {
        private Itr() {
            super();
        }

        @Override // java.util.concurrent.ConcurrentLinkedDeque.AbstractItr
        Node<E> nextNode(Node<E> node) {
            return ConcurrentLinkedDeque.this.succ(node);
        }

        @Override // java.util.concurrent.ConcurrentLinkedDeque.AbstractItr
        Node<E> startNode() {
            return ConcurrentLinkedDeque.this.first();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentLinkedDeque$Node.class */
    public static final class Node<E> {
        private static final Unsafe UNSAFE;
        private static final long itemOffset;
        private static final long nextOffset;
        private static final long prevOffset;
        volatile E item;
        volatile Node<E> next;
        volatile Node<E> prev;

        static {
            try {
                UNSAFE = Unsafe.getUnsafe();
                prevOffset = UNSAFE.objectFieldOffset(Node.class.getDeclaredField("prev"));
                itemOffset = UNSAFE.objectFieldOffset(Node.class.getDeclaredField("item"));
                nextOffset = UNSAFE.objectFieldOffset(Node.class.getDeclaredField("next"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        Node() {
        }

        Node(E e) {
            UNSAFE.putObject(this, itemOffset, e);
        }

        boolean casItem(E e, E e2) {
            return UNSAFE.compareAndSwapObject(this, itemOffset, e, e2);
        }

        boolean casNext(Node<E> node, Node<E> node2) {
            return UNSAFE.compareAndSwapObject(this, nextOffset, node, node2);
        }

        boolean casPrev(Node<E> node, Node<E> node2) {
            return UNSAFE.compareAndSwapObject(this, prevOffset, node, node2);
        }

        void lazySetNext(Node<E> node) {
            UNSAFE.putOrderedObject(this, nextOffset, node);
        }

        void lazySetPrev(Node<E> node) {
            UNSAFE.putOrderedObject(this, prevOffset, node);
        }
    }

    static {
        PREV_TERMINATOR.next = (Node<E>) PREV_TERMINATOR;
        NEXT_TERMINATOR = new Node<>();
        NEXT_TERMINATOR.prev = (Node<E>) NEXT_TERMINATOR;
        try {
            UNSAFE = Unsafe.getUnsafe();
            headOffset = UNSAFE.objectFieldOffset(ConcurrentLinkedDeque.class.getDeclaredField("head"));
            tailOffset = UNSAFE.objectFieldOffset(ConcurrentLinkedDeque.class.getDeclaredField("tail"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public ConcurrentLinkedDeque() {
        Node<E> node = new Node<>(null);
        this.tail = node;
        this.head = node;
    }

    public ConcurrentLinkedDeque(Collection<? extends E> collection) {
        Node<E> node = null;
        Node<E> node2 = null;
        for (E e : collection) {
            checkNotNull(e);
            Node<E> node3 = new Node<>(e);
            if (node == null) {
                node2 = node3;
                node = node3;
            } else {
                node2.lazySetNext(node3);
                node3.lazySetPrev(node2);
                node2 = node3;
            }
        }
        initHeadTail(node, node2);
    }

    private boolean casHead(Node<E> node, Node<E> node2) {
        return UNSAFE.compareAndSwapObject(this, headOffset, node, node2);
    }

    private boolean casTail(Node<E> node, Node<E> node2) {
        return UNSAFE.compareAndSwapObject(this, tailOffset, node, node2);
    }

    private static void checkNotNull(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
    }

    private void initHeadTail(Node<E> node, Node<E> node2) {
        Node<E> node3 = node;
        Node<E> node4 = node2;
        if (node == node2) {
            if (node == null) {
                node4 = new Node<>(null);
                node3 = node4;
            } else {
                node4 = new Node<>(null);
                node2.lazySetNext(node4);
                node4.lazySetPrev(node2);
                node3 = node;
            }
        }
        this.head = node3;
        this.tail = node4;
    }

    private void linkFirst(E e) {
        Node<E> node;
        Node<E> node2;
        checkNotNull(e);
        Node<E> node3 = new Node<>(e);
        loop0: while (true) {
            node = this.head;
            Node<E> node4 = node;
            while (true) {
                Node<E> node5 = node4.prev;
                node2 = node4;
                if (node5 != null) {
                    node2 = node5;
                    node4 = node5.prev;
                    if (node4 != null) {
                        Node<E> node6 = this.head;
                        if (node != node6) {
                            node4 = node6;
                        }
                        node = node6;
                    }
                }
                if (node2.next != node2) {
                    node3.lazySetNext(node2);
                    node4 = node2;
                    if (node2.casPrev(null, node3)) {
                        break loop0;
                    }
                }
            }
        }
        if (node2 != node) {
            casHead(node, node3);
        }
    }

    private void linkLast(E e) {
        Node<E> node;
        Node<E> node2;
        checkNotNull(e);
        Node<E> node3 = new Node<>(e);
        loop0: while (true) {
            node = this.tail;
            Node<E> node4 = node;
            while (true) {
                Node<E> node5 = node4.next;
                node2 = node4;
                if (node5 != null) {
                    node2 = node5;
                    node4 = node5.next;
                    if (node4 != null) {
                        Node<E> node6 = this.tail;
                        if (node != node6) {
                            node4 = node6;
                        }
                        node = node6;
                    }
                }
                if (node2.prev != node2) {
                    node3.lazySetPrev(node2);
                    node4 = node2;
                    if (node2.casNext(null, node3)) {
                        break loop0;
                    }
                }
            }
        }
        if (node2 != node) {
            casTail(node, node3);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Node<E> node = null;
        Node<E> node2 = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject == null) {
                initHeadTail(node, node2);
                return;
            }
            Node<E> node3 = new Node<>(readObject);
            if (node == null) {
                node2 = node3;
                node = node3;
            } else {
                node2.lazySetNext(node3);
                node3.lazySetPrev(node2);
                node2 = node3;
            }
        }
    }

    private E screenNullResult(E e) {
        if (e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
        if (r6.next == r6) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void skipDeletedPredecessors(java.util.concurrent.ConcurrentLinkedDeque.Node<E> r5) {
        /*
            r4 = this;
        L0:
            r0 = r5
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r0.prev
            r7 = r0
            r0 = r7
            r6 = r0
        L7:
            r0 = r6
            E r0 = r0.item
            if (r0 == 0) goto L1d
        Le:
            r0 = r7
            r1 = r6
            if (r0 == r1) goto L1c
            r0 = r5
            r1 = r7
            r2 = r6
            boolean r0 = r0.casPrev(r1, r2)
            if (r0 == 0) goto L30
        L1c:
            return
        L1d:
            r0 = r6
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r0.prev
            r8 = r0
            r0 = r8
            if (r0 != 0) goto L3f
            r0 = r6
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r0.next
            r1 = r6
            if (r0 != r1) goto Le
        L30:
            r0 = r5
            E r0 = r0.item
            if (r0 != 0) goto L0
            r0 = r5
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r0.next
            if (r0 == 0) goto L0
            return
        L3f:
            r0 = r6
            r1 = r8
            if (r0 == r1) goto L30
            r0 = r8
            r6 = r0
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentLinkedDeque.skipDeletedPredecessors(java.util.concurrent.ConcurrentLinkedDeque$Node):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
        if (r6.prev == r6) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void skipDeletedSuccessors(java.util.concurrent.ConcurrentLinkedDeque.Node<E> r5) {
        /*
            r4 = this;
        L0:
            r0 = r5
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r0.next
            r7 = r0
            r0 = r7
            r6 = r0
        L7:
            r0 = r6
            E r0 = r0.item
            if (r0 == 0) goto L1d
        Le:
            r0 = r7
            r1 = r6
            if (r0 == r1) goto L1c
            r0 = r5
            r1 = r7
            r2 = r6
            boolean r0 = r0.casNext(r1, r2)
            if (r0 == 0) goto L30
        L1c:
            return
        L1d:
            r0 = r6
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r0.next
            r8 = r0
            r0 = r8
            if (r0 != 0) goto L3f
            r0 = r6
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r0.prev
            r1 = r6
            if (r0 != r1) goto Le
        L30:
            r0 = r5
            E r0 = r0.item
            if (r0 != 0) goto L0
            r0 = r5
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r0.prev
            if (r0 == 0) goto L0
            return
        L3f:
            r0 = r6
            r1 = r8
            if (r0 == r1) goto L30
            r0 = r8
            r6 = r0
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentLinkedDeque.skipDeletedSuccessors(java.util.concurrent.ConcurrentLinkedDeque$Node):void");
    }

    private ArrayList<E> toArrayList() {
        ArrayList<E> arrayList = new ArrayList<>();
        Node<E> first = first();
        while (true) {
            Node<E> node = first;
            if (node == null) {
                return arrayList;
            }
            E e = node.item;
            if (e != null) {
                arrayList.add(e);
            }
            first = succ(node);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
        if (r7.prev == r7) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
        if (r5.casNext(r6, r7) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
        skipDeletedPredecessors(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0036, code lost:
        if (r5.prev != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
        if (r7.next == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
        if (r7.item == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
        if (r7.prev != r5) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
        updateHead();
        updateTail();
        r8.lazySetNext(r8);
        r8.lazySetPrev(prevTerminator());
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0067, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (r8 == null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void unlinkFirst(java.util.concurrent.ConcurrentLinkedDeque.Node<E> r5, java.util.concurrent.ConcurrentLinkedDeque.Node<E> r6) {
        /*
            r4 = this;
            r0 = 0
            r8 = r0
            r0 = r6
            r7 = r0
        L5:
            r0 = r7
            E r0 = r0.item
            if (r0 != 0) goto L17
            r0 = r7
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r0.next
            r9 = r0
            r0 = r9
            if (r0 != 0) goto L68
        L17:
            r0 = r8
            if (r0 == 0) goto L67
            r0 = r7
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r0.prev
            r1 = r7
            if (r0 == r1) goto L67
            r0 = r5
            r1 = r6
            r2 = r7
            boolean r0 = r0.casNext(r1, r2)
            if (r0 == 0) goto L67
            r0 = r4
            r1 = r7
            r0.skipDeletedPredecessors(r1)
            r0 = r5
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r0.prev
            if (r0 != 0) goto L67
            r0 = r7
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r0.next
            if (r0 == 0) goto L47
            r0 = r7
            E r0 = r0.item
            if (r0 == 0) goto L67
        L47:
            r0 = r7
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r0.prev
            r1 = r5
            if (r0 != r1) goto L67
            r0 = r4
            r0.updateHead()
            r0 = r4
            r0.updateTail()
            r0 = r8
            r1 = r8
            r0.lazySetNext(r1)
            r0 = r8
            r1 = r4
            java.util.concurrent.ConcurrentLinkedDeque$Node r1 = r1.prevTerminator()
            r0.lazySetPrev(r1)
        L67:
            return
        L68:
            r0 = r7
            r1 = r9
            if (r0 == r1) goto L67
            r0 = r7
            r8 = r0
            r0 = r9
            r7 = r0
            goto L5
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentLinkedDeque.unlinkFirst(java.util.concurrent.ConcurrentLinkedDeque$Node, java.util.concurrent.ConcurrentLinkedDeque$Node):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
        if (r7.next == r7) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
        if (r5.casPrev(r6, r7) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
        skipDeletedSuccessors(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0036, code lost:
        if (r5.next != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
        if (r7.prev == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
        if (r7.item == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
        if (r7.next != r5) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
        updateHead();
        updateTail();
        r8.lazySetPrev(r8);
        r8.lazySetNext(nextTerminator());
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0067, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (r8 == null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void unlinkLast(java.util.concurrent.ConcurrentLinkedDeque.Node<E> r5, java.util.concurrent.ConcurrentLinkedDeque.Node<E> r6) {
        /*
            r4 = this;
            r0 = 0
            r8 = r0
            r0 = r6
            r7 = r0
        L5:
            r0 = r7
            E r0 = r0.item
            if (r0 != 0) goto L17
            r0 = r7
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r0.prev
            r9 = r0
            r0 = r9
            if (r0 != 0) goto L68
        L17:
            r0 = r8
            if (r0 == 0) goto L67
            r0 = r7
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r0.next
            r1 = r7
            if (r0 == r1) goto L67
            r0 = r5
            r1 = r6
            r2 = r7
            boolean r0 = r0.casPrev(r1, r2)
            if (r0 == 0) goto L67
            r0 = r4
            r1 = r7
            r0.skipDeletedSuccessors(r1)
            r0 = r5
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r0.next
            if (r0 != 0) goto L67
            r0 = r7
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r0.prev
            if (r0 == 0) goto L47
            r0 = r7
            E r0 = r0.item
            if (r0 == 0) goto L67
        L47:
            r0 = r7
            java.util.concurrent.ConcurrentLinkedDeque$Node<E> r0 = r0.next
            r1 = r5
            if (r0 != r1) goto L67
            r0 = r4
            r0.updateHead()
            r0 = r4
            r0.updateTail()
            r0 = r8
            r1 = r8
            r0.lazySetPrev(r1)
            r0 = r8
            r1 = r4
            java.util.concurrent.ConcurrentLinkedDeque$Node r1 = r1.nextTerminator()
            r0.lazySetNext(r1)
        L67:
            return
        L68:
            r0 = r7
            r1 = r9
            if (r0 == r1) goto L67
            r0 = r7
            r8 = r0
            r0 = r9
            r7 = r0
            goto L5
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentLinkedDeque.unlinkLast(java.util.concurrent.ConcurrentLinkedDeque$Node, java.util.concurrent.ConcurrentLinkedDeque$Node):void");
    }

    private final void updateHead() {
        while (true) {
            Node<E> node = this.head;
            if (node.item != null) {
                return;
            }
            Node<E> node2 = node.prev;
            if (node2 == null) {
                return;
            }
            while (true) {
                Node<E> node3 = node2.prev;
                if (node3 == null) {
                    break;
                }
                node2 = node3;
                Node<E> node4 = node3.prev;
                if (node4 == null) {
                    break;
                } else if (node == this.head) {
                    node2 = node4;
                }
            }
            if (casHead(node, node2)) {
                return;
            }
        }
    }

    private final void updateTail() {
        while (true) {
            Node<E> node = this.tail;
            if (node.item != null) {
                return;
            }
            Node<E> node2 = node.next;
            if (node2 == null) {
                return;
            }
            while (true) {
                Node<E> node3 = node2.next;
                if (node3 == null) {
                    break;
                }
                node2 = node3;
                Node<E> node4 = node3.next;
                if (node4 == null) {
                    break;
                } else if (node == this.tail) {
                    node2 = node4;
                }
            }
            if (casTail(node, node2)) {
                return;
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Node<E> first = first();
        while (true) {
            Node<E> node = first;
            if (node == null) {
                objectOutputStream.writeObject(null);
                return;
            }
            E e = node.item;
            if (e != null) {
                objectOutputStream.writeObject(e);
            }
            first = succ(node);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(E e) {
        return offerLast(e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        Node<E> node;
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        Node<E> node2 = null;
        Node<E> node3 = null;
        for (E e : collection) {
            checkNotNull(e);
            Node<E> node4 = new Node<>(e);
            if (node2 == null) {
                node3 = node4;
                node2 = node4;
            } else {
                node3.lazySetNext(node4);
                node4.lazySetPrev(node3);
                node3 = node4;
            }
        }
        if (node2 == null) {
            return false;
        }
        loop1: while (true) {
            node = this.tail;
            Node<E> node5 = node;
            while (true) {
                Node<E> node6 = node5.next;
                Node<E> node7 = node5;
                if (node6 != null) {
                    node7 = node6;
                    node5 = node6.next;
                    if (node5 != null) {
                        Node<E> node8 = this.tail;
                        if (node != node8) {
                            node5 = node8;
                        }
                        node = node8;
                    }
                }
                if (node7.prev == node7) {
                    break;
                }
                node2.lazySetPrev(node7);
                node5 = node7;
                if (node7.casNext(null, node2)) {
                    break loop1;
                }
            }
        }
        if (casTail(node, node3)) {
            return true;
        }
        Node<E> node9 = this.tail;
        if (node3.next == null) {
            casTail(node9, node3);
            return true;
        }
        return true;
    }

    @Override // java.util.Deque
    public void addFirst(E e) {
        linkFirst(e);
    }

    @Override // java.util.Deque
    public void addLast(E e) {
        linkLast(e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        do {
        } while (pollFirst() != null);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        Node<E> first = first();
        while (true) {
            Node<E> node = first;
            if (node == null) {
                return false;
            }
            E e = node.item;
            if (e != null && obj.equals(e)) {
                return true;
            }
            first = succ(node);
        }
    }

    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        return new DescendingItr();
    }

    @Override // java.util.Deque, java.util.Queue
    public E element() {
        return getFirst();
    }

    Node<E> first() {
        Node<E> node;
        Node<E> node2;
        do {
            node = this.head;
            node2 = node;
            while (true) {
                Node<E> node3 = node2.prev;
                if (node3 == null) {
                    break;
                }
                node2 = node3;
                Node<E> node4 = node3.prev;
                if (node4 == null) {
                    break;
                }
                Node<E> node5 = this.head;
                node2 = node != node5 ? node5 : node4;
                node = node5;
            }
            if (node2 == node) {
                break;
            }
        } while (!casHead(node, node2));
        return node2;
    }

    @Override // java.util.Deque
    public E getFirst() {
        return screenNullResult(peekFirst());
    }

    @Override // java.util.Deque
    public E getLast() {
        return screenNullResult(peekLast());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return peekFirst() == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new Itr();
    }

    Node<E> last() {
        Node<E> node;
        Node<E> node2;
        do {
            node = this.tail;
            node2 = node;
            while (true) {
                Node<E> node3 = node2.next;
                if (node3 == null) {
                    break;
                }
                node2 = node3;
                Node<E> node4 = node3.next;
                if (node4 == null) {
                    break;
                }
                Node<E> node5 = this.tail;
                node2 = node != node5 ? node5 : node4;
                node = node5;
            }
            if (node2 == node) {
                break;
            }
        } while (!casTail(node, node2));
        return node2;
    }

    Node<E> nextTerminator() {
        return (Node<E>) NEXT_TERMINATOR;
    }

    @Override // java.util.Deque, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e) {
        return offerLast(e);
    }

    @Override // java.util.Deque
    public boolean offerFirst(E e) {
        linkFirst(e);
        return true;
    }

    @Override // java.util.Deque
    public boolean offerLast(E e) {
        linkLast(e);
        return true;
    }

    @Override // java.util.Deque, java.util.Queue
    public E peek() {
        return peekFirst();
    }

    @Override // java.util.Deque
    public E peekFirst() {
        Node<E> first = first();
        while (true) {
            Node<E> node = first;
            if (node == null) {
                return null;
            }
            E e = node.item;
            if (e != null) {
                return e;
            }
            first = succ(node);
        }
    }

    @Override // java.util.Deque
    public E peekLast() {
        Node<E> last = last();
        while (true) {
            Node<E> node = last;
            if (node == null) {
                return null;
            }
            E e = node.item;
            if (e != null) {
                return e;
            }
            last = pred(node);
        }
    }

    @Override // java.util.Deque, java.util.Queue
    public E poll() {
        return pollFirst();
    }

    @Override // java.util.Deque
    public E pollFirst() {
        Node<E> first = first();
        while (true) {
            Node<E> node = first;
            if (node == null) {
                return null;
            }
            E e = node.item;
            if (e != null && node.casItem(e, null)) {
                unlink(node);
                return e;
            }
            first = succ(node);
        }
    }

    @Override // java.util.Deque
    public E pollLast() {
        Node<E> last = last();
        while (true) {
            Node<E> node = last;
            if (node == null) {
                return null;
            }
            E e = node.item;
            if (e != null && node.casItem(e, null)) {
                unlink(node);
                return e;
            }
            last = pred(node);
        }
    }

    @Override // java.util.Deque
    public E pop() {
        return removeFirst();
    }

    final Node<E> pred(Node<E> node) {
        Node<E> node2 = node.prev;
        Node<E> node3 = node2;
        if (node == node2) {
            node3 = last();
        }
        return node3;
    }

    Node<E> prevTerminator() {
        return (Node<E>) PREV_TERMINATOR;
    }

    @Override // java.util.Deque
    public void push(E e) {
        addFirst(e);
    }

    @Override // java.util.Deque, java.util.Queue
    public E remove() {
        return removeFirst();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    @Override // java.util.Deque
    public E removeFirst() {
        return screenNullResult(pollFirst());
    }

    @Override // java.util.Deque
    public boolean removeFirstOccurrence(Object obj) {
        checkNotNull(obj);
        Node<E> first = first();
        while (true) {
            Node<E> node = first;
            if (node == null) {
                return false;
            }
            E e = node.item;
            if (e != null && obj.equals(e) && node.casItem(e, null)) {
                unlink(node);
                return true;
            }
            first = succ(node);
        }
    }

    @Override // java.util.Deque
    public E removeLast() {
        return screenNullResult(pollLast());
    }

    @Override // java.util.Deque
    public boolean removeLastOccurrence(Object obj) {
        checkNotNull(obj);
        Node<E> last = last();
        while (true) {
            Node<E> node = last;
            if (node == null) {
                return false;
            }
            E e = node.item;
            if (e != null && obj.equals(e) && node.casItem(e, null)) {
                unlink(node);
                return true;
            }
            last = pred(node);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        int i;
        int i2 = 0;
        Node<E> first = first();
        while (true) {
            i = i2;
            if (first == null) {
                break;
            }
            int i3 = i2;
            if (first.item != null) {
                int i4 = i2 + 1;
                i3 = i4;
                if (i4 == Integer.MAX_VALUE) {
                    i = i4;
                    break;
                }
            }
            first = succ(first);
            i2 = i3;
        }
        return i;
    }

    final Node<E> succ(Node<E> node) {
        Node<E> node2 = node.next;
        Node<E> node3 = node2;
        if (node == node2) {
            node3 = first();
        }
        return node3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return toArrayList().toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) toArrayList().toArray(tArr);
    }

    void unlink(Node<E> node) {
        int i;
        boolean z;
        boolean z2;
        Node<E> node2 = node.prev;
        Node<E> node3 = node.next;
        if (node2 == null) {
            unlinkFirst(node, node3);
        } else if (node3 == null) {
            unlinkLast(node, node2);
        } else {
            int i2 = 1;
            while (true) {
                i = i2;
                if (node2.item != null) {
                    z = false;
                    break;
                }
                Node<E> node4 = node2.prev;
                if (node4 == null) {
                    if (node2.next == node2) {
                        return;
                    }
                    z = true;
                } else if (node2 == node4) {
                    return;
                } else {
                    node2 = node4;
                    i2 = i + 1;
                }
            }
            Node<E> node5 = node2;
            Node<E> node6 = node3;
            while (true) {
                if (node6.item != null) {
                    z2 = false;
                    break;
                }
                Node<E> node7 = node6.next;
                if (node7 == null) {
                    if (node6.prev == node6) {
                        return;
                    }
                    z2 = true;
                } else if (node6 == node7) {
                    return;
                } else {
                    node6 = node7;
                    i++;
                }
            }
            if (i >= 2 || (!z && !z2)) {
                skipDeletedSuccessors(node5);
                skipDeletedPredecessors(node6);
                if ((z || z2) && node5.next == node6 && node6.prev == node5) {
                    if (z) {
                        if (node5.prev != null) {
                            return;
                        }
                    } else if (node5.item == null) {
                        return;
                    }
                    if (z2) {
                        if (node6.next != null) {
                            return;
                        }
                    } else if (node6.item == null) {
                        return;
                    }
                    updateHead();
                    updateTail();
                    node.lazySetPrev(z ? prevTerminator() : node);
                    node.lazySetNext(z2 ? nextTerminator() : node);
                }
            }
        }
    }
}
