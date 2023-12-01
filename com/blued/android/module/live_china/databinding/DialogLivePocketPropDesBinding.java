package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLivePocketPropDesBinding.class */
public final class DialogLivePocketPropDesBinding implements ViewBinding {
    public final ImageView a;
    public final ShapeTextView b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    private final FrameLayout h;

    private DialogLivePocketPropDesBinding(FrameLayout frameLayout, ImageView imageView, ShapeTextView shapeTextView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.h = frameLayout;
        this.a = imageView;
        this.b = shapeTextView;
        this.c = imageView2;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
        this.g = textView4;
    }

    public static DialogLivePocketPropDesBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogLivePocketPropDesBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_pocket_prop_des, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLivePocketPropDesBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
        if (imageView != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.iv_confirm);
            if (shapeTextView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_icon);
                if (imageView2 != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_des);
                    if (textView != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_exp_time);
                        if (textView2 != null) {
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_exp_tip);
                            if (textView3 != null) {
                                TextView textView4 = (TextView) view.findViewById(R.id.tv_name);
                                if (textView4 != null) {
                                    return new DialogLivePocketPropDesBinding((FrameLayout) view, imageView, shapeTextView, imageView2, textView, textView2, textView3, textView4);
                                }
                                str = "tvName";
                            } else {
                                str = "tvExpTip";
                            }
                        } else {
                            str = "tvExpTime";
                        }
                    } else {
                        str = "tvDes";
                    }
                } else {
                    str = "ivIcon";
                }
            } else {
                str = "ivConfirm";
            }
        } else {
            str = "ivClose";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.h;
    }
}
