package com.soft.blued.ui.msg.pop;

import android.content.Context;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/LoadingPop.class */
public final class LoadingPop extends CenterPopupView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingPop(Context context) {
        super(context);
        Intrinsics.e(context, "context");
    }

    public int getImplLayoutId() {
        return 2131558566;
    }
}
