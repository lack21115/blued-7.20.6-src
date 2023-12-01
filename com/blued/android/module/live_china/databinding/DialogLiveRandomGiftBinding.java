package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLiveRandomGiftBinding.class */
public final class DialogLiveRandomGiftBinding implements ViewBinding {
    public final ImageView a;
    public final RelativeLayout b;
    public final RecyclerView c;
    public final View d;
    public final ShapeTextView e;
    private final FrameLayout f;

    private DialogLiveRandomGiftBinding(FrameLayout frameLayout, ImageView imageView, RelativeLayout relativeLayout, RecyclerView recyclerView, View view, ShapeTextView shapeTextView) {
        this.f = frameLayout;
        this.a = imageView;
        this.b = relativeLayout;
        this.c = recyclerView;
        this.d = view;
        this.e = shapeTextView;
    }

    public static DialogLiveRandomGiftBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogLiveRandomGiftBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_random_gift, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLiveRandomGiftBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_info);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_draw_lottery_float);
            if (relativeLayout != null) {
                RecyclerView findViewById = view.findViewById(R.id.rv_list);
                if (findViewById != null) {
                    View findViewById2 = view.findViewById(R.id.top_padding);
                    if (findViewById2 != null) {
                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_draw_lottery);
                        if (shapeTextView != null) {
                            return new DialogLiveRandomGiftBinding((FrameLayout) view, imageView, relativeLayout, findViewById, findViewById2, shapeTextView);
                        }
                        str = "tvDrawLottery";
                    } else {
                        str = "topPadding";
                    }
                } else {
                    str = "rvList";
                }
            } else {
                str = "rlDrawLotteryFloat";
            }
        } else {
            str = "ivInfo";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.f;
    }
}
