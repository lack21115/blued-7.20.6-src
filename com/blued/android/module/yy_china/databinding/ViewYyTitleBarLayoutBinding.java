package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyTitleBarLayoutBinding.class */
public final class ViewYyTitleBarLayoutBinding implements ViewBinding {
    public final ImageView a;
    public final TextView b;
    private final RelativeLayout c;

    private ViewYyTitleBarLayoutBinding(RelativeLayout relativeLayout, ImageView imageView, TextView textView) {
        this.c = relativeLayout;
        this.a = imageView;
        this.b = textView;
    }

    public static ViewYyTitleBarLayoutBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_back_img);
        if (imageView != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_title_text);
            if (textView != null) {
                return new ViewYyTitleBarLayoutBinding((RelativeLayout) view, imageView, textView);
            }
            str = "tvTitleText";
        } else {
            str = "ivBackImg";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.c;
    }
}
