package com.soft.blued.bluedBus;

import android.os.Looper;
import com.soft.blued.bluedBus.MainThreadSupport;
import com.soft.blued.utils.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/bluedBus/BluedBus.class */
public class BluedBus {

    /* renamed from: a  reason: collision with root package name */
    private Map<Class, List<SubscriberMethod>> f14607a = new HashMap();
    private Map<String, CopyOnWriteArrayList<Subscription>> b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Map<Class, List<String>> f14608c = new HashMap();
    private final MainThreadSupport d;
    private final Poster e;

    private BluedBus() {
        MainThreadSupport a2 = a();
        this.d = a2;
        this.e = a2 != null ? a2.a(this) : null;
    }

    MainThreadSupport a() {
        MainThreadSupport mainThreadSupport = this.d;
        if (mainThreadSupport != null) {
            return mainThreadSupport;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null) {
            return null;
        }
        return new MainThreadSupport.AndroidHandlerMainThreadSupport(mainLooper);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PendingPost pendingPost) {
        Object[] objArr = pendingPost.f14612a;
        Subscription subscription = pendingPost.b;
        PendingPost.a(pendingPost);
        a(subscription, objArr);
    }

    void a(Subscription subscription, Object[] objArr) {
        try {
            subscription.b.f14615a.invoke(subscription.f14616a, objArr);
        } catch (Exception e) {
            Logger.a("drb", "Exception = ", e);
        }
    }
}
