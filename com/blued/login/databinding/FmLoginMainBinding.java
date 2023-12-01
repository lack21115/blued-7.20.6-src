package com.blued.login.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.login.R;
import com.blued.login.view.LoginIndicator;
import com.blued.login.view.TagViewPager;
import com.tencent.rtmp.ui.TXCloudVideoView;

/* loaded from: source-7206380-dex2jar.jar:com/blued/login/databinding/FmLoginMainBinding.class */
public final class FmLoginMainBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f20519a;
    public final FrameLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f20520c;
    public final FrameLayout d;
    public final ImageView e;
    public final ImageView f;
    public final LoginIndicator g;
    public final TextView h;
    public final ShapeTextView i;
    public final TextView j;
    public final ShapeTextView k;
    public final TXCloudVideoView l;
    public final TagViewPager m;
    private final ConstraintLayout n;

    private FmLoginMainBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, ImageView imageView, ImageView imageView2, LoginIndicator loginIndicator, TextView textView, ShapeTextView shapeTextView, TextView textView2, ShapeTextView shapeTextView2, TXCloudVideoView tXCloudVideoView, TagViewPager tagViewPager) {
        this.n = constraintLayout;
        this.f20519a = constraintLayout2;
        this.b = frameLayout;
        this.f20520c = frameLayout2;
        this.d = frameLayout3;
        this.e = imageView;
        this.f = imageView2;
        this.g = loginIndicator;
        this.h = textView;
        this.i = shapeTextView;
        this.j = textView2;
        this.k = shapeTextView2;
        this.l = tXCloudVideoView;
        this.m = tagViewPager;
    }

    public static FmLoginMainBinding a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.constraint_layout);
        if (constraintLayout != null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fm_img);
            if (frameLayout != null) {
                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fm_terms);
                if (frameLayout2 != null) {
                    FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.fm_top);
                    if (frameLayout3 != null) {
                        ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
                        if (imageView != null) {
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_icon);
                            if (imageView2 != null) {
                                LoginIndicator loginIndicator = (LoginIndicator) view.findViewById(R.id.lpi_line);
                                if (loginIndicator != null) {
                                    TextView textView = (TextView) view.findViewById(R.id.tv_ip);
                                    if (textView != null) {
                                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_mobile);
                                        if (shapeTextView != null) {
                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_other);
                                            if (textView2 != null) {
                                                ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_wechat);
                                                if (shapeTextView2 != null) {
                                                    TXCloudVideoView tXCloudVideoView = (TXCloudVideoView) view.findViewById(R.id.video_view);
                                                    if (tXCloudVideoView != null) {
                                                        TagViewPager tagViewPager = (TagViewPager) view.findViewById(R.id.viewPager);
                                                        if (tagViewPager != null) {
                                                            return new FmLoginMainBinding((ConstraintLayout) view, constraintLayout, frameLayout, frameLayout2, frameLayout3, imageView, imageView2, loginIndicator, textView, shapeTextView, textView2, shapeTextView2, tXCloudVideoView, tagViewPager);
                                                        }
                                                        str = "viewPager";
                                                    } else {
                                                        str = "videoView";
                                                    }
                                                } else {
                                                    str = "tvWechat";
                                                }
                                            } else {
                                                str = "tvOther";
                                            }
                                        } else {
                                            str = "tvMobile";
                                        }
                                    } else {
                                        str = "tvIp";
                                    }
                                } else {
                                    str = "lpiLine";
                                }
                            } else {
                                str = "ivIcon";
                            }
                        } else {
                            str = "ivBack";
                        }
                    } else {
                        str = "fmTop";
                    }
                } else {
                    str = "fmTerms";
                }
            } else {
                str = "fmImg";
            }
        } else {
            str = "constraintLayout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.n;
    }
}
