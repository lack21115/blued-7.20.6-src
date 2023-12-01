package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/IncludeLiveGiftBottomFuntionBinding.class */
public final class IncludeLiveGiftBottomFuntionBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f11989a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f11990c;
    public final LinearLayout d;
    public final TextView e;
    public final TextView f;
    public final ImageView g;
    public final LinearLayout h;
    public final TextView i;
    public final ShapeTextView j;
    public final TextView k;
    public final FrameLayout l;
    private final LinearLayout m;

    private IncludeLiveGiftBottomFuntionBinding(LinearLayout linearLayout, FrameLayout frameLayout, ImageView imageView, TextView textView, LinearLayout linearLayout2, TextView textView2, TextView textView3, ImageView imageView2, LinearLayout linearLayout3, TextView textView4, ShapeTextView shapeTextView, TextView textView5, FrameLayout frameLayout2) {
        this.m = linearLayout;
        this.f11989a = frameLayout;
        this.b = imageView;
        this.f11990c = textView;
        this.d = linearLayout2;
        this.e = textView2;
        this.f = textView3;
        this.g = imageView2;
        this.h = linearLayout3;
        this.i = textView4;
        this.j = shapeTextView;
        this.k = textView5;
        this.l = frameLayout2;
    }

    public static IncludeLiveGiftBottomFuntionBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.include_live_gift_bottom_funtion, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static IncludeLiveGiftBottomFuntionBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_renewal_root);
        if (frameLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.gift_select_num_image);
            if (imageView != null) {
                TextView textView = (TextView) view.findViewById(R.id.gift_select_num_text);
                if (textView != null) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.gift_select_num_view);
                    if (linearLayout != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.give_gift_view);
                        if (textView2 != null) {
                            TextView textView3 = (TextView) view.findViewById(R.id.give_price_view);
                            if (textView3 != null) {
                                ImageView imageView2 = (ImageView) view.findViewById(R.id.live_gift_first_charge_iv);
                                if (imageView2 != null) {
                                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.live_gift_send_layout);
                                    if (linearLayout2 != null) {
                                        TextView textView4 = (TextView) view.findViewById(R.id.price_view);
                                        if (textView4 != null) {
                                            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.renewal_view);
                                            if (shapeTextView != null) {
                                                TextView textView5 = (TextView) view.findViewById(R.id.top_up_view);
                                                if (textView5 != null) {
                                                    FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.view_space);
                                                    if (frameLayout2 != null) {
                                                        return new IncludeLiveGiftBottomFuntionBinding((LinearLayout) view, frameLayout, imageView, textView, linearLayout, textView2, textView3, imageView2, linearLayout2, textView4, shapeTextView, textView5, frameLayout2);
                                                    }
                                                    str = "viewSpace";
                                                } else {
                                                    str = "topUpView";
                                                }
                                            } else {
                                                str = "renewalView";
                                            }
                                        } else {
                                            str = "priceView";
                                        }
                                    } else {
                                        str = "liveGiftSendLayout";
                                    }
                                } else {
                                    str = "liveGiftFirstChargeIv";
                                }
                            } else {
                                str = "givePriceView";
                            }
                        } else {
                            str = "giveGiftView";
                        }
                    } else {
                        str = "giftSelectNumView";
                    }
                } else {
                    str = "giftSelectNumText";
                }
            } else {
                str = "giftSelectNumImage";
            }
        } else {
            str = "flRenewalRoot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.m;
    }
}
