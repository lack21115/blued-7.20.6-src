package com.alibaba.mtl.appmonitor;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.d.j;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/a.class */
public class a implements Runnable {
    private static boolean j = false;
    private static boolean l = false;
    private Application b;
    private boolean k = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alibaba.mtl.appmonitor.a$a  reason: collision with other inner class name */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/a$a.class */
    public class C0042a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with other field name */
        private Runnable f15a;

        C0042a(Runnable runnable) {
            this.f15a = runnable;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            r.a().f(4);
            r.a().a(4, this.f15a, 60000L);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            r.a().f(4);
            r.a().a(4, this.f15a, 60000L);
        }
    }

    public a(Application application) {
        this.b = application;
    }

    private static boolean a(Context context) {
        String a2 = com.alibaba.mtl.log.e.b.a(context);
        i.a("BackgroundTrigger", "[checkRuningProcess]:", a2);
        return (TextUtils.isEmpty(a2) || a2.indexOf(":") == -1) ? false : true;
    }

    public static void init(Application application) {
        if (j) {
            return;
        }
        i.a("BackgroundTrigger", "init BackgroundTrigger");
        l = a(application.getApplicationContext());
        a aVar = new a(application);
        if (l) {
            r.a().a(4, aVar, 60000L);
        } else if (Build.VERSION.SDK_INT >= 14) {
            aVar.getClass();
            application.registerActivityLifecycleCallbacks(new C0042a(aVar));
        }
        j = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        f[] values;
        i.a("BackgroundTrigger", "[bg check]");
        boolean b = com.alibaba.mtl.log.e.b.b(this.b.getApplicationContext());
        if (this.k != b) {
            this.k = b;
            if (b) {
                j.a().k();
                for (f fVar : f.values()) {
                    AppMonitorDelegate.setStatisticsInterval(fVar, fVar.c());
                }
                com.alibaba.mtl.log.a.m();
            } else {
                f[] values2 = f.values();
                int length = values2.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    f fVar2 = values2[i2];
                    AppMonitorDelegate.setStatisticsInterval(fVar2, fVar2.d());
                    i = i2 + 1;
                }
                AppMonitorDelegate.triggerUpload();
                com.alibaba.mtl.log.a.l();
            }
        }
        if (l) {
            r.a().a(4, this, 60000L);
        }
    }
}
