package com.blued.android.module.live_china.adapter;

import android.widget.TextView;
import com.blued.android.module.live_china.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveMedalDescAdapter.class */
public final class LiveMedalDescAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public LiveMedalDescAdapter() {
        super(R.layout.item_live_medal_explain);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, String str) {
        if (baseViewHolder == null) {
            return;
        }
        ((TextView) baseViewHolder.getView(R.id.tv_live_desc)).setText(str);
    }
}
