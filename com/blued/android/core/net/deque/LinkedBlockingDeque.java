package com.blued.android.core.net.deque;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/deque/LinkedBlockingDeque.class */
public class LinkedBlockingDeque<E> extends AbstractQueue<E> implements BlockingDeque<E>, Serializable {
    private static final long serialVersionUID = -387911632671998426L;

    /* renamed from: a  reason: collision with root package name */
    transient Node<E> f9670a;
    transient Node<E> b;

    /* renamed from: c  reason: collision with root package name */
    final ReentrantLock f9671c;
    private transient int d;
    private final int e;
    private final Condition f;
    private final Condition g;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/deque/LinkedBlockingDeque$AbstractItr.class */
    abstract class AbstractItr implements Iterator<E> {

        /* renamed from: a  reason: collision with root package name */
        Node<E> f9672a;
        E b;
        private Node<E> d;

        AbstractItr() {
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.f9671c;
            reentrantLock.lock();
            try {
                Node<E> a2 = a();
                this.f9672a = a2;
                this.b = a2 == null ? null : a2.f9674a;
            } finally {
                reentrantLock.unlock();
            }
        }

        private Node<E> b(Node<E> node) {
            while (true) {
                Node<E> a2 = a(node);
                if (a2 == null) {
                    return null;
                }
                if (a2.f9674a != null) {
                    return a2;
                }
                if (a2 == node) {
                    return a();
                }
                node = a2;
            }
        }

        abstract Node<E> a();

        abstract Node<E> a(Node<E> node);

        void b() {
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.f9671c;
            reentrantLock.lock();
            try {
                Node<E> b = b(this.f9672a);
                this.f9672a = b;
                this.b = b == null ? null : b.f9674a;
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9672a != null;
        }

        @Override // java.util.Iterator
        public E next() {
            Node<E> node = this.f9672a;
            if (node != null) {
                this.d = node;
                E e = this.b;
                b();
                return e;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            Node<E> node = this.d;
            if (node == null) {
                throw new IllegalStateException();
            }
            this.d = null;
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.f9671c;
            reentrantLock.lock();
            try {
                if (node.f9674a != null) {
                    LinkedBlockingDeque.this.a((Node) node);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/deque/LinkedBlockingDeque$DescendingItr.class */
    class DescendingItr extends LinkedBlockingDeque<E>.AbstractItr {
        final /* synthetic */ LinkedBlockingDeque d;

        @Override // com.blued.android.core.net.deque.LinkedBlockingDeque.AbstractItr
        Node<E> a() {
            return this.d.b;
        }

        @Override // com.blued.android.core.net.deque.LinkedBlockingDeque.AbstractItr
        Node<E> a(Node<E> node) {
            return node.b;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/deque/LinkedBlockingDeque$Itr.class */
    class Itr extends LinkedBlockingDeque<E>.AbstractItr {
        private Itr() {
            super();
        }

        @Override // com.blued.android.core.net.deque.LinkedBlockingDeque.AbstractItr
        Node<E> a() {
            return LinkedBlockingDeque.this.f9670a;
        }

        @Override // com.blued.android.core.net.deque.LinkedBlockingDeque.AbstractItr
        Node<E> a(Node<E> node) {
            return node.f9675c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/deque/LinkedBlockingDeque$Node.class */
    public static final class Node<E> {

        /* renamed from: a  reason: collision with root package name */
        E f9674a;
        Node<E> b;

        /* renamed from: c  reason: collision with root package name */
        Node<E> f9675c;

        Node(E e) {
            this.f9674a = e;
        }
    }

    public LinkedBlockingDeque() {
        this(Integer.MAX_VALUE);
    }

    public LinkedBlockingDeque(int i) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f9671c = reentrantLock;
        this.f = reentrantLock.newCondition();
        this.g = this.f9671c.newCondition();
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.e = i;
    }

    private boolean b(Node<E> node) {
        if (this.d >= this.e) {
            return false;
        }
        Node<E> node2 = this.f9670a;
        node.f9675c = node2;
        this.f9670a = node;
        if (this.b == null) {
            this.b = node;
        } else {
            node2.b = node;
        }
        this.d++;
        this.f.signal();
        return true;
    }

    private boolean c(Node<E> node) {
        if (this.d >= this.e) {
            return false;
        }
        Node<E> node2 = this.b;
        node.b = node2;
        this.b = node;
        if (this.f9670a == null) {
            this.f9670a = node;
        } else {
            node2.f9675c = node;
        }
        this.d++;
        this.f.signal();
        return true;
    }

    private E f() {
        Node<E> node = this.f9670a;
        if (node == null) {
            return null;
        }
        Node<E> node2 = node.f9675c;
        E e = node.f9674a;
        node.f9674a = null;
        node.f9675c = node;
        this.f9670a = node2;
        if (node2 == null) {
            this.b = null;
        } else {
            node2.b = null;
        }
        this.d--;
        this.g.signal();
        return e;
    }

    private E g() {
        Node<E> node = this.b;
        if (node == null) {
            return null;
        }
        Node<E> node2 = node.b;
        E e = node.f9674a;
        node.f9674a = null;
        node.b = node;
        this.b = node2;
        if (node2 == null) {
            this.f9670a = null;
        } else {
            node2.f9675c = null;
        }
        this.d--;
        this.g.signal();
        return e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.d = 0;
        this.f9670a = null;
        this.b = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject == null) {
                return;
            }
            add(readObject);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ReentrantLock reentrantLock = this.f9671c;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (Node<E> node = this.f9670a; node != null; node = node.f9675c) {
                objectOutputStream.writeObject(node.f9674a);
            }
            objectOutputStream.writeObject(null);
        } finally {
            reentrantLock.unlock();
        }
    }

    public E a() {
        E b = b();
        if (b != null) {
            return b;
        }
        throw new NoSuchElementException();
    }

    public E a(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.f9671c;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E f = f();
                if (f != null) {
                    return f;
                }
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return null;
                }
                nanos = this.f.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    void a(Node<E> node) {
        Node<E> node2 = node.b;
        Node<E> node3 = node.f9675c;
        if (node2 == null) {
            f();
        } else if (node3 == null) {
            g();
        } else {
            node2.f9675c = node3;
            node3.b = node2;
            node.f9674a = null;
            this.d--;
            this.g.signal();
        }
    }

    public void a(E e) {
        if (!c((LinkedBlockingDeque<E>) e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public boolean a(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        boolean z;
        if (e != null) {
            Node<E> node = new Node<>(e);
            long nanos = timeUnit.toNanos(j);
            ReentrantLock reentrantLock = this.f9671c;
            reentrantLock.lockInterruptibly();
            while (true) {
                try {
                    if (c((Node) node)) {
                        z = true;
                        break;
                    } else if (nanos <= 0) {
                        z = false;
                        break;
                    } else {
                        nanos = this.g.awaitNanos(nanos);
                    }
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            reentrantLock.unlock();
            return z;
        }
        throw null;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        a((LinkedBlockingDeque<E>) e);
        return true;
    }

    public E b() {
        ReentrantLock reentrantLock = this.f9671c;
        reentrantLock.lock();
        try {
            return f();
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean b(E e) {
        if (e != null) {
            Node<E> node = new Node<>(e);
            ReentrantLock reentrantLock = this.f9671c;
            reentrantLock.lock();
            try {
                return b((Node) node);
            } finally {
                reentrantLock.unlock();
            }
        }
        throw null;
    }

    public E c() throws InterruptedException {
        ReentrantLock reentrantLock = this.f9671c;
        reentrantLock.lock();
        while (true) {
            try {
                E f = f();
                if (f != null) {
                    return f;
                }
                this.f.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public boolean c(E e) {
        if (e != null) {
            Node<E> node = new Node<>(e);
            ReentrantLock reentrantLock = this.f9671c;
            reentrantLock.lock();
            try {
                return c((Node) node);
            } finally {
                reentrantLock.unlock();
            }
        }
        throw null;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        ReentrantLock reentrantLock = this.f9671c;
        reentrantLock.lock();
        try {
            Node<E> node = this.f9670a;
            while (true) {
                Node<E> node2 = node;
                if (node2 == null) {
                    this.b = null;
                    this.f9670a = null;
                    this.d = 0;
                    this.g.signalAll();
                    return;
                }
                node2.f9674a = null;
                Node<E> node3 = node2.f9675c;
                node2.b = null;
                node2.f9675c = null;
                node = node3;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f9671c;
        reentrantLock.lock();
        try {
            for (Node<E> node = this.f9670a; node != null; node = node.f9675c) {
                if (obj.equals(node.f9674a)) {
                    reentrantLock.unlock();
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public E d() {
        E e = e();
        if (e != null) {
            return e;
        }
        throw new NoSuchElementException();
    }

    public void d(E e) throws InterruptedException {
        if (e == null) {
            throw null;
        }
        Node<E> node = new Node<>(e);
        ReentrantLock reentrantLock = this.f9671c;
        reentrantLock.lock();
        while (!c((Node) node)) {
            try {
                this.g.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        if (collection == null) {
            throw null;
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        ReentrantLock reentrantLock = this.f9671c;
        reentrantLock.lock();
        try {
            int min = Math.min(i, this.d);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= min) {
                    return min;
                }
                collection.add((E) this.f9670a.f9674a);
                f();
                i2 = i3 + 1;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public E e() {
        ReentrantLock reentrantLock = this.f9671c;
        reentrantLock.lock();
        try {
            E e = this.f9670a == null ? null : this.f9670a.f9674a;
            reentrantLock.unlock();
            return e;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public boolean e(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f9671c;
        reentrantLock.lock();
        try {
            for (Node<E> node = this.f9670a; node != null; node = node.f9675c) {
                if (obj.equals(node.f9674a)) {
                    a((Node) node);
                    reentrantLock.unlock();
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E element() {
        return d();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new Itr();
    }

    public boolean offer(E e) {
        return c((LinkedBlockingDeque<E>) e);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        return a(e, j, timeUnit);
    }

    @Override // java.util.Queue
    public E peek() {
        return e();
    }

    @Override // java.util.Queue
    public E poll() {
        return b();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        return a(j, timeUnit);
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e) throws InterruptedException {
        d(e);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.f9671c;
        reentrantLock.lock();
        try {
            int i = this.e;
            int i2 = this.d;
            reentrantLock.unlock();
            return i - i2;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E remove() {
        return a();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return e(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        ReentrantLock reentrantLock = this.f9671c;
        reentrantLock.lock();
        try {
            return this.d;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        return c();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        ReentrantLock reentrantLock = this.f9671c;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.d];
            int i = 0;
            Node<E> node = this.f9670a;
            while (node != null) {
                objArr[i] = node.f9674a;
                node = node.f9675c;
                i++;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.lang.Object[]] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.f9671c;
        reentrantLock.lock();
        T[] tArr2 = tArr;
        try {
            if (tArr.length < this.d) {
                tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.d);
            }
            int i = 0;
            Node<E> node = this.f9670a;
            while (node != null) {
                tArr2[i] = node.f9674a;
                node = node.f9675c;
                i++;
            }
            if (tArr2.length > i) {
                tArr2[i] = null;
            }
            reentrantLock.unlock();
            return tArr2;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        ReentrantLock reentrantLock = this.f9671c;
        reentrantLock.lock();
        try {
            Node<E> node = this.f9670a;
            if (node == null) {
                reentrantLock.unlock();
                return "[]";
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            while (true) {
                E e = node.f9674a;
                E e2 = e;
                if (e == this) {
                    e2 = "(this Collection)";
                }
                sb.append(e2);
                node = node.f9675c;
                if (node == null) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(',');
                sb.append(' ');
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
