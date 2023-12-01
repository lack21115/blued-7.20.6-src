package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogYyTaskRewardBinding.class */
public final class DialogYyTaskRewardBinding implements ViewBinding {
    public final View a;
    public final ImageView b;
    public final RecyclerView c;
    public final TextView d;
    public final TextView e;
    private final FrameLayout f;

    private DialogYyTaskRewardBinding(FrameLayout frameLayout, View view, ImageView imageView, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.f = frameLayout;
        this.a = view;
        this.b = imageView;
        this.c = recyclerView;
        this.d = textView;
        this.e = textView2;
    }

    public static DialogYyTaskRewardBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_yy_task_reward, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogYyTaskRewardBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.conver_view);
        if (findViewById != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.img_close);
            if (imageView != null) {
                RecyclerView findViewById2 = view.findViewById(R.id.rv_prize_list);
                if (findViewById2 != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_dialog_title);
                    if (textView != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_explain_prize);
                        if (textView2 != null) {
                            return new DialogYyTaskRewardBinding((FrameLayout) view, findViewById, imageView, findViewById2, textView, textView2);
                        }
                        str = "tvExplainPrize";
                    } else {
                        str = "tvDialogTitle";
                    }
                } else {
                    str = "rvPrizeList";
                }
            } else {
                str = "imgClose";
            }
        } else {
            str = "converView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.f;
    }
}
