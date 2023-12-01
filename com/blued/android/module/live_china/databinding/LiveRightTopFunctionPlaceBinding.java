package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.view.righttopfunction.LiveFloatGoodsWallView;
import com.blued.android.module.live_china.view.righttopfunction.LiveWishView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveRightTopFunctionPlaceBinding.class */
public final class LiveRightTopFunctionPlaceBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f12414a;
    public final LiveFloatGoodsWallView b;

    /* renamed from: c  reason: collision with root package name */
    public final LiveWishView f12415c;
    private final FrameLayout d;

    private LiveRightTopFunctionPlaceBinding(FrameLayout frameLayout, FrameLayout frameLayout2, LiveFloatGoodsWallView liveFloatGoodsWallView, LiveWishView liveWishView) {
        this.d = frameLayout;
        this.f12414a = frameLayout2;
        this.b = liveFloatGoodsWallView;
        this.f12415c = liveWishView;
    }

    public static LiveRightTopFunctionPlaceBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_root);
        if (frameLayout != null) {
            LiveFloatGoodsWallView liveFloatGoodsWallView = (LiveFloatGoodsWallView) view.findViewById(R.id.live_goods_wall);
            if (liveFloatGoodsWallView != null) {
                LiveWishView liveWishView = (LiveWishView) view.findViewById(R.id.live_wish_view);
                if (liveWishView != null) {
                    return new LiveRightTopFunctionPlaceBinding((FrameLayout) view, frameLayout, liveFloatGoodsWallView, liveWishView);
                }
                str = "liveWishView";
            } else {
                str = "liveGoodsWall";
            }
        } else {
            str = "flRoot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.d;
    }
}
