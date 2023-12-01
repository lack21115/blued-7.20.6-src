package com.blued.community.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/FragmentFeedBubbleRewardBinding.class */
public final class FragmentFeedBubbleRewardBinding implements ViewBinding {
    public final TextView a;
    public final ImageView b;
    public final CardView c;
    public final ImageView d;
    public final FrameLayout e;
    public final TextView f;
    public final TextView g;
    private final FrameLayout h;

    private FragmentFeedBubbleRewardBinding(FrameLayout frameLayout, TextView textView, ImageView imageView, CardView cardView, ImageView imageView2, FrameLayout frameLayout2, TextView textView2, TextView textView3) {
        this.h = frameLayout;
        this.a = textView;
        this.b = imageView;
        this.c = cardView;
        this.d = imageView2;
        this.e = frameLayout2;
        this.f = textView2;
        this.g = textView3;
    }

    public static FragmentFeedBubbleRewardBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.btn_confirm);
        if (textView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.close_btn);
            if (imageView != null) {
                CardView findViewById = view.findViewById(R.id.content_layout);
                if (findViewById != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_reward);
                    if (imageView2 != null) {
                        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.root_layout);
                        if (frameLayout != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_sub_title);
                            if (textView2 != null) {
                                TextView textView3 = (TextView) view.findViewById(R.id.tv_title);
                                if (textView3 != null) {
                                    return new FragmentFeedBubbleRewardBinding((FrameLayout) view, textView, imageView, findViewById, imageView2, frameLayout, textView2, textView3);
                                }
                                str = "tvTitle";
                            } else {
                                str = "tvSubTitle";
                            }
                        } else {
                            str = "rootLayout";
                        }
                    } else {
                        str = "ivReward";
                    }
                } else {
                    str = "contentLayout";
                }
            } else {
                str = "closeBtn";
            }
        } else {
            str = "btnConfirm";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.h;
    }
}
