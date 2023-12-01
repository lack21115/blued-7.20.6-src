package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.al;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ha.class */
final class ha extends al.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f27773a;

    ha(Context context) {
        this.f27773a = context;
    }

    @Override // com.xiaomi.push.al.b
    public final void b() {
        Object obj;
        ArrayList arrayList;
        List list;
        List list2;
        obj = gz.f486a;
        synchronized (obj) {
            list = gz.f488a;
            arrayList = new ArrayList(list);
            list2 = gz.f488a;
            list2.clear();
        }
        gz.b(this.f27773a, arrayList);
    }
}
