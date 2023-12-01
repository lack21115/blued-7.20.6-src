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

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16555a;
    public final RecyclerView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16556c;
    private final ConstraintLayout d;

    private GiftExhibitionPageAllBinding(ConstraintLayout constraintLayout, ImageView imageView, RecyclerView recyclerView, TextView textView) {
        this.d = constraintLayout;
        this.f16555a = imageView;
        this.b = recyclerView;
        this.f16556c = textView;
    }

    public static GiftExhibitionPageAllBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_empty);
        if (imageView != null) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_gift_list);
            if (recyclerView != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_empty_text);
                if (textView != null) {
                    return new GiftExhibitionPageAllBinding((ConstraintLayout) view, imageView, recyclerView, textView);
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.d;
    }
}
