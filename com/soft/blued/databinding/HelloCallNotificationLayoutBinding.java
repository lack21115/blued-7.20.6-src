package com.soft.blued.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/HelloCallNotificationLayoutBinding.class */
public final class HelloCallNotificationLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f15373a;
    public final FrameLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f15374c;
    public final ImageView d;
    public final LinearLayout e;
    public final ShapeConstraintLayout f;
    public final TextView g;
    private final ShapeConstraintLayout h;

    private HelloCallNotificationLayoutBinding(ShapeConstraintLayout shapeConstraintLayout, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, ShapeConstraintLayout shapeConstraintLayout2, TextView textView) {
        this.h = shapeConstraintLayout;
        this.f15373a = frameLayout;
        this.b = frameLayout2;
        this.f15374c = imageView;
        this.d = imageView2;
        this.e = linearLayout;
        this.f = shapeConstraintLayout2;
        this.g = textView;
    }

    public static HelloCallNotificationLayoutBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_header_view);
        if (frameLayout != null) {
            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_status_bar);
            if (frameLayout2 != null) {
                ImageView imageView = (ImageView) view.findViewById(2131364232);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.img_notification_bg);
                    if (imageView2 != null) {
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.item_view);
                        if (linearLayout != null) {
                            ShapeConstraintLayout findViewById = view.findViewById(2131369470);
                            if (findViewById != null) {
                                TextView textView = (TextView) view.findViewById(R.id.tv_notification_title);
                                if (textView != null) {
                                    return new HelloCallNotificationLayoutBinding((ShapeConstraintLayout) view, frameLayout, frameLayout2, imageView, imageView2, linearLayout, findViewById, textView);
                                }
                                str = "tvNotificationTitle";
                            } else {
                                str = "rootView";
                            }
                        } else {
                            str = "itemView";
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
