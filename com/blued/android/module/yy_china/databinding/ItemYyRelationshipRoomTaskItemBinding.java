package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyRelationshipRoomTaskItemBinding.class */
public final class ItemYyRelationshipRoomTaskItemBinding implements ViewBinding {
    public final ShapeTextView a;
    public final ConstraintLayout b;
    public final SquareImageView c;
    public final ShapeTextView d;
    public final TextView e;
    public final TextView f;
    private final ConstraintLayout g;

    private ItemYyRelationshipRoomTaskItemBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, ConstraintLayout constraintLayout2, SquareImageView squareImageView, ShapeTextView shapeTextView2, TextView textView, TextView textView2) {
        this.g = constraintLayout;
        this.a = shapeTextView;
        this.b = constraintLayout2;
        this.c = squareImageView;
        this.d = shapeTextView2;
        this.e = textView;
        this.f = textView2;
    }

    public static ItemYyRelationshipRoomTaskItemBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_do);
        if (shapeTextView != null) {
            ConstraintLayout findViewById = view.findViewById(R.id.con_bg);
            if (findViewById != null) {
                SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv);
                if (squareImageView != null) {
                    ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.iv_bott);
                    if (shapeTextView2 != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_mess);
                        if (textView != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_name);
                            if (textView2 != null) {
                                return new ItemYyRelationshipRoomTaskItemBinding((ConstraintLayout) view, shapeTextView, findViewById, squareImageView, shapeTextView2, textView, textView2);
                            }
                            str = "tvName";
                        } else {
                            str = "tvMess";
                        }
                    } else {
                        str = "ivBott";
                    }
                } else {
                    str = "iv";
                }
            } else {
                str = "conBg";
            }
        } else {
            str = "btnDo";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.g;
    }
}
