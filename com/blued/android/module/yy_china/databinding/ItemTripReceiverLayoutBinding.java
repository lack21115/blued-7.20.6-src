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

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16670a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f16671c;
    public final CardView d;
    public final TextView e;
    private final ConstraintLayout f;

    private ItemTripReceiverLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, CardView cardView, TextView textView) {
        this.f = constraintLayout;
        this.f16670a = imageView;
        this.b = imageView2;
        this.f16671c = constraintLayout2;
        this.d = cardView;
        this.e = textView;
    }

    public static ItemTripReceiverLayoutBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_checked_symbol);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.img_receiver_portrait);
            if (imageView2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.item_root_view);
                if (constraintLayout != null) {
                    CardView cardView = (CardView) view.findViewById(R.id.ll_portrait_layout);
                    if (cardView != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_role_text);
                        if (textView != null) {
                            return new ItemTripReceiverLayoutBinding((ConstraintLayout) view, imageView, imageView2, constraintLayout, cardView, textView);
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
