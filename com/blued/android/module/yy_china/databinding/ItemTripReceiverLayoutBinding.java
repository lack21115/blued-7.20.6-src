package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemTripReceiverLayoutBinding.class */
public final class ItemTripReceiverLayoutBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final ConstraintLayout c;
    public final CardView d;
    public final TextView e;
    private final ConstraintLayout f;

    private ItemTripReceiverLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, CardView cardView, TextView textView) {
        this.f = constraintLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = constraintLayout2;
        this.d = cardView;
        this.e = textView;
    }

    public static ItemTripReceiverLayoutBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_checked_symbol);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.img_receiver_portrait);
            if (imageView2 != null) {
                ConstraintLayout findViewById = view.findViewById(R.id.item_root_view);
                if (findViewById != null) {
                    CardView findViewById2 = view.findViewById(R.id.ll_portrait_layout);
                    if (findViewById2 != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_role_text);
                        if (textView != null) {
                            return new ItemTripReceiverLayoutBinding((ConstraintLayout) view, imageView, imageView2, findViewById, findViewById2, textView);
                        }
                        str = "tvRoleText";
                    } else {
                        str = "llPortraitLayout";
                    }
                } else {
                    str = "itemRootView";
                }
            } else {
                str = "imgReceiverPortrait";
            }
        } else {
            str = "imgCheckedSymbol";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
