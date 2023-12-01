package c.t.m.g;

import java.util.Observable;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/n3.class */
public class n3 extends Observable {
    @Override // java.util.Observable
    public void clearChanged() {
        synchronized (this) {
            super.clearChanged();
        }
    }

    @Override // java.util.Observable
    public void setChanged() {
        synchronized (this) {
            super.setChanged();
        }
    }
}
