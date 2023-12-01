package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live.base.view.subscaleview.SubsamplingScaleImageView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLiveConstellationInfoBinding.class */
public final class DialogLiveConstellationInfoBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f11757a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final SubsamplingScaleImageView f11758c;
    private final ConstraintLayout d;

    private DialogLiveConstellationInfoBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, SubsamplingScaleImageView subsamplingScaleImageView) {
        this.d = constraintLayout;
        this.f11757a = imageView;
        this.b = imageView2;
        this.f11758c = subsamplingScaleImageView;
    }

    public static DialogLiveConstellationInfoBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogLiveConstellationInfoBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_constellation_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLiveConstellationInfoBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_bg);
            if (imageView2 != null) {
                SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) view.findViewById(R.id.iv_info);
                if (subsamplingScaleImageView != null) {
                    return new DialogLiveConstellationInfoBinding((ConstraintLayout) view, imageView, imageView2, subsamplingScaleImageView);
                }
                str = "ivInfo";
            } else {
                str = "ivBg";
            }
        } else {
            str = "ivBack";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.d;
    }
}
