package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveConstellationHonourKingViewBinding.class */
public final class LiveConstellationHonourKingViewBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final View e;
    public final RelativeLayout f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    private final RelativeLayout j;

    private LiveConstellationHonourKingViewBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, View view, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.j = relativeLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = imageView4;
        this.e = view;
        this.f = relativeLayout2;
        this.g = textView;
        this.h = textView2;
        this.i = textView3;
    }

    public static LiveConstellationHonourKingViewBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_constellation_honour_king_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveConstellationHonourKingViewBinding a(View view) {
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
                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_honour_main);
                            if (relativeLayout != null) {
                                TextView textView = (TextView) view.findViewById(R.id.tv_anchor_name);
                                if (textView != null) {
                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_top_title);
                                    if (textView2 != null) {
                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_user_name);
                                        if (textView3 != null) {
                                            return new LiveConstellationHonourKingViewBinding((RelativeLayout) view, imageView, imageView2, imageView3, imageView4, findViewById, relativeLayout, textView, textView2, textView3);
                                        }
                                        str = "tvUserName";
                                    } else {
                                        str = "tvTopTitle";
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

    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.j;
    }
}
