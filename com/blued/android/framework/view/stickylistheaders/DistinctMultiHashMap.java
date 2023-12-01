package com.blued.android.framework.view.stickylistheaders;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickylistheaders/DistinctMultiHashMap.class */
class DistinctMultiHashMap<TKey, TItemValue> {
    LinkedHashMap<Object, List<TItemValue>> a;
    LinkedHashMap<Object, TKey> b;
    private IDMapper<TKey, TItemValue> c;

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
        this.a = new LinkedHashMap<>();
        this.b = new LinkedHashMap<>();
        this.c = iDMapper;
    }

    public TKey a(TItemValue titemvalue) {
        return this.b.get(this.c.b(titemvalue));
    }

    public void a(TKey tkey, TItemValue titemvalue) {
        Object a = this.c.a(tkey);
        if (this.a.get(a) == null) {
            this.a.put(a, new ArrayList());
        }
        TKey a2 = a(titemvalue);
        if (a2 != null) {
            this.a.get(this.c.a(a2)).remove(titemvalue);
        }
        this.b.put(this.c.b(titemvalue), tkey);
        if (a((List<List<TItemValue>>) this.a.get(this.c.a(tkey)), (List<TItemValue>) titemvalue)) {
            return;
        }
        this.a.get(this.c.a(tkey)).add(titemvalue);
    }

    protected boolean a(List<TItemValue> list, TItemValue titemvalue) {
        for (TItemValue titemvalue2 : list) {
            if (this.c.b(titemvalue2).equals(this.c.b(titemvalue))) {
                return true;
            }
        }
        return false;
    }
}
