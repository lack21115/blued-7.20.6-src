package com.blued.android.module.common.extensions;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/extensions/ActivityViewBindingProperty.class */
public final class ActivityViewBindingProperty<A extends ComponentActivity, V extends ViewBinding> extends LifecycleViewBindingProperty<A, V> {
    protected Lifecycle a(A thisRef) {
        Intrinsics.e(thisRef, "thisRef");
        Lifecycle lifecycle = thisRef.getLifecycle();
        Intrinsics.c(lifecycle, "thisRef.lifecycle");
        return lifecycle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.blued.android.module.common.extensions.LifecycleViewBindingProperty
    public /* bridge */ /* synthetic */ Lifecycle a(Object obj) {
        return a((ActivityViewBindingProperty<A, V>) ((ComponentActivity) obj));
    }
}
