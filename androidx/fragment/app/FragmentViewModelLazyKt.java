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
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> activityViewModels(Fragment activityViewModels, Function0<? extends ViewModelProvider.Factory> function0) {
        Intrinsics.e(activityViewModels, "$this$activityViewModels");
        Intrinsics.a(4, "VM");
        KClass b = Reflection.b(ViewModel.class);
        FragmentViewModelLazyKt$activityViewModels$1 fragmentViewModelLazyKt$activityViewModels$1 = new FragmentViewModelLazyKt$activityViewModels$1(activityViewModels);
        if (function0 == null) {
            function0 = new FragmentViewModelLazyKt$activityViewModels$2(activityViewModels);
        }
        return createViewModelLazy(activityViewModels, b, fragmentViewModelLazyKt$activityViewModels$1, function0);
    }

    public static /* synthetic */ Lazy activityViewModels$default(Fragment activityViewModels, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        Intrinsics.e(activityViewModels, "$this$activityViewModels");
        Intrinsics.a(4, "VM");
        KClass b = Reflection.b(ViewModel.class);
        FragmentViewModelLazyKt$activityViewModels$1 fragmentViewModelLazyKt$activityViewModels$1 = new FragmentViewModelLazyKt$activityViewModels$1(activityViewModels);
        if (function0 == null) {
            function0 = new FragmentViewModelLazyKt$activityViewModels$2(activityViewModels);
        }
        return createViewModelLazy(activityViewModels, b, fragmentViewModelLazyKt$activityViewModels$1, function0);
    }

    public static final <VM extends ViewModel> Lazy<VM> createViewModelLazy(final Fragment createViewModelLazy, KClass<VM> viewModelClass, Function0<? extends ViewModelStore> storeProducer, Function0<? extends ViewModelProvider.Factory> function0) {
        Intrinsics.e(createViewModelLazy, "$this$createViewModelLazy");
        Intrinsics.e(viewModelClass, "viewModelClass");
        Intrinsics.e(storeProducer, "storeProducer");
        if (function0 == null) {
            function0 = new Function0<ViewModelProvider.Factory>() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ViewModelProvider.Factory invoke() {
                    return Fragment.this.getDefaultViewModelProviderFactory();
                }
            };
        }
        return new ViewModelLazy(viewModelClass, storeProducer, function0);
    }

    public static /* synthetic */ Lazy createViewModelLazy$default(Fragment fragment, KClass kClass, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 4) != 0) {
            function02 = null;
        }
        return createViewModelLazy(fragment, kClass, function0, function02);
    }

    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> viewModels(Fragment viewModels, Function0<? extends ViewModelStoreOwner> ownerProducer, Function0<? extends ViewModelProvider.Factory> function0) {
        Intrinsics.e(viewModels, "$this$viewModels");
        Intrinsics.e(ownerProducer, "ownerProducer");
        Intrinsics.a(4, "VM");
        return createViewModelLazy(viewModels, Reflection.b(ViewModel.class), new FragmentViewModelLazyKt$viewModels$2(ownerProducer), function0);
    }

    public static /* synthetic */ Lazy viewModels$default(final Fragment viewModels, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = new Function0<Fragment>() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Fragment invoke() {
                    return Fragment.this;
                }
            };
        }
        if ((i & 2) != 0) {
            function02 = null;
        }
        Intrinsics.e(viewModels, "$this$viewModels");
        Function0 ownerProducer = function0;
        Intrinsics.e(ownerProducer, "ownerProducer");
        Intrinsics.a(4, "VM");
        return createViewModelLazy(viewModels, Reflection.b(ViewModel.class), new FragmentViewModelLazyKt$viewModels$2(function0), function02);
    }
}
