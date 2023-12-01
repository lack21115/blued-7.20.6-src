package androidx.coordinatorlayout.widget;

import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:androidx/coordinatorlayout/widget/DirectedAcyclicGraph.class */
public final class DirectedAcyclicGraph<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Pools.Pool<ArrayList<T>> f2298a = new Pools.SimplePool(10);
    private final SimpleArrayMap<T, ArrayList<T>> b = new SimpleArrayMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<T> f2299c = new ArrayList<>();
    private final HashSet<T> d = new HashSet<>();

    private ArrayList<T> a() {
        ArrayList<T> acquire = this.f2298a.acquire();
        ArrayList<T> arrayList = acquire;
        if (acquire == null) {
            arrayList = new ArrayList<>();
        }
        return arrayList;
    }

    private void a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t)) {
            return;
        }
        if (hashSet.contains(t)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t);
        ArrayList<T> arrayList2 = this.b.get(t);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                a(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(t);
        arrayList.add(t);
    }

    private void a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f2298a.release(arrayList);
    }

    public void addEdge(T t, T t2) {
        if (!this.b.containsKey(t) || !this.b.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayList = this.b.get(t);
        ArrayList<T> arrayList2 = arrayList;
        if (arrayList == null) {
            arrayList2 = a();
            this.b.put(t, arrayList2);
        }
        arrayList2.add(t2);
    }

    public void addNode(T t) {
        if (this.b.containsKey(t)) {
            return;
        }
        this.b.put(t, null);
    }

    public void clear() {
        int size = this.b.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                this.b.clear();
                return;
            }
            ArrayList<T> valueAt = this.b.valueAt(i2);
            if (valueAt != null) {
                a(valueAt);
            }
            i = i2 + 1;
        }
    }

    public boolean contains(T t) {
        return this.b.containsKey(t);
    }

    public List getIncomingEdges(T t) {
        return this.b.get(t);
    }

    public List<T> getOutgoingEdges(T t) {
        int size = this.b.size();
        ArrayList arrayList = null;
        int i = 0;
        while (i < size) {
            ArrayList<T> valueAt = this.b.valueAt(i);
            ArrayList arrayList2 = arrayList;
            if (valueAt != null) {
                arrayList2 = arrayList;
                if (valueAt.contains(t)) {
                    arrayList2 = arrayList;
                    if (arrayList == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(this.b.keyAt(i));
                }
            }
            i++;
            arrayList = arrayList2;
        }
        return arrayList;
    }

    public ArrayList<T> getSortedList() {
        this.f2299c.clear();
        this.d.clear();
        int size = this.b.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return this.f2299c;
            }
            a(this.b.keyAt(i2), this.f2299c, this.d);
            i = i2 + 1;
        }
    }

    public boolean hasOutgoingEdges(T t) {
        int size = this.b.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return false;
            }
            ArrayList<T> valueAt = this.b.valueAt(i2);
            if (valueAt != null && valueAt.contains(t)) {
                return true;
            }
            i = i2 + 1;
        }
    }
}
