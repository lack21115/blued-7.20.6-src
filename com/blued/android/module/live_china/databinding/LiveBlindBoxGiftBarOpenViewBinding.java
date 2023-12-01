package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.view.LiveLuckyBagSlopeProgressView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveBlindBoxGiftBarOpenViewBinding.class */
public final class LiveBlindBoxGiftBarOpenViewBinding implements ViewBinding {
    public final ImageView a;
    public final LiveLuckyBagSlopeProgressView b;
    public final ImageView c;
    public final LinearLayout d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    private final RelativeLayout j;

    private LiveBlindBoxGiftBarOpenViewBinding(RelativeLayout relativeLayout, ImageView imageView, LiveLuckyBagSlopeProgressView liveLuckyBagSlopeProgressView, ImageView imageView2, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.j = relativeLayout;
        this.a = imageView;
        this.b = liveLuckyBagSlopeProgressView;
        this.c = imageView2;
        this.d = linearLayout;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = textView4;
        this.i = textView5;
    }

    public static LiveBlindBoxGiftBarOpenViewBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.blind_box_pedestal);
        if (imageView != null) {
            LiveLuckyBagSlopeProgressView liveLuckyBagSlopeProgressView = (LiveLuckyBagSlopeProgressView) view.findViewById(R.id.blind_box_progress_view);
            if (liveLuckyBagSlopeProgressView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_open_right_icon);
                if (imageView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_right_layout);
                    if (linearLayout != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_current_progress);
                        if (textView != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_max_progress);
                            if (textView2 != null) {
                                TextView textView3 = (TextView) view.findViewById(R.id.tv_price);
                                if (textView3 != null) {
                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_price_gift);
                                    if (textView4 != null) {
                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_title);
                                        if (textView5 != null) {
                                            return new LiveBlindBoxGiftBarOpenViewBinding((RelativeLayout) view, imageView, liveLuckyBagSlopeProgressView, imageView2, linearLayout, textView, textView2, textView3, textView4, textView5);
                                        }
                                        str = "tvTitle";
                                    } else {
                                        str = "tvPriceGift";
                                    }
                                } else {
                                    str = "tvPrice";
                                }
                            } else {
                                str = "tvMaxProgress";
                            }
                        } else {
                            str = "tvCurrentProgress";
                        }
                    } else {
                        str = "llRightLayout";
                    }
                } else {
                    str = "ivOpenRightIcon";
                }
            } else {
                str = "blindBoxProgressView";
            }
        } else {
            str = "blindBoxPedestal";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.j;
    }
}
