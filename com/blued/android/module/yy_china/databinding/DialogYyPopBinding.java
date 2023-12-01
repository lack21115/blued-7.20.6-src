package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogYyPopBinding.class */
public final class DialogYyPopBinding implements ViewBinding {
    public final FrameLayout a;
    public final ImageView b;
    private final FrameLayout c;

    private DialogYyPopBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView) {
        this.c = frameLayout;
        this.a = frameLayout2;
        this.b = imageView;
    }

    public static DialogYyPopBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.con);
        if (frameLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
            if (imageView != null) {
                return new DialogYyPopBinding((FrameLayout) view, frameLayout, imageView);
            }
            str = "ivBack";
        } else {
            str = "con";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.c;
    }
}
