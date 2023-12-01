package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/availableupdate/c.class */
public class c {
    public static final c b = new c();

    /* renamed from: c  reason: collision with root package name */
    public static final Object f22609c = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final List<Activity> f22610a = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (f22609c) {
            for (Activity activity2 : this.f22610a) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.f22610a.add(activity);
        }
    }

    public void b(Activity activity) {
        synchronized (f22609c) {
            this.f22610a.remove(activity);
        }
    }
}
