package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyRelaiionshipRoomUiBinding.class */
public final class ItemYyRelaiionshipRoomUiBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final SVGAImageView f16786a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    private final ConstraintLayout f16787c;

    private ItemYyRelaiionshipRoomUiBinding(ConstraintLayout constraintLayout, SVGAImageView sVGAImageView, ImageView imageView) {
        this.f16787c = constraintLayout;
        this.f16786a = sVGAImageView;
        this.b = imageView;
    }

    public static ItemYyRelaiionshipRoomUiBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static ItemYyRelaiionshipRoomUiBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_yy_relaiionship_room_ui, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ItemYyRelaiionshipRoomUiBinding a(View view) {
        String str;
        SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.iv);
        if (sVGAImageView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_suo);
            if (imageView != null) {
                return new ItemYyRelaiionshipRoomUiBinding((ConstraintLayout) view, sVGAImageView, imageView);
            }
            str = "ivSuo";
        } else {
            str = "iv";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f16787c;
    }
}
