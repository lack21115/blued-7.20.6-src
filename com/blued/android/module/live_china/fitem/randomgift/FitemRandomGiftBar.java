package com.blued.android.module.live_china.fitem.randomgift;

import android.content.Context;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveGiftRandomBarItemModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/randomgift/FitemRandomGiftBar.class */
public final class FitemRandomGiftBar extends FreedomItem {
    private LiveGiftRandomBarItemModel b;

    public FitemRandomGiftBar(LiveGiftRandomBarItemModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_random_gift_bar;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(vh, "vh");
        boolean z = true;
        BaseViewHolder a = vh.a(R.id.iv_icom, this.b.getGoods_icon()).a(R.id.iv_icom, this.b.getLight() == 1 ? 1.0f : 0.4f);
        int i2 = R.id.iv_light;
        if (this.b.getLight() != 1) {
            z = false;
        }
        a.b(i2, z);
    }
}
