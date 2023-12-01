package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogNewUserInfosBinding.class */
public final class DialogNewUserInfosBinding implements ViewBinding {
    public final ImageView a;
    private final ConstraintLayout b;

    private DialogNewUserInfosBinding(ConstraintLayout constraintLayout, ImageView imageView) {
        this.b = constraintLayout;
        this.a = imageView;
    }

    public static DialogNewUserInfosBinding a(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
        if (imageView != null) {
            return new DialogNewUserInfosBinding((ConstraintLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("ivClose"));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.b;
    }
}
