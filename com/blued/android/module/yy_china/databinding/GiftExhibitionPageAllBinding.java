package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/GiftExhibitionPageAllBinding.class */
public final class GiftExhibitionPageAllBinding implements ViewBinding {
    public final ImageView a;
    public final RecyclerView b;
    public final TextView c;
    private final ConstraintLayout d;

    private GiftExhibitionPageAllBinding(ConstraintLayout constraintLayout, ImageView imageView, RecyclerView recyclerView, TextView textView) {
        this.d = constraintLayout;
        this.a = imageView;
        this.b = recyclerView;
        this.c = textView;
    }

    public static GiftExhibitionPageAllBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_empty);
        if (imageView != null) {
            RecyclerView findViewById = view.findViewById(R.id.rv_gift_list);
            if (findViewById != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_empty_text);
                if (textView != null) {
                    return new GiftExhibitionPageAllBinding((ConstraintLayout) view, imageView, findViewById, textView);
                }
                str = "tvEmptyText";
            } else {
                str = "rvGiftList";
            }
        } else {
            str = "imgEmpty";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.d;
    }
}
