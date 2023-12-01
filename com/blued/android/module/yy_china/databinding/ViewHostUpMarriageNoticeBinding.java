package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.BluedMarqueeTextView;
import com.blued.android.module.common.view.HollowView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewHostUpMarriageNoticeBinding.class */
public final class ViewHostUpMarriageNoticeBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final HollowView c;
    public final ImageView d;
    public final ConstraintLayout e;
    public final BluedMarqueeTextView f;
    private final ConstraintLayout g;

    private ViewHostUpMarriageNoticeBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, HollowView hollowView, ImageView imageView3, ConstraintLayout constraintLayout2, BluedMarqueeTextView bluedMarqueeTextView) {
        this.g = constraintLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = hollowView;
        this.d = imageView3;
        this.e = constraintLayout2;
        this.f = bluedMarqueeTextView;
    }

    public static ViewHostUpMarriageNoticeBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_host_up_marriage_notice, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewHostUpMarriageNoticeBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_background);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv);
            if (imageView2 != null) {
                HollowView hollowView = (HollowView) view.findViewById(R.id.iv_hol);
                if (hollowView != null) {
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_us);
                    if (imageView3 != null) {
                        ConstraintLayout findViewById = view.findViewById(R.id.notify_view);
                        if (findViewById != null) {
                            BluedMarqueeTextView bluedMarqueeTextView = (BluedMarqueeTextView) view.findViewById(R.id.tv_notice_text);
                            if (bluedMarqueeTextView != null) {
                                return new ViewHostUpMarriageNoticeBinding((ConstraintLayout) view, imageView, imageView2, hollowView, imageView3, findViewById, bluedMarqueeTextView);
                            }
                            str = "tvNoticeText";
                        } else {
                            str = "notifyView";
                        }
                    } else {
                        str = "ivUs";
                    }
                } else {
                    str = "ivHol";
                }
            } else {
                str = "iv";
            }
        } else {
            str = "imgBackground";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.g;
    }
}
