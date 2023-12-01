package com.blued.android.module.yy_china.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogChorusGiftsLayoutBinding.class */
public final class DialogChorusGiftsLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16305a;
    public final View b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f16306c;
    private final ConstraintLayout d;

    private DialogChorusGiftsLayoutBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, View view, RecyclerView recyclerView) {
        this.d = constraintLayout;
        this.f16305a = shapeTextView;
        this.b = view;
        this.f16306c = recyclerView;
    }

    public static DialogChorusGiftsLayoutBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_pay);
        if (shapeTextView != null) {
            View findViewById = view.findViewById(R.id.cover_view);
            if (findViewById != null) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_gift_list);
                if (recyclerView != null) {
                    return new DialogChorusGiftsLayoutBinding((ConstraintLayout) view, shapeTextView, findViewById, recyclerView);
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.d;
    }
}
