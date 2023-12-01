package com.sdk.tencent.d;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/d/f.class */
public class f<E> extends AbstractQueue<E> implements Serializable, BlockingQueue<E> {

    /* renamed from: a  reason: collision with root package name */
    public final int f14352a;
    public final AtomicInteger b;

    /* renamed from: c  reason: collision with root package name */
    public transient com.sdk.tencent.d.a<E> f14353c;
    public transient com.sdk.tencent.d.a<E> d;
    public final ReentrantLock e;
    public final Condition f;
    public final ReentrantLock g;
    public final Condition h;

    /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/d/f$a.class */
    public class a implements Iterator<E> {

        /* renamed from: a  reason: collision with root package name */
        public com.sdk.tencent.d.a<E> f14354a;
        public com.sdk.tencent.d.a<E> b;

        /* renamed from: c  reason: collision with root package name */
        public E f14355c;

        public a() {
            f.this.a();
            try {
                com.sdk.tencent.d.a<E> aVar = f.this.f14353c.f14340c;
                this.f14354a = aVar;
                if (aVar != null) {
                    this.f14355c = aVar.a();
                }
            } finally {
                f.this.b();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f14354a != null;
        }

        @Override // java.util.Iterator
        public E next() {
            com.sdk.tencent.d.a<E> aVar;
            f.this.a();
            try {
                com.sdk.tencent.d.a<E> aVar2 = this.f14354a;
                if (aVar2 != null) {
                    E e = this.f14355c;
                    this.b = aVar2;
                    while (true) {
                        com.sdk.tencent.d.a<E> aVar3 = aVar2.f14340c;
                        if (aVar3 == aVar2) {
                            aVar = f.this.f14353c.f14340c;
                            break;
                        }
                        aVar = aVar3;
                        if (aVar3 == null) {
                            break;
                        } else if (aVar3.a() != null) {
                            aVar = aVar3;
                            break;
                        } else {
                            aVar2 = aVar3;
                        }
                    }
                    this.f14354a = aVar;
                    this.f14355c = aVar == null ? null : aVar.a();
                    return e;
                }
                throw new NoSuchElementException();
            } finally {
                f.this.b();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
            r4.d.a(r0, r0);
         */
        @Override // java.util.Iterator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void remove() {
            /*
                r4 = this;
                r0 = r4
                com.sdk.tencent.d.a<E> r0 = r0.b
                if (r0 == 0) goto L4f
                r0 = r4
                com.sdk.tencent.d.f r0 = com.sdk.tencent.d.f.this
                r0.a()
                r0 = r4
                com.sdk.tencent.d.a<E> r0 = r0.b     // Catch: java.lang.Throwable -> L45
                r8 = r0
                r0 = r4
                r1 = 0
                r0.b = r1     // Catch: java.lang.Throwable -> L45
                r0 = r4
                com.sdk.tencent.d.f r0 = com.sdk.tencent.d.f.this     // Catch: java.lang.Throwable -> L45
                com.sdk.tencent.d.a<E> r0 = r0.f14353c     // Catch: java.lang.Throwable -> L45
                r5 = r0
            L21:
                r0 = r5
                r6 = r0
                r0 = r6
                com.sdk.tencent.d.a<T> r0 = r0.f14340c     // Catch: java.lang.Throwable -> L45
                r7 = r0
                r0 = r7
                if (r0 == 0) goto L3d
                r0 = r7
                r5 = r0
                r0 = r7
                r1 = r8
                if (r0 != r1) goto L21
                r0 = r4
                com.sdk.tencent.d.f r0 = com.sdk.tencent.d.f.this     // Catch: java.lang.Throwable -> L45
                r1 = r7
                r2 = r6
                r0.a(r1, r2)     // Catch: java.lang.Throwable -> L45
            L3d:
                r0 = r4
                com.sdk.tencent.d.f r0 = com.sdk.tencent.d.f.this
                r0.b()
                return
            L45:
                r5 = move-exception
                r0 = r4
                com.sdk.tencent.d.f r0 = com.sdk.tencent.d.f.this
                r0.b()
                r0 = r5
                throw r0
            L4f:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                r1 = r0
                r1.<init>()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sdk.tencent.d.f.a.remove():void");
        }
    }

    public f() {
        this(Integer.MAX_VALUE);
    }

    public f(int i) {
        this.b = new AtomicInteger();
        ReentrantLock reentrantLock = new ReentrantLock();
        this.e = reentrantLock;
        this.f = reentrantLock.newCondition();
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.g = reentrantLock2;
        this.h = reentrantLock2.newCondition();
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.f14352a = i;
        com.sdk.tencent.d.a<E> aVar = new com.sdk.tencent.d.a<>(null);
        this.f14353c = aVar;
        this.d = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final E a(com.sdk.tencent.d.a<E> aVar) {
        boolean z;
        synchronized (this) {
            if (aVar == 0) {
                com.sdk.tencent.d.a aVar2 = (com.sdk.tencent.d.a<E>) this.f14353c;
                com.sdk.tencent.d.a<E> aVar3 = (com.sdk.tencent.d.a<E>) aVar2.f14340c;
                aVar2.f14340c = aVar2;
                this.f14353c = aVar3;
                E a2 = aVar3.a();
                aVar3.a(null);
                return a2;
            }
            com.sdk.tencent.d.a<E> aVar4 = this.f14353c;
            while (true) {
                com.sdk.tencent.d.a aVar5 = (com.sdk.tencent.d.a<E>) aVar4.f14340c;
                z = false;
                if (aVar5 == null) {
                    break;
                } else if (aVar5.b.f14351a.ordinal() > aVar.b.f14351a.ordinal()) {
                    aVar4.f14340c = aVar;
                    aVar.f14340c = aVar5;
                    z = true;
                    break;
                } else {
                    aVar4 = aVar4.f14340c;
                }
            }
            if (!z) {
                this.d.f14340c = aVar;
                this.d = aVar;
            }
            return null;
        }
    }

    public void a() {
        this.g.lock();
        this.e.lock();
    }

    public void a(com.sdk.tencent.d.a<E> aVar, com.sdk.tencent.d.a<E> aVar2) {
        aVar.a(null);
        aVar2.f14340c = (com.sdk.tencent.d.a<E>) aVar.f14340c;
        if (this.d == aVar) {
            this.d = aVar2;
        }
        if (this.b.getAndDecrement() == this.f14352a) {
            this.h.signal();
        }
    }

    public void b() {
        this.e.unlock();
        this.g.unlock();
    }

    public final void c() {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            this.f.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        a();
        try {
            com.sdk.tencent.d.a aVar = this.f14353c;
            while (true) {
                com.sdk.tencent.d.a aVar2 = aVar;
                com.sdk.tencent.d.a aVar3 = aVar2.f14340c;
                if (aVar3 == null) {
                    break;
                }
                aVar2.f14340c = aVar2;
                aVar3.a(null);
                aVar = aVar3;
            }
            this.f14353c = this.d;
            if (this.b.getAndSet(0) == this.f14352a) {
                this.h.signal();
            }
        } finally {
            b();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        a();
        try {
            com.sdk.tencent.d.a<E> aVar = this.f14353c;
            do {
                aVar = aVar.f14340c;
                if (aVar == null) {
                    b();
                    return false;
                }
            } while (!obj.equals(aVar.a()));
            b();
            return true;
        } catch (Throwable th) {
            b();
            throw th;
        }
    }

    public final void d() {
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            this.h.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        collection.getClass();
        if (collection != this) {
            if (i <= 0) {
                return 0;
            }
            ReentrantLock reentrantLock = this.e;
            reentrantLock.lock();
            boolean z = false;
            try {
                int min = Math.min(i, this.b.get());
                com.sdk.tencent.d.a<E> aVar = this.f14353c;
                int i2 = 0;
                while (i2 < min) {
                    com.sdk.tencent.d.a<E> aVar2 = aVar.f14340c;
                    collection.add((E) aVar2.a());
                    aVar2.a(null);
                    aVar.f14340c = aVar;
                    i2++;
                    aVar = aVar2;
                }
                boolean z2 = false;
                if (i2 > 0) {
                    this.f14353c = aVar;
                    z = false;
                    z2 = false;
                    if (this.b.getAndAdd(-i2) == this.f14352a) {
                        z2 = true;
                    }
                }
                reentrantLock.unlock();
                if (z2) {
                    d();
                }
                return min;
            } catch (Throwable th) {
                reentrantLock.unlock();
                if (z) {
                    d();
                }
                throw th;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new a();
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e) {
        e.getClass();
        AtomicInteger atomicInteger = this.b;
        boolean z = false;
        if (atomicInteger.get() == this.f14352a) {
            return false;
        }
        int i = -1;
        com.sdk.tencent.d.a<E> aVar = new com.sdk.tencent.d.a<>(e);
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            if (atomicInteger.get() < this.f14352a) {
                a(aVar);
                int andIncrement = atomicInteger.getAndIncrement();
                i = andIncrement;
                if (andIncrement + 1 < this.f14352a) {
                    this.h.signal();
                    i = andIncrement;
                }
            }
            reentrantLock.unlock();
            if (i == 0) {
                c();
            }
            if (i >= 0) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e, long j, TimeUnit timeUnit) {
        e.getClass();
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.g;
        AtomicInteger atomicInteger = this.b;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == this.f14352a) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return false;
                }
                nanos = this.h.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        a(new com.sdk.tencent.d.a<>(e));
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement + 1 < this.f14352a) {
            this.h.signal();
        }
        if (andIncrement == 0) {
            c();
            return true;
        }
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        if (this.b.get() == 0) {
            return null;
        }
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            com.sdk.tencent.d.a<E> aVar = this.f14353c.f14340c;
            if (aVar == null) {
                reentrantLock.unlock();
                return null;
            }
            return aVar.a();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue
    public E poll() {
        AtomicInteger atomicInteger = this.b;
        E e = null;
        if (atomicInteger.get() == 0) {
            return null;
        }
        int i = -1;
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            if (atomicInteger.get() > 0) {
                E a2 = a(null);
                int andDecrement = atomicInteger.getAndDecrement();
                i = andDecrement;
                e = a2;
                if (andDecrement > 1) {
                    this.f.signal();
                    e = a2;
                    i = andDecrement;
                }
            }
            reentrantLock.unlock();
            if (i == this.f14352a) {
                d();
            }
            return e;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        AtomicInteger atomicInteger = this.b;
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return null;
                }
                nanos = this.f.awaitNanos(nanos);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        E a2 = a(null);
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.f.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.f14352a) {
            d();
        }
        return a2;
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e) {
        e.getClass();
        com.sdk.tencent.d.a<E> aVar = new com.sdk.tencent.d.a<>(e);
        ReentrantLock reentrantLock = this.g;
        AtomicInteger atomicInteger = this.b;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == this.f14352a) {
            try {
                this.h.await();
            } finally {
                reentrantLock.unlock();
            }
        }
        a(aVar);
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement + 1 < this.f14352a) {
            this.h.signal();
        }
        if (andIncrement == 0) {
            c();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return this.f14352a - this.b.get();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public boolean remove(Object obj) {
        com.sdk.tencent.d.a<E> aVar;
        com.sdk.tencent.d.a<E> aVar2;
        if (obj == null) {
            return false;
        }
        a();
        try {
            com.sdk.tencent.d.a<E> aVar3 = this.f14353c;
            do {
                aVar = aVar3;
                aVar2 = aVar.f14340c;
                if (aVar2 == null) {
                    b();
                    return false;
                }
                aVar3 = aVar2;
            } while (!obj.equals(aVar2.a()));
            a(aVar2, aVar);
            b();
            return true;
        } catch (Throwable th) {
            b();
            throw th;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.b.get();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() {
        AtomicInteger atomicInteger = this.b;
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                this.f.await();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        E a2 = a(null);
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.f.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.f14352a) {
            d();
        }
        return a2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        a();
        try {
            Object[] objArr = new Object[this.b.get()];
            int i = 0;
            com.sdk.tencent.d.a<E> aVar = this.f14353c;
            while (true) {
                aVar = aVar.f14340c;
                if (aVar == null) {
                    return objArr;
                }
                objArr[i] = aVar.a();
                i++;
            }
        } finally {
            b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27, types: [java.lang.Object[]] */
    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        a();
        try {
            int i = this.b.get();
            T[] tArr2 = tArr;
            if (tArr.length < i) {
                tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
            }
            int i2 = 0;
            com.sdk.tencent.d.a<E> aVar = this.f14353c;
            while (true) {
                aVar = aVar.f14340c;
                if (aVar == null) {
                    break;
                }
                tArr2[i2] = aVar.a();
                i2++;
            }
            if (tArr2.length > i2) {
                tArr2[i2] = null;
            }
            b();
            return tArr2;
        } catch (Throwable th) {
            b();
            throw th;
        }
    }
}
