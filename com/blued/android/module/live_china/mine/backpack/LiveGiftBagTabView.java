package com.blued.android.module.live_china.mine.backpack;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.blued.android.module.common.view.CommonGiftTabView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.mine.backpack.LiveGiftBagTabView;
import com.blued.android.module.live_china.model.LiveGiftPackageModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/backpack/LiveGiftBagTabView.class */
public final class LiveGiftBagTabView extends CommonGiftTabView<LiveGiftPackageModel> {

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/backpack/LiveGiftBagTabView$LiveGiftTabAdapter.class */
    final class LiveGiftTabAdapter extends CommonGiftTabView<LiveGiftPackageModel>.GiftTabAdapter {
        final /* synthetic */ LiveGiftBagTabView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LiveGiftTabAdapter(LiveGiftBagTabView this$0, Context context) {
            super(context);
            Intrinsics.e(this$0, "this$0");
            this.b = this$0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(CommonRecycleAdapter.CommonAdapterHolder viewHolder, CommonGiftPackageModel model, View view) {
            Intrinsics.e(viewHolder, "$viewHolder");
            Intrinsics.e(model, "$model");
            int[] iArr = new int[2];
            View a2 = viewHolder.a(R.id.live_gift_tab_item_qa);
            a2.getLocationInWindow(iArr);
            Observable<Object> observable = LiveEventBus.get(LiveEventBusUtil.s);
            observable.post(model.name + '_' + (iArr[0] + DisplayUtil.a(a2.getContext(), 14.0f)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(LiveGiftBagTabView this$0, int i, View view) {
            Intrinsics.e(this$0, "this$0");
            this$0.setToolBtnSelect(i);
            LiveEventBus.get("gift_backpack_package_selected").post(Integer.valueOf(i));
        }

        @Override // com.blued.android.module.common.view.CommonGiftTabView.GiftTabAdapter, com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(final CommonGiftPackageModel<?> model, final int i, final CommonRecycleAdapter.CommonAdapterHolder viewHolder) {
            Intrinsics.e(model, "model");
            Intrinsics.e(viewHolder, "viewHolder");
            LiveGiftPackageModel liveGiftPackageModel = (LiveGiftPackageModel) model;
            TextView textView = (TextView) viewHolder.a(R.id.live_gift_tab_item_name);
            textView.setText(model.name);
            if (this.b.d == i) {
                textView.setEnabled(true);
                textView.setTextColor(this.b.getResources().getColor(R.color.syc_dark_C933CC));
                viewHolder.b(R.id.live_gift_tab_item_indicator, 0);
            } else {
                textView.setEnabled(false);
                textView.setTextColor(this.b.getResources().getColor(R.color.syc_dark_j));
                viewHolder.b(R.id.live_gift_tab_item_indicator, 4);
            }
            View a2 = viewHolder.b(R.id.live_gift_tab_item_qa, (liveGiftPackageModel.showQuestion && this.b.d == i) ? 0 : 8).b(R.id.live_gift_tab_item_dot, liveGiftPackageModel.hasNew ? 0 : 8).a(R.id.live_gift_tab_item_qa, new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBagTabView$LiveGiftTabAdapter$2Q9F0vjA4CB0y2MIys1P29IgpMg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveGiftBagTabView.LiveGiftTabAdapter.a(CommonRecycleAdapter.CommonAdapterHolder.this, model, view);
                }
            }).a();
            final LiveGiftBagTabView liveGiftBagTabView = this.b;
            a2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBagTabView$LiveGiftTabAdapter$PJ_FXUlg7HCJ2cxJ9AEh576OuS0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveGiftBagTabView.LiveGiftTabAdapter.a(LiveGiftBagTabView.this, i, view);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveGiftBagTabView(Context context) {
        super(context);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveGiftBagTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.e(context, "context");
    }

    @Override // com.blued.android.module.common.view.CommonGiftTabView
    public CommonGiftTabView<LiveGiftPackageModel>.GiftTabAdapter a() {
        return new LiveGiftTabAdapter(this, this.f10971a);
    }

    @Override // com.blued.android.module.common.view.CommonGiftTabView
    public void a(Context context) {
        this.f = DisplayUtil.a(getContext(), 20.0f);
        super.a(context);
    }

    @Override // com.blued.android.module.common.view.CommonGiftTabView
    public CommonGiftTabView<LiveGiftPackageModel>.GiftTabAdapter getAdapter() {
        CommonGiftTabView<LiveGiftPackageModel>.GiftTabAdapter adapter = super.getAdapter();
        Intrinsics.c(adapter, "super.getAdapter()");
        return adapter;
    }

    @Override // com.blued.android.module.common.view.CommonGiftTabView
    public int getItemViewLayoutId() {
        return R.layout.live_gift_tab_item_layout;
    }
}
