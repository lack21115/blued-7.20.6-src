package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LayoutLiveShoutCardStatusBinding.class */
public final class LayoutLiveShoutCardStatusBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final TextView c;
    private final ShapeRelativeLayout d;

    private LayoutLiveShoutCardStatusBinding(ShapeRelativeLayout shapeRelativeLayout, ImageView imageView, ImageView imageView2, TextView textView) {
        this.d = shapeRelativeLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = textView;
    }

    public static LayoutLiveShoutCardStatusBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_live_shout_card_status, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LayoutLiveShoutCardStatusBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_shout_card_icon);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_shout_card_status_anim);
            if (imageView2 != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_shout_card_status);
                if (textView != null) {
                    return new LayoutLiveShoutCardStatusBinding((ShapeRelativeLayout) view, imageView, imageView2, textView);
                }
                str = "tvShoutCardStatus";
            } else {
                str = "ivShoutCardStatusAnim";
            }
        } else {
            str = "ivShoutCardIcon";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ShapeRelativeLayout getRoot() {
        return this.d;
    }
}
