package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.anythink.expressad.a;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/LayoutMineTipBinding.class */
public final class LayoutMineTipBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f15716a;
    public final ShapeFrameLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f15717c;
    public final ImageView d;
    public final ShapeFrameLayout e;
    public final TextView f;
    public final ShapeLinearLayout g;
    public final ConstraintLayout h;
    public final ShapeTextView i;
    public final TextView j;
    public final TextView k;
    public final View l;
    private final ConstraintLayout m;

    private LayoutMineTipBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ShapeFrameLayout shapeFrameLayout, ImageView imageView, ImageView imageView2, ShapeFrameLayout shapeFrameLayout2, TextView textView, ShapeLinearLayout shapeLinearLayout, ConstraintLayout constraintLayout3, ShapeTextView shapeTextView, TextView textView2, TextView textView3, View view) {
        this.m = constraintLayout;
        this.f15716a = constraintLayout2;
        this.b = shapeFrameLayout;
        this.f15717c = imageView;
        this.d = imageView2;
        this.e = shapeFrameLayout2;
        this.f = textView;
        this.g = shapeLinearLayout;
        this.h = constraintLayout3;
        this.i = shapeTextView;
        this.j = textView2;
        this.k = textView3;
        this.l = view;
    }

    public static LayoutMineTipBinding a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_per_entry_tip);
        if (constraintLayout != null) {
            ShapeFrameLayout findViewById = view.findViewById(R.id.fl_setting_tip);
            if (findViewById != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_interact_tip);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_visit_tip);
                    if (imageView2 != null) {
                        ShapeFrameLayout findViewById2 = view.findViewById(R.id.live_tip1);
                        if (findViewById2 != null) {
                            TextView textView = (TextView) view.findViewById(R.id.live_tip2);
                            if (textView != null) {
                                ShapeLinearLayout findViewById3 = view.findViewById(R.id.ll_live_table_tip);
                                if (findViewById3 != null) {
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.mine_tip);
                                    if (constraintLayout2 != null) {
                                        ShapeTextView findViewById4 = view.findViewById(R.id.tip_btn);
                                        if (findViewById4 != null) {
                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_interact_tip);
                                            if (textView2 != null) {
                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_visit_tip);
                                                if (textView3 != null) {
                                                    View findViewById5 = view.findViewById(R.id.view);
                                                    if (findViewById5 != null) {
                                                        return new LayoutMineTipBinding((ConstraintLayout) view, constraintLayout, findViewById, imageView, imageView2, findViewById2, textView, findViewById3, constraintLayout2, findViewById4, textView2, textView3, findViewById5);
                                                    }
                                                    str = a.B;
                                                } else {
                                                    str = "tvVisitTip";
                                                }
                                            } else {
                                                str = "tvInteractTip";
                                            }
                                        } else {
                                            str = "tipBtn";
                                        }
                                    } else {
                                        str = "mineTip";
                                    }
                                } else {
                                    str = "llLiveTableTip";
                                }
                            } else {
                                str = "liveTip2";
                            }
                        } else {
                            str = "liveTip1";
                        }
                    } else {
                        str = "ivVisitTip";
                    }
                } else {
                    str = "ivInteractTip";
                }
            } else {
                str = "flSettingTip";
            }
        } else {
            str = "clPerEntryTip";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.m;
    }
}
