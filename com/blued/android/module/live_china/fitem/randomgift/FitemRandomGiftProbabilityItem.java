package com.blued.android.module.live_china.fitem.randomgift;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.RandomGiftItemModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/randomgift/FitemRandomGiftProbabilityItem.class */
public final class FitemRandomGiftProbabilityItem extends FreedomItem {
    private RandomGiftItemModel b;

    public FitemRandomGiftProbabilityItem(RandomGiftItemModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_random_gift_probability_item;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(vh, "vh");
        vh.a(R.id.tv_name, (CharSequence) this.b.getGoods_name()).a(R.id.iv_icon, this.b.getGoods_icon()).a(R.id.tv_probability, (CharSequence) this.b.getInit_random_weight());
        String current_random_weight = this.b.getCurrent_random_weight();
        boolean z = false;
        if (current_random_weight == null || current_random_weight.length() == 0) {
            vh.c(R.id.rl_current_probability);
            return;
        }
        BaseViewHolder a2 = vh.a(R.id.tv_current_probability, (CharSequence) this.b.getCurrent_random_weight());
        int i2 = R.id.iv_up_arrows;
        if (this.b.is_percent_fly() == 1) {
            z = true;
        }
        a2.b(i2, z).d(R.id.rl_current_probability).b(R.id.tv_current_probability, ContextCompat.getColor(vh.f10931a.b, this.b.is_percent_fly() == 1 ? R.color.syc_dark_FF7B00 : R.color.syc_dark_222));
    }
}
