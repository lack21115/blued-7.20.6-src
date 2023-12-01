package com.blued.community.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.animator.PopupAnimator;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.extensions.CustomViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.utils.NinePatchUtils;
import com.blued.community.R;
import com.blued.community.databinding.PopGuideCommonWithImgBinding;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.widget.FeedGuidePop;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/community/widget/FeedGuidePop.class */
public final class FeedGuidePop extends AttachPopupView {
    private final int A;
    private final int B;
    private String C;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private final ViewBindingProperty K;
    private final NinePatchUtils.GuideArrowPosition v;
    private final boolean w;
    private final int x;
    private final String y;
    private final int z;
    static final /* synthetic */ KProperty<Object>[] u = {Reflection.a(new PropertyReference1Impl(FeedGuidePop.class, "vb", "getVb()Lcom/blued/community/databinding/PopGuideCommonWithImgBinding;", 0))};
    public static final Companion t = new Companion(null);

    @Metadata
    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/widget/FeedGuidePop$Companion.class */
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

        public static /* synthetic */ void a(Companion companion, FeedGuidePop feedGuidePop, XPopupCallback xPopupCallback, View view, long j, PopupPosition popupPosition, boolean z, int i, Object obj) {
            if ((i & 8) != 0) {
                j = 0;
            }
            if ((i & 16) != 0) {
                popupPosition = PopupPosition.Top;
            }
            if ((i & 32) != 0) {
                z = true;
            }
            companion.a(feedGuidePop, xPopupCallback, view, j, popupPosition, z);
        }

        public final void a(FeedGuidePop guidePop, XPopupCallback xPopupCallback, View atView, long j) {
            Intrinsics.e(guidePop, "guidePop");
            Intrinsics.e(atView, "atView");
            a(guidePop, xPopupCallback, atView, j, PopupPosition.Bottom, false);
        }

        public final void a(FeedGuidePop guidePop, XPopupCallback xPopupCallback, View atView, long j, PopupPosition position, boolean z) {
            Intrinsics.e(guidePop, "guidePop");
            Intrinsics.e(atView, "atView");
            Intrinsics.e(position, "position");
            final BasePopupView a2 = new XPopup.Builder(guidePop.getContext()).a(atView).a(xPopupCallback).d((Boolean) false).b(z).a(position).c((Boolean) true).a(PopupAnimation.ScaleAlphaFromCenter).b(Boolean.valueOf(guidePop.A())).c(guidePop.B()).b(guidePop.getOffsetX()).c(guidePop.getOffsetY()).a((BasePopupView) guidePop);
            a2.h();
            if (j != 0) {
                AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.community.widget.-$$Lambda$FeedGuidePop$Companion$mmxlD8j9hfOIDuVH6nAGwmxVoY0
                    @Override // java.lang.Runnable
                    public final void run() {
                        FeedGuidePop.Companion.a(BasePopupView.this);
                    }
                }, j);
            }
        }

        public final void b(FeedGuidePop guidePop, XPopupCallback xPopupCallback, View atView, long j) {
            Intrinsics.e(guidePop, "guidePop");
            Intrinsics.e(atView, "atView");
            a(guidePop, xPopupCallback, atView, j, PopupPosition.Top, false);
        }

        public final void c(FeedGuidePop guidePop, XPopupCallback xPopupCallback, View atView, long j) {
            Intrinsics.e(guidePop, "guidePop");
            Intrinsics.e(atView, "atView");
            a(this, guidePop, xPopupCallback, atView, j, PopupPosition.Bottom, false, 32, null);
        }
    }

    @Metadata
    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/widget/FeedGuidePop$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f20484a;

        static {
            int[] iArr = new int[NinePatchUtils.GuideArrowPosition.values().length];
            iArr[NinePatchUtils.GuideArrowPosition.LEFT.ordinal()] = 1;
            iArr[NinePatchUtils.GuideArrowPosition.RIGHT.ordinal()] = 2;
            f20484a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedGuidePop(Context context, String text, NinePatchUtils.GuideArrowPosition position, boolean z, int i, String str, int i2, int i3, int i4) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(text, "text");
        Intrinsics.e(position, "position");
        this.v = position;
        this.w = z;
        this.x = i;
        this.y = str;
        this.z = i2;
        this.A = i3;
        this.B = i4;
        this.C = text;
        this.D = true;
        this.K = new CustomViewBindingProperty(new Function1<FeedGuidePop, PopGuideCommonWithImgBinding>() { // from class: com.blued.community.widget.FeedGuidePop$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final PopGuideCommonWithImgBinding invoke(FeedGuidePop popView) {
                Intrinsics.e(popView, "popView");
                return PopGuideCommonWithImgBinding.a(popView.getPopupImplView());
            }
        });
    }

    private final PopGuideCommonWithImgBinding getVb() {
        return (PopGuideCommonWithImgBinding) this.K.b(this, u[0]);
    }

    public final boolean A() {
        return this.D;
    }

    public final boolean B() {
        return this.E;
    }

    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        ImageView imageView;
        PopGuideCommonWithImgBinding vb;
        ImageView imageView2;
        ImageView imageView3;
        LinearLayout linearLayout;
        super.b();
        if (getContext() == null) {
            return;
        }
        PopGuideCommonWithImgBinding vb2 = getVb();
        TextView textView = vb2 == null ? null : vb2.f;
        if (textView != null) {
            textView.setText(this.C);
        }
        if (getTopPadding() == 0) {
            setTopPadding(FeedMethods.c(getDrawableRes() == 0 ? 9 : 5));
        }
        if (getBottomPadding() == 0) {
            setBottomPadding(FeedMethods.c(getDrawableRes() == 0 ? 9 : 5));
        }
        PopGuideCommonWithImgBinding vb3 = getVb();
        if (vb3 != null && (linearLayout = vb3.f19061c) != null) {
            linearLayout.setPadding(FeedMethods.c(getDrawableRes() == 0 ? 10 : 15), getTopPadding(), FeedMethods.c(getDrawableRes() == 0 ? 10 : 15), getBottomPadding());
        }
        if (z()) {
            PopGuideCommonWithImgBinding vb4 = getVb();
            ImageView imageView4 = vb4 == null ? null : vb4.f19060a;
            if (imageView4 != null) {
                imageView4.setVisibility(8);
            }
            PopGuideCommonWithImgBinding vb5 = getVb();
            if (vb5 != null && (imageView3 = vb5.b) != null) {
                imageView3.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = imageView3.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                int i = WhenMappings.f20484a[getPosition().ordinal()];
                if (i == 1) {
                    layoutParams2.gravity = 3;
                    layoutParams2.leftMargin = getHorizonTriangleMargin() != 0 ? getHorizonTriangleMargin() : FeedMethods.c(30);
                    layoutParams2.rightMargin = 0;
                } else if (i != 2) {
                    layoutParams2.gravity = 17;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                } else {
                    layoutParams2.gravity = 5;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = FeedMethods.c(30);
                }
            }
        } else {
            PopGuideCommonWithImgBinding vb6 = getVb();
            ImageView imageView5 = vb6 == null ? null : vb6.b;
            if (imageView5 != null) {
                imageView5.setVisibility(8);
            }
            PopGuideCommonWithImgBinding vb7 = getVb();
            if (vb7 != null && (imageView = vb7.f19060a) != null) {
                imageView.setVisibility(0);
                ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
                if (layoutParams3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                }
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
                int i2 = WhenMappings.f20484a[getPosition().ordinal()];
                if (i2 == 1) {
                    layoutParams4.gravity = 3;
                    layoutParams4.leftMargin = DisplayUtil.a(AppInfo.d(), 20.0f);
                    layoutParams4.rightMargin = 0;
                } else if (i2 != 2) {
                    layoutParams4.gravity = 17;
                    layoutParams4.leftMargin = 0;
                    layoutParams4.rightMargin = 0;
                } else {
                    layoutParams4.gravity = 5;
                    layoutParams4.leftMargin = 0;
                    layoutParams4.rightMargin = DisplayUtil.a(AppInfo.d(), 20.0f);
                }
            }
        }
        if (getDrawableRes() != 0) {
            PopGuideCommonWithImgBinding vb8 = getVb();
            ImageView imageView6 = vb8 == null ? null : vb8.d;
            if (imageView6 != null) {
                imageView6.setVisibility(0);
            }
            if (TextUtils.isEmpty(getApngRes())) {
                ImageWrapper a2 = ImageLoader.a((IRequestHost) null, getDrawableRes());
                PopGuideCommonWithImgBinding vb9 = getVb();
                a2.a(vb9 == null ? null : vb9.d);
            } else {
                String apngRes = getApngRes();
                if (apngRes != null) {
                    ImageWrapper g = ImageLoader.c(null, apngRes).f().g(3);
                    PopGuideCommonWithImgBinding vb10 = getVb();
                    g.a(vb10 == null ? null : vb10.d);
                }
            }
        } else {
            PopGuideCommonWithImgBinding vb11 = getVb();
            ImageView imageView7 = vb11 == null ? null : vb11.d;
            if (imageView7 != null) {
                imageView7.setVisibility(8);
            }
        }
        if (getImgWidth() > 0 && getImgHeight() > 0 && (vb = getVb()) != null && (imageView2 = vb.d) != null) {
            ViewGroup.LayoutParams layoutParams5 = imageView2.getLayoutParams();
            layoutParams5.width = DisplayUtil.a(getContext(), getImgWidth());
            layoutParams5.height = DisplayUtil.a(getContext(), getImgHeight());
            imageView2.setLayoutParams(layoutParams5);
        }
        PopGuideCommonWithImgBinding vb12 = getVb();
        ImageView imageView8 = vb12 == null ? null : vb12.d;
        if (imageView8 == null) {
            return;
        }
        imageView8.setRotation(getRotationDegree());
    }

    public final String getApngRes() {
        return this.y;
    }

    public final int getBottomPadding() {
        return this.I;
    }

    public final int getDrawableRes() {
        return this.x;
    }

    public final int getHorizonTriangleMargin() {
        return this.J;
    }

    public final int getImgHeight() {
        return this.A;
    }

    public final int getImgWidth() {
        return this.z;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_guide_common_with_img;
    }

    public final int getOffsetX() {
        return this.F;
    }

    public final int getOffsetY() {
        return this.G;
    }

    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public PopupAnimator getPopupAnimator() {
        return null;
    }

    public final NinePatchUtils.GuideArrowPosition getPosition() {
        return this.v;
    }

    public final int getRotationDegree() {
        return this.B;
    }

    public final int getTopPadding() {
        return this.H;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void p() {
        super.p();
    }

    public final void setBottomPadding(int i) {
        this.I = i;
    }

    public final void setClickThrough(boolean z) {
        this.E = z;
    }

    public final void setDismissOnTouchOutside(boolean z) {
        this.D = z;
    }

    public final void setHorizonTriangleMargin(int i) {
        this.J = i;
    }

    public final void setOffsetX(int i) {
        this.F = i;
    }

    public final void setOffsetY(int i) {
        this.G = i;
    }

    public final void setTopPadding(int i) {
        this.H = i;
    }

    public final boolean z() {
        return this.w;
    }
}
