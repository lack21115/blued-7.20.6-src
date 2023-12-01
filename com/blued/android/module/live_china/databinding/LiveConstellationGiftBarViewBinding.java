package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveConstellationGiftBarViewBinding.class */
public final class LiveConstellationGiftBarViewBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final TextView f;
    public final ImageView g;
    public final ImageView h;
    public final RelativeLayout i;
    public final LinearLayout j;
    public final TextView k;
    public final TextView l;
    private final RelativeLayout m;

    private LiveConstellationGiftBarViewBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, TextView textView, ImageView imageView6, ImageView imageView7, RelativeLayout relativeLayout2, LinearLayout linearLayout, TextView textView2, TextView textView3) {
        this.m = relativeLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = imageView4;
        this.e = imageView5;
        this.f = textView;
        this.g = imageView6;
        this.h = imageView7;
        this.i = relativeLayout2;
        this.j = linearLayout;
        this.k = textView2;
        this.l = textView3;
    }

    public static LiveConstellationGiftBarViewBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_anchor_avatar);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_audience_avatar);
            if (imageView2 != null) {
                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_constellation);
                if (imageView3 != null) {
                    ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_constellation_arrow);
                    if (imageView4 != null) {
                        ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_constellation_gift_bg);
                        if (imageView5 != null) {
                            TextView textView = (TextView) view.findViewById(R.id.iv_constellation_name);
                            if (textView != null) {
                                ImageView imageView6 = (ImageView) view.findViewById(R.id.iv_constellation_normal_view);
                                if (imageView6 != null) {
                                    ImageView imageView7 = (ImageView) view.findViewById(R.id.iv_to_peak);
                                    if (imageView7 != null) {
                                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.ll_avatars);
                                        if (relativeLayout != null) {
                                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_to_unlock);
                                            if (linearLayout != null) {
                                                TextView textView2 = (TextView) view.findViewById(R.id.tv_constellation_title);
                                                if (textView2 != null) {
                                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_need_num_to_peak);
                                                    if (textView3 != null) {
                                                        return new LiveConstellationGiftBarViewBinding((RelativeLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, textView, imageView6, imageView7, relativeLayout, linearLayout, textView2, textView3);
                                                    }
                                                    str = "tvNeedNumToPeak";
                                                } else {
                                                    str = "tvConstellationTitle";
                                                }
                                            } else {
                                                str = "llToUnlock";
                                            }
                                        } else {
                                            str = "llAvatars";
                                        }
                                    } else {
                                        str = "ivToPeak";
                                    }
                                } else {
                                    str = "ivConstellationNormalView";
                                }
                            } else {
                                str = "ivConstellationName";
                            }
                        } else {
                            str = "ivConstellationGiftBg";
                        }
                    } else {
                        str = "ivConstellationArrow";
                    }
                } else {
                    str = "ivConstellation";
                }
            } else {
                str = "ivAudienceAvatar";
            }
        } else {
            str = "ivAnchorAvatar";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.m;
    }
}
