package com.bytedance.pangle.download;

import android.app.Activity;
import com.bytedance.pangle.Zeus;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/download/a.class */
public class a {
    private static volatile a b;

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f21378a = new CopyOnWriteArrayList();

    public a() {
        Zeus.getAppApplication().registerActivityLifecycleCallbacks(new com.bytedance.pangle.a() { // from class: com.bytedance.pangle.download.a.1
            @Override // com.bytedance.pangle.a, android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityResumed(Activity activity) {
                Iterator it = a.this.f21378a.iterator();
                while (it.hasNext()) {
                    it.next();
                    b.a();
                }
            }
        });
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                try {
                    if (b == null) {
                        b = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }
}
