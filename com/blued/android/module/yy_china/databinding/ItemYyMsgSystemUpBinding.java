package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyMsgSystemUpBinding.class */
public final class ItemYyMsgSystemUpBinding implements ViewBinding {
    public final TextView a;
    private final LinearLayout b;

    private ItemYyMsgSystemUpBinding(LinearLayout linearLayout, TextView textView) {
        this.b = linearLayout;
        this.a = textView;
    }

    public static ItemYyMsgSystemUpBinding a(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_msg_content);
        if (textView != null) {
            return new ItemYyMsgSystemUpBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("tvMsgContent"));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.b;
    }
}
