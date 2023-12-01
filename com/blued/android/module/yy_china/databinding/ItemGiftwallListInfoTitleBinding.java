package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.HollowView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemGiftwallListInfoTitleBinding.class */
public final class ItemGiftwallListInfoTitleBinding implements ViewBinding {
    private final LinearLayout A;
    public final ConstraintLayout a;
    public final ConstraintLayout b;
    public final HollowView c;
    public final HollowView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final ProgressBar k;
    public final ProgressBar l;
    public final RecyclerView m;
    public final ShapeFrameLayout n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    public final ShapeTextView u;
    public final ShapeTextView v;
    public final ShapeTextView w;
    public final ShapeTextView x;
    public final TextView y;
    public final TextView z;

    private ItemGiftwallListInfoTitleBinding(LinearLayout linearLayout, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, HollowView hollowView, HollowView hollowView2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ProgressBar progressBar, ProgressBar progressBar2, RecyclerView recyclerView, ShapeFrameLayout shapeFrameLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, ShapeTextView shapeTextView3, ShapeTextView shapeTextView4, TextView textView7, TextView textView8) {
        this.A = linearLayout;
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = hollowView;
        this.d = hollowView2;
        this.e = imageView;
        this.f = imageView2;
        this.g = imageView3;
        this.h = imageView4;
        this.i = imageView5;
        this.j = imageView6;
        this.k = progressBar;
        this.l = progressBar2;
        this.m = recyclerView;
        this.n = shapeFrameLayout;
        this.o = textView;
        this.p = textView2;
        this.q = textView3;
        this.r = textView4;
        this.s = textView5;
        this.t = textView6;
        this.u = shapeTextView;
        this.v = shapeTextView2;
        this.w = shapeTextView3;
        this.x = shapeTextView4;
        this.y = textView7;
        this.z = textView8;
    }

    public static ItemGiftwallListInfoTitleBinding a(View view) {
        String str;
        ConstraintLayout findViewById = view.findViewById(R.id.con_elite);
        if (findViewById != null) {
            ConstraintLayout findViewById2 = view.findViewById(R.id.con_nomer);
            if (findViewById2 != null) {
                HollowView hollowView = (HollowView) view.findViewById(R.id.holl);
                if (hollowView != null) {
                    HollowView hollowView2 = (HollowView) view.findViewById(R.id.holl_elite);
                    if (hollowView2 != null) {
                        ImageView imageView = (ImageView) view.findViewById(R.id.iv_elite_backgound);
                        if (imageView != null) {
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_nomer_backgound);
                            if (imageView2 != null) {
                                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_share_elite);
                                if (imageView3 != null) {
                                    ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_share_nomoer);
                                    if (imageView4 != null) {
                                        ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_user);
                                        if (imageView5 != null) {
                                            ImageView imageView6 = (ImageView) view.findViewById(R.id.iv_user_elite);
                                            if (imageView6 != null) {
                                                ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.pro_elite);
                                                if (progressBar != null) {
                                                    ProgressBar progressBar2 = (ProgressBar) view.findViewById(R.id.pro_nomer);
                                                    if (progressBar2 != null) {
                                                        RecyclerView findViewById3 = view.findViewById(R.id.rv);
                                                        if (findViewById3 != null) {
                                                            ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.sha_fra_bg);
                                                            if (shapeFrameLayout != null) {
                                                                TextView textView = (TextView) view.findViewById(R.id.tv_elite_pro_text);
                                                                if (textView != null) {
                                                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_name);
                                                                    if (textView2 != null) {
                                                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_name_elite);
                                                                        if (textView3 != null) {
                                                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_nomer_pro_text);
                                                                            if (textView4 != null) {
                                                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_pro_need_elite);
                                                                                if (textView5 != null) {
                                                                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_pro_need_nomer);
                                                                                    if (textView6 != null) {
                                                                                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_share_elite_1);
                                                                                        if (shapeTextView != null) {
                                                                                            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_share_elite_2);
                                                                                            if (shapeTextView2 != null) {
                                                                                                ShapeTextView shapeTextView3 = (ShapeTextView) view.findViewById(R.id.tv_share_nomoer_1);
                                                                                                if (shapeTextView3 != null) {
                                                                                                    ShapeTextView shapeTextView4 = (ShapeTextView) view.findViewById(R.id.tv_share_nomoer_2);
                                                                                                    if (shapeTextView4 != null) {
                                                                                                        TextView textView7 = (TextView) view.findViewById(R.id.tv_title);
                                                                                                        if (textView7 != null) {
                                                                                                            TextView textView8 = (TextView) view.findViewById(R.id.tv_title_info);
                                                                                                            if (textView8 != null) {
                                                                                                                return new ItemGiftwallListInfoTitleBinding((LinearLayout) view, findViewById, findViewById2, hollowView, hollowView2, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, progressBar, progressBar2, findViewById3, shapeFrameLayout, textView, textView2, textView3, textView4, textView5, textView6, shapeTextView, shapeTextView2, shapeTextView3, shapeTextView4, textView7, textView8);
                                                                                                            }
                                                                                                            str = "tvTitleInfo";
                                                                                                        } else {
                                                                                                            str = "tvTitle";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "tvShareNomoer2";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "tvShareNomoer1";
                                                                                                }
                                                                                            } else {
                                                                                                str = "tvShareElite2";
                                                                                            }
                                                                                        } else {
                                                                                            str = "tvShareElite1";
                                                                                        }
                                                                                    } else {
                                                                                        str = "tvProNeedNomer";
                                                                                    }
                                                                                } else {
                                                                                    str = "tvProNeedElite";
                                                                                }
                                                                            } else {
                                                                                str = "tvNomerProText";
                                                                            }
                                                                        } else {
                                                                            str = "tvNameElite";
                                                                        }
                                                                    } else {
                                                                        str = "tvName";
                                                                    }
                                                                } else {
                                                                    str = "tvEliteProText";
                                                                }
                                                            } else {
                                                                str = "shaFraBg";
                                                            }
                                                        } else {
                                                            str = "rv";
                                                        }
                                                    } else {
                                                        str = "proNomer";
                                                    }
                                                } else {
                                                    str = "proElite";
                                                }
                                            } else {
                                                str = "ivUserElite";
                                            }
                                        } else {
                                            str = "ivUser";
                                        }
                                    } else {
                                        str = "ivShareNomoer";
                                    }
                                } else {
                                    str = "ivShareElite";
                                }
                            } else {
                                str = "ivNomerBackgound";
                            }
                        } else {
                            str = "ivEliteBackgound";
                        }
                    } else {
                        str = "hollElite";
                    }
                } else {
                    str = "holl";
                }
            } else {
                str = "conNomer";
            }
        } else {
            str = "conElite";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.A;
    }
}
