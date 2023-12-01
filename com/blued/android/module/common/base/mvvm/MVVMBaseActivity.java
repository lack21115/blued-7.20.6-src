package com.blued.android.module.common.base.mvvm;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvvm/MVVMBaseActivity.class */
public abstract class MVVMBaseActivity<M extends BaseViewModel> extends BaseFragmentActivity {
    private final int c;
    private final Lazy d;

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvvm/MVVMBaseActivity$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[LoadState.values().length];
            iArr[LoadState.LoadStart.ordinal()] = 1;
            iArr[LoadState.LoadSuccess.ordinal()] = 2;
            iArr[LoadState.LoadFail.ordinal()] = 3;
            a = iArr;
            int[] iArr2 = new int[HasMoreState.values().length];
            iArr2[HasMoreState.HasMore.ordinal()] = 1;
            iArr2[HasMoreState.NoMore.ordinal()] = 2;
            b = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MVVMBaseActivity this$0, HasMoreState hasMoreState) {
        Intrinsics.e(this$0, "this$0");
        int i = hasMoreState == null ? -1 : WhenMappings.b[hasMoreState.ordinal()];
        if (i == 1) {
            this$0.o();
        } else if (i != 2) {
        } else {
            this$0.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MVVMBaseActivity this$0, LoadState loadState) {
        Intrinsics.e(this$0, "this$0");
        int i = loadState == null ? -1 : WhenMappings.a[loadState.ordinal()];
        if (i == 1) {
            this$0.n();
        } else if (i == 2) {
            this$0.a(true);
        } else if (i != 3) {
        } else {
            this$0.a(false);
        }
    }

    private final void q() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        j().a().observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.common.base.mvvm.-$$Lambda$MVVMBaseActivity$3azlmxXWakF1LoKErwggl6oXR8w
            public final void onChanged(Object obj) {
                MVVMBaseActivity.a(MVVMBaseActivity.this, (LoadState) obj);
            }
        });
        j().b().observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.common.base.mvvm.-$$Lambda$MVVMBaseActivity$59fhqMp_C3JX9YWdnx7WO31SYIc
            public final void onChanged(Object obj) {
                MVVMBaseActivity.a(MVVMBaseActivity.this, (HasMoreState) obj);
            }
        });
    }

    protected void a(boolean z) {
    }

    public final M f() {
        return (M) this.d.getValue();
    }

    protected void g() {
    }

    protected ViewModelStoreOwner h() {
        return (ViewModelStoreOwner) this;
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
            ViewModelProvider viewModelProvider = new ViewModelProvider(h, (ViewModelProvider.Factory) companion.getInstance((Application) d));
            if (type != null) {
                return (M) viewModelProvider.get((Class) type);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<M of com.blued.android.module.common.base.mvvm.MVVMBaseActivity>");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
    }

    protected final M j() {
        return f();
    }

    protected void k() {
    }

    protected abstract void l();

    protected abstract void m();

    protected void n() {
    }

    protected void o() {
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.c);
        g();
        j().a(getIntent() != null ? getIntent().getExtras() : null);
        q();
        k();
        l();
        m();
    }

    protected void p() {
    }
}
