package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/b/q.class */
public final class q extends v {

    /* renamed from: a  reason: collision with root package name */
    protected InsideNotificationItem f41051a;
    private String b;

    public q() {
        super(4);
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        String b = com.vivo.push.util.q.b(this.f41051a);
        this.b = b;
        aVar.a("notification_v1", b);
    }

    public final InsideNotificationItem d() {
        return this.f41051a;
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        String a2 = aVar.a("notification_v1");
        this.b = a2;
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        InsideNotificationItem a3 = com.vivo.push.util.q.a(this.b);
        this.f41051a = a3;
        if (a3 != null) {
            a3.setMsgId(f());
        }
    }

    public final String e() {
        if (TextUtils.isEmpty(this.b)) {
            InsideNotificationItem insideNotificationItem = this.f41051a;
            if (insideNotificationItem == null) {
                return null;
            }
            return com.vivo.push.util.q.b(insideNotificationItem);
        }
        return this.b;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final String toString() {
        return "OnNotifyArrivedCommand";
    }
}
