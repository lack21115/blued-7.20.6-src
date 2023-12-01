package com.opos.mobad.f.a.a;

import com.opos.mobad.service.a.e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/a/s.class */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<Integer, e.a> f26051a = new HashMap<>();

    public s(List<e.a> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (e.a aVar : list) {
            this.f26051a.put(Integer.valueOf(aVar.f27301a), aVar);
        }
    }

    private <T extends com.opos.mobad.ad.g> void a(List<T> list) {
        for (T t : list) {
            if (t != null) {
                t.b(0);
            }
        }
    }

    private <T extends com.opos.mobad.ad.g> void a(List<T> list, int i) {
        for (T t : list) {
            if (t != null) {
                t.a(i, null, 0);
            }
        }
    }

    public <T extends com.opos.mobad.ad.g> e.a a(HashMap<Integer, List<T>> hashMap) {
        List<T> value;
        T t;
        e.a aVar = null;
        if (hashMap != null) {
            if (hashMap.size() <= 0) {
                return null;
            }
            int i = -1;
            int i2 = 0;
            for (Map.Entry<Integer, List<T>> entry : hashMap.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null && value.size() > 0 && (t = value.get(0)) != null) {
                    int f = t.f();
                    int i3 = f;
                    if (f <= 0) {
                        e.a aVar2 = this.f26051a.get(entry.getKey());
                        i3 = f;
                        if (aVar2 != null) {
                            i3 = aVar2.g;
                        }
                    }
                    if (i3 <= 0) {
                        com.opos.cmn.an.f.a.b("delegator", "biding with fail result");
                        return null;
                    } else if (i2 > i3) {
                        com.opos.cmn.an.f.a.b("delegator", "biding fail by compare:" + entry.getKey());
                    } else if (i2 != i3) {
                        i = entry.getKey().intValue();
                        i2 = i3;
                    } else if (entry.getKey().intValue() == 1) {
                        i = entry.getKey().intValue();
                    }
                }
            }
            com.opos.cmn.an.f.a.b("delegator", "biding result:" + i);
            aVar = null;
            if (i != -1) {
                a(i, hashMap);
                aVar = this.f26051a.get(Integer.valueOf(i));
            }
        }
        return aVar;
    }

    public <T extends com.opos.mobad.ad.g> void a(int i, HashMap<Integer, List<T>> hashMap) {
        List<T> value;
        for (Map.Entry<Integer, List<T>> entry : hashMap.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && value.size() > 0) {
                if (i == entry.getKey().intValue()) {
                    com.opos.cmn.an.f.a.b("delegator", "notify win " + i);
                    a(value);
                } else {
                    com.opos.cmn.an.f.a.b("delegator", "notify loss " + entry.getKey() + ":1");
                    a(value, 1);
                }
            }
        }
    }
}
