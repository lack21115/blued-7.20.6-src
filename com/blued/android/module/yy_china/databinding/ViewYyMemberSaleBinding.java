package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyMemberSaleBinding.class */
public final class ViewYyMemberSaleBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final YYBaseUserHeadView f16936a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f16937c;
    public final TextView d;
    public final TextView e;
    public final ConstraintLayout f;
    private final ConstraintLayout g;

    private ViewYyMemberSaleBinding(ConstraintLayout constraintLayout, YYBaseUserHeadView yYBaseUserHeadView, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, TextView textView, TextView textView2, ConstraintLayout constraintLayout2) {
        this.g = constraintLayout;
        this.f16936a = yYBaseUserHeadView;
        this.b = shapeTextView;
        this.f16937c = shapeTextView2;
        this.d = textView;
        this.e = textView2;
        this.f = constraintLayout2;
    }

    public static ViewYyMemberSaleBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_yy_member_sale, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewYyMemberSaleBinding a(View view) {
        String str;
        YYBaseUserHeadView yYBaseUserHeadView = (YYBaseUserHeadView) view.findViewById(R.id.base_us_head);
        if (yYBaseUserHeadView != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_audience_empty);
            if (shapeTextView != null) {
                ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_audience_index);
                if (shapeTextView2 != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_consumption_value);
                    if (textView != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_no_audience);
                        if (textView2 != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.yy_connectting_root);
                            if (constraintLayout != null) {
                                return new ViewYyMemberSaleBinding((ConstraintLayout) view, yYBaseUserHeadView, shapeTextView, shapeTextView2, textView, textView2, constraintLayout);
                            }
                            str = "yyConnecttingRoot";
                        } else {
                            str = "tvNoAudience";
                        }
                    } else {
                        str = "tvConsumptionValue";
                    }
                } else {
                    str = "tvAudienceIndex";
                }
            } else {
                str = "tvAudienceEmpty";
            }
        } else {
            str = "baseUsHead";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.g;
    }
}
