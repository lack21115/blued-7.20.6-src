package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyRobMusicGuideBinding.class */
public final class ViewYyRobMusicGuideBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16951a;
    private final LinearLayout b;

    private ViewYyRobMusicGuideBinding(LinearLayout linearLayout, ImageView imageView) {
        this.b = linearLayout;
        this.f16951a = imageView;
    }

    public static ViewYyRobMusicGuideBinding a(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
        if (imageView != null) {
            return new ViewYyRobMusicGuideBinding((LinearLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("ivBack"));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.b;
    }
}
