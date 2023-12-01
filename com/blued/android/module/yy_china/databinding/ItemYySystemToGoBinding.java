package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYySystemToGoBinding.class */
public final class ItemYySystemToGoBinding implements ViewBinding {
    public final ShapeTextView a;
    public final TextView b;
    private final ConstraintLayout c;

    private ItemYySystemToGoBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, TextView textView) {
        this.c = constraintLayout;
        this.a = shapeTextView;
        this.b = textView;
    }

    public static ItemYySystemToGoBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_go);
        if (shapeTextView != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_msg_content);
            if (textView != null) {
                return new ItemYySystemToGoBinding((ConstraintLayout) view, shapeTextView, textView);
            }
            str = "tvMsgContent";
        } else {
            str = "btnGo";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.c;
    }
}
