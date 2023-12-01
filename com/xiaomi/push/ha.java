package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.al;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ha.class */
final class ha extends al.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f41464a;

    ha(Context context) {
        this.f41464a = context;
    }

    @Override // com.xiaomi.push.al.b
    public final void b() {
        Object obj;
        ArrayList arrayList;
        List list;
        List list2;
        obj = gz.f533a;
        synchronized (obj) {
            list = gz.f535a;
            arrayList = new ArrayList(list);
            list2 = gz.f535a;
            list2.clear();
        }
        gz.b(this.f41464a, arrayList);
    }
}
