package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyRelationTabViewBinding.class */
public final class ItemYyRelationTabViewBinding implements ViewBinding {
    public final ImageView a;
    public final TextView b;
    private final ConstraintLayout c;

    private ItemYyRelationTabViewBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        this.c = constraintLayout;
        this.a = imageView;
        this.b = textView;
    }

    public static ItemYyRelationTabViewBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_top_name);
        if (imageView != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_top_name);
            if (textView != null) {
                return new ItemYyRelationTabViewBinding((ConstraintLayout) view, imageView, textView);
            }
            str = "tvTopName";
        } else {
            str = "ivTopName";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.c;
    }
}
