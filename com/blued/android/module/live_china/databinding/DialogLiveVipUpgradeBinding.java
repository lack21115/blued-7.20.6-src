package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLiveVipUpgradeBinding.class */
public final class DialogLiveVipUpgradeBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f11830a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f11831c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final TextView g;
    public final TextView h;
    private final ConstraintLayout i;

    private DialogLiveVipUpgradeBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, TextView textView, TextView textView2) {
        this.i = constraintLayout;
        this.f11830a = frameLayout;
        this.b = imageView;
        this.f11831c = imageView2;
        this.d = imageView3;
        this.e = imageView4;
        this.f = imageView5;
        this.g = textView;
        this.h = textView2;
    }

    public static DialogLiveVipUpgradeBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogLiveVipUpgradeBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_vip_upgrade, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLiveVipUpgradeBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_main);
        if (frameLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_bg);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_close);
                if (imageView2 != null) {
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_level);
                    if (imageView3 != null) {
                        ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_ok);
                        if (imageView4 != null) {
                            ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_write);
                            if (imageView5 != null) {
                                TextView textView = (TextView) view.findViewById(R.id.tv_tip);
                                if (textView != null) {
                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_wechat);
                                    if (textView2 != null) {
                                        return new DialogLiveVipUpgradeBinding((ConstraintLayout) view, frameLayout, imageView, imageView2, imageView3, imageView4, imageView5, textView, textView2);
                                    }
                                    str = "tvWechat";
                                } else {
                                    str = "tvTip";
                                }
                            } else {
                                str = "ivWrite";
                            }
                        } else {
                            str = "ivOk";
                        }
                    } else {
                        str = "ivLevel";
                    }
                } else {
                    str = "ivClose";
                }
            } else {
                str = "ivBg";
            }
        } else {
            str = "flMain";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.i;
    }
}
