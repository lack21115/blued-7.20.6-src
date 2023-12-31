package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/PopGroupUserCardBinding.class */
public final class PopGroupUserCardBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f15843a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f15844c;
    public final ImageView d;
    public final ImageView e;
    public final ShapeTextView f;
    public final LinearLayout g;
    public final RelativeLayout h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final ShapeTextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    private final ConstraintLayout r;

    private PopGroupUserCardBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2, ImageView imageView3, ShapeTextView shapeTextView, LinearLayout linearLayout, RelativeLayout relativeLayout, TextView textView3, TextView textView4, TextView textView5, TextView textView6, ShapeTextView shapeTextView2, TextView textView7, TextView textView8, TextView textView9, TextView textView10) {
        this.r = constraintLayout;
        this.f15843a = textView;
        this.b = textView2;
        this.f15844c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = shapeTextView;
        this.g = linearLayout;
        this.h = relativeLayout;
        this.i = textView3;
        this.j = textView4;
        this.k = textView5;
        this.l = textView6;
        this.m = shapeTextView2;
        this.n = textView7;
        this.o = textView8;
        this.p = textView9;
        this.q = textView10;
    }

    public static PopGroupUserCardBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.age_view);
        if (textView != null) {
            TextView textView2 = (TextView) view.findViewById(R.id.height_view);
            if (textView2 != null) {
                ImageView imageView = (ImageView) view.findViewById(2131365504);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_verify);
                    if (imageView2 != null) {
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_vip);
                        if (imageView3 != null) {
                            ShapeTextView findViewById = view.findViewById(R.id.kick_out);
                            if (findViewById != null) {
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_personal_info);
                                if (linearLayout != null) {
                                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_icon);
                                    if (relativeLayout != null) {
                                        TextView textView3 = (TextView) view.findViewById(R.id.role_view);
                                        if (textView3 != null) {
                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_at_him);
                                            if (textView4 != null) {
                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_chat);
                                                if (textView5 != null) {
                                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_distance);
                                                    if (textView6 != null) {
                                                        ShapeTextView findViewById2 = view.findViewById(R.id.tv_identity);
                                                        if (findViewById2 != null) {
                                                            TextView textView7 = (TextView) view.findViewById(2131372046);
                                                            if (textView7 != null) {
                                                                TextView textView8 = (TextView) view.findViewById(R.id.tv_time);
                                                                if (textView8 != null) {
                                                                    TextView textView9 = (TextView) view.findViewById(R.id.tv_view_user);
                                                                    if (textView9 != null) {
                                                                        TextView textView10 = (TextView) view.findViewById(R.id.weight_view);
                                                                        if (textView10 != null) {
                                                                            return new PopGroupUserCardBinding((ConstraintLayout) view, textView, textView2, imageView, imageView2, imageView3, findViewById, linearLayout, relativeLayout, textView3, textView4, textView5, textView6, findViewById2, textView7, textView8, textView9, textView10);
                                                                        }
                                                                        str = "weightView";
                                                                    } else {
                                                                        str = "tvViewUser";
                                                                    }
                                                                } else {
                                                                    str = "tvTime";
                                                                }
                                                            } else {
                                                                str = "tvName";
                                                            }
                                                        } else {
                                                            str = "tvIdentity";
                                                        }
                                                    } else {
                                                        str = "tvDistance";
                                                    }
                                                } else {
                                                    str = "tvChat";
                                                }
                                            } else {
                                                str = "tvAtHim";
                                            }
                                        } else {
                                            str = "roleView";
                                        }
                                    } else {
                                        str = "rlIcon";
                                    }
                                } else {
                                    str = "llPersonalInfo";
                                }
                            } else {
                                str = "kickOut";
                            }
                        } else {
                            str = "ivVip";
                        }
                    } else {
                        str = "ivVerify";
                    }
                } else {
                    str = "ivIcon";
                }
            } else {
                str = "heightView";
            }
        } else {
            str = "ageView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.r;
    }
}
