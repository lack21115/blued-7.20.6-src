package com.blued.android.module.common.extensions;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/extensions/FragmentViewBindingProperty.class */
public final class FragmentViewBindingProperty<F extends Fragment, V extends ViewBinding> extends LifecycleViewBindingProperty<F, V> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentViewBindingProperty(Function1<? super F, ? extends V> viewBinder) {
        super(viewBinder);
        Intrinsics.e(viewBinder, "viewBinder");
    }

    protected Lifecycle a(F thisRef) {
        Intrinsics.e(thisRef, "thisRef");
        try {
            Lifecycle lifecycle = thisRef.getViewLifecycleOwner().getLifecycle();
            Intrinsics.c(lifecycle, "thisRef.viewLifecycleOwner.lifecycle");
            return lifecycle;
        } catch (IllegalStateException e) {
            Logger.e("ViewBindingProperty", "IllegalStateException: Fragment doesn't have view associated with it or the view has been destroyed");
            Lifecycle lifecycle2 = thisRef.getLifecycle();
            Intrinsics.c(lifecycle2, "thisRef.lifecycle");
            return lifecycle2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.blued.android.module.common.extensions.LifecycleViewBindingProperty
    public /* bridge */ /* synthetic */ Lifecycle a(Object obj) {
        return a((FragmentViewBindingProperty<F, V>) ((Fragment) obj));
    }
}
