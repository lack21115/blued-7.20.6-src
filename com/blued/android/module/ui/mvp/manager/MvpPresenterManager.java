package com.blued.android.module.ui.mvp.manager;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.ui.mvp.presenter.MvpPresenter;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/ui/mvp/manager/MvpPresenterManager.class */
public final class MvpPresenterManager {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f16049a = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private static final Lazy<MvpPresenterManager> f16050c = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<MvpPresenterManager>() { // from class: com.blued.android.module.ui.mvp.manager.MvpPresenterManager$Companion$manager$2
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final MvpPresenterManager invoke() {
            return new MvpPresenterManager();
        }
    });
    private final Map<String, MvpPresenter> b = new HashMap();

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/ui/mvp/manager/MvpPresenterManager$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final MvpPresenterManager b() {
            return (MvpPresenterManager) MvpPresenterManager.f16050c.getValue();
        }

        @JvmStatic
        public final MvpPresenterManager a() {
            return b();
        }
    }

    public final MvpPresenter a(String presenterId) {
        Intrinsics.e(presenterId, "presenterId");
        return this.b.get(presenterId);
    }

    public final void a(final MvpPresenter mvpPresenter, final Lifecycle lifecycle) {
        Intrinsics.e(mvpPresenter, "mvpPresenter");
        Intrinsics.e(lifecycle, "lifecycle");
        LogUtils.b("onSave, add mvpPresenter:" + mvpPresenter + ", for key:" + mvpPresenter.c());
        final String h = mvpPresenter.h();
        this.b.put(h, mvpPresenter);
        lifecycle.addObserver(new LifecycleObserver() { // from class: com.blued.android.module.ui.mvp.manager.MvpPresenterManager$savePresenter$1
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public final void onDestroy() {
                Map map;
                map = MvpPresenterManager.this.b;
                MvpPresenter mvpPresenter2 = (MvpPresenter) map.remove(h);
                if (mvpPresenter2 != null) {
                    mvpPresenter2.t();
                }
                lifecycle.removeObserver(this);
                LogUtils.b("onDestroy, remove mvpPresenter:" + mvpPresenter2 + ", for key:" + mvpPresenter.c());
            }
        });
    }
}
