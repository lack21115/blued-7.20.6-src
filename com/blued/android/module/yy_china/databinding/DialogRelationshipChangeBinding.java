package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogRelationshipChangeBinding.class */
public final class DialogRelationshipChangeBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16388a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f16389c;
    public final ImageView d;
    public final ShapeableImageView e;
    public final ShapeableImageView f;
    public final TextView g;
    public final TextView h;
    private final ConstraintLayout i;

    private DialogRelationshipChangeBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, ImageView imageView, ImageView imageView2, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, TextView textView, TextView textView2) {
        this.i = constraintLayout;
        this.f16388a = shapeTextView;
        this.b = shapeTextView2;
        this.f16389c = imageView;
        this.d = imageView2;
        this.e = shapeableImageView;
        this.f = shapeableImageView2;
        this.g = textView;
        this.h = textView2;
    }

    public static DialogRelationshipChangeBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_cancle);
        if (shapeTextView != null) {
            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.btn_hint);
            if (shapeTextView2 != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_back);
                    if (imageView2 != null) {
                        ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.iv_user_1);
                        if (shapeableImageView != null) {
                            ShapeableImageView shapeableImageView2 = (ShapeableImageView) view.findViewById(R.id.iv_user_2);
                            if (shapeableImageView2 != null) {
                                TextView textView = (TextView) view.findViewById(R.id.tv_type);
                                if (textView != null) {
                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_type_info);
                                    if (textView2 != null) {
                                        return new DialogRelationshipChangeBinding((ConstraintLayout) view, shapeTextView, shapeTextView2, imageView, imageView2, shapeableImageView, shapeableImageView2, textView, textView2);
                                    }
                                    str = "tvTypeInfo";
                                } else {
                                    str = "tvType";
                                }
                            } else {
                                str = "ivUser2";
                            }
                        } else {
                            str = "ivUser1";
                        }
                    } else {
                        str = "ivBack";
                    }
                } else {
                    str = "iv";
                }
            } else {
                str = "btnHint";
            }
        } else {
            str = "btnCancle";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.i;
    }
}
