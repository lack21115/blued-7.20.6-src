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
    private final ArrayList<FitemRandomGiftTaskAwardItem> c;
    private FreedomAdapter d;

    public FitemRandomGiftTaskItem(RandomGiftItemTaskModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
        this.c = new ArrayList<>();
    }

    private final void e() {
        RecyclerView a = this.a.a(R.id.rv_list);
        a.setLayoutManager(new GridLayoutManager(this.a.a.b, 3));
        this.d = new FreedomAdapter(this.a.a.b, this.a.b, this.c);
        a.setItemAnimator(new DefaultItemAnimator());
        a.setAdapter(this.d);
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_random_gift_task_item;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(vh, "vh");
        vh.a(R.id.tv_title, true).a(R.id.tv_title, (CharSequence) this.b.getTitle()).a(R.id.tv_progress, (CharSequence) AppInfo.d().getString(R.string.live_random_gift_task_not_finish, Integer.valueOf(this.b.getCurrent()), Integer.valueOf(this.b.getFull())));
        this.c.clear();
        ArrayList<RandomGiftItemModel> rewards = this.b.getRewards();
        if (rewards == null) {
            return;
        }
        for (RandomGiftItemModel randomGiftItemModel : rewards) {
            this.c.add(new FitemRandomGiftTaskAwardItem(randomGiftItemModel));
        }
        e();
    }
}
