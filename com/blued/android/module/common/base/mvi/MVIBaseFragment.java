package com.blued.android.module.common.base.mvi;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.net.wifi.WifiEnterpriseConfig;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.base.mvi.MVIBaseViewModel;
import com.blued.android.module.common.base.mvi.MviEvent;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.ToastUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvi/MVIBaseFragment.class */
public abstract class MVIBaseFragment<M extends MVIBaseViewModel<?, ?>> extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f10678a = new Companion(null);
    private final int b;
    private View e;

    /* renamed from: c  reason: collision with root package name */
    private final String f10679c = getClass().getSimpleName();
    private final Lazy d = LazyKt.a(new Function0<M>(this) { // from class: com.blued.android.module.common.base.mvi.MVIBaseFragment$mViewModel$2

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MVIBaseFragment<M> f10681a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.f10681a = this;
        }

        /* JADX WARN: Incorrect return type in method signature: ()TM; */
        /* JADX WARN: Type inference failed for: r0v2, types: [com.blued.android.module.common.base.mvi.MVIBaseViewModel] */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final MVIBaseViewModel invoke() {
            return this.f10681a.x();
        }
    });
    private boolean f = true;
    private final Lazy g = LazyKt.a(new Function0<Dialog>(this) { // from class: com.blued.android.module.common.base.mvi.MVIBaseFragment$loadingDialog$2

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MVIBaseFragment<M> f10680a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.f10680a = this;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final Dialog invoke() {
            return DialogUtils.a(this.f10680a.getContext());
        }
    });

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvi/MVIBaseFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MVIBaseFragment(int i) {
        this.b = i;
    }

    private final M a() {
        return (M) this.d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MVIBaseFragment this$0, UiEvent it) {
        Intrinsics.e(this$0, "this$0");
        if (it instanceof MviEvent.ToastEvent) {
            ToastUtils.a(((MviEvent.ToastEvent) it).a());
        } else if (it instanceof MviEvent.LoadStarted) {
            this$0.r();
        } else if (it instanceof MviEvent.LoadFinished) {
            MviEvent.LoadFinished loadFinished = (MviEvent.LoadFinished) it;
            this$0.a(loadFinished.a(), loadFinished.b());
        } else if (it instanceof MviEvent.DataEmpty) {
            this$0.z();
        }
        Intrinsics.c(it, "it");
        this$0.onEvent(it);
    }

    private final void b() {
        y().init(getArguments());
        o();
        c();
    }

    private final void c() {
        y().getUiEvent().observe(getViewLifecycleOwner(), new Observer() { // from class: com.blued.android.module.common.base.mvi.-$$Lambda$MVIBaseFragment$iNLK7rDc9JkBqvV7-00Y_V1mevg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MVIBaseFragment.a(MVIBaseFragment.this, (UiEvent) obj);
            }
        });
    }

    public int A() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return 0;
        }
        return arguments.getInt(WifiEnterpriseConfig.PRIVATE_KEY_ID_KEY, 0);
    }

    public <M> M B() {
        Bundle arguments = getArguments();
        return (M) (arguments == null ? null : arguments.getSerializable("key_data"));
    }

    public void a(boolean z, boolean z2) {
    }

    protected void k() {
    }

    public abstract void m();

    protected abstract void o();

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        Intrinsics.e(inflater, "inflater");
        b();
        if (!u() || (view = this.e) == null) {
            View inflate = inflater.inflate(this.b, (ViewGroup) null, false);
            this.e = inflate;
            return inflate;
        }
        return view;
    }

    public void onEvent(UiEvent event) {
        Intrinsics.e(event, "event");
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f) {
            this.f = false;
            k();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        m();
    }

    public void r() {
    }

    public final Dialog t() {
        Object value = this.g.getValue();
        Intrinsics.c(value, "<get-loadingDialog>(...)");
        return (Dialog) value;
    }

    protected boolean u() {
        return false;
    }

    public void v() {
    }

    protected ViewModelStoreOwner w() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public M x() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass == null || !(genericSuperclass instanceof ParameterizedType)) {
            throw new RuntimeException("ViewModel init error");
        }
        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        ViewModelStoreOwner w = w();
        ViewModelProvider.AndroidViewModelFactory.Companion companion = ViewModelProvider.AndroidViewModelFactory.Companion;
        Context d = AppInfo.d();
        if (d != null) {
            ViewModelProvider viewModelProvider = new ViewModelProvider(w, companion.getInstance((Application) d));
            if (type != null) {
                return (M) viewModelProvider.get((Class) type);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<M of com.blued.android.module.common.base.mvi.MVIBaseFragment>");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
    }

    public final M y() {
        return a();
    }

    public void z() {
    }
}
