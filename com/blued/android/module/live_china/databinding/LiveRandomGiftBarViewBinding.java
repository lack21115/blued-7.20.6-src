package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveRandomGiftBarViewBinding.class */
public final class LiveRandomGiftBarViewBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final RecyclerView c;
    public final ShapeTextView d;
    public final ShapeTextView e;
    private final RelativeLayout f;

    private LiveRandomGiftBarViewBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, RecyclerView recyclerView, ShapeTextView shapeTextView, ShapeTextView shapeTextView2) {
        this.f = relativeLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = recyclerView;
        this.d = shapeTextView;
        this.e = shapeTextView2;
    }

    public static LiveRandomGiftBarViewBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_random_gift_base_map);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_random_gift_img);
            if (imageView2 != null) {
                RecyclerView findViewById = view.findViewById(R.id.rv_list);
                if (findViewById != null) {
                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_random_gift_btn_lighten);
                    if (shapeTextView != null) {
                        ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_random_gift_btn_lottery);
                        if (shapeTextView2 != null) {
                            return new LiveRandomGiftBarViewBinding((RelativeLayout) view, imageView, imageView2, findViewById, shapeTextView, shapeTextView2);
                        }
                        str = "tvRandomGiftBtnLottery";
                    } else {
                        str = "tvRandomGiftBtnLighten";
                    }
                } else {
                    str = "rvList";
                }
            } else {
                str = "ivRandomGiftImg";
            }
        } else {
            str = "ivRandomGiftBaseMap";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.f;
    }
}
