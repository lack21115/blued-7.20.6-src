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
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemBattlePassRandomAward.class */
public final class FitemBattlePassRandomAward extends FreedomItem {
    private final LiveBattleGiftModel b;

    public FitemBattlePassRandomAward(LiveBattleGiftModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007c, code lost:
        if (r0.length() == 0) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(com.blued.android.module.live_china.fitem.FitemBattlePassRandomAward r5, com.blued.android.module.common.utils.freedom.BaseViewHolder r6, android.view.View r7) {
        /*
            r0 = r5
            java.lang.String r1 = "this$0"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r6
            java.lang.String r1 = "$vh"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r5
            com.blued.android.module.live_china.model.LiveBattleGiftModel r0 = r0.b
            java.lang.String r0 = r0.getBubble_url()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r10 = r0
            r0 = 0
            r9 = r0
            r0 = r10
            if (r0 == 0) goto L32
            r0 = r10
            int r0 = r0.length()
            if (r0 != 0) goto L2d
            goto L32
        L2d:
            r0 = 0
            r8 = r0
            goto L34
        L32:
            r0 = 1
            r8 = r0
        L34:
            r0 = r8
            if (r0 != 0) goto Ld0
            r0 = r5
            com.blued.android.module.live_china.model.LiveBattleGiftModel r0 = r0.b
            java.lang.String r0 = r0.getBubble_title()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L5b
            r0 = r10
            int r0 = r0.length()
            if (r0 != 0) goto L56
            goto L5b
        L56:
            r0 = 0
            r8 = r0
            goto L5d
        L5b:
            r0 = 1
            r8 = r0
        L5d:
            r0 = r8
            if (r0 != 0) goto Ld0
            r0 = r5
            com.blued.android.module.live_china.model.LiveBattleGiftModel r0 = r0.b
            java.lang.String r0 = r0.getBubble_desc()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L7f
            r0 = r9
            r8 = r0
            r0 = r10
            int r0 = r0.length()
            if (r0 != 0) goto L81
        L7f:
            r0 = 1
            r8 = r0
        L81:
            r0 = r8
            if (r0 != 0) goto Ld0
            com.blued.android.module.live_china.model.BattlePassLevelAwardDataModel r0 = new com.blued.android.module.live_china.model.BattlePassLevelAwardDataModel
            r1 = r0
            r1.<init>()
            r10 = r0
            r0 = r10
            r1 = r5
            com.blued.android.module.live_china.model.LiveBattleGiftModel r1 = r1.b
            java.lang.String r1 = r1.getBubble_url()
            r0.setBubble_url(r1)
            r0 = r10
            r1 = r5
            com.blued.android.module.live_china.model.LiveBattleGiftModel r1 = r1.b
            java.lang.String r1 = r1.getBubble_title()
            r0.setBubble_title(r1)
            r0 = r10
            r1 = r5
            com.blued.android.module.live_china.model.LiveBattleGiftModel r1 = r1.b
            java.lang.String r1 = r1.getBubble_desc()
            r0.setBubble_desc(r1)
            r0 = r6
            com.blued.android.module.common.utils.freedom.FreedomAdapter r0 = r0.a
            android.content.Context r0 = r0.b
            r5 = r0
            r0 = r5
            java.lang.String r1 = "vh.adapter.mContext"
            kotlin.jvm.internal.Intrinsics.c(r0, r1)
            com.blued.android.module.live_china.pop.LiveBattlePassAwardTipPop r0 = new com.blued.android.module.live_china.pop.LiveBattlePassAwardTipPop
            r1 = r0
            r2 = r5
            r3 = r10
            r1.<init>(r2, r3)
            r1 = r7
            java.lang.String r2 = "random"
            r0.a(r1, r2)
        Ld0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fitem.FitemBattlePassRandomAward.a(com.blued.android.module.live_china.fitem.FitemBattlePassRandomAward, com.blued.android.module.common.utils.freedom.BaseViewHolder, android.view.View):void");
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_battle_pass_random_award;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, final BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        BaseViewHolder a = vh.a(R.id.iv_icon, this.b.getIcon()).a(R.id.tv_count, (CharSequence) String.valueOf(this.b.getLabel())).a(R.id.tv_count, true);
        int i2 = R.id.tv_count;
        String label = this.b.getLabel();
        a.b(i2, true ^ (label == null || label.length() == 0)).a(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemBattlePassRandomAward$iKPsWbiq0wphZoAyKB7nf0huNgs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemBattlePassRandomAward.a(FitemBattlePassRandomAward.this, vh, view);
            }
        });
    }
}
