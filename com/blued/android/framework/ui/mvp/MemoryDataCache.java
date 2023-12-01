package com.blued.android.framework.ui.mvp;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/mvp/MemoryDataCache.class */
public class MemoryDataCache<T> {
    List<Pair<String, List>> a = new ArrayList();

    private Pair<String, List> b(String str) {
        for (Pair<String, List> pair : this.a) {
            if (((String) pair.first).equals(str)) {
                return pair;
            }
        }
        return null;
    }

    public List<Pair<String, List>> a() {
        return new ArrayList(this.a);
    }

    public List<Object> a(String str) {
        Pair<String, List> b = b(str);
        if (b != null) {
            return (List) b.second;
        }
        return null;
    }

    public List a(String str, List list) {
        Pair<String, List> b = b(str);
        if (list == null) {
            if (b != null) {
                return (List) b.second;
            }
            return null;
        } else if (b != null) {
            ((List) b.second).clear();
            ((List) b.second).addAll(list);
            return (List) b.second;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            this.a.add(new Pair<>(str, arrayList));
            return arrayList;
        }
    }

    public List b(String str, List list) {
        Pair<String, List> b = b(str);
        if (list == null) {
            if (b != null) {
                return (List) b.second;
            }
            return null;
        } else if (b != null) {
            ((List) b.second).addAll(list);
            return (List) b.second;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            this.a.add(new Pair<>(str, arrayList));
            return arrayList;
        }
    }

    public boolean b() {
        return this.a.isEmpty();
    }

    public void c() {
        this.a.clear();
    }
}
