package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogYyPrizeBinding.class */
public final class DialogYyPrizeBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f16451a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16452c;
    public final TextView d;
    private final FrameLayout e;

    private DialogYyPrizeBinding(FrameLayout frameLayout, View view, ImageView imageView, TextView textView, TextView textView2) {
        this.e = frameLayout;
        this.f16451a = view;
        this.b = imageView;
        this.f16452c = textView;
        this.d = textView2;
    }

    public static DialogYyPrizeBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.conver_view);
        if (findViewById != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.prize_icon);
            if (imageView != null) {
                TextView textView = (TextView) view.findViewById(R.id.prize_name);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.prize_value);
                    if (textView2 != null) {
                        return new DialogYyPrizeBinding((FrameLayout) view, findViewById, imageView, textView, textView2);
                    }
                    str = "prizeValue";
                } else {
                    str = "prizeName";
                }
            } else {
                str = "prizeIcon";
            }
        } else {
            str = "converView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.e;
    }
}
