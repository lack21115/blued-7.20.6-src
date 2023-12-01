package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemKtvPrizeViewBinding.class */
public final class ItemKtvPrizeViewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f16624a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16625c;
    private final ConstraintLayout d;

    private ItemKtvPrizeViewBinding(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, TextView textView2) {
        this.d = constraintLayout;
        this.f16624a = textView;
        this.b = imageView;
        this.f16625c = textView2;
    }

    public static ItemKtvPrizeViewBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_ktv_prize_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ItemKtvPrizeViewBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.item_prize_count);
        if (textView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.item_prize_icon);
            if (imageView != null) {
                TextView textView2 = (TextView) view.findViewById(R.id.item_prize_name);
                if (textView2 != null) {
                    return new ItemKtvPrizeViewBinding((ConstraintLayout) view, textView, imageView, textView2);
                }
                str = "itemPrizeName";
            } else {
                str = "itemPrizeIcon";
            }
        } else {
            str = "itemPrizeCount";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.d;
    }
}
