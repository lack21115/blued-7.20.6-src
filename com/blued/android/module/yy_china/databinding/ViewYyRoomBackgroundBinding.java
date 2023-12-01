package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyRoomBackgroundBinding.class */
public final class ViewYyRoomBackgroundBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final SVGAImageView f16952a;
    public final SVGAImageView b;

    /* renamed from: c  reason: collision with root package name */
    private final View f16953c;

    private ViewYyRoomBackgroundBinding(View view, SVGAImageView sVGAImageView, SVGAImageView sVGAImageView2) {
        this.f16953c = view;
        this.f16952a = sVGAImageView;
        this.b = sVGAImageView2;
    }

    public static ViewYyRoomBackgroundBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.view_yy_room_background, viewGroup);
            return a(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    public static ViewYyRoomBackgroundBinding a(View view) {
        String str;
        SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.room_img);
        if (sVGAImageView != null) {
            SVGAImageView sVGAImageView2 = (SVGAImageView) view.findViewById(R.id.room_img_ani);
            if (sVGAImageView2 != null) {
                return new ViewYyRoomBackgroundBinding(view, sVGAImageView, sVGAImageView2);
            }
            str = "roomImgAni";
        } else {
            str = "roomImg";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f16953c;
    }
}
