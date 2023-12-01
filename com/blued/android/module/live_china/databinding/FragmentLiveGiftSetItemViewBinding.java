package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live.base.view.clickanimview.BamTextView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/FragmentLiveGiftSetItemViewBinding.class */
public final class FragmentLiveGiftSetItemViewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeFrameLayout f11936a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f11937c;
    public final LinearLayout d;
    public final ProgressBar e;
    public final RecyclerView f;
    public final RecyclerView g;
    public final ShapeFrameLayout h;
    public final BamTextView i;
    public final ShapeTextView j;
    public final TextView k;
    private final NestedScrollView l;

    private FragmentLiveGiftSetItemViewBinding(NestedScrollView nestedScrollView, ShapeFrameLayout shapeFrameLayout, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, ProgressBar progressBar, RecyclerView recyclerView, RecyclerView recyclerView2, ShapeFrameLayout shapeFrameLayout2, BamTextView bamTextView, ShapeTextView shapeTextView, TextView textView) {
        this.l = nestedScrollView;
        this.f11936a = shapeFrameLayout;
        this.b = imageView;
        this.f11937c = linearLayout;
        this.d = linearLayout2;
        this.e = progressBar;
        this.f = recyclerView;
        this.g = recyclerView2;
        this.h = shapeFrameLayout2;
        this.i = bamTextView;
        this.j = shapeTextView;
        this.k = textView;
    }

    public static FragmentLiveGiftSetItemViewBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static FragmentLiveGiftSetItemViewBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_live_gift_set_item_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static FragmentLiveGiftSetItemViewBinding a(View view) {
        String str;
        ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.fl_extra);
        if (shapeFrameLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_count_down);
            if (imageView != null) {
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_main);
                if (linearLayout != null) {
                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_task);
                    if (linearLayout2 != null) {
                        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.pro_bar);
                        if (progressBar != null) {
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_extra);
                            if (recyclerView != null) {
                                RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rv_list);
                                if (recyclerView2 != null) {
                                    ShapeFrameLayout shapeFrameLayout2 = (ShapeFrameLayout) view.findViewById(R.id.sf_task);
                                    if (shapeFrameLayout2 != null) {
                                        BamTextView bamTextView = (BamTextView) view.findViewById(R.id.tv_all_send);
                                        if (bamTextView != null) {
                                            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_count_down);
                                            if (shapeTextView != null) {
                                                TextView textView = (TextView) view.findViewById(R.id.tv_des);
                                                if (textView != null) {
                                                    return new FragmentLiveGiftSetItemViewBinding((NestedScrollView) view, shapeFrameLayout, imageView, linearLayout, linearLayout2, progressBar, recyclerView, recyclerView2, shapeFrameLayout2, bamTextView, shapeTextView, textView);
                                                }
                                                str = "tvDes";
                                            } else {
                                                str = "tvCountDown";
                                            }
                                        } else {
                                            str = "tvAllSend";
                                        }
                                    } else {
                                        str = "sfTask";
                                    }
                                } else {
                                    str = "rvList";
                                }
                            } else {
                                str = "rvExtra";
                            }
                        } else {
                            str = "proBar";
                        }
                    } else {
                        str = "llTask";
                    }
                } else {
                    str = "llMain";
                }
            } else {
                str = "ivCountDown";
            }
        } else {
            str = "flExtra";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public NestedScrollView getRoot() {
        return this.l;
    }
}
