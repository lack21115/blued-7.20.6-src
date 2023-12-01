package androidx.fragment.app;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentViewModelLazyKt.class */
public final class FragmentViewModelLazyKt {
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> activityViewModels(Fragment fragment, Function0<? extends ViewModelProvider.Factory> function0) {
        Intrinsics.e(fragment, "$this$activityViewModels");
        Intrinsics.a(4, "VM");
        KClass b = Reflection.b(ViewModel.class);
        FragmentViewModelLazyKt$activityViewModels$1 fragmentViewModelLazyKt$activityViewModels$1 = new FragmentViewModelLazyKt$activityViewModels$1(fragment);
        if (function0 == null) {
            function0 = new FragmentViewModelLazyKt$activityViewModels$2(fragment);
        }
        return createViewModelLazy(fragment, b, fragmentViewModelLazyKt$activityViewModels$1, function0);
    }

    public static /* synthetic */ Lazy activityViewModels$default(Fragment fragment, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        Intrinsics.e(fragment, "$this$activityViewModels");
        Intrinsics.a(4, "VM");
        KClass b = Reflection.b(ViewModel.class);
        FragmentViewModelLazyKt$activityViewModels$1 fragmentViewModelLazyKt$activityViewModels$1 = new FragmentViewModelLazyKt$activityViewModels$1(fragment);
        if (function0 == null) {
            function0 = new FragmentViewModelLazyKt$activityViewModels$2(fragment);
        }
        return createViewModelLazy(fragment, b, fragmentViewModelLazyKt$activityViewModels$1, function0);
    }

    public static final <VM extends ViewModel> Lazy<VM> createViewModelLazy(final Fragment fragment, KClass<VM> kClass, Function0<? extends ViewModelStore> function0, Function0<? extends ViewModelProvider.Factory> function02) {
        Intrinsics.e(fragment, "$this$createViewModelLazy");
        Intrinsics.e(kClass, "viewModelClass");
        Intrinsics.e(function0, "storeProducer");
        if (function02 == null) {
            function02 = new Function0<ViewModelProvider.Factory>() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* renamed from: invoke */
                public final ViewModelProvider.Factory m1403invoke() {
                    return Fragment.this.getDefaultViewModelProviderFactory();
                }
            };
        }
        return new ViewModelLazy(kClass, function0, function02);
    }

    public static /* synthetic */ Lazy createViewModelLazy$default(Fragment fragment, KClass kClass, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 4) != 0) {
            function02 = null;
        }
        return createViewModelLazy(fragment, kClass, function0, function02);
    }

    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> viewModels(Fragment fragment, Function0<? extends ViewModelStoreOwner> function0, Function0<? extends ViewModelProvider.Factory> function02) {
        Intrinsics.e(fragment, "$this$viewModels");
        Intrinsics.e(function0, "ownerProducer");
        Intrinsics.a(4, "VM");
        return createViewModelLazy(fragment, Reflection.b(ViewModel.class), new FragmentViewModelLazyKt$viewModels$2(function0), function02);
    }

    public static /* synthetic */ Lazy viewModels$default(final Fragment fragment, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = new Function0<Fragment>() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$1
                {
                    super(0);
                }

                /* renamed from: invoke */
                public final Fragment m1404invoke() {
                    return Fragment.this;
                }
            };
        }
        if ((i & 2) != 0) {
            function02 = null;
        }
        Intrinsics.e(fragment, "$this$viewModels");
        Intrinsics.e(function0, "ownerProducer");
        Intrinsics.a(4, "VM");
        return createViewModelLazy(fragment, Reflection.b(ViewModel.class), new FragmentViewModelLazyKt$viewModels$2(function0), function02);
    }
}
