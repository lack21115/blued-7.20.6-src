package com.soft.blued.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/PrivilegeUserNotificationLayoutBinding.class */
public final class PrivilegeUserNotificationLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f15882a;
    public final FrameLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f15883c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final TextView g;
    public final TextView h;
    private final ShapeConstraintLayout i;

    private PrivilegeUserNotificationLayoutBinding(ShapeConstraintLayout shapeConstraintLayout, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView, TextView textView2) {
        this.i = shapeConstraintLayout;
        this.f15882a = frameLayout;
        this.b = frameLayout2;
        this.f15883c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = imageView4;
        this.g = textView;
        this.h = textView2;
    }

    public static PrivilegeUserNotificationLayoutBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_header_view);
        if (frameLayout != null) {
            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_status_bar);
            if (frameLayout2 != null) {
                ImageView imageView = (ImageView) view.findViewById(2131364232);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.img_animation_bg);
                    if (imageView2 != null) {
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.img_notification_bg);
                        if (imageView3 != null) {
                            ImageView imageView4 = (ImageView) view.findViewById(R.id.img_verify);
                            if (imageView4 != null) {
                                TextView textView = (TextView) view.findViewById(R.id.tv_notification_content);
                                if (textView != null) {
                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_notification_title);
                                    if (textView2 != null) {
                                        return new PrivilegeUserNotificationLayoutBinding((ShapeConstraintLayout) view, frameLayout, frameLayout2, imageView, imageView2, imageView3, imageView4, textView, textView2);
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
                        str = "imgAnimationBg";
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
        return this.i;
    }
}
