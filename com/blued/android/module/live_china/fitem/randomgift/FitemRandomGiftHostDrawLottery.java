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

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<FitemRandomGiftDrawLotteryItem> f12685c;
    private FreedomAdapter d;

    public FitemRandomGiftHostDrawLottery(ArrayList<RandomGiftItemModel> datas) {
        Intrinsics.e(datas, "datas");
        this.b = datas;
        this.f12685c = new ArrayList<>();
    }

    private final void e() {
        RecyclerView recyclerView = (RecyclerView) this.f10935a.a(R.id.rv_list);
        recyclerView.setLayoutManager(new GridLayoutManager(this.f10935a.f10931a.b, 4));
        this.d = new FreedomAdapter(this.f10935a.f10931a.b, this.f10935a.b, this.f12685c);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(this.d);
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_random_gift_host_draw_lottery;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(vh, "vh");
        vh.a(R.id.tv_title, true);
        this.f12685c.clear();
        for (RandomGiftItemModel randomGiftItemModel : this.b) {
            if (randomGiftItemModel != null) {
                this.f12685c.add(new FitemRandomGiftDrawLotteryItem(randomGiftItemModel));
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
