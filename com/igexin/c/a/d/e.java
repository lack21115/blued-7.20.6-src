package com.igexin.c.a.d;

import com.igexin.c.a.d.f;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/d/e.class */
public class e<E extends f> {
    static final /* synthetic */ boolean h = !e.class.desiredAssertionStatus();
    private static final String i = "ScheduleQueue";

    /* renamed from: a  reason: collision with root package name */
    final transient ReentrantLock f23267a;
    final transient Condition b;

    /* renamed from: c  reason: collision with root package name */
    final TreeSet<E> f23268c;
    final AtomicInteger d;
    int e;
    g f;
    public final AtomicLong g;
    private long j;

    public e(Comparator<? super E> comparator, g gVar) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f23267a = reentrantLock;
        this.b = reentrantLock.newCondition();
        this.d = new AtomicInteger(0);
        this.g = new AtomicLong(-1L);
        this.f23268c = new TreeSet<>(comparator);
        this.f = gVar;
    }

    private E b() {
        try {
            return this.f23268c.first();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    private E c() {
        E b = b();
        if (b == null) {
            return null;
        }
        if (this.f23268c.remove(b)) {
            return b;
        }
        com.igexin.c.a.c.a.a(i, "Queue Poll Error@");
        return null;
    }

    private E d() {
        ReentrantLock reentrantLock = this.f23267a;
        reentrantLock.lock();
        try {
            E b = b();
            if (b != null) {
                if (b.a(TimeUnit.MILLISECONDS) > 0) {
                    b.N |= 134217728;
                } else {
                    b.N &= 1090519038;
                }
                if (b.N >= 0) {
                    E c2 = c();
                    if (h || c2 != null) {
                        if (!e()) {
                            this.b.signalAll();
                        }
                        return c2;
                    }
                    throw new AssertionError();
                }
            }
            reentrantLock.unlock();
            return null;
        } finally {
            reentrantLock.unlock();
        }
    }

    private boolean e() {
        ReentrantLock reentrantLock = this.f23267a;
        reentrantLock.lock();
        try {
            return this.f23268c.isEmpty();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void f() {
        this.f23268c.clear();
    }

    public final int a(E e, long j, TimeUnit timeUnit) {
        ReentrantLock reentrantLock = this.f23267a;
        reentrantLock.lock();
        try {
            if (!this.f23268c.contains(e)) {
                reentrantLock.unlock();
                return -1;
            }
            this.f23268c.remove(e);
            e.w = System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(j, timeUnit);
            e.getClass().getSimpleName();
            e.hashCode();
            e.a(TimeUnit.SECONDS);
            int i2 = a((e<E>) e) ? 1 : -2;
            reentrantLock.unlock();
            return i2;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final E a() throws InterruptedException {
        ReentrantLock reentrantLock = this.f23267a;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E b = b();
                if (b == null) {
                    this.d.set(1);
                    this.e = 0;
                    this.b.await();
                } else {
                    long a2 = b.a(TimeUnit.NANOSECONDS);
                    boolean z = true;
                    if (!b.m) {
                        z = b.n;
                    }
                    if (a2 <= 0 || z) {
                        break;
                    }
                    b.getClass().getSimpleName();
                    b.hashCode();
                    TimeUnit.SECONDS.convert(a2, TimeUnit.NANOSECONDS);
                    this.g.set(b.w);
                    com.igexin.c.a.c.a.a("schedule take|needAlarm = " + this.f.C + "|" + b.getClass().getName() + "@" + b.hashCode(), new Object[0]);
                    if (this.f.C) {
                        this.f.a(b.w);
                    }
                    this.b.awaitNanos(a2);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        E c2 = c();
        if (h || c2 != null) {
            if (!e()) {
                this.b.signalAll();
            }
            if (this.j > 0) {
                System.currentTimeMillis();
            }
            this.g.set(-1L);
            return c2;
        }
        throw new AssertionError();
    }

    public final boolean a(E e) {
        if (e == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f23267a;
        reentrantLock.lock();
        try {
            try {
                E b = b();
                int i2 = this.e + 1;
                this.e = i2;
                e.x = i2;
                if (!this.f23268c.add(e)) {
                    e.x--;
                    reentrantLock.unlock();
                    return false;
                }
                e.N++;
                e.N &= 1090519038;
                if (b == null || this.f23268c.comparator().compare(e, b) < 0) {
                    this.b.signalAll();
                }
                reentrantLock.unlock();
                return true;
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(e2);
                com.igexin.c.a.c.a.a("ScheduleQueue|offer|error", new Object[0]);
                reentrantLock.unlock();
                return false;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final boolean a(Class cls) {
        if (cls == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f23267a;
        reentrantLock.lock();
        try {
            ArrayList arrayList = new ArrayList();
            cls.getName();
            Iterator<E> it = this.f23268c.iterator();
            while (it.hasNext()) {
                E next = it.next();
                if (next.getClass() == cls) {
                    arrayList.add(next);
                }
            }
            cls.getName();
            arrayList.size();
            this.f23268c.removeAll(arrayList);
            reentrantLock.unlock();
            return true;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final boolean b(E e) {
        ReentrantLock reentrantLock = this.f23267a;
        reentrantLock.lock();
        try {
            if (this.f23268c.contains(e) && this.f23268c.remove(e)) {
                return a((e<E>) e);
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean c(E e) {
        if (e == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f23267a;
        reentrantLock.lock();
        try {
            e.getClass().getName();
            if (!this.f23268c.contains(e) || !this.f23268c.remove(e)) {
                reentrantLock.unlock();
                return false;
            }
            e.getClass().getName();
            e.hashCode();
            reentrantLock.unlock();
            return true;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
