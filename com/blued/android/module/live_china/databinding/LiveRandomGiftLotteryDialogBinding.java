package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SlopeLoadingView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveRandomGiftLotteryDialogBinding.class */
public final class LiveRandomGiftLotteryDialogBinding implements ViewBinding {
    public final FrameLayout a;
    public final FrameLayout b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final SlopeLoadingView f;
    public final ShapeTextView g;
    public final TextView h;
    public final ShapeTextView i;
    public final TextView j;
    private final FrameLayout k;

    private LiveRandomGiftLotteryDialogBinding(FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, ImageView imageView, ImageView imageView2, ImageView imageView3, SlopeLoadingView slopeLoadingView, ShapeTextView shapeTextView, TextView textView, ShapeTextView shapeTextView2, TextView textView2) {
        this.k = frameLayout;
        this.a = frameLayout2;
        this.b = frameLayout3;
        this.c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = slopeLoadingView;
        this.g = shapeTextView;
        this.h = textView;
        this.i = shapeTextView2;
        this.j = textView2;
    }

    public static LiveRandomGiftLotteryDialogBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static LiveRandomGiftLotteryDialogBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_random_gift_lottery_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveRandomGiftLotteryDialogBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_adorn_root);
        if (frameLayout != null) {
            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_root);
            if (frameLayout2 != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_beans);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_gold);
                    if (imageView2 != null) {
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_icon);
                        if (imageView3 != null) {
                            SlopeLoadingView slopeLoadingView = (SlopeLoadingView) view.findViewById(R.id.loading);
                            if (slopeLoadingView != null) {
                                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_btn_confirm);
                                if (shapeTextView != null) {
                                    TextView textView = (TextView) view.findViewById(R.id.tv_name);
                                    if (textView != null) {
                                        ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_tag);
                                        if (shapeTextView2 != null) {
                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_title);
                                            if (textView2 != null) {
                                                return new LiveRandomGiftLotteryDialogBinding((FrameLayout) view, frameLayout, frameLayout2, imageView, imageView2, imageView3, slopeLoadingView, shapeTextView, textView, shapeTextView2, textView2);
                                            }
                                            str = "tvTitle";
                                        } else {
                                            str = "tvTag";
                                        }
                                    } else {
                                        str = "tvName";
                                    }
                                } else {
                                    str = "tvBtnConfirm";
                                }
                            } else {
                                str = "loading";
                            }
                        } else {
                            str = "ivIcon";
                        }
                    } else {
                        str = "ivGold";
                    }
                } else {
                    str = "ivBeans";
                }
            } else {
                str = "flRoot";
            }
        } else {
            str = "flAdornRoot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.k;
    }
}
