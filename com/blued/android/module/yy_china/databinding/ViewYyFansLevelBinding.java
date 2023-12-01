package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyFansLevelBinding.class */
public final class ViewYyFansLevelBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;
    private final ConstraintLayout e;

    private ViewYyFansLevelBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        this.e = constraintLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = textView;
        this.d = textView2;
    }

    public static ViewYyFansLevelBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_yy_fans_level, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewYyFansLevelBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_level_heart);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.ll_bg_view);
            if (imageView2 != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_level_name);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_level_num);
                    if (textView2 != null) {
                        return new ViewYyFansLevelBinding((ConstraintLayout) view, imageView, imageView2, textView, textView2);
                    }
                    str = "tvLevelNum";
                } else {
                    str = "tvLevelName";
                }
            } else {
                str = "llBgView";
            }
        } else {
            str = "imgLevelHeart";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
