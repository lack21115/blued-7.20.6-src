package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyPopularLayoutBinding.class */
public final class ItemYyPopularLayoutBinding implements ViewBinding {
    public final ImageView a;
    public final ConstraintLayout b;
    public final RecyclerView c;
    public final TextView d;
    private final ConstraintLayout e;

    private ItemYyPopularLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, RecyclerView recyclerView, TextView textView) {
        this.e = constraintLayout;
        this.a = imageView;
        this.b = constraintLayout2;
        this.c = recyclerView;
        this.d = textView;
    }

    public static ItemYyPopularLayoutBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_entertainment);
        if (imageView != null) {
            ConstraintLayout findViewById = view.findViewById(R.id.ll_title);
            if (findViewById != null) {
                RecyclerView findViewById2 = view.findViewById(R.id.rv_popular_list);
                if (findViewById2 != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_popular_title);
                    if (textView != null) {
                        return new ItemYyPopularLayoutBinding((ConstraintLayout) view, imageView, findViewById, findViewById2, textView);
                    }
                    str = "tvPopularTitle";
                } else {
                    str = "rvPopularList";
                }
            } else {
                str = "llTitle";
            }
        } else {
            str = "imgEntertainment";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
