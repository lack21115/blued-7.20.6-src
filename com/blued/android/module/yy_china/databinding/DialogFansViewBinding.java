package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.yy_china.R;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogFansViewBinding.class */
public final class DialogFansViewBinding implements ViewBinding {
    public final ShapeLinearLayout a;
    public final View b;
    public final ImageView c;
    public final ShapeableImageView d;
    public final ImageView e;
    public final ConstraintLayout f;
    public final LinearLayout g;
    public final ConstraintLayout h;
    public final ConstraintLayout i;
    public final RecyclerView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    private final ConstraintLayout n;

    private DialogFansViewBinding(ConstraintLayout constraintLayout, ShapeLinearLayout shapeLinearLayout, View view, ImageView imageView, ShapeableImageView shapeableImageView, ImageView imageView2, ConstraintLayout constraintLayout2, LinearLayout linearLayout, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3) {
        this.n = constraintLayout;
        this.a = shapeLinearLayout;
        this.b = view;
        this.c = imageView;
        this.d = shapeableImageView;
        this.e = imageView2;
        this.f = constraintLayout2;
        this.g = linearLayout;
        this.h = constraintLayout3;
        this.i = constraintLayout4;
        this.j = recyclerView;
        this.k = textView;
        this.l = textView2;
        this.m = textView3;
    }

    public static DialogFansViewBinding a(View view) {
        String str;
        ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.btn_join);
        if (shapeLinearLayout != null) {
            View findViewById = view.findViewById(R.id.cover_view);
            if (findViewById != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.img_fans_gift);
                if (imageView != null) {
                    ShapeableImageView findViewById2 = view.findViewById(R.id.img_host_avatar);
                    if (findViewById2 != null) {
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.img_q_a);
                        if (imageView2 != null) {
                            ConstraintLayout findViewById3 = view.findViewById(R.id.ll_author_view);
                            if (findViewById3 != null) {
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_title_view);
                                if (linearLayout != null) {
                                    ConstraintLayout findViewById4 = view.findViewById(R.id.root_cover_view);
                                    if (findViewById4 != null) {
                                        ConstraintLayout findViewById5 = view.findViewById(R.id.root_view);
                                        if (findViewById5 != null) {
                                            RecyclerView findViewById6 = view.findViewById(R.id.rv_benefit_list);
                                            if (findViewById6 != null) {
                                                TextView textView = (TextView) view.findViewById(R.id.tv_fans_amount);
                                                if (textView != null) {
                                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_fans_value);
                                                    if (textView2 != null) {
                                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_host_name);
                                                        if (textView3 != null) {
                                                            return new DialogFansViewBinding((ConstraintLayout) view, shapeLinearLayout, findViewById, imageView, findViewById2, imageView2, findViewById3, linearLayout, findViewById4, findViewById5, findViewById6, textView, textView2, textView3);
                                                        }
                                                        str = "tvHostName";
                                                    } else {
                                                        str = "tvFansValue";
                                                    }
                                                } else {
                                                    str = "tvFansAmount";
                                                }
                                            } else {
                                                str = "rvBenefitList";
                                            }
                                        } else {
                                            str = "rootView";
                                        }
                                    } else {
                                        str = "rootCoverView";
                                    }
                                } else {
                                    str = "llTitleView";
                                }
                            } else {
                                str = "llAuthorView";
                            }
                        } else {
                            str = "imgQA";
                        }
                    } else {
                        str = "imgHostAvatar";
                    }
                } else {
                    str = "imgFansGift";
                }
            } else {
                str = "coverView";
            }
        } else {
            str = "btnJoin";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.n;
    }
}
