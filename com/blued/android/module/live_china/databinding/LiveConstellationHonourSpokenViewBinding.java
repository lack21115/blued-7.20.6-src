package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveConstellationHonourSpokenViewBinding.class */
public final class LiveConstellationHonourSpokenViewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f12171a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f12172c;
    public final ImageView d;
    public final View e;
    public final LinearLayout f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    private final RelativeLayout n;

    private LiveConstellationHonourSpokenViewBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, View view, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.n = relativeLayout;
        this.f12171a = imageView;
        this.b = imageView2;
        this.f12172c = imageView3;
        this.d = imageView4;
        this.e = view;
        this.f = linearLayout;
        this.g = textView;
        this.h = textView2;
        this.i = textView3;
        this.j = textView4;
        this.k = textView5;
        this.l = textView6;
        this.m = textView7;
    }

    public static LiveConstellationHonourSpokenViewBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_constellation_honour_spoken_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveConstellationHonourSpokenViewBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_anchor_avatar);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_anchor_avatar_frame);
            if (imageView2 != null) {
                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_user_avatar);
                if (imageView3 != null) {
                    ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_user_avatar_frame);
                    if (imageView4 != null) {
                        View findViewById = view.findViewById(R.id.line);
                        if (findViewById != null) {
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.rl_honour_main);
                            if (linearLayout != null) {
                                TextView textView = (TextView) view.findViewById(R.id.tv_anchor_name);
                                if (textView != null) {
                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_constellation_bonus);
                                    if (textView2 != null) {
                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_constellation_bonus_percent);
                                        if (textView3 != null) {
                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_constellation_num);
                                            if (textView4 != null) {
                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_constellation_num_title);
                                                if (textView5 != null) {
                                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_top_title);
                                                    if (textView6 != null) {
                                                        TextView textView7 = (TextView) view.findViewById(R.id.tv_user_name);
                                                        if (textView7 != null) {
                                                            return new LiveConstellationHonourSpokenViewBinding((RelativeLayout) view, imageView, imageView2, imageView3, imageView4, findViewById, linearLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7);
                                                        }
                                                        str = "tvUserName";
                                                    } else {
                                                        str = "tvTopTitle";
                                                    }
                                                } else {
                                                    str = "tvConstellationNumTitle";
                                                }
                                            } else {
                                                str = "tvConstellationNum";
                                            }
                                        } else {
                                            str = "tvConstellationBonusPercent";
                                        }
                                    } else {
                                        str = "tvConstellationBonus";
                                    }
                                } else {
                                    str = "tvAnchorName";
                                }
                            } else {
                                str = "rlHonourMain";
                            }
                        } else {
                            str = "line";
                        }
                    } else {
                        str = "ivUserAvatarFrame";
                    }
                } else {
                    str = "ivUserAvatar";
                }
            } else {
                str = "ivAnchorAvatarFrame";
            }
        } else {
            str = "ivAnchorAvatar";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.n;
    }
}
