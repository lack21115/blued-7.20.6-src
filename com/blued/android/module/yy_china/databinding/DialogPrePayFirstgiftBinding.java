package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogPrePayFirstgiftBinding.class */
public final class DialogPrePayFirstgiftBinding implements ViewBinding {
    public final SquareImageView a;
    public final SquareImageView b;
    public final RelativeLayout c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final ShapeTextView i;
    private final RelativeLayout j;

    private DialogPrePayFirstgiftBinding(RelativeLayout relativeLayout, SquareImageView squareImageView, SquareImageView squareImageView2, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, ShapeTextView shapeTextView) {
        this.j = relativeLayout;
        this.a = squareImageView;
        this.b = squareImageView2;
        this.c = relativeLayout2;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
        this.g = textView4;
        this.h = textView5;
        this.i = shapeTextView;
    }

    public static DialogPrePayFirstgiftBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_gift_left);
        if (squareImageView != null) {
            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.iv_gift_right);
            if (squareImageView2 != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_con);
                if (relativeLayout != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_content);
                    if (textView != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_gift_left_name);
                        if (textView2 != null) {
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_gift_left_num);
                            if (textView3 != null) {
                                TextView textView4 = (TextView) view.findViewById(R.id.tv_gift_right_name);
                                if (textView4 != null) {
                                    TextView textView5 = (TextView) view.findViewById(R.id.tv_gift_right_num);
                                    if (textView5 != null) {
                                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_pre_pay);
                                        if (shapeTextView != null) {
                                            return new DialogPrePayFirstgiftBinding((RelativeLayout) view, squareImageView, squareImageView2, relativeLayout, textView, textView2, textView3, textView4, textView5, shapeTextView);
                                        }
                                        str = "tvPrePay";
                                    } else {
                                        str = "tvGiftRightNum";
                                    }
                                } else {
                                    str = "tvGiftRightName";
                                }
                            } else {
                                str = "tvGiftLeftNum";
                            }
                        } else {
                            str = "tvGiftLeftName";
                        }
                    } else {
                        str = "tvContent";
                    }
                } else {
                    str = "rlCon";
                }
            } else {
                str = "ivGiftRight";
            }
        } else {
            str = "ivGiftLeft";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.j;
    }
}
