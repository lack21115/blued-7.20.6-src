package com.blued.android.module.live_china.fitem.randomgift;

import android.content.Context;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.RandomGiftItemModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/randomgift/FitemRandomGiftHostDrawLottery.class */
public final class FitemRandomGiftHostDrawLottery extends FreedomItem {
    private ArrayList<RandomGiftItemModel> b;
    private final ArrayList<FitemRandomGiftDrawLotteryItem> c;
    private FreedomAdapter d;

    public FitemRandomGiftHostDrawLottery(ArrayList<RandomGiftItemModel> datas) {
        Intrinsics.e(datas, "datas");
        this.b = datas;
        this.c = new ArrayList<>();
    }

    private final void e() {
        RecyclerView a = this.a.a(R.id.rv_list);
        a.setLayoutManager(new GridLayoutManager(this.a.a.b, 4));
        this.d = new FreedomAdapter(this.a.a.b, this.a.b, this.c);
        a.setItemAnimator(new DefaultItemAnimator());
        a.setAdapter(this.d);
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_random_gift_host_draw_lottery;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(vh, "vh");
        vh.a(R.id.tv_title, true);
        this.c.clear();
        for (RandomGiftItemModel randomGiftItemModel : this.b) {
            if (randomGiftItemModel != null) {
                this.c.add(new FitemRandomGiftDrawLotteryItem(randomGiftItemModel));
            }
        }
        RandomGiftItemModel randomGiftItemModel2 = this.b.get(0);
        String current_random_weight = randomGiftItemModel2 == null ? null : randomGiftItemModel2.getCurrent_random_weight();
        if (current_random_weight != null ? current_random_weight.length() == 0 : true) {
            vh.c(R.id.tv_list_title_current_probability);
        } else {
            vh.d(R.id.tv_list_title_current_probability);
        }
        e();
    }
}
