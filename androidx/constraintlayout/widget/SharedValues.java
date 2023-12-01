package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/SharedValues.class */
public class SharedValues {
    public static final int UNSET = -1;

    /* renamed from: a  reason: collision with root package name */
    private SparseIntArray f2284a = new SparseIntArray();
    private HashMap<Integer, HashSet<WeakReference<SharedValuesListener>>> b = new HashMap<>();

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/SharedValues$SharedValuesListener.class */
    public interface SharedValuesListener {
        void onNewValue(int i, int i2, int i3);
    }

    public void addListener(int i, SharedValuesListener sharedValuesListener) {
        HashSet<WeakReference<SharedValuesListener>> hashSet = this.b.get(Integer.valueOf(i));
        HashSet<WeakReference<SharedValuesListener>> hashSet2 = hashSet;
        if (hashSet == null) {
            hashSet2 = new HashSet<>();
            this.b.put(Integer.valueOf(i), hashSet2);
        }
        hashSet2.add(new WeakReference<>(sharedValuesListener));
    }

    public void clearListeners() {
        this.b.clear();
    }

    public void fireNewValue(int i, int i2) {
        int i3 = this.f2284a.get(i, -1);
        if (i3 == i2) {
            return;
        }
        this.f2284a.put(i, i2);
        HashSet<WeakReference<SharedValuesListener>> hashSet = this.b.get(Integer.valueOf(i));
        if (hashSet == null) {
            return;
        }
        Iterator<WeakReference<SharedValuesListener>> it = hashSet.iterator();
        boolean z = false;
        while (it.hasNext()) {
            SharedValuesListener sharedValuesListener = it.next().get();
            if (sharedValuesListener != null) {
                sharedValuesListener.onNewValue(i, i2, i3);
            } else {
                z = true;
            }
        }
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<WeakReference<SharedValuesListener>> it2 = hashSet.iterator();
            while (it2.hasNext()) {
                WeakReference<SharedValuesListener> next = it2.next();
                if (next.get() == null) {
                    arrayList.add(next);
                }
            }
            hashSet.removeAll(arrayList);
        }
    }

    public int getValue(int i) {
        return this.f2284a.get(i, -1);
    }

    public void removeListener(int i, SharedValuesListener sharedValuesListener) {
        HashSet<WeakReference<SharedValuesListener>> hashSet = this.b.get(Integer.valueOf(i));
        if (hashSet == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<WeakReference<SharedValuesListener>> it = hashSet.iterator();
        while (it.hasNext()) {
            WeakReference<SharedValuesListener> next = it.next();
            SharedValuesListener sharedValuesListener2 = next.get();
            if (sharedValuesListener2 == null || sharedValuesListener2 == sharedValuesListener) {
                arrayList.add(next);
            }
        }
        hashSet.removeAll(arrayList);
    }

    public void removeListener(SharedValuesListener sharedValuesListener) {
        for (Integer num : this.b.keySet()) {
            removeListener(num.intValue(), sharedValuesListener);
        }
    }
}
