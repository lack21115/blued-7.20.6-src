package com.blued.android.module.live_china.fitem;

import android.content.Context;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemRankHourHistoryTitle.class */
public final class FitemRankHourHistoryTitle extends FreedomItem {
    private String b;
    private boolean c;

    public FitemRankHourHistoryTitle(String text, boolean z) {
        Intrinsics.e(text, "text");
        this.b = text;
        this.c = z;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_rank_hour_history_title;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        vh.a(R.id.tv_date, (CharSequence) this.b).b(R.id.iv_hour_star, this.c).b(R.id.iv_potential_star, this.c);
    }
}
