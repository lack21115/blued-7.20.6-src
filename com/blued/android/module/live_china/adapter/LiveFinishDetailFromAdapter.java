package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.view.View;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.live_china.databinding.LiveHostFinishDetailFromItemBinding;
import com.blued.android.module.live_china.model.LiveFinishData;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveFinishDetailFromAdapter.class */
public final class LiveFinishDetailFromAdapter extends BaseQuickAdapter<LiveFinishData, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f11634a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder helper, LiveFinishData liveFinishData) {
        Intrinsics.e(helper, "helper");
        if (liveFinishData == null) {
            return;
        }
        int layoutPosition = helper.getLayoutPosition();
        LiveHostFinishDetailFromItemBinding a2 = LiveHostFinishDetailFromItemBinding.a(helper.itemView);
        Intrinsics.c(a2, "bind(helper.itemView)");
        if (layoutPosition == getData().size() - 1) {
            a2.f.setVisibility(0);
            a2.f12242c.setVisibility(8);
            return;
        }
        a2.f.setVisibility(8);
        a2.f12242c.setVisibility(0);
        ShapeModel shapeModel = a2.f12242c.getShapeModel();
        if (layoutPosition == getData().size() - 2) {
            shapeModel.K = DensityUtils.a(this.mContext, 8.0f);
            shapeModel.L = DensityUtils.a(this.mContext, 8.0f);
        } else {
            shapeModel.K = DensityUtils.a(this.mContext, 0.0f);
            shapeModel.L = DensityUtils.a(this.mContext, 0.0f);
        }
        a2.f12242c.setShapeModel(shapeModel);
        if (layoutPosition == getData().size() - 2) {
            View view = a2.b;
            Intrinsics.c(view, "itemBinding?.divide2");
            BluedViewExKt.a(view);
        } else {
            View view2 = a2.b;
            Intrinsics.c(view2, "itemBinding?.divide2");
            BluedViewExKt.b(view2);
        }
        if (layoutPosition == 0) {
            View view3 = a2.f12241a;
            Intrinsics.c(view3, "itemBinding?.divide1");
            BluedViewExKt.a(view3);
        } else {
            View view4 = a2.f12241a;
            Intrinsics.c(view4, "itemBinding?.divide1");
            BluedViewExKt.b(view4);
        }
        a2.e.setText(liveFinishData.getFrom());
        a2.d.setText(liveFinishData.getCount());
    }

    public final Context getContext() {
        return this.f11634a;
    }
}
