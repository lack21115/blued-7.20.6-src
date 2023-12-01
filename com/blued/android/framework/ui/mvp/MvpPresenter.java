package com.blued.android.framework.ui.mvp;

import android.app.Activity;
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
import com.blued.android.framework.ui.mvp.MvpPresenter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/mvp/MvpPresenter.class */
public abstract class MvpPresenter {
    String a;
    FragmentActivity c;
    private final String h = "_MVP_" + getClass().getSimpleName();
    long b = 0;
    Set<MvpView> d = new HashSet();
    Set<MvpView> e = new HashSet();
    MemoryDataCache f = new MemoryDataCache();
    IRequestHost g = new IRequestHost() { // from class: com.blued.android.framework.ui.mvp.-$$Lambda$MvpPresenter$cr2dndZqSvaIULd2IKLibFwSADU
        @Override // com.blued.android.core.net.IRequestHost
        public final boolean isActive() {
            boolean q;
            q = MvpPresenter.this.q();
            return q;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.framework.ui.mvp.MvpPresenter$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/mvp/MvpPresenter$1.class */
    public class AnonymousClass1 implements IFetchDataListener {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            MvpPresenter.this.g("_load_type_refresh_");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(final String str, List list) {
            final List a = MvpPresenter.this.a(str, list);
            MvpPresenter.this.b("refresh_datafetch", new Runnable() { // from class: com.blued.android.framework.ui.mvp.-$$Lambda$MvpPresenter$1$pcqilMtwlZHwhbyqshaUxYOUPic
                @Override // java.lang.Runnable
                public final void run() {
                    MvpPresenter.AnonymousClass1.this.c(str, a);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(String str, List list) {
            MvpPresenter.this.d(str, list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(boolean z) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Boolean.valueOf(z));
            MvpPresenter.this.a("_internal_data_type_has_more_data_", (List) arrayList);
            MvpPresenter.this.a(z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(boolean z) {
            MvpPresenter.this.d("_load_type_refresh_", z);
        }

        @Override // com.blued.android.framework.ui.mvp.IFetchDataListener
        public void a() {
            MvpPresenter.this.b("refresh_start", new Runnable() { // from class: com.blued.android.framework.ui.mvp.-$$Lambda$MvpPresenter$1$KbouD_8wQDlyouydI163j3Du6lg
                @Override // java.lang.Runnable
                public final void run() {
                    MvpPresenter.AnonymousClass1.this.b();
                }
            });
        }

        @Override // com.blued.android.framework.ui.mvp.IFetchDataListener
        public void a(final String str, final List list) {
            MvpPresenter.this.a("refresh_datafetch", new Runnable() { // from class: com.blued.android.framework.ui.mvp.-$$Lambda$MvpPresenter$1$CzxHZDAv_1h6FE_8QPYZtYJJj74
                @Override // java.lang.Runnable
                public final void run() {
                    MvpPresenter.AnonymousClass1.this.b(str, list);
                }
            });
        }

        @Override // com.blued.android.framework.ui.mvp.IFetchDataListener
        public void a(final boolean z) {
            MvpPresenter.this.b("refresh_end", new Runnable() { // from class: com.blued.android.framework.ui.mvp.-$$Lambda$MvpPresenter$1$aHrOAbrqW7TUKYIyvRI4EBj-5x8
                @Override // java.lang.Runnable
                public final void run() {
                    MvpPresenter.AnonymousClass1.this.d(z);
                }
            });
        }

        @Override // com.blued.android.framework.ui.mvp.IFetchDataListener
        public void b(final boolean z) {
            MvpPresenter mvpPresenter = MvpPresenter.this;
            mvpPresenter.b("refresh_onMoreData, hasMoreData:" + z, new Runnable() { // from class: com.blued.android.framework.ui.mvp.-$$Lambda$MvpPresenter$1$a-JklyQlWTFPI3SVlKZp4V5sXhY
                @Override // java.lang.Runnable
                public final void run() {
                    MvpPresenter.AnonymousClass1.this.c(z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.framework.ui.mvp.MvpPresenter$2  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/mvp/MvpPresenter$2.class */
    public class AnonymousClass2 implements IFetchDataListener {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            MvpPresenter.this.g("_load_type_loadmore_");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(final String str, List list) {
            final List b = MvpPresenter.this.b(str, list);
            MvpPresenter.this.b("fetchmore_datafetch", new Runnable() { // from class: com.blued.android.framework.ui.mvp.-$$Lambda$MvpPresenter$2$bdfcZ3nBOgKl8y5zsNt7vhpoqMY
                @Override // java.lang.Runnable
                public final void run() {
                    MvpPresenter.AnonymousClass2.this.c(str, b);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(String str, List list) {
            MvpPresenter.this.d(str, list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(boolean z) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Boolean.valueOf(z));
            MvpPresenter.this.a("_internal_data_type_has_more_data_", (List) arrayList);
            MvpPresenter.this.a(z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(boolean z) {
            MvpPresenter.this.d("_load_type_loadmore_", z);
        }

        @Override // com.blued.android.framework.ui.mvp.IFetchDataListener
        public void a() {
            MvpPresenter.this.b("fetchmore_start", new Runnable() { // from class: com.blued.android.framework.ui.mvp.-$$Lambda$MvpPresenter$2$a3C2CyV1r3omXJbVq7hIV_xh1nA
                @Override // java.lang.Runnable
                public final void run() {
                    MvpPresenter.AnonymousClass2.this.b();
                }
            });
        }

        @Override // com.blued.android.framework.ui.mvp.IFetchDataListener
        public void a(final String str, final List list) {
            MvpPresenter.this.a("fetchmore_datafetch", new Runnable() { // from class: com.blued.android.framework.ui.mvp.-$$Lambda$MvpPresenter$2$QnRtpGZQ8D2vE1TFEIgkAb9C3yc
                @Override // java.lang.Runnable
                public final void run() {
                    MvpPresenter.AnonymousClass2.this.b(str, list);
                }
            });
        }

        @Override // com.blued.android.framework.ui.mvp.IFetchDataListener
        public void a(final boolean z) {
            MvpPresenter.this.b("fetchmore_end", new Runnable() { // from class: com.blued.android.framework.ui.mvp.-$$Lambda$MvpPresenter$2$6pOhI39YCsWSM9WPRKLCdkIAzsU
                @Override // java.lang.Runnable
                public final void run() {
                    MvpPresenter.AnonymousClass2.this.d(z);
                }
            });
        }

        @Override // com.blued.android.framework.ui.mvp.IFetchDataListener
        public void b(final boolean z) {
            MvpPresenter mvpPresenter = MvpPresenter.this;
            mvpPresenter.b("fetchmore_onMoreData, hasMoreData:" + z, new Runnable() { // from class: com.blued.android.framework.ui.mvp.-$$Lambda$MvpPresenter$2$3CMyS84s7QuhVjFPVO2lBsG-Txc
                @Override // java.lang.Runnable
                public final void run() {
                    MvpPresenter.AnonymousClass2.this.c(z);
                }
            });
        }
    }

    private void a(FragmentActivity fragmentActivity) {
        if (this.c != fragmentActivity) {
            IRequestHost iRequestHost = this.g;
            if (iRequestHost != null) {
                ImageLoaderHostManager.a(iRequestHost, fragmentActivity);
            }
            this.c = fragmentActivity;
            fragmentActivity.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.blued.android.framework.ui.mvp.MvpPresenter.3
                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                public void onDestroy() {
                    if (MvpPresenter.this.g != null) {
                        ImageLoaderHostManager.b(MvpPresenter.this.g);
                    }
                    if (MvpPresenter.this.c == null || MvpPresenter.this.c.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
                        return;
                    }
                    MvpPresenter.this.c.getLifecycle().removeObserver(this);
                    MvpPresenter.this.c = null;
                    MvpPresenter.this.f("_hostActivity onDestroy, remove it.");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            m();
        } else {
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, final String str, final List list) {
        if (z) {
            a(str, list);
        }
        b("setDataToUI_" + str, new Runnable() { // from class: com.blued.android.framework.ui.mvp.-$$Lambda$MvpPresenter$_rdwC7_h4pySDxTClIlblRaDb4E
            @Override // java.lang.Runnable
            public final void run() {
                MvpPresenter.this.d(str, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str, Runnable runnable) {
        if (o()) {
            runnable.run();
            return;
        }
        f("_mvpView is not ready, task can't deal, taskName:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void d(String str, List list) {
        for (MvpView mvpView : this.d) {
            if (mvpView.k()) {
                f("showDataToUI(), type:" + str);
                mvpView.a(str, list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void d(String str, boolean z) {
        for (MvpView mvpView : this.d) {
            if (mvpView.k()) {
                mvpView.a(str, z);
            }
        }
    }

    private boolean d(String str) {
        List<Object> a = this.f.a(str);
        return a != null && a.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void g(String str) {
        for (MvpView mvpView : this.d) {
            if (mvpView.k()) {
                mvpView.g_(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        String str2 = this.h;
        Log.v(str2, this.a + "--" + str);
    }

    private void m() {
        for (MvpView mvpView : this.d) {
            if (mvpView.k()) {
                mvpView.o();
            }
        }
    }

    private void n() {
        for (MvpView mvpView : this.d) {
            if (mvpView.k()) {
                mvpView.p();
            }
        }
    }

    private boolean o() {
        synchronized (this.e) {
            Iterator<MvpView> it = this.e.iterator();
            do {
                if (!it.hasNext()) {
                    return false;
                }
            } while (!it.next().k());
            return true;
        }
    }

    private MvpView p() {
        for (MvpView mvpView : this.d) {
            if (mvpView.k()) {
                return mvpView;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean q() {
        return o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Pair<String, List>> a() {
        return this.f.a();
    }

    List a(String str, List list) {
        return this.f.a(str, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Bundle bundle) {
    }

    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        a(fragmentActivity);
    }

    public final void a(FragmentActivity fragmentActivity, MvpView mvpView) {
        this.d.add(mvpView);
        synchronized (this.e) {
            this.e.add(mvpView);
        }
        a(fragmentActivity);
    }

    public void a(LifecycleOwner lifecycleOwner) {
    }

    protected abstract void a(IFetchDataListener iFetchDataListener);

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(MemoryDataCache memoryDataCache) {
        this.f = memoryDataCache;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(MvpView mvpView) {
        this.d.remove(mvpView);
        synchronized (this.e) {
            this.e.remove(mvpView);
        }
    }

    public final <T> void a(String str, T t) {
        a(str, (String) t, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.util.List] */
    public final <T> void a(final String str, T t, final boolean z) {
        ArrayList arrayList;
        if (t == null || !(t instanceof List)) {
            ArrayList arrayList2 = new ArrayList();
            if (t != null) {
                arrayList2.add(t);
            }
            arrayList = arrayList2;
        } else {
            arrayList = (List) t;
        }
        final ArrayList arrayList3 = arrayList;
        a("setDataToUI_" + str, new Runnable() { // from class: com.blued.android.framework.ui.mvp.-$$Lambda$MvpPresenter$DgcLNqRJHvZ5XLr-r4V8pxNTirA
            @Override // java.lang.Runnable
            public final void run() {
                MvpPresenter.this.a(z, str, arrayList3);
            }
        });
    }

    public void a(String str, final Runnable runnable) {
        f("runDataTask, taskName:" + str);
        if (MvpUtils.a()) {
            runnable.run();
        } else {
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.framework.ui.mvp.-$$Lambda$MvpPresenter$SCYBU8zirjl-mLfkLEccIOhhyZU
                @Override // java.lang.Runnable
                public final void run() {
                    Runnable.this.run();
                }
            });
        }
    }

    public final void a(String str, boolean z) {
        a(str, (String) null, z);
    }

    List b(String str, List list) {
        return this.f.b(str, list);
    }

    protected abstract void b(IFetchDataListener iFetchDataListener);

    public void b(final String str, final Runnable runnable) {
        String str2 = this.h;
        Log.v(str2, "runUIViewTask, taskName:" + str);
        if (!MvpUtils.a()) {
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.framework.ui.mvp.-$$Lambda$MvpPresenter$Nj__fMdOeRBcvdQ1Pl-zAnXOk7M
                @Override // java.lang.Runnable
                public final void run() {
                    MvpPresenter.this.c(str, runnable);
                }
            });
        } else if (o()) {
            runnable.run();
        } else {
            f("_mvpView is not ready, task can't deal, taskName:" + str);
        }
    }

    public final void b(final String str, final boolean z) {
        b("dismissDataLoading", new Runnable() { // from class: com.blued.android.framework.ui.mvp.-$$Lambda$MvpPresenter$9hAaTMdgeh4tE32dki4KnGN7hAU
            @Override // java.lang.Runnable
            public final void run() {
                MvpPresenter.this.d(str, z);
            }
        });
    }

    public boolean b() {
        boolean z = this.b <= 0 || this.f.b();
        if (!z) {
            String[] l = l();
            if (l == null) {
                return z;
            }
            for (String str : l) {
                if (!d(str)) {
                    return true;
                }
            }
        }
        return z;
    }

    public boolean c() {
        f("isNeedRefresh, _cacheTime:" + this.b + ", interval:" + (SystemClock.uptimeMillis() - this.b));
        if (!b()) {
            return j() && SystemClock.uptimeMillis() - this.b >= 300000;
        }
        f("_refreshTime or _memoryDataCache need to refresh");
        return true;
    }

    public void d() {
        f("refreshDataIfNeed");
        if (c()) {
            f("need refresh, refresh new data");
            MvpView p = p();
            if (p != null) {
                p.l();
            }
        }
    }

    public final void d_(final String str) {
        b("showDataLoading", new Runnable() { // from class: com.blued.android.framework.ui.mvp.-$$Lambda$MvpPresenter$m64ViBcgH8kGOiiT2AjQbzydEc4
            @Override // java.lang.Runnable
            public final void run() {
                MvpPresenter.this.g(str);
            }
        });
    }

    public final void e() {
        f("refreshData");
        if (b()) {
            f("presenter has no cache data, so fetch cache first");
            k();
        }
        this.b = SystemClock.uptimeMillis();
        a(new AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e_(String str) {
        this.a = str;
    }

    public final void f() {
        Log.v(this.h, "fetchMoreData");
        b(new AnonymousClass2());
    }

    public final void f_(String str) {
        a(str, true);
    }

    public final IRequestHost g() {
        return this.g;
    }

    public final Activity h() {
        return this.c;
    }

    public final void i() {
        FragmentActivity fragmentActivity = this.c;
        if (fragmentActivity != null) {
            fragmentActivity.finish();
        }
    }

    protected boolean j() {
        return false;
    }

    public void k() {
    }

    protected String[] l() {
        return null;
    }
}
