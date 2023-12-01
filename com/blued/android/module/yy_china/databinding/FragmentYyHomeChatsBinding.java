package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.BluedMarqueeTextView;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.HomeRotationView;
import com.blued.android.module.yy_china.view.YYHomeCradAniView;
import com.blued.android.module.yy_china.view.YYHomeThemeTabView;
import com.google.android.material.appbar.AppBarLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyHomeChatsBinding.class */
public final class FragmentYyHomeChatsBinding implements ViewBinding {
    public final TextView A;
    public final BluedMarqueeTextView B;
    private final ConstraintLayout C;

    /* renamed from: a  reason: collision with root package name */
    public final YYHomeCradAniView f16502a;
    public final YYHomeCradAniView b;

    /* renamed from: c  reason: collision with root package name */
    public final AppBarLayout f16503c;
    public final ConstraintLayout d;
    public final ConstraintLayout e;
    public final FrameLayout f;
    public final ImageView g;
    public final ImageView h;
    public final FrameLayout i;
    public final FrameLayout j;
    public final FrameLayout k;
    public final ImageView l;
    public final SVGAImageView m;
    public final SVGAImageView n;
    public final LinearLayout o;
    public final LinearLayout p;
    public final NoDataAndLoadFailView q;
    public final ViewPager r;
    public final HomeRotationView s;
    public final ShapeLinearLayout t;
    public final YYHomeThemeTabView u;
    public final TextView v;
    public final TextView w;
    public final BluedMarqueeTextView x;
    public final ShapeTextView y;
    public final TextView z;

    private FragmentYyHomeChatsBinding(ConstraintLayout constraintLayout, YYHomeCradAniView yYHomeCradAniView, YYHomeCradAniView yYHomeCradAniView2, AppBarLayout appBarLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, ImageView imageView3, SVGAImageView sVGAImageView, SVGAImageView sVGAImageView2, LinearLayout linearLayout, LinearLayout linearLayout2, NoDataAndLoadFailView noDataAndLoadFailView, ViewPager viewPager, HomeRotationView homeRotationView, ShapeLinearLayout shapeLinearLayout, YYHomeThemeTabView yYHomeThemeTabView, TextView textView, TextView textView2, BluedMarqueeTextView bluedMarqueeTextView, ShapeTextView shapeTextView, TextView textView3, TextView textView4, BluedMarqueeTextView bluedMarqueeTextView2) {
        this.C = constraintLayout;
        this.f16502a = yYHomeCradAniView;
        this.b = yYHomeCradAniView2;
        this.f16503c = appBarLayout;
        this.d = constraintLayout2;
        this.e = constraintLayout3;
        this.f = frameLayout;
        this.g = imageView;
        this.h = imageView2;
        this.i = frameLayout2;
        this.j = frameLayout3;
        this.k = frameLayout4;
        this.l = imageView3;
        this.m = sVGAImageView;
        this.n = sVGAImageView2;
        this.o = linearLayout;
        this.p = linearLayout2;
        this.q = noDataAndLoadFailView;
        this.r = viewPager;
        this.s = homeRotationView;
        this.t = shapeLinearLayout;
        this.u = yYHomeThemeTabView;
        this.v = textView;
        this.w = textView2;
        this.x = bluedMarqueeTextView;
        this.y = shapeTextView;
        this.z = textView3;
        this.A = textView4;
        this.B = bluedMarqueeTextView2;
    }

    public static FragmentYyHomeChatsBinding a(View view) {
        String str;
        YYHomeCradAniView yYHomeCradAniView = (YYHomeCradAniView) view.findViewById(R.id.ani_1);
        if (yYHomeCradAniView != null) {
            YYHomeCradAniView yYHomeCradAniView2 = (YYHomeCradAniView) view.findViewById(R.id.ani_2);
            if (yYHomeCradAniView2 != null) {
                AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.appbar);
                if (appBarLayout != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cont);
                    if (constraintLayout != null) {
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.fra_cons);
                        if (constraintLayout2 != null) {
                            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fralay);
                            if (frameLayout != null) {
                                ImageView imageView = (ImageView) view.findViewById(R.id.iv);
                                if (imageView != null) {
                                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_host_room);
                                    if (imageView2 != null) {
                                        FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.iv_top_1);
                                        if (frameLayout2 != null) {
                                            FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.iv_top_2);
                                            if (frameLayout3 != null) {
                                                FrameLayout frameLayout4 = (FrameLayout) view.findViewById(R.id.iv_top_3);
                                                if (frameLayout4 != null) {
                                                    ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_top_left);
                                                    if (imageView3 != null) {
                                                        SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.iv_top_right_1);
                                                        if (sVGAImageView != null) {
                                                            SVGAImageView sVGAImageView2 = (SVGAImageView) view.findViewById(R.id.iv_top_right_2);
                                                            if (sVGAImageView2 != null) {
                                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_red_envelope);
                                                                if (linearLayout != null) {
                                                                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_tablayout);
                                                                    if (linearLayout2 != null) {
                                                                        NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) view.findViewById(R.id.no_data_view);
                                                                        if (noDataAndLoadFailView != null) {
                                                                            ViewPager viewPager = (ViewPager) view.findViewById(R.id.room_view_pager);
                                                                            if (viewPager != null) {
                                                                                HomeRotationView homeRotationView = (HomeRotationView) view.findViewById(R.id.rota);
                                                                                if (homeRotationView != null) {
                                                                                    ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.shall_home_bottoms);
                                                                                    if (shapeLinearLayout != null) {
                                                                                        YYHomeThemeTabView yYHomeThemeTabView = (YYHomeThemeTabView) view.findViewById(R.id.tablayout);
                                                                                        if (yYHomeThemeTabView != null) {
                                                                                            TextView textView = (TextView) view.findViewById(R.id.tv_create_room_bottom);
                                                                                            if (textView != null) {
                                                                                                TextView textView2 = (TextView) view.findViewById(R.id.tv_down_right_1);
                                                                                                if (textView2 != null) {
                                                                                                    BluedMarqueeTextView bluedMarqueeTextView = (BluedMarqueeTextView) view.findViewById(R.id.tv_down_right_2);
                                                                                                    if (bluedMarqueeTextView != null) {
                                                                                                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_match_room);
                                                                                                        if (shapeTextView != null) {
                                                                                                            TextView textView3 = (TextView) view.findViewById(R.id.tv_match_room_bottom);
                                                                                                            if (textView3 != null) {
                                                                                                                TextView textView4 = (TextView) view.findViewById(R.id.tv_top_right_1);
                                                                                                                if (textView4 != null) {
                                                                                                                    BluedMarqueeTextView bluedMarqueeTextView2 = (BluedMarqueeTextView) view.findViewById(R.id.tv_top_right_2);
                                                                                                                    if (bluedMarqueeTextView2 != null) {
                                                                                                                        return new FragmentYyHomeChatsBinding((ConstraintLayout) view, yYHomeCradAniView, yYHomeCradAniView2, appBarLayout, constraintLayout, constraintLayout2, frameLayout, imageView, imageView2, frameLayout2, frameLayout3, frameLayout4, imageView3, sVGAImageView, sVGAImageView2, linearLayout, linearLayout2, noDataAndLoadFailView, viewPager, homeRotationView, shapeLinearLayout, yYHomeThemeTabView, textView, textView2, bluedMarqueeTextView, shapeTextView, textView3, textView4, bluedMarqueeTextView2);
                                                                                                                    }
                                                                                                                    str = "tvTopRight2";
                                                                                                                } else {
                                                                                                                    str = "tvTopRight1";
                                                                                                                }
                                                                                                            } else {
                                                                                                                str = "tvMatchRoomBottom";
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "tvMatchRoom";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "tvDownRight2";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "tvDownRight1";
                                                                                                }
                                                                                            } else {
                                                                                                str = "tvCreateRoomBottom";
                                                                                            }
                                                                                        } else {
                                                                                            str = "tablayout";
                                                                                        }
                                                                                    } else {
                                                                                        str = "shallHomeBottoms";
                                                                                    }
                                                                                } else {
                                                                                    str = "rota";
                                                                                }
                                                                            } else {
                                                                                str = "roomViewPager";
                                                                            }
                                                                        } else {
                                                                            str = "noDataView";
                                                                        }
                                                                    } else {
                                                                        str = "llTablayout";
                                                                    }
                                                                } else {
                                                                    str = "llRedEnvelope";
                                                                }
                                                            } else {
                                                                str = "ivTopRight2";
                                                            }
                                                        } else {
                                                            str = "ivTopRight1";
                                                        }
                                                    } else {
                                                        str = "ivTopLeft";
                                                    }
                                                } else {
                                                    str = "ivTop3";
                                                }
                                            } else {
                                                str = "ivTop2";
                                            }
                                        } else {
                                            str = "ivTop1";
                                        }
                                    } else {
                                        str = "ivHostRoom";
                                    }
                                } else {
                                    str = "iv";
                                }
                            } else {
                                str = "fralay";
                            }
                        } else {
                            str = "fraCons";
                        }
                    } else {
                        str = "cont";
                    }
                } else {
                    str = "appbar";
                }
            } else {
                str = "ani2";
            }
        } else {
            str = "ani1";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.C;
    }
}
