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

    /* renamed from: a  reason: collision with root package name */
    public final YyBaseMusicTabLoadErrorBinding f11398a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ProgressBar f11399c;
    public final RecyclerView d;
    public final TextView e;
    public final ViewPager f;
    private final LinearLayout g;

    private YyBaseMusicMainViewBinding(LinearLayout linearLayout, YyBaseMusicTabLoadErrorBinding yyBaseMusicTabLoadErrorBinding, ImageView imageView, ProgressBar progressBar, RecyclerView recyclerView, TextView textView, ViewPager viewPager) {
        this.g = linearLayout;
        this.f11398a = yyBaseMusicTabLoadErrorBinding;
        this.b = imageView;
        this.f11399c = progressBar;
        this.d = recyclerView;
        this.e = textView;
        this.f = viewPager;
    }

    public static YyBaseMusicMainViewBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.inc_load_error);
        if (findViewById != null) {
            YyBaseMusicTabLoadErrorBinding a2 = YyBaseMusicTabLoadErrorBinding.a(findViewById);
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_search);
            if (imageView != null) {
                ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.loading_view);
                if (progressBar != null) {
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_tab);
                    if (recyclerView != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_music_title);
                        if (textView != null) {
                            ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
                            if (viewPager != null) {
                                return new YyBaseMusicMainViewBinding((LinearLayout) view, a2, imageView, progressBar, recyclerView, textView, viewPager);
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.g;
    }
}
