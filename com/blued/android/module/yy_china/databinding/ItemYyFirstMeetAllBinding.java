package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyFirstMeetAllBinding.class */
public final class ItemYyFirstMeetAllBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final SquareImageView f16709a;
    public final SquareImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f16710c;
    public final TextView d;
    private final ConstraintLayout e;

    private ItemYyFirstMeetAllBinding(ConstraintLayout constraintLayout, SquareImageView squareImageView, SquareImageView squareImageView2, RecyclerView recyclerView, TextView textView) {
        this.e = constraintLayout;
        this.f16709a = squareImageView;
        this.b = squareImageView2;
        this.f16710c = recyclerView;
        this.d = textView;
    }

    public static ItemYyFirstMeetAllBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_smeel);
        if (squareImageView != null) {
            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.iv_user);
            if (squareImageView2 != null) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcv);
                if (recyclerView != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_mess);
                    if (textView != null) {
                        return new ItemYyFirstMeetAllBinding((ConstraintLayout) view, squareImageView, squareImageView2, recyclerView, textView);
                    }
                    str = "tvMess";
                } else {
                    str = "rcv";
                }
            } else {
                str = "ivUser";
            }
        } else {
            str = "ivSmeel";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
