package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewLivingStreamLayoutBinding.class */
public final class ViewLivingStreamLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16867a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f16868c;
    private final ConstraintLayout d;

    private ViewLivingStreamLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2) {
        this.d = constraintLayout;
        this.f16867a = imageView;
        this.b = imageView2;
        this.f16868c = constraintLayout2;
    }

    public static ViewLivingStreamLayoutBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_living_stream_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewLivingStreamLayoutBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_living_bg);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_yy_room_anim);
            if (imageView2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.sll_yy_room_tag);
                if (constraintLayout != null) {
                    return new ViewLivingStreamLayoutBinding((ConstraintLayout) view, imageView, imageView2, constraintLayout);
                }
                str = "sllYyRoomTag";
            } else {
                str = "ivYyRoomAnim";
            }
        } else {
            str = "ivLivingBg";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.d;
    }
}
