package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyMemberRobBinding.class */
public final class ViewYyMemberRobBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final YYBaseUserHeadView f16934a;
    public final SVGAImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16935c;
    private final ConstraintLayout d;

    private ViewYyMemberRobBinding(ConstraintLayout constraintLayout, YYBaseUserHeadView yYBaseUserHeadView, SVGAImageView sVGAImageView, TextView textView) {
        this.d = constraintLayout;
        this.f16934a = yYBaseUserHeadView;
        this.b = sVGAImageView;
        this.f16935c = textView;
    }

    public static ViewYyMemberRobBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_yy_member_rob, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewYyMemberRobBinding a(View view) {
        String str;
        YYBaseUserHeadView yYBaseUserHeadView = (YYBaseUserHeadView) view.findViewById(R.id.base_us_head);
        if (yYBaseUserHeadView != null) {
            SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.iv_svga);
            if (sVGAImageView != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_audience_index);
                if (textView != null) {
                    return new ViewYyMemberRobBinding((ConstraintLayout) view, yYBaseUserHeadView, sVGAImageView, textView);
                }
                str = "tvAudienceIndex";
            } else {
                str = "ivSvga";
            }
        } else {
            str = "baseUsHead";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.d;
    }
}
