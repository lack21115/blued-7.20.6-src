package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemConfessedMessBinding.class */
public final class ItemConfessedMessBinding implements ViewBinding {
    public final TextView a;
    private final ConstraintLayout b;

    private ItemConfessedMessBinding(ConstraintLayout constraintLayout, TextView textView) {
        this.b = constraintLayout;
        this.a = textView;
    }

    public static ItemConfessedMessBinding a(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_mess);
        if (textView != null) {
            return new ItemConfessedMessBinding((ConstraintLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("tvMess"));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.b;
    }
}
