package com.igexin.push.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.igexin.sdk.PushConsts;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/h.class */
public final class h implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23551a = "GALC";
    private AtomicLong b = new AtomicLong(0);

    /* renamed from: c  reason: collision with root package name */
    private int f23552c;

    private void a(Activity activity) {
        try {
            Context applicationContext = activity.getApplicationContext();
            activity.getComponentName().getClassName();
            com.igexin.c.a.c.a.a("GALC|" + activity.getComponentName().getClassName() + " onAStart " + this.f23552c, new Object[0]);
            if (this.f23552c == 0) {
                Thread.currentThread().getName();
                com.igexin.c.a.c.a.a("GALC|>>>>>> FG threadName=" + Thread.currentThread().getName(), new Object[0]);
                if (com.igexin.push.f.j.a(applicationContext) || System.currentTimeMillis() - this.b.get() <= 20000) {
                    return;
                }
                com.igexin.push.core.a.b.d();
                Intent intent = new Intent(applicationContext, com.igexin.push.core.a.b.a(applicationContext));
                intent.putExtra("action", PushConsts.ACTION_SERVICE_ONRESUME);
                ServiceManager.getInstance().b(applicationContext, intent);
                com.igexin.c.a.c.a.a("GALC|on fg, start>>>>>>", new Object[0]);
                this.b.set(System.currentTimeMillis());
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            Context applicationContext = activity.getApplicationContext();
            activity.getComponentName().getClassName();
            com.igexin.c.a.c.a.a("GALC|" + activity.getComponentName().getClassName() + " onAStart " + this.f23552c, new Object[0]);
            if (this.f23552c == 0) {
                Thread.currentThread().getName();
                com.igexin.c.a.c.a.a("GALC|>>>>>> FG threadName=" + Thread.currentThread().getName(), new Object[0]);
                if (!com.igexin.push.f.j.a(applicationContext) && System.currentTimeMillis() - this.b.get() > 20000) {
                    com.igexin.push.core.a.b.d();
                    Intent intent = new Intent(applicationContext, com.igexin.push.core.a.b.a(applicationContext));
                    intent.putExtra("action", PushConsts.ACTION_SERVICE_ONRESUME);
                    ServiceManager.getInstance().b(applicationContext, intent);
                    com.igexin.c.a.c.a.a("GALC|on fg, start>>>>>>", new Object[0]);
                    this.b.set(System.currentTimeMillis());
                }
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        this.f23552c++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        if (activity == null) {
            return;
        }
        int i = this.f23552c - 1;
        this.f23552c = i;
        this.f23552c = Math.max(i, 0);
        com.igexin.c.a.c.a.b(f23551a, "|" + activity.getComponentName().getClassName() + " onAStopp " + this.f23552c);
        if (this.f23552c == 0) {
            com.igexin.c.a.c.a.a("GALC|>>>>>> on bg", new Object[0]);
        }
    }
}
