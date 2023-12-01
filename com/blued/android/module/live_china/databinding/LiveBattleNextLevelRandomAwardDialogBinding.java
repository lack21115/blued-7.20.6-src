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
import com.blued.android.module.svgaplayer.SVGAImageView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveBattleNextLevelRandomAwardDialogBinding.class */
public final class LiveBattleNextLevelRandomAwardDialogBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f12140a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f12141c;
    public final ImageView d;
    public final LinearLayout e;
    public final RelativeLayout f;
    public final RelativeLayout g;
    public final SVGAImageView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    private final RelativeLayout l;

    private LiveBattleNextLevelRandomAwardDialogBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, SVGAImageView sVGAImageView, TextView textView, TextView textView2, TextView textView3) {
        this.l = relativeLayout;
        this.f12140a = imageView;
        this.b = imageView2;
        this.f12141c = imageView3;
        this.d = imageView4;
        this.e = linearLayout;
        this.f = relativeLayout2;
        this.g = relativeLayout3;
        this.h = sVGAImageView;
        this.i = textView;
        this.j = textView2;
        this.k = textView3;
    }

    public static LiveBattleNextLevelRandomAwardDialogBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static LiveBattleNextLevelRandomAwardDialogBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_battle_next_level_random_award_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveBattleNextLevelRandomAwardDialogBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.btn_buy_battle_pass_pro);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.btn_get_all);
            if (imageView2 != null) {
                ImageView imageView3 = (ImageView) view.findViewById(R.id.btn_get_all_big);
                if (imageView3 != null) {
                    ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_box);
                    if (imageView4 != null) {
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_btn_root);
                        if (linearLayout != null) {
                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_content);
                            if (relativeLayout != null) {
                                RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.rl_root);
                                if (relativeLayout2 != null) {
                                    SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.svg_float);
                                    if (sVGAImageView != null) {
                                        TextView textView = (TextView) view.findViewById(R.id.tv_desc);
                                        if (textView != null) {
                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_extra);
                                            if (textView2 != null) {
                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_title);
                                                if (textView3 != null) {
                                                    return new LiveBattleNextLevelRandomAwardDialogBinding((RelativeLayout) view, imageView, imageView2, imageView3, imageView4, linearLayout, relativeLayout, relativeLayout2, sVGAImageView, textView, textView2, textView3);
                                                }
                                                str = "tvTitle";
                                            } else {
                                                str = "tvExtra";
                                            }
                                        } else {
                                            str = "tvDesc";
                                        }
                                    } else {
                                        str = "svgFloat";
                                    }
                                } else {
                                    str = "rlRoot";
                                }
                            } else {
                                str = "rlContent";
                            }
                        } else {
                            str = "llBtnRoot";
                        }
                    } else {
                        str = "ivBox";
                    }
                } else {
                    str = "btnGetAllBig";
                }
            } else {
                str = "btnGetAll";
            }
        } else {
            str = "btnBuyBattlePassPro";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.l;
    }
}
