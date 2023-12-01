package com.blued.android.module.live_china.rank;

import android.content.Context;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/rank/FitemRankHostExtra.class */
public final class FitemRankHostExtra extends FreedomItem {
    private final String b;
    private final int c;

    public FitemRankHostExtra(String str, int i) {
        this.b = str;
        this.c = i;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_rank_host_extra;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        if (Intrinsics.a((Object) this.b, (Object) "fans")) {
            vh.a(R.id.tv_extra_rank_label, "最爱主播").d(R.id.rl_extra_rank_label, R.drawable.rank_extra_user_bg).a(R.id.iv_extra_rank_icon, "https://web.bldimg.com/image-manager/1689582813_49898.webp").a(R.id.iv_list_bg, "https://web.bldimg.com/image-manager/1689748217_30812.webp").a(R.id.tv_extra_rank_name, "用户");
        } else if (Intrinsics.a((Object) this.b, (Object) "anchor")) {
            vh.a(R.id.tv_extra_rank_label, "忠实粉丝").d(R.id.rl_extra_rank_label, R.drawable.rank_extra_host_bg).a(R.id.iv_extra_rank_icon, "https://web.bldimg.com/image-manager/1689582813_63824.webp").a(R.id.iv_list_bg, "https://web.bldimg.com/image-manager/1689746509_20748.webp").a(R.id.tv_extra_rank_name, "主播");
        } else {
            if (this.c == 0) {
                vh.a(R.id.tv_extra_rank_label, "公会之星").d(R.id.rl_extra_rank_label, R.drawable.rank_extra_union_bg).a(R.id.iv_extra_rank_icon, "https://web.bldimg.com/image-manager/1689582813_20837.webp").a(R.id.tv_extra_rank_name, "公会");
            } else {
                vh.a(R.id.tv_extra_rank_label, "MVP用户").d(R.id.rl_extra_rank_label, R.drawable.rank_extra_union_ladder_bg).a(R.id.iv_extra_rank_icon, "https://web.bldimg.com/image-manager/1689582813_52262.webp").a(R.id.tv_extra_rank_name, "主播");
            }
            vh.a(R.id.iv_list_bg, "https://web.bldimg.com/image-manager/1689748478_52108.webp");
        }
    }
}
