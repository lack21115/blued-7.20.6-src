package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogMaskedChoseMicBinding.class */
public final class DialogMaskedChoseMicBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16362a;
    public final ShapeConstraintLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final Group f16363c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final LinearLayout h;
    public final RecyclerView i;
    public final ShapeTextView j;
    public final TextView k;
    private final FrameLayout l;

    private DialogMaskedChoseMicBinding(FrameLayout frameLayout, ShapeTextView shapeTextView, ShapeConstraintLayout shapeConstraintLayout, Group group, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, RecyclerView recyclerView, ShapeTextView shapeTextView2, TextView textView) {
        this.l = frameLayout;
        this.f16362a = shapeTextView;
        this.b = shapeConstraintLayout;
        this.f16363c = group;
        this.d = imageView;
        this.e = imageView2;
        this.f = imageView3;
        this.g = imageView4;
        this.h = linearLayout;
        this.i = recyclerView;
        this.j = shapeTextView2;
        this.k = textView;
    }

    public static DialogMaskedChoseMicBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_masked);
        if (shapeTextView != null) {
            ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.con);
            if (shapeConstraintLayout != null) {
                Group group = (Group) view.findViewById(R.id.gro_masked_about);
                if (group != null) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
                    if (imageView != null) {
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_masked_about);
                        if (imageView2 != null) {
                            ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_masked_top_about);
                            if (imageView3 != null) {
                                ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_masked_top_bg);
                                if (imageView4 != null) {
                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll);
                                    if (linearLayout != null) {
                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcv);
                                        if (recyclerView != null) {
                                            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_masked_top_about);
                                            if (shapeTextView2 != null) {
                                                TextView textView = (TextView) view.findViewById(R.id.tv_num_douzi);
                                                if (textView != null) {
                                                    return new DialogMaskedChoseMicBinding((FrameLayout) view, shapeTextView, shapeConstraintLayout, group, imageView, imageView2, imageView3, imageView4, linearLayout, recyclerView, shapeTextView2, textView);
                                                }
                                                str = "tvNumDouzi";
                                            } else {
                                                str = "tvMaskedTopAbout";
                                            }
                                        } else {
                                            str = "rcv";
                                        }
                                    } else {
                                        str = "ll";
                                    }
                                } else {
                                    str = "ivMaskedTopBg";
                                }
                            } else {
                                str = "ivMaskedTopAbout";
                            }
                        } else {
                            str = "ivMaskedAbout";
                        }
                    } else {
                        str = "ivBack";
                    }
                } else {
                    str = "groMaskedAbout";
                }
            } else {
                str = "con";
            }
        } else {
            str = "btnMasked";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.l;
    }
}
