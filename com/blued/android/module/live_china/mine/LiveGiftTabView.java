package com.blued.android.module.live_china.mine;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.blued.android.module.common.view.CommonGiftTabView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.mine.LiveGiftTabView;
import com.blued.android.module.live_china.model.LiveGiftPackageModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/LiveGiftTabView.class */
public class LiveGiftTabView extends CommonGiftTabView<LiveGiftPackageModel> {

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/LiveGiftTabView$LiveGiftTabAdapter.class */
    public class LiveGiftTabAdapter extends CommonGiftTabView<LiveGiftPackageModel>.GiftTabAdapter {
        public LiveGiftTabAdapter(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i, View view) {
            LiveGiftTabView.this.setToolBtnSelect(i);
            if (i < this.dataList.size()) {
                LiveEventBus.get("gift_package_selected").post(((CommonGiftPackageModel) this.dataList.get(i)).index);
            }
        }

        @Override // com.blued.android.module.common.view.CommonGiftTabView.GiftTabAdapter, com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(CommonGiftPackageModel commonGiftPackageModel, final int i, final CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder) {
            LiveGiftPackageModel liveGiftPackageModel = (LiveGiftPackageModel) commonGiftPackageModel;
            TextView textView = (TextView) commonAdapterHolder.a(R.id.live_gift_tab_item_name);
            textView.setText(commonGiftPackageModel.name);
            if (LiveGiftTabView.this.d == i) {
                textView.setEnabled(true);
                textView.setTextColor(LiveGiftTabView.this.getContext().getResources().getColor(R.color.syc_dark_C933CC));
                commonAdapterHolder.b(R.id.live_gift_tab_item_indicator, 0);
            } else {
                textView.setEnabled(false);
                textView.setTextColor(LiveGiftTabView.this.getContext().getResources().getColor(R.color.syc_dark_j));
                commonAdapterHolder.b(R.id.live_gift_tab_item_indicator, 4);
            }
            commonAdapterHolder.b(R.id.live_gift_tab_item_qa, (liveGiftPackageModel.showQuestion && LiveGiftTabView.this.d == i) ? 0 : 8).b(R.id.live_gift_tab_item_dot, liveGiftPackageModel.hasNew ? 0 : 8).a(R.id.live_gift_tab_item_qa, new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.LiveGiftTabView.LiveGiftTabAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    int[] iArr = new int[2];
                    View a2 = commonAdapterHolder.a(R.id.live_gift_tab_item_qa);
                    a2.getLocationInWindow(iArr);
                    LiveGiftTabView.this.a(commonAdapterHolder.getLayoutPosition(), iArr[0] + DisplayUtil.a(a2.getContext(), 14.0f));
                }
            }).a().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftTabView$LiveGiftTabAdapter$jPOYZm4_f2PQX5w-t0QvdF3C3MQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveGiftTabView.LiveGiftTabAdapter.this.a(i, view);
                }
            });
        }
    }

    public LiveGiftTabView(Context context) {
        super(context);
    }

    public LiveGiftTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        if (i == this.d) {
            LiveEventBusUtil.a(this.d, i2);
        }
    }

    @Override // com.blued.android.module.common.view.CommonGiftTabView
    public CommonGiftTabView<LiveGiftPackageModel>.GiftTabAdapter a() {
        return new LiveGiftTabAdapter(this.f10971a);
    }

    @Override // com.blued.android.module.common.view.CommonGiftTabView
    public void a(Context context) {
        this.f = DisplayUtil.a(getContext(), 20.0f);
        super.a(context);
    }

    @Override // com.blued.android.module.common.view.CommonGiftTabView
    public int getItemViewLayoutId() {
        return R.layout.live_gift_tab_item_layout;
    }
}
