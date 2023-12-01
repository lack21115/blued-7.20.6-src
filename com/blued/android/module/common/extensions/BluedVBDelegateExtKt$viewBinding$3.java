package com.blued.android.module.common.extensions;

import android.view.View;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/extensions/BluedVBDelegateExtKt$viewBinding$3.class */
public final /* synthetic */ class BluedVBDelegateExtKt$viewBinding$3 extends FunctionReferenceImpl implements Function1<Fragment, View> {

    /* renamed from: a  reason: collision with root package name */
    public static final BluedVBDelegateExtKt$viewBinding$3 f10784a = new BluedVBDelegateExtKt$viewBinding$3();

    public BluedVBDelegateExtKt$viewBinding$3() {
        super(1, Fragment.class, "requireView", "requireView()Landroid/view/View;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final View invoke(Fragment p0) {
        Intrinsics.e(p0, "p0");
        return p0.requireView();
    }
}
