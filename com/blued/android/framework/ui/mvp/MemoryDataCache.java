package com.blued.android.framework.ui.mvp;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/mvp/MemoryDataCache.class */
public class MemoryDataCache<T> {

    /* renamed from: a  reason: collision with root package name */
    List<Pair<String, List>> f9923a = new ArrayList();

    private Pair<String, List> b(String str) {
        for (Pair<String, List> pair : this.f9923a) {
            if (pair.first.equals(str)) {
                return pair;
            }
        }
        return null;
    }

    public List<Pair<String, List>> a() {
        return new ArrayList(this.f9923a);
    }

    public List<Object> a(String str) {
        Pair<String, List> b = b(str);
        if (b != null) {
            return b.second;
        }
        return null;
    }

    public List a(String str, List list) {
        Pair<String, List> b = b(str);
        if (list == null) {
            if (b != null) {
                return b.second;
            }
            return null;
        } else if (b != null) {
            b.second.clear();
            b.second.addAll(list);
            return b.second;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            this.f9923a.add(new Pair<>(str, arrayList));
            return arrayList;
        }
    }

    public List b(String str, List list) {
        Pair<String, List> b = b(str);
        if (list == null) {
            if (b != null) {
                return b.second;
            }
            return null;
        } else if (b != null) {
            b.second.addAll(list);
            return b.second;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            this.f9923a.add(new Pair<>(str, arrayList));
            return arrayList;
        }
    }

    public boolean b() {
        return this.f9923a.isEmpty();
    }

    public void c() {
        this.f9923a.clear();
    }
}
