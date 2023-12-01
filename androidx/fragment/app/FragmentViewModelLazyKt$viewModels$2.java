package androidx.fragment.app;

import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentViewModelLazyKt$viewModels$2.class */
public final class FragmentViewModelLazyKt$viewModels$2 extends Lambda implements Function0<ViewModelStore> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function0 f2998a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$viewModels$2(Function0 function0) {
        super(0);
        this.f2998a = function0;
    }

    /* renamed from: invoke */
    public final ViewModelStore m1405invoke() {
        ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.f2998a.invoke()).getViewModelStore();
        Intrinsics.c(viewModelStore, "ownerProducer().viewModelStore");
        return viewModelStore;
    }
}
