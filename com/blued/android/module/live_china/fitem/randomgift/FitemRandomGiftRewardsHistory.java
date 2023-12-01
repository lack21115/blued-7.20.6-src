package com.blued.android.module.live_china.fitem.randomgift;

import android.content.Context;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.RandomGiftDialogRewardsHistoryDataModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/randomgift/FitemRandomGiftRewardsHistory.class */
public final class FitemRandomGiftRewardsHistory extends FreedomItem {
    private RandomGiftDialogRewardsHistoryDataModel b;

    public FitemRandomGiftRewardsHistory(RandomGiftDialogRewardsHistoryDataModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_random_gift_rewards_history;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(vh, "vh");
        vh.a(R.id.tv_name, (CharSequence) this.b.getTitle()).a(R.id.tv_name, true).a(R.id.tv_time, (CharSequence) this.b.getTime()).a(R.id.tv_time, true);
    }
}
