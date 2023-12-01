package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemGiftExhibitionListTitleBinding.class */
public final class ItemGiftExhibitionListTitleBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f16600a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    private final ConstraintLayout f16601c;

    private ItemGiftExhibitionListTitleBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.f16601c = constraintLayout;
        this.f16600a = textView;
        this.b = textView2;
    }

    public static ItemGiftExhibitionListTitleBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.tv_sub_title_name);
        if (textView != null) {
            TextView textView2 = (TextView) view.findViewById(R.id.tv_title_name);
            if (textView2 != null) {
                return new ItemGiftExhibitionListTitleBinding((ConstraintLayout) view, textView, textView2);
            }
            str = "tvTitleName";
        } else {
            str = "tvSubTitleName";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f16601c;
    }
}
