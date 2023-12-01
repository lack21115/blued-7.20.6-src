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

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<FitemRandomGiftTaskItem> f12691c;
    private FreedomAdapter d;

    public FitemRandomGiftTask(ArrayList<RandomGiftItemTaskModel> datas) {
        Intrinsics.e(datas, "datas");
        this.b = datas;
        this.f12691c = new ArrayList<>();
    }

    private final void e() {
        RecyclerView recyclerView = (RecyclerView) this.f10935a.a(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f10935a.f10931a.b));
        this.d = new FreedomAdapter(this.f10935a.f10931a.b, this.f10935a.b, this.f12691c);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(this.d);
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_random_gift_task;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(vh, "vh");
        vh.a(R.id.tv_title, true);
        this.f12691c.clear();
        ArrayList<RandomGiftItemTaskModel> arrayList = this.b;
        if (arrayList != null) {
            for (RandomGiftItemTaskModel randomGiftItemTaskModel : arrayList) {
                this.f12691c.add(new FitemRandomGiftTaskItem(randomGiftItemTaskModel));
            }
        }
        e();
    }
}
