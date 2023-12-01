package com.soft.blued.ui.home.pop;

import com.soft.blued.databinding.PopTabBubbleBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/pop/TabBubblePop$special$$inlined$viewBindingFragment$default$1.class */
public final class TabBubblePop$special$$inlined$viewBindingFragment$default$1 extends Lambda implements Function1<TabBubblePop, PopTabBubbleBinding> {
    public TabBubblePop$special$$inlined$viewBindingFragment$default$1() {
        super(1);
    }

    /* renamed from: a */
    public final PopTabBubbleBinding invoke(TabBubblePop tabBubblePop) {
        Intrinsics.e(tabBubblePop, "popView");
        return PopTabBubbleBinding.a(tabBubblePop.getPopupImplView());
    }
}
