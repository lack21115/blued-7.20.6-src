package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/PopAlinkBinding.class */
public final class PopAlinkBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f15814a;
    public final ImageButton b;

    /* renamed from: c  reason: collision with root package name */
    private final RelativeLayout f15815c;

    private PopAlinkBinding(RelativeLayout relativeLayout, ImageView imageView, ImageButton imageButton) {
        this.f15815c = relativeLayout;
        this.f15814a = imageView;
        this.b = imageButton;
    }

    public static PopAlinkBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_advert);
        if (imageView != null) {
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.img_close);
            if (imageButton != null) {
                return new PopAlinkBinding((RelativeLayout) view, imageView, imageButton);
            }
            str = "imgClose";
        } else {
            str = "imgAdvert";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.f15815c;
    }
}
