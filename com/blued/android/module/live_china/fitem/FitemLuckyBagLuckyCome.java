package com.blued.android.module.live_china.fitem;

import android.content.Context;
import android.view.View;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LuckyBagLuckyComeModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.view.LiveLuckyBagSlopeProgressView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemLuckyBagLuckyCome.class */
public final class FitemLuckyBagLuckyCome extends FreedomItem {
    private final LuckyBagLuckyComeModel b;

    public FitemLuckyBagLuckyCome(LuckyBagLuckyComeModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        LiveSetDataObserver.a().b(LiveRoomInfo.a().j() ? "https://app.blued.cn/home/blind-box" : "https://app-testenv.blued.cn/home/blind-box", 0);
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_lucky_bag_lucky_come;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        ((LiveLuckyBagSlopeProgressView) vh.a(R.id.tv_progress, true).a(R.id.tv_progress, (CharSequence) String.valueOf(this.b.getCurrent())).a(R.id.tv_progress_count, (CharSequence) AppInfo.d().getString(R.string.live_lucky_bag_lucky_come_progress, Integer.valueOf(this.b.getMax()))).a(R.id.tv_lucky_come_subtitle, (CharSequence) this.b.getDesc()).a(R.id.slope_progress)).setProgress(this.b.getCurrent() / this.b.getMax());
        vh.a(R.id.iv_info, new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemLuckyBagLuckyCome$w6lMgX3kopwVsDh5jIZs2HoRySo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemLuckyBagLuckyCome.a(view);
            }
        });
    }
}
