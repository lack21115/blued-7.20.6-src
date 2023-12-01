package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyFirstMeetItemBinding.class */
public final class ItemYyFirstMeetItemBinding implements ViewBinding {
    public final SquareImageView a;
    public final TextView b;
    private final ConstraintLayout c;

    private ItemYyFirstMeetItemBinding(ConstraintLayout constraintLayout, SquareImageView squareImageView, TextView textView) {
        this.c = constraintLayout;
        this.a = squareImageView;
        this.b = textView;
    }

    public static ItemYyFirstMeetItemBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_user);
        if (squareImageView != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_mess);
            if (textView != null) {
                return new ItemYyFirstMeetItemBinding((ConstraintLayout) view, squareImageView, textView);
            }
            str = "tvMess";
        } else {
            str = "ivUser";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.c;
    }
}
