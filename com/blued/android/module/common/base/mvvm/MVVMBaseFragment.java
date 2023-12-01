package com.blued.android.module.common.base.mvvm;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvvm/MVVMBaseFragment.class */
public abstract class MVVMBaseFragment<M extends BaseViewModel> extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private final int f10696a;
    private final Lazy b = LazyKt.a(new Function0<M>(this) { // from class: com.blued.android.module.common.base.mvvm.MVVMBaseFragment$mViewModel$2

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MVVMBaseFragment<M> f10699a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.f10699a = this;
        }

        /* JADX WARN: Incorrect return type in method signature: ()TM; */
        /* JADX WARN: Type inference failed for: r0v2, types: [com.blued.android.module.common.base.mvvm.BaseViewModel] */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final BaseViewModel invoke() {
            return this.f10699a.i();
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private boolean f10697c = true;
    private boolean d = true;

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvvm/MVVMBaseFragment$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10698a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[LoadState.values().length];
            iArr[LoadState.LoadStart.ordinal()] = 1;
            iArr[LoadState.LoadSuccess.ordinal()] = 2;
            iArr[LoadState.LoadFail.ordinal()] = 3;
            f10698a = iArr;
            int[] iArr2 = new int[HasMoreState.values().length];
            iArr2[HasMoreState.HasMore.ordinal()] = 1;
            iArr2[HasMoreState.NoMore.ordinal()] = 2;
            b = iArr2;
        }
    }

    public MVVMBaseFragment(int i) {
        this.f10696a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MVVMBaseFragment this$0, HasMoreState hasMoreState) {
        Intrinsics.e(this$0, "this$0");
        int i = hasMoreState == null ? -1 : WhenMappings.b[hasMoreState.ordinal()];
        if (i == 1) {
            this$0.n();
        } else if (i != 2) {
        } else {
            this$0.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MVVMBaseFragment this$0, LoadState loadState) {
        Intrinsics.e(this$0, "this$0");
        int i = loadState == null ? -1 : WhenMappings.f10698a[loadState.ordinal()];
        if (i == 1) {
            this$0.m();
        } else if (i == 2) {
            this$0.a(true);
        } else if (i != 3) {
        } else {
            this$0.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MVVMBaseFragment this$0, Void r4) {
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    private final void p() {
        j().a(getArguments());
        if (this.d || d()) {
            k();
            this.d = false;
        }
        l();
        q();
    }

    private final void q() {
        j().a().observe(getViewLifecycleOwner(), new Observer() { // from class: com.blued.android.module.common.base.mvvm.-$$Lambda$MVVMBaseFragment$RhNLJ-mKjTuXtSJgjoL1XqmOVWo
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MVVMBaseFragment.a(MVVMBaseFragment.this, (LoadState) obj);
            }
        });
        j().b().observe(getViewLifecycleOwner(), new Observer() { // from class: com.blued.android.module.common.base.mvvm.-$$Lambda$MVVMBaseFragment$yWeQYAB7oZ7yGmZkY7G_GfmbQO0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MVVMBaseFragment.a(MVVMBaseFragment.this, (HasMoreState) obj);
            }
        });
        a().c().observe(getViewLifecycleOwner(), new Observer() { // from class: com.blued.android.module.common.base.mvvm.-$$Lambda$MVVMBaseFragment$XKTjys5JJARKmBO5aNkoPvjwlT4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MVVMBaseFragment.a(MVVMBaseFragment.this, (Void) obj);
            }
        });
    }

    public final M a() {
        return (M) this.b.getValue();
    }

    public void a(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b() {
        return this.f10697c;
    }

    protected boolean c() {
        return false;
    }

    protected boolean d() {
        return true;
    }

    public void e() {
    }

    public abstract void f();

    public void g() {
    }

    protected ViewModelStoreOwner h() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public M i() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass == null || !(genericSuperclass instanceof ParameterizedType)) {
            throw new MVVMRuntimeException("ViewModel init error");
        }
        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        ViewModelStoreOwner h = h();
        ViewModelProvider.AndroidViewModelFactory.Companion companion = ViewModelProvider.AndroidViewModelFactory.Companion;
        Context d = AppInfo.d();
        if (d != null) {
            ViewModelProvider viewModelProvider = new ViewModelProvider(h, companion.getInstance((Application) d));
            if (type != null) {
                return (M) viewModelProvider.get((Class) type);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<M of com.blued.android.module.common.base.mvvm.MVVMBaseFragment>");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
    }

    public final M j() {
        return a();
    }

    public void k() {
    }

    protected abstract void l();

    protected void m() {
    }

    public void n() {
    }

    public void o() {
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = true;
        e();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        p();
        c();
        return inflater.inflate(this.f10696a, (ViewGroup) null, false);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        j().a().removeObservers(getViewLifecycleOwner());
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f10697c) {
            this.f10697c = false;
            g();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        f();
    }
}
