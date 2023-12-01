package com.blued.android.module.common.extensions;

import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.viewbinding.ViewBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [V] */
@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/extensions/BluedVBDelegateExtKt$viewBinding$2.class */
public final class BluedVBDelegateExtKt$viewBinding$2<V> extends Lambda implements Function1<ComponentActivity, V> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function1<View, V> f10783a;
    final /* synthetic */ Function1<ComponentActivity, View> b;

    /* JADX WARN: Incorrect return type in method signature: (Landroidx/activity/ComponentActivity;)TV; */
    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final ViewBinding invoke(ComponentActivity activity) {
        Intrinsics.e(activity, "activity");
        return (ViewBinding) this.f10783a.invoke(this.b.invoke(activity));
    }
}
