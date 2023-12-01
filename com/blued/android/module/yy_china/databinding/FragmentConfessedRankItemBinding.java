package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentConfessedRankItemBinding.class */
public final class FragmentConfessedRankItemBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f16472a;
    public final SquareImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f16473c;
    public final RecyclerView d;
    public final TextView e;
    private final ConstraintLayout f;

    private FragmentConfessedRankItemBinding(ConstraintLayout constraintLayout, TextView textView, SquareImageView squareImageView, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView2) {
        this.f = constraintLayout;
        this.f16472a = textView;
        this.b = squareImageView;
        this.f16473c = linearLayout;
        this.d = recyclerView;
        this.e = textView2;
    }

    public static FragmentConfessedRankItemBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.btn_to_confeefed_null);
        if (textView != null) {
            SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_null);
            if (squareImageView != null) {
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_null);
                if (linearLayout != null) {
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rec);
                    if (recyclerView != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_mess);
                        if (textView2 != null) {
                            return new FragmentConfessedRankItemBinding((ConstraintLayout) view, textView, squareImageView, linearLayout, recyclerView, textView2);
                        }
                        str = "tvMess";
                    } else {
                        str = "rec";
                    }
                } else {
                    str = "llNull";
                }
            } else {
                str = "ivNull";
            }
        } else {
            str = "btnToConfeefedNull";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
