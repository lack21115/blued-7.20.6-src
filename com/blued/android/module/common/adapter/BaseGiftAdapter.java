package com.blued.android.module.common.adapter;

import android.content.Context;
import android.view.View;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.model.BaseGiftModel;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adapter/BaseGiftAdapter.class */
public abstract class BaseGiftAdapter<T extends BaseGiftModel> extends CommonRecycleAdapter {
    public BaseGiftAdapter(Context context, int i) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder, BaseGiftModel baseGiftModel, int i, View view) {
        if (a(commonAdapterHolder.a(), baseGiftModel, i)) {
            LiveEventBus.get("gift_item_clicked").post(baseGiftModel.index);
        }
    }

    protected abstract void a(BaseGiftModel baseGiftModel, int i, CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder);

    protected boolean a(View view, BaseGiftModel baseGiftModel, int i) {
        return true;
    }

    @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
    protected void onBindViewHolderData(Object obj, final int i, final CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder) {
        final BaseGiftModel baseGiftModel = (BaseGiftModel) obj;
        a(baseGiftModel, i, commonAdapterHolder);
        commonAdapterHolder.a().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.adapter.-$$Lambda$BaseGiftAdapter$jnb8rtHZgT8vGq4vdLVuTumINJQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseGiftAdapter.this.a(commonAdapterHolder, baseGiftModel, i, view);
            }
        });
    }
}
