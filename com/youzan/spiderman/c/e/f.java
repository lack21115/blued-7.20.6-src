package com.youzan.spiderman.c.e;

import android.content.Context;
import com.youzan.spiderman.utils.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/c/e/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private Context f41772a;
    private com.youzan.spiderman.c.b.f b;

    /* renamed from: c  reason: collision with root package name */
    private List<c> f41773c = Collections.synchronizedList(new ArrayList());
    private Set<String> d = new HashSet();

    static /* synthetic */ void a(f fVar, c cVar, Set set) {
        fVar.f41773c.remove(cVar);
        int size = set.size();
        synchronized (fVar.d) {
            int size2 = fVar.d.size();
            int i = size + size2;
            if (i > 300) {
                int i2 = i - 300;
                Logger.e("SyncResourceManager", "not download resource list is larger than 300, remove some count:" + i2, new Object[0]);
                try {
                    Iterator<String> it = fVar.d.iterator();
                    while (it.hasNext() && i2 > 0) {
                        it.next();
                        it.remove();
                        i2--;
                    }
                } catch (Exception e) {
                    Logger.e("SyncResourceManager", "remove not downloads exception", e);
                }
            }
            fVar.d.addAll(set);
            Logger.i("SyncResourceManager", "下载队列剩余: " + size2, new Object[0]);
            if (fVar.f41773c.isEmpty()) {
                b bVar = new b();
                bVar.a(fVar.d);
                com.youzan.spiderman.cache.b.a(bVar, "resource_list_pref");
            }
        }
    }

    public final void a(Context context, com.youzan.spiderman.c.b.f fVar) {
        this.f41772a = context.getApplicationContext();
        this.b = fVar;
    }

    public final void a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        a(new HashSet(list));
    }

    public final void a(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        c cVar = new c(set, this.f41772a, this.b, new a() { // from class: com.youzan.spiderman.c.e.f.1
            @Override // com.youzan.spiderman.c.e.a
            public final void a(c cVar2, Set<String> set2) {
                f.a(f.this, cVar2, set2);
            }
        });
        this.f41773c.add(cVar);
        com.youzan.spiderman.a.c.a().a(cVar);
    }
}
