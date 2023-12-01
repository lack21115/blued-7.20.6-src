package com.blued.android.module.live_china.fitem.randomgift;

import android.content.Context;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.RandomGiftItemModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/randomgift/FitemRandomGiftTaskAwardItem.class */
public final class FitemRandomGiftTaskAwardItem extends FreedomItem {
    private RandomGiftItemModel b;

    public FitemRandomGiftTaskAwardItem(RandomGiftItemModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_random_gift_task_award_item;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(vh, "vh");
        vh.a(R.id.iv_icom, this.b.getGoods_icon()).a(R.id.tv_title, (CharSequence) this.b.getTitle()).a(R.id.tv_desc, (CharSequence) this.b.getNext_title());
    }
}
