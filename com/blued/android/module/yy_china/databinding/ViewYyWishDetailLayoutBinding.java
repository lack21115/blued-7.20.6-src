package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyWishDetailLayoutBinding.class */
public final class ViewYyWishDetailLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16974a;
    public final View b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f16975c;
    public final RecyclerView d;
    public final RecyclerView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    private final ConstraintLayout l;

    private ViewYyWishDetailLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, View view, RelativeLayout relativeLayout, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.l = constraintLayout;
        this.f16974a = imageView;
        this.b = view;
        this.f16975c = relativeLayout;
        this.d = recyclerView;
        this.e = recyclerView2;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.i = textView4;
        this.j = textView5;
        this.k = textView6;
    }

    public static ViewYyWishDetailLayoutBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.bottom_background_view);
        if (imageView != null) {
            View findViewById = view.findViewById(R.id.cover_view);
            if (findViewById != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_gold);
                if (relativeLayout != null) {
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_gold_list);
                    if (recyclerView != null) {
                        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rv_wish_list);
                        if (recyclerView2 != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_reset);
                            if (textView != null) {
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_wish_list_title);
                                if (textView2 != null) {
                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_wish_ranking);
                                    if (textView3 != null) {
                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_wish_status);
                                        if (textView4 != null) {
                                            TextView textView5 = (TextView) view.findViewById(R.id.tv_wish_sub_title);
                                            if (textView5 != null) {
                                                TextView textView6 = (TextView) view.findViewById(R.id.tv_wish_title);
                                                if (textView6 != null) {
                                                    return new ViewYyWishDetailLayoutBinding((ConstraintLayout) view, imageView, findViewById, relativeLayout, recyclerView, recyclerView2, textView, textView2, textView3, textView4, textView5, textView6);
                                                }
                                                str = "tvWishTitle";
                                            } else {
                                                str = "tvWishSubTitle";
                                            }
                                        } else {
                                            str = "tvWishStatus";
                                        }
                                    } else {
                                        str = "tvWishRanking";
                                    }
                                } else {
                                    str = "tvWishListTitle";
                                }
                            } else {
                                str = "tvReset";
                            }
                        } else {
                            str = "rvWishList";
                        }
                    } else {
                        str = "rvGoldList";
                    }
                } else {
                    str = "rlGold";
                }
            } else {
                str = "coverView";
            }
        } else {
            str = "bottomBackgroundView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.l;
    }
}
