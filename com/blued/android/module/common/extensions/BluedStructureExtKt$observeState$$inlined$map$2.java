package com.blued.android.module.common.extensions;

import androidx.arch.core.util.Function;
import kotlin.Metadata;
import kotlin.reflect.KProperty1;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/extensions/BluedStructureExtKt$observeState$$inlined$map$2.class */
public final class BluedStructureExtKt$observeState$$inlined$map$2<I, O> implements Function {
    final /* synthetic */ KProperty1 a;
    final /* synthetic */ KProperty1 b;

    public final StateTuple2<A, B> apply(T t) {
        return new StateTuple2<>(this.a.a(t), this.b.a(t));
    }
}
