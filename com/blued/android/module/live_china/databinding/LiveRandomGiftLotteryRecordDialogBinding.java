package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.module.common.view.SlopeLoadingView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveRandomGiftLotteryRecordDialogBinding.class */
public final class LiveRandomGiftLotteryRecordDialogBinding implements ViewBinding {
    public final ShapeFrameLayout a;
    public final ImageView b;
    public final SlopeLoadingView c;
    public final RelativeLayout d;
    public final RecyclerView e;
    public final TextView f;
    private final FrameLayout g;

    private LiveRandomGiftLotteryRecordDialogBinding(FrameLayout frameLayout, ShapeFrameLayout shapeFrameLayout, ImageView imageView, SlopeLoadingView slopeLoadingView, RelativeLayout relativeLayout, RecyclerView recyclerView, TextView textView) {
        this.g = frameLayout;
        this.a = shapeFrameLayout;
        this.b = imageView;
        this.c = slopeLoadingView;
        this.d = relativeLayout;
        this.e = recyclerView;
        this.f = textView;
    }

    public static LiveRandomGiftLotteryRecordDialogBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static LiveRandomGiftLotteryRecordDialogBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_random_gift_lottery_record_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveRandomGiftLotteryRecordDialogBinding a(View view) {
        String str;
        ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.fl_root);
        if (shapeFrameLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
            if (imageView != null) {
                SlopeLoadingView slopeLoadingView = (SlopeLoadingView) view.findViewById(R.id.loading);
                if (slopeLoadingView != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_empty);
                    if (relativeLayout != null) {
                        RecyclerView findViewById = view.findViewById(R.id.rv_list);
                        if (findViewById != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_desc);
                            if (textView != null) {
                                return new LiveRandomGiftLotteryRecordDialogBinding((FrameLayout) view, shapeFrameLayout, imageView, slopeLoadingView, relativeLayout, findViewById, textView);
                            }
                            str = "tvDesc";
                        } else {
                            str = "rvList";
                        }
                    } else {
                        str = "rlEmpty";
                    }
                } else {
                    str = "loading";
                }
            } else {
                str = "ivClose";
            }
        } else {
            str = "flRoot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.g;
    }
}
