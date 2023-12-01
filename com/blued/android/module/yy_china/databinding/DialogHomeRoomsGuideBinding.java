package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.AutoScrollViewPager;
import com.blued.android.module.common.view.LinePageIndicator;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogHomeRoomsGuideBinding.class */
public final class DialogHomeRoomsGuideBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f16352a;
    public final RelativeLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f16353c;
    public final ShapeTextView d;
    public final AutoScrollViewPager e;
    public final LinePageIndicator f;
    private final RelativeLayout g;

    private DialogHomeRoomsGuideBinding(RelativeLayout relativeLayout, ConstraintLayout constraintLayout, RelativeLayout relativeLayout2, ImageView imageView, ShapeTextView shapeTextView, AutoScrollViewPager autoScrollViewPager, LinePageIndicator linePageIndicator) {
        this.g = relativeLayout;
        this.f16352a = constraintLayout;
        this.b = relativeLayout2;
        this.f16353c = imageView;
        this.d = shapeTextView;
        this.e = autoScrollViewPager;
        this.f = linePageIndicator;
    }

    public static DialogHomeRoomsGuideBinding a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.con);
        if (constraintLayout != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.fl_con);
            if (relativeLayout != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_backs);
                if (imageView != null) {
                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_join_room);
                    if (shapeTextView != null) {
                        AutoScrollViewPager autoScrollViewPager = (AutoScrollViewPager) view.findViewById(R.id.yy_banner_guide);
                        if (autoScrollViewPager != null) {
                            LinePageIndicator linePageIndicator = (LinePageIndicator) view.findViewById(R.id.yy_lpi_line);
                            if (linePageIndicator != null) {
                                return new DialogHomeRoomsGuideBinding((RelativeLayout) view, constraintLayout, relativeLayout, imageView, shapeTextView, autoScrollViewPager, linePageIndicator);
                            }
                            str = "yyLpiLine";
                        } else {
                            str = "yyBannerGuide";
                        }
                    } else {
                        str = "tvJoinRoom";
                    }
                } else {
                    str = "ivBacks";
                }
            } else {
                str = "flCon";
            }
        } else {
            str = "con";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.g;
    }
}
