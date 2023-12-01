package com.opos.mobad.l;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/l/o.class */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private Map<Integer, Set<Integer>> f12634a;
    private AtomicInteger b;

    /* renamed from: c  reason: collision with root package name */
    private ReentrantReadWriteLock f12635c = new ReentrantReadWriteLock();

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/l/o$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f12636a;
        private Map<Integer, Set<Integer>> b = new HashMap();

        public a(int i) {
            this.f12636a = i;
        }

        public a a(int i, int i2) {
            Set<Integer> set = this.b.get(Integer.valueOf(i));
            HashSet hashSet = set;
            if (set == null) {
                hashSet = new HashSet();
                this.b.put(Integer.valueOf(i), hashSet);
            }
            hashSet.add(Integer.valueOf(i2));
            return this;
        }

        public a a(int i, int... iArr) {
            if (iArr == null) {
                return this;
            }
            Set<Integer> set = this.b.get(Integer.valueOf(i));
            HashSet hashSet = set;
            if (set == null) {
                hashSet = new HashSet();
                this.b.put(Integer.valueOf(i), hashSet);
            }
            int length = iArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return this;
                }
                hashSet.add(Integer.valueOf(iArr[i3]));
                i2 = i3 + 1;
            }
        }

        public o a() {
            return new o(this.f12636a, this.b);
        }
    }

    protected o(int i, Map<Integer, Set<Integer>> map) {
        this.b = new AtomicInteger(i);
        a(map);
    }

    private int a(int i, int i2, Callable<Boolean> callable) {
        try {
            if (!callable.call().booleanValue()) {
                a("execute fail");
                return i;
            }
            if (!this.b.compareAndSet(i, i2)) {
                a("unexpected fail");
                b();
            }
            return i2;
        } catch (Exception e) {
            a("call exception :" + e);
            return i;
        }
    }

    private static final void a(String str) {
        com.opos.cmn.an.f.a.b("SyncStateController", str);
    }

    private void a(Map<Integer, Set<Integer>> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f12634a = new HashMap();
        for (Integer num : map.keySet()) {
            Set<Integer> set = map.get(num);
            if (set != null && !set.isEmpty()) {
                this.f12634a.put(num, new HashSet(map.get(num)));
            }
        }
    }

    private void b() {
    }

    private boolean b(int i, int i2) {
        String str;
        Map<Integer, Set<Integer>> map = this.f12634a;
        if (map == null) {
            str = "checkEnable but mController = null";
        } else if (!map.containsKey(Integer.valueOf(i))) {
            str = "checkEnable but error current state:" + i;
        } else if (this.f12634a.get(Integer.valueOf(i)).contains(Integer.valueOf(i2))) {
            return true;
        } else {
            str = "checkEnable but error next state:" + i + ",to:" + i2;
        }
        a(str);
        return false;
    }

    public int a() {
        return this.b.get();
    }

    public int a(int i) {
        a("changeToState:" + i);
        try {
            this.f12635c.readLock().lock();
            int i2 = this.b.get();
            if (i2 != i) {
                int i3 = 3;
                while (i3 > 0) {
                    if (!b(i2, i)) {
                        this.f12635c.readLock().unlock();
                        return i2;
                    } else if (!this.b.compareAndSet(i2, i)) {
                        i3--;
                        i2 = this.b.get();
                    }
                }
                this.f12635c.readLock().unlock();
                return a(i, (Callable<Boolean>) null);
            }
            return i;
        } finally {
            this.f12635c.readLock().unlock();
        }
    }

    public int a(int i, int i2) {
        AtomicInteger atomicInteger;
        a("changeToStateFrom:" + i + ", to:" + i2 + ", mCurrentState:" + this.b.get());
        try {
            this.f12635c.readLock().lock();
            if (this.b.get() == i2) {
                a("changeToStateFrom target equal mCurrentState:" + this.b);
            } else {
                if (!b(i, i2)) {
                    atomicInteger = this.b;
                } else if (!this.b.compareAndSet(i, i2)) {
                    atomicInteger = this.b;
                }
                i2 = atomicInteger.get();
            }
            this.f12635c.readLock().unlock();
            return i2;
        } catch (Throwable th) {
            this.f12635c.readLock().unlock();
            throw th;
        }
    }

    public int a(int i, Callable<Boolean> callable) {
        int a2;
        String str;
        a("changeToStateBy:" + i + ", callable = " + callable + ", mCurrentState:" + this.b.get());
        try {
            this.f12635c.writeLock().lock();
            int i2 = this.b.get();
            if (i2 == i) {
                str = "changeToStateBy but now target:" + i;
            } else if (b(i2, i)) {
                if (callable == null) {
                    a2 = i;
                    if (!this.b.compareAndSet(i2, i)) {
                        b();
                        a2 = i;
                    }
                } else {
                    a2 = a(i2, i, callable);
                }
                this.f12635c.writeLock().unlock();
                return a2;
            } else {
                str = "changeToStateBy but target is not enable:" + i;
            }
            a(str);
            return i2;
        } finally {
            this.f12635c.writeLock().unlock();
        }
    }
}
