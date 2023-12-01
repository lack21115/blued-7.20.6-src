package com.soft.blued.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/NotificationFeedCityBannerLayoutBinding.class */
public final class NotificationFeedCityBannerLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f15806a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f15807c;
    public final FrameLayout d;
    public final TextView e;
    public final FrameLayout f;
    public final TextView g;
    private final FrameLayout h;

    private NotificationFeedCityBannerLayoutBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ShapeTextView shapeTextView, FrameLayout frameLayout2, TextView textView, FrameLayout frameLayout3, TextView textView2) {
        this.h = frameLayout;
        this.f15806a = imageView;
        this.b = imageView2;
        this.f15807c = shapeTextView;
        this.d = frameLayout2;
        this.e = textView;
        this.f = frameLayout3;
        this.g = textView2;
    }

    public static NotificationFeedCityBannerLayoutBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.avatar_one);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.avatar_two);
            if (imageView2 != null) {
                ShapeTextView findViewById = view.findViewById(R.id.btn);
                if (findViewById != null) {
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.click_layout);
                    if (frameLayout != null) {
                        TextView textView = (TextView) view.findViewById(R.id.des);
                        if (textView != null) {
                            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(2131369470);
                            if (frameLayout2 != null) {
                                TextView textView2 = (TextView) view.findViewById(2131370694);
                                if (textView2 != null) {
                                    return new NotificationFeedCityBannerLayoutBinding((FrameLayout) view, imageView, imageView2, findViewById, frameLayout, textView, frameLayout2, textView2);
                                }
                                str = "title";
                            } else {
                                str = "rootView";
                            }
                        } else {
                            str = "des";
                        }
                    } else {
                        str = "clickLayout";
                    }
                } else {
                    str = "btn";
                }
            } else {
                str = "avatarTwo";
            }
        } else {
            str = "avatarOne";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.h;
    }
}
