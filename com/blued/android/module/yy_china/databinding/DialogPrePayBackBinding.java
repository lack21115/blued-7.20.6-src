package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogPrePayBackBinding.class */
public final class DialogPrePayBackBinding implements ViewBinding {
    public final ImageView a;
    public final RecyclerView b;
    public final RelativeLayout c;
    public final TextView d;
    public final ShapeTextView e;
    private final LinearLayout f;

    private DialogPrePayBackBinding(LinearLayout linearLayout, ImageView imageView, RecyclerView recyclerView, RelativeLayout relativeLayout, TextView textView, ShapeTextView shapeTextView) {
        this.f = linearLayout;
        this.a = imageView;
        this.b = recyclerView;
        this.c = relativeLayout;
        this.d = textView;
        this.e = shapeTextView;
    }

    public static DialogPrePayBackBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
        if (imageView != null) {
            RecyclerView findViewById = view.findViewById(R.id.rcv);
            if (findViewById != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_con);
                if (relativeLayout != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_content);
                    if (textView != null) {
                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_pre_pay);
                        if (shapeTextView != null) {
                            return new DialogPrePayBackBinding((LinearLayout) view, imageView, findViewById, relativeLayout, textView, shapeTextView);
                        }
                        str = "tvPrePay";
                    } else {
                        str = "tvContent";
                    }
                } else {
                    str = "rlCon";
                }
            } else {
                str = "rcv";
            }
        } else {
            str = "ivBack";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.f;
    }
}
