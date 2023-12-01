package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYLivingStreamView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemConfessedRankItemBinding.class */
public final class ItemConfessedRankItemBinding implements ViewBinding {
    public final SquareImageView a;
    public final SquareImageView b;
    public final SquareImageView c;
    public final YYLivingStreamView d;
    public final YYLivingStreamView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    private final ConstraintLayout i;

    private ItemConfessedRankItemBinding(ConstraintLayout constraintLayout, SquareImageView squareImageView, SquareImageView squareImageView2, SquareImageView squareImageView3, YYLivingStreamView yYLivingStreamView, YYLivingStreamView yYLivingStreamView2, TextView textView, TextView textView2, TextView textView3) {
        this.i = constraintLayout;
        this.a = squareImageView;
        this.b = squareImageView2;
        this.c = squareImageView3;
        this.d = yYLivingStreamView;
        this.e = yYLivingStreamView2;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
    }

    public static ItemConfessedRankItemBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_index);
        if (squareImageView != null) {
            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.iv_user_1);
            if (squareImageView2 != null) {
                SquareImageView squareImageView3 = (SquareImageView) view.findViewById(R.id.iv_user_2);
                if (squareImageView3 != null) {
                    YYLivingStreamView yYLivingStreamView = (YYLivingStreamView) view.findViewById(R.id.live_1);
                    if (yYLivingStreamView != null) {
                        YYLivingStreamView yYLivingStreamView2 = (YYLivingStreamView) view.findViewById(R.id.live_2);
                        if (yYLivingStreamView2 != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_index);
                            if (textView != null) {
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_num);
                                if (textView2 != null) {
                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_num_need);
                                    if (textView3 != null) {
                                        return new ItemConfessedRankItemBinding((ConstraintLayout) view, squareImageView, squareImageView2, squareImageView3, yYLivingStreamView, yYLivingStreamView2, textView, textView2, textView3);
                                    }
                                    str = "tvNumNeed";
                                } else {
                                    str = "tvNum";
                                }
                            } else {
                                str = "tvIndex";
                            }
                        } else {
                            str = "live2";
                        }
                    } else {
                        str = "live1";
                    }
                } else {
                    str = "ivUser2";
                }
            } else {
                str = "ivUser1";
            }
        } else {
            str = "ivIndex";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.i;
    }
}
