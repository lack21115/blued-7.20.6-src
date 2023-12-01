package com.blued.android.module.common.extensions;

import androidx.arch.core.util.Function;
import kotlin.Metadata;
import kotlin.reflect.KProperty1;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/extensions/BluedStructureExtKt$observeState$$inlined$map$2.class */
public final class BluedStructureExtKt$observeState$$inlined$map$2<I, O> implements Function {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ KProperty1 f10779a;
    final /* synthetic */ KProperty1 b;

    @Override // androidx.arch.core.util.Function
    public final StateTuple2<A, B> apply(T t) {
        return new StateTuple2<>(this.f10779a.a(t), this.b.a(t));
    }
}
