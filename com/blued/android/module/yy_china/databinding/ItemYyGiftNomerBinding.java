package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYGiftHitLoadingView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyGiftNomerBinding.class */
public final class ItemYyGiftNomerBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16723a;
    public final YYGiftHitLoadingView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16724c;
    public final TextView d;
    public final SquareImageView e;
    public final ShapeTextView f;
    public final ImageView g;
    public final ShapeConstraintLayout h;
    private final FrameLayout i;

    private ItemYyGiftNomerBinding(FrameLayout frameLayout, ShapeTextView shapeTextView, YYGiftHitLoadingView yYGiftHitLoadingView, TextView textView, TextView textView2, SquareImageView squareImageView, ShapeTextView shapeTextView2, ImageView imageView, ShapeConstraintLayout shapeConstraintLayout) {
        this.i = frameLayout;
        this.f16723a = shapeTextView;
        this.b = yYGiftHitLoadingView;
        this.f16724c = textView;
        this.d = textView2;
        this.e = squareImageView;
        this.f = shapeTextView2;
        this.g = imageView;
        this.h = shapeConstraintLayout;
    }

    public static ItemYyGiftNomerBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.item_fans_level);
        if (shapeTextView != null) {
            YYGiftHitLoadingView yYGiftHitLoadingView = (YYGiftHitLoadingView) view.findViewById(R.id.item_live_gift_hit_loading);
            if (yYGiftHitLoadingView != null) {
                TextView textView = (TextView) view.findViewById(R.id.item_live_gift_name);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.item_live_gift_price);
                    if (textView2 != null) {
                        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.item_live_gift_view_iv);
                        if (squareImageView != null) {
                            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.item_live_gift_week_star);
                            if (shapeTextView2 != null) {
                                ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
                                if (imageView != null) {
                                    ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.sha_ll_gift);
                                    if (shapeConstraintLayout != null) {
                                        return new ItemYyGiftNomerBinding((FrameLayout) view, shapeTextView, yYGiftHitLoadingView, textView, textView2, squareImageView, shapeTextView2, imageView, shapeConstraintLayout);
                                    }
                                    str = "shaLlGift";
                                } else {
                                    str = "ivBack";
                                }
                            } else {
                                str = "itemLiveGiftWeekStar";
                            }
                        } else {
                            str = "itemLiveGiftViewIv";
                        }
                    } else {
                        str = "itemLiveGiftPrice";
                    }
                } else {
                    str = "itemLiveGiftName";
                }
            } else {
                str = "itemLiveGiftHitLoading";
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
