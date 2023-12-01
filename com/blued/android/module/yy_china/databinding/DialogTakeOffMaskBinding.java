package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogTakeOffMaskBinding.class */
public final class DialogTakeOffMaskBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f16417a;
    public final ShapeConstraintLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f16418c;
    public final ShapeTextView d;
    public final TextView e;
    public final TextView f;
    private final ConstraintLayout g;

    private DialogTakeOffMaskBinding(ConstraintLayout constraintLayout, View view, ShapeConstraintLayout shapeConstraintLayout, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, TextView textView, TextView textView2) {
        this.g = constraintLayout;
        this.f16417a = view;
        this.b = shapeConstraintLayout;
        this.f16418c = shapeTextView;
        this.d = shapeTextView2;
        this.e = textView;
        this.f = textView2;
    }

    public static DialogTakeOffMaskBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.cover_view);
        if (findViewById != null) {
            ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.dialog_background_layout);
            if (shapeConstraintLayout != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.dialog_btn_cancel);
                if (shapeTextView != null) {
                    ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.dialog_btn_confirm);
                    if (shapeTextView2 != null) {
                        TextView textView = (TextView) view.findViewById(R.id.dialog_content_view);
                        if (textView != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.dialog_title_view);
                            if (textView2 != null) {
                                return new DialogTakeOffMaskBinding((ConstraintLayout) view, findViewById, shapeConstraintLayout, shapeTextView, shapeTextView2, textView, textView2);
                            }
                            str = "dialogTitleView";
                        } else {
                            str = "dialogContentView";
                        }
                    } else {
                        str = "dialogBtnConfirm";
                    }
                } else {
                    str = "dialogBtnCancel";
                }
            } else {
                str = "dialogBackgroundLayout";
            }
        } else {
            str = "coverView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.g;
    }
}
