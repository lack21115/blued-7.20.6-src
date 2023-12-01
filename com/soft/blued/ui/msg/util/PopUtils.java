package com.soft.blued.ui.msg.util;

import android.content.Context;
import android.view.View;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
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
    public static final PopUtils f32602a = new PopUtils();

    private PopUtils() {
    }

    public final void a(Context context, String hint, View atView) {
        Intrinsics.e(context, "context");
        Intrinsics.e(hint, "hint");
        Intrinsics.e(atView, "atView");
        new XPopup.Builder(context).a(atView).a(PopupAnimation.ScaleAlphaFromCenter).b(false).a(PopupPosition.Bottom).d((Boolean) false).c(BluedViewExtKt.a(-8)).a((BasePopupView) new GuideCenterDownBluedPop(context, hint)).h();
    }
}
