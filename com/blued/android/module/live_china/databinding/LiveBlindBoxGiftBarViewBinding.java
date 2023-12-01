package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveBlindBoxGiftBarViewBinding.class */
public final class LiveBlindBoxGiftBarViewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f12153a;
    public final RelativeLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final LiveBlindBoxGiftBarOpenViewBinding f12154c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final TextView g;
    private final RelativeLayout h;

    private LiveBlindBoxGiftBarViewBinding(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, LiveBlindBoxGiftBarOpenViewBinding liveBlindBoxGiftBarOpenViewBinding, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView) {
        this.h = relativeLayout;
        this.f12153a = imageView;
        this.b = relativeLayout2;
        this.f12154c = liveBlindBoxGiftBarOpenViewBinding;
        this.d = imageView2;
        this.e = imageView3;
        this.f = imageView4;
        this.g = textView;
    }

    public static LiveBlindBoxGiftBarViewBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.blind_box_normal_pedestal);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.blind_box_normal_view);
            if (relativeLayout != null) {
                View findViewById = view.findViewById(R.id.blind_box_open_view);
                if (findViewById != null) {
                    LiveBlindBoxGiftBarOpenViewBinding a2 = LiveBlindBoxGiftBarOpenViewBinding.a(findViewById);
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_blind_box_gift_bg);
                    if (imageView2 != null) {
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_left_gift_img);
                        if (imageView3 != null) {
                            ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_right_gift_img);
                            if (imageView4 != null) {
                                TextView textView = (TextView) view.findViewById(R.id.tv_normal_title);
                                if (textView != null) {
                                    return new LiveBlindBoxGiftBarViewBinding((RelativeLayout) view, imageView, relativeLayout, a2, imageView2, imageView3, imageView4, textView);
                                }
                                str = "tvNormalTitle";
                            } else {
                                str = "ivRightGiftImg";
                            }
                        } else {
                            str = "ivLeftGiftImg";
                        }
                    } else {
                        str = "ivBlindBoxGiftBg";
                    }
                } else {
                    str = "blindBoxOpenView";
                }
            } else {
                str = "blindBoxNormalView";
            }
        } else {
            str = "blindBoxNormalPedestal";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.h;
    }
}
