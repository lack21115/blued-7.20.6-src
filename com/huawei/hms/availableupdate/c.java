package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/availableupdate/c.class */
public class c {
    public static final c b = new c();

    /* renamed from: c  reason: collision with root package name */
    public static final Object f9001c = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final List<Activity> f9002a = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (f9001c) {
            for (Activity activity2 : this.f9002a) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.f9002a.add(activity);
        }
    }

    public void b(Activity activity) {
        synchronized (f9001c) {
            this.f9002a.remove(activity);
        }
    }
}
