package com.ut.mini.sdkevents;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.alibaba.mtl.log.b;
import com.alibaba.mtl.log.c;
import com.alibaba.mtl.log.e.i;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTInterfaceCallDelegate;
import com.ut.mini.UTTracker;
import com.ut.mini.core.appstatus.UTMCAppStatusCallbacks;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.ut.mini.plugin.UTPlugin;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/ut/mini/sdkevents/UTMI1010_2001Event.class */
public class UTMI1010_2001Event extends UTPlugin implements UTMCAppStatusCallbacks {
    private long C = 0;
    private long D = 0;
    private long E = 0;

    private void a(long j) {
        if (c.a().f()) {
            return;
        }
        long j2 = 0;
        if (j > 0) {
            if (0 != this.E) {
                j2 = SystemClock.elapsedRealtime() - this.E;
            }
            UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder("UT", 1010, "" + j, "" + j2, null, null);
            UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
            if (defaultTracker != null) {
                defaultTracker.send(uTOriginalCustomHitBuilder.build());
            } else {
                i.a("Record app display event error", "Fatal Error,must call setRequestAuthentication method first.");
            }
        }
    }

    private static boolean p() {
        String packageName;
        ActivityManager activityManager;
        ComponentName componentName;
        try {
            Context context = b.a().getContext();
            if (context == null || (packageName = context.getPackageName()) == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null) {
                return true;
            }
            try {
                List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
                if (runningTasks == null || runningTasks.size() <= 0 || (componentName = runningTasks.get(0).topActivity) == null) {
                    return true;
                }
                return !packageName.contains(componentName.getPackageName());
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityPaused(Activity activity) {
        UTInterfaceCallDelegate.pageDisAppearByAuto(activity);
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityResumed(Activity activity) {
        UTInterfaceCallDelegate.pageAppearByAuto(activity);
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityStopped(Activity activity) {
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    @Override // com.ut.mini.plugin.UTPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onPluginMsgArrivedFromSDK(int r7, java.lang.Object r8) {
        /*
            r6 = this;
            r0 = r7
            r1 = 3
            if (r0 != r1) goto L7b
            r0 = r8
            java.util.Map r0 = (java.util.Map) r0
            r8 = r0
            r0 = r8
            com.alibaba.mtl.log.model.LogField r1 = com.alibaba.mtl.log.model.LogField.EVENTID
            java.lang.String r1 = r1.toString()
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L7b
            java.lang.String r0 = "2001"
            r1 = r8
            com.alibaba.mtl.log.model.LogField r2 = com.alibaba.mtl.log.model.LogField.EVENTID
            java.lang.String r2 = r2.toString()
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7b
            r0 = r8
            com.alibaba.mtl.log.model.LogField r1 = com.alibaba.mtl.log.model.LogField.ARG3
            java.lang.String r1 = r1.toString()
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L5c
            r0 = r8
            com.alibaba.mtl.log.model.LogField r1 = com.alibaba.mtl.log.model.LogField.ARG3
            java.lang.String r1 = r1.toString()
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            r8 = r0
            r0 = r8
            long r0 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Exception -> L57
            r9 = r0
            goto L5e
        L57:
            r8 = move-exception
            r0 = r8
            r0.printStackTrace()
        L5c:
            r0 = 0
            r9 = r0
        L5e:
            r0 = r6
            r1 = r6
            long r1 = r1.C
            r2 = r9
            long r1 = r1 + r2
            r0.C = r1
            boolean r0 = p()
            if (r0 == 0) goto L7b
            r0 = r6
            r1 = r6
            long r1 = r1.C
            r0.a(r1)
            r0 = r6
            r1 = 0
            r0.C = r1
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.sdkevents.UTMI1010_2001Event.onPluginMsgArrivedFromSDK(int, java.lang.Object):void");
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onSwitchBackground() {
        a(SystemClock.elapsedRealtime() - this.D);
        this.E = SystemClock.elapsedRealtime();
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onSwitchForeground() {
        this.D = SystemClock.elapsedRealtime();
    }

    @Override // com.ut.mini.plugin.UTPlugin
    public int[] returnRequiredMsgIds() {
        return new int[]{3};
    }
}
