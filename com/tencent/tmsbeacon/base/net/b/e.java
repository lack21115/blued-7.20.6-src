package com.tencent.tmsbeacon.base.net.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/b/e.class */
public final class e extends BroadcastReceiver implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final List<a> f39504a = new ArrayList();
    private static volatile boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f39505c = true;
    private volatile boolean d = false;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/b/e$a.class */
    public interface a {
        void a();

        void b();
    }

    private void a() {
        List<a> list = f39504a;
        synchronized (list) {
            for (a aVar : list) {
                aVar.a();
            }
        }
    }

    public static void a(Context context, a aVar) {
        if (context == null) {
            com.tencent.tmsbeacon.base.util.c.b("[net] context == null!", new Object[0]);
            return;
        }
        List<a> list = f39504a;
        synchronized (list) {
            if (!list.contains(aVar)) {
                list.add(aVar);
            }
        }
        if (b) {
            return;
        }
        context.registerReceiver(new e(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        b = true;
    }

    public static void a(a aVar) {
        List<a> list = f39504a;
        synchronized (list) {
            list.remove(aVar);
        }
    }

    private void b() {
        List<a> list = f39504a;
        synchronized (list) {
            for (a aVar : list) {
                aVar.b();
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f39505c) {
            this.f39505c = false;
        } else if (this.d) {
        } else {
            com.tencent.tmsbeacon.a.b.a.a().a(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.d = true;
        if (d.d()) {
            com.tencent.tmsbeacon.base.util.c.d("[net] current network available!", new Object[0]);
            a();
        } else {
            com.tencent.tmsbeacon.base.util.c.d("[net] current network unavailable!", new Object[0]);
            b();
        }
        this.d = false;
    }
}
