package com.blued.android.module.live_china.fitem.randomgift;

import android.content.Context;
import android.view.View;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.RandomGiftItemModel;
import com.blued.android.module.live_china.utils.LiveUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/randomgift/FitemRandomGiftLoveItem.class */
public final class FitemRandomGiftLoveItem extends FreedomItem {
    private RandomGiftItemModel b;

    public FitemRandomGiftLoveItem(RandomGiftItemModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_random_gift_love_item;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(vh, "vh");
        vh.b(R.id.rl_probability_up, this.b.is_hide() == 1 && this.b.is_percent_fly() == 1).a(R.id.iv_gift, this.b.getGoods_icon()).a(R.id.tv_name, (CharSequence) this.b.getGoods_name()).a(R.id.tv_name, true);
        if (this.b.getLight_count() > 0) {
            vh.d(R.id.tv_lighten_count).a(R.id.tv_lighten_count, (CharSequence) AppInfo.d().getString(R.string.live_random_gift_love_lighten_count, this.b.getLight_count() > 999 ? "999+" : String.valueOf(this.b.getLight_count()))).a(R.id.tv_lighten_count, LiveUtils.a(vh.b(R.id.tv_lighten_count), "#FF7B00", false)).a(R.id.iv_gift, 1.0f).b(R.id.tv_hide, this.b.is_hide() == 1);
            String str = (String) vh.f10931a.a("highlight", "");
            Integer full_times = (Integer) vh.f10931a.a("full_times", (String) 0);
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                Intrinsics.c(full_times, "full_times");
                if (full_times.intValue() > 0 && this.b.getLight_count() > full_times.intValue()) {
                    vh.d(R.id.iv_gift_highlight).a(R.id.iv_gift_highlight, str, true, -1);
                }
            }
            vh.c(R.id.iv_gift_highlight);
        } else {
            vh.c(R.id.tv_lighten_count).a(R.id.iv_gift, 0.3f).c(R.id.iv_gift_highlight);
        }
        View view = vh.itemView;
        if (view == null) {
            return;
        }
        Object a2 = vh.f10931a.a("is_horizontal", (String) false);
        Intrinsics.c(a2, "vh.adapter.getVar(\"is_horizontal\", false)");
        if (((Boolean) a2).booleanValue()) {
            view.getLayoutParams().width = -1;
        } else {
            view.getLayoutParams().width = -2;
        }
    }
}
