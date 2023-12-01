package com.opos.mobad.n.i;

import android.view.View;
import com.opos.mobad.c.b.b;
import com.opos.mobad.n.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/i/a.class */
public abstract class a implements com.opos.mobad.n.a {

    /* renamed from: a  reason: collision with root package name */
    private int f26999a;

    /* renamed from: c  reason: collision with root package name */
    public a.InterfaceC0708a f27000c;
    private long d;
    private boolean e = false;
    protected C0718a b = j();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.mobad.n.i.a$11  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/i/a$11.class */
    public class AnonymousClass11 implements Runnable {
        AnonymousClass11() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.b.a() < 3) {
                a.this.b.a(3, new Callable<Boolean>() { // from class: com.opos.mobad.n.i.a.11.1
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        b.a(new Runnable() { // from class: com.opos.mobad.n.i.a.11.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.f27000c != null) {
                                    a.this.f27000c.b();
                                }
                            }
                        });
                        return true;
                    }
                });
                return;
            }
            com.opos.cmn.an.f.a.b("TemplateState", "current state has showing ,no need to onShow = " + a.this.b.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.mobad.n.i.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/i/a$a.class */
    public static class C0718a {

        /* renamed from: a  reason: collision with root package name */
        private Map<Integer, Set<Integer>> f27023a;
        private AtomicInteger b;

        /* renamed from: com.opos.mobad.n.i.a$a$a  reason: collision with other inner class name */
        /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/i/a$a$a.class */
        public static class C0719a {

            /* renamed from: a  reason: collision with root package name */
            private int f27024a;
            private Map<Integer, Set<Integer>> b = new HashMap();

            public C0719a(int i) {
                this.f27024a = i;
            }

            public C0719a a(int i, int i2) {
                Set<Integer> set = this.b.get(Integer.valueOf(i));
                HashSet hashSet = set;
                if (set == null) {
                    hashSet = new HashSet();
                    this.b.put(Integer.valueOf(i), hashSet);
                }
                hashSet.add(Integer.valueOf(i2));
                return this;
            }

            public C0719a a(int i, int... iArr) {
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

            public C0718a a() {
                return new C0718a(this.f27024a, this.b);
            }
        }

        protected C0718a(int i, Map<Integer, Set<Integer>> map) {
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
            com.opos.cmn.an.f.a.b("TemplateStateController", str);
        }

        private void a(Map<Integer, Set<Integer>> map) {
            if (map == null || map.isEmpty()) {
                return;
            }
            this.f27023a = new HashMap();
            for (Integer num : map.keySet()) {
                Set<Integer> set = map.get(num);
                if (set != null && !set.isEmpty()) {
                    this.f27023a.put(num, new HashSet(map.get(num)));
                }
            }
        }

        private boolean a(int i, int i2) {
            String str;
            Map<Integer, Set<Integer>> map = this.f27023a;
            if (map == null) {
                str = "checkEnable but mController = null";
            } else if (!map.containsKey(Integer.valueOf(i))) {
                str = "checkEnable but error current state:" + i;
            } else if (this.f27023a.get(Integer.valueOf(i)).contains(Integer.valueOf(i2))) {
                return true;
            } else {
                str = "checkEnable but error next state:" + i + ",to:" + i2;
            }
            a(str);
            return false;
        }

        private void b() {
        }

        public int a() {
            return this.b.get();
        }

        public int a(int i, Callable<Boolean> callable) {
            int a2;
            StringBuilder sb;
            String str;
            a("changeToStateBy:" + i + ", callable = " + callable + ", mCurrentState:" + this.b.get());
            int i2 = this.b.get();
            if (i2 == i) {
                sb = new StringBuilder();
                str = "changeToStateBy but now target:";
            } else if (a(i2, i)) {
                if (callable == null) {
                    a2 = i;
                    if (!this.b.compareAndSet(i2, i)) {
                        b();
                        return i;
                    }
                } else {
                    a2 = a(i2, i, callable);
                }
                return a2;
            } else {
                sb = new StringBuilder();
                str = "changeToStateBy but target is not enable:";
            }
            sb.append(str);
            sb.append(i);
            a(sb.toString());
            return i2;
        }
    }

    public a(int i) {
        this.f26999a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final long j, final long j2) {
        b.a(new Runnable() { // from class: com.opos.mobad.n.i.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.o() == 8 || a.this.f27000c == null) {
                    return;
                }
                a.this.f27000c.d(j, j2);
            }
        });
    }

    protected static final C0718a j() {
        return new C0718a.C0719a(0).a(0, 2, 1, 8).a(1, 8).a(2, 3, 8).a(3, 4, 5, 8).a(4, 7, 6, 1, 8).a(5, 7, 6, 1, 8).a(7, 4, 5, 8).a(6, 5, 8).a();
    }

    @Override // com.opos.mobad.n.a
    public void a() {
        this.b.a(6, new Callable<Boolean>() { // from class: com.opos.mobad.n.i.a.6
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                return Boolean.valueOf(a.this.f());
            }
        });
    }

    public void a(final int i) {
        b.b(new Runnable() { // from class: com.opos.mobad.n.i.a.9
            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(1, new Callable<Boolean>() { // from class: com.opos.mobad.n.i.a.9.1
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        if (a.this.f27000c != null) {
                            a.this.f27000c.b(i);
                        }
                        return false;
                    }
                });
            }
        });
    }

    public void a(final int i, final String str) {
        b.b(new Runnable() { // from class: com.opos.mobad.n.i.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(1, new Callable<Boolean>() { // from class: com.opos.mobad.n.i.a.2.1
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        if (a.this.f27000c != null) {
                            a.this.f27000c.a(i, str);
                        }
                        return true;
                    }
                });
            }
        });
    }

    public void a(long j, long j2) {
        a.InterfaceC0708a interfaceC0708a;
        if (this.b.a() == 8 || (interfaceC0708a = this.f27000c) == null) {
            return;
        }
        interfaceC0708a.c(j, j2);
    }

    public void a(final View view, final int[] iArr) {
        b.b(new Runnable() { // from class: com.opos.mobad.n.i.a.12
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f27000c != null) {
                    a.this.f27000c.d(view, iArr);
                }
            }
        });
    }

    public void a(View view, int[] iArr, boolean z) {
        a.InterfaceC0708a interfaceC0708a;
        if (this.b.a() == 8 || (interfaceC0708a = this.f27000c) == null) {
            return;
        }
        interfaceC0708a.a(view, iArr, z);
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0708a interfaceC0708a) {
        this.f27000c = interfaceC0708a;
    }

    public void a(final Callable callable) {
        b.b(new Runnable() { // from class: com.opos.mobad.n.i.a.10
            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(2, new Callable<Boolean>() { // from class: com.opos.mobad.n.i.a.10.1
                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        if (a.this.f27000c != null) {
                            a.this.f27000c.e();
                        }
                        if (callable != null) {
                            callable.call();
                        }
                        return true;
                    }
                });
            }
        });
    }

    @Override // com.opos.mobad.n.a
    public void b() {
        this.b.a(5, new Callable<Boolean>() { // from class: com.opos.mobad.n.i.a.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                return Boolean.valueOf(a.this.g());
            }
        });
    }

    public void b(int i) {
        a.InterfaceC0708a interfaceC0708a;
        if (this.b.a() == 8 || (interfaceC0708a = this.f27000c) == null) {
            return;
        }
        interfaceC0708a.c(i);
    }

    public void b(long j, long j2) {
        a.InterfaceC0708a interfaceC0708a;
        if (this.b.a() == 8 || (interfaceC0708a = this.f27000c) == null) {
            return;
        }
        interfaceC0708a.b(j, j2);
    }

    public void b(View view, int[] iArr) {
        a.InterfaceC0708a interfaceC0708a;
        if (this.b.a() == 8 || (interfaceC0708a = this.f27000c) == null) {
            return;
        }
        interfaceC0708a.c(view, iArr);
    }

    public void c(final long j, final long j2) {
        com.opos.cmn.an.f.a.b("TemplateState", "onProgress = " + j + "," + j2 + "," + this.b.a());
        b.b(new Runnable() { // from class: com.opos.mobad.n.i.a.3
            @Override // java.lang.Runnable
            public void run() {
                a aVar;
                long j3;
                int a2 = a.this.b.a();
                if (a2 == 4 || a2 == 5) {
                    if (a.this.e) {
                        aVar = a.this;
                        j3 = j;
                    } else {
                        a.this.d = j2;
                        a.this.e = true;
                        aVar = a.this;
                        j3 = 0;
                    }
                    aVar.d(j3, aVar.d);
                }
            }
        });
    }

    public void c(View view, int[] iArr) {
        a.InterfaceC0708a interfaceC0708a;
        if (this.b.a() == 8 || (interfaceC0708a = this.f27000c) == null) {
            return;
        }
        interfaceC0708a.b(view, iArr);
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        this.b.a(8, new Callable<Boolean>() { // from class: com.opos.mobad.n.i.a.13
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                a.this.h();
                a.this.f27000c = null;
                return true;
            }
        });
    }

    public void d(View view, int[] iArr) {
        a.InterfaceC0708a interfaceC0708a;
        if (this.b.a() == 8 || (interfaceC0708a = this.f27000c) == null) {
            return;
        }
        interfaceC0708a.f(view, iArr);
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.f26999a;
    }

    public void e(View view, int[] iArr) {
        a.InterfaceC0708a interfaceC0708a;
        if (this.b.a() == 8 || (interfaceC0708a = this.f27000c) == null) {
            return;
        }
        interfaceC0708a.g(view, iArr);
    }

    public void f(View view, int[] iArr) {
        a.InterfaceC0708a interfaceC0708a;
        if (this.b.a() == 8 || (interfaceC0708a = this.f27000c) == null) {
            return;
        }
        interfaceC0708a.e(view, iArr);
    }

    protected abstract boolean f();

    public void g(View view, int[] iArr) {
        a.InterfaceC0708a interfaceC0708a;
        if (this.b.a() == 8 || (interfaceC0708a = this.f27000c) == null) {
            return;
        }
        interfaceC0708a.h(view, iArr);
    }

    protected abstract boolean g();

    protected abstract void h();

    public void h(View view, int[] iArr) {
        a.InterfaceC0708a interfaceC0708a;
        if (this.b.a() == 8 || (interfaceC0708a = this.f27000c) == null) {
            return;
        }
        interfaceC0708a.a(view, iArr);
    }

    public void i(View view, int[] iArr) {
        a.InterfaceC0708a interfaceC0708a;
        if (this.b.a() == 8 || (interfaceC0708a = this.f27000c) == null) {
            return;
        }
        interfaceC0708a.i(view, iArr);
    }

    public void k() {
        this.b.a(4, new Callable<Boolean>() { // from class: com.opos.mobad.n.i.a.7
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                return Boolean.valueOf(a.this.g());
            }
        });
    }

    public void l() {
        this.b.a(7, new Callable<Boolean>() { // from class: com.opos.mobad.n.i.a.8
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                return Boolean.valueOf(a.this.f());
            }
        });
    }

    public void m() {
        a((Callable) null);
    }

    public void n() {
        b.b(new AnonymousClass11());
    }

    public int o() {
        return this.b.a();
    }

    public void p() {
        b.b(new Runnable() { // from class: com.opos.mobad.n.i.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f27000c != null) {
                    a.this.f27000c.a(a.this.d, a.this.d);
                }
            }
        });
    }
}
