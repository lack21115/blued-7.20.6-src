package com.blued.android.module.common.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;
import com.blued.android.module.common.R;
import com.blued.android.module.common.databinding.PopGuideCommonBinding;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.blued.android.module.common.extensions.CustomViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.utils.NinePatchUtils;
import com.blued.android.module.common.view.CommonGuidePop;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/CommonGuidePop.class */
public final class CommonGuidePop extends AttachPopupView {
    private boolean A;
    private int B;
    private int C;
    private OnClickListener D;
    private final ViewBindingProperty E;
    private final NinePatchUtils.GuideArrowPosition v;
    private final int w;
    private String x;
    private int y;
    private boolean z;
    static final /* synthetic */ KProperty<Object>[] u = {Reflection.a(new PropertyReference1Impl(CommonGuidePop.class, "vb", "getVb()Lcom/blued/android/module/common/databinding/PopGuideCommonBinding;", 0))};
    public static final Companion t = new Companion(null);

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/CommonGuidePop$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(BasePopupView basePopupView) {
            if (basePopupView != null && basePopupView.s()) {
                basePopupView.p();
            }
        }

        public final void a(CommonGuidePop guidePop, XPopupCallback xPopupCallback, View atView, long j) {
            Intrinsics.e(guidePop, "guidePop");
            Intrinsics.e(atView, "atView");
            a(guidePop, xPopupCallback, atView, j, PopupPosition.Top, false);
        }

        public final void a(CommonGuidePop guidePop, XPopupCallback xPopupCallback, View atView, long j, PopupPosition position, boolean z) {
            Intrinsics.e(guidePop, "guidePop");
            Intrinsics.e(atView, "atView");
            Intrinsics.e(position, "position");
            final BasePopupView a = new XPopup.Builder(guidePop.getContext()).a(atView).a(xPopupCallback).d((Boolean) false).b(z).a(position).a(PopupAnimation.ScaleAlphaFromCenter).b(Boolean.valueOf(guidePop.z())).c(guidePop.A()).b(guidePop.getOffsetX()).c(guidePop.getOffsetY()).a((BasePopupView) guidePop);
            a.h();
            if (j != 0) {
                AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.common.view.-$$Lambda$CommonGuidePop$Companion$Uj3x3bf7u2eqQ348TdEgGG4JGEQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        CommonGuidePop.Companion.a(BasePopupView.this);
                    }
                }, j);
            }
        }
    }

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/CommonGuidePop$OnClickListener.class */
    public interface OnClickListener {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonGuidePop(Context context, String text, NinePatchUtils.GuideArrowPosition position, int i) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(text, "text");
        Intrinsics.e(position, "position");
        this.v = position;
        this.w = i;
        this.x = text;
        this.z = true;
        this.E = new CustomViewBindingProperty(new Function1<CommonGuidePop, PopGuideCommonBinding>() { // from class: com.blued.android.module.common.view.CommonGuidePop$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final PopGuideCommonBinding invoke(CommonGuidePop popView) {
                Intrinsics.e(popView, "popView");
                return PopGuideCommonBinding.a(popView.getPopupImplView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CommonGuidePop this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        OnClickListener onClickListener = this$0.D;
        if (onClickListener == null) {
            return;
        }
        onClickListener.a();
    }

    private final PopGuideCommonBinding getVb() {
        return (PopGuideCommonBinding) this.E.b(this, u[0]);
    }

    public final boolean A() {
        return this.A;
    }

    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        TextView textView;
        TextView textView2;
        FrameLayout frameLayout;
        PopGuideCommonBinding vb;
        TextView textView3;
        super.b();
        if (getContext() == null) {
            return;
        }
        PopGuideCommonBinding vb2 = getVb();
        TextView textView4 = vb2 == null ? null : vb2.c;
        if (textView4 != null) {
            textView4.setText(this.x);
        }
        if (getColorId() != 0 && (vb = getVb()) != null && (textView3 = vb.c) != null) {
            textView3.setTextColor(BluedSkinUtils.a(getContext(), getColorId()));
        }
        PopGuideCommonBinding vb3 = getVb();
        FrameLayout frameLayout2 = vb3 == null ? null : vb3.a;
        if (frameLayout2 != null) {
            frameLayout2.setBackground(NinePatchUtils.a(getPosition(), getResId()));
        }
        PopGuideCommonBinding vb4 = getVb();
        if (vb4 != null && (frameLayout = vb4.a) != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.view.-$$Lambda$CommonGuidePop$W69eiIRDw6E6LQvd2JhkfDyiGKQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommonGuidePop.a(CommonGuidePop.this, view);
                }
            });
        }
        if (getResId() == R.drawable.guide_black_bubble_down || getResId() == R.drawable.guide_blue_bubble_down) {
            PopGuideCommonBinding vb5 = getVb();
            ViewGroup.LayoutParams layoutParams = (vb5 == null || (textView = vb5.c) == null) ? null : textView.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = BluedViewExtKt.a(5);
            PopGuideCommonBinding vb6 = getVb();
            TextView textView5 = vb6 == null ? null : vb6.c;
            if (textView5 != null) {
                textView5.setLayoutParams(marginLayoutParams);
            }
            PopGuideCommonBinding vb7 = getVb();
            if (vb7 == null || (textView2 = vb7.c) == null) {
                return;
            }
            textView2.setPadding(0, 0, 0, 0);
        }
    }

    public final int getColorId() {
        return this.y;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_guide_common;
    }

    public final int getOffsetX() {
        return this.B;
    }

    public final int getOffsetY() {
        return this.C;
    }

    public final OnClickListener getOnClick() {
        return this.D;
    }

    public final NinePatchUtils.GuideArrowPosition getPosition() {
        return this.v;
    }

    public final int getResId() {
        return this.w;
    }

    public final void setClickThrough(boolean z) {
        this.A = z;
    }

    public final void setColorId(int i) {
        this.y = i;
    }

    public final void setDismissOnTouchOutside(boolean z) {
        this.z = z;
    }

    public final void setOffsetX(int i) {
        this.B = i;
    }

    public final void setOffsetY(int i) {
        this.C = i;
    }

    public final void setOnClick(OnClickListener onClickListener) {
        this.D = onClickListener;
    }

    public final boolean z() {
        return this.z;
    }
}
