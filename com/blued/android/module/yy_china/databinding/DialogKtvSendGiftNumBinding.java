package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogKtvSendGiftNumBinding.class */
public final class DialogKtvSendGiftNumBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final SquareImageView f16359a;
    public final LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f16360c;
    public final ShapeTextView d;
    public final ShapeTextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    private final ShapeConstraintLayout j;

    private DialogKtvSendGiftNumBinding(ShapeConstraintLayout shapeConstraintLayout, SquareImageView squareImageView, LinearLayout linearLayout, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, ShapeTextView shapeTextView3, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.j = shapeConstraintLayout;
        this.f16359a = squareImageView;
        this.b = linearLayout;
        this.f16360c = shapeTextView;
        this.d = shapeTextView2;
        this.e = shapeTextView3;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.i = textView4;
    }

    public static DialogKtvSendGiftNumBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_gift);
        if (squareImageView != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll);
            if (linearLayout != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_click_1);
                if (shapeTextView != null) {
                    ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_click_2);
                    if (shapeTextView2 != null) {
                        ShapeTextView shapeTextView3 = (ShapeTextView) view.findViewById(R.id.tv_click_3);
                        if (shapeTextView3 != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_cont);
                            if (textView != null) {
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_cont_host);
                                if (textView2 != null) {
                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_mess);
                                    if (textView3 != null) {
                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_mess_feel);
                                        if (textView4 != null) {
                                            return new DialogKtvSendGiftNumBinding((ShapeConstraintLayout) view, squareImageView, linearLayout, shapeTextView, shapeTextView2, shapeTextView3, textView, textView2, textView3, textView4);
                                        }
                                        str = "tvMessFeel";
                                    } else {
                                        str = "tvMess";
                                    }
                                } else {
                                    str = "tvContHost";
                                }
                            } else {
                                str = "tvCont";
                            }
                        } else {
                            str = "tvClick3";
                        }
                    } else {
                        str = "tvClick2";
                    }
                } else {
                    str = "tvClick1";
                }
            } else {
                str = "ll";
            }
        } else {
            str = "ivGift";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeConstraintLayout getRoot() {
        return this.j;
    }
}
