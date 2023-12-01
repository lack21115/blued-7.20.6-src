package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveMultiConnectionItemViewBinding.class */
public final class LiveMultiConnectionItemViewBinding implements ViewBinding {
    public final ShapeFrameLayout a;
    public final ShapeFrameLayout b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final CardView j;
    public final ShapeLinearLayout k;
    public final ShapeLinearLayout l;
    public final ShapeTextView m;
    public final ShapeFrameLayout n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final TextView s;
    private final FrameLayout t;

    private LiveMultiConnectionItemViewBinding(FrameLayout frameLayout, ShapeFrameLayout shapeFrameLayout, ShapeFrameLayout shapeFrameLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, CardView cardView, ShapeLinearLayout shapeLinearLayout, ShapeLinearLayout shapeLinearLayout2, ShapeTextView shapeTextView, ShapeFrameLayout shapeFrameLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.t = frameLayout;
        this.a = shapeFrameLayout;
        this.b = shapeFrameLayout2;
        this.c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = imageView4;
        this.g = imageView5;
        this.h = imageView6;
        this.i = imageView7;
        this.j = cardView;
        this.k = shapeLinearLayout;
        this.l = shapeLinearLayout2;
        this.m = shapeTextView;
        this.n = shapeFrameLayout3;
        this.o = textView;
        this.p = textView2;
        this.q = textView3;
        this.r = textView4;
        this.s = textView5;
    }

    public static LiveMultiConnectionItemViewBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_multi_connection_item_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveMultiConnectionItemViewBinding a(View view) {
        String str;
        ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.fl_streak);
        if (shapeFrameLayout != null) {
            ShapeFrameLayout shapeFrameLayout2 = (ShapeFrameLayout) view.findViewById(R.id.fl_streak_in);
            if (shapeFrameLayout2 != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_attention);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_icon);
                    if (imageView2 != null) {
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_icon_ac);
                        if (imageView3 != null) {
                            ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_pk_voice_switch);
                            if (imageView4 != null) {
                                ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_result);
                                if (imageView5 != null) {
                                    ImageView imageView6 = (ImageView) view.findViewById(R.id.iv_streak);
                                    if (imageView6 != null) {
                                        ImageView imageView7 = (ImageView) view.findViewById(R.id.pk_light_right);
                                        if (imageView7 != null) {
                                            CardView findViewById = view.findViewById(R.id.sl_pk_stream);
                                            if (findViewById != null) {
                                                ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.sl_rank);
                                                if (shapeLinearLayout != null) {
                                                    ShapeLinearLayout shapeLinearLayout2 = (ShapeLinearLayout) view.findViewById(R.id.sl_user_info);
                                                    if (shapeLinearLayout2 != null) {
                                                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_group);
                                                        if (shapeTextView != null) {
                                                            ShapeFrameLayout shapeFrameLayout3 = (ShapeFrameLayout) view.findViewById(R.id.tv_group_wrap);
                                                            if (shapeFrameLayout3 != null) {
                                                                TextView textView = (TextView) view.findViewById(R.id.tv_name);
                                                                if (textView != null) {
                                                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_num);
                                                                    if (textView2 != null) {
                                                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_num_copy);
                                                                        if (textView3 != null) {
                                                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_plus_right);
                                                                            if (textView4 != null) {
                                                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_plus_right_copy);
                                                                                if (textView5 != null) {
                                                                                    return new LiveMultiConnectionItemViewBinding((FrameLayout) view, shapeFrameLayout, shapeFrameLayout2, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, findViewById, shapeLinearLayout, shapeLinearLayout2, shapeTextView, shapeFrameLayout3, textView, textView2, textView3, textView4, textView5);
                                                                                }
                                                                                str = "tvPlusRightCopy";
                                                                            } else {
                                                                                str = "tvPlusRight";
                                                                            }
                                                                        } else {
                                                                            str = "tvNumCopy";
                                                                        }
                                                                    } else {
                                                                        str = "tvNum";
                                                                    }
                                                                } else {
                                                                    str = "tvName";
                                                                }
                                                            } else {
                                                                str = "tvGroupWrap";
                                                            }
                                                        } else {
                                                            str = "tvGroup";
                                                        }
                                                    } else {
                                                        str = "slUserInfo";
                                                    }
                                                } else {
                                                    str = "slRank";
                                                }
                                            } else {
                                                str = "slPkStream";
                                            }
                                        } else {
                                            str = "pkLightRight";
                                        }
                                    } else {
                                        str = "ivStreak";
                                    }
                                } else {
                                    str = "ivResult";
                                }
                            } else {
                                str = "ivPkVoiceSwitch";
                            }
                        } else {
                            str = "ivIconAc";
                        }
                    } else {
                        str = "ivIcon";
                    }
                } else {
                    str = "ivAttention";
                }
            } else {
                str = "flStreakIn";
            }
        } else {
            str = "flStreak";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.t;
    }
}
