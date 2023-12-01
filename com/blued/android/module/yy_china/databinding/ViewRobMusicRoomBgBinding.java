package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewRobMusicRoomBgBinding.class */
public final class ViewRobMusicRoomBgBinding implements ViewBinding {
    public final SVGAImageView a;
    public final ImageView b;
    private final FrameLayout c;

    private ViewRobMusicRoomBgBinding(FrameLayout frameLayout, SVGAImageView sVGAImageView, ImageView imageView) {
        this.c = frameLayout;
        this.a = sVGAImageView;
        this.b = imageView;
    }

    public static ViewRobMusicRoomBgBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_rob_music_room_bg, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewRobMusicRoomBgBinding a(View view) {
        String str;
        SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.img_rob_svga_background);
        if (sVGAImageView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.img_top);
            if (imageView != null) {
                return new ViewRobMusicRoomBgBinding((FrameLayout) view, sVGAImageView, imageView);
            }
            str = "imgTop";
        } else {
            str = "imgRobSvgaBackground";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.c;
    }
}
