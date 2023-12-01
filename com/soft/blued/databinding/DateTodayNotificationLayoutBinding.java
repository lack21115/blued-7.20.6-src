package com.soft.blued.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/DateTodayNotificationLayoutBinding.class */
public final class DateTodayNotificationLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f15002a;
    public final FrameLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f15003c;
    public final FrameLayout d;
    public final FrameLayout e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final RelativeLayout i;
    public final ShapeConstraintLayout j;
    public final TextView k;
    private final ShapeConstraintLayout l;

    private DateTodayNotificationLayoutBinding(ShapeConstraintLayout shapeConstraintLayout, ConstraintLayout constraintLayout, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout, ShapeConstraintLayout shapeConstraintLayout2, TextView textView) {
        this.l = shapeConstraintLayout;
        this.f15002a = constraintLayout;
        this.b = frameLayout;
        this.f15003c = frameLayout2;
        this.d = frameLayout3;
        this.e = frameLayout4;
        this.f = imageView;
        this.g = imageView2;
        this.h = imageView3;
        this.i = relativeLayout;
        this.j = shapeConstraintLayout2;
        this.k = textView;
    }

    public static DateTodayNotificationLayoutBinding a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_item);
        if (constraintLayout != null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_header_him);
            if (frameLayout != null) {
                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_header_self);
                if (frameLayout2 != null) {
                    FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.fl_status_bar);
                    if (frameLayout3 != null) {
                        FrameLayout frameLayout4 = (FrameLayout) view.findViewById(2131364048);
                        if (frameLayout4 != null) {
                            ImageView imageView = (ImageView) view.findViewById(R.id.from_header_view);
                            if (imageView != null) {
                                ImageView imageView2 = (ImageView) view.findViewById(2131364232);
                                if (imageView2 != null) {
                                    ImageView imageView3 = (ImageView) view.findViewById(R.id.img_notification_bg);
                                    if (imageView3 != null) {
                                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_header);
                                        if (relativeLayout != null) {
                                            ShapeConstraintLayout findViewById = view.findViewById(2131369470);
                                            if (findViewById != null) {
                                                TextView textView = (TextView) view.findViewById(R.id.tv_user_info);
                                                if (textView != null) {
                                                    return new DateTodayNotificationLayoutBinding((ShapeConstraintLayout) view, constraintLayout, frameLayout, frameLayout2, frameLayout3, frameLayout4, imageView, imageView2, imageView3, relativeLayout, findViewById, textView);
                                                }
                                                str = "tvUserInfo";
                                            } else {
                                                str = "rootView";
                                            }
                                        } else {
                                            str = "rlHeader";
                                        }
                                    } else {
                                        str = "imgNotificationBg";
                                    }
                                } else {
                                    str = "headerView";
                                }
                            } else {
                                str = "fromHeaderView";
                            }
                        } else {
                            str = "frameLayout";
                        }
                    } else {
                        str = "flStatusBar";
                    }
                } else {
                    str = "flHeaderSelf";
                }
            } else {
                str = "flHeaderHim";
            }
        } else {
            str = "clItem";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeConstraintLayout getRoot() {
        return this.l;
    }
}
