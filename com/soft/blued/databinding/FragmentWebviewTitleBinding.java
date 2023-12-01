package com.soft.blued.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FragmentWebviewTitleBinding.class */
public final class FragmentWebviewTitleBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f29038a;
    public final LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29039c;
    public final ImageView d;
    public final ImageView e;
    public final LinearLayout f;
    public final ImageView g;
    public final ImageView h;
    public final FrameLayout i;
    public final TextView j;
    public final ImageView k;
    public final ImageView l;
    public final TextView m;
    public final ImageView n;
    public final ImageView o;
    public final ImageView p;
    public final ImageView q;
    public final TextView r;
    public final TextView s;
    public final LinearLayout t;
    public final TextView u;
    private final LinearLayout v;

    private FragmentWebviewTitleBinding(LinearLayout linearLayout, FrameLayout frameLayout, LinearLayout linearLayout2, TextView textView, ImageView imageView, ImageView imageView2, LinearLayout linearLayout3, ImageView imageView3, ImageView imageView4, FrameLayout frameLayout2, TextView textView2, ImageView imageView5, ImageView imageView6, TextView textView3, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, TextView textView4, TextView textView5, LinearLayout linearLayout4, TextView textView6) {
        this.v = linearLayout;
        this.f29038a = frameLayout;
        this.b = linearLayout2;
        this.f29039c = textView;
        this.d = imageView;
        this.e = imageView2;
        this.f = linearLayout3;
        this.g = imageView3;
        this.h = imageView4;
        this.i = frameLayout2;
        this.j = textView2;
        this.k = imageView5;
        this.l = imageView6;
        this.m = textView3;
        this.n = imageView7;
        this.o = imageView8;
        this.p = imageView9;
        this.q = imageView10;
        this.r = textView4;
        this.s = textView5;
        this.t = linearLayout4;
        this.u = textView6;
    }

    public static FragmentWebviewTitleBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.center_layout);
        if (frameLayout != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ctt_bg);
            if (linearLayout != null) {
                TextView textView = (TextView) view.findViewById(2131363108);
                if (textView != null) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.ctt_center_icon);
                    if (imageView != null) {
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.ctt_center_img);
                        if (imageView2 != null) {
                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ctt_center_text_layout);
                            if (linearLayout2 != null) {
                                ImageView imageView3 = (ImageView) view.findViewById(R.id.ctt_close);
                                if (imageView3 != null) {
                                    ImageView imageView4 = (ImageView) view.findViewById(R.id.ctt_close_click);
                                    if (imageView4 != null) {
                                        FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.ctt_close_layout);
                                        if (frameLayout2 != null) {
                                            TextView textView2 = (TextView) view.findViewById(R.id.ctt_close_text);
                                            if (textView2 != null) {
                                                ImageView imageView5 = (ImageView) view.findViewById(2131363120);
                                                if (imageView5 != null) {
                                                    ImageView imageView6 = (ImageView) view.findViewById(R.id.ctt_left_click);
                                                    if (imageView6 != null) {
                                                        TextView textView3 = (TextView) view.findViewById(R.id.ctt_left_text);
                                                        if (textView3 != null) {
                                                            ImageView imageView7 = (ImageView) view.findViewById(2131363126);
                                                            if (imageView7 != null) {
                                                                ImageView imageView8 = (ImageView) view.findViewById(R.id.ctt_right_click);
                                                                if (imageView8 != null) {
                                                                    ImageView imageView9 = (ImageView) view.findViewById(R.id.ctt_right_left);
                                                                    if (imageView9 != null) {
                                                                        ImageView imageView10 = (ImageView) view.findViewById(R.id.ctt_right_left_click);
                                                                        if (imageView10 != null) {
                                                                            TextView textView4 = (TextView) view.findViewById(R.id.ctt_right_left_text);
                                                                            if (textView4 != null) {
                                                                                TextView textView5 = (TextView) view.findViewById(2131363135);
                                                                                if (textView5 != null) {
                                                                                    LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.title_bg);
                                                                                    if (linearLayout3 != null) {
                                                                                        TextView textView6 = (TextView) view.findViewById(R.id.title_btm_line);
                                                                                        if (textView6 != null) {
                                                                                            return new FragmentWebviewTitleBinding((LinearLayout) view, frameLayout, linearLayout, textView, imageView, imageView2, linearLayout2, imageView3, imageView4, frameLayout2, textView2, imageView5, imageView6, textView3, imageView7, imageView8, imageView9, imageView10, textView4, textView5, linearLayout3, textView6);
                                                                                        }
                                                                                        str = "titleBtmLine";
                                                                                    } else {
                                                                                        str = "titleBg";
                                                                                    }
                                                                                } else {
                                                                                    str = "cttRightText";
                                                                                }
                                                                            } else {
                                                                                str = "cttRightLeftText";
                                                                            }
                                                                        } else {
                                                                            str = "cttRightLeftClick";
                                                                        }
                                                                    } else {
                                                                        str = "cttRightLeft";
                                                                    }
                                                                } else {
                                                                    str = "cttRightClick";
                                                                }
                                                            } else {
                                                                str = "cttRight";
                                                            }
                                                        } else {
                                                            str = "cttLeftText";
                                                        }
                                                    } else {
                                                        str = "cttLeftClick";
                                                    }
                                                } else {
                                                    str = "cttLeft";
                                                }
                                            } else {
                                                str = "cttCloseText";
                                            }
                                        } else {
                                            str = "cttCloseLayout";
                                        }
                                    } else {
                                        str = "cttCloseClick";
                                    }
                                } else {
                                    str = "cttClose";
                                }
                            } else {
                                str = "cttCenterTextLayout";
                            }
                        } else {
                            str = "cttCenterImg";
                        }
                    } else {
                        str = "cttCenterIcon";
                    }
                } else {
                    str = "cttCenter";
                }
            } else {
                str = "cttBg";
            }
        } else {
            str = "centerLayout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.v;
    }
}
