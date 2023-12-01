package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyCpBossDialogBinding.class */
public final class ViewYyCpBossDialogBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16897a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final View f16898c;
    public final ShapeFrameLayout d;
    public final ShapeFrameLayout e;
    public final FrameLayout f;
    public final ShapeFrameLayout g;
    public final ImageView h;
    public final ImageView i;
    public final ShapeFrameLayout j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    private final ConstraintLayout o;

    private ViewYyCpBossDialogBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, TextView textView, View view, ShapeFrameLayout shapeFrameLayout, ShapeFrameLayout shapeFrameLayout2, FrameLayout frameLayout, ShapeFrameLayout shapeFrameLayout3, ImageView imageView, ImageView imageView2, ShapeFrameLayout shapeFrameLayout4, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.o = constraintLayout;
        this.f16897a = shapeTextView;
        this.b = textView;
        this.f16898c = view;
        this.d = shapeFrameLayout;
        this.e = shapeFrameLayout2;
        this.f = frameLayout;
        this.g = shapeFrameLayout3;
        this.h = imageView;
        this.i = imageView2;
        this.j = shapeFrameLayout4;
        this.k = textView2;
        this.l = textView3;
        this.m = textView4;
        this.n = textView5;
    }

    public static ViewYyCpBossDialogBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.boss_apply);
        if (shapeTextView != null) {
            TextView textView = (TextView) view.findViewById(R.id.boss_dialog_title);
            if (textView != null) {
                View findViewById = view.findViewById(R.id.cover_view);
                if (findViewById != null) {
                    ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.dot_shape_1);
                    if (shapeFrameLayout != null) {
                        ShapeFrameLayout shapeFrameLayout2 = (ShapeFrameLayout) view.findViewById(R.id.dot_shape_2);
                        if (shapeFrameLayout2 != null) {
                            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_background);
                            if (frameLayout != null) {
                                ShapeFrameLayout shapeFrameLayout3 = (ShapeFrameLayout) view.findViewById(R.id.img_background);
                                if (shapeFrameLayout3 != null) {
                                    ImageView imageView = (ImageView) view.findViewById(R.id.img_gift_value);
                                    if (imageView != null) {
                                        ImageView imageView2 = (ImageView) view.findViewById(R.id.img_gift_view);
                                        if (imageView2 != null) {
                                            ShapeFrameLayout shapeFrameLayout4 = (ShapeFrameLayout) view.findViewById(R.id.shape_background);
                                            if (shapeFrameLayout4 != null) {
                                                TextView textView2 = (TextView) view.findViewById(R.id.tv_gift_name);
                                                if (textView2 != null) {
                                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_gift_price);
                                                    if (textView3 != null) {
                                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_vip_benefits);
                                                        if (textView4 != null) {
                                                            TextView textView5 = (TextView) view.findViewById(R.id.tv_vip_requirement);
                                                            if (textView5 != null) {
                                                                return new ViewYyCpBossDialogBinding((ConstraintLayout) view, shapeTextView, textView, findViewById, shapeFrameLayout, shapeFrameLayout2, frameLayout, shapeFrameLayout3, imageView, imageView2, shapeFrameLayout4, textView2, textView3, textView4, textView5);
                                                            }
                                                            str = "tvVipRequirement";
                                                        } else {
                                                            str = "tvVipBenefits";
                                                        }
                                                    } else {
                                                        str = "tvGiftPrice";
                                                    }
                                                } else {
                                                    str = "tvGiftName";
                                                }
                                            } else {
                                                str = "shapeBackground";
                                            }
                                        } else {
                                            str = "imgGiftView";
                                        }
                                    } else {
                                        str = "imgGiftValue";
                                    }
                                } else {
                                    str = "imgBackground";
                                }
                            } else {
                                str = "flBackground";
                            }
                        } else {
                            str = "dotShape2";
                        }
                    } else {
                        str = "dotShape1";
                    }
                } else {
                    str = "coverView";
                }
            } else {
                str = "bossDialogTitle";
            }
        } else {
            str = "bossApply";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.o;
    }
}
