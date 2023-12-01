package com.blued.android.module.live_china.fitem.randomgift;

import android.content.Context;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.RandomGiftItemTaskModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/randomgift/FitemRandomGiftTask.class */
public final class FitemRandomGiftTask extends FreedomItem {
    private ArrayList<RandomGiftItemTaskModel> b;
    private final ArrayList<FitemRandomGiftTaskItem> c;
    private FreedomAdapter d;

    public FitemRandomGiftTask(ArrayList<RandomGiftItemTaskModel> datas) {
        Intrinsics.e(datas, "datas");
        this.b = datas;
        this.c = new ArrayList<>();
    }

    private final void e() {
        RecyclerView a = this.a.a(R.id.rv_list);
        a.setLayoutManager(new LinearLayoutManager(this.a.a.b));
        this.d = new FreedomAdapter(this.a.a.b, this.a.b, this.c);
        a.setItemAnimator(new DefaultItemAnimator());
        a.setAdapter(this.d);
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_random_gift_task;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(vh, "vh");
        vh.a(R.id.tv_title, true);
        this.c.clear();
        ArrayList<RandomGiftItemTaskModel> arrayList = this.b;
        if (arrayList != null) {
            for (RandomGiftItemTaskModel randomGiftItemTaskModel : arrayList) {
                this.c.add(new FitemRandomGiftTaskItem(randomGiftItemTaskModel));
            }
        }
        e();
    }
}
