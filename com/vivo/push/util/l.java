package com.vivo.push.util;

import android.content.Context;
import com.vivo.push.d.r;
import com.vivo.push.model.InsideNotificationItem;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/util/l.class */
final class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f41140a;
    final /* synthetic */ k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, List list) {
        this.b = kVar;
        this.f41140a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InsideNotificationItem insideNotificationItem;
        long j;
        Context context;
        InsideNotificationItem insideNotificationItem2;
        long j2;
        int i;
        r.a aVar;
        insideNotificationItem = this.b.b;
        if (insideNotificationItem != null) {
            w b = w.b();
            j = this.b.f41139c;
            b.a("com.vivo.push.notify_key", j);
            context = this.b.f41138a;
            List list = this.f41140a;
            insideNotificationItem2 = this.b.b;
            j2 = this.b.f41139c;
            i = this.b.e;
            aVar = this.b.f;
            NotifyAdapterUtil.pushNotification(context, list, insideNotificationItem2, j2, i, aVar);
        }
    }
}
