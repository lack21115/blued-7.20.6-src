package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyRedEnvelopeLayoutBinding.class */
public final class FragmentYyRedEnvelopeLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f16537a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeableImageView f16538c;
    public final LinearLayout d;
    public final ImageView e;
    public final FrameLayout f;
    public final RecyclerView g;
    public final ShapeTextView h;
    public final TextView i;
    public final TextView j;
    private final ConstraintLayout k;

    private FragmentYyRedEnvelopeLayoutBinding(ConstraintLayout constraintLayout, View view, ImageView imageView, ShapeableImageView shapeableImageView, LinearLayout linearLayout, ImageView imageView2, FrameLayout frameLayout, RecyclerView recyclerView, ShapeTextView shapeTextView, TextView textView, TextView textView2) {
        this.k = constraintLayout;
        this.f16537a = view;
        this.b = imageView;
        this.f16538c = shapeableImageView;
        this.d = linearLayout;
        this.e = imageView2;
        this.f = frameLayout;
        this.g = recyclerView;
        this.h = shapeTextView;
        this.i = textView;
        this.j = textView2;
    }

    public static FragmentYyRedEnvelopeLayoutBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.cover_view);
        if (findViewById != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_close_btn);
            if (imageView != null) {
                ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.iv_poster_img);
                if (shapeableImageView != null) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_poster_view);
                    if (linearLayout != null) {
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.red_envelope_img);
                        if (imageView2 != null) {
                            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.rv_list_bg);
                            if (frameLayout != null) {
                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_prize_list);
                                if (recyclerView != null) {
                                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_get_prize);
                                    if (shapeTextView != null) {
                                        TextView textView = (TextView) view.findViewById(R.id.tv_limit_time);
                                        if (textView != null) {
                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_poster);
                                            if (textView2 != null) {
                                                return new FragmentYyRedEnvelopeLayoutBinding((ConstraintLayout) view, findViewById, imageView, shapeableImageView, linearLayout, imageView2, frameLayout, recyclerView, shapeTextView, textView, textView2);
                                            }
                                            str = "tvPoster";
                                        } else {
                                            str = "tvLimitTime";
                                        }
                                    } else {
                                        str = "tvGetPrize";
                                    }
                                } else {
                                    str = "rvPrizeList";
                                }
                            } else {
                                str = "rvListBg";
                            }
                        } else {
                            str = "redEnvelopeImg";
                        }
                    } else {
                        str = "llPosterView";
                    }
                } else {
                    str = "ivPosterImg";
                }
            } else {
                str = "ivCloseBtn";
            }
        } else {
            str = "coverView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.k;
    }
}
