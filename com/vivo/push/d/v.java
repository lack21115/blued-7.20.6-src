package com.vivo.push.d;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/d/v.class */
final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f27396a;
    final /* synthetic */ Map b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ u f27397c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, Context context, Map map) {
        this.f27397c = uVar;
        this.f27396a = context;
        this.b = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ComponentName componentName;
        String packageName = this.f27396a.getPackageName();
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) this.f27396a.getSystemService("activity")).getRunningTasks(100);
            if (runningTasks != null) {
                Iterator<ActivityManager.RunningTaskInfo> it = runningTasks.iterator();
                do {
                    if (it.hasNext()) {
                        componentName = it.next().topActivity;
                    }
                } while (!componentName.getPackageName().equals(packageName));
                com.vivo.push.util.p.d("OnNotificationClickTask", "topClassName=" + componentName.getClassName());
                Intent intent = new Intent();
                intent.setComponent(componentName);
                intent.setFlags(335544320);
                u.b(intent, this.b);
                this.f27396a.startActivity(intent);
                return;
            }
        } catch (Exception e) {
            com.vivo.push.util.p.a("OnNotificationClickTask", "start recentIntent is error", e);
        }
        Intent launchIntentForPackage = this.f27396a.getPackageManager().getLaunchIntentForPackage(this.f27396a.getPackageName());
        if (launchIntentForPackage == null) {
            com.vivo.push.util.p.a("OnNotificationClickTask", "LaunchIntent is null");
            return;
        }
        launchIntentForPackage.setFlags(268435456);
        u.b(launchIntentForPackage, this.b);
        this.f27396a.startActivity(launchIntentForPackage);
    }
}
