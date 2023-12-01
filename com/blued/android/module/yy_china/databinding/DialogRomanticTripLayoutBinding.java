package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogRomanticTripLayoutBinding.class */
public final class DialogRomanticTripLayoutBinding implements ViewBinding {
    public final View a;
    public final ShapeTextView b;
    public final View c;
    public final View d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ConstraintLayout i;
    public final ShapeConstraintLayout j;
    public final RecyclerView k;
    public final RecyclerView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    private final ConstraintLayout p;

    private DialogRomanticTripLayoutBinding(ConstraintLayout constraintLayout, View view, ShapeTextView shapeTextView, View view2, View view3, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ConstraintLayout constraintLayout2, ShapeConstraintLayout shapeConstraintLayout, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView, TextView textView2, TextView textView3) {
        this.p = constraintLayout;
        this.a = view;
        this.b = shapeTextView;
        this.c = view2;
        this.d = view3;
        this.e = imageView;
        this.f = imageView2;
        this.g = imageView3;
        this.h = imageView4;
        this.i = constraintLayout2;
        this.j = shapeConstraintLayout;
        this.k = recyclerView;
        this.l = recyclerView2;
        this.m = textView;
        this.n = textView2;
        this.o = textView3;
    }

    public static DialogRomanticTripLayoutBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.bottom_view);
        if (findViewById != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_pay);
            if (shapeTextView != null) {
                View findViewById2 = view.findViewById(R.id.cover_view);
                if (findViewById2 != null) {
                    View findViewById3 = view.findViewById(R.id.disenable_view);
                    if (findViewById3 != null) {
                        ImageView imageView = (ImageView) view.findViewById(R.id.img_background);
                        if (imageView != null) {
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.img_map);
                            if (imageView2 != null) {
                                ImageView imageView3 = (ImageView) view.findViewById(R.id.img_rule);
                                if (imageView3 != null) {
                                    ImageView imageView4 = (ImageView) view.findViewById(R.id.img_user_list_bg);
                                    if (imageView4 != null) {
                                        ConstraintLayout findViewById4 = view.findViewById(R.id.ll_content_view);
                                        if (findViewById4 != null) {
                                            ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.ll_user_list);
                                            if (shapeConstraintLayout != null) {
                                                RecyclerView findViewById5 = view.findViewById(R.id.rv_city_list);
                                                if (findViewById5 != null) {
                                                    RecyclerView findViewById6 = view.findViewById(R.id.rv_user_list);
                                                    if (findViewById6 != null) {
                                                        TextView textView = (TextView) view.findViewById(R.id.tv_guidebook);
                                                        if (textView != null) {
                                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_rule_info);
                                                            if (textView2 != null) {
                                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_user_title);
                                                                if (textView3 != null) {
                                                                    return new DialogRomanticTripLayoutBinding((ConstraintLayout) view, findViewById, shapeTextView, findViewById2, findViewById3, imageView, imageView2, imageView3, imageView4, findViewById4, shapeConstraintLayout, findViewById5, findViewById6, textView, textView2, textView3);
                                                                }
                                                                str = "tvUserTitle";
                                                            } else {
                                                                str = "tvRuleInfo";
                                                            }
                                                        } else {
                                                            str = "tvGuidebook";
                                                        }
                                                    } else {
                                                        str = "rvUserList";
                                                    }
                                                } else {
                                                    str = "rvCityList";
                                                }
                                            } else {
                                                str = "llUserList";
                                            }
                                        } else {
                                            str = "llContentView";
                                        }
                                    } else {
                                        str = "imgUserListBg";
                                    }
                                } else {
                                    str = "imgRule";
                                }
                            } else {
                                str = "imgMap";
                            }
                        } else {
                            str = "imgBackground";
                        }
                    } else {
                        str = "disenableView";
                    }
                } else {
                    str = "coverView";
                }
            } else {
                str = "btnPay";
            }
        } else {
            str = "bottomView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.p;
    }
}
