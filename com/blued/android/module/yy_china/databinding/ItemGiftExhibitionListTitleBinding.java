package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemGiftExhibitionListTitleBinding.class */
public final class ItemGiftExhibitionListTitleBinding implements ViewBinding {
    public final TextView a;
    public final TextView b;
    private final ConstraintLayout c;

    private ItemGiftExhibitionListTitleBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.c = constraintLayout;
        this.a = textView;
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

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.c;
    }
}
