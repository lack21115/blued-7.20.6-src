package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyGivePresentLayoutBinding.class */
public final class ViewYyGivePresentLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f16918a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f16919c;
    public final TextView d;
    private final ShapeRelativeLayout e;

    private ViewYyGivePresentLayoutBinding(ShapeRelativeLayout shapeRelativeLayout, TextView textView, TextView textView2, ShapeTextView shapeTextView, TextView textView3) {
        this.e = shapeRelativeLayout;
        this.f16918a = textView;
        this.b = textView2;
        this.f16919c = shapeTextView;
        this.d = textView3;
    }

    public static ViewYyGivePresentLayoutBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_yy_give_present_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewYyGivePresentLayoutBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.receiver_gift);
        if (textView != null) {
            TextView textView2 = (TextView) view.findViewById(R.id.tv_hi);
            if (textView2 != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_pay);
                if (shapeTextView != null) {
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_receiver_name);
                    if (textView3 != null) {
                        return new ViewYyGivePresentLayoutBinding((ShapeRelativeLayout) view, textView, textView2, shapeTextView, textView3);
                    }
                    str = "tvReceiverName";
                } else {
                    str = "tvPay";
                }
            } else {
                str = "tvHi";
            }
        } else {
            str = "receiverGift";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeRelativeLayout getRoot() {
        return this.e;
    }
}
