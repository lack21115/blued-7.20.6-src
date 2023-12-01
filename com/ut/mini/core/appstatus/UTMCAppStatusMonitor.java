package com.ut.mini.core.appstatus;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.alibaba.mtl.log.e.r;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

/* loaded from: source-8829756-dex2jar.jar:com/ut/mini/core/appstatus/UTMCAppStatusMonitor.class */
public class UTMCAppStatusMonitor implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private static UTMCAppStatusMonitor f41023a;
    private int J = 0;
    private boolean P = false;

    /* renamed from: a  reason: collision with other field name */
    private ScheduledFuture<?> f79a = null;
    private Object d = new Object();
    private List<UTMCAppStatusCallbacks> m = new LinkedList();
    private Object e = new Object();

    /* loaded from: source-8829756-dex2jar.jar:com/ut/mini/core/appstatus/UTMCAppStatusMonitor$a.class */
    class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UTMCAppStatusMonitor.this.P = false;
            synchronized (UTMCAppStatusMonitor.this.e) {
                for (UTMCAppStatusCallbacks uTMCAppStatusCallbacks : UTMCAppStatusMonitor.this.m) {
                    uTMCAppStatusCallbacks.onSwitchBackground();
                }
            }
        }
    }

    private UTMCAppStatusMonitor() {
    }

    private void N() {
        synchronized (this.d) {
            r.a().f(11);
        }
    }

    public static UTMCAppStatusMonitor getInstance() {
        UTMCAppStatusMonitor uTMCAppStatusMonitor;
        synchronized (UTMCAppStatusMonitor.class) {
            try {
                if (f41023a == null) {
                    f41023a = new UTMCAppStatusMonitor();
                }
                uTMCAppStatusMonitor = f41023a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return uTMCAppStatusMonitor;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.e) {
            for (UTMCAppStatusCallbacks uTMCAppStatusCallbacks : this.m) {
                uTMCAppStatusCallbacks.onActivityCreated(activity, bundle);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        synchronized (this.e) {
            for (UTMCAppStatusCallbacks uTMCAppStatusCallbacks : this.m) {
                uTMCAppStatusCallbacks.onActivityDestroyed(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        synchronized (this.e) {
            for (UTMCAppStatusCallbacks uTMCAppStatusCallbacks : this.m) {
                uTMCAppStatusCallbacks.onActivityPaused(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        synchronized (this.e) {
            for (UTMCAppStatusCallbacks uTMCAppStatusCallbacks : this.m) {
                uTMCAppStatusCallbacks.onActivityResumed(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.e) {
            for (UTMCAppStatusCallbacks uTMCAppStatusCallbacks : this.m) {
                uTMCAppStatusCallbacks.onActivitySaveInstanceState(activity, bundle);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        N();
        this.J++;
        if (!this.P) {
            synchronized (this.e) {
                for (UTMCAppStatusCallbacks uTMCAppStatusCallbacks : this.m) {
                    uTMCAppStatusCallbacks.onSwitchForeground();
                }
            }
        }
        this.P = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i = this.J - 1;
        this.J = i;
        if (i == 0) {
            N();
            r.a().a(11, new a(), 1000L);
        }
    }

    public void registerAppStatusCallbacks(UTMCAppStatusCallbacks uTMCAppStatusCallbacks) {
        if (uTMCAppStatusCallbacks != null) {
            synchronized (this.e) {
                this.m.add(uTMCAppStatusCallbacks);
            }
        }
    }

    public void unregisterAppStatusCallbacks(UTMCAppStatusCallbacks uTMCAppStatusCallbacks) {
        if (uTMCAppStatusCallbacks != null) {
            synchronized (this.e) {
                this.m.remove(uTMCAppStatusCallbacks);
            }
        }
    }
}
