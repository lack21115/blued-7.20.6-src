package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyFirstMeetItemBinding.class */
public final class ItemYyFirstMeetItemBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final SquareImageView f16714a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    private final ConstraintLayout f16715c;

    private ItemYyFirstMeetItemBinding(ConstraintLayout constraintLayout, SquareImageView squareImageView, TextView textView) {
        this.f16715c = constraintLayout;
        this.f16714a = squareImageView;
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f16715c;
    }
}
