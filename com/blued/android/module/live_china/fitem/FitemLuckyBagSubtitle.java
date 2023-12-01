package com.blued.android.module.live_china.fitem;

import android.content.Context;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.utils.LiveUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemLuckyBagSubtitle.class */
public final class FitemLuckyBagSubtitle extends FreedomItem {
    private final String b;

    public FitemLuckyBagSubtitle(String goods_name) {
        Intrinsics.e(goods_name, "goods_name");
        this.b = goods_name;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_lucky_bag_subtitle;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        vh.a(R.id.tv_subtitle, (CharSequence) context.getString(R.string.live_lucky_bag_subtitle, this.b)).a(R.id.tv_subtitle, LiveUtils.a(vh.b(R.id.tv_subtitle), "#B542D7", true));
    }
}
