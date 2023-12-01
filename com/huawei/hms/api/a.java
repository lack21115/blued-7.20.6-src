package com.huawei.hms.api;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/api/a.class */
class a {
    static final a b = new a();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f8994c = new Object();

    /* renamed from: a  reason: collision with root package name */
    List<Activity> f8995a = new ArrayList(1);

    a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Activity activity) {
        synchronized (f8994c) {
            for (Activity activity2 : this.f8995a) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.f8995a.add(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Activity activity) {
        synchronized (f8994c) {
            this.f8995a.remove(activity);
        }
    }
}
