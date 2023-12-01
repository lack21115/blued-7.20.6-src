package com.blued.android.module.live_china.fitem;

import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.GoodsWallTaskAwardItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemGoodsWallTaskGoods.class */
public final class FitemGoodsWallTaskGoods extends FreedomItem {
    private GoodsWallTaskAwardItemModel b;

    public FitemGoodsWallTaskGoods(GoodsWallTaskAwardItemModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_goods_wall_task_goods;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x008e, code lost:
        if (r0.length() == 0) goto L13;
     */
    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r6, com.blued.android.module.common.utils.freedom.BaseViewHolder r7, java.util.List<com.blued.android.module.common.utils.freedom.FreedomItem> r8, int r9) {
        /*
            r5 = this;
            r0 = r6
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r7
            java.lang.String r1 = "vh"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            int r0 = com.blued.android.module.live_china.R.id.tv_tag
            r11 = r0
            r0 = r5
            com.blued.android.module.live_china.model.GoodsWallTaskAwardItemModel r0 = r0.b
            java.lang.String r0 = r0.getBadge()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6 = r0
            r0 = 0
            r10 = r0
            r0 = r6
            if (r0 == 0) goto L35
            r0 = r6
            int r0 = r0.length()
            if (r0 != 0) goto L2f
            goto L35
        L2f:
            r0 = 0
            r9 = r0
            goto L38
        L35:
            r0 = 1
            r9 = r0
        L38:
            r0 = r7
            r1 = r11
            r2 = r9
            r3 = 1
            r2 = r2 ^ r3
            com.blued.android.module.common.utils.freedom.BaseViewHolder r0 = r0.b(r1, r2)
            int r1 = com.blued.android.module.live_china.R.id.tv_tag
            r2 = r5
            com.blued.android.module.live_china.model.GoodsWallTaskAwardItemModel r2 = r2.b
            java.lang.String r2 = r2.getBadge()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            com.blued.android.module.common.utils.freedom.BaseViewHolder r0 = r0.a(r1, r2)
            int r1 = com.blued.android.module.live_china.R.id.iv_goods
            r2 = r5
            com.blued.android.module.live_china.model.GoodsWallTaskAwardItemModel r2 = r2.b
            java.lang.String r2 = r2.getIcon()
            com.blued.android.module.common.utils.freedom.BaseViewHolder r0 = r0.a(r1, r2)
            int r1 = com.blued.android.module.live_china.R.id.tv_name
            r2 = r5
            com.blued.android.module.live_china.model.GoodsWallTaskAwardItemModel r2 = r2.b
            java.lang.String r2 = r2.getName()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            com.blued.android.module.common.utils.freedom.BaseViewHolder r0 = r0.a(r1, r2)
            r6 = r0
            int r0 = com.blued.android.module.live_china.R.id.tv_desc
            r11 = r0
            r0 = r5
            com.blued.android.module.live_china.model.GoodsWallTaskAwardItemModel r0 = r0.b
            java.lang.String r0 = r0.getType()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L91
            r0 = r10
            r9 = r0
            r0 = r8
            int r0 = r0.length()
            if (r0 != 0) goto L94
        L91:
            r0 = 1
            r9 = r0
        L94:
            r0 = r6
            r1 = r11
            r2 = r9
            r3 = 1
            r2 = r2 ^ r3
            com.blued.android.module.common.utils.freedom.BaseViewHolder r0 = r0.b(r1, r2)
            int r1 = com.blued.android.module.live_china.R.id.tv_desc
            r2 = r5
            com.blued.android.module.live_china.model.GoodsWallTaskAwardItemModel r2 = r2.b
            java.lang.String r2 = r2.getType()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            com.blued.android.module.common.utils.freedom.BaseViewHolder r0 = r0.a(r1, r2)
            r0 = r7
            com.blued.android.core.net.IRequestHost r0 = r0.b
            java.lang.String r1 = "live_bg_goods_wall_task_item.png"
            com.blued.android.core.image.ImageWrapper r0 = com.blued.android.core.image.ImageLoader.c(r0, r1)
            com.blued.android.core.image.ImageWrapper r0 = r0.g()
            r1 = -1
            com.blued.android.core.image.ImageWrapper r0 = r0.g(r1)
            r1 = r7
            int r2 = com.blued.android.module.live_china.R.id.iv_goods_border
            android.view.View r1 = r1.a(r2)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r0.a(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fitem.FitemGoodsWallTaskGoods.a(android.content.Context, com.blued.android.module.common.utils.freedom.BaseViewHolder, java.util.List, int):void");
    }
}
