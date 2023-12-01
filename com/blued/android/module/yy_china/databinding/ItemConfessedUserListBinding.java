package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemConfessedUserListBinding.class */
public final class ItemConfessedUserListBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16580a;
    public final ShapeableImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16581c;
    public final TextView d;
    private final ConstraintLayout e;

    private ItemConfessedUserListBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, ShapeableImageView shapeableImageView, TextView textView, TextView textView2) {
        this.e = constraintLayout;
        this.f16580a = shapeTextView;
        this.b = shapeableImageView;
        this.f16581c = textView;
        this.d = textView2;
    }

    public static ItemConfessedUserListBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_selcet);
        if (shapeTextView != null) {
            ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.iv_user);
            if (shapeableImageView != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_mess);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_name);
                    if (textView2 != null) {
                        return new ItemConfessedUserListBinding((ConstraintLayout) view, shapeTextView, shapeableImageView, textView, textView2);
                    }
                    str = "tvName";
                } else {
                    str = "tvMess";
                }
            } else {
                str = "ivUser";
            }
        } else {
            str = "btnSelcet";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
