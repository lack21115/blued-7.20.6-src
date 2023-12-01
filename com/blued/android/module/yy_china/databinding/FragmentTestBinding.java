package com.blued.android.module.yy_china.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentTestBinding.class */
public final class FragmentTestBinding implements ViewBinding {
    public final ShapeTextView a;
    public final ShapeTextView b;
    private final ConstraintLayout c;

    private FragmentTestBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, ShapeTextView shapeTextView2) {
        this.c = constraintLayout;
        this.a = shapeTextView;
        this.b = shapeTextView2;
    }

    public static FragmentTestBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_join);
        if (shapeTextView != null) {
            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_log_out);
            if (shapeTextView2 != null) {
                return new FragmentTestBinding((ConstraintLayout) view, shapeTextView, shapeTextView2);
            }
            str = "tvLogOut";
        } else {
            str = "tvJoin";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.c;
    }
}
