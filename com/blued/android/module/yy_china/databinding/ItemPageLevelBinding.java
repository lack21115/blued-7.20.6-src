package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemPageLevelBinding.class */
public final class ItemPageLevelBinding implements ViewBinding {
    public final TextView a;
    public final TextView b;
    public final TextView c;
    private final ConstraintLayout d;

    private ItemPageLevelBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        this.d = constraintLayout;
        this.a = textView;
        this.b = textView2;
        this.c = textView3;
    }

    public static ItemPageLevelBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.tv_name);
        if (textView != null) {
            TextView textView2 = (TextView) view.findViewById(R.id.tv_num);
            if (textView2 != null) {
                TextView textView3 = (TextView) view.findViewById(R.id.tv_time);
                if (textView3 != null) {
                    return new ItemPageLevelBinding((ConstraintLayout) view, textView, textView2, textView3);
                }
                str = "tvTime";
            } else {
                str = "tvNum";
            }
        } else {
            str = "tvName";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.d;
    }
}
