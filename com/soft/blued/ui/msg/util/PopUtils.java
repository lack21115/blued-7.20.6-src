package com.soft.blued.ui.msg.util;

import android.content.Context;
import android.provider.Downloads;
import android.view.View;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.soft.blued.ui.msg.pop.GuideCenterDownBluedPop;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/util/PopUtils.class */
public final class PopUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final PopUtils f18911a = new PopUtils();

    private PopUtils() {
    }

    public final void a(Context context, String str, View view) {
        Intrinsics.e(context, "context");
        Intrinsics.e(str, Downloads.Impl.COLUMN_FILE_NAME_HINT);
        Intrinsics.e(view, "atView");
        new XPopup.Builder(context).a(view).a(PopupAnimation.a).b(false).a(PopupPosition.d).d(false).c(BluedViewExtKt.a(-8)).a(new GuideCenterDownBluedPop(context, str)).h();
    }
}
