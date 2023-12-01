package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveHostFinishDetailDialogLayoutBinding.class */
public final class LiveHostFinishDetailDialogLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f12239a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f12240c;
    public final TextView d;
    public final ViewPager e;
    public final View f;
    private final FrameLayout g;

    private LiveHostFinishDetailDialogLayoutBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView, ViewPager viewPager, View view) {
        this.g = frameLayout;
        this.f12239a = imageView;
        this.b = imageView2;
        this.f12240c = linearLayout;
        this.d = textView;
        this.e = viewPager;
        this.f = view;
    }

    public static LiveHostFinishDetailDialogLayoutBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static LiveHostFinishDetailDialogLayoutBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_host_finish_detail_dialog_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveHostFinishDetailDialogLayoutBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_bg);
            if (imageView2 != null) {
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_label);
                if (linearLayout != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_time);
                    if (textView != null) {
                        ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
                        if (viewPager != null) {
                            View findViewById = view.findViewById(R.id.view_status_bar);
                            if (findViewById != null) {
                                return new LiveHostFinishDetailDialogLayoutBinding((FrameLayout) view, imageView, imageView2, linearLayout, textView, viewPager, findViewById);
                            }
                            str = "viewStatusBar";
                        } else {
                            str = "viewPager";
                        }
                    } else {
                        str = "tvTime";
                    }
                } else {
                    str = "llLabel";
                }
            } else {
                str = "ivBg";
            }
        } else {
            str = "ivBack";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.g;
    }
}
