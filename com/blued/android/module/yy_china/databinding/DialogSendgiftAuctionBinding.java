package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogSendgiftAuctionBinding.class */
public final class DialogSendgiftAuctionBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16409a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16410c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final ShapeTextView g;
    private final LinearLayout h;

    private DialogSendgiftAuctionBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, ShapeTextView shapeTextView) {
        this.h = linearLayout;
        this.f16409a = imageView;
        this.b = imageView2;
        this.f16410c = textView;
        this.d = textView2;
        this.e = textView3;
        this.f = textView4;
        this.g = shapeTextView;
    }

    public static DialogSendgiftAuctionBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_sendgift_auction, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogSendgiftAuctionBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_l);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_r);
            if (imageView2 != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_name_l);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_name_r);
                    if (textView2 != null) {
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_num_l);
                        if (textView3 != null) {
                            TextView textView4 = (TextView) view.findViewById(R.id.tv_num_r);
                            if (textView4 != null) {
                                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_ok);
                                if (shapeTextView != null) {
                                    return new DialogSendgiftAuctionBinding((LinearLayout) view, imageView, imageView2, textView, textView2, textView3, textView4, shapeTextView);
                                }
                                str = "tvOk";
                            } else {
                                str = "tvNumR";
                            }
                        } else {
                            str = "tvNumL";
                        }
                    } else {
                        str = "tvNameR";
                    }
                } else {
                    str = "tvNameL";
                }
            } else {
                str = "ivR";
            }
        } else {
            str = "ivL";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.h;
    }
}
