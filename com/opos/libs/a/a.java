package com.opos.libs.a;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/libs/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, Set<Integer>> f25601a;
    public AtomicInteger b;

    /* renamed from: c  reason: collision with root package name */
    public ReentrantReadWriteLock f25602c = new ReentrantReadWriteLock();

    /* renamed from: com.opos.libs.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/libs/a/a$a.class */
    public static class C0668a {

        /* renamed from: a  reason: collision with root package name */
        public int f25603a;
        public Map<Integer, Set<Integer>> b = new HashMap();

        public C0668a(int i) {
            this.f25603a = i;
        }

        public C0668a a(int i, int i2) {
            Set<Integer> set = this.b.get(Integer.valueOf(i));
            HashSet hashSet = set;
            if (set == null) {
                hashSet = new HashSet();
                this.b.put(Integer.valueOf(i), hashSet);
            }
            hashSet.add(Integer.valueOf(i2));
            return this;
        }

        public C0668a a(int i, int... iArr) {
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

        public a a() {
            return new a(this.f25603a, this.b);
        }
    }

    public a(int i, Map<Integer, Set<Integer>> map) {
        this.b = new AtomicInteger(i);
        a(map);
    }

    public int a() {
        return this.b.get();
    }

    public int a(int i) {
        com.opos.cmn.an.f.a.b("SyncStateController", "changeToState:" + i);
        try {
            this.f25602c.readLock().lock();
            int i2 = this.b.get();
            if (i2 != i) {
                int i3 = 3;
                while (i3 > 0) {
                    if (!a(i2, i)) {
                        this.f25602c.readLock().unlock();
                        return i2;
                    } else if (!this.b.compareAndSet(i2, i)) {
                        i3--;
                        i2 = this.b.get();
                    }
                }
                this.f25602c.readLock().unlock();
                return a(i, (Callable<Boolean>) null);
            }
            return i;
        } finally {
            this.f25602c.readLock().unlock();
        }
    }

    public int a(int i, Callable<Boolean> callable) {
        int i2;
        String str;
        com.opos.cmn.an.f.a.b("SyncStateController", "changeToStateBy:" + i + ", callable = " + callable + ", mCurrentState:" + this.b.get());
        try {
            this.f25602c.writeLock().lock();
            int i3 = this.b.get();
            if (i3 == i) {
                str = "changeToStateBy but now target:" + i;
            } else if (a(i3, i)) {
                if (callable == null) {
                    this.b.compareAndSet(i3, i);
                    i2 = i;
                } else {
                    try {
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("SyncStateController", "call exception :" + e);
                    }
                    if (callable.call().booleanValue()) {
                        i2 = i;
                        if (!this.b.compareAndSet(i3, i)) {
                            com.opos.cmn.an.f.a.b("SyncStateController", "unexpected fail");
                            i2 = i;
                        }
                    } else {
                        com.opos.cmn.an.f.a.b("SyncStateController", "execute fail");
                        i2 = i3;
                    }
                }
                this.f25602c.writeLock().unlock();
                return i2;
            } else {
                str = "changeToStateBy but target is not enable:" + i;
            }
            com.opos.cmn.an.f.a.b("SyncStateController", str);
            return i3;
        } finally {
            this.f25602c.writeLock().unlock();
        }
    }

    public final void a(Map<Integer, Set<Integer>> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f25601a = new HashMap();
        for (Integer num : map.keySet()) {
            Set<Integer> set = map.get(num);
            if (set != null && !set.isEmpty()) {
                this.f25601a.put(num, new HashSet(map.get(num)));
            }
        }
    }

    public final boolean a(int i, int i2) {
        String str;
        Map<Integer, Set<Integer>> map = this.f25601a;
        if (map == null) {
            str = "checkEnable but mController = null";
        } else if (!map.containsKey(Integer.valueOf(i))) {
            str = "checkEnable but error current state:" + i;
        } else if (this.f25601a.get(Integer.valueOf(i)).contains(Integer.valueOf(i2))) {
            return true;
        } else {
            str = "checkEnable but error next state:" + i + ",to:" + i2;
        }
        com.opos.cmn.an.f.a.b("SyncStateController", str);
        return false;
    }
}
