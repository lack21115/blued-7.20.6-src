package com.blued.android.module.live_china.adapter;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveMedalItemData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveMedalListAdapter.class */
public final class LiveMedalListAdapter extends BaseQuickAdapter<LiveMedalItemData, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final IRequestHost f11664a;

    public LiveMedalListAdapter(IRequestHost iRequestHost) {
        super(R.layout.item_live_medal_list);
        this.f11664a = iRequestHost;
    }

    public final IRequestHost a() {
        return this.f11664a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006a, code lost:
        if (r0.length() == 0) goto L20;
     */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void convert(com.chad.library.adapter.base.BaseViewHolder r4, com.blued.android.module.live_china.model.LiveMedalItemData r5) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.adapter.LiveMedalListAdapter.convert(com.chad.library.adapter.base.BaseViewHolder, com.blued.android.module.live_china.model.LiveMedalItemData):void");
    }
}
