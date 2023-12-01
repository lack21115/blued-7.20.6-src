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

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewDoublePeopleMarriageNoticeBinding.class */
public final class ViewDoublePeopleMarriageNoticeBinding implements ViewBinding {
    public final SVGAImageView a;
    public final ImageView b;
    public final ImageView c;
    public final ShapeableImageView d;
    public final ShapeableImageView e;
    public final ConstraintLayout f;
    public final BluedMarqueeTextView g;
    private final ConstraintLayout h;

    private ViewDoublePeopleMarriageNoticeBinding(ConstraintLayout constraintLayout, SVGAImageView sVGAImageView, ImageView imageView, ImageView imageView2, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, ConstraintLayout constraintLayout2, BluedMarqueeTextView bluedMarqueeTextView) {
        this.h = constraintLayout;
        this.a = sVGAImageView;
        this.b = imageView;
        this.c = imageView2;
        this.d = shapeableImageView;
        this.e = shapeableImageView2;
        this.f = constraintLayout2;
        this.g = bluedMarqueeTextView;
    }

    public static ViewDoublePeopleMarriageNoticeBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_double_people_marriage_notice, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewDoublePeopleMarriageNoticeBinding a(View view) {
        String str;
        SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.img_animation_view);
        if (sVGAImageView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.img_background);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_md);
                if (imageView2 != null) {
                    ShapeableImageView findViewById = view.findViewById(R.id.iv_user);
                    if (findViewById != null) {
                        ShapeableImageView findViewById2 = view.findViewById(R.id.iv_user_2);
                        if (findViewById2 != null) {
                            ConstraintLayout findViewById3 = view.findViewById(R.id.notify_view);
                            if (findViewById3 != null) {
                                BluedMarqueeTextView bluedMarqueeTextView = (BluedMarqueeTextView) view.findViewById(R.id.tv_notice_text);
                                if (bluedMarqueeTextView != null) {
                                    return new ViewDoublePeopleMarriageNoticeBinding((ConstraintLayout) view, sVGAImageView, imageView, imageView2, findViewById, findViewById2, findViewById3, bluedMarqueeTextView);
                                }
                                str = "tvNoticeText";
                            } else {
                                str = "notifyView";
                            }
                        } else {
                            str = "ivUser2";
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

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.h;
    }
}
