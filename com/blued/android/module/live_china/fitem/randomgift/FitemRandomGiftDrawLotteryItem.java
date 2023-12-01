package com.blued.android.module.live_china.fitem.randomgift;

import android.content.Context;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.RandomGiftItemModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/randomgift/FitemRandomGiftDrawLotteryItem.class */
public final class FitemRandomGiftDrawLotteryItem extends FreedomItem {
    private RandomGiftItemModel b;

    public FitemRandomGiftDrawLotteryItem(RandomGiftItemModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_random_gift_draw_lottery_item;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(vh, "vh");
        vh.a(R.id.tv_tag, true).a(R.id.tv_name, true).a(R.id.tv_desc, true).a(R.id.tv_probability, true).a(R.id.iv_gift, this.b.getGoods_icon()).a(R.id.tv_name, (CharSequence) this.b.getGoods_name()).a(R.id.tv_probability, (CharSequence) this.b.getRandom_weight());
        String label = this.b.getLabel();
        if (label == null || label.length() == 0) {
            vh.c(R.id.tv_tag);
            vh.a(R.id.tv_name).setTranslationY(DisplayUtil.a(AppInfo.d(), 7.0f));
        } else {
            vh.a(R.id.tv_tag, (CharSequence) this.b.getLabel());
            vh.d(R.id.tv_tag);
            vh.a(R.id.tv_name).setTranslationY(0.0f);
        }
        String goods_type = this.b.getGoods_type();
        boolean z = true;
        if (goods_type != null) {
            z = goods_type.length() == 0;
        }
        if (z) {
            vh.a(R.id.tv_desc, "").a(R.id.tv_name).setTranslationY(DisplayUtil.a(AppInfo.d(), 7.0f));
        } else {
            vh.a(R.id.tv_desc, (CharSequence) this.b.getGoods_type()).a(R.id.tv_name).setTranslationY(0.0f);
        }
    }
}
