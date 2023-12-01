package com.blued.android.module.live_china.adapter;

import android.content.Context;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.ItemLiveRankBehalfRecordBinding;
import com.blued.android.module.live_china.model.LiveRankBehalfRecordsModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveRankBehalfRecordAdapter.class */
public final class LiveRankBehalfRecordAdapter extends BaseQuickAdapter<LiveRankBehalfRecordsModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f11679a;
    private IRequestHost b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveRankBehalfRecordAdapter(Context context, IRequestHost fragmentActive) {
        super(R.layout.item_live_rank_behalf_record);
        Intrinsics.e(context, "context");
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.f11679a = context;
        this.b = fragmentActive;
    }

    public final IRequestHost a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder helper, LiveRankBehalfRecordsModel liveRankBehalfRecordsModel) {
        Intrinsics.e(helper, "helper");
        ItemLiveRankBehalfRecordBinding a2 = ItemLiveRankBehalfRecordBinding.a(helper.itemView);
        Intrinsics.c(a2, "bind(helper.itemView)");
        if (liveRankBehalfRecordsModel == null) {
            return;
        }
        ImageLoader.a(a(), liveRankBehalfRecordsModel.getAvatar()).b(R.drawable.live_rank_hour_default_avatar).c().a(a2.f12070a);
        a2.g.setText(String.valueOf(helper.getLayoutPosition() + 1));
        a2.f12071c.setText(liveRankBehalfRecordsModel.getBehalf_username());
        a2.b.setText(liveRankBehalfRecordsModel.getTarget_username());
        a2.d.setText(liveRankBehalfRecordsModel.getBeans());
    }

    public final Context getContext() {
        return this.f11679a;
    }
}
