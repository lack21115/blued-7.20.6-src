package com.blued.android.module.common.widget.consecutivescroller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.blued.android.module.common.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/consecutivescroller/ConsecutiveListLinearLayout.class */
public final class ConsecutiveListLinearLayout extends LinearLayout implements IConsecutiveScroller {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConsecutiveListLinearLayout(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConsecutiveListLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsecutiveListLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
    }

    @Override // com.blued.android.module.common.widget.consecutivescroller.IConsecutiveScroller
    public View getCurrentScrollerView() {
        View findViewById = findViewById(R.id.recyclerView);
        Intrinsics.c(findViewById, "findViewById(R.id.recyclerView)");
        return findViewById;
    }

    @Override // com.blued.android.module.common.widget.consecutivescroller.IConsecutiveScroller
    public List<View> getScrolledViews() {
        View findViewById = findViewById(R.id.recyclerView);
        Intrinsics.c(findViewById, "findViewById(R.id.recyclerView)");
        return CollectionsKt.c(findViewById);
    }
}
