package com.blued.android.module.live_china.fitem;

import android.content.Context;
import android.view.View;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveBattleGiftModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemBattlePassAward.class */
public final class FitemBattlePassAward extends FreedomItem {
    private final LiveBattleGiftModel b;
    private final boolean c;

    public FitemBattlePassAward(LiveBattleGiftModel model, boolean z) {
        Intrinsics.e(model, "model");
        this.b = model;
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007c, code lost:
        if (r0.length() == 0) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(com.blued.android.module.live_china.fitem.FitemBattlePassAward r5, com.blued.android.module.common.utils.freedom.BaseViewHolder r6, android.view.View r7) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fitem.FitemBattlePassAward.a(com.blued.android.module.live_china.fitem.FitemBattlePassAward, com.blued.android.module.common.utils.freedom.BaseViewHolder, android.view.View):void");
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_battle_pass_award;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, final BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        BaseViewHolder a = vh.a(R.id.iv_icon, this.b.getIcon()).a(R.id.tv_count, (CharSequence) this.b.getLabel()).a(R.id.tv_count, true);
        int i2 = R.id.tv_count;
        String label = this.b.getLabel();
        a.b(i2, true ^ (label == null || label.length() == 0)).a(R.id.fl_root, new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemBattlePassAward$sz7n-UZ-5fUZnp6feXbYZpuP-NQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemBattlePassAward.a(FitemBattlePassAward.this, vh, view);
            }
        }).a(R.id.fl_root).setBackgroundResource(R.drawable.live_battle_gift_item_bg);
    }
}
