package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyRobMusicGuideBinding.class */
public final class ViewYyRobMusicGuideBinding implements ViewBinding {
    public final ImageView a;
    private final LinearLayout b;

    private ViewYyRobMusicGuideBinding(LinearLayout linearLayout, ImageView imageView) {
        this.b = linearLayout;
        this.a = imageView;
    }

    public static ViewYyRobMusicGuideBinding a(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
        if (imageView != null) {
            return new ViewYyRobMusicGuideBinding((LinearLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("ivBack"));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.b;
    }
}
