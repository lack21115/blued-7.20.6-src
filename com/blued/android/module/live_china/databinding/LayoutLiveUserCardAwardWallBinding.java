package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LayoutLiveUserCardAwardWallBinding.class */
public final class LayoutLiveUserCardAwardWallBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f12102a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f12103c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final ImageView k;
    public final RelativeLayout l;
    public final RelativeLayout m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final View r;
    private final ShapeLinearLayout s;

    private LayoutLiveUserCardAwardWallBinding(ShapeLinearLayout shapeLinearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view) {
        this.s = shapeLinearLayout;
        this.f12102a = imageView;
        this.b = imageView2;
        this.f12103c = imageView3;
        this.d = imageView4;
        this.e = imageView5;
        this.f = imageView6;
        this.g = imageView7;
        this.h = imageView8;
        this.i = imageView9;
        this.j = imageView10;
        this.k = imageView11;
        this.l = relativeLayout;
        this.m = relativeLayout2;
        this.n = textView;
        this.o = textView2;
        this.p = textView3;
        this.q = textView4;
        this.r = view;
    }

    public static LayoutLiveUserCardAwardWallBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_live_user_card_award_wall, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LayoutLiveUserCardAwardWallBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_gift_0);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_gift_1);
            if (imageView2 != null) {
                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_gift_2);
                if (imageView3 != null) {
                    ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_gift_arrow);
                    if (imageView4 != null) {
                        ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_medal_0);
                        if (imageView5 != null) {
                            ImageView imageView6 = (ImageView) view.findViewById(R.id.iv_medal_1);
                            if (imageView6 != null) {
                                ImageView imageView7 = (ImageView) view.findViewById(R.id.iv_medal_2);
                                if (imageView7 != null) {
                                    ImageView imageView8 = (ImageView) view.findViewById(R.id.iv_medal_arrow);
                                    if (imageView8 != null) {
                                        ImageView imageView9 = (ImageView) view.findViewById(R.id.iv_tag_0);
                                        if (imageView9 != null) {
                                            ImageView imageView10 = (ImageView) view.findViewById(R.id.iv_tag_1);
                                            if (imageView10 != null) {
                                                ImageView imageView11 = (ImageView) view.findViewById(R.id.iv_tag_2);
                                                if (imageView11 != null) {
                                                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rv_gift_content);
                                                    if (relativeLayout != null) {
                                                        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.rv_medal_content);
                                                        if (relativeLayout2 != null) {
                                                            TextView textView = (TextView) view.findViewById(R.id.tv_gift_count_desc);
                                                            if (textView != null) {
                                                                TextView textView2 = (TextView) view.findViewById(R.id.tv_gift_name);
                                                                if (textView2 != null) {
                                                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_medal_count_desc);
                                                                    if (textView3 != null) {
                                                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_medal_name);
                                                                        if (textView4 != null) {
                                                                            View findViewById = view.findViewById(R.id.view_dividing_line);
                                                                            if (findViewById != null) {
                                                                                return new LayoutLiveUserCardAwardWallBinding((ShapeLinearLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, relativeLayout, relativeLayout2, textView, textView2, textView3, textView4, findViewById);
                                                                            }
                                                                            str = "viewDividingLine";
                                                                        } else {
                                                                            str = "tvMedalName";
                                                                        }
                                                                    } else {
                                                                        str = "tvMedalCountDesc";
                                                                    }
                                                                } else {
                                                                    str = "tvGiftName";
                                                                }
                                                            } else {
                                                                str = "tvGiftCountDesc";
                                                            }
                                                        } else {
                                                            str = "rvMedalContent";
                                                        }
                                                    } else {
                                                        str = "rvGiftContent";
                                                    }
                                                } else {
                                                    str = "ivTag2";
                                                }
                                            } else {
                                                str = "ivTag1";
                                            }
                                        } else {
                                            str = "ivTag0";
                                        }
                                    } else {
                                        str = "ivMedalArrow";
                                    }
                                } else {
                                    str = "ivMedal2";
                                }
                            } else {
                                str = "ivMedal1";
                            }
                        } else {
                            str = "ivMedal0";
                        }
                    } else {
                        str = "ivGiftArrow";
                    }
                } else {
                    str = "ivGift2";
                }
            } else {
                str = "ivGift1";
            }
        } else {
            str = "ivGift0";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeLinearLayout getRoot() {
        return this.s;
    }
}
