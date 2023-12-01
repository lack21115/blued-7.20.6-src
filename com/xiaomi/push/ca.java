package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ch;
import java.lang.ref.WeakReference;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ca.class */
public class ca implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private String f41298a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<Context> f238a;

    public ca(String str, WeakReference<Context> weakReference) {
        this.f41298a = str;
        this.f238a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        WeakReference<Context> weakReference = this.f238a;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        if (cn.a(this.f41298a) <= bz.f234a) {
            com.xiaomi.channel.commonutils.logger.b.b("=====> do not need clean db");
            return;
        }
        cd a2 = cd.a(this.f41298a);
        cc a3 = cc.a(this.f41298a);
        a2.a(a3);
        a3.a(cb.a(context, this.f41298a, 1000));
        ch.a(context).a((ch.a) a2);
    }
}
