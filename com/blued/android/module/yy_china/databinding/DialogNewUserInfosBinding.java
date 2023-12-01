package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogNewUserInfosBinding.class */
public final class DialogNewUserInfosBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16372a;
    private final ConstraintLayout b;

    private DialogNewUserInfosBinding(ConstraintLayout constraintLayout, ImageView imageView) {
        this.b = constraintLayout;
        this.f16372a = imageView;
    }

    public static DialogNewUserInfosBinding a(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
        if (imageView != null) {
            return new DialogNewUserInfosBinding((ConstraintLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("ivClose"));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.b;
    }
}
