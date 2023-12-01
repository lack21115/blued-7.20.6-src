package c.t.m.g;

import java.util.Observable;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/n1.class */
public class n1 {
    public static volatile n1 b;

    /* renamed from: a  reason: collision with root package name */
    public b f3842a = new b();

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/n1$b.class */
    public static class b extends Observable {
        public b() {
        }

        @Override // java.util.Observable
        public void notifyObservers(Object obj) {
            setChanged();
            super.notifyObservers(obj);
        }
    }

    public static n1 a() {
        Thread.currentThread().getId();
        if (b == null) {
            synchronized (n1.class) {
                try {
                    if (b == null) {
                        b = new n1();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        n1 n1Var = b;
        return b;
    }

    public void a(p1 p1Var) {
        this.f3842a.addObserver(p1Var);
    }

    public void b(p1 p1Var) {
        this.f3842a.deleteObserver(p1Var);
    }
}
