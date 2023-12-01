package com.blued.android.module.ui.mvp.presenter;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoaderHostManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MemoryDataCache;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.android.module.ui.mvp.base.IntMvpView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/ui/mvp/presenter/MvpPresenter.class */
public abstract class MvpPresenter {
    private final String a = Intrinsics.a("_MVP_", (Object) getClass().getSimpleName());
    private final int b = 300000;
    private String c;
    private long d;
    private FragmentActivity e;
    private Set<IntMvpView> f;
    private Set<IntMvpView> g;
    private MemoryDataCache<?> h;
    private IRequestHost i;
    private boolean j;
    private Lifecycle k;

    public MvpPresenter() {
        Class<? super Object> superclass = getClass().getSuperclass();
        String simpleName = superclass == null ? null : superclass.getSimpleName();
        this.c = simpleName == null ? this.a : simpleName;
        this.f = new HashSet();
        this.g = new HashSet();
        this.h = new MemoryDataCache<>();
        this.j = true;
        this.i = new IRequestHost() { // from class: com.blued.android.module.ui.mvp.presenter.-$$Lambda$MvpPresenter$xO2xvWFlLHMv2bKvlC5n2yDoIT0
            @Override // com.blued.android.core.net.IRequestHost
            public final boolean isActive() {
                boolean b;
                b = MvpPresenter.b(MvpPresenter.this);
                return b;
            }
        };
    }

    private final void a() {
        for (IntMvpView intMvpView : this.f) {
            if (intMvpView.c()) {
                intMvpView.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MvpPresenter this$0, String taskName, Runnable task) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(taskName, "$taskName");
        Intrinsics.e(task, "$task");
        if (this$0.s()) {
            task.run();
        } else {
            this$0.d(Intrinsics.a("_mvpView is not ready, task can't deal, taskName:", (Object) taskName));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Runnable task) {
        Intrinsics.e(task, "$task");
        task.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, boolean z) {
        for (IntMvpView intMvpView : this.f) {
            if (intMvpView.c()) {
                intMvpView.a(str, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(boolean z) {
        this.j = z;
        if (z) {
            a();
        } else {
            b();
        }
    }

    private final void b() {
        for (IntMvpView intMvpView : this.f) {
            if (intMvpView.c()) {
                intMvpView.f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(MvpPresenter this$0) {
        Intrinsics.e(this$0, "this$0");
        return this$0.s();
    }

    private final boolean b(String str) {
        List<Object> a = this.h.a(str);
        return a != null && a.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String str) {
        for (IntMvpView intMvpView : this.f) {
            if (intMvpView.c()) {
                intMvpView.a(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String str, List<?> list) {
        for (IntMvpView intMvpView : this.f) {
            if (intMvpView.c()) {
                d(Intrinsics.a("showDataToUI(), type:", (Object) str));
                intMvpView.a(str, list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(String str) {
        String str2 = this.a;
        Log.v(str2, this.c + "--" + str);
    }

    private final IntMvpView u() {
        for (IntMvpView intMvpView : this.f) {
            if (intMvpView.c()) {
                return intMvpView;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IntMvpView v() {
        for (IntMvpView intMvpView : this.f) {
            if (intMvpView.c() && !Intrinsics.a(intMvpView.g(), this.e)) {
                return intMvpView;
            }
        }
        return null;
    }

    public List<?> a(String str, List<?> list) {
        List<?> a = this.h.a(str, list);
        Intrinsics.c(a, "_memoryDataCache.saveData(type, data)");
        return a;
    }

    public void a(Bundle outState) {
        Intrinsics.e(outState, "outState");
    }

    public final void a(FragmentActivity fragmentActivity) {
        this.e = fragmentActivity;
    }

    public void a(FragmentActivity hostActivity, Bundle bundle, Bundle bundle2) {
        Intrinsics.e(hostActivity, "hostActivity");
    }

    public final void a(FragmentActivity hostActivity, Lifecycle lifecycle) {
        Intrinsics.e(hostActivity, "hostActivity");
        if (this.e != hostActivity) {
            IRequestHost iRequestHost = this.i;
            if (iRequestHost != null) {
                ImageLoaderHostManager.a(iRequestHost, hostActivity);
            }
            this.e = hostActivity;
            Lifecycle lifecycle2 = lifecycle;
            if (lifecycle == null) {
                lifecycle2 = hostActivity == null ? null : hostActivity.getLifecycle();
            }
            this.k = lifecycle2;
            if (lifecycle2 == null) {
                return;
            }
            lifecycle2.addObserver(new LifecycleObserver() { // from class: com.blued.android.module.ui.mvp.presenter.MvpPresenter$setHostActivity$1
                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                public final void onDestroy() {
                    IntMvpView v;
                    if (MvpPresenter.this.f() != null) {
                        ImageLoaderHostManager.b(MvpPresenter.this.f());
                    }
                    Lifecycle g = MvpPresenter.this.g();
                    if (g != null) {
                        g.removeObserver(this);
                    }
                    if (!MvpPresenter.this.s()) {
                        if (MvpPresenter.this.d() != null) {
                            Lifecycle g2 = MvpPresenter.this.g();
                            if ((g2 == null ? null : g2.getCurrentState()) == Lifecycle.State.DESTROYED) {
                                MvpPresenter.this.a((FragmentActivity) null);
                                MvpPresenter.this.a((Lifecycle) null);
                                MvpPresenter.this.d("_hostActivity onDestroy, remove it.");
                            }
                        }
                    } else if (MvpPresenter.this.d() != null) {
                        Lifecycle g3 = MvpPresenter.this.g();
                        if ((g3 == null ? null : g3.getCurrentState()) == Lifecycle.State.DESTROYED) {
                            v = MvpPresenter.this.v();
                            if (v == null) {
                                MvpPresenter.this.a((FragmentActivity) null);
                                MvpPresenter.this.a((Lifecycle) null);
                                MvpPresenter.this.d("_hostActivity onDestroy, remove it.");
                                return;
                            }
                            MvpPresenter.this.a(v.g());
                            MvpPresenter mvpPresenter = MvpPresenter.this;
                            FragmentActivity d = mvpPresenter.d();
                            mvpPresenter.a(d == null ? null : d.getLifecycle());
                            MvpPresenter.this.d("_hostActivity onDestroy, change it.");
                        }
                    }
                }
            });
        }
    }

    public final void a(FragmentActivity hostActivity, Lifecycle lifecycle, IntMvpView mvpView) {
        Intrinsics.e(hostActivity, "hostActivity");
        Intrinsics.e(mvpView, "mvpView");
        this.f.add(mvpView);
        synchronized (this.g) {
            e().add(mvpView);
        }
        a(hostActivity, lifecycle);
    }

    public final void a(Lifecycle lifecycle) {
        this.k = lifecycle;
    }

    public void a(LifecycleOwner lifecycleOwner) {
        Intrinsics.e(lifecycleOwner, "lifecycleOwner");
    }

    protected abstract void a(IFetchDataListener iFetchDataListener);

    public final void a(IntMvpView mvpView) {
        Intrinsics.e(mvpView, "mvpView");
        this.f.remove(mvpView);
        synchronized (this.g) {
            e().remove(mvpView);
        }
    }

    public void a(String id) {
        Intrinsics.e(id, "id");
        this.c = id;
    }

    public void a(String taskName, final Runnable task) {
        Intrinsics.e(taskName, "taskName");
        Intrinsics.e(task, "task");
        d(Intrinsics.a("runDataTask, taskName:", (Object) taskName));
        if (MvpUtils.a()) {
            task.run();
        } else {
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.ui.mvp.presenter.-$$Lambda$MvpPresenter$0qBMibk1rfF99b3uwAMCV2p319M
                @Override // java.lang.Runnable
                public final void run() {
                    MvpPresenter.a(Runnable.this);
                }
            });
        }
    }

    public List<?> b(String str, List<?> list) {
        List<?> b = this.h.b(str, list);
        Intrinsics.c(b, "_memoryDataCache.addData(type, data)");
        return b;
    }

    public void b(final String taskName, final Runnable task) {
        Intrinsics.e(taskName, "taskName");
        Intrinsics.e(task, "task");
        Log.v(this.a, Intrinsics.a("runUIViewTask, taskName:", (Object) taskName));
        if (!MvpUtils.a()) {
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.ui.mvp.presenter.-$$Lambda$MvpPresenter$VeCcqDsA9xLOjaA6mudcyE2JdQY
                @Override // java.lang.Runnable
                public final void run() {
                    MvpPresenter.a(MvpPresenter.this, taskName, task);
                }
            });
        } else if (s()) {
            task.run();
        } else {
            d(Intrinsics.a("_mvpView is not ready, task can't deal, taskName:", (Object) taskName));
        }
    }

    public final String c() {
        return this.c;
    }

    public final FragmentActivity d() {
        return this.e;
    }

    public final Set<IntMvpView> e() {
        return this.g;
    }

    public final IRequestHost f() {
        return this.i;
    }

    public final Lifecycle g() {
        return this.k;
    }

    public final String h() {
        return this.c;
    }

    public List<Pair<String, List<?>>> i() {
        return this.h.a();
    }

    public boolean j() {
        int i = 0;
        boolean z = this.d <= 0 || this.h.b();
        if (!z) {
            String[] q = q();
            if (q == null) {
                return z;
            }
            int length = q.length;
            while (i < length) {
                String str = q[i];
                i++;
                if (!b(str)) {
                    return true;
                }
            }
        }
        return z;
    }

    public boolean k() {
        d("isNeedRefresh, _cacheTime:" + this.d + ", interval:" + (SystemClock.uptimeMillis() - this.d));
        if (!j()) {
            return o() && SystemClock.uptimeMillis() - this.d >= ((long) this.b);
        }
        d("_refreshTime or _memoryDataCache need to refresh");
        return true;
    }

    public void l() {
        d("refreshDataIfNeed");
        if (k()) {
            d("need refresh, refresh new data");
            IntMvpView u = u();
            if (u == null) {
                return;
            }
            u.d();
        }
    }

    public final void m() {
        d("refreshData");
        if (j()) {
            d("presenter has no cache data, so fetch cache first");
            p();
        }
        this.d = SystemClock.uptimeMillis();
        a(new MvpPresenter$refreshData$1(this));
    }

    public final IRequestHost n() {
        return this.i;
    }

    protected boolean o() {
        return false;
    }

    protected void p() {
    }

    protected String[] q() {
        return null;
    }

    public final void r() {
        if (this.j) {
            a();
        } else {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean s() {
        synchronized (this.g) {
            Iterator<IntMvpView> it = e().iterator();
            do {
                if (!it.hasNext()) {
                    Unit unit = Unit.a;
                    return false;
                }
            } while (!it.next().c());
            return true;
        }
    }

    public final void t() {
        if (s()) {
            return;
        }
        this.h.c();
    }
}
