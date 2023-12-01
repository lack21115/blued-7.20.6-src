package com.blued.android.module.live_china.mine.backpack;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.blued.android.module.common.view.CommonGiftTabView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.mine.backpack.LiveGiftBagItemTabView;
import com.blued.android.module.live_china.model.LiveGiftPackageModel;
import com.blued.android.module.live_china.view.BluedViewExKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/backpack/LiveGiftBagItemTabView.class */
public final class LiveGiftBagItemTabView extends CommonGiftTabView<LiveGiftPackageModel> {
    private OnTabViewItemClick h;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/backpack/LiveGiftBagItemTabView$LiveGiftTabAdapter.class */
    public final class LiveGiftTabAdapter extends CommonGiftTabView<LiveGiftPackageModel>.GiftTabAdapter {
        final /* synthetic */ LiveGiftBagItemTabView b;
        private final Context c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LiveGiftTabAdapter(LiveGiftBagItemTabView this$0, Context context) {
            super(context);
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(context, "context");
            this.b = this$0;
            this.c = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(LiveGiftBagItemTabView this$0, int i, LiveGiftTabAdapter this$1, View view) {
            OnTabViewItemClick onTabViewItemClick;
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(this$1, "this$1");
            this$0.setToolBtnSelect(i);
            if (i >= this$1.dataList.size() || (onTabViewItemClick = this$0.h) == null) {
                return;
            }
            onTabViewItemClick.a(i);
        }

        @Override // com.blued.android.module.common.view.CommonGiftTabView.GiftTabAdapter, com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(CommonGiftPackageModel<?> model, final int i, CommonRecycleAdapter.CommonAdapterHolder viewHolder) {
            Intrinsics.e(model, "model");
            Intrinsics.e(viewHolder, "viewHolder");
            LiveGiftPackageModel liveGiftPackageModel = (LiveGiftPackageModel) model;
            TextView textView = (TextView) viewHolder.a(R.id.live_gift_tab_item_name);
            ShapeFrameLayout rootView = (ShapeFrameLayout) viewHolder.a(R.id.sfl_gift_backpack_item_rootview);
            String str = liveGiftPackageModel.name;
            if (str == null || str.length() == 0) {
                Intrinsics.c(rootView, "rootView");
                BluedViewExKt.c(rootView);
            }
            textView.setText(liveGiftPackageModel.name);
            ShapeModel shapeModel = rootView.getShapeModel();
            if (this.b.d == i) {
                textView.setEnabled(true);
                textView.setTextColor(this.b.getResources().getColor(R.color.syc_dark_C933CC));
                shapeModel.v = this.b.getResources().getColor(R.color.syc_dark_29ff3aaa);
                shapeModel.t = this.b.getResources().getColor(R.color.syc_dark_29922cee);
                shapeModel.k = 0;
            } else {
                textView.setEnabled(false);
                textView.setTextColor(this.b.getResources().getColor(R.color.syc_989898));
                shapeModel.k = this.b.getResources().getColor(R.color.colorText_0FFFFFFF);
                shapeModel.v = 0;
                shapeModel.t = 0;
            }
            rootView.setShapeModel(shapeModel);
            viewHolder.b(R.id.live_gift_tab_item_dot, liveGiftPackageModel.hasNew ? 0 : 8);
            View a = viewHolder.a();
            final LiveGiftBagItemTabView liveGiftBagItemTabView = this.b;
            a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBagItemTabView$LiveGiftTabAdapter$Sz5icYUAfdnTvZPacT8N0ZBCSl4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveGiftBagItemTabView.LiveGiftTabAdapter.a(LiveGiftBagItemTabView.this, i, this, view);
                }
            });
        }

        public final Context getContext() {
            return this.c;
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/backpack/LiveGiftBagItemTabView$OnTabViewItemClick.class */
    public interface OnTabViewItemClick {
        void a(int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveGiftBagItemTabView(Context context) {
        super(context);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveGiftBagItemTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.e(context, "context");
    }

    @Override // com.blued.android.module.common.view.CommonGiftTabView
    public CommonGiftTabView<LiveGiftPackageModel>.GiftTabAdapter a() {
        Context mContext = this.a;
        Intrinsics.c(mContext, "mContext");
        return new LiveGiftTabAdapter(this, mContext);
    }

    @Override // com.blued.android.module.common.view.CommonGiftTabView
    public void a(Context context) {
        this.f = DisplayUtil.a(getContext(), 12.0f);
        super.a(context);
    }

    @Override // com.blued.android.module.common.view.CommonGiftTabView
    public int getItemViewLayoutId() {
        return R.layout.live_gift_backpack_tab_item_layout;
    }

    public final void setOnTabViewItemClick(OnTabViewItemClick itemClickListener) {
        Intrinsics.e(itemClickListener, "itemClickListener");
        this.h = itemClickListener;
    }
}
