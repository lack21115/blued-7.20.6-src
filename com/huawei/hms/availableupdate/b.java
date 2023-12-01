package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/availableupdate/b.class */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final b f22607c = new b();
    public static final Object d = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f22608a = new AtomicBoolean(false);
    public List<Activity> b = new ArrayList(1);

    public AtomicBoolean a() {
        return this.f22608a;
    }

    public void a(Activity activity) {
        synchronized (d) {
            for (Activity activity2 : this.b) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.b.add(activity);
        }
    }

    public void a(boolean z) {
        this.f22608a.set(z);
    }

    public void b(Activity activity) {
        synchronized (d) {
            this.b.remove(activity);
        }
    }
}
