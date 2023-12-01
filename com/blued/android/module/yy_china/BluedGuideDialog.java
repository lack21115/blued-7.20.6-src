package com.blued.android.module.yy_china;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.databinding.DialogGuideLayoutBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/BluedGuideDialog.class */
public final class BluedGuideDialog extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    private DialogGuideLayoutBinding f16099a;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/BluedGuideDialog$GuideBuilder.class */
    public static final class GuideBuilder {

        /* renamed from: a  reason: collision with root package name */
        private int f16100a;
        private float b;

        /* renamed from: c  reason: collision with root package name */
        private int f16101c;
        private int d = R.drawable.icon_yy_create_room_mask_guide_top;
        private String e = "";
        private int f = R.color.color_1B1B1B;
        private int g = R.color.syc_dark_b;
        private float h = 10.0f;
        private int i = -1;
        private int j = -1;

        public final int a() {
            return this.f16100a;
        }

        public final void a(float f) {
            this.b = f;
        }

        public final void a(int i) {
            this.f16100a = i;
        }

        public final void a(String str) {
            this.e = str;
        }

        public final float b() {
            return this.b;
        }

        public final void b(float f) {
            this.h = f;
        }

        public final void b(int i) {
            this.f16101c = i;
        }

        public final int c() {
            return this.f16101c;
        }

        public final void c(int i) {
            this.d = i;
        }

        public final int d() {
            return this.d;
        }

        public final void d(int i) {
            this.f = i;
        }

        public final String e() {
            return this.e;
        }

        public final void e(int i) {
            this.g = i;
        }

        public final int f() {
            return this.f;
        }

        public final void f(int i) {
            this.i = i;
        }

        public final int g() {
            return this.g;
        }

        public final void g(int i) {
            this.j = i;
        }

        public final float h() {
            return this.h;
        }

        public final int i() {
            return this.i;
        }

        public final int j() {
            return this.j;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BluedGuideDialog(Context context) {
        super(context);
        Intrinsics.e(context, "context");
        a(context);
    }

    private final void a(float f, int i) {
        DialogGuideLayoutBinding dialogGuideLayoutBinding = this.f16099a;
        DialogGuideLayoutBinding dialogGuideLayoutBinding2 = dialogGuideLayoutBinding;
        if (dialogGuideLayoutBinding == null) {
            Intrinsics.c("mBinding");
            dialogGuideLayoutBinding2 = null;
        }
        ViewGroup.LayoutParams layoutParams = dialogGuideLayoutBinding2.f16350a.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        if (i == 1) {
            DialogGuideLayoutBinding dialogGuideLayoutBinding3 = this.f16099a;
            if (dialogGuideLayoutBinding3 == null) {
                Intrinsics.c("mBinding");
                dialogGuideLayoutBinding3 = null;
            }
            layoutParams2.leftMargin = DensityUtils.a(dialogGuideLayoutBinding3.f16350a.getContext(), f);
        } else if (i != 2) {
        } else {
            DialogGuideLayoutBinding dialogGuideLayoutBinding4 = this.f16099a;
            if (dialogGuideLayoutBinding4 == null) {
                Intrinsics.c("mBinding");
                dialogGuideLayoutBinding4 = null;
            }
            layoutParams2.rightMargin = DensityUtils.a(dialogGuideLayoutBinding4.f16350a.getContext(), f);
        }
    }

    private final void a(int i) {
        ConstraintSet constraintSet = new ConstraintSet();
        DialogGuideLayoutBinding dialogGuideLayoutBinding = this.f16099a;
        DialogGuideLayoutBinding dialogGuideLayoutBinding2 = dialogGuideLayoutBinding;
        if (dialogGuideLayoutBinding == null) {
            Intrinsics.c("mBinding");
            dialogGuideLayoutBinding2 = null;
        }
        constraintSet.clone(dialogGuideLayoutBinding2.getRoot());
        a(constraintSet, R.id.img_guide_arrow);
        a(constraintSet, R.id.tv_guide_message);
        if (i == 0) {
            constraintSet.connect(R.id.img_guide_arrow, 1, 0, 1);
            constraintSet.connect(R.id.img_guide_arrow, 3, 0, 3);
            constraintSet.connect(R.id.tv_guide_message, 3, R.id.img_guide_arrow, 4);
            constraintSet.connect(R.id.tv_guide_message, 1, R.id.img_guide_arrow, 1);
        } else if (i == 1) {
            constraintSet.connect(R.id.tv_guide_message, 1, 0, 1);
            constraintSet.connect(R.id.tv_guide_message, 3, 0, 3);
            constraintSet.connect(R.id.img_guide_arrow, 3, R.id.tv_guide_message, 4);
            constraintSet.connect(R.id.img_guide_arrow, 1, R.id.tv_guide_message, 1);
        }
        DialogGuideLayoutBinding dialogGuideLayoutBinding3 = this.f16099a;
        if (dialogGuideLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogGuideLayoutBinding3 = null;
        }
        constraintSet.applyTo(dialogGuideLayoutBinding3.getRoot());
    }

    private final void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_guide_layout, (ViewGroup) null);
        DialogGuideLayoutBinding a2 = DialogGuideLayoutBinding.a(inflate);
        Intrinsics.c(a2, "bind(root)");
        this.f16099a = a2;
        setContentView(inflate);
        setBackgroundDrawable(new ColorDrawable(0));
        setOutsideTouchable(true);
    }

    private final void a(ConstraintSet constraintSet, int i) {
        constraintSet.clear(i, 1);
        constraintSet.clear(i, 3);
        constraintSet.clear(i, 4);
        constraintSet.clear(i, 2);
    }

    private final void b(int i) {
        ConstraintSet constraintSet = new ConstraintSet();
        DialogGuideLayoutBinding dialogGuideLayoutBinding = this.f16099a;
        DialogGuideLayoutBinding dialogGuideLayoutBinding2 = dialogGuideLayoutBinding;
        if (dialogGuideLayoutBinding == null) {
            Intrinsics.c("mBinding");
            dialogGuideLayoutBinding2 = null;
        }
        constraintSet.clone(dialogGuideLayoutBinding2.getRoot());
        constraintSet.clear(R.id.img_guide_arrow, 1);
        constraintSet.clear(R.id.img_guide_arrow, 2);
        if (i == 0) {
            constraintSet.connect(R.id.img_guide_arrow, 2, R.id.tv_guide_message, 2);
            constraintSet.connect(R.id.img_guide_arrow, 1, R.id.tv_guide_message, 1);
        } else if (i == 1) {
            constraintSet.connect(R.id.img_guide_arrow, 1, R.id.tv_guide_message, 1);
        } else if (i == 2) {
            constraintSet.connect(R.id.img_guide_arrow, 2, R.id.tv_guide_message, 2);
        }
        DialogGuideLayoutBinding dialogGuideLayoutBinding3 = this.f16099a;
        if (dialogGuideLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogGuideLayoutBinding3 = null;
        }
        constraintSet.applyTo(dialogGuideLayoutBinding3.getRoot());
    }

    public final int a() {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(1073741823, Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(1073741823, Integer.MIN_VALUE);
        DialogGuideLayoutBinding dialogGuideLayoutBinding = this.f16099a;
        DialogGuideLayoutBinding dialogGuideLayoutBinding2 = dialogGuideLayoutBinding;
        if (dialogGuideLayoutBinding == null) {
            Intrinsics.c("mBinding");
            dialogGuideLayoutBinding2 = null;
        }
        dialogGuideLayoutBinding2.getRoot().measure(makeMeasureSpec, makeMeasureSpec2);
        DialogGuideLayoutBinding dialogGuideLayoutBinding3 = this.f16099a;
        if (dialogGuideLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogGuideLayoutBinding3 = null;
        }
        return dialogGuideLayoutBinding3.getRoot().getMeasuredHeight();
    }

    public final void a(GuideBuilder guideBuilder) {
        if (guideBuilder == null) {
            return;
        }
        DialogGuideLayoutBinding dialogGuideLayoutBinding = this.f16099a;
        DialogGuideLayoutBinding dialogGuideLayoutBinding2 = dialogGuideLayoutBinding;
        if (dialogGuideLayoutBinding == null) {
            Intrinsics.c("mBinding");
            dialogGuideLayoutBinding2 = null;
        }
        dialogGuideLayoutBinding2.f16350a.setBackgroundResource(guideBuilder.d());
        DialogGuideLayoutBinding dialogGuideLayoutBinding3 = this.f16099a;
        DialogGuideLayoutBinding dialogGuideLayoutBinding4 = dialogGuideLayoutBinding3;
        if (dialogGuideLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogGuideLayoutBinding4 = null;
        }
        ShapeHelper.b(dialogGuideLayoutBinding4.b, guideBuilder.f());
        DialogGuideLayoutBinding dialogGuideLayoutBinding5 = this.f16099a;
        DialogGuideLayoutBinding dialogGuideLayoutBinding6 = dialogGuideLayoutBinding5;
        if (dialogGuideLayoutBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogGuideLayoutBinding6 = null;
        }
        ShapeTextView shapeTextView = dialogGuideLayoutBinding6.b;
        DialogGuideLayoutBinding dialogGuideLayoutBinding7 = this.f16099a;
        DialogGuideLayoutBinding dialogGuideLayoutBinding8 = dialogGuideLayoutBinding7;
        if (dialogGuideLayoutBinding7 == null) {
            Intrinsics.c("mBinding");
            dialogGuideLayoutBinding8 = null;
        }
        shapeTextView.setTextColor(dialogGuideLayoutBinding8.getRoot().getContext().getColor(guideBuilder.g()));
        DialogGuideLayoutBinding dialogGuideLayoutBinding9 = this.f16099a;
        DialogGuideLayoutBinding dialogGuideLayoutBinding10 = dialogGuideLayoutBinding9;
        if (dialogGuideLayoutBinding9 == null) {
            Intrinsics.c("mBinding");
            dialogGuideLayoutBinding10 = null;
        }
        dialogGuideLayoutBinding10.b.setTextSize(guideBuilder.h());
        a(guideBuilder.c());
        b(guideBuilder.a());
        a(guideBuilder.b(), guideBuilder.a());
        DialogGuideLayoutBinding dialogGuideLayoutBinding11 = this.f16099a;
        DialogGuideLayoutBinding dialogGuideLayoutBinding12 = dialogGuideLayoutBinding11;
        if (dialogGuideLayoutBinding11 == null) {
            Intrinsics.c("mBinding");
            dialogGuideLayoutBinding12 = null;
        }
        dialogGuideLayoutBinding12.b.setText(guideBuilder.e());
        if (guideBuilder.i() > 0) {
            DialogGuideLayoutBinding dialogGuideLayoutBinding13 = this.f16099a;
            DialogGuideLayoutBinding dialogGuideLayoutBinding14 = dialogGuideLayoutBinding13;
            if (dialogGuideLayoutBinding13 == null) {
                Intrinsics.c("mBinding");
                dialogGuideLayoutBinding14 = null;
            }
            dialogGuideLayoutBinding14.b.setMaxWidth(guideBuilder.i());
        }
        if (guideBuilder.j() > 0) {
            DialogGuideLayoutBinding dialogGuideLayoutBinding15 = this.f16099a;
            if (dialogGuideLayoutBinding15 == null) {
                Intrinsics.c("mBinding");
                dialogGuideLayoutBinding15 = null;
            }
            ViewGroup.LayoutParams layoutParams = dialogGuideLayoutBinding15.b.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ((ConstraintLayout.LayoutParams) layoutParams).height = guideBuilder.j();
        }
    }
}
