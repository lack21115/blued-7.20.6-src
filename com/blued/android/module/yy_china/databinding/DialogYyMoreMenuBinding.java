package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYMoreMenuView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogYyMoreMenuBinding.class */
public final class DialogYyMoreMenuBinding implements ViewBinding {
    public final ImageView a;
    public final YYMoreMenuView b;
    private final LinearLayout c;

    private DialogYyMoreMenuBinding(LinearLayout linearLayout, ImageView imageView, YYMoreMenuView yYMoreMenuView) {
        this.c = linearLayout;
        this.a = imageView;
        this.b = yYMoreMenuView;
    }

    public static DialogYyMoreMenuBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_yy_more_menu, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogYyMoreMenuBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
        if (imageView != null) {
            YYMoreMenuView yYMoreMenuView = (YYMoreMenuView) view.findViewById(R.id.move);
            if (yYMoreMenuView != null) {
                return new DialogYyMoreMenuBinding((LinearLayout) view, imageView, yYMoreMenuView);
            }
            str = "move";
        } else {
            str = "ivClose";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.c;
    }
}
