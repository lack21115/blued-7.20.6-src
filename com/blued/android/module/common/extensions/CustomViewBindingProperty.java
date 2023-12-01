package com.blued.android.module.common.extensions;

import androidx.viewbinding.ViewBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/extensions/CustomViewBindingProperty.class */
public final class CustomViewBindingProperty<R, V extends ViewBinding> implements ViewBindingProperty<R, V> {
    private final Function1<R, V> a;
    private V b;

    /* JADX WARN: Multi-variable type inference failed */
    public CustomViewBindingProperty(Function1<? super R, ? extends V> viewBinder) {
        Intrinsics.e(viewBinder, "viewBinder");
        this.a = viewBinder;
    }

    @Override // kotlin.properties.ReadOnlyProperty
    /* renamed from: a */
    public V b(R thisRef, KProperty<?> property) {
        Intrinsics.e(thisRef, "thisRef");
        Intrinsics.e(property, "property");
        V v = this.b;
        if (v == null) {
            V invoke = this.a.invoke(thisRef);
            this.b = invoke;
            return invoke;
        }
        return v;
    }
}
