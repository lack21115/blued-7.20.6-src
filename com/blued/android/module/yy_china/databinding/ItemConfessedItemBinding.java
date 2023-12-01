package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYLivingStreamView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemConfessedItemBinding.class */
public final class ItemConfessedItemBinding implements ViewBinding {
    public final SquareImageView a;
    public final SquareImageView b;
    public final YYLivingStreamView c;
    public final YYLivingStreamView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    private final ConstraintLayout h;

    private ItemConfessedItemBinding(ConstraintLayout constraintLayout, SquareImageView squareImageView, SquareImageView squareImageView2, YYLivingStreamView yYLivingStreamView, YYLivingStreamView yYLivingStreamView2, TextView textView, TextView textView2, TextView textView3) {
        this.h = constraintLayout;
        this.a = squareImageView;
        this.b = squareImageView2;
        this.c = yYLivingStreamView;
        this.d = yYLivingStreamView2;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
    }

    public static ItemConfessedItemBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_user_1);
        if (squareImageView != null) {
            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.iv_user_2);
            if (squareImageView2 != null) {
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
                                    return new ItemConfessedItemBinding((ConstraintLayout) view, squareImageView, squareImageView2, yYLivingStreamView, yYLivingStreamView2, textView, textView2, textView3);
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
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.h;
    }
}
