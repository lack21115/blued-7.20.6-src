package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogRelationshipInvitedBinding.class */
public final class DialogRelationshipInvitedBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16390a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f16391c;
    public final SquareImageView d;
    public final ShapeableImageView e;
    public final ShapeableImageView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    private final ConstraintLayout j;

    private DialogRelationshipInvitedBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, ImageView imageView, SquareImageView squareImageView, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, TextView textView, TextView textView2, TextView textView3) {
        this.j = constraintLayout;
        this.f16390a = shapeTextView;
        this.b = shapeTextView2;
        this.f16391c = imageView;
        this.d = squareImageView;
        this.e = shapeableImageView;
        this.f = shapeableImageView2;
        this.g = textView;
        this.h = textView2;
        this.i = textView3;
    }

    public static DialogRelationshipInvitedBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_cancle);
        if (shapeTextView != null) {
            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.btn_hint);
            if (shapeTextView2 != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
                if (imageView != null) {
                    SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_gift);
                    if (squareImageView != null) {
                        ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.iv_user_1);
                        if (shapeableImageView != null) {
                            ShapeableImageView shapeableImageView2 = (ShapeableImageView) view.findViewById(R.id.iv_user_2);
                            if (shapeableImageView2 != null) {
                                TextView textView = (TextView) view.findViewById(R.id.tv_beans);
                                if (textView != null) {
                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_type);
                                    if (textView2 != null) {
                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_type_info);
                                        if (textView3 != null) {
                                            return new DialogRelationshipInvitedBinding((ConstraintLayout) view, shapeTextView, shapeTextView2, imageView, squareImageView, shapeableImageView, shapeableImageView2, textView, textView2, textView3);
                                        }
                                        str = "tvTypeInfo";
                                    } else {
                                        str = "tvType";
                                    }
                                } else {
                                    str = "tvBeans";
                                }
                            } else {
                                str = "ivUser2";
                            }
                        } else {
                            str = "ivUser1";
                        }
                    } else {
                        str = "ivGift";
                    }
                } else {
                    str = "ivBack";
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
        return this.j;
    }
}
