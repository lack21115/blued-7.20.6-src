package com.tencent.beacon.base.net.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/b/e.class */
public final class e extends BroadcastReceiver implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final List<a> f21284a = new ArrayList();
    private static volatile boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21285c = true;
    private volatile boolean d = false;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/b/e$a.class */
    public interface a {
        void a();

        void b();
    }

    private void a() {
        synchronized (f21284a) {
            for (a aVar : f21284a) {
                aVar.a();
            }
        }
    }

    public static void a(Context context, a aVar) {
        if (context == null) {
            com.tencent.beacon.base.util.c.b("[net] context == null!", new Object[0]);
            return;
        }
        synchronized (f21284a) {
            if (!f21284a.contains(aVar)) {
                f21284a.add(aVar);
            }
        }
        if (b) {
            return;
        }
        context.registerReceiver(new e(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        b = true;
    }

    private void b() {
        synchronized (f21284a) {
            for (a aVar : f21284a) {
                aVar.b();
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f21285c) {
            this.f21285c = false;
        } else if (this.d) {
        } else {
            com.tencent.beacon.a.b.a.a().a(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.d = true;
        if (d.d()) {
            com.tencent.beacon.base.util.c.d("[net] current network available!", new Object[0]);
            a();
        } else {
            com.tencent.beacon.base.util.c.d("[net] current network unavailable!", new Object[0]);
            b();
        }
        this.d = false;
    }
}
