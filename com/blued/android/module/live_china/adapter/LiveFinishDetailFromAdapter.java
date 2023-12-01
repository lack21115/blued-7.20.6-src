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
    private Context a;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder helper, LiveFinishData liveFinishData) {
        Intrinsics.e(helper, "helper");
        if (liveFinishData == null) {
            return;
        }
        int layoutPosition = helper.getLayoutPosition();
        LiveHostFinishDetailFromItemBinding a = LiveHostFinishDetailFromItemBinding.a(helper.itemView);
        Intrinsics.c(a, "bind(helper.itemView)");
        if (layoutPosition == getData().size() - 1) {
            a.f.setVisibility(0);
            a.c.setVisibility(8);
            return;
        }
        a.f.setVisibility(8);
        a.c.setVisibility(0);
        ShapeModel shapeModel = a.c.getShapeModel();
        if (layoutPosition == getData().size() - 2) {
            shapeModel.K = DensityUtils.a(this.mContext, 8.0f);
            shapeModel.L = DensityUtils.a(this.mContext, 8.0f);
        } else {
            shapeModel.K = DensityUtils.a(this.mContext, 0.0f);
            shapeModel.L = DensityUtils.a(this.mContext, 0.0f);
        }
        a.c.setShapeModel(shapeModel);
        if (layoutPosition == getData().size() - 2) {
            View view = a.b;
            Intrinsics.c(view, "itemBinding?.divide2");
            BluedViewExKt.a(view);
        } else {
            View view2 = a.b;
            Intrinsics.c(view2, "itemBinding?.divide2");
            BluedViewExKt.b(view2);
        }
        if (layoutPosition == 0) {
            View view3 = a.a;
            Intrinsics.c(view3, "itemBinding?.divide1");
            BluedViewExKt.a(view3);
        } else {
            View view4 = a.a;
            Intrinsics.c(view4, "itemBinding?.divide1");
            BluedViewExKt.b(view4);
        }
        a.e.setText(liveFinishData.getFrom());
        a.d.setText(liveFinishData.getCount());
    }

    public final Context getContext() {
        return this.a;
    }
}
