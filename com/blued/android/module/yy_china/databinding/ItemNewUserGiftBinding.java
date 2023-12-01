package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemNewUserGiftBinding.class */
public final class ItemNewUserGiftBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final SquareImageView f16632a;
    public final SquareImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeConstraintLayout f16633c;
    public final TextView d;
    public final ShapeTextView e;
    public final ShapeTextView f;
    private final ConstraintLayout g;

    private ItemNewUserGiftBinding(ConstraintLayout constraintLayout, SquareImageView squareImageView, SquareImageView squareImageView2, ShapeConstraintLayout shapeConstraintLayout, TextView textView, ShapeTextView shapeTextView, ShapeTextView shapeTextView2) {
        this.g = constraintLayout;
        this.f16632a = squareImageView;
        this.b = squareImageView2;
        this.f16633c = shapeConstraintLayout;
        this.d = textView;
        this.e = shapeTextView;
        this.f = shapeTextView2;
    }

    public static ItemNewUserGiftBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv);
        if (squareImageView != null) {
            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.iv_type);
            if (squareImageView2 != null) {
                ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.rl);
                if (shapeConstraintLayout != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_name);
                    if (textView != null) {
                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_num);
                        if (shapeTextView != null) {
                            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_ti);
                            if (shapeTextView2 != null) {
                                return new ItemNewUserGiftBinding((ConstraintLayout) view, squareImageView, squareImageView2, shapeConstraintLayout, textView, shapeTextView, shapeTextView2);
                            }
                            str = "tvTi";
                        } else {
                            str = "tvNum";
                        }
                    } else {
                        str = "tvName";
                    }
                } else {
                    str = "rl";
                }
            } else {
                str = "ivType";
            }
        } else {
            str = "iv";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.g;
    }
}
