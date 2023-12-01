package com.blued.android.module.common.extensions;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [F, V] */
@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/extensions/BluedVBDelegateExtKt$viewBinding$4.class */
public final class BluedVBDelegateExtKt$viewBinding$4<F, V> extends Lambda implements Function1<F, V> {
    final /* synthetic */ Function1<View, V> a;
    final /* synthetic */ Function1<F, View> b;

    /* JADX WARN: Incorrect return type in method signature: (TF;)TV; */
    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final ViewBinding invoke(Fragment fragment) {
        Intrinsics.e(fragment, "fragment");
        return (ViewBinding) this.a.invoke(this.b.invoke(fragment));
    }
}
