package com.blued.android.module.common.extensions;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [P, V] */
@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/extensions/BluedVBDelegateExtKt$viewBinding$7.class */
public final class BluedVBDelegateExtKt$viewBinding$7<P, V> extends Lambda implements Function1<P, V> {
    final /* synthetic */ Function1<View, V> a;
    final /* synthetic */ Function1<P, View> b;

    /* JADX WARN: Incorrect return type in method signature: (TP;)TV; */
    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final ViewBinding invoke(BasePopupView popView) {
        Intrinsics.e(popView, "popView");
        return (ViewBinding) this.a.invoke(this.b.invoke(popView));
    }
}
