package com.blued.android.module.live_china.fitem;

import android.content.Context;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemGoodsWallBrandTitle.class */
public final class FitemGoodsWallBrandTitle extends FreedomItem {
    private String b;

    public FitemGoodsWallBrandTitle(String text) {
        Intrinsics.e(text, "text");
        this.b = text;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_goods_wall_brand_title;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        vh.a(R.id.tv_title, (CharSequence) this.b).a(R.id.tv_title, true);
    }
}
