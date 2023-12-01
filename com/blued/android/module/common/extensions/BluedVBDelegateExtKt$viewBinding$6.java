package com.blued.android.module.common.extensions;

import android.view.View;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/extensions/BluedVBDelegateExtKt$viewBinding$6.class */
public final /* synthetic */ class BluedVBDelegateExtKt$viewBinding$6 extends FunctionReferenceImpl implements Function1<BasePopupView, View> {
    public static final BluedVBDelegateExtKt$viewBinding$6 a = new BluedVBDelegateExtKt$viewBinding$6();

    public BluedVBDelegateExtKt$viewBinding$6() {
        super(1, BasePopupView.class, "getPopupImplView", "getPopupImplView()Landroid/view/View;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final View invoke(BasePopupView p0) {
        Intrinsics.e(p0, "p0");
        return p0.getPopupImplView();
    }
}
