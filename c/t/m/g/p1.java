package c.t.m.g;

import java.util.Observable;
import java.util.Observer;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/p1.class */
public abstract class p1 implements Observer {
    public abstract void a(o1 o1Var);

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (obj instanceof o1) {
            a((o1) obj);
        }
    }
}
