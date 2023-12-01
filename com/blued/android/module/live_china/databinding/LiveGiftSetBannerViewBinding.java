package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveGiftSetBannerViewBinding.class */
public final class LiveGiftSetBannerViewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f12225a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f12226c;
    public final RecyclerView d;
    public final TextView e;
    public final TextView f;
    private final FrameLayout g;

    private LiveGiftSetBannerViewBinding(FrameLayout frameLayout, ShapeTextView shapeTextView, ImageView imageView, ImageView imageView2, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.g = frameLayout;
        this.f12225a = shapeTextView;
        this.b = imageView;
        this.f12226c = imageView2;
        this.d = recyclerView;
        this.e = textView;
        this.f = textView2;
    }

    public static LiveGiftSetBannerViewBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_gift_set_banner_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveGiftSetBannerViewBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.all_send);
        if (shapeTextView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_anim_one);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_anim_two);
                if (imageView2 != null) {
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
                    if (recyclerView != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_look);
                        if (textView != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_title);
                            if (textView2 != null) {
                                return new LiveGiftSetBannerViewBinding((FrameLayout) view, shapeTextView, imageView, imageView2, recyclerView, textView, textView2);
                            }
                            str = "tvTitle";
                        } else {
                            str = "tvLook";
                        }
                    } else {
                        str = "rvList";
                    }
                } else {
                    str = "ivAnimTwo";
                }
            } else {
                str = "ivAnimOne";
            }
        } else {
            str = "allSend";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.g;
    }
}
