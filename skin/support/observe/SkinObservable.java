package skin.support.observe;

import java.util.ArrayList;

/* loaded from: source-3503164-dex2jar.jar:skin/support/observe/SkinObservable.class */
public class SkinObservable {
    private final ArrayList<SkinObserver> a = new ArrayList<>();

    public void a(Object obj) {
        SkinObserver[] skinObserverArr;
        synchronized (this) {
            skinObserverArr = (SkinObserver[]) this.a.toArray(new SkinObserver[this.a.size()]);
        }
        int length = skinObserverArr.length;
        while (true) {
            int i = length - 1;
            if (i < 0) {
                return;
            }
            skinObserverArr[i].a(this, obj);
            length = i;
        }
    }

    public void a(SkinObserver skinObserver) {
        synchronized (this) {
            if (skinObserver == null) {
                throw new NullPointerException();
            }
            if (!this.a.contains(skinObserver)) {
                this.a.add(skinObserver);
            }
        }
    }

    public void b(SkinObserver skinObserver) {
        synchronized (this) {
            this.a.remove(skinObserver);
        }
    }

    public void j() {
        a((Object) null);
    }
}
