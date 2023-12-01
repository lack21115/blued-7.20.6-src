package com.blued.android.module.live_china.fitem;

import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.GiftConstellationHonourModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemGiftConstellationHonour.class */
public final class FitemGiftConstellationHonour extends FreedomItem {
    private final GiftConstellationHonourModel b;

    public FitemGiftConstellationHonour(GiftConstellationHonourModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_gift_constellation_honour;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x00c8, code lost:
        if ((r0 != null && r0.size() == 0) != false) goto L58;
     */
    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r8, com.blued.android.module.common.utils.freedom.BaseViewHolder r9, java.util.List<com.blued.android.module.common.utils.freedom.FreedomItem> r10, int r11) {
        /*
            Method dump skipped, instructions count: 711
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fitem.FitemGiftConstellationHonour.a(android.content.Context, com.blued.android.module.common.utils.freedom.BaseViewHolder, java.util.List, int):void");
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public float c() {
        return 1.0f;
    }
}
