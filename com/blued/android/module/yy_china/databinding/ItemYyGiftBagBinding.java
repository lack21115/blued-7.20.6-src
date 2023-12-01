package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYGiftHitLoadingView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyGiftBagBinding.class */
public final class ItemYyGiftBagBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16721a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16722c;
    public final YYGiftHitLoadingView d;
    public final TextView e;
    public final SquareImageView f;
    public final ShapeTextView g;
    public final ImageView h;
    private final FrameLayout i;

    private ItemYyGiftBagBinding(FrameLayout frameLayout, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, TextView textView, YYGiftHitLoadingView yYGiftHitLoadingView, TextView textView2, SquareImageView squareImageView, ShapeTextView shapeTextView3, ImageView imageView) {
        this.i = frameLayout;
        this.f16721a = shapeTextView;
        this.b = shapeTextView2;
        this.f16722c = textView;
        this.d = yYGiftHitLoadingView;
        this.e = textView2;
        this.f = squareImageView;
        this.g = shapeTextView3;
        this.h = imageView;
    }

    public static ItemYyGiftBagBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.item_fans_level);
        if (shapeTextView != null) {
            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.item_live_gift_count);
            if (shapeTextView2 != null) {
                TextView textView = (TextView) view.findViewById(R.id.item_live_gift_expiry);
                if (textView != null) {
                    YYGiftHitLoadingView yYGiftHitLoadingView = (YYGiftHitLoadingView) view.findViewById(R.id.item_live_gift_hit_loading);
                    if (yYGiftHitLoadingView != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.item_live_gift_name);
                        if (textView2 != null) {
                            SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.item_live_gift_view_iv);
                            if (squareImageView != null) {
                                ShapeTextView shapeTextView3 = (ShapeTextView) view.findViewById(R.id.item_live_gift_week_star);
                                if (shapeTextView3 != null) {
                                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
                                    if (imageView != null) {
                                        return new ItemYyGiftBagBinding((FrameLayout) view, shapeTextView, shapeTextView2, textView, yYGiftHitLoadingView, textView2, squareImageView, shapeTextView3, imageView);
                                    }
                                    str = "ivBack";
                                } else {
                                    str = "itemLiveGiftWeekStar";
                                }
                            } else {
                                str = "itemLiveGiftViewIv";
                            }
                        } else {
                            str = "itemLiveGiftName";
                        }
                    } else {
                        str = "itemLiveGiftHitLoading";
                    }
                } else {
                    str = "itemLiveGiftExpiry";
                }
            } else {
                str = "itemLiveGiftCount";
            }
        } else {
            str = "itemFansLevel";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.i;
    }
}
