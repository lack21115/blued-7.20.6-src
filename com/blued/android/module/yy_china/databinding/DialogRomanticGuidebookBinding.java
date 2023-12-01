package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYHomeThemeTabView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogRomanticGuidebookBinding.class */
public final class DialogRomanticGuidebookBinding implements ViewBinding {
    public final View a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final YYHomeThemeTabView f;
    public final ViewPager g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    private final ConstraintLayout k;

    private DialogRomanticGuidebookBinding(ConstraintLayout constraintLayout, View view, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, YYHomeThemeTabView yYHomeThemeTabView, ViewPager viewPager, TextView textView, TextView textView2, TextView textView3) {
        this.k = constraintLayout;
        this.a = view;
        this.b = imageView;
        this.c = imageView2;
        this.d = imageView3;
        this.e = imageView4;
        this.f = yYHomeThemeTabView;
        this.g = viewPager;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
    }

    public static DialogRomanticGuidebookBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.cover_view);
        if (findViewById != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.img_background);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.img_close);
                if (imageView2 != null) {
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.img_float_view);
                    if (imageView3 != null) {
                        ImageView imageView4 = (ImageView) view.findViewById(R.id.img_rule);
                        if (imageView4 != null) {
                            YYHomeThemeTabView yYHomeThemeTabView = (YYHomeThemeTabView) view.findViewById(R.id.ll_tab_layout);
                            if (yYHomeThemeTabView != null) {
                                ViewPager findViewById2 = view.findViewById(R.id.ll_view_pager);
                                if (findViewById2 != null) {
                                    TextView textView = (TextView) view.findViewById(R.id.tv_guidebook);
                                    if (textView != null) {
                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_rule_info);
                                        if (textView2 != null) {
                                            TextView textView3 = (TextView) view.findViewById(R.id.tv_user_name);
                                            if (textView3 != null) {
                                                return new DialogRomanticGuidebookBinding((ConstraintLayout) view, findViewById, imageView, imageView2, imageView3, imageView4, yYHomeThemeTabView, findViewById2, textView, textView2, textView3);
                                            }
                                            str = "tvUserName";
                                        } else {
                                            str = "tvRuleInfo";
                                        }
                                    } else {
                                        str = "tvGuidebook";
                                    }
                                } else {
                                    str = "llViewPager";
                                }
                            } else {
                                str = "llTabLayout";
                            }
                        } else {
                            str = "imgRule";
                        }
                    } else {
                        str = "imgFloatView";
                    }
                } else {
                    str = "imgClose";
                }
            } else {
                str = "imgBackground";
            }
        } else {
            str = "coverView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.k;
    }
}
