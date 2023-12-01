package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemRelationshipToInviteGiftBinding.class */
public final class ItemRelationshipToInviteGiftBinding implements ViewBinding {
    public final SquareImageView a;
    public final LinearLayout b;
    public final TextView c;
    public final TextView d;
    private final ConstraintLayout e;

    private ItemRelationshipToInviteGiftBinding(ConstraintLayout constraintLayout, SquareImageView squareImageView, LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.e = constraintLayout;
        this.a = squareImageView;
        this.b = linearLayout;
        this.c = textView;
        this.d = textView2;
    }

    public static ItemRelationshipToInviteGiftBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv);
        if (squareImageView != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll);
            if (linearLayout != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_bean);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_name);
                    if (textView2 != null) {
                        return new ItemRelationshipToInviteGiftBinding((ConstraintLayout) view, squareImageView, linearLayout, textView, textView2);
                    }
                    str = "tvName";
                } else {
                    str = "tvBean";
                }
            } else {
                str = "ll";
            }
        } else {
            str = "iv";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
