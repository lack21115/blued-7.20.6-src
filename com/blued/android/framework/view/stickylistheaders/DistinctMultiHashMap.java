package com.blued.android.framework.view.stickylistheaders;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickylistheaders/DistinctMultiHashMap.class */
class DistinctMultiHashMap<TKey, TItemValue> {

    /* renamed from: a  reason: collision with root package name */
    LinkedHashMap<Object, List<TItemValue>> f10330a;
    LinkedHashMap<Object, TKey> b;

    /* renamed from: c  reason: collision with root package name */
    private IDMapper<TKey, TItemValue> f10331c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickylistheaders/DistinctMultiHashMap$IDMapper.class */
    public interface IDMapper<TKey, TItemValue> {
        Object a(TKey tkey);

        Object b(TItemValue titemvalue);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DistinctMultiHashMap() {
        this(new IDMapper<TKey, TItemValue>() { // from class: com.blued.android.framework.view.stickylistheaders.DistinctMultiHashMap.1
            @Override // com.blued.android.framework.view.stickylistheaders.DistinctMultiHashMap.IDMapper
            public Object a(TKey tkey) {
                return tkey;
            }

            @Override // com.blued.android.framework.view.stickylistheaders.DistinctMultiHashMap.IDMapper
            public Object b(TItemValue titemvalue) {
                return titemvalue;
            }
        });
    }

    DistinctMultiHashMap(IDMapper<TKey, TItemValue> iDMapper) {
        this.f10330a = new LinkedHashMap<>();
        this.b = new LinkedHashMap<>();
        this.f10331c = iDMapper;
    }

    public TKey a(TItemValue titemvalue) {
        return this.b.get(this.f10331c.b(titemvalue));
    }

    public void a(TKey tkey, TItemValue titemvalue) {
        Object a2 = this.f10331c.a(tkey);
        if (this.f10330a.get(a2) == null) {
            this.f10330a.put(a2, new ArrayList());
        }
        TKey a3 = a(titemvalue);
        if (a3 != null) {
            this.f10330a.get(this.f10331c.a(a3)).remove(titemvalue);
        }
        this.b.put(this.f10331c.b(titemvalue), tkey);
        if (a((List<List<TItemValue>>) this.f10330a.get(this.f10331c.a(tkey)), (List<TItemValue>) titemvalue)) {
            return;
        }
        this.f10330a.get(this.f10331c.a(tkey)).add(titemvalue);
    }

    protected boolean a(List<TItemValue> list, TItemValue titemvalue) {
        for (TItemValue titemvalue2 : list) {
            if (this.f10331c.b(titemvalue2).equals(this.f10331c.b(titemvalue))) {
                return true;
            }
        }
        return false;
    }
}
