package com.blued.android.module.live_china.fitem.randomgift;

import android.content.Context;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.RandomGiftItemModel;
import com.blued.android.module.live_china.model.RandomGiftItemTaskModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/randomgift/FitemRandomGiftTaskItem.class */
public final class FitemRandomGiftTaskItem extends FreedomItem {
    private RandomGiftItemTaskModel b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<FitemRandomGiftTaskAwardItem> f12692c;
    private FreedomAdapter d;

    public FitemRandomGiftTaskItem(RandomGiftItemTaskModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
        this.f12692c = new ArrayList<>();
    }

    private final void e() {
        RecyclerView recyclerView = (RecyclerView) this.f10935a.a(R.id.rv_list);
        recyclerView.setLayoutManager(new GridLayoutManager(this.f10935a.f10931a.b, 3));
        this.d = new FreedomAdapter(this.f10935a.f10931a.b, this.f10935a.b, this.f12692c);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(this.d);
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_random_gift_task_item;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(vh, "vh");
        vh.a(R.id.tv_title, true).a(R.id.tv_title, (CharSequence) this.b.getTitle()).a(R.id.tv_progress, (CharSequence) AppInfo.d().getString(R.string.live_random_gift_task_not_finish, Integer.valueOf(this.b.getCurrent()), Integer.valueOf(this.b.getFull())));
        this.f12692c.clear();
        ArrayList<RandomGiftItemModel> rewards = this.b.getRewards();
        if (rewards == null) {
            return;
        }
        for (RandomGiftItemModel randomGiftItemModel : rewards) {
            this.f12692c.add(new FitemRandomGiftTaskAwardItem(randomGiftItemModel));
        }
        e();
    }
}
