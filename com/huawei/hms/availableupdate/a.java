package com.huawei.hms.availableupdate;

import android.app.Activity;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/availableupdate/a.class */
public class a {
    public static final a b = new a();

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Activity> f8998a;

    public final Activity a() {
        WeakReference<Activity> weakReference = this.f8998a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public boolean a(Activity activity) {
        HMSLog.i("UpdateAdapterMgr", "onActivityCreate");
        Activity a2 = a();
        if (a2 == null || a2.isFinishing()) {
            this.f8998a = new WeakReference<>(activity);
            return true;
        }
        activity.finish();
        HMSLog.i("UpdateAdapterMgr", "finish one");
        return false;
    }

    public void b(Activity activity) {
        HMSLog.i("UpdateAdapterMgr", "onActivityDestroy");
        Activity a2 = a();
        if (activity == null || !activity.equals(a2)) {
            return;
        }
        HMSLog.i("UpdateAdapterMgr", "reset");
        this.f8998a = null;
    }
}
