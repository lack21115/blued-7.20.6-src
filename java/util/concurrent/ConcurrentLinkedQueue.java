package java.util.concurrent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentLinkedQueue.class */
public class ConcurrentLinkedQueue<E> extends AbstractQueue<E> implements Queue<E>, Serializable {
    private static final Unsafe UNSAFE;
    private static final long headOffset;
    private static final long serialVersionUID = 196745693267521676L;
    private static final long tailOffset;
    private volatile transient Node<E> head;
    private volatile transient Node<E> tail;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentLinkedQueue$Itr.class */
    public class Itr implements Iterator<E> {
        private Node<E> lastRet;
        private E nextItem;
        private Node<E> nextNode;

        Itr() {
            advance();
        }

        private E advance() {
            Node<E> node;
            Node<E> succ;
            this.lastRet = this.nextNode;
            E e = this.nextItem;
            if (this.nextNode == null) {
                succ = ConcurrentLinkedQueue.this.first();
                node = null;
            } else {
                node = this.nextNode;
                succ = ConcurrentLinkedQueue.this.succ(this.nextNode);
            }
            while (succ != null) {
                E e2 = succ.item;
                if (e2 != null) {
                    this.nextNode = succ;
                    this.nextItem = e2;
                    return e;
                }
                Node<E> succ2 = ConcurrentLinkedQueue.this.succ(succ);
                if (node != null && succ2 != null) {
                    node.casNext(succ, succ2);
                }
                succ = succ2;
            }
            this.nextNode = null;
            this.nextItem = null;
            return e;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextNode != null;
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.nextNode == null) {
                throw new NoSuchElementException();
            }
            return (E) advance();
        }

        @Override // java.util.Iterator
        public void remove() {
            Node<E> node = this.lastRet;
            if (node == null) {
                throw new IllegalStateException();
            }
            node.item = null;
            this.lastRet = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/ConcurrentLinkedQueue$Node.class */
    public static class Node<E> {
        private static final Unsafe UNSAFE;
        private static final long itemOffset;
        private static final long nextOffset;
        volatile E item;
        volatile Node<E> next;

        static {
            try {
                UNSAFE = Unsafe.getUnsafe();
                itemOffset = UNSAFE.objectFieldOffset(Node.class.getDeclaredField("item"));
                nextOffset = UNSAFE.objectFieldOffset(Node.class.getDeclaredField("next"));
            } catch (Exception e) {
                throw new Error(e);
            }
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

        void lazySetNext(Node<E> node) {
            UNSAFE.putOrderedObject(this, nextOffset, node);
        }
    }

    static {
        try {
            UNSAFE = Unsafe.getUnsafe();
            headOffset = UNSAFE.objectFieldOffset(ConcurrentLinkedQueue.class.getDeclaredField("head"));
            tailOffset = UNSAFE.objectFieldOffset(ConcurrentLinkedQueue.class.getDeclaredField("tail"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public ConcurrentLinkedQueue() {
        Node<E> node = new Node<>(null);
        this.tail = node;
        this.head = node;
    }

    public ConcurrentLinkedQueue(Collection<? extends E> collection) {
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
                node2 = node3;
            }
        }
        Node<E> node4 = node;
        if (node == null) {
            node2 = new Node<>(null);
            node4 = node2;
        }
        this.head = node4;
        this.tail = node2;
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

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Node<E> node = null;
        Node<E> node2 = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject == null) {
                break;
            }
            Node<E> node3 = new Node<>(readObject);
            if (node == null) {
                node2 = node3;
                node = node3;
            } else {
                node2.lazySetNext(node3);
                node2 = node3;
            }
        }
        Node<E> node4 = node;
        if (node == null) {
            node2 = new Node<>(null);
            node4 = node2;
        }
        this.head = node4;
        this.tail = node2;
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

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        return offer(e);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        if (collection == this) {
            throw new IllegalArgumentException();
        }
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
                node2 = node3;
            }
        }
        if (node == null) {
            return false;
        }
        Node<E> node4 = this.tail;
        Node<E> node5 = node4;
        while (true) {
            Node<E> node6 = node5.next;
            if (node6 == null) {
                if (node5.casNext(null, node)) {
                    break;
                }
            } else if (node5 == node6) {
                Node<E> node7 = this.tail;
                node5 = node4 != node7 ? node7 : this.head;
                node4 = node7;
            } else {
                Node<E> node8 = node4;
                if (node5 != node4) {
                    Node<E> node9 = this.tail;
                    if (node4 != node9) {
                        node4 = node9;
                        node5 = node9;
                    } else {
                        node8 = node9;
                    }
                }
                node5 = node6;
                node4 = node8;
            }
        }
        if (casTail(node4, node2)) {
            return true;
        }
        Node<E> node10 = this.tail;
        if (node2.next == null) {
            casTail(node10, node2);
            return true;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
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

    Node<E> first() {
        Node<E> node;
        Node<E> node2;
        boolean z;
        loop0: while (true) {
            node = this.head;
            Node<E> node3 = node;
            while (true) {
                node2 = node3;
                z = node2.item != null;
                if (z) {
                    break loop0;
                }
                Node<E> node4 = node2.next;
                if (node4 == null) {
                    break loop0;
                } else if (node2 != node4) {
                    node3 = node4;
                }
            }
        }
        updateHead(node, node2);
        if (z) {
            return node2;
        }
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return first() == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new Itr();
    }

    public boolean offer(E e) {
        checkNotNull(e);
        Node<E> node = new Node<>(e);
        Node<E> node2 = this.tail;
        Node<E> node3 = node2;
        while (true) {
            Node<E> node4 = node3.next;
            if (node4 == null) {
                if (node3.casNext(null, node)) {
                    break;
                }
            } else if (node3 == node4) {
                Node<E> node5 = this.tail;
                node3 = node2 != node5 ? node5 : this.head;
                node2 = node5;
            } else {
                Node<E> node6 = node2;
                if (node3 != node2) {
                    Node<E> node7 = this.tail;
                    if (node2 != node7) {
                        node2 = node7;
                        node3 = node7;
                    } else {
                        node6 = node7;
                    }
                }
                node3 = node4;
                node2 = node6;
            }
        }
        if (node3 != node2) {
            casTail(node2, node);
            return true;
        }
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        Node<E> node;
        Node<E> node2;
        E e;
        loop0: while (true) {
            node = this.head;
            Node<E> node3 = node;
            while (true) {
                node2 = node3;
                e = node2.item;
                if (e != null) {
                    break loop0;
                }
                Node<E> node4 = node2.next;
                if (node4 == null) {
                    break loop0;
                } else if (node2 != node4) {
                    node3 = node4;
                }
            }
        }
        updateHead(node, node2);
        return e;
    }

    public E poll() {
        while (true) {
            Node<E> node = this.head;
            Node<E> node2 = node;
            while (true) {
                Node<E> node3 = node2;
                E e = node3.item;
                if (e != null && node3.casItem(e, null)) {
                    if (node3 != node) {
                        Node<E> node4 = node3.next;
                        if (node4 != null) {
                            node3 = node4;
                        }
                        updateHead(node, node3);
                    }
                    return e;
                }
                Node<E> node5 = node3.next;
                if (node5 == null) {
                    updateHead(node, node3);
                    return null;
                } else if (node3 != node5) {
                    node2 = node5;
                }
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (obj == null) {
            return false;
        }
        Node<E> node = null;
        Node<E> first = first();
        while (true) {
            Node<E> node2 = first;
            if (node2 == null) {
                return false;
            }
            E e = node2.item;
            if (e != null && obj.equals(e) && node2.casItem(e, null)) {
                Node<E> succ = succ(node2);
                if (node == null || succ == null) {
                    return true;
                }
                node.casNext(node2, succ);
                return true;
            }
            node = node2;
            first = succ(node2);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
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
            node3 = this.head;
        }
        return node3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        ArrayList arrayList = new ArrayList();
        Node<E> first = first();
        while (true) {
            Node<E> node = first;
            if (node == null) {
                return arrayList.toArray();
            }
            E e = node.item;
            if (e != null) {
                arrayList.add(e);
            }
            first = succ(node);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        Node<E> first = first();
        int i = 0;
        while (first != null && i < tArr.length) {
            E e = first.item;
            if (e != null) {
                tArr[i] = e;
                i++;
            }
            first = succ(first);
        }
        if (first == null) {
            if (i < tArr.length) {
                tArr[i] = 0;
            }
            return tArr;
        }
        ArrayList arrayList = new ArrayList();
        Node<E> first2 = first();
        while (true) {
            Node<E> node = first2;
            if (node == null) {
                return (T[]) arrayList.toArray(tArr);
            }
            E e2 = node.item;
            if (e2 != null) {
                arrayList.add(e2);
            }
            first2 = succ(node);
        }
    }

    final void updateHead(Node<E> node, Node<E> node2) {
        if (node == node2 || !casHead(node, node2)) {
            return;
        }
        node.lazySetNext(node);
    }
}
