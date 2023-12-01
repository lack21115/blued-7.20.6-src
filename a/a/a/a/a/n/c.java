package a.a.a.a.a.n;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/n/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f1474a = {"domain", "wsHost"};
    public final HashMap<String, a> b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<String, Integer[]> f1475c = new HashMap<>();

    public a a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.b.get(str);
        }
        return aVar;
    }

    public ArrayList<String> a() {
        ArrayList<String> arrayList;
        synchronized (this) {
            arrayList = new ArrayList<>(this.b.keySet());
        }
        return arrayList;
    }

    public void a(ArrayList<String> arrayList, HashMap<String, ArrayList<String>> hashMap, HashMap<String, Integer[]> hashMap2, int i) {
        synchronized (this) {
            this.b.clear();
            this.f1475c.clear();
            for (Map.Entry<String, ArrayList<String>> entry : hashMap.entrySet()) {
                this.b.put(entry.getKey(), new a((String[]) entry.getValue().toArray(new String[entry.getValue().size()])));
            }
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.b.put(it.next(), new a(null));
            }
            for (Map.Entry<String, Integer[]> entry2 : hashMap2.entrySet()) {
                this.f1475c.put(entry2.getKey(), entry2.getValue());
            }
        }
    }

    public Integer[] b(String str) {
        return this.f1475c.containsKey(str) ? this.f1475c.get(str) : new Integer[]{2, 6935};
    }
}
