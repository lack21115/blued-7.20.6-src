package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewClickOneGiftSendBinding.class */
public final class ViewClickOneGiftSendBinding implements ViewBinding {
    public final ShapeTextView a;
    public final ShapeTextView b;
    public final ImageView c;
    public final SquareImageView d;
    public final SquareImageView e;
    public final ConstraintLayout f;
    public final ConstraintLayout g;
    public final TextView h;
    public final TextView i;
    private final View j;

    private ViewClickOneGiftSendBinding(View view, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, ImageView imageView, SquareImageView squareImageView, SquareImageView squareImageView2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2) {
        this.j = view;
        this.a = shapeTextView;
        this.b = shapeTextView2;
        this.c = imageView;
        this.d = squareImageView;
        this.e = squareImageView2;
        this.f = constraintLayout;
        this.g = constraintLayout2;
        this.h = textView;
        this.i = textView2;
    }

    public static ViewClickOneGiftSendBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.view_click_one_gift_send, viewGroup);
            return a(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    public static ViewClickOneGiftSendBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_pay);
        if (shapeTextView != null) {
            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.btn_sent);
            if (shapeTextView2 != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.img_issues);
                if (imageView != null) {
                    SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_gift_icn);
                    if (squareImageView != null) {
                        SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.iv_theme_gift_icn);
                        if (squareImageView2 != null) {
                            ConstraintLayout findViewById = view.findViewById(R.id.ll_single_gift);
                            if (findViewById != null) {
                                ConstraintLayout findViewById2 = view.findViewById(R.id.ll_wish_content);
                                if (findViewById2 != null) {
                                    TextView textView = (TextView) view.findViewById(R.id.tv_got_count);
                                    if (textView != null) {
                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_total_count);
                                        if (textView2 != null) {
                                            return new ViewClickOneGiftSendBinding(view, shapeTextView, shapeTextView2, imageView, squareImageView, squareImageView2, findViewById, findViewById2, textView, textView2);
                                        }
                                        str = "tvTotalCount";
                                    } else {
                                        str = "tvGotCount";
                                    }
                                } else {
                                    str = "llWishContent";
                                }
                            } else {
                                str = "llSingleGift";
                            }
                        } else {
                            str = "ivThemeGiftIcn";
                        }
                    } else {
                        str = "ivGiftIcn";
                    }
                } else {
                    str = "imgIssues";
                }
            } else {
                str = "btnSent";
            }
        } else {
            str = "btnPay";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    public View getRoot() {
        return this.j;
    }
}
