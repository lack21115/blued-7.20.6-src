package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyRedEnvelopeOpenedBinding.class */
public final class FragmentYyRedEnvelopeOpenedBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f16539a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f16540c;
    public final ImageView d;
    public final RecyclerView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    private final ConstraintLayout i;

    private FragmentYyRedEnvelopeOpenedBinding(ConstraintLayout constraintLayout, View view, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3) {
        this.i = constraintLayout;
        this.f16539a = view;
        this.b = imageView;
        this.f16540c = linearLayout;
        this.d = imageView2;
        this.e = recyclerView;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
    }

    public static FragmentYyRedEnvelopeOpenedBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.cover_view);
        if (findViewById != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_close_btn);
            if (imageView != null) {
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_prize_view);
                if (linearLayout != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.red_envelope_img);
                    if (imageView2 != null) {
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_drawer_list);
                        if (recyclerView != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_prize_count);
                            if (textView != null) {
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_red_envelope_title);
                                if (textView2 != null) {
                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_take_off_count);
                                    if (textView3 != null) {
                                        return new FragmentYyRedEnvelopeOpenedBinding((ConstraintLayout) view, findViewById, imageView, linearLayout, imageView2, recyclerView, textView, textView2, textView3);
                                    }
                                    str = "tvTakeOffCount";
                                } else {
                                    str = "tvRedEnvelopeTitle";
                                }
                            } else {
                                str = "tvPrizeCount";
                            }
                        } else {
                            str = "rvDrawerList";
                        }
                    } else {
                        str = "redEnvelopeImg";
                    }
                } else {
                    str = "llPrizeView";
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
        return this.i;
    }
}
