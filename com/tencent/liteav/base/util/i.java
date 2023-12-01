package com.tencent.liteav.base.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.tencent.liteav.base.Log;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/i.class */
public final class i implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f36331a;
    private final Set<Integer> b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    private final Set<Integer> f36332c = new HashSet();

    public i(Context context) {
        if (context == null) {
            Log.e("ProcessLifecycleOwner", "ProcessStateOwner init failed. Context is null", new Object[0]);
            return;
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this);
        this.f36331a = a(context);
    }

    private void a(int i) {
        this.b.add(Integer.valueOf(i));
        this.f36331a = false;
    }

    private static boolean a(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                Log.e("ProcessLifecycleOwner", "activityManager is null.", new Object[0]);
                return false;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                Log.e("ProcessLifecycleOwner", "processInfoList is null.", new Object[0]);
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && context.getPackageName().equals(runningAppProcessInfo.processName)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            Log.e("ProcessLifecycleOwner", "Get App background state failed. ".concat(String.valueOf(e)), new Object[0]);
            return false;
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
        this.f36332c.add(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(activity.hashCode());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity.hashCode());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        int hashCode = activity.hashCode();
        boolean z = true;
        if (this.b.contains(Integer.valueOf(hashCode))) {
            this.b.remove(Integer.valueOf(hashCode));
            if (this.b.size() != 0) {
                z = false;
            }
            this.f36331a = z;
        } else if (this.b.size() != 0) {
            this.f36331a = false;
        } else if (this.f36332c.contains(Integer.valueOf(hashCode))) {
            this.f36331a = true;
        }
        this.f36332c.remove(Integer.valueOf(hashCode));
    }
}
