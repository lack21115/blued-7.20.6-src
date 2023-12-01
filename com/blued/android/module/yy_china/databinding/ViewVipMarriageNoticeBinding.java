package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.BluedMarqueeTextView;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.yy_china.R;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewVipMarriageNoticeBinding.class */
public final class ViewVipMarriageNoticeBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final SVGAImageView f16884a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f16885c;
    public final ShapeableImageView d;
    public final ConstraintLayout e;
    public final BluedMarqueeTextView f;
    private final ConstraintLayout g;

    private ViewVipMarriageNoticeBinding(ConstraintLayout constraintLayout, SVGAImageView sVGAImageView, ImageView imageView, ImageView imageView2, ShapeableImageView shapeableImageView, ConstraintLayout constraintLayout2, BluedMarqueeTextView bluedMarqueeTextView) {
        this.g = constraintLayout;
        this.f16884a = sVGAImageView;
        this.b = imageView;
        this.f16885c = imageView2;
        this.d = shapeableImageView;
        this.e = constraintLayout2;
        this.f = bluedMarqueeTextView;
    }

    public static ViewVipMarriageNoticeBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_vip_marriage_notice, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewVipMarriageNoticeBinding a(View view) {
        String str;
        SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.img_animation_view);
        if (sVGAImageView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.img_background);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_md);
                if (imageView2 != null) {
                    ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.iv_user);
                    if (shapeableImageView != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.notify_view);
                        if (constraintLayout != null) {
                            BluedMarqueeTextView bluedMarqueeTextView = (BluedMarqueeTextView) view.findViewById(R.id.tv_notice_text);
                            if (bluedMarqueeTextView != null) {
                                return new ViewVipMarriageNoticeBinding((ConstraintLayout) view, sVGAImageView, imageView, imageView2, shapeableImageView, constraintLayout, bluedMarqueeTextView);
                            }
                            str = "tvNoticeText";
                        } else {
                            str = "notifyView";
                        }
                    } else {
                        str = "ivUser";
                    }
                } else {
                    str = "ivMd";
                }
            } else {
                str = "imgBackground";
            }
        } else {
            str = "imgAnimationView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.g;
    }
}
