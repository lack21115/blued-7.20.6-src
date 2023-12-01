package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.SlopeLoadingView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLiveGoodsWallTaskBinding.class */
public final class DialogLiveGoodsWallTaskBinding implements ViewBinding {
    public final ImageView a;
    public final SlopeLoadingView b;
    public final RecyclerView c;
    public final TextView d;
    public final View e;
    public final View f;
    private final ConstraintLayout g;

    private DialogLiveGoodsWallTaskBinding(ConstraintLayout constraintLayout, ImageView imageView, SlopeLoadingView slopeLoadingView, RecyclerView recyclerView, TextView textView, View view, View view2) {
        this.g = constraintLayout;
        this.a = imageView;
        this.b = slopeLoadingView;
        this.c = recyclerView;
        this.d = textView;
        this.e = view;
        this.f = view2;
    }

    public static DialogLiveGoodsWallTaskBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogLiveGoodsWallTaskBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_goods_wall_task, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLiveGoodsWallTaskBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
        if (imageView != null) {
            SlopeLoadingView slopeLoadingView = (SlopeLoadingView) view.findViewById(R.id.loading);
            if (slopeLoadingView != null) {
                RecyclerView findViewById = view.findViewById(R.id.rv_list);
                if (findViewById != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_title);
                    if (textView != null) {
                        View findViewById2 = view.findViewById(R.id.view_line);
                        if (findViewById2 != null) {
                            View findViewById3 = view.findViewById(R.id.view_top_bg);
                            if (findViewById3 != null) {
                                return new DialogLiveGoodsWallTaskBinding((ConstraintLayout) view, imageView, slopeLoadingView, findViewById, textView, findViewById2, findViewById3);
                            }
                            str = "viewTopBg";
                        } else {
                            str = "viewLine";
                        }
                    } else {
                        str = "tvTitle";
                    }
                } else {
                    str = "rvList";
                }
            } else {
                str = "loading";
            }
        } else {
            str = "ivClose";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.g;
    }
}
