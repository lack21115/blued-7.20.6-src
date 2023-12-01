package com.blued.android.module.live_china.fitem;

import android.content.Context;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemBattlePassRandomAwardDesc.class */
public final class FitemBattlePassRandomAwardDesc extends FreedomItem {
    private final String b;

    public FitemBattlePassRandomAwardDesc(String desc) {
        Intrinsics.e(desc, "desc");
        this.b = desc;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_battle_pass_random_award_desc;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        vh.a(R.id.tv_info, (CharSequence) this.b);
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public float c() {
        return 1.0f;
    }
}
