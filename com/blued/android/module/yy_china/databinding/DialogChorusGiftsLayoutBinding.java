package com.blued.android.module.yy_china.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogChorusGiftsLayoutBinding.class */
public final class DialogChorusGiftsLayoutBinding implements ViewBinding {
    public final ShapeTextView a;
    public final View b;
    public final RecyclerView c;
    private final ConstraintLayout d;

    private DialogChorusGiftsLayoutBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, View view, RecyclerView recyclerView) {
        this.d = constraintLayout;
        this.a = shapeTextView;
        this.b = view;
        this.c = recyclerView;
    }

    public static DialogChorusGiftsLayoutBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_pay);
        if (shapeTextView != null) {
            View findViewById = view.findViewById(R.id.cover_view);
            if (findViewById != null) {
                RecyclerView findViewById2 = view.findViewById(R.id.rv_gift_list);
                if (findViewById2 != null) {
                    return new DialogChorusGiftsLayoutBinding((ConstraintLayout) view, shapeTextView, findViewById, findViewById2);
                }
                str = "rvGiftList";
            } else {
                str = "coverView";
            }
        } else {
            str = "btnPay";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.d;
    }
}
