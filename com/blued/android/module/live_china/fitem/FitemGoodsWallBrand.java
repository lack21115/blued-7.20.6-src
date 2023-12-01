package com.blued.android.module.live_china.fitem;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.common.utils.freedom.clickcallback.onViewRecycledCallback;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.GoodsWallBrandItemModel;
import com.blued.android.module.live_china.utils.LiveCloakingUtil;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemGoodsWallBrand.class */
public final class FitemGoodsWallBrand extends FreedomItem {
    private GoodsWallBrandItemModel b;

    public FitemGoodsWallBrand(GoodsWallBrandItemModel mode) {
        Intrinsics.e(mode, "mode");
        this.b = mode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.05f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ofFloat.setDuration(1080L);
        ofFloat.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.05f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setDuration(1080L);
        ofFloat2.start();
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_goods_wall_brand;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        vh.a(R.id.iv_avatar, this.b.getAvatar(), R.drawable.icon_desire_funders_default, true).a(R.id.iv_avatar_frame, this.b.getAvatar_frame(), true, -1).a(R.id.tv_name, (CharSequence) LiveCloakingUtil.a(this.b.getUsername(), this.b.is_hide())).a(R.id.tv_goods, (CharSequence) AppInfo.d().getString(R.string.live_goods_wall_brand_item_subtitle, Intrinsics.a("  ", (Object) this.b.getGoods_name()))).a(R.id.iv_goosd, this.b.getGoods_image()).a(R.id.tv_num, (CharSequence) String.valueOf(this.b.getGoods_count())).a(R.id.tv_name, true).a(R.id.tv_goods, true).a(R.id.tv_num_prefix, true).a(R.id.tv_num, true).b(R.id.tv_num_prefix, this.b.getGoods_count() > 1).b(R.id.tv_num, this.b.getGoods_count() > 1);
        final View a = vh.a(R.id.iv_goosd);
        a.getScaleX();
        a.post(new Runnable() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemGoodsWallBrand$7BDX4k8M2ILekjSKQW2YwpqbOP0
            @Override // java.lang.Runnable
            public final void run() {
                FitemGoodsWallBrand.a(View.this);
            }
        });
        final SVGAImageView sVGAImageView = (SVGAImageView) vh.a(R.id.svga_bg);
        sVGAImageView.setMIsNeedOnDetachedFromWindow(false);
        SVGAParser.a(SVGAParser.a.b(), "live_bg_goods_wall_brand_back.svga", new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.live_china.fitem.FitemGoodsWallBrand$initBindView$2
            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(SVGAVideoEntity videoItem) {
                Intrinsics.e(videoItem, "videoItem");
                SVGAImageView.this.setVideoItem(videoItem);
                SVGAImageView.this.a(0, true);
            }

            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        }, (SVGAParser.PlayCallback) null, 4, (Object) null);
        vh.c = new onViewRecycledCallback() { // from class: com.blued.android.module.live_china.fitem.FitemGoodsWallBrand$initBindView$3
            @Override // com.blued.android.module.common.utils.freedom.clickcallback.onViewRecycledCallback
            public void a() {
                SVGAImageView.this.e();
            }
        };
    }
}
