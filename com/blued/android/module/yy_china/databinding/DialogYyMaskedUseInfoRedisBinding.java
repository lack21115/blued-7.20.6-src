package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogYyMaskedUseInfoRedisBinding.class */
public final class DialogYyMaskedUseInfoRedisBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16434a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f16435c;
    public final ShapeLinearLayout d;
    public final TextView e;
    public final TextView f;
    private final ConstraintLayout g;

    private DialogYyMaskedUseInfoRedisBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, ImageView imageView, ShapeLinearLayout shapeLinearLayout, TextView textView, TextView textView2) {
        this.g = constraintLayout;
        this.f16434a = shapeTextView;
        this.b = shapeTextView2;
        this.f16435c = imageView;
        this.d = shapeLinearLayout;
        this.e = textView;
        this.f = textView2;
    }

    public static DialogYyMaskedUseInfoRedisBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_cancel);
        if (shapeTextView != null) {
            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.btn_ok);
            if (shapeTextView2 != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
                if (imageView != null) {
                    ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.sha_ll);
                    if (shapeLinearLayout != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_click_next);
                        if (textView != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_mess);
                            if (textView2 != null) {
                                return new DialogYyMaskedUseInfoRedisBinding((ConstraintLayout) view, shapeTextView, shapeTextView2, imageView, shapeLinearLayout, textView, textView2);
                            }
                            str = "tvMess";
                        } else {
                            str = "tvClickNext";
                        }
                    } else {
                        str = "shaLl";
                    }
                } else {
                    str = "ivBack";
                }
            } else {
                str = "btnOk";
            }
        } else {
            str = "btnCancel";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.g;
    }
}
