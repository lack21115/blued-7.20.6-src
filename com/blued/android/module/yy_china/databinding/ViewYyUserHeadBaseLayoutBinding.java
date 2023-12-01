package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyUserHeadBaseLayoutBinding.class */
public final class ViewYyUserHeadBaseLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeFrameLayout f16967a;
    public final CardView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f16968c;
    public final CardView d;
    public final ImageView e;
    public final SquareImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final RelativeLayout j;
    public final FrameLayout k;
    public final SVGAImageView l;
    public final TextView m;
    private final RelativeLayout n;

    private ViewYyUserHeadBaseLayoutBinding(RelativeLayout relativeLayout, ShapeFrameLayout shapeFrameLayout, CardView cardView, ShapeTextView shapeTextView, CardView cardView2, ImageView imageView, SquareImageView squareImageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RelativeLayout relativeLayout2, FrameLayout frameLayout, SVGAImageView sVGAImageView, TextView textView) {
        this.n = relativeLayout;
        this.f16967a = shapeFrameLayout;
        this.b = cardView;
        this.f16968c = shapeTextView;
        this.d = cardView2;
        this.e = imageView;
        this.f = squareImageView;
        this.g = imageView2;
        this.h = imageView3;
        this.i = imageView4;
        this.j = relativeLayout2;
        this.k = frameLayout;
        this.l = sVGAImageView;
        this.m = textView;
    }

    public static ViewYyUserHeadBaseLayoutBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_yy_user_head_base_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewYyUserHeadBaseLayoutBinding a(View view) {
        String str;
        ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.car_head);
        if (shapeFrameLayout != null) {
            CardView cardView = (CardView) view.findViewById(R.id.card_1);
            if (cardView != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.fl_disable_audience);
                if (shapeTextView != null) {
                    CardView cardView2 = (CardView) view.findViewById(R.id.fl_no_audience);
                    if (cardView2 != null) {
                        ImageView imageView = (ImageView) view.findViewById(R.id.iv_apng);
                        if (imageView != null) {
                            SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_apply_seat);
                            if (squareImageView != null) {
                                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_audience_img);
                                if (imageView2 != null) {
                                    ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_headwear);
                                    if (imageView3 != null) {
                                        ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_microphone_status);
                                        if (imageView4 != null) {
                                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_head_bottom);
                                            if (relativeLayout != null) {
                                                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.rl_head_top);
                                                if (frameLayout != null) {
                                                    SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.talking_anim_view);
                                                    if (sVGAImageView != null) {
                                                        TextView textView = (TextView) view.findViewById(R.id.tv_role);
                                                        if (textView != null) {
                                                            return new ViewYyUserHeadBaseLayoutBinding((RelativeLayout) view, shapeFrameLayout, cardView, shapeTextView, cardView2, imageView, squareImageView, imageView2, imageView3, imageView4, relativeLayout, frameLayout, sVGAImageView, textView);
                                                        }
                                                        str = "tvRole";
                                                    } else {
                                                        str = "talkingAnimView";
                                                    }
                                                } else {
                                                    str = "rlHeadTop";
                                                }
                                            } else {
                                                str = "rlHeadBottom";
                                            }
                                        } else {
                                            str = "ivMicrophoneStatus";
                                        }
                                    } else {
                                        str = "ivHeadwear";
                                    }
                                } else {
                                    str = "ivAudienceImg";
                                }
                            } else {
                                str = "ivApplySeat";
                            }
                        } else {
                            str = "ivApng";
                        }
                    } else {
                        str = "flNoAudience";
                    }
                } else {
                    str = "flDisableAudience";
                }
            } else {
                str = "card1";
            }
        } else {
            str = "carHead";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.n;
    }
}
