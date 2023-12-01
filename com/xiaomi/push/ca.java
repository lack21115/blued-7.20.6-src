package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ch;
import java.lang.ref.WeakReference;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ca.class */
public class ca implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private String f27607a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<Context> f191a;

    public ca(String str, WeakReference<Context> weakReference) {
        this.f27607a = str;
        this.f191a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        WeakReference<Context> weakReference = this.f191a;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        if (cn.a(this.f27607a) <= bz.f187a) {
            com.xiaomi.channel.commonutils.logger.b.b("=====> do not need clean db");
            return;
        }
        cd a2 = cd.a(this.f27607a);
        cc a3 = cc.a(this.f27607a);
        a2.a(a3);
        a3.a(cb.a(context, this.f27607a, 1000));
        ch.a(context).a((ch.a) a2);
    }
}
