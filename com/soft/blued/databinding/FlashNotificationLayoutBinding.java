package com.soft.blued.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FlashNotificationLayoutBinding.class */
public final class FlashNotificationLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f15055a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeConstraintLayout f15056c;
    public final TextView d;
    public final TextView e;
    private final ShapeConstraintLayout f;

    private FlashNotificationLayoutBinding(ShapeConstraintLayout shapeConstraintLayout, FrameLayout frameLayout, ImageView imageView, ShapeConstraintLayout shapeConstraintLayout2, TextView textView, TextView textView2) {
        this.f = shapeConstraintLayout;
        this.f15055a = frameLayout;
        this.b = imageView;
        this.f15056c = shapeConstraintLayout2;
        this.d = textView;
        this.e = textView2;
    }

    public static FlashNotificationLayoutBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_status_bar);
        if (frameLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(2131364232);
            if (imageView != null) {
                ShapeConstraintLayout findViewById = view.findViewById(2131369470);
                if (findViewById != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_notification_content);
                    if (textView != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_notification_title);
                        if (textView2 != null) {
                            return new FlashNotificationLayoutBinding((ShapeConstraintLayout) view, frameLayout, imageView, findViewById, textView, textView2);
                        }
                        str = "tvNotificationTitle";
                    } else {
                        str = "tvNotificationContent";
                    }
                } else {
                    str = "rootView";
                }
            } else {
                str = "headerView";
            }
        } else {
            str = "flStatusBar";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeConstraintLayout getRoot() {
        return this.f;
    }
}
