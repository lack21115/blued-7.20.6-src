package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.yy_china.databinding.ViewYyStepBinding;
import com.blued.android.module.yy_china.model.YYStepModel;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYStepView.class */
public final class YYStepView extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private YYStepModel f18499a;
    private ViewYyStepBinding b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18500c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYStepView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYStepView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYStepView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        ViewYyStepBinding a2 = ViewYyStepBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a2, "inflate(LayoutInflater.from(context), this, true)");
        this.b = a2;
    }

    private final int a(int i) {
        return DensityUtils.a(getContext(), i * 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        YYStepModel yYStepModel = this.f18499a;
        if (yYStepModel == null) {
            return;
        }
        this.b.e.setText(yYStepModel.name);
        this.b.e.setAlpha(yYStepModel.isChecked ? 1.0f : 0.3f);
        if (this.f18500c) {
            this.b.f16961c.setVisibility(8);
            this.b.b.setVisibility(8);
            this.b.d.setVisibility(yYStepModel.isLastOne ? 8 : 0);
            View view = this.b.f16960a;
            int i = 0;
            if (yYStepModel.isLastOne) {
                i = 8;
            }
            view.setVisibility(i);
            return;
        }
        this.b.b.setVisibility(yYStepModel.isLastOne ? 8 : 0);
        ImageView imageView = this.b.f16961c;
        int i2 = 0;
        if (yYStepModel.isLastOne) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        this.b.d.setVisibility(8);
        this.b.f16960a.setVisibility(8);
    }

    public final void a(int i, int i2, int i3, int i4) {
        this.b.e.setPadding(a(i), a(i2), a(i3), a(i4));
    }

    public final void a(YYStepModel stepModel, LifecycleOwner active, boolean z) {
        Intrinsics.e(stepModel, "stepModel");
        Intrinsics.e(active, "active");
        this.f18499a = stepModel;
        this.f18500c = z;
        a();
        LiveEventBus.get("refresh_dating_step", YYStepModel.class).observe(active, new Observer<YYStepModel>() { // from class: com.blued.android.module.yy_china.view.YYStepView$bindData$1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(YYStepModel yYStepModel) {
                YYStepModel yYStepModel2;
                YYStepModel yYStepModel3;
                YYStepModel yYStepModel4;
                if (yYStepModel != null) {
                    yYStepModel2 = YYStepView.this.f18499a;
                    if (yYStepModel2 == null) {
                        return;
                    }
                    yYStepModel3 = YYStepView.this.f18499a;
                    if (yYStepModel3 != null) {
                        yYStepModel4 = YYStepView.this.f18499a;
                        Integer valueOf = yYStepModel4 == null ? null : Integer.valueOf(yYStepModel4.stepIndex);
                        Intrinsics.a(valueOf);
                        yYStepModel3.isChecked = valueOf.intValue() <= yYStepModel.stepIndex;
                    }
                    YYStepView.this.a();
                }
            }
        });
    }

    public final void setImageOfStepLine(int i) {
        this.b.f16961c.setImageResource(i);
    }

    public final void setLineMargin(float... ltrb) {
        Intrinsics.e(ltrb, "ltrb");
        int length = ltrb.length;
        ViewGroup.LayoutParams layoutParams = this.b.f16961c.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        if (length >= 1) {
            layoutParams2.leftMargin = DensityUtils.a(getContext(), ltrb[0]);
        }
        if (length >= 2) {
            layoutParams2.topMargin = DensityUtils.a(getContext(), ltrb[1]);
        }
        if (length >= 3) {
            layoutParams2.rightMargin = DensityUtils.a(getContext(), ltrb[2]);
        }
        if (length >= 4) {
            layoutParams2.bottomMargin = DensityUtils.a(getContext(), ltrb[3]);
        }
    }

    public final void setStepNameSize(float f) {
        this.b.e.setTextSize(f);
    }

    public final void setStepViewBackground(int i) {
        this.b.e.setBackgroundResource(i);
    }
}
