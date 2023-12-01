package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/ViewModelLazy.class */
public final class ViewModelLazy<VM extends ViewModel> implements Lazy<VM> {
    private VM cached;
    private final Function0<ViewModelProvider.Factory> factoryProducer;
    private final Function0<ViewModelStore> storeProducer;
    private final KClass<VM> viewModelClass;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelLazy(KClass<VM> viewModelClass, Function0<? extends ViewModelStore> storeProducer, Function0<? extends ViewModelProvider.Factory> factoryProducer) {
        Intrinsics.e(viewModelClass, "viewModelClass");
        Intrinsics.e(storeProducer, "storeProducer");
        Intrinsics.e(factoryProducer, "factoryProducer");
        this.viewModelClass = viewModelClass;
        this.storeProducer = storeProducer;
        this.factoryProducer = factoryProducer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [androidx.lifecycle.ViewModel] */
    @Override // kotlin.Lazy
    public VM getValue() {
        VM vm = this.cached;
        VM vm2 = vm;
        if (vm == null) {
            vm2 = new ViewModelProvider(this.storeProducer.invoke(), this.factoryProducer.invoke()).get(JvmClassMappingKt.a(this.viewModelClass));
            this.cached = vm2;
        }
        return vm2;
    }

    public boolean isInitialized() {
        return this.cached != null;
    }
}
