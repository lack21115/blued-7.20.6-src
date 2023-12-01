package com.blued.android.module.live_china.fitem;

import android.content.Context;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.GiftConstellationAwardItemModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemGiftConstellation.class */
public final class FitemGiftConstellation extends FreedomItem {
    private final GiftConstellationAwardItemModel b;

    public FitemGiftConstellation(GiftConstellationAwardItemModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_gift_constellation;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(vh, "vh");
        vh.a(R.id.tv_constellation, (CharSequence) this.b.getName()).a(R.id.iv_constellation_icon, this.b.getImage(), true, -1).a(R.id.tv_constellation_award, (CharSequence) this.b.getType_name());
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public float c() {
        return 0.25f;
    }
}
