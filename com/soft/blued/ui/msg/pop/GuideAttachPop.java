package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.provider.BrowserContract;
import android.provider.Downloads;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.module.common.extensions.CustomViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.soft.blued.R;
import com.soft.blued.databinding.PopGuideAttachBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/GuideAttachPop.class */
public final class GuideAttachPop extends AttachPopupView {
    static final /* synthetic */ KProperty<Object>[] t = {(KProperty) Reflection.a(new PropertyReference1Impl(GuideAttachPop.class, "vb", "getVb()Lcom/soft/blued/databinding/PopGuideAttachBinding;", 0))};
    private final String u;
    private final ArrowPosition v;
    private final Position w;
    private final int x;
    private final ViewBindingProperty y;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/GuideAttachPop$ArrowPosition.class */
    public enum ArrowPosition {
        LEFT,
        CENTER,
        RIGHT
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/GuideAttachPop$Position.class */
    public enum Position {
        TOP,
        BOTTOM
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/GuideAttachPop$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f18802a;

        static {
            int[] iArr = new int[ArrowPosition.values().length];
            iArr[ArrowPosition.LEFT.ordinal()] = 1;
            iArr[ArrowPosition.RIGHT.ordinal()] = 2;
            iArr[ArrowPosition.CENTER.ordinal()] = 3;
            f18802a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuideAttachPop(Context context, String str, ArrowPosition arrowPosition, Position position, int i) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(str, Downloads.Impl.COLUMN_FILE_NAME_HINT);
        Intrinsics.e(arrowPosition, "arrowPosition");
        Intrinsics.e(position, BrowserContract.Bookmarks.POSITION);
        this.u = str;
        this.v = arrowPosition;
        this.w = position;
        this.x = i;
        BasePopupView basePopupView = (BasePopupView) this;
        this.y = new CustomViewBindingProperty(new Function1<GuideAttachPop, PopGuideAttachBinding>() { // from class: com.soft.blued.ui.msg.pop.GuideAttachPop$special$$inlined$viewBindingFragment$default$1
            /* renamed from: a */
            public final PopGuideAttachBinding invoke(GuideAttachPop guideAttachPop) {
                Intrinsics.e(guideAttachPop, "popView");
                return PopGuideAttachBinding.a(guideAttachPop.getPopupImplView());
            }
        });
    }

    private final PopGuideAttachBinding getVb() {
        return (PopGuideAttachBinding) this.y.b(this, t[0]);
    }

    public void b() {
        super.b();
        PopGuideAttachBinding vb = getVb();
        if (vb == null) {
            return;
        }
        vb.e.setText(getHint());
        ImageView imageView = getPosition() == Position.BOTTOM ? vb.b : vb.f15845a;
        Intrinsics.c(imageView, "if (position == Position…arrowUp else it.arrowDown");
        imageView.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        int i = WhenMappings.f18802a[getArrowPosition().ordinal()];
        if (i == 1) {
            layoutParams2.gravity = 3;
            layoutParams2.leftMargin = getOffset();
        } else if (i == 2) {
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = getOffset();
        } else if (i == 3) {
            layoutParams2.gravity = 1;
        }
        imageView.setLayoutParams(layoutParams2);
    }

    public final ArrowPosition getArrowPosition() {
        return this.v;
    }

    public final String getHint() {
        return this.u;
    }

    public int getImplLayoutId() {
        return R.layout.pop_guide_attach;
    }

    public final int getOffset() {
        return this.x;
    }

    public final Position getPosition() {
        return this.w;
    }
}
