package com.soft.blued.ui.live.fitem;

import android.content.Context;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.soft.blued.R;
import com.soft.blued.ui.live.model.LivePersonalCollectionModel;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fitem/FitemPersonalCollection.class */
public class FitemPersonalCollection extends FreedomItem {
    public LivePersonalCollectionModel b;

    public FitemPersonalCollection(LivePersonalCollectionModel livePersonalCollectionModel) {
        this.b = livePersonalCollectionModel;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_personal_collection;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder baseViewHolder, List<FreedomItem> list, int i) {
        baseViewHolder.a(2131365504, this.b.icon).a(2131372754, (CharSequence) this.b.name);
    }
}
