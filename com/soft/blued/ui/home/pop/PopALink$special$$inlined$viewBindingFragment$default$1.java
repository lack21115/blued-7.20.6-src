package com.soft.blued.ui.home.pop;

import com.soft.blued.databinding.PopAlinkBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/pop/PopALink$special$$inlined$viewBindingFragment$default$1.class */
public final class PopALink$special$$inlined$viewBindingFragment$default$1 extends Lambda implements Function1<PopALink, PopAlinkBinding> {
    public PopALink$special$$inlined$viewBindingFragment$default$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final PopAlinkBinding invoke(PopALink popView) {
        Intrinsics.e(popView, "popView");
        return PopAlinkBinding.a(popView.getPopupImplView());
    }
}
