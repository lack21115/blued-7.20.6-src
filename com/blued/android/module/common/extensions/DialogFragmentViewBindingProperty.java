package com.blued.android.module.common.extensions;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/extensions/DialogFragmentViewBindingProperty.class */
public final class DialogFragmentViewBindingProperty<F extends Fragment, V extends ViewBinding> extends LifecycleViewBindingProperty<F, V> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogFragmentViewBindingProperty(Function1<? super F, ? extends V> viewBinder) {
        super(viewBinder);
        Intrinsics.e(viewBinder, "viewBinder");
    }

    protected Lifecycle a(F thisRef) {
        Intrinsics.e(thisRef, "thisRef");
        if (thisRef instanceof DialogFragment) {
            DialogFragment dialogFragment = (DialogFragment) thisRef;
            if (dialogFragment.getShowsDialog()) {
                Lifecycle lifecycle = dialogFragment.getLifecycle();
                Intrinsics.c(lifecycle, "{\n            thisRef.lifecycle\n        }");
                return lifecycle;
            }
        }
        try {
            Lifecycle lifecycle2 = thisRef.getViewLifecycleOwner().getLifecycle();
            Intrinsics.c(lifecycle2, "{\n            try {\n    …)\n            }\n        }");
            return lifecycle2;
        } catch (IllegalStateException e) {
            Lifecycle lifecycle3 = thisRef.getLifecycle();
            Intrinsics.c(lifecycle3, "thisRef.lifecycle");
            return lifecycle3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.blued.android.module.common.extensions.LifecycleViewBindingProperty
    public /* bridge */ /* synthetic */ Lifecycle a(Object obj) {
        return a((DialogFragmentViewBindingProperty<F, V>) ((Fragment) obj));
    }
}
