package com.soft.blued.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/SpecialCareNotificationLayoutBinding.class */
public final class SpecialCareNotificationLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f15900a;
    public final FrameLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f15901c;
    public final ImageView d;
    public final ImageView e;
    public final TextView f;
    public final TextView g;
    private final ShapeConstraintLayout h;

    private SpecialCareNotificationLayoutBinding(ShapeConstraintLayout shapeConstraintLayout, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2) {
        this.h = shapeConstraintLayout;
        this.f15900a = frameLayout;
        this.b = frameLayout2;
        this.f15901c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = textView;
        this.g = textView2;
    }

    public static SpecialCareNotificationLayoutBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_header_view);
        if (frameLayout != null) {
            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_status_bar);
            if (frameLayout2 != null) {
                ImageView imageView = (ImageView) view.findViewById(2131364232);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.img_notification_bg);
                    if (imageView2 != null) {
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.img_verify);
                        if (imageView3 != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_notification_content);
                            if (textView != null) {
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_notification_title);
                                if (textView2 != null) {
                                    return new SpecialCareNotificationLayoutBinding((ShapeConstraintLayout) view, frameLayout, frameLayout2, imageView, imageView2, imageView3, textView, textView2);
                                }
                                str = "tvNotificationTitle";
                            } else {
                                str = "tvNotificationContent";
                            }
                        } else {
                            str = "imgVerify";
                        }
                    } else {
                        str = "imgNotificationBg";
                    }
                } else {
                    str = "headerView";
                }
            } else {
                str = "flStatusBar";
            }
        } else {
            str = "flHeaderView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeConstraintLayout getRoot() {
        return this.h;
    }
}
