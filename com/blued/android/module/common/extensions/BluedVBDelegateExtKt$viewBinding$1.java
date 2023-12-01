package com.blued.android.module.common.extensions;

import android.app.Activity;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/extensions/BluedVBDelegateExtKt$viewBinding$1.class */
public final /* synthetic */ class BluedVBDelegateExtKt$viewBinding$1 extends FunctionReferenceImpl implements Function1<Activity, View> {

    /* renamed from: a  reason: collision with root package name */
    public static final BluedVBDelegateExtKt$viewBinding$1 f10782a = new BluedVBDelegateExtKt$viewBinding$1();

    public BluedVBDelegateExtKt$viewBinding$1() {
        super(1, BluedVBDelegateExtKt.class, "findRootView", "findRootView(Landroid/app/Activity;)Landroid/view/View;", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final View invoke(Activity p0) {
        Intrinsics.e(p0, "p0");
        return BluedVBDelegateExtKt.a(p0);
    }
}
