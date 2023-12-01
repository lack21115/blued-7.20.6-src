package com.blued.android.module.live_china.mine.backpack.adapter;

import android.content.Context;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/backpack/adapter/GiftBackpackItemParentAdapter.class */
public final class GiftBackpackItemParentAdapter extends BaseQuickAdapter<ArrayList<ArrayList<LiveGiftModel>>, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f13928a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, ArrayList<ArrayList<LiveGiftModel>> item) {
        Intrinsics.e(item, "item");
    }

    public final Context getContext() {
        return this.f13928a;
    }
}
