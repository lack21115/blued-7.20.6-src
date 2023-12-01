package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/b/p.class */
public final class p extends com.vivo.push.o {

    /* renamed from: a  reason: collision with root package name */
    private String f41049a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f41050c;
    private long d;
    private InsideNotificationItem e;

    public p() {
        super(5);
    }

    public p(String str, long j, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.f41049a = str;
        this.d = j;
        this.e = insideNotificationItem;
    }

    @Override // com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.f41049a);
        aVar.a("notify_id", this.d);
        aVar.a("notification_v1", com.vivo.push.util.q.b(this.e));
        aVar.a("open_pkg_name", this.b);
        aVar.a("open_pkg_name_encode", this.f41050c);
    }

    public final String d() {
        return this.f41049a;
    }

    @Override // com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        this.f41049a = aVar.a("package_name");
        this.d = aVar.b("notify_id", -1L);
        this.b = aVar.a("open_pkg_name");
        this.f41050c = aVar.b("open_pkg_name_encode");
        String a2 = aVar.a("notification_v1");
        if (!TextUtils.isEmpty(a2)) {
            this.e = com.vivo.push.util.q.a(a2);
        }
        InsideNotificationItem insideNotificationItem = this.e;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(this.d);
        }
    }

    public final long e() {
        return this.d;
    }

    public final InsideNotificationItem f() {
        return this.e;
    }

    @Override // com.vivo.push.o
    public final String toString() {
        return "OnNotificationClickCommand";
    }
}
