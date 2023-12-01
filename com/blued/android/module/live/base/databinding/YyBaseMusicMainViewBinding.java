package com.blued.android.module.live.base.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.live.base.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/databinding/YyBaseMusicMainViewBinding.class */
public final class YyBaseMusicMainViewBinding implements ViewBinding {
    public final YyBaseMusicTabLoadErrorBinding a;
    public final ImageView b;
    public final ProgressBar c;
    public final RecyclerView d;
    public final TextView e;
    public final ViewPager f;
    private final LinearLayout g;

    private YyBaseMusicMainViewBinding(LinearLayout linearLayout, YyBaseMusicTabLoadErrorBinding yyBaseMusicTabLoadErrorBinding, ImageView imageView, ProgressBar progressBar, RecyclerView recyclerView, TextView textView, ViewPager viewPager) {
        this.g = linearLayout;
        this.a = yyBaseMusicTabLoadErrorBinding;
        this.b = imageView;
        this.c = progressBar;
        this.d = recyclerView;
        this.e = textView;
        this.f = viewPager;
    }

    public static YyBaseMusicMainViewBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.inc_load_error);
        if (findViewById != null) {
            YyBaseMusicTabLoadErrorBinding a = YyBaseMusicTabLoadErrorBinding.a(findViewById);
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_search);
            if (imageView != null) {
                ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.loading_view);
                if (progressBar != null) {
                    RecyclerView findViewById2 = view.findViewById(R.id.rv_tab);
                    if (findViewById2 != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_music_title);
                        if (textView != null) {
                            ViewPager findViewById3 = view.findViewById(R.id.view_pager);
                            if (findViewById3 != null) {
                                return new YyBaseMusicMainViewBinding((LinearLayout) view, a, imageView, progressBar, findViewById2, textView, findViewById3);
                            }
                            str = "viewPager";
                        } else {
                            str = "tvMusicTitle";
                        }
                    } else {
                        str = "rvTab";
                    }
                } else {
                    str = "loadingView";
                }
            } else {
                str = "ivSearch";
            }
        } else {
            str = "incLoadError";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.g;
    }
}
